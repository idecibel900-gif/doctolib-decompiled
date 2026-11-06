package expo.modules.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NetworkUtilsKt {
    public static final byte[] frontPadWithZeros(byte[] inputArray) {
        Intrinsics.checkNotNullParameter(inputArray, "inputArray");
        byte[] bArr = {0, 0, 0, 0};
        System.arraycopy(inputArray, 0, bArr, 4 - inputArray.length, inputArray.length);
        return bArr;
    }
}
