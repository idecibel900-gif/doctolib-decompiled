package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public PlatformMagnifierImpl mo165createnHHXs2Y(View view, boolean z, long j, float f, float f2, boolean z2, Density density, float f3) {
        if (z) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long jMo232toSizeXkaWNTQ = density.mo232toSizeXkaWNTQ(j);
        float fMo231toPx0680j_4 = density.mo231toPx0680j_4(f);
        float fMo231toPx0680j_5 = density.mo231toPx0680j_4(f2);
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jMo232toSizeXkaWNTQ != 9205357640488583168L) {
            builder.setSize(MathKt.roundToInt(Size.m1261getWidthimpl(jMo232toSizeXkaWNTQ)), MathKt.roundToInt(Size.m1259getHeightimpl(jMo232toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(fMo231toPx0680j_4)) {
            builder.setCornerRadius(fMo231toPx0680j_4);
        }
        if (!Float.isNaN(fMo231toPx0680j_5)) {
            builder.setElevation(fMo231toPx0680j_5);
        }
        if (!Float.isNaN(f3)) {
            builder.setInitialZoom(f3);
        }
        builder.setClippingEnabled(z2);
        return new PlatformMagnifierImpl(builder.build());
    }

    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo164updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m1237isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2));
            } else {
                getMagnifier().show(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j));
            }
        }
    }
}
