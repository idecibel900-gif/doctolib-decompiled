package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final Function0 rippleAlpha;
    private final Animatable animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List interactions = new ArrayList();

    public StateLayer(boolean z, Function0 function0) {
        this.bounded = z;
        this.rippleAlpha = function0;
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, CoroutineScope coroutineScope) {
        float draggedAlpha;
        boolean z = interaction instanceof HoverInteraction$Enter;
        if (z) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction$Exit) {
            this.interactions.remove(((HoverInteraction$Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction$Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction$Unfocus) {
            this.interactions.remove(((FocusInteraction$Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction$Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction$Stop) {
            this.interactions.remove(((DragInteraction$Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction$Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction$Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull(this.interactions);
        if (Intrinsics.areEqual(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 == null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StateLayer$handleInteraction$2(this, RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), null), 3, null);
        } else {
            RippleAlpha rippleAlpha = (RippleAlpha) this.rippleAlpha.invoke();
            if (z) {
                draggedAlpha = rippleAlpha.getHoveredAlpha();
            } else if (interaction instanceof FocusInteraction$Focus) {
                draggedAlpha = rippleAlpha.getFocusedAlpha();
            } else {
                draggedAlpha = interaction instanceof DragInteraction$Start ? rippleAlpha.getDraggedAlpha() : 0.0f;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StateLayer$handleInteraction$1(this, draggedAlpha, RippleKt.incomingStateLayerAnimationSpecFor(interaction2), null), 3, null);
        }
        this.currentInteraction = interaction2;
    }

    /* JADX INFO: renamed from: drawStateLayer-mxwnekA, reason: not valid java name */
    public final void m686drawStateLayermxwnekA(DrawScope drawScope, float f, long j) {
        float fFloatValue = ((Number) this.animatedAlpha.getValue()).floatValue();
        if (fFloatValue > 0.0f) {
            long jM1365copywmQWz5c$default = Color.m1365copywmQWz5c$default(j, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (!this.bounded) {
                DrawScope.m1588drawCircleVaOC9Bg$default(drawScope, jM1365copywmQWz5c$default, f, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float fM1261getWidthimpl = Size.m1261getWidthimpl(drawScope.mo1599getSizeNHjbRc());
            float fM1259getHeightimpl = Size.m1259getHeightimpl(drawScope.mo1599getSizeNHjbRc());
            int iM1360getIntersectrtfAjoo = ClipOp.Companion.m1360getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo1579getSizeNHjbRc = drawContext.mo1579getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo1582clipRectN_I0leg(0.0f, 0.0f, fM1261getWidthimpl, fM1259getHeightimpl, iM1360getIntersectrtfAjoo);
            DrawScope.m1588drawCircleVaOC9Bg$default(drawScope, jM1365copywmQWz5c$default, f, 0L, 0.0f, null, null, 0, 124, null);
            drawContext.getCanvas().restore();
            drawContext.mo1580setSizeuvyYCjk(jMo1579getSizeNHjbRc);
        }
    }
}
