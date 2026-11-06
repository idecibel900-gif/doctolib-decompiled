package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface FileOrchestrator {
    int decrementAndGetPendingFilesCount();

    List getAllFiles();

    List getFlushableFiles();

    File getMetadataFile(File file);

    File getReadableFile(Set set);

    File getRootDir();

    File getWritableFile(boolean z);

    public static final class DefaultImpls {
        public static /* synthetic */ File getWritableFile$default(FileOrchestrator fileOrchestrator, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWritableFile");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return fileOrchestrator.getWritableFile(z);
        }
    }
}
