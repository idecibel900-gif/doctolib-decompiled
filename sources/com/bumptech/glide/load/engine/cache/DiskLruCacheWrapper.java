package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();
    private final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    protected DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    private synchronized DiskLruCache getDiskCache() {
        try {
            if (this.diskLruCache == null) {
                this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.diskLruCache;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Objects.toString(key);
        }
        try {
            DiskLruCache.Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(safeKey);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Objects.toString(key);
            }
            try {
                DiskLruCache diskCache = getDiskCache();
                if (diskCache.get(safeKey) == null) {
                    DiskLruCache.Editor editorEdit = diskCache.edit(safeKey);
                    if (editorEdit == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
                    }
                    try {
                        if (writer.write(editorEdit.getFile(0))) {
                            editorEdit.commit();
                        }
                        editorEdit.abortUnlessCommitted();
                    } catch (Throwable th) {
                        editorEdit.abortUnlessCommitted();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.writeLocker.release(safeKey);
        } catch (Throwable th2) {
            this.writeLocker.release(safeKey);
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            try {
                getDiskCache().delete();
            } catch (IOException unused) {
            } finally {
                resetDiskCache();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }
}
