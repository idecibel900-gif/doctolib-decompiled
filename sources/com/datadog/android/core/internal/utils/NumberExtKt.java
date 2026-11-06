package com.datadog.android.core.internal.utils;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NumberExtKt {
    public static final byte[] toByteArray(int i) {
        byte[] bArrArray = ByteBuffer.allocate(4).putInt(i).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(Int.SIZE_BYTES).putInt(this).array()");
        return bArrArray;
    }
}
