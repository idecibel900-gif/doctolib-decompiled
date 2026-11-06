package com.swmansion.enriched.markdown.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeSpan extends MetricAffectingSpan {
    private final BlockStyle blockStyle;
    private final SpanStyleCache styleCache;

    public CodeSpan(SpanStyleCache styleCache, BlockStyle blockStyle) {
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyMonospacedFont(tp);
        tp.setColor(this.styleCache.getCodeColor());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyMonospacedFont(tp);
    }

    private final void applyMonospacedFont(TextPaint textPaint) {
        Typeface monospaceTypeface;
        textPaint.setTextSize(this.styleCache.getCodeFontSize() > 0.0f ? this.styleCache.getCodeFontSize() : this.blockStyle.getFontSize());
        Typeface typeface = textPaint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & 3;
        if (this.styleCache.getCodeFontFamily().length() > 0) {
            SpanStyleCache spanStyleCache = this.styleCache;
            monospaceTypeface = spanStyleCache.getTypeface(spanStyleCache.getCodeFontFamily(), style);
        } else {
            monospaceTypeface = SpanStyleCache.Companion.getMonospaceTypeface(style);
        }
        textPaint.setTypeface(monospaceTypeface);
    }
}
