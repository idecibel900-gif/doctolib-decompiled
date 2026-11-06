package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class PaddingValuesImpl implements PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private PaddingValuesImpl(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        if (f < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo295calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float mo297calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo296calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public float mo294calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        return Dp.m2553equalsimpl0(this.start, paddingValuesImpl.start) && Dp.m2553equalsimpl0(this.top, paddingValuesImpl.top) && Dp.m2553equalsimpl0(this.end, paddingValuesImpl.end) && Dp.m2553equalsimpl0(this.bottom, paddingValuesImpl.bottom);
    }

    public int hashCode() {
        return (((((Dp.m2554hashCodeimpl(this.start) * 31) + Dp.m2554hashCodeimpl(this.top)) * 31) + Dp.m2554hashCodeimpl(this.end)) * 31) + Dp.m2554hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) Dp.m2555toStringimpl(this.start)) + ", top=" + ((Object) Dp.m2555toStringimpl(this.top)) + ", end=" + ((Object) Dp.m2555toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m2555toStringimpl(this.bottom)) + ')';
    }
}
