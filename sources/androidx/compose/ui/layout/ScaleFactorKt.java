package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ScaleFactorKt {
    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m1877constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m1880timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m1261getWidthimpl(j) * ScaleFactor.m1878getScaleXimpl(j2), Size.m1259getHeightimpl(j) * ScaleFactor.m1879getScaleYimpl(j2));
    }
}
