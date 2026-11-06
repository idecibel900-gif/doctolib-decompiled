package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EncodedCountingMemoryCacheFactory {
    public static CountingMemoryCache get(Supplier supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
        LruCountingMemoryCache lruCountingMemoryCache = new LruCountingMemoryCache(new ValueDescriptor() { // from class: com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, cacheTrimStrategy, supplier, null, false, false);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
