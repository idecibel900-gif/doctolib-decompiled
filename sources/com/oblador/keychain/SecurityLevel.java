package com.oblador.keychain;

import java.util.Arrays;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
public enum SecurityLevel {
    ANY,
    SECURE_SOFTWARE,
    SECURE_HARDWARE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public final String jsName() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("SECURITY_LEVEL_%s", Arrays.copyOf(new Object[]{name()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean satisfiesSafetyThreshold(SecurityLevel threshold) {
        Intrinsics.checkNotNullParameter(threshold, "threshold");
        return compareTo(threshold) >= 0;
    }
}
