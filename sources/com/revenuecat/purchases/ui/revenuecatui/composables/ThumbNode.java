package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "initialOffset", "", "initialSize", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "sizeAnim", "onAttach", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private boolean checked;
    private float initialOffset;
    private float initialSize;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable offsetAnim;
    private Animatable sizeAnim;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return super.maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return super.maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return super.minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return super.minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter(interactionSource, "<set-?>");
        this.interactionSource = interactionSource;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public ThumbNode(InteractionSource interactionSource, boolean z) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        this.interactionSource = interactionSource;
        this.checked = z;
        this.initialOffset = Float.NaN;
        this.initialSize = Float.NaN;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$onAttach$1", f = "Switch.kt", l = {333}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ThumbNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                Flow interactions = ThumbNode.this.getInteractionSource().getInteractions();
                final ThumbNode thumbNode = ThumbNode.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode.onAttach.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Interaction interaction, Continuation continuation) {
                        if (interaction instanceof PressInteraction.Press) {
                            ref$IntRef.element++;
                        } else if (interaction instanceof PressInteraction.Release) {
                            ref$IntRef.element--;
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            ref$IntRef.element--;
                        }
                        boolean z = ref$IntRef.element > 0;
                        if (thumbNode.isPressed != z) {
                            thumbNode.isPressed = z;
                            LayoutModifierNodeKt.invalidateMeasurement(thumbNode);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (interactions.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        float fM4288getPressedHandleWidthD9Ej5fM;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        boolean z = (measurable.maxIntrinsicHeight(Constraints.m2530getMaxWidthimpl(j)) == 0 || measurable.maxIntrinsicWidth(Constraints.m2529getMaxHeightimpl(j)) == 0) ? false : true;
        if (this.isPressed) {
            fM4288getPressedHandleWidthD9Ej5fM = SwitchTokens.INSTANCE.m4288getPressedHandleWidthD9Ej5fM();
        } else {
            fM4288getPressedHandleWidthD9Ej5fM = (z || this.checked) ? SwitchKt.ThumbDiameter : SwitchKt.UncheckedThumbDiameter;
        }
        float fMo231toPx0680j_4 = measure.mo231toPx0680j_4(fM4288getPressedHandleWidthD9Ej5fM);
        Animatable animatable = this.sizeAnim;
        int iFloatValue = (int) (animatable != null ? ((Number) animatable.getValue()).floatValue() : fMo231toPx0680j_4);
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(Constraints.Companion.m2539fixedJhjzzOo(iFloatValue, iFloatValue));
        final float fMo231toPx0680j_5 = measure.mo231toPx0680j_4(Dp.m2551constructorimpl(Dp.m2551constructorimpl(SwitchKt.SwitchHeight - measure.mo227toDpu2uoSUM(fMo231toPx0680j_4)) / 2.0f));
        float fMo231toPx0680j_6 = measure.mo231toPx0680j_4(Dp.m2551constructorimpl(Dp.m2551constructorimpl(SwitchKt.SwitchWidth - SwitchKt.ThumbDiameter) - SwitchKt.ThumbPadding));
        boolean z2 = this.isPressed;
        if (z2 && this.checked) {
            fMo231toPx0680j_5 = fMo231toPx0680j_6 - measure.mo231toPx0680j_4(SwitchTokens.INSTANCE.m4292getTrackOutlineWidthD9Ej5fM());
        } else if (z2 && !this.checked) {
            fMo231toPx0680j_5 = measure.mo231toPx0680j_4(SwitchTokens.INSTANCE.m4292getTrackOutlineWidthD9Ej5fM());
        } else if (this.checked) {
            fMo231toPx0680j_5 = fMo231toPx0680j_6;
        }
        Animatable animatable2 = this.sizeAnim;
        if (!Intrinsics.areEqual(animatable2 != null ? (Float) animatable2.getTargetValue() : null, fMo231toPx0680j_4)) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, fMo231toPx0680j_4, null), 3, null);
        }
        Animatable animatable3 = this.offsetAnim;
        if (!Intrinsics.areEqual(animatable3 != null ? (Float) animatable3.getTargetValue() : null, fMo231toPx0680j_5)) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$2(this, fMo231toPx0680j_5, null), 3, null);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = fMo231toPx0680j_4;
            this.initialOffset = fMo231toPx0680j_5;
        }
        return MeasureScope.layout$default(measure, iFloatValue, iFloatValue, null, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$measure$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable = placeableMo1843measureBRTryo0;
                Animatable animatable4 = this.offsetAnim;
                Placeable.PlacementScope.placeRelative$default(layout, placeable, (int) (animatable4 != null ? ((Number) animatable4.getValue()).floatValue() : fMo231toPx0680j_5), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void update() {
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, 0.0f, 2, null);
        }
        if (this.offsetAnim != null || Float.isNaN(this.initialOffset)) {
            return;
        }
        this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, 0.0f, 2, null);
    }
}
