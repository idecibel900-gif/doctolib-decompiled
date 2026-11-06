package coil.util;

import android.content.Context;
import coil.disk.DiskCache;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SingletonDiskCache {
    public static final SingletonDiskCache INSTANCE = new SingletonDiskCache();
    private static DiskCache instance;

    private SingletonDiskCache() {
    }

    public final synchronized DiskCache get(Context context) {
        DiskCache diskCacheBuild;
        diskCacheBuild = instance;
        if (diskCacheBuild == null) {
            diskCacheBuild = new DiskCache.Builder().directory(FilesKt.resolve(Utils.getSafeCacheDir(context), "image_cache")).build();
            instance = diskCacheBuild;
        }
        return diskCacheBuild;
    }
}
