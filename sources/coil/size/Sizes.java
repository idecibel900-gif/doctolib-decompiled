package coil.size;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: coil.size.-Sizes, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Sizes {
    public static final boolean isOriginal(Size size) {
        return Intrinsics.areEqual(size, Size.ORIGINAL);
    }
}
