package coil.memory;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import coil.util.Bitmaps;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class RealStrongMemoryCache implements StrongMemoryCache {
    private final RealStrongMemoryCache$cache$1 cache;
    private final WeakMemoryCache weakMemoryCache;

    /* JADX WARN: Type inference failed for: r2v1, types: [coil.memory.RealStrongMemoryCache$cache$1] */
    public RealStrongMemoryCache(final int i, WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
        this.cache = new LruCache(i) { // from class: coil.memory.RealStrongMemoryCache$cache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            public int sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue) {
                return internalValue.getSize();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            public void entryRemoved(boolean z, MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue, RealStrongMemoryCache.InternalValue internalValue2) {
                this.weakMemoryCache.set(key, internalValue.getBitmap(), internalValue.getExtras(), internalValue.getSize());
            }
        };
    }

    public int getSize() {
        return size();
    }

    public int getMaxSize() {
        return maxSize();
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        InternalValue internalValue = (InternalValue) get(key);
        if (internalValue != null) {
            return new MemoryCache.Value(internalValue.getBitmap(), internalValue.getExtras());
        }
        return null;
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Bitmap bitmap, Map map) {
        int allocationByteCountCompat = Bitmaps.getAllocationByteCountCompat(bitmap);
        if (allocationByteCountCompat <= getMaxSize()) {
            put(key, new InternalValue(bitmap, map, allocationByteCountCompat));
        } else {
            remove(key);
            this.weakMemoryCache.set(key, bitmap, map, allocationByteCountCompat);
        }
    }

    public void clearMemory() {
        evictAll();
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int i) {
        if (i >= 40) {
            clearMemory();
        } else {
            if (10 > i || i >= 20) {
                return;
            }
            trimToSize(getSize() / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class InternalValue {
        private final Bitmap bitmap;
        private final Map extras;
        private final int size;

        public InternalValue(Bitmap bitmap, Map map, int i) {
            this.bitmap = bitmap;
            this.extras = map;
            this.size = i;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Map getExtras() {
            return this.extras;
        }

        public final int getSize() {
            return this.size;
        }
    }
}
