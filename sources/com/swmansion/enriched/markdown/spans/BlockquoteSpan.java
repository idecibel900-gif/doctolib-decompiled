package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.BlockquoteStyle;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockquoteSpan extends MetricAffectingSpan implements LeadingMarginSpan, LineBackgroundSpan {
    public static final Companion Companion = new Companion(null);
    private static final Paint sharedBackgroundPaint;
    private static final Paint sharedBorderPaint;
    private final BlockStyle blockStyle;
    private final BlockquoteStyle blockquoteStyle;
    private float boxLeft;
    private float boxRight;
    private Map cachedSpansByPosition;
    private CharSequence cachedText;
    private final Context context;
    private final int depth;
    private final float levelSpacing;
    private final Path path;
    private final float[] radiiArray;
    private final RectF rect;
    private final SpanStyleCache styleCache;

    public final int getDepth() {
        return this.depth;
    }

    public BlockquoteSpan(BlockquoteStyle blockquoteStyle, int i, Context context, SpanStyleCache styleCache) {
        Intrinsics.checkNotNullParameter(blockquoteStyle, "blockquoteStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        this.blockquoteStyle = blockquoteStyle;
        this.depth = i;
        this.context = context;
        this.styleCache = styleCache;
        this.levelSpacing = blockquoteStyle.getBorderWidth() + blockquoteStyle.getGapWidth();
        this.blockStyle = new BlockStyle(blockquoteStyle.getFontSize(), blockquoteStyle.getFontFamily(), blockquoteStyle.getFontWeight(), blockquoteStyle.getColor());
        this.cachedSpansByPosition = new LinkedHashMap();
        this.path = new Path();
        this.rect = new RectF();
        this.radiiArray = new float[8];
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

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return (int) this.levelSpacing;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) throws Throwable {
        Canvas canvas;
        int i8;
        Spanned spanned;
        BlockquoteSpan blockquoteSpan;
        BlockquoteSpan blockquoteSpan2;
        Canvas canvas2;
        float f;
        float f2;
        BlockquoteSpan blockquoteSpan3;
        Spanned spanned2;
        int i9 = i6;
        int i10 = i7;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        if (shouldSkipDrawing(charSequence, i9)) {
            return;
        }
        Paint paintConfigureBorderPaint = configureBorderPaint();
        float borderRadius = this.blockquoteStyle.getBorderRadius();
        Spanned spanned3 = charSequence instanceof Spanned ? (Spanned) charSequence : null;
        if (spanned3 == null) {
            drawBorders(c, i, i2, i3, i5, paintConfigureBorderPaint);
            return;
        }
        BlockquoteSpan blockquoteSpan4 = this;
        BlockquoteSpan blockquoteSpanSpanAtMinDepth = blockquoteSpan4.spanAtMinDepth(spanned3, i9);
        float f3 = 0.0f;
        int i11 = (borderRadius > 0.0f ? 1 : (borderRadius == 0.0f ? 0 : -1));
        boolean z2 = i11 > 0 && blockquoteSpan4.boxRight > blockquoteSpan4.boxLeft && blockquoteSpanSpanAtMinDepth != null && blockquoteSpan4.isBoundaryLine(spanned3, i9, i10, blockquoteSpanSpanAtMinDepth);
        float padding = blockquoteSpan4.blockquoteStyle.getPadding();
        int i12 = blockquoteSpan4.depth;
        if (i12 < 0) {
            return;
        }
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i13 = 0;
        while (true) {
            float f6 = f3;
            float f7 = i2;
            float f8 = i + (blockquoteSpan4.levelSpacing * i13 * f7);
            float borderWidth = (blockquoteSpan4.blockquoteStyle.getBorderWidth() * f7) + f8;
            float fMin = Math.min(f8, borderWidth);
            float fMax = Math.max(f8, borderWidth);
            float f9 = i3;
            float f10 = f9 + f4;
            float f11 = i5;
            float f12 = f11 - f5;
            BlockquoteSpan blockquoteSpanSpanAtDepth = i13 == 0 ? blockquoteSpanSpanAtMinDepth : blockquoteSpan4.spanAtDepth(spanned3, i9, i13);
            boolean z3 = i11 > 0 && i13 > 0 && blockquoteSpanSpanAtDepth != null && blockquoteSpan4.isBoundaryLine(spanned3, i9, i10, blockquoteSpanSpanAtDepth);
            if (!z2 && !z3) {
                c.drawRect(fMin, f10, fMax, f12, paintConfigureBorderPaint);
                blockquoteSpan2 = blockquoteSpanSpanAtMinDepth;
                blockquoteSpan3 = blockquoteSpanSpanAtDepth;
                spanned2 = spanned3;
            } else {
                Spanned spanned4 = spanned3;
                Paint paint = paintConfigureBorderPaint;
                BlockquoteSpan blockquoteSpan5 = blockquoteSpanSpanAtDepth;
                int iSave = c.save();
                if (z2) {
                    try {
                        Intrinsics.checkNotNull(blockquoteSpanSpanAtMinDepth);
                        spanned = spanned4;
                        BlockquoteSpan blockquoteSpan6 = blockquoteSpanSpanAtMinDepth;
                        canvas = c;
                        i8 = iSave;
                        blockquoteSpan = blockquoteSpan4;
                        try {
                            blockquoteSpan.buildBoundaryPath(spanned, i6, i10, blockquoteSpan6, blockquoteSpan4.boxLeft, f9, blockquoteSpan4.boxRight, f11);
                            blockquoteSpan2 = blockquoteSpan6;
                            canvas.clipPath(blockquoteSpan.path);
                        } catch (Throwable th) {
                            th = th;
                            canvas2 = canvas;
                            canvas2.restoreToCount(i8);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        canvas = c;
                        i8 = iSave;
                    }
                } else {
                    spanned = spanned4;
                    i8 = iSave;
                    blockquoteSpan = blockquoteSpan4;
                    blockquoteSpan2 = blockquoteSpanSpanAtMinDepth;
                    canvas = c;
                }
                if (z3) {
                    float f13 = i2 >= 0 ? fMin : blockquoteSpan.boxLeft;
                    float f14 = i2 >= 0 ? blockquoteSpan.boxRight : fMax;
                    Intrinsics.checkNotNull(blockquoteSpan5);
                    blockquoteSpan.buildBoundaryPath(spanned, i6, i7, blockquoteSpan5, f13, f10, f14, f12);
                    i9 = i6;
                    blockquoteSpan5 = blockquoteSpan5;
                    f = f10;
                    f2 = f12;
                    blockquoteSpan4 = blockquoteSpan;
                    i10 = i7;
                    try {
                        canvas.clipPath(blockquoteSpan4.path);
                    } catch (Throwable th3) {
                        th = th3;
                        canvas2 = canvas;
                        canvas2.restoreToCount(i8);
                        throw th;
                    }
                } else {
                    i9 = i6;
                    i10 = i7;
                    blockquoteSpan4 = blockquoteSpan;
                    f = f10;
                    f2 = f12;
                }
                canvas2 = canvas;
                blockquoteSpan3 = blockquoteSpan5;
                paintConfigureBorderPaint = paint;
                spanned2 = spanned;
                try {
                    canvas2.drawRect(fMin, f, fMax, f2, paintConfigureBorderPaint);
                    canvas2.restoreToCount(i8);
                } catch (Throwable th4) {
                    th = th4;
                    canvas2.restoreToCount(i8);
                    throw th;
                }
            }
            if (padding > f6 && blockquoteSpan3 != null) {
                if (i9 == spanned2.getSpanStart(blockquoteSpan3)) {
                    f4 += padding;
                }
                if (blockquoteSpan4.isLastLineOf(spanned2, i10, blockquoteSpan3)) {
                    f5 += padding;
                }
            }
            if (i13 == i12) {
                return;
            }
            i13++;
            f3 = f6;
            i11 = i11;
            i12 = i12;
            spanned3 = spanned2;
            blockquoteSpanSpanAtMinDepth = blockquoteSpan2;
        }
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence text, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (!shouldSkipDrawing(text, i6)) {
            float f = i;
            this.boxLeft = f;
            float f2 = i2;
            this.boxRight = f2;
            Integer backgroundColor = this.blockquoteStyle.getBackgroundColor();
            if (backgroundColor != null) {
                if (backgroundColor.intValue() == 0) {
                    backgroundColor = null;
                }
                if (backgroundColor != null) {
                    Paint paintConfigureBackgroundPaint = configureBackgroundPaint(backgroundColor.intValue());
                    float borderRadius = this.blockquoteStyle.getBorderRadius();
                    Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
                    BlockquoteSpan blockquoteSpanSpanAtMinDepth = spanned != null ? spanAtMinDepth(spanned, i6) : null;
                    if (borderRadius <= 0.0f || blockquoteSpanSpanAtMinDepth == null) {
                        canvas.drawRect(f, i3, f2, i5, paintConfigureBackgroundPaint);
                    } else {
                        buildBoundaryPath((Spanned) text, i6, i7, blockquoteSpanSpanAtMinDepth, f, i3, f2, i5);
                        canvas.drawPath(this.path, paintConfigureBackgroundPaint);
                    }
                }
            }
        }
    }

    private final void drawBorders(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        float f = i3;
        float f2 = i4;
        int i5 = this.depth;
        if (i5 < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            float f3 = i2;
            float f4 = i + (this.levelSpacing * i6 * f3);
            float borderWidth = (this.blockquoteStyle.getBorderWidth() * f3) + f4;
            float fMin = Math.min(f4, borderWidth);
            float fMax = Math.max(f4, borderWidth);
            Canvas canvas2 = canvas;
            Paint paint2 = paint;
            canvas2.drawRect(fMin, f, fMax, f2, paint2);
            if (i6 == i5) {
                return;
            }
            i6++;
            canvas = canvas2;
            paint = paint2;
        }
    }

    private final void applyTextStyle(TextPaint textPaint) {
        textPaint.setTextSize(this.blockStyle.getFontSize());
        Typeface typeface = textPaint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & 3;
        TextPaintExtensionsKt.applyBlockStyleFont(textPaint, this.blockStyle, this.context);
        if (style != 0) {
            Typeface typeface2 = textPaint.getTypeface();
            if (typeface2 == null) {
                typeface2 = Typeface.DEFAULT;
            }
            textPaint.setTypeface(Typeface.create(typeface2, style));
        }
        int color = this.blockStyle.getColor();
        int[] colorsToPreserve = this.styleCache.getColorsToPreserve();
        TextPaintExtensionsKt.applyColorPreserving(textPaint, color, Arrays.copyOf(colorsToPreserve, colorsToPreserve.length));
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
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        sharedBorderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        sharedBackgroundPaint = paint2;
    }

    private final Paint configureBorderPaint() {
        Paint paint = sharedBorderPaint;
        paint.setColor(this.blockquoteStyle.getBorderColor());
        return paint;
    }

    private final Paint configureBackgroundPaint(int i) {
        Paint paint = sharedBackgroundPaint;
        paint.setColor(i);
        return paint;
    }

    private final BlockquoteSpan[] spansAt(Spanned spanned, int i) {
        if (this.cachedText != spanned) {
            this.cachedText = spanned;
            this.cachedSpansByPosition.clear();
        }
        Map map = this.cachedSpansByPosition;
        Integer numValueOf = Integer.valueOf(i);
        Object obj = map.get(numValueOf);
        if (obj == null) {
            Object[] spans = spanned.getSpans(i, i + 1, BlockquoteSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            obj = (BlockquoteSpan[]) spans;
            map.put(numValueOf, obj);
        }
        return (BlockquoteSpan[]) obj;
    }

    private final boolean shouldSkipDrawing(CharSequence charSequence, int i) {
        Integer num;
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        BlockquoteSpan[] blockquoteSpanArrSpansAt = spansAt((Spanned) charSequence, i);
        if (blockquoteSpanArrSpansAt.length == 0) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(blockquoteSpanArrSpansAt[0].depth);
            int lastIndex = ArraysKt.getLastIndex(blockquoteSpanArrSpansAt);
            if (1 <= lastIndex) {
                int i2 = 1;
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(blockquoteSpanArrSpansAt[i2].depth);
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            num = numValueOf;
        }
        return (num != null ? num.intValue() : -1) > this.depth;
    }

    private final BlockquoteSpan spanAtMinDepth(Spanned spanned, int i) {
        BlockquoteSpan[] blockquoteSpanArrSpansAt = spansAt(spanned, i);
        if (blockquoteSpanArrSpansAt.length == 0) {
            return null;
        }
        BlockquoteSpan blockquoteSpan = blockquoteSpanArrSpansAt[0];
        int lastIndex = ArraysKt.getLastIndex(blockquoteSpanArrSpansAt);
        if (lastIndex == 0) {
            return blockquoteSpan;
        }
        int i2 = blockquoteSpan.depth;
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                BlockquoteSpan blockquoteSpan2 = blockquoteSpanArrSpansAt[i3];
                int i4 = blockquoteSpan2.depth;
                if (i2 > i4) {
                    blockquoteSpan = blockquoteSpan2;
                    i2 = i4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return blockquoteSpan;
    }

    private final BlockquoteSpan spanAtDepth(Spanned spanned, int i, int i2) {
        for (BlockquoteSpan blockquoteSpan : spansAt(spanned, i)) {
            if (blockquoteSpan.depth == i2) {
                return blockquoteSpan;
            }
        }
        return null;
    }

    private final boolean isLastLineOf(Spanned spanned, int i, BlockquoteSpan blockquoteSpan) {
        int spanEnd = spanned.getSpanEnd(blockquoteSpan);
        while (spanEnd > 0 && spanned.charAt(spanEnd - 1) == '\n') {
            spanEnd--;
        }
        return i >= spanEnd;
    }

    private final boolean isBoundaryLine(Spanned spanned, int i, int i2, BlockquoteSpan blockquoteSpan) {
        int spanStart = spanned.getSpanStart(blockquoteSpan);
        int spanEnd = spanned.getSpanEnd(blockquoteSpan);
        if (spanStart < 0 || spanStart >= spanEnd) {
            return false;
        }
        return i == spanStart || isLastLineOf(spanned, i2, blockquoteSpan);
    }

    private final void buildBoundaryPath(Spanned spanned, int i, int i2, BlockquoteSpan blockquoteSpan, float f, float f2, float f3, float f4) {
        boolean z = i == spanned.getSpanStart(blockquoteSpan);
        boolean zIsLastLineOf = isLastLineOf(spanned, i2, blockquoteSpan);
        float borderRadius = this.blockquoteStyle.getBorderRadius();
        ArraysKt.fill$default(this.radiiArray, 0.0f, 0, 0, 6, (Object) null);
        if (z) {
            float[] fArr = this.radiiArray;
            fArr[0] = borderRadius;
            fArr[1] = borderRadius;
            fArr[2] = borderRadius;
            fArr[3] = borderRadius;
        }
        if (zIsLastLineOf) {
            float[] fArr2 = this.radiiArray;
            fArr2[4] = borderRadius;
            fArr2[5] = borderRadius;
            fArr2[6] = borderRadius;
            fArr2[7] = borderRadius;
        }
        this.rect.set(f, f2, f3, f4);
        this.path.reset();
        this.path.addRoundRect(this.rect, this.radiiArray, Path.Direction.CW);
    }
}
