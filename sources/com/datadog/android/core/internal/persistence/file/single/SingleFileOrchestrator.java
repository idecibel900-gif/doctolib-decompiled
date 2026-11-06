package com.datadog.android.core.internal.persistence.file.single;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SingleFileOrchestrator implements FileOrchestrator {
    private final File file;
    private final InternalLogger internalLogger;

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        return 0;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        return null;
    }

    public SingleFileOrchestrator(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.file = file;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(boolean z) {
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        return this.file;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        if (excludeFiles.contains(this.file)) {
            return null;
        }
        return this.file;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getAllFiles() {
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile, this.internalLogger);
        }
        return CollectionsKt.listOf(this.file);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getFlushableFiles() {
        return getAllFiles();
    }
}
