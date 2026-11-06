package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.metrics.BatchClosedMetadata;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BatchFileOrchestrator implements FileOrchestrator {
    public static final Companion Companion = new Companion(null);
    private final FilePersistenceConfig config;
    private final BatchFileFilter fileFilter;
    private final InternalLogger internalLogger;
    private long lastCleanupTimestamp;
    private long lastFileAccessTimestamp;
    private final MetricsDispatcher metricsDispatcher;
    private final AtomicInteger pendingFiles;
    private File previousFile;
    private long previousFileItemCount;
    private final long recentReadDelayMs;
    private final long recentWriteDelayMs;
    private final File rootDir;

    public BatchFileOrchestrator(File rootDir, FilePersistenceConfig config, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher, AtomicInteger pendingFiles) {
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(metricsDispatcher, "metricsDispatcher");
        Intrinsics.checkNotNullParameter(pendingFiles, "pendingFiles");
        this.rootDir = rootDir;
        this.config = config;
        this.internalLogger = internalLogger;
        this.metricsDispatcher = metricsDispatcher;
        this.pendingFiles = pendingFiles;
        this.fileFilter = new BatchFileFilter();
        this.recentReadDelayMs = MathKt.roundToLong(config.getRecentDelayMs() * 1.05d);
        this.recentWriteDelayMs = MathKt.roundToLong(config.getRecentDelayMs() * 0.95d);
    }

    public /* synthetic */ BatchFileOrchestrator(File file, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher, AtomicInteger atomicInteger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, filePersistenceConfig, internalLogger, metricsDispatcher, (i & 16) != 0 ? new AtomicInteger(0) : atomicInteger);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(boolean z) {
        if (!isRootDirValid()) {
            return null;
        }
        if (canDoCleanup()) {
            freeSpaceIfNeeded(deleteObsoleteFiles(listBatchFiles()));
            this.lastCleanupTimestamp = System.currentTimeMillis();
        }
        if (!z) {
            File reusableWritableFile = getReusableWritableFile();
            return reusableWritableFile == null ? createNewFile$default(this, false, 1, null) : reusableWritableFile;
        }
        return createNewFile(true);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        Object obj = null;
        if (!isRootDirValid()) {
            return null;
        }
        List listDeleteObsoleteFiles = deleteObsoleteFiles(listSortedBatchFiles());
        this.lastCleanupTimestamp = System.currentTimeMillis();
        this.pendingFiles.set(listDeleteObsoleteFiles.size());
        for (Object obj2 : listDeleteObsoleteFiles) {
            File file = (File) obj2;
            if (!excludeFiles.contains(file) && !isFileRecent(file, this.recentReadDelayMs)) {
                obj = obj2;
                break;
            }
        }
        return (File) obj;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getAllFiles() {
        if (!isRootDirValid()) {
            return CollectionsKt.emptyList();
        }
        return listSortedBatchFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getFlushableFiles() {
        return getAllFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        if (isRootDirValid()) {
            return this.rootDir;
        }
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Intrinsics.areEqual(file.getParent(), this.rootDir.getPath())) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.getMetadataFile.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "The file provided (%s) doesn't belong to the current folder (%s)", Arrays.copyOf(new Object[]{file.getPath(), this.rootDir.getPath()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        if (isBatchFile(file)) {
            return getMetadata(file);
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.getMetadataFile.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "The file provided is not a batch file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        return this.pendingFiles.decrementAndGet();
    }

    private final boolean isRootDirValid() {
        if (FileExtKt.existsSafe(this.rootDir, this.internalLogger)) {
            if (this.rootDir.isDirectory()) {
                if (FileExtKt.canWriteSafe(this.rootDir, this.internalLogger)) {
                    return true;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.isRootDirValid.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "The provided root dir is not writable: %s", Arrays.copyOf(new Object[]{BatchFileOrchestrator.this.rootDir.getPath()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return false;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.isRootDirValid.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "The provided root file is not a directory: %s", Arrays.copyOf(new Object[]{BatchFileOrchestrator.this.rootDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        synchronized (this.rootDir) {
            if (FileExtKt.existsSafe(this.rootDir, this.internalLogger)) {
                return true;
            }
            if (FileExtKt.mkdirsSafe(this.rootDir, this.internalLogger)) {
                return true;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator$isRootDirValid$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "The provided root dir can't be created: %s", Arrays.copyOf(new Object[]{this.this$0.rootDir.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
    }

    static /* synthetic */ File createNewFile$default(BatchFileOrchestrator batchFileOrchestrator, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return batchFileOrchestrator.createNewFile(z);
    }

    private final File createNewFile(boolean z) {
        File file = new File(this.rootDir, String.valueOf(System.currentTimeMillis()));
        File file2 = this.previousFile;
        long j = this.lastFileAccessTimestamp;
        if (file2 != null) {
            this.metricsDispatcher.sendBatchClosedMetric(file2, new BatchClosedMetadata(j, z, this.previousFileItemCount));
        }
        this.previousFile = file;
        this.previousFileItemCount = 1L;
        this.lastFileAccessTimestamp = System.currentTimeMillis();
        this.pendingFiles.incrementAndGet();
        return file;
    }

    private final File getReusableWritableFile() {
        File latestBatchFile = getLatestBatchFile(listBatchFiles());
        if (latestBatchFile == null) {
            return null;
        }
        File file = this.previousFile;
        long j = this.previousFileItemCount;
        if (!Intrinsics.areEqual(file, latestBatchFile)) {
            return null;
        }
        boolean zIsFileRecent = isFileRecent(latestBatchFile, this.recentWriteDelayMs);
        boolean z = FileExtKt.lengthSafe(latestBatchFile, this.internalLogger) < this.config.getMaxBatchSize();
        boolean z2 = j < ((long) this.config.getMaxItemsPerBatch());
        if (!zIsFileRecent || !z || !z2) {
            return null;
        }
        this.previousFileItemCount = j + 1;
        this.lastFileAccessTimestamp = System.currentTimeMillis();
        return latestBatchFile;
    }

    private final boolean isFileRecent(File file, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        Long longOrNull = StringsKt.toLongOrNull(name);
        return (longOrNull != null ? longOrNull.longValue() : 0L) >= jCurrentTimeMillis - j;
    }

    private final List deleteObsoleteFiles(List list) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.config.getOldFileThreshold();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Long longOrNull = StringsKt.toLongOrNull(name);
            if ((longOrNull != null ? longOrNull.longValue() : 0L) < jCurrentTimeMillis) {
                if (FileExtKt.deleteSafe(file, this.internalLogger)) {
                    this.metricsDispatcher.sendBatchDeletedMetric(file, RemovalReason.Obsolete.INSTANCE, this.pendingFiles.decrementAndGet());
                }
                if (FileExtKt.existsSafe(getMetadata(file), this.internalLogger)) {
                    FileExtKt.deleteSafe(getMetadata(file), this.internalLogger);
                }
                file = null;
            }
            if (file != null) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private final void freeSpaceIfNeeded(List list) {
        List list2 = list;
        Iterator it = list2.iterator();
        final long jLengthSafe = 0;
        while (it.hasNext()) {
            jLengthSafe += FileExtKt.lengthSafe((File) it.next(), this.internalLogger);
        }
        final long maxDiskSpace = this.config.getMaxDiskSpace();
        final long jDeleteFile = jLengthSafe - maxDiskSpace;
        if (jDeleteFile > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.freeSpaceIfNeeded.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Too much disk space used (%d/%d): cleaning up to free %d bytes…", Arrays.copyOf(new Object[]{Long.valueOf(jLengthSafe), Long.valueOf(maxDiskSpace), Long.valueOf(jDeleteFile)}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            for (File file : CollectionsKt.sorted(list2)) {
                if (jDeleteFile > 0) {
                    jDeleteFile = (jDeleteFile - deleteFile(file, true)) - deleteFile$default(this, getMetadata(file), false, 2, null);
                }
            }
        }
    }

    static /* synthetic */ long deleteFile$default(BatchFileOrchestrator batchFileOrchestrator, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return batchFileOrchestrator.deleteFile(file, z);
    }

    private final long deleteFile(File file, boolean z) {
        if (!FileExtKt.existsSafe(file, this.internalLogger)) {
            return 0L;
        }
        long jLengthSafe = FileExtKt.lengthSafe(file, this.internalLogger);
        if (!FileExtKt.deleteSafe(file, this.internalLogger)) {
            return 0L;
        }
        if (z) {
            this.metricsDispatcher.sendBatchDeletedMetric(file, RemovalReason.Purged.INSTANCE, this.pendingFiles.decrementAndGet());
        }
        return jLengthSafe;
    }

    private final List listBatchFiles() {
        File[] fileArrListFilesSafe = FileExtKt.listFilesSafe(this.rootDir, this.fileFilter, this.internalLogger);
        if (fileArrListFilesSafe == null) {
            fileArrListFilesSafe = new File[0];
        }
        return ArraysKt.toList(fileArrListFilesSafe);
    }

    private final List listSortedBatchFiles() {
        return CollectionsKt.sorted(listBatchFiles());
    }

    private final boolean canDoCleanup() {
        return System.currentTimeMillis() - this.lastCleanupTimestamp > this.config.getCleanupFrequencyThreshold();
    }

    private final File getMetadata(File file) {
        return new File(file.getPath() + "_metadata");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBatchFile(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.toLongOrNull(name) != null;
    }

    private final File getLatestBatchFile(List list) {
        return (File) CollectionsKt.maxOrNull(list);
    }

    public final class BatchFileFilter implements FileFilter {
        public BatchFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            return BatchFileOrchestrator.this.isBatchFile(file);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
