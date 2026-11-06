package com.margelo.nitro.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ArrayBufferKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteBuffer arrayBufferView(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.nativeOrder());
        byteBufferDuplicate.clear();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        return byteBufferDuplicate;
    }
}
