package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    @Override // coil.memory.WeakMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    @Override // coil.memory.WeakMemoryCache
    public void set(MemoryCache.Key key, Bitmap bitmap, Map map, int i) {
    }

    @Override // coil.memory.WeakMemoryCache
    public void trimMemory(int i) {
    }
}
