package com.facebook.soloader;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface ElfByteChannel extends ByteChannel {
    int read(ByteBuffer byteBuffer, long j);
}
