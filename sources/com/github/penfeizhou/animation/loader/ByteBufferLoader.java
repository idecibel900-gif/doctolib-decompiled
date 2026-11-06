package com.github.penfeizhou.animation.loader;

import com.github.penfeizhou.animation.io.ByteBufferReader;
import com.github.penfeizhou.animation.io.Reader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteBufferLoader implements Loader {
    public abstract ByteBuffer getByteBuffer();

    @Override // com.github.penfeizhou.animation.loader.Loader
    public Reader obtain() {
        return new ByteBufferReader(getByteBuffer());
    }
}
