package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceFontFamilyName {
    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2264equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2265hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2266toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m2263constructorimpl(String str) {
        if (str.length() > 0) {
            return str;
        }
        throw new IllegalArgumentException("name may not be empty");
    }
}
