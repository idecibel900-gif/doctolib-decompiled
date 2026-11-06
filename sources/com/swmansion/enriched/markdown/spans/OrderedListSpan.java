package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.ListStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OrderedListSpan extends BaseListSpan {
    public static final Companion Companion = new Companion(null);
    private static final TextPaint sharedMarkerPaint;
    private int itemNumber;
    private final ListStyle listStyle;
    private final Typeface markerTypeface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderedListSpan(ListStyle listStyle, int i, Context context, SpanStyleCache styleCache, boolean z) {
        super(i, context, styleCache, new BlockStyle(listStyle.getFontSize(), listStyle.getFontFamily(), listStyle.getFontWeight(), listStyle.getColor()), listStyle.getMarginLeft(), listStyle.getGapWidth(), z);
        Intrinsics.checkNotNullParameter(listStyle, "listStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        this.listStyle = listStyle;
        String fontFamily = listStyle.getFontFamily();
        fontFamily = fontFamily.length() <= 0 ? null : fontFamily;
        int fontWeight = ReactTypefaceUtils.parseFontWeight(listStyle.getMarkerFontWeight());
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        this.markerTypeface = ReactTypefaceUtils.applyStyles(null, -1, fontWeight, fontFamily, assets);
        this.itemNumber = 1;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        sharedMarkerPaint = textPaint;
    }

    private final TextPaint configureMarkerPaint() {
        TextPaint textPaint = sharedMarkerPaint;
        textPaint.setTextSize(this.listStyle.getFontSize());
        textPaint.setColor(this.listStyle.getMarkerColor());
        textPaint.setTypeface(this.markerTypeface);
        return textPaint;
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected float getMarkerWidth() {
        return this.listStyle.effectiveMarkerWidth(configureMarkerPaint().measureText("99."));
    }

    public final int getItemNumber() {
        return this.itemNumber;
    }

    @Override // com.swmansion.enriched.markdown.spans.BaseListSpan
    protected void drawMarker(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, Layout layout, int i6) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        TextPaint textPaintConfigureMarkerPaint = configureMarkerPaint();
        int i7 = this.itemNumber;
        if (i2 < 0) {
            sb = new StringBuilder();
            sb.append(".");
            sb.append(i7);
        } else {
            sb = new StringBuilder();
            sb.append(i7);
            sb.append(".");
        }
        String string = sb.toString();
        float fMeasureText = textPaintConfigureMarkerPaint.measureText(string);
        float depth = i + (((getDepth() * getMarginLeft()) + getMarkerWidth()) * i2);
        if (i2 > 0) {
            depth -= fMeasureText;
        }
        canvas.drawText(string, depth, i4, textPaintConfigureMarkerPaint);
    }

    public final void setItemNumber(int i) {
        this.itemNumber = i;
    }
}
