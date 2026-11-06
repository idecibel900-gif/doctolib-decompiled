package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class OffsetNode extends Modifier.Node implements LayoutModifierNode {
    private boolean rtlAware;
    private float x;
    private float y;

    public /* synthetic */ OffsetNode(float f, float f2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, z);
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m301getXD9Ej5fM() {
        return this.x;
    }

    /* JADX INFO: renamed from: setX-0680j_4, reason: not valid java name */
    public final void m303setX0680j_4(float f) {
        this.x = f;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m302getYD9Ej5fM() {
        return this.y;
    }

    /* JADX INFO: renamed from: setY-0680j_4, reason: not valid java name */
    public final void m304setY0680j_4(float f) {
        this.y = f;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    public final void setRtlAware(boolean z) {
        this.rtlAware = z;
    }

    private OffsetNode(float f, float f2, boolean z) {
        this.x = f;
        this.y = f2;
        this.rtlAware = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.OffsetNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                if (this.this$0.getRtlAware()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1843measureBRTryo0, measureScope.mo225roundToPx0680j_4(this.this$0.m301getXD9Ej5fM()), measureScope.mo225roundToPx0680j_4(this.this$0.m302getYD9Ej5fM()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, measureScope.mo225roundToPx0680j_4(this.this$0.m301getXD9Ej5fM()), measureScope.mo225roundToPx0680j_4(this.this$0.m302getYD9Ej5fM()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }
}
