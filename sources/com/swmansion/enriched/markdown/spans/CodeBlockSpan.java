package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.CodeBlockStyle;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeBlockSpan extends MetricAffectingSpan implements LineBackgroundSpan, LeadingMarginSpan {
    public static final Companion Companion = new Companion(null);
    private static final Paint sharedBackgroundPaint;
    private static final Paint sharedBorderPaint;
    private final RectF arcRect;
    private final CodeBlockStyle codeBlockStyle;
    private final Context context;
    private final int leadingIndent;
    private final Path path;
    private final float[] radiiArray;
    private final RectF rect;
    private final SpanStyleCache styleCache;

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
    }

    public CodeBlockSpan(CodeBlockStyle codeBlockStyle, Context context, SpanStyleCache styleCache, int i) {
        Intrinsics.checkNotNullParameter(codeBlockStyle, "codeBlockStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        this.codeBlockStyle = codeBlockStyle;
        this.context = context;
        this.styleCache = styleCache;
        this.leadingIndent = i;
        this.path = new Path();
        this.rect = new RectF();
        this.arcRect = new RectF();
        this.radiiArray = new float[8];
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        sharedBackgroundPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.BUTT);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        sharedBorderPaint = paint2;
    }

    private final Paint configureBackgroundPaint() {
        Paint paint = sharedBackgroundPaint;
        paint.setColor(this.codeBlockStyle.getBackgroundColor());
        return paint;
    }

    private final Paint configureBorderPaint() {
        Paint paint = sharedBorderPaint;
        paint.setStrokeWidth(this.codeBlockStyle.getBorderWidth());
        paint.setColor(this.codeBlockStyle.getBorderColor());
        return paint;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return ((int) this.codeBlockStyle.getPadding()) + this.leadingIndent;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyTextStyle(tp);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyTextStyle(tp);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint p, int i, int i2, int i3, int i4, int i5, CharSequence text, int i6, int i7, int i8) throws Throwable {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(text instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) text;
        int spanStart = spanned.getSpanStart(this);
        int spanEnd = spanned.getSpanEnd(this);
        if (spanStart < 0 || spanStart >= spanEnd) {
            return;
        }
        boolean z = i6 == spanStart;
        boolean z2 = i7 == spanEnd || (spanEnd <= i7 && (spanEnd == text.length() || text.charAt(spanEnd - 1) == '\n'));
        float borderWidth = this.codeBlockStyle.getBorderWidth() / 2.0f;
        this.rect.set(i + this.leadingIndent + borderWidth, i3 + (z ? borderWidth : 0.0f), i2 - borderWidth, i5 - (z2 ? borderWidth : 0.0f));
        RectF rectF = this.rect;
        if (rectF.left >= rectF.right) {
            return;
        }
        float borderRadius = this.codeBlockStyle.getBorderRadius();
        if (borderRadius > borderWidth) {
            borderRadius -= borderWidth;
        }
        ArraysKt.fill$default(this.radiiArray, 0.0f, 0, 0, 6, (Object) null);
        if (z) {
            float[] fArr = this.radiiArray;
            fArr[0] = borderRadius;
            fArr[1] = borderRadius;
            fArr[2] = borderRadius;
            fArr[3] = borderRadius;
        }
        if (z2) {
            float[] fArr2 = this.radiiArray;
            fArr2[4] = borderRadius;
            fArr2[5] = borderRadius;
            fArr2[6] = borderRadius;
            fArr2[7] = borderRadius;
        }
        this.path.reset();
        this.path.addRoundRect(this.rect, this.radiiArray, Path.Direction.CW);
        Paint paintConfigureBackgroundPaint = configureBackgroundPaint();
        Paint paintConfigureBorderPaint = configureBorderPaint();
        int iSave = canvas.save();
        try {
            canvas.drawPath(this.path, paintConfigureBackgroundPaint);
            if (this.codeBlockStyle.getBorderWidth() > 0.0f) {
                RectF rectF2 = this.rect;
                float f = rectF2.left;
                float f2 = rectF2.right;
                float f3 = rectF2.top;
                float f4 = rectF2.bottom;
                try {
                    if (z && z2) {
                        canvas.drawPath(this.path, paintConfigureBorderPaint);
                    } else if (z) {
                        canvas.drawLine(f + borderRadius, f3, f2 - borderRadius, f3, paintConfigureBorderPaint);
                        float f5 = f3 + borderRadius;
                        canvas.drawLine(f, f5, f, f4, paintConfigureBorderPaint);
                        canvas.drawLine(f2, f5, f2, f4, paintConfigureBorderPaint);
                        float f6 = 2 * borderRadius;
                        float f7 = f3 + f6;
                        this.arcRect.set(f, f3, f + f6, f7);
                        canvas.drawArc(this.arcRect, 180.0f, 90.0f, false, paintConfigureBorderPaint);
                        this.arcRect.set(f2 - f6, f3, f2, f7);
                        canvas.drawArc(this.arcRect, 270.0f, 90.0f, false, paintConfigureBorderPaint);
                    } else if (z2) {
                        canvas.drawLine(f + borderRadius, f4, f2 - borderRadius, f4, paintConfigureBorderPaint);
                        float f8 = f4 - borderRadius;
                        canvas.drawLine(f, f3, f, f8, paintConfigureBorderPaint);
                        canvas.drawLine(f2, f3, f2, f8, paintConfigureBorderPaint);
                        float f9 = 2 * borderRadius;
                        float f10 = f4 - f9;
                        this.arcRect.set(f, f10, f + f9, f4);
                        canvas.drawArc(this.arcRect, 90.0f, 90.0f, false, paintConfigureBorderPaint);
                        this.arcRect.set(f2 - f9, f10, f2, f4);
                        canvas.drawArc(this.arcRect, 0.0f, 90.0f, false, paintConfigureBorderPaint);
                    } else {
                        canvas.drawLine(f, f3, f, f4, paintConfigureBorderPaint);
                        canvas.drawLine(f2, f3, f2, f4, paintConfigureBorderPaint);
                    }
                } catch (Throwable th) {
                    th = th;
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            }
            canvas.restoreToCount(iSave);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void applyTextStyle(TextPaint textPaint) {
        TextPaintExtensionsKt.applyCodeBlockTextStyle(textPaint, this.codeBlockStyle, this.context);
        int color = this.codeBlockStyle.getColor();
        int[] colorsToPreserve = this.styleCache.getColorsToPreserve();
        TextPaintExtensionsKt.applyColorPreserving(textPaint, color, Arrays.copyOf(colorsToPreserve, colorsToPreserve.length));
    }
}
