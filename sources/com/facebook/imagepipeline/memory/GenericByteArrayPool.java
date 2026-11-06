package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class GenericByteArrayPool extends BasePool implements ByteArrayPool {
    private final int[] bucketSizes;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getSizeInBytes(int i) {
        return i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        Intrinsics.checkNotNullParameter(memoryTrimmableRegistry, "memoryTrimmableRegistry");
        Intrinsics.checkNotNullParameter(poolParams, "poolParams");
        Intrinsics.checkNotNullParameter(poolStatsTracker, "poolStatsTracker");
        SparseIntArray sparseIntArray = poolParams.bucketSizes;
        if (sparseIntArray != null) {
            this.bucketSizes = new int[sparseIntArray.size()];
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                this.bucketSizes[i] = sparseIntArray.keyAt(i);
            }
        } else {
            this.bucketSizes = new int[0];
        }
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public byte[] alloc(int i) {
        return new byte[i];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getBucketedSize(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.bucketSizes) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.length;
    }
}
