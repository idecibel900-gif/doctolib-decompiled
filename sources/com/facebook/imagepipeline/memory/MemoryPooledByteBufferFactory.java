package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    private final MemoryChunkPool pool;
    private final PooledByteStreams pooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool pool, PooledByteStreams pooledByteStreams) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        this.pool = pool;
        this.pooledByteStreams = pooledByteStreams;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.pool, 0, 2, null);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(byte[] bytes) throws Throwable {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.pool, bytes.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bytes, 0, bytes.length);
                MemoryPooledByteBuffer byteBuffer = memoryPooledByteBufferOutputStream.toByteBuffer();
                memoryPooledByteBufferOutputStream.close();
                return byteBuffer;
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        } catch (Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.pool, i);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    public final MemoryPooledByteBuffer newByteBuf(InputStream inputStream, MemoryPooledByteBufferOutputStream outputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        this.pooledByteStreams.copy(inputStream, outputStream);
        return outputStream.toByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream() {
        return new MemoryPooledByteBufferOutputStream(this.pool, 0, 2, null);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream(int i) {
        return new MemoryPooledByteBufferOutputStream(this.pool, i);
    }
}
