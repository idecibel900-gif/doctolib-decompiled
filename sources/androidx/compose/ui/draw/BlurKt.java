package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m1128blur1fqSgw(Modifier modifier, final float f, final float f2, final Shape shape) {
        int iM1515getDecal3opZhB0;
        final boolean z;
        if (shape != null) {
            iM1515getDecal3opZhB0 = TileMode.Companion.m1514getClamp3opZhB0();
            z = true;
        } else {
            iM1515getDecal3opZhB0 = TileMode.Companion.m1515getDecal3opZhB0();
            z = false;
        }
        final int i = iM1515getDecal3opZhB0;
        float f3 = 0;
        return ((Dp.m2550compareTo0680j_4(f, Dp.m2551constructorimpl(f3)) <= 0 || Dp.m2550compareTo0680j_4(f2, Dp.m2551constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                float fMo231toPx0680j_4 = graphicsLayerScope.mo231toPx0680j_4(f);
                float fMo231toPx0680j_5 = graphicsLayerScope.mo231toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((fMo231toPx0680j_4 <= 0.0f || fMo231toPx0680j_5 <= 0.0f) ? null : RenderEffectKt.m1475BlurEffect3YTHUZs(fMo231toPx0680j_4, fMo231toPx0680j_5, i));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1130blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1131boximpl(BlurredEdgeTreatment.Companion.m1137getRectangleGoahg());
        }
        return m1129blurF8QBwvs(modifier, f, blurredEdgeTreatment.m1136unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m1129blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        return m1128blur1fqSgw(modifier, f, f, shape);
    }
}
