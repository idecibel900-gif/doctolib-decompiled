package io.sentry;

import com.adjust.sdk.Constants;
import io.sentry.clientreport.ClientReport;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryEnvelopeItem {
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    private byte[] data;
    private final Callable dataFactory;
    private final SentryEnvelopeItemHeader header;

    SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, byte[] bArr) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.data = bArr;
        this.dataFactory = null;
    }

    SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, Callable callable) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.dataFactory = (Callable) Objects.requireNonNull(callable, "DataFactory is required.");
        this.data = null;
    }

    public byte[] getData() {
        Callable callable;
        if (this.data == null && (callable = this.dataFactory) != null) {
            this.data = (byte[]) callable.call();
        }
        return this.data;
    }

    public SentryEnvelopeItemHeader getHeader() {
        return this.header;
    }

    public static SentryEnvelopeItem fromSession(final ISerializer iSerializer, final Session session) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(session, "Session is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$ogPUuoWhojqGmD8x8K5h4hr2xOQ(iSerializer, session);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Session, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$ogPUuoWhojqGmD8x8K5h4hr2xOQ(ISerializer iSerializer, Session session) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            try {
                iSerializer.serialize(session, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
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
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public SentryEvent getEvent(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.Event) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryEvent sentryEvent = (SentryEvent) iSerializer.deserialize(bufferedReader, SentryEvent.class);
            bufferedReader.close();
            return sentryEvent;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static SentryEnvelopeItem fromEvent(final ISerializer iSerializer, final SentryBaseEvent sentryBaseEvent) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(sentryBaseEvent, "SentryEvent is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$ZlXbeckV1LCh3MoyhDwrxqNtlow(iSerializer, sentryBaseEvent);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(sentryBaseEvent), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda19
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda20
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$ZlXbeckV1LCh3MoyhDwrxqNtlow(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            try {
                iSerializer.serialize(sentryBaseEvent, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
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
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public SentryTransaction getTransaction(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryTransaction sentryTransaction = (SentryTransaction) iSerializer.deserialize(bufferedReader, SentryTransaction.class);
            bufferedReader.close();
            return sentryTransaction;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public SentryLogEvents getLogs(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.Log) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryLogEvents sentryLogEvents = (SentryLogEvents) iSerializer.deserialize(bufferedReader, SentryLogEvents.class);
            bufferedReader.close();
            return sentryLogEvents;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public SentryMetricsEvents getMetrics(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.TraceMetric) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryMetricsEvents sentryMetricsEvents = (SentryMetricsEvents) iSerializer.deserialize(bufferedReader, SentryMetricsEvents.class);
            bufferedReader.close();
            return sentryMetricsEvents;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static SentryEnvelopeItem fromAttachment(final ISerializer iSerializer, final ILogger iLogger, final Attachment attachment, final long j) {
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.m5163$r8$lambda$vp0UtyfyLMhxl5h_vgNizIVnE8(attachment, j, iSerializer, iLogger);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Attachment, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, attachment.getContentType(), attachment.getFilename(), attachment.getAttachmentType()), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$vp0UtyfyLMhxl5h_vgNiz-IVnE8, reason: not valid java name */
    public static /* synthetic */ byte[] m5163$r8$lambda$vp0UtyfyLMhxl5h_vgNizIVnE8(Attachment attachment, long j, ISerializer iSerializer, ILogger iLogger) throws SentryEnvelopeException {
        byte[] bArr;
        if (attachment.getBytes() != null) {
            byte[] bytes = attachment.getBytes();
            ensureAttachmentSizeLimit(bytes.length, j, attachment.getFilename());
            return bytes;
        }
        if (attachment.getSerializable() != null) {
            byte[] bArrBytesFrom = JsonSerializationUtils.bytesFrom(iSerializer, iLogger, attachment.getSerializable());
            if (bArrBytesFrom != null) {
                ensureAttachmentSizeLimit(bArrBytesFrom.length, j, attachment.getFilename());
                return bArrBytesFrom;
            }
        } else {
            if (attachment.getPathname() != null) {
                return FileUtils.readBytesFromFile(attachment.getPathname(), j);
            }
            if (attachment.getByteProvider() != null && (bArr = (byte[]) attachment.getByteProvider().call()) != null) {
                ensureAttachmentSizeLimit(bArr.length, j, attachment.getFilename());
                return bArr;
            }
        }
        throw new SentryEnvelopeException(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable, path or provider is set.", attachment.getFilename()));
    }

    private static void ensureAttachmentSizeLimit(long j, long j2, String str) throws SentryEnvelopeException {
        if (j > j2) {
            throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static SentryEnvelopeItem fromProfileChunk(final ProfileChunk profileChunk, final ISerializer iSerializer, final IProfileConverter iProfileConverter) {
        final File traceFile = profileChunk.getTraceFile();
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$ohSK319k6qSk5JKFnW9i_yB8yhE(traceFile, profileChunk, iProfileConverter, iSerializer);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.ProfileChunk, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application-json", traceFile != null ? traceFile.getName() : null, (String) null, profileChunk.getPlatform(), (Integer) null), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$ohSK319k6qSk5JKFnW9i_yB8yhE(File file, ProfileChunk profileChunk, IProfileConverter iProfileConverter, ISerializer iSerializer) throws SentryEnvelopeException {
        if (file != null) {
            if (!file.exists()) {
                throw new SentryEnvelopeException(String.format("Dropping profile chunk, because the file '%s' doesn't exists", file.getName()));
            }
            if ("java".equals(profileChunk.getPlatform())) {
                if (!NoOpProfileConverter.getInstance().equals(iProfileConverter)) {
                    try {
                        profileChunk.setSentryProfile(iProfileConverter.convertFromFile(file.getAbsolutePath()));
                    } catch (Exception e) {
                        throw new SentryEnvelopeException("Profile conversion failed", e);
                    }
                } else {
                    throw new SentryEnvelopeException("No ProfileConverter available, dropping chunk.");
                }
            } else {
                String strEncodeToString = Base64.encodeToString(FileUtils.readBytesFromFile(file.getPath(), 52428800L), 3);
                if (strEncodeToString.isEmpty()) {
                    throw new SentryEnvelopeException("Profiling trace file is empty");
                }
                profileChunk.setSampledProfile(strEncodeToString);
            }
        }
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
                    try {
                        iSerializer.serialize(profileChunk, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        if (file != null) {
                            file.delete();
                        }
                        return byteArray;
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
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e2) {
                throw new SentryEnvelopeException(String.format("Failed to serialize profile chunk\n%s", e2.getMessage()));
            }
        } catch (Throwable th5) {
            if (file != null) {
                file.delete();
            }
            throw th5;
        }
    }

    public static SentryEnvelopeItem fromProfilingTrace(final ProfilingTraceData profilingTraceData, final long j, final ISerializer iSerializer) {
        final File traceFile = profilingTraceData.getTraceFile();
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.m5160$r8$lambda$aBwJNiy04SzqX1yfvXdafaVjtA(traceFile, j, profilingTraceData, iSerializer);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Profile, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application-json", traceFile.getName()), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda17
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$aBwJNiy04Sz-qX1yfvXdafaVjtA, reason: not valid java name */
    public static /* synthetic */ byte[] m5160$r8$lambda$aBwJNiy04SzqX1yfvXdafaVjtA(File file, long j, ProfilingTraceData profilingTraceData, ISerializer iSerializer) throws SentryEnvelopeException {
        if (!file.exists()) {
            throw new SentryEnvelopeException(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", file.getName()));
        }
        String strEncodeToString = Base64.encodeToString(FileUtils.readBytesFromFile(file.getPath(), j), 3);
        if (strEncodeToString.isEmpty()) {
            throw new SentryEnvelopeException("Profiling trace file is empty");
        }
        profilingTraceData.setSampledProfile(strEncodeToString);
        profilingTraceData.readDeviceCpuFrequencies();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
                    try {
                        iSerializer.serialize(profilingTraceData, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        file.delete();
                        return byteArray;
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
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                file.delete();
                throw th5;
            }
        } catch (IOException e) {
            throw new SentryEnvelopeException(String.format("Failed to serialize profiling trace data\n%s", e.getMessage()));
        }
    }

    public static SentryEnvelopeItem fromClientReport(final ISerializer iSerializer, final ClientReport clientReport) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(clientReport, "ClientReport is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda21
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$7vzYbRL9Os3Wv_fgyuPYdkUuoJ0(iSerializer, clientReport);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(clientReport), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda22
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda23
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$7vzYbRL9Os3Wv_fgyuPYdkUuoJ0(ISerializer iSerializer, ClientReport clientReport) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            try {
                iSerializer.serialize(clientReport, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
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
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public ClientReport getClientReport(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            ClientReport clientReport = (ClientReport) iSerializer.deserialize(bufferedReader, ClientReport.class);
            bufferedReader.close();
            return clientReport;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static SentryEnvelopeItem fromReplay(final ISerializer iSerializer, final ILogger iLogger, final SentryReplayEvent sentryReplayEvent, final ReplayRecording replayRecording, final boolean z) {
        final File videoFile = sentryReplayEvent.getVideoFile();
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda24
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.m5156$r8$lambda$6CgfOux0rr2kiyBKWoc1aaYN34(iSerializer, sentryReplayEvent, replayRecording, videoFile, iLogger, z);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.ReplayVideo, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda25
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, null, null), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda26
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$6CgfOux0rr2kiyB-KWoc1aaYN34, reason: not valid java name */
    public static /* synthetic */ byte[] m5156$r8$lambda$6CgfOux0rr2kiyBKWoc1aaYN34(ISerializer iSerializer, SentryReplayEvent sentryReplayEvent, ReplayRecording replayRecording, File file, ILogger iLogger, boolean z) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    iSerializer.serialize(sentryReplayEvent, bufferedWriter);
                    linkedHashMap.put(SentryItemType.ReplayEvent.getItemType(), byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                    if (replayRecording != null) {
                        iSerializer.serialize(replayRecording, bufferedWriter);
                        linkedHashMap.put(SentryItemType.ReplayRecording.getItemType(), byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.reset();
                    }
                    if (file != null && file.exists()) {
                        byte[] bytesFromFile = FileUtils.readBytesFromFile(file.getPath(), 10485760L);
                        if (bytesFromFile.length > 0) {
                            linkedHashMap.put(SentryItemType.ReplayVideo.getItemType(), bytesFromFile);
                        }
                    }
                    byte[] bArrSerializeToMsgpack = serializeToMsgpack(linkedHashMap);
                    bufferedWriter.close();
                    byteArrayOutputStream.close();
                    if (file != null) {
                        if (z) {
                            FileUtils.deleteRecursively(file.getParentFile());
                            return bArrSerializeToMsgpack;
                        }
                        file.delete();
                    }
                    return bArrSerializeToMsgpack;
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
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            try {
                iLogger.log(SentryLevel.ERROR, "Could not serialize replay recording", th5);
                return null;
            } finally {
                if (file != null) {
                    if (z) {
                        FileUtils.deleteRecursively(file.getParentFile());
                    } else {
                        file.delete();
                    }
                }
            }
        }
    }

    public static SentryEnvelopeItem fromLogs(final ISerializer iSerializer, final SentryLogEvents sentryLogEvents) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(sentryLogEvents, "SentryLogEvents is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$leZQAvTwBGODW2OhG61NhgJyp6g(iSerializer, sentryLogEvents);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Log, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application/vnd.sentry.items.log+json", (String) null, (String) null, (String) null, Integer.valueOf(sentryLogEvents.getItems().size())), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$leZQAvTwBGODW2OhG61NhgJyp6g(ISerializer iSerializer, SentryLogEvents sentryLogEvents) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            try {
                iSerializer.serialize(sentryLogEvents, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
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
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static SentryEnvelopeItem fromMetrics(final ISerializer iSerializer, final SentryMetricsEvents sentryMetricsEvents) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(sentryMetricsEvents, "SentryMetricsEvents is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryEnvelopeItem.$r8$lambda$fNU8_RB7tMjcYj2hrS75PptWCZU(iSerializer, sentryMetricsEvents);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.TraceMetric, new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(cachedItem.getBytes().length);
            }
        }, "application/vnd.sentry.items.trace-metric+json", (String) null, (String) null, (String) null, Integer.valueOf(sentryMetricsEvents.getItems().size())), new Callable() { // from class: io.sentry.SentryEnvelopeItem$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return cachedItem.getBytes();
            }
        });
    }

    public static /* synthetic */ byte[] $r8$lambda$fNU8_RB7tMjcYj2hrS75PptWCZU(ISerializer iSerializer, SentryMetricsEvents sentryMetricsEvents) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            try {
                iSerializer.serialize(sentryMetricsEvents, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
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
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class CachedItem {
        private byte[] bytes;
        private final Callable dataFactory;

        public CachedItem(Callable callable) {
            this.dataFactory = callable;
        }

        public byte[] getBytes() {
            Callable callable;
            if (this.bytes == null && (callable = this.dataFactory) != null) {
                this.bytes = (byte[]) callable.call();
            }
            return orEmptyArray(this.bytes);
        }

        private static byte[] orEmptyArray(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }
    }

    private static byte[] serializeToMsgpack(Map map) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) (map.size() | 128));
            for (Map.Entry entry : map.entrySet()) {
                byte[] bytes = ((String) entry.getKey()).getBytes(UTF_8);
                int length = bytes.length;
                byteArrayOutputStream.write(-39);
                byteArrayOutputStream.write((byte) length);
                byteArrayOutputStream.write(bytes);
                byte[] bArr = (byte[]) entry.getValue();
                int length2 = bArr.length;
                byteArrayOutputStream.write(-58);
                byteArrayOutputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(length2).array());
                byteArrayOutputStream.write(bArr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
