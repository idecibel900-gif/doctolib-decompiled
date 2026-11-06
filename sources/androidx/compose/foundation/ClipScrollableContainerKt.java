package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: loaded from: classes.dex */
public abstract class ClipScrollableContainerKt {
    private static final Modifier HorizontalScrollableClipModifier;
    private static final float MaxSupportedElevation = Dp.m2551constructorimpl(30);
    private static final Modifier VerticalScrollableClipModifier;

    public static final Modifier clipScrollableContainer(Modifier modifier, Orientation orientation) {
        Modifier modifier2;
        if (orientation == Orientation.Vertical) {
            modifier2 = VerticalScrollableClipModifier;
        } else {
            modifier2 = HorizontalScrollableClipModifier;
        }
        return modifier.then(modifier2);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }

    static {
        Modifier.Companion companion = Modifier.Companion;
        HorizontalScrollableClipModifier = ClipKt.clip(companion, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$HorizontalScrollableClipModifier$1
            @Override // androidx.compose.ui.graphics.Shape
            /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
            public Outline mo145createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                float fMo225roundToPx0680j_4 = density.mo225roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
                return new Outline.Rectangle(new Rect(0.0f, -fMo225roundToPx0680j_4, Size.m1261getWidthimpl(j), Size.m1259getHeightimpl(j) + fMo225roundToPx0680j_4));
            }
        });
        VerticalScrollableClipModifier = ClipKt.clip(companion, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$VerticalScrollableClipModifier$1
            @Override // androidx.compose.ui.graphics.Shape
            /* JADX INFO: renamed from: createOutline-Pq9zytI */
            public Outline mo145createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                float fMo225roundToPx0680j_4 = density.mo225roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
                return new Outline.Rectangle(new Rect(-fMo225roundToPx0680j_4, 0.0f, Size.m1261getWidthimpl(j) + fMo225roundToPx0680j_4, Size.m1259getHeightimpl(j)));
            }
        });
    }
}
