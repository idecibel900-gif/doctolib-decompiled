package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EncodedMemoryCacheFactory {
    public static InstrumentedMemoryCache get(MemoryCache memoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerEncodedMemoryCache(memoryCache);
        return new InstrumentedMemoryCache(memoryCache, new MemoryCacheTracker() { // from class: com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheMiss(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheMiss(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCachePut(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCachePut(cacheKey);
            }
        });
    }
}
