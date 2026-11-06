package com.swmansion.enriched.markdown.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.swmansion.enriched.markdown.styles.CodeStyle;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeBackgroundSpan implements LineBackgroundSpan {
    public static final Companion Companion = new Companion(null);
    private static final Paint sharedBackgroundPaint;
    private static final Paint sharedBorderPaint;
    private final Path path;
    private final RectF rect;
    private final StyleConfig styleConfig;

    public CodeBackgroundSpan(StyleConfig styleConfig) {
        Intrinsics.checkNotNullParameter(styleConfig, "styleConfig");
        this.styleConfig = styleConfig;
        this.rect = new RectF();
        this.path = new Path();
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
        paint2.setStrokeWidth(1.0f);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        sharedBorderPaint = paint2;
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint p, int i, int i2, int i3, int i4, int i5, CharSequence text, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(text, "text");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            int spanStart = spanned.getSpanStart(this);
            int spanEnd = spanned.getSpanEnd(this);
            if (spanStart < 0 || spanStart >= spanEnd) {
                return;
            }
            boolean z = spanStart >= i6;
            boolean z2 = spanEnd <= i7;
            int iAdjustBottomForMargin = adjustBottomForMargin(spanned, i7, i5);
            int iLeadingMarginAt = leadingMarginAt(spanned, i6);
            float horizontalOffset = z ? getHorizontalOffset(text, i6, i7, spanStart, p, iLeadingMarginAt) + i : i + iLeadingMarginAt;
            float horizontalOffset2 = z2 ? getHorizontalOffset(text, i6, i7, spanEnd, p, iLeadingMarginAt) + i : i2;
            this.rect.set(Math.min(horizontalOffset, horizontalOffset2), i3, Math.max(horizontalOffset, horizontalOffset2), iAdjustBottomForMargin);
            CodeStyle codeStyle = this.styleConfig.getCodeStyle();
            sharedBackgroundPaint.setColor(codeStyle.getBackgroundColor());
            sharedBorderPaint.setColor(codeStyle.getBorderColor());
            drawShapes(canvas, z, z2);
        }
    }

    private final float getHorizontalOffset(CharSequence charSequence, int i, int i2, int i3, Paint paint, int i4) {
        if (i3 <= i) {
            return i4;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        TextPaint textPaint = paint instanceof TextPaint ? (TextPaint) paint : null;
        if (textPaint == null) {
            textPaint = new TextPaint(paint);
        }
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(charSequenceSubSequence, 0, charSequenceSubSequence.length(), textPaint, ColorExtractionConstants.MAX_PIXEL_SAMPLES).build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        return staticLayoutBuild.getPrimaryHorizontal(i3 - i);
    }

    private final void drawShapes(Canvas canvas, boolean z, boolean z2) {
        float[] fArrCreateRadii = createRadii(z, z2);
        this.path.reset();
        this.path.addRoundRect(this.rect, fArrCreateRadii, Path.Direction.CW);
        canvas.drawPath(this.path, sharedBackgroundPaint);
        if (z && z2) {
            canvas.drawPath(this.path, sharedBorderPaint);
        } else {
            drawOpenBorders(canvas, z, z2);
        }
    }

    private final void drawOpenBorders(Canvas canvas, boolean z, boolean z2) {
        this.path.reset();
        if (z) {
            Path path = this.path;
            RectF rectF = this.rect;
            path.moveTo(rectF.right, rectF.top);
            Path path2 = this.path;
            RectF rectF2 = this.rect;
            path2.lineTo(rectF2.left + 6.0f, rectF2.top);
            Path path3 = this.path;
            RectF rectF3 = this.rect;
            float f = rectF3.left;
            float f2 = rectF3.top;
            path3.quadTo(f, f2, f, f2 + 6.0f);
            Path path4 = this.path;
            RectF rectF4 = this.rect;
            path4.lineTo(rectF4.left, rectF4.bottom - 6.0f);
            Path path5 = this.path;
            RectF rectF5 = this.rect;
            float f3 = rectF5.left;
            float f4 = rectF5.bottom;
            path5.quadTo(f3, f4, 6.0f + f3, f4);
            Path path6 = this.path;
            RectF rectF6 = this.rect;
            path6.lineTo(rectF6.right, rectF6.bottom);
        } else if (z2) {
            Path path7 = this.path;
            RectF rectF7 = this.rect;
            path7.moveTo(rectF7.left, rectF7.top);
            Path path8 = this.path;
            RectF rectF8 = this.rect;
            path8.lineTo(rectF8.right - 6.0f, rectF8.top);
            Path path9 = this.path;
            RectF rectF9 = this.rect;
            float f5 = rectF9.right;
            float f6 = rectF9.top;
            path9.quadTo(f5, f6, f5, f6 + 6.0f);
            Path path10 = this.path;
            RectF rectF10 = this.rect;
            path10.lineTo(rectF10.right, rectF10.bottom - 6.0f);
            Path path11 = this.path;
            RectF rectF11 = this.rect;
            float f7 = rectF11.right;
            float f8 = rectF11.bottom;
            path11.quadTo(f7, f8, f7 - 6.0f, f8);
            Path path12 = this.path;
            RectF rectF12 = this.rect;
            path12.lineTo(rectF12.left, rectF12.bottom);
        } else {
            Path path13 = this.path;
            RectF rectF13 = this.rect;
            path13.moveTo(rectF13.left, rectF13.top);
            Path path14 = this.path;
            RectF rectF14 = this.rect;
            path14.lineTo(rectF14.right, rectF14.top);
            Path path15 = this.path;
            RectF rectF15 = this.rect;
            path15.moveTo(rectF15.left, rectF15.bottom);
            Path path16 = this.path;
            RectF rectF16 = this.rect;
            path16.lineTo(rectF16.right, rectF16.bottom);
        }
        canvas.drawPath(this.path, sharedBorderPaint);
    }

    private final float[] createRadii(boolean z, boolean z2) {
        if (z && z2) {
            return new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f};
        }
        if (z) {
            return new float[]{6.0f, 6.0f, 0.0f, 0.0f, 0.0f, 0.0f, 6.0f, 6.0f};
        }
        if (z2) {
            return new float[]{0.0f, 0.0f, 6.0f, 6.0f, 6.0f, 6.0f, 0.0f, 0.0f};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private final int leadingMarginAt(Spanned spanned, int i) {
        if (i >= spanned.length()) {
            return 0;
        }
        Iterator it = ArrayIteratorKt.iterator((LeadingMarginSpan[]) spanned.getSpans(i, i + 1, LeadingMarginSpan.class));
        int leadingMargin = 0;
        while (it.hasNext()) {
            leadingMargin += ((LeadingMarginSpan) it.next()).getLeadingMargin(false);
        }
        return leadingMargin;
    }

    private final int adjustBottomForMargin(Spanned spanned, int i, int i2) {
        if (i > 0 && i <= spanned.length()) {
            int i3 = i - 1;
            if (spanned.charAt(i3) == '\n') {
                Iterator it = ArrayIteratorKt.iterator((MarginBottomSpan[]) spanned.getSpans(i3, i, MarginBottomSpan.class));
                while (it.hasNext()) {
                    MarginBottomSpan marginBottomSpan = (MarginBottomSpan) it.next();
                    if (spanned.getSpanEnd(marginBottomSpan) == i) {
                        i2 -= (int) marginBottomSpan.getMarginBottom();
                    }
                }
            }
        }
        return i2;
    }
}
