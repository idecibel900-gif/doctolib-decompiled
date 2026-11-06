package androidx.constraintlayout.compose;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintLayoutKt {
    private static final boolean DEBUG = false;

    public static final void buildMapping(State state, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list.get(i);
            Object layoutId = LayoutIdKt.getLayoutId(measurable);
            if (layoutId == null && (layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable)) == null) {
                layoutId = createId();
            }
            state.map(layoutId.toString(), measurable);
            Object constraintLayoutTag = ConstraintLayoutTagKt.getConstraintLayoutTag(measurable);
            if (constraintLayoutTag != null && (constraintLayoutTag instanceof String) && (layoutId instanceof String)) {
                state.setTag((String) layoutId, (String) constraintLayoutTag);
            }
        }
    }

    public static final Object createId() {
        return new Object() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt.createId.1
        };
    }

    /* JADX INFO: renamed from: placeWithFrameTransform-Ktjjmr4$default, reason: not valid java name */
    public static /* synthetic */ void m2687placeWithFrameTransformKtjjmr4$default(Placeable.PlacementScope placementScope, Placeable placeable, WidgetFrame widgetFrame, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntOffset.Companion.m2598getZeronOccac();
        }
        m2686placeWithFrameTransformKtjjmr4(placementScope, placeable, widgetFrame, j);
    }

    /* JADX INFO: renamed from: placeWithFrameTransform-Ktjjmr4, reason: not valid java name */
    public static final void m2686placeWithFrameTransformKtjjmr4(Placeable.PlacementScope placementScope, Placeable placeable, final WidgetFrame widgetFrame, long j) {
        if (widgetFrame.visibility == 8) {
            if (DEBUG) {
                widgetFrame.getId();
            }
        } else if (widgetFrame.isDefaultTransform()) {
            Placeable.PlacementScope.m1865place70tqf50$default(placementScope, placeable, IntOffsetKt.IntOffset(widgetFrame.left - IntOffset.m2591getXimpl(j), widgetFrame.top - IntOffset.m2592getYimpl(j)), 0.0f, 2, null);
        } else {
            placementScope.placeWithLayer(placeable, widgetFrame.left - IntOffset.m2591getXimpl(j), widgetFrame.top - IntOffset.m2592getYimpl(j), Float.isNaN(widgetFrame.translationZ) ? 0.0f : widgetFrame.translationZ, new Function1() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$placeWithFrameTransform$layerBlock$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((GraphicsLayerScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                    if (!Float.isNaN(widgetFrame.pivotX) || !Float.isNaN(widgetFrame.pivotY)) {
                        graphicsLayerScope.mo1419setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(Float.isNaN(widgetFrame.pivotX) ? 0.5f : widgetFrame.pivotX, Float.isNaN(widgetFrame.pivotY) ? 0.5f : widgetFrame.pivotY));
                    }
                    if (!Float.isNaN(widgetFrame.rotationX)) {
                        graphicsLayerScope.setRotationX(widgetFrame.rotationX);
                    }
                    if (!Float.isNaN(widgetFrame.rotationY)) {
                        graphicsLayerScope.setRotationY(widgetFrame.rotationY);
                    }
                    if (!Float.isNaN(widgetFrame.rotationZ)) {
                        graphicsLayerScope.setRotationZ(widgetFrame.rotationZ);
                    }
                    if (!Float.isNaN(widgetFrame.translationX)) {
                        graphicsLayerScope.setTranslationX(widgetFrame.translationX);
                    }
                    if (!Float.isNaN(widgetFrame.translationY)) {
                        graphicsLayerScope.setTranslationY(widgetFrame.translationY);
                    }
                    if (!Float.isNaN(widgetFrame.translationZ)) {
                        graphicsLayerScope.setShadowElevation(widgetFrame.translationZ);
                    }
                    if (!Float.isNaN(widgetFrame.scaleX) || !Float.isNaN(widgetFrame.scaleY)) {
                        graphicsLayerScope.setScaleX(Float.isNaN(widgetFrame.scaleX) ? 1.0f : widgetFrame.scaleX);
                        graphicsLayerScope.setScaleY(Float.isNaN(widgetFrame.scaleY) ? 1.0f : widgetFrame.scaleY);
                    }
                    if (Float.isNaN(widgetFrame.alpha)) {
                        return;
                    }
                    graphicsLayerScope.setAlpha(widgetFrame.alpha);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDebugString(ConstraintWidget constraintWidget) {
        return constraintWidget.getDebugName() + " width " + constraintWidget.getWidth() + " minWidth " + constraintWidget.getMinWidth() + " maxWidth " + constraintWidget.getMaxWidth() + " height " + constraintWidget.getHeight() + " minHeight " + constraintWidget.getMinHeight() + " maxHeight " + constraintWidget.getMaxHeight() + " HDB " + constraintWidget.getHorizontalDimensionBehaviour() + " VDB " + constraintWidget.getVerticalDimensionBehaviour() + " MCW " + constraintWidget.mMatchConstraintDefaultWidth + " MCH " + constraintWidget.mMatchConstraintDefaultHeight + " percentW " + constraintWidget.mMatchConstraintPercentWidth + " percentH " + constraintWidget.mMatchConstraintPercentHeight;
    }
}
