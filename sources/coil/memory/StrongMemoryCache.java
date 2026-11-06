package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface StrongMemoryCache {
    MemoryCache.Value get(MemoryCache.Key key);

    void set(MemoryCache.Key key, Bitmap bitmap, Map map);

    void trimMemory(int i);
}
