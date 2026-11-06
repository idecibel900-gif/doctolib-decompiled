package com.revenuecat.purchases.models;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toHexString", "", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChecksumKt {
    public static final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1() { // from class: com.revenuecat.purchases.models.ChecksumKt.toHexString.1
            public final CharSequence invoke(byte b) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).byteValue());
            }
        }, 30, (Object) null);
    }
}
