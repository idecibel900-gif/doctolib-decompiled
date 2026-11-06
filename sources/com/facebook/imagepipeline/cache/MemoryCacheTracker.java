package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCacheTracker {
    void onCacheHit(Object obj);

    void onCacheMiss(Object obj);

    void onCachePut(Object obj);
}
