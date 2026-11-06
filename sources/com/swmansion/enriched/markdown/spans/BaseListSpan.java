package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseListSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    public static final Companion Companion = new Companion(null);
    private final BlockStyle blockStyle;
    private Map cachedHasDeeperSpanByPosition;
    private CharSequence cachedText;
    private final Context context;
    private final int depth;
    private final boolean drawsMarker;
    private final float gapWidth;
    private final float marginLeft;
    private final Lazy markerFontMetrics$delegate;
    private final SpanStyleCache styleCache;

    protected abstract void drawMarker(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, Layout layout, int i6);

    protected abstract float getMarkerWidth();

    public final int getDepth() {
        return this.depth;
    }

    protected final float getMarginLeft() {
        return this.marginLeft;
    }

    public final boolean getDrawsMarker$react_native_enriched_markdown_release() {
        return this.drawsMarker;
    }

    public BaseListSpan(int i, Context context, SpanStyleCache styleCache, BlockStyle blockStyle, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.depth = i;
        this.context = context;
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
        this.marginLeft = f;
        this.gapWidth = f2;
        this.drawsMarker = z;
        this.cachedHasDeeperSpanByPosition = new LinkedHashMap();
        this.markerFontMetrics$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.spans.BaseListSpan$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseListSpan.markerFontMetrics_delegate$lambda$1(this.f$0);
            }
        });
    }

    public final Paint.FontMetrics getMarkerFontMetrics() {
        Object value = this.markerFontMetrics$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Paint.FontMetrics) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint.FontMetrics markerFontMetrics_delegate$lambda$1(BaseListSpan baseListSpan) {
        TextPaint textPaint = new TextPaint();
        TextPaintExtensionsKt.applyBlockStyleFont(textPaint, baseListSpan.blockStyle, baseListSpan.context);
        textPaint.setTextSize(baseListSpan.blockStyle.getFontSize());
        return textPaint.getFontMetrics();
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        applyTextStyle(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        applyTextStyle(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        if (this.depth == 0) {
            return (int) (getMarkerWidth() + RangesKt.coerceAtLeast(this.gapWidth, 4.0f));
        }
        return (int) this.marginLeft;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (this.drawsMarker && z && !shouldSkipDrawing(charSequence, i6) && hasContent(charSequence, i6, i7)) {
            if (!(charSequence instanceof Spanned) || ((Spanned) charSequence).getSpanStart(this) == i6) {
                drawMarkerAt(canvas, paint, i, i2, i3, i4, i5, layout, i6);
            }
        }
    }

    public final void drawMarkerAt(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, Layout layout, int i6) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        drawMarker(canvas, paint, i, i2, i3, i4, i5, layout, i6);
        paint.setStyle(style);
        paint.setColor(color);
    }

    private final void applyTextStyle(TextPaint textPaint) {
        Typeface typeface;
        textPaint.setTextSize(this.blockStyle.getFontSize());
        Typeface typeface2 = textPaint.getTypeface();
        int style = (typeface2 != null ? typeface2.getStyle() : 0) & 3;
        TextPaintExtensionsKt.applyBlockStyleFont(textPaint, this.blockStyle, this.context);
        if (style != 0 && (typeface = textPaint.getTypeface()) != null) {
            textPaint.setTypeface(Typeface.create(typeface, style));
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

    private final boolean hasContent(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i2 > i) {
            Iterable iterableUntil = RangesKt.until(i, i2);
            if ((iterableUntil instanceof Collection) && ((Collection) iterableUntil).isEmpty()) {
                return false;
            }
            Iterator it = iterableUntil.iterator();
            while (it.hasNext()) {
                if (!CharsKt.isWhitespace(charSequence.charAt(((IntIterator) it).nextInt()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean shouldSkipDrawing(CharSequence charSequence, int i) {
        boolean z = false;
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        if (this.cachedText != charSequence) {
            this.cachedText = charSequence;
            this.cachedHasDeeperSpanByPosition.clear();
        }
        Map map = this.cachedHasDeeperSpanByPosition;
        Integer numValueOf = Integer.valueOf(i);
        Object objValueOf = map.get(numValueOf);
        if (objValueOf == null) {
            BaseListSpan[] baseListSpanArr = (BaseListSpan[]) ((Spanned) charSequence).getSpans(i, i + 1, BaseListSpan.class);
            Intrinsics.checkNotNull(baseListSpanArr);
            for (BaseListSpan baseListSpan : baseListSpanArr) {
                if (baseListSpan.depth > this.depth) {
                    z = true;
                    break;
                }
            }
            objValueOf = Boolean.valueOf(z);
            map.put(numValueOf, objValueOf);
        }
        return ((Boolean) objValueOf).booleanValue();
    }
}
