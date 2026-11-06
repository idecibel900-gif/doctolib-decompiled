package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public interface GraphicsLayerImpl {
    public static final Companion Companion = Companion.$$INSTANCE;

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas canvas);

    float getAlpha();

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo1626getAmbientShadowColor0d7_KjU();

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int mo1627getBlendMode0nO6VwU();

    float getCameraDistance();

    boolean getClip();

    ColorFilter getColorFilter();

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    int mo1628getCompositingStrategyke2Ky5w();

    default boolean getHasDisplayList() {
        return true;
    }

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo1629getSpotShadowColor0d7_KjU();

    float getTranslationX();

    float getTranslationY();

    void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1);

    void setAlpha(float f);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo1630setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    void mo1631setCompositingStrategyWpw9cng(int i);

    void setInvalidated(boolean z);

    void setOutline(Outline outline);

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    void mo1632setPivotOffsetk4lQ0M(long j);

    /* JADX INFO: renamed from: setPosition-H0pRuoY, reason: not valid java name */
    void mo1633setPositionH0pRuoY(int i, int i2, long j);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo1634setSpotShadowColor8_81llA(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function1 DefaultDrawBlock = new Function1() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                DrawScope.m1595drawRectnJ9OG0$default(drawScope, Color.Companion.m1384getTransparent0d7_KjU(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
            }
        };

        private Companion() {
        }

        public final Function1 getDefaultDrawBlock() {
            return DefaultDrawBlock;
        }
    }
}
