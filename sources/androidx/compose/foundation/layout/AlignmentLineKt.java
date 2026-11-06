package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AlignmentLineKt {
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m272paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m271paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m271paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set("before", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("after", Dp.m2549boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m273paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier modifierM272paddingFrom4j6BHR0$default;
        Modifier modifierM272paddingFrom4j6BHR0$default2;
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m2553equalsimpl0(f, companion.m2560getUnspecifiedD9Ej5fM())) {
            modifierM272paddingFrom4j6BHR0$default = m272paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            modifierM272paddingFrom4j6BHR0$default = Modifier.Companion;
        }
        Modifier modifierThen = modifier.then(modifierM272paddingFrom4j6BHR0$default);
        if (!Dp.m2553equalsimpl0(f2, companion.m2560getUnspecifiedD9Ej5fM())) {
            modifierM272paddingFrom4j6BHR0$default2 = m272paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            modifierM272paddingFrom4j6BHR0$default2 = Modifier.Companion;
        }
        return modifierThen.then(modifierM272paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m270alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int iMax;
        int height;
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m2522copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m2522copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo1843measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? placeableMo1843measureBRTryo0.getHeight() : placeableMo1843measureBRTryo0.getWidth();
        int iM2529getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m2529getMaxHeightimpl(j) : Constraints.m2530getMaxWidthimpl(j);
        Dp.Companion companion = Dp.Companion;
        int i2 = iM2529getMaxHeightimpl - height2;
        final int iCoerceIn = RangesKt.coerceIn((!Dp.m2553equalsimpl0(f, companion.m2560getUnspecifiedD9Ej5fM()) ? measureScope.mo225roundToPx0680j_4(f) : 0) - i, 0, i2);
        final int iCoerceIn2 = RangesKt.coerceIn(((!Dp.m2553equalsimpl0(f2, companion.m2560getUnspecifiedD9Ej5fM()) ? measureScope.mo225roundToPx0680j_4(f2) : 0) - height2) + i, 0, i2 - iCoerceIn);
        if (getHorizontal(alignmentLine)) {
            iMax = placeableMo1843measureBRTryo0.getWidth();
        } else {
            iMax = Math.max(placeableMo1843measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m2532getMinWidthimpl(j));
        }
        if (getHorizontal(alignmentLine)) {
            height = Math.max(placeableMo1843measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m2531getMinHeightimpl(j));
        } else {
            height = placeableMo1843measureBRTryo0.getHeight();
        }
        final int i3 = height;
        final int i4 = iMax;
        return MeasureScope.layout$default(measureScope, i4, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
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
                int width;
                int height3 = 0;
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    width = 0;
                } else {
                    width = !Dp.m2553equalsimpl0(f, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i4 - iCoerceIn2) - placeableMo1843measureBRTryo0.getWidth();
                }
                if (AlignmentLineKt.getHorizontal(alignmentLine)) {
                    height3 = !Dp.m2553equalsimpl0(f, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? iCoerceIn : (i3 - iCoerceIn2) - placeableMo1843measureBRTryo0.getHeight();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1843measureBRTryo0, width, height3, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }
}
