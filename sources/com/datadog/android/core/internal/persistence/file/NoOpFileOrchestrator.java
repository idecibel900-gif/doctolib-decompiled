package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpFileOrchestrator implements FileOrchestrator {
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
    public File getReadableFile(Set excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(boolean z) {
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getFlushableFiles() {
        return CollectionsKt.emptyList();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List getAllFiles() {
        return CollectionsKt.emptyList();
    }
}
