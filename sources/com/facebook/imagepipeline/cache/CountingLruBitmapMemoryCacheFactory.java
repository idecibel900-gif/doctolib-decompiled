package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes3.dex */
public class CountingLruBitmapMemoryCacheFactory implements BitmapMemoryCacheFactory {
    @Override // com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory
    public CountingMemoryCache create(Supplier supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy, boolean z, boolean z2, CountingMemoryCache.EntryStateObserver entryStateObserver) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new ValueDescriptor() { // from class: com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(CloseableImage closeableImage) {
                return closeableImage.getSizeInBytes();
            }
        }, cacheTrimStrategy, supplier, entryStateObserver, z, z2);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
