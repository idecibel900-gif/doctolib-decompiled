package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface WeakMemoryCache {
    MemoryCache.Value get(MemoryCache.Key key);

    void set(MemoryCache.Key key, Bitmap bitmap, Map map, int i);

    void trimMemory(int i);
}
