package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {
    CloseableReference mBufRef;
    private final int mSize;

    public MemoryPooledByteBuffer(CloseableReference closeableReference, int i) {
        Preconditions.checkNotNull(closeableReference);
        Preconditions.checkArgument(Boolean.valueOf(i >= 0 && i <= ((MemoryChunk) closeableReference.get()).getSize()));
        this.mBufRef = closeableReference.m3216clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int i) {
        ensureValid();
        Preconditions.checkArgument(Boolean.valueOf(i >= 0));
        Preconditions.checkArgument(Boolean.valueOf(i < this.mSize));
        Preconditions.checkNotNull(this.mBufRef);
        return ((MemoryChunk) this.mBufRef.get()).read(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        Preconditions.checkArgument(Boolean.valueOf(i + i3 <= this.mSize));
        Preconditions.checkNotNull(this.mBufRef);
        return ((MemoryChunk) this.mBufRef.get()).read(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
    }

    synchronized void ensureValid() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
