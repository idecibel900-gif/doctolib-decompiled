package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    private final RenderEffect renderEffect;

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect, f, f2, i);
    }

    private BlurEffect(RenderEffect renderEffect, float f, float f2, int i) {
        super(null);
        this.renderEffect = renderEffect;
        this.radiusX = f;
        this.radiusY = f2;
        this.edgeTreatment = i;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.m1476createBlurEffect8A3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        return this.radiusX == blurEffect.radiusX && this.radiusY == blurEffect.radiusY && TileMode.m1511equalsimpl0(this.edgeTreatment, blurEffect.edgeTreatment) && Intrinsics.areEqual(this.renderEffect, blurEffect.renderEffect);
    }

    public int hashCode() {
        RenderEffect renderEffect = this.renderEffect;
        return ((((((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Float.hashCode(this.radiusX)) * 31) + Float.hashCode(this.radiusY)) * 31) + TileMode.m1512hashCodeimpl(this.edgeTreatment);
    }

    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + ((Object) TileMode.m1513toStringimpl(this.edgeTreatment)) + ')';
    }
}
