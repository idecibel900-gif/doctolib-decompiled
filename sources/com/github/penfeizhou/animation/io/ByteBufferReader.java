package com.github.penfeizhou.animation.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferReader implements Reader {
    protected final ByteBuffer byteBuffer;

    @Override // com.github.penfeizhou.animation.io.Reader
    public void close() {
    }

    public ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public long skip(long j) {
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public byte peek() {
        return this.byteBuffer.get();
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public void reset() {
        this.byteBuffer.position(0);
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public int position() {
        return this.byteBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public int read(byte[] bArr, int i, int i2) {
        this.byteBuffer.get(bArr, i, i2);
        return i2;
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public int available() {
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public InputStream toInputStream() {
        return new ByteArrayInputStream(this.byteBuffer.array());
    }
}
