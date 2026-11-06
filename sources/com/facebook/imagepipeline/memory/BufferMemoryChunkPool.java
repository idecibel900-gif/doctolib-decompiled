package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class BufferMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public BufferMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public BufferMemoryChunk alloc(int i) {
        return new BufferMemoryChunk(i);
    }
}
