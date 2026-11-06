package com.swmansion.enriched.markdown.spans;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HighlightSpan extends CharacterStyle {
    private final BlockStyle blockStyle;
    private final int foregroundColor;
    private final SpanStyleCache styleCache;

    public HighlightSpan(SpanStyleCache styleCache, BlockStyle blockStyle) {
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
        this.foregroundColor = styleCache.getHighlightColorFor(blockStyle.getColor());
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setColor(this.foregroundColor);
        int highlightBackgroundColor = this.styleCache.getHighlightBackgroundColor();
        if (Color.alpha(highlightBackgroundColor) > 0) {
            textPaint.bgColor = highlightBackgroundColor;
        }
    }
}
