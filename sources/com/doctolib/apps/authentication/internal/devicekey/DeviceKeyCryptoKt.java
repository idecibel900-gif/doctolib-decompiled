package com.doctolib.apps.authentication.internal.devicekey;

import java.math.BigInteger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeviceKeyCryptoKt {
    public static final byte[] toFixed32(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("negative field element");
        }
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == 32) {
            Intrinsics.checkNotNull(byteArray);
            return byteArray;
        }
        if (byteArray.length == 33 && byteArray[0] == 0) {
            Intrinsics.checkNotNull(byteArray);
            return ArraysKt.copyOfRange(byteArray, 1, 33);
        }
        if (byteArray.length < 32) {
            byte[] bArr = new byte[32 - byteArray.length];
            Intrinsics.checkNotNull(byteArray);
            return ArraysKt.plus(bArr, byteArray);
        }
        throw new IllegalArgumentException("field element exceeds 32 bytes: " + byteArray.length);
    }
}
