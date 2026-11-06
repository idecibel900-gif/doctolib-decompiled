package com.revenuecat.purchases.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"fromLittleEndianBytes", "", "Lkotlin/Int$Companion;", "byteArray", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntExtensionsKt {
    public static final int fromLittleEndianBytes(IntCompanionObject intCompanionObject, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
}
