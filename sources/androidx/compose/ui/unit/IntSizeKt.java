package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.SizeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntSizeKt {
    public static final long IntSize(int i, int i2) {
        return IntSize.m2605constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m2614getCenterozmzZPI(long j) {
        return IntOffset.m2586constructorimpl((((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32));
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m2615toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m2609getWidthimpl(j), IntSize.m2608getHeightimpl(j));
    }
}
