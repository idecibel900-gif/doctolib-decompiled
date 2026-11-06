package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes3.dex */
public class InstrumentedMemoryCache implements MemoryCache {
    private final MemoryCache mDelegate;
    private final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.mDelegate = memoryCache;
        this.mTracker = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference get(Object obj) {
        CloseableReference closeableReference = this.mDelegate.get(obj);
        if (closeableReference == null) {
            this.mTracker.onCacheMiss(obj);
            return closeableReference;
        }
        this.mTracker.onCacheHit(obj);
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(Object obj) {
        this.mDelegate.probe(obj);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference cache(Object obj, CloseableReference closeableReference) {
        this.mTracker.onCachePut(obj);
        return this.mDelegate.cache(obj, closeableReference);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate predicate) {
        return this.mDelegate.removeAll(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate predicate) {
        return this.mDelegate.contains(predicate);
    }
}
