package coil.memory;

import android.graphics.Bitmap;
import coil.util.Bitmaps;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    private final WeakMemoryCache weakMemoryCache;

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int i) {
    }

    public EmptyStrongMemoryCache(WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Bitmap bitmap, Map map) {
        this.weakMemoryCache.set(key, bitmap, map, Bitmaps.getAllocationByteCountCompat(bitmap));
    }
}
