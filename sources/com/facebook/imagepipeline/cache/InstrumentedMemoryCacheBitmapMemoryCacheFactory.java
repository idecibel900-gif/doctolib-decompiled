package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InstrumentedMemoryCacheBitmapMemoryCacheFactory {
    public static InstrumentedMemoryCache get(MemoryCache memoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(memoryCache);
        return new InstrumentedMemoryCache(memoryCache, new MemoryCacheTracker() { // from class: com.facebook.imagepipeline.cache.InstrumentedMemoryCacheBitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheHit(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheMiss(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheMiss(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCachePut(CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCachePut(cacheKey);
            }
        });
    }
}
