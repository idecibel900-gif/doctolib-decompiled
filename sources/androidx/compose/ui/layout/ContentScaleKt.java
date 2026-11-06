package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m1840computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m1842computeFillWidthiLBOSCw(j, j2), m1839computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m1841computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m1842computeFillWidthiLBOSCw(j, j2), m1839computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m1842computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m1261getWidthimpl(j2) / Size.m1261getWidthimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m1839computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m1259getHeightimpl(j2) / Size.m1259getHeightimpl(j);
    }
}
