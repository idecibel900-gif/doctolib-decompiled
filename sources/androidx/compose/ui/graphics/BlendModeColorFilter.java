package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class BlendModeColorFilter extends ColorFilter {
    private final int blendMode;
    private final long color;

    public /* synthetic */ BlendModeColorFilter(long j, int i, android.graphics.ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, colorFilter);
    }

    public /* synthetic */ BlendModeColorFilter(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i);
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m1345getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    private BlendModeColorFilter(long j, int i, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.color = j;
        this.blendMode = i;
    }

    private BlendModeColorFilter(long j, int i) {
        this(j, i, AndroidColorFilter_androidKt.m1280actualTintColorFilterxETnrds(j, i), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return Color.m1367equalsimpl0(this.color, blendModeColorFilter.color) && BlendMode.m1313equalsimpl0(this.blendMode, blendModeColorFilter.blendMode);
    }

    public int hashCode() {
        return (Color.m1373hashCodeimpl(this.color) * 31) + BlendMode.m1314hashCodeimpl(this.blendMode);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) Color.m1374toStringimpl(this.color)) + ", blendMode=" + ((Object) BlendMode.m1315toStringimpl(this.blendMode)) + ')';
    }
}
