package io.sentry.android.replay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amazon.a.a.o.b.f;
import io.sentry.DateUtils;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ReplayRecording;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.video.MuxerConfig;
import io.sentry.android.replay.video.SimpleVideoEncoder;
import io.sentry.protocol.SentryId;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.FileUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.LongProgression;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayCache implements Closeable {
    private SimpleVideoEncoder encoder;
    private final AutoClosableReentrantLock encoderLock;
    private final List frames;
    private final AutoClosableReentrantLock framesLock;
    private final AtomicBoolean isClosed;
    private final AutoClosableReentrantLock lock;
    private final LinkedHashMap ongoingSegment;
    private final Lazy ongoingSegmentFile$delegate;
    private final SentryOptions options;
    private final Lazy replayCacheDir$delegate;
    private final SentryId replayId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ReplayCache(SentryOptions options, SentryId replayId) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        this.options = options;
        this.replayId = replayId;
        this.isClosed = new AtomicBoolean(false);
        this.encoderLock = new AutoClosableReentrantLock();
        this.lock = new AutoClosableReentrantLock();
        this.framesLock = new AutoClosableReentrantLock();
        this.replayCacheDir$delegate = LazyKt.lazy(new Function0() { // from class: io.sentry.android.replay.ReplayCache$replayCacheDir$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return ReplayCache.Companion.makeReplayCacheDir(this.this$0.options, this.this$0.replayId);
            }
        });
        this.frames = new ArrayList();
        this.ongoingSegment = new LinkedHashMap();
        this.ongoingSegmentFile$delegate = LazyKt.lazy(new Function0() { // from class: io.sentry.android.replay.ReplayCache$ongoingSegmentFile$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() throws IOException {
                if (this.this$0.getReplayCacheDir$sentry_android_replay_release() == null) {
                    return null;
                }
                File file = new File(this.this$0.getReplayCacheDir$sentry_android_replay_release(), ".ongoing_segment");
                if (!file.exists()) {
                    file.createNewFile();
                }
                return file;
            }
        });
    }

    public final File getReplayCacheDir$sentry_android_replay_release() {
        return (File) this.replayCacheDir$delegate.getValue();
    }

    public final List getFrames$sentry_android_replay_release() {
        return this.frames;
    }

    public final File getOngoingSegmentFile$sentry_android_replay_release() {
        return (File) this.ongoingSegmentFile$delegate.getValue();
    }

    public final void addFrame$sentry_android_replay_release(Bitmap bitmap, long j, String str) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (getReplayCacheDir$sentry_android_replay_release() == null || bitmap.isRecycled()) {
            return;
        }
        File replayCacheDir$sentry_android_replay_release = getReplayCacheDir$sentry_android_replay_release();
        if (replayCacheDir$sentry_android_replay_release != null) {
            replayCacheDir$sentry_android_replay_release.mkdirs();
        }
        File file = new File(getReplayCacheDir$sentry_android_replay_release(), j + ".jpg");
        file.createNewFile();
        synchronized (bitmap) {
            if (bitmap.isRecycled()) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, this.options.getSessionReplay().getQuality().screenshotQuality, fileOutputStream);
                fileOutputStream.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                addFrame(file, j, str);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        }
    }

    public static /* synthetic */ void addFrame$default(ReplayCache replayCache, File file, long j, String str, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            str = null;
        }
        replayCache.addFrame(file, j, str);
    }

    public final void addFrame(File screenshot, long j, String str) throws Exception {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        ReplayFrame replayFrame = new ReplayFrame(screenshot, j, str);
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.framesLock.acquire();
        try {
            this.frames.add(replayFrame);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    public final Long firstFrameTimestamp$sentry_android_replay_release() throws Exception {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.framesLock.acquire();
        try {
            ReplayFrame replayFrame = (ReplayFrame) CollectionsKt.firstOrNull(this.frames);
            Long lValueOf = replayFrame != null ? Long.valueOf(replayFrame.getTimestamp()) : null;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            return lValueOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ GeneratedVideo createVideoOf$default(ReplayCache replayCache, long j, long j2, int i, int i2, int i3, int i4, int i5, File file, int i6, Object obj) {
        int i7;
        File file2;
        if ((i6 & 128) != 0) {
            File replayCacheDir$sentry_android_replay_release = replayCache.getReplayCacheDir$sentry_android_replay_release();
            StringBuilder sb = new StringBuilder();
            i7 = i;
            sb.append(i7);
            sb.append(".mp4");
            file2 = new File(replayCacheDir$sentry_android_replay_release, sb.toString());
        } else {
            i7 = i;
            file2 = file;
        }
        return replayCache.createVideoOf(j, j2, i7, i2, i3, i4, i5, file2);
    }

    public final GeneratedVideo createVideoOf(long j, long j2, int i, int i2, int i3, int i4, int i5, File videoFile) throws Exception {
        ISentryLifecycleToken iSentryLifecycleToken;
        int i6;
        Intrinsics.checkNotNullParameter(videoFile, "videoFile");
        if (videoFile.exists() && videoFile.length() > 0) {
            videoFile.delete();
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.framesLock.acquire();
        try {
            List<ReplayFrame> arrayList = this.frames.isEmpty() ? new ArrayList() : CollectionsKt.toMutableList((Collection) this.frames);
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            if (arrayList.isEmpty()) {
                this.options.getLogger().log(SentryLevel.DEBUG, "No captured frames, skipping generating a video segment", new Object[0]);
                return null;
            }
            ISentryLifecycleToken iSentryLifecycleTokenAcquire2 = this.encoderLock.acquire();
            try {
                iSentryLifecycleToken = iSentryLifecycleTokenAcquire2;
                try {
                    SimpleVideoEncoder simpleVideoEncoder = new SimpleVideoEncoder(this.options, new MuxerConfig(videoFile, i3, i2, i4, i5, null, 32, null), null, 4, null);
                    simpleVideoEncoder.start();
                    AutoCloseableKt.closeFinally(iSentryLifecycleToken, null);
                    this.encoder = simpleVideoEncoder;
                    long j3 = ((long) 1000) / ((long) i4);
                    Object objFirstOrNull = CollectionsKt.firstOrNull(arrayList);
                    long j4 = j2 + j;
                    LongProgression longProgressionStep = RangesKt.step(RangesKt.until(j2, j4), j3);
                    long first = longProgressionStep.getFirst();
                    long last = longProgressionStep.getLast();
                    long step = longProgressionStep.getStep();
                    if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                        i6 = 0;
                    } else {
                        long j5 = first;
                        int i7 = 0;
                        while (true) {
                            for (ReplayFrame replayFrame : arrayList) {
                                long j6 = j5 + j3;
                                long timestamp = replayFrame.getTimestamp();
                                if (j5 <= timestamp && timestamp <= j6) {
                                    objFirstOrNull = replayFrame;
                                    break;
                                }
                                if (replayFrame.getTimestamp() > j6) {
                                    break;
                                }
                            }
                            if (encode((ReplayFrame) objFirstOrNull)) {
                                i7++;
                            } else if (objFirstOrNull != null) {
                                deleteFile(((ReplayFrame) objFirstOrNull).getScreenshot());
                                ISentryLifecycleToken iSentryLifecycleTokenAcquire3 = this.framesLock.acquire();
                                try {
                                    TypeIntrinsics.asMutableCollection(this.frames).remove(objFirstOrNull);
                                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire3, null);
                                    arrayList.remove(objFirstOrNull);
                                    objFirstOrNull = null;
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire3, th);
                                        throw th2;
                                    }
                                }
                            }
                            if (j5 == last) {
                                break;
                            }
                            j5 += step;
                        }
                        i6 = i7;
                    }
                    if (i6 == 0) {
                        this.options.getLogger().log(SentryLevel.DEBUG, "Generated a video with no frames, not capturing a replay segment", new Object[0]);
                        deleteFile(videoFile);
                        return null;
                    }
                    ISentryLifecycleToken iSentryLifecycleTokenAcquire4 = this.encoderLock.acquire();
                    try {
                        SimpleVideoEncoder simpleVideoEncoder2 = this.encoder;
                        if (simpleVideoEncoder2 != null) {
                            simpleVideoEncoder2.release();
                        }
                        SimpleVideoEncoder simpleVideoEncoder3 = this.encoder;
                        long duration = simpleVideoEncoder3 != null ? simpleVideoEncoder3.getDuration() : 0L;
                        this.encoder = null;
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire4, null);
                        rotate$sentry_android_replay_release(j4);
                        return new GeneratedVideo(videoFile, i6, duration);
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire4, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        AutoCloseableKt.closeFinally(iSentryLifecycleToken, th6);
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                iSentryLifecycleToken = iSentryLifecycleTokenAcquire2;
            }
        } catch (Throwable th9) {
            try {
                throw th9;
            } catch (Throwable th10) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th9);
                throw th10;
            }
        }
    }

    private final boolean encode(ReplayFrame replayFrame) {
        if (replayFrame == null) {
            return false;
        }
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(replayFrame.getScreenshot().getAbsolutePath());
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.encoderLock.acquire();
            try {
                SimpleVideoEncoder simpleVideoEncoder = this.encoder;
                if (simpleVideoEncoder != null) {
                    Intrinsics.checkNotNull(bitmapDecodeFile);
                    simpleVideoEncoder.encode(bitmapDecodeFile);
                    Unit unit = Unit.INSTANCE;
                }
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                bitmapDecodeFile.recycle();
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.options.getLogger().log(SentryLevel.WARNING, "Unable to decode bitmap and encode it into a video, skipping frame", th3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFile(File file) {
        try {
            if (file.delete()) {
                return;
            }
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete replay frame: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Failed to delete replay frame: %s", file.getAbsolutePath());
        }
    }

    public final String rotate$sentry_android_replay_release(final long j) throws Exception {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.framesLock.acquire();
        try {
            CollectionsKt.removeAll(this.frames, new Function1() { // from class: io.sentry.android.replay.ReplayCache$rotate$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ReplayFrame it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.getTimestamp() < j) {
                        this.deleteFile(it.getScreenshot());
                        return Boolean.TRUE;
                    }
                    Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                    if (ref$ObjectRef2.element == null) {
                        ref$ObjectRef2.element = it.getScreen();
                    }
                    return Boolean.FALSE;
                }
            });
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            return (String) ref$ObjectRef.element;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.encoderLock.acquire();
        try {
            SimpleVideoEncoder simpleVideoEncoder = this.encoder;
            if (simpleVideoEncoder != null) {
                simpleVideoEncoder.release();
            }
            this.encoder = null;
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            this.isClosed.set(true);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    public final void persistSegmentValues$sentry_android_replay_release(String key, String str) throws Exception {
        File ongoingSegmentFile$sentry_android_replay_release;
        File ongoingSegmentFile$sentry_android_replay_release2;
        Intrinsics.checkNotNullParameter(key, "key");
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (this.isClosed.get()) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                return;
            }
            File ongoingSegmentFile$sentry_android_replay_release3 = getOngoingSegmentFile$sentry_android_replay_release();
            if ((ongoingSegmentFile$sentry_android_replay_release3 == null || !ongoingSegmentFile$sentry_android_replay_release3.exists()) && (ongoingSegmentFile$sentry_android_replay_release = getOngoingSegmentFile$sentry_android_replay_release()) != null) {
                ongoingSegmentFile$sentry_android_replay_release.createNewFile();
            }
            if (this.ongoingSegment.isEmpty() && (ongoingSegmentFile$sentry_android_replay_release2 = getOngoingSegmentFile$sentry_android_replay_release()) != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ongoingSegmentFile$sentry_android_replay_release2), Charsets.UTF_8), 8192);
                try {
                    Sequence sequenceLineSequence = TextStreamsKt.lineSequence(bufferedReader);
                    LinkedHashMap linkedHashMap = this.ongoingSegment;
                    Iterator it = sequenceLineSequence.iterator();
                    while (it.hasNext()) {
                        List listSplit$default = StringsKt.split$default((CharSequence) it.next(), new String[]{f.b}, false, 2, 2, (Object) null);
                        Pair pair = TuplesKt.to((String) listSplit$default.get(0), (String) listSplit$default.get(1));
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    }
                    CloseableKt.closeFinally(bufferedReader, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            }
            if (str == null) {
                this.ongoingSegment.remove(key);
            } else {
                this.ongoingSegment.put(key, str);
            }
            File ongoingSegmentFile$sentry_android_replay_release4 = getOngoingSegmentFile$sentry_android_replay_release();
            if (ongoingSegmentFile$sentry_android_replay_release4 != null) {
                Set setEntrySet = this.ongoingSegment.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
                FilesKt.writeText$default(ongoingSegmentFile$sentry_android_replay_release4, CollectionsKt.joinToString$default(setEntrySet, "\n", null, null, 0, null, new Function1() { // from class: io.sentry.android.replay.ReplayCache$persistSegmentValues$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Map.Entry entry) {
                        Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
                    }
                }, 30, null), null, 2, null);
                Unit unit = Unit.INSTANCE;
            }
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th3);
                throw th4;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File makeReplayCacheDir(SentryOptions options, SentryId replayId) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            String cacheDirPath = options.getCacheDirPath();
            if (cacheDirPath == null || cacheDirPath.length() == 0) {
                options.getLogger().log(SentryLevel.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                return null;
            }
            String cacheDirPath2 = options.getCacheDirPath();
            Intrinsics.checkNotNull(cacheDirPath2);
            File file = new File(cacheDirPath2, "replay_" + replayId);
            file.mkdirs();
            return file;
        }

        /* JADX WARN: Code duplicated, block: B:90:0x0206  */
        public final LastSegmentData fromDisk$sentry_android_replay_release(SentryOptions options, SentryId replayId, Function1 function1) throws IOException {
            Date dateTime;
            SentryReplayEvent.ReplayType replayTypeValueOf;
            LastSegmentData lastSegmentData;
            final ReplayCache replayCache;
            List listEmptyList;
            String str = "";
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            File fileMakeReplayCacheDir = makeReplayCacheDir(options, replayId);
            File file = new File(fileMakeReplayCacheDir, ".ongoing_segment");
            if (!file.exists()) {
                options.getLogger().log(SentryLevel.DEBUG, "No ongoing segment found for replay: %s", replayId);
                FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8), 8192);
            try {
                Iterator it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List listSplit$default = StringsKt.split$default((CharSequence) it.next(), new String[]{f.b}, false, 2, 2, (Object) null);
                    Pair pair = TuplesKt.to((String) listSplit$default.get(0), (String) listSplit$default.get(1));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                CloseableKt.closeFinally(bufferedReader, null);
                String str2 = (String) linkedHashMap.get("config.height");
                Integer intOrNull = str2 != null ? StringsKt.toIntOrNull(str2) : null;
                String str3 = (String) linkedHashMap.get("config.width");
                Integer intOrNull2 = str3 != null ? StringsKt.toIntOrNull(str3) : null;
                String str4 = (String) linkedHashMap.get("config.frame-rate");
                Integer intOrNull3 = str4 != null ? StringsKt.toIntOrNull(str4) : null;
                String str5 = (String) linkedHashMap.get("config.bit-rate");
                Integer intOrNull4 = str5 != null ? StringsKt.toIntOrNull(str5) : null;
                String str6 = (String) linkedHashMap.get("segment.id");
                Integer intOrNull5 = str6 != null ? StringsKt.toIntOrNull(str6) : null;
                try {
                    String str7 = (String) linkedHashMap.get("segment.timestamp");
                    if (str7 == null) {
                        str7 = "";
                    }
                    dateTime = DateUtils.getDateTime(str7);
                } catch (Throwable unused) {
                    dateTime = null;
                }
                try {
                    String str8 = (String) linkedHashMap.get("replay.type");
                    if (str8 != null) {
                        str = str8;
                    }
                    replayTypeValueOf = SentryReplayEvent.ReplayType.valueOf(str);
                } catch (Throwable unused2) {
                    replayTypeValueOf = null;
                }
                if (intOrNull == null || intOrNull2 == null || intOrNull3 == null || intOrNull4 == null || intOrNull5 == null) {
                    lastSegmentData = null;
                } else {
                    lastSegmentData = null;
                    if (intOrNull5.intValue() != -1 && dateTime != null && replayTypeValueOf != null) {
                        ScreenshotRecorderConfig screenshotRecorderConfig = new ScreenshotRecorderConfig(intOrNull2.intValue(), intOrNull.intValue(), 1.0f, 1.0f, intOrNull3.intValue(), intOrNull4.intValue());
                        if (function1 == null || (replayCache = (ReplayCache) function1.invoke(replayId)) == null) {
                            replayCache = new ReplayCache(options, replayId);
                        }
                        File replayCacheDir$sentry_android_replay_release = replayCache.getReplayCacheDir$sentry_android_replay_release();
                        if (replayCacheDir$sentry_android_replay_release != null) {
                            replayCacheDir$sentry_android_replay_release.listFiles(new FilenameFilter() { // from class: io.sentry.android.replay.ReplayCache$Companion$$ExternalSyntheticLambda0
                                @Override // java.io.FilenameFilter
                                public final boolean accept(File file2, String str9) {
                                    return ReplayCache.Companion.fromDisk$lambda$3(replayCache, file2, str9);
                                }
                            });
                        }
                        if (replayCache.getFrames$sentry_android_replay_release().isEmpty()) {
                            options.getLogger().log(SentryLevel.DEBUG, "No frames found for replay: %s, deleting the replay", replayId);
                            FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                            return null;
                        }
                        List frames$sentry_android_replay_release = replayCache.getFrames$sentry_android_replay_release();
                        if (frames$sentry_android_replay_release.size() > 1) {
                            CollectionsKt.sortWith(frames$sentry_android_replay_release, new Comparator() { // from class: io.sentry.android.replay.ReplayCache$Companion$fromDisk$$inlined$sortBy$1
                                @Override // java.util.Comparator
                                public final int compare(Object obj, Object obj2) {
                                    return ComparisonsKt.compareValues(Long.valueOf(((ReplayFrame) obj).getTimestamp()), Long.valueOf(((ReplayFrame) obj2).getTimestamp()));
                                }
                            });
                        }
                        SentryReplayEvent.ReplayType replayType = SentryReplayEvent.ReplayType.SESSION;
                        int iIntValue = replayTypeValueOf == replayType ? intOrNull5.intValue() : 0;
                        if (replayTypeValueOf != replayType) {
                            dateTime = DateUtils.getDateTime(((ReplayFrame) CollectionsKt.first(replayCache.getFrames$sentry_android_replay_release())).getTimestamp());
                            Intrinsics.checkNotNull(dateTime);
                        }
                        Date date = dateTime;
                        long timestamp = (((ReplayFrame) CollectionsKt.last(replayCache.getFrames$sentry_android_replay_release())).getTimestamp() - date.getTime()) + ((long) (1000 / intOrNull3.intValue()));
                        String str9 = (String) linkedHashMap.get("replay.recording");
                        if (str9 != null) {
                            ReplayRecording replayRecording = (ReplayRecording) options.getSerializer().deserialize(new StringReader(str9), ReplayRecording.class);
                            if ((replayRecording != null ? replayRecording.getPayload() : null) != null) {
                                List payload = replayRecording.getPayload();
                                Intrinsics.checkNotNull(payload);
                                listEmptyList = new LinkedList(payload);
                            } else {
                                listEmptyList = null;
                            }
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return new LastSegmentData(screenshotRecorderConfig, replayCache, date, iIntValue, timestamp, replayTypeValueOf, (String) linkedHashMap.get("replay.screen-at-start"), CollectionsKt.sortedWith(listEmptyList, new Comparator() { // from class: io.sentry.android.replay.ReplayCache$Companion$fromDisk$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return ComparisonsKt.compareValues(Long.valueOf(((RRWebEvent) obj).getTimestamp()), Long.valueOf(((RRWebEvent) obj2).getTimestamp()));
                            }
                        }));
                    }
                }
                options.getLogger().log(SentryLevel.DEBUG, "Incorrect segment values found for replay: %s, deleting the replay", replayId);
                FileUtils.deleteRecursively(fileMakeReplayCacheDir);
                return lastSegmentData;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean fromDisk$lambda$3(ReplayCache replayCache, File file, String str) throws Exception {
            Intrinsics.checkNotNull(str);
            if (StringsKt.endsWith$default(str, ".jpg", false, 2, (Object) null)) {
                File file2 = new File(file, str);
                Long longOrNull = StringsKt.toLongOrNull(FilesKt.getNameWithoutExtension(file2));
                if (longOrNull != null) {
                    ReplayCache.addFrame$default(replayCache, file2, longOrNull.longValue(), null, 4, null);
                }
            }
            return false;
        }
    }
}
