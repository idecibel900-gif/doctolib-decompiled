package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    private final DrawStyle drawStyle;

    public DrawStyleSpan(DrawStyle drawStyle) {
        this.drawStyle = drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
                textPaint.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
                textPaint.setStrokeJoin(m2405toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).m1604getJoinLxFBmk8()));
                textPaint.setStrokeCap(m2404toAndroidCapBeK7IIE(((Stroke) this.drawStyle).m1603getCapKaPHkGw()));
                ((Stroke) this.drawStyle).getPathEffect();
                textPaint.setPathEffect(null);
            }
        }
    }

    /* JADX INFO: renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    private final Paint.Join m2405toAndroidJoinWw9F2mQ(int i) {
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        if (StrokeJoin.m1504equalsimpl0(i, companion.m1508getMiterLxFBmk8())) {
            return Paint.Join.MITER;
        }
        if (StrokeJoin.m1504equalsimpl0(i, companion.m1509getRoundLxFBmk8())) {
            return Paint.Join.ROUND;
        }
        return StrokeJoin.m1504equalsimpl0(i, companion.m1507getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    /* JADX INFO: renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    private final Paint.Cap m2404toAndroidCapBeK7IIE(int i) {
        StrokeCap.Companion companion = StrokeCap.Companion;
        if (StrokeCap.m1497equalsimpl0(i, companion.m1500getButtKaPHkGw())) {
            return Paint.Cap.BUTT;
        }
        if (StrokeCap.m1497equalsimpl0(i, companion.m1501getRoundKaPHkGw())) {
            return Paint.Cap.ROUND;
        }
        return StrokeCap.m1497equalsimpl0(i, companion.m1502getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }
}
