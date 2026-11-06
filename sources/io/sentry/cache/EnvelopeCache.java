package io.sentry.cache;

import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ISerializer;
import io.sentry.SentryCrashLastRunState;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryUUID;
import io.sentry.Session;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.NativeCrashExit;
import io.sentry.hints.SessionEnd;
import io.sentry.hints.SessionStart;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {
    protected final AutoClosableReentrantLock cacheLock;
    private final Map fileNameMap;
    private final CountDownLatch previousSessionLatch;
    protected final AutoClosableReentrantLock sessionLock;

    public static IEnvelopeCache create(SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath == null) {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
            return NoOpEnvelopeCache.getInstance();
        }
        return new EnvelopeCache(sentryOptions, cacheDirPath, maxCacheItems);
    }

    public EnvelopeCache(SentryOptions sentryOptions, String str, int i) {
        super(sentryOptions, str, i);
        this.fileNameMap = new WeakHashMap();
        this.cacheLock = new AutoClosableReentrantLock();
        this.sessionLock = new AutoClosableReentrantLock();
        this.previousSessionLatch = new CountDownLatch(1);
    }

    public boolean storeEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        return storeInternal(sentryEnvelope, hint);
    }

    private boolean storeInternal(SentryEnvelope sentryEnvelope, Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        rotateCacheIfNeeded(allEnvelopeFiles());
        File currentSessionFile = getCurrentSessionFile(this.directory.getAbsolutePath());
        File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
        if (HintUtils.hasType(hint, SessionEnd.class) && !currentSessionFile.delete()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (HintUtils.hasType(hint, AbnormalExit.class) || HintUtils.hasType(hint, NativeCrashExit.class)) {
            tryEndPreviousSession(hint);
        }
        if (HintUtils.hasType(hint, SessionStart.class)) {
            movePreviousSession(currentSessionFile, previousSessionFile);
            updateCurrentSession(currentSessionFile, sentryEnvelope);
            boolean zExists = new File(this.options.getCacheDirPath(), ".sentry-native/last_crash").exists();
            if (!zExists) {
                File file = new File(this.options.getCacheDirPath(), "last_crash");
                if (file.exists()) {
                    this.options.getLogger().log(SentryLevel.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    zExists = true;
                }
            }
            SentryCrashLastRunState.getInstance().setCrashedLastRun(zExists);
            flushPreviousSession();
        }
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Not adding Envelope to offline storage because it already exists: %s", envelopeFile.getAbsolutePath());
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Adding Envelope to offline storage: %s", envelopeFile.getAbsolutePath());
        boolean zWriteEnvelopeToDisk = writeEnvelopeToDisk(envelopeFile, sentryEnvelope);
        if (HintUtils.hasType(hint, UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class)) {
            writeCrashMarkerFile();
        }
        return zWriteEnvelopeToDisk;
    }

    private void tryEndPreviousSession(Hint hint) {
        Date dateTime;
        Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
        File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
        if (previousSessionFile.exists()) {
            ILogger logger = this.options.getLogger();
            SentryLevel sentryLevel = SentryLevel.WARNING;
            logger.log(sentryLevel, "Previous session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(previousSessionFile), CacheStrategy.UTF_8));
                try {
                    Session session = (Session) ((ISerializer) this.serializer.getValue()).deserialize(bufferedReader, Session.class);
                    if (session != null) {
                        Date date = null;
                        if (sentrySdkHint instanceof AbnormalExit) {
                            AbnormalExit abnormalExit = (AbnormalExit) sentrySdkHint;
                            Long lTimestamp = abnormalExit.timestamp();
                            if (lTimestamp != null) {
                                dateTime = DateUtils.getDateTime(lTimestamp.longValue());
                                Date started = session.getStarted();
                                if (started == null || dateTime.before(started)) {
                                    this.options.getLogger().log(sentryLevel, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                }
                            } else {
                                dateTime = null;
                            }
                            session.update(Session.State.Abnormal, null, true, abnormalExit.mechanism());
                            date = dateTime;
                            session.end(date);
                            writeSessionToDisk(previousSessionFile, session);
                        } else if (sentrySdkHint instanceof NativeCrashExit) {
                            Date dateTime2 = DateUtils.getDateTime(((NativeCrashExit) sentrySdkHint).timestamp().longValue());
                            Date started2 = session.getStarted();
                            if (started2 == null || dateTime2.before(started2)) {
                                this.options.getLogger().log(sentryLevel, "Native crash exit happened before previous session start, not ending the session.", new Object[0]);
                            } else {
                                session.update(Session.State.Crashed, null, true, null);
                                date = dateTime2;
                                session.end(date);
                                writeSessionToDisk(previousSessionFile, session);
                            }
                        } else {
                            session.end(date);
                            writeSessionToDisk(previousSessionFile, session);
                        }
                    }
                    bufferedReader.close();
                    return;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error processing previous session.", th3);
                return;
            }
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "No previous session file to end.", new Object[0]);
    }

    private void writeCrashMarkerFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.options.getCacheDirPath(), "last_crash"));
            try {
                fileOutputStream.write(DateUtils.getTimestamp(DateUtils.getCurrentDateTime()).getBytes(CacheStrategy.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error writing the crash marker file to the disk", th3);
        }
    }

    private void updateCurrentSession(File file, SentryEnvelope sentryEnvelope) {
        Iterable items = sentryEnvelope.getItems();
        if (items.iterator().hasNext()) {
            SentryEnvelopeItem sentryEnvelopeItem = (SentryEnvelopeItem) items.iterator().next();
            if (SentryItemType.Session.equals(sentryEnvelopeItem.getHeader().getType())) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), CacheStrategy.UTF_8));
                    try {
                        Session session = (Session) ((ISerializer) this.serializer.getValue()).deserialize(bufferedReader, Session.class);
                        if (session == null) {
                            this.options.getLogger().log(SentryLevel.ERROR, "Item of type %s returned null by the parser.", sentryEnvelopeItem.getHeader().getType());
                        } else {
                            writeSessionToDisk(file, session);
                        }
                        bufferedReader.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Item failed to process.", th3);
                    return;
                }
            }
            this.options.getLogger().log(SentryLevel.INFO, "Current envelope has a different envelope type %s", sentryEnvelopeItem.getHeader().getType());
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
    }

    private boolean writeEnvelopeToDisk(File file, SentryEnvelope sentryEnvelope) {
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((ISerializer) this.serializer.getValue()).serialize(sentryEnvelope, fileOutputStream);
                fileOutputStream.close();
                return true;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.ERROR, th3, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
            return false;
        }
    }

    private void writeSessionToDisk(File file, Session session) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, CacheStrategy.UTF_8));
                try {
                    this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", session.getSessionId());
                    ((ISerializer) this.serializer.getValue()).serialize(session, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            this.options.getLogger().log(SentryLevel.ERROR, th5, "Error writing Session to offline storage: %s", session.getSessionId());
        }
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public void discard(SentryEnvelope sentryEnvelope) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.delete()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Discarding envelope from cache: %s", envelopeFile.getAbsolutePath());
        } else {
            this.options.getLogger().log(SentryLevel.DEBUG, "Envelope was not cached or could not be deleted: %s", envelopeFile.getAbsolutePath());
        }
    }

    private File getEnvelopeFile(SentryEnvelope sentryEnvelope) {
        String str;
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.cacheLock.acquire();
        try {
            if (this.fileNameMap.containsKey(sentryEnvelope)) {
                str = (String) this.fileNameMap.get(sentryEnvelope);
            } else {
                String str2 = SentryUUID.generateSentryId() + ".envelope";
                this.fileNameMap.put(sentryEnvelope, str2);
                str = str2;
            }
            File file = new File(this.directory.getAbsolutePath(), str);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return file;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static File getCurrentSessionFile(String str) {
        return new File(str, "session.json");
    }

    public static File getPreviousSessionFile(String str) {
        return new File(str, "previous_session.json");
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        File[] fileArrAllEnvelopeFiles = allEnvelopeFiles();
        ArrayList arrayList = new ArrayList(fileArrAllEnvelopeFiles.length);
        for (File file : fileArrAllEnvelopeFiles) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(((ISerializer) this.serializer.getValue()).deserializeEnvelope(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e);
            }
        }
        return arrayList.iterator();
    }

    private File[] allEnvelopeFiles() {
        File[] fileArrListFiles;
        return (!isDirectoryValid() || (fileArrListFiles = this.directory.listFiles(new FilenameFilter() { // from class: io.sentry.cache.EnvelopeCache$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return str.endsWith(".envelope");
            }
        })) == null) ? new File[0] : fileArrListFiles;
    }

    public boolean waitPreviousSessionFlush() {
        try {
            return this.previousSessionLatch.await(this.options.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.options.getLogger().log(SentryLevel.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public void flushPreviousSession() {
        this.previousSessionLatch.countDown();
    }

    public void movePreviousSession(File file, File file2) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.sessionLock.acquire();
        try {
            if (!file.exists()) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            if (file2.exists()) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Previous session file already exists, deleting it.", new Object[0]);
                if (!file2.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Unable to delete previous session file: %s", file2);
                }
            }
            this.options.getLogger().log(SentryLevel.INFO, "Moving current session to previous session.", new Object[0]);
            try {
                if (!file.renameTo(file2)) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Unable to move current session to previous session.", new Object[0]);
                }
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error moving current session to previous session.", th);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
