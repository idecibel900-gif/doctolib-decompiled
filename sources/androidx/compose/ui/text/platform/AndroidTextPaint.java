package androidx.compose.ui.text.platform;

import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private State shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.textDecoration = TextDecoration.Companion.getNone();
        this.backingBlendMode = DrawScope.Companion.m1600getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.Companion.getNone();
    }

    private final Paint getComposePaint() {
        Paint paint = this.backingComposePaint;
        if (paint != null) {
            return paint;
        }
        Paint paintAsComposePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = paintAsComposePaint;
        return paintAsComposePaint;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.Companion;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.Companion.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m1223getXimpl(this.shadow.m1486getOffsetF1C5BW0()), Offset.m1224getYimpl(this.shadow.m1486getOffsetF1C5BW0()), ColorKt.m1393toArgb8_81llA(this.shadow.m1485getColor0d7_KjU()));
        }
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m2393setColor8_81llA(long j) {
        if (j != 16) {
            setColor(ColorKt.m1393toArgb8_81llA(j));
            clearShader();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    public final void m2392setBrush12SF9DM(final Brush brush, final long j, float f) {
        if (brush == null) {
            clearShader();
            return;
        }
        if (brush instanceof SolidColor) {
            m2393setColor8_81llA(TextDrawStyleKt.m2501modulateDxMtmZc(((SolidColor) brush).m1495getValue0d7_KjU(), f));
            return;
        }
        if (brush instanceof ShaderBrush) {
            if (Intrinsics.areEqual(this.brush, brush)) {
                Size size = this.brushSize;
                if (!(size == null ? false : Size.m1258equalsimpl0(size.m1265unboximpl(), j))) {
                    if (j != 9205357640488583168L) {
                        this.brush = brush;
                        this.brushSize = Size.m1255boximpl(j);
                        this.shaderState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Shader invoke() {
                                return ((ShaderBrush) brush).mo1352createShaderuvyYCjk(j);
                            }
                        });
                    }
                }
            } else {
                if (j != 9205357640488583168L) {
                    this.brush = brush;
                    this.brushSize = Size.m1255boximpl(j);
                    this.shaderState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Shader invoke() {
                            return ((ShaderBrush) brush).mo1352createShaderuvyYCjk(j);
                        }
                    });
                }
            }
            Paint composePaint = getComposePaint();
            State state = this.shaderState;
            composePaint.setShader(state != null ? (Shader) state.getValue() : null);
            AndroidTextPaint_androidKt.setAlpha(this, f);
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            setStyle(android.graphics.Paint.Style.FILL);
            return;
        }
        if (drawStyle instanceof Stroke) {
            getComposePaint().mo1296setStylek9PVt8s(PaintingStyle.Companion.m1462getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            getComposePaint().setStrokeWidth(stroke.getWidth());
            getComposePaint().setStrokeMiterLimit(stroke.getMiter());
            getComposePaint().mo1295setStrokeJoinWw9F2mQ(stroke.m1604getJoinLxFBmk8());
            getComposePaint().mo1294setStrokeCapBeK7IIE(stroke.m1603getCapKaPHkGw());
            Paint composePaint = getComposePaint();
            stroke.getPathEffect();
            composePaint.setPathEffect(null);
        }
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m2390getBlendMode0nO6VwU() {
        return this.backingBlendMode;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m2391setBlendModes9anfk8(int i) {
        if (BlendMode.m1313equalsimpl0(i, this.backingBlendMode)) {
            return;
        }
        getComposePaint().mo1291setBlendModes9anfk8(i);
        this.backingBlendMode = i;
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }
}
