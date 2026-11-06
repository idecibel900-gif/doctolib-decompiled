package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {
    private static final Class TAG = DynamicDefaultDiskStorage.class;
    private final String mBaseDirectoryName;
    private final Supplier mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    volatile State mCurrentState = new State(null, null);
    private final int mVersion;

    static class State {
        public final DiskStorage delegate;
        public final File rootDirectory;

        State(File file, DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        try {
            return get().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String str, Object obj) {
        return get().getResource(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        return get().contains(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) {
        return get().touch(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (IOException e) {
            FLog.e(TAG, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) {
        return get().insert(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection getEntries() {
        return get().getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return get().remove(entry);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        return get().remove(str);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        get().clearAll();
    }

    synchronized DiskStorage get() {
        try {
            if (shouldCreateNewStorage()) {
                deleteOldStorageIfNecessary();
                createStorage();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);
    }

    private boolean shouldCreateNewStorage() {
        File file;
        State state = this.mCurrentState;
        return state.delegate == null || (file = state.rootDirectory) == null || !file.exists();
    }

    void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate == null || this.mCurrentState.rootDirectory == null) {
            return;
        }
        FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }

    private void createStorage() throws FileUtils.CreateDirectoryException {
        File file = new File((File) this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        createRootDirectoryIfNecessary(file);
        this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
    }

    void createRootDirectoryIfNecessary(File file) throws FileUtils.CreateDirectoryException {
        try {
            FileUtils.mkdirs(file);
            FLog.d(TAG, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
