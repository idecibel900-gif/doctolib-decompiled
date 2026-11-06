package com.swmansion.enriched.markdown.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.adjust.sdk.Constants;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EmphasisSpan extends MetricAffectingSpan {
    private final BlockStyle blockStyle;
    private final SpanStyleCache styleCache;

    public EmphasisSpan(SpanStyleCache styleCache, BlockStyle blockStyle) {
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyEmphasisStyle(tp);
        applyEmphasisColor(tp);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyEmphasisStyle(tp);
    }

    private final void applyEmphasisStyle(TextPaint textPaint) {
        Typeface typeface = textPaint.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        int i = (typeface.getStyle() & 1) != 0 ? 3 : 2;
        if (this.styleCache.getEmphasisFontFamily().length() > 0) {
            if (Intrinsics.areEqual(this.styleCache.getEmphasisFontStyle(), Constants.NORMAL)) {
                i = 0;
            }
            SpanStyleCache spanStyleCache = this.styleCache;
            typeface = spanStyleCache.getTypeface(spanStyleCache.getEmphasisFontFamily(), i);
        } else if (!Intrinsics.areEqual(this.styleCache.getEmphasisFontStyle(), Constants.NORMAL)) {
            typeface = Typeface.create(typeface, i);
        }
        textPaint.setTypeface(typeface);
    }

    private final void applyEmphasisColor(TextPaint textPaint) {
        int emphasisColorFor = this.styleCache.getEmphasisColorFor(this.blockStyle.getColor(), textPaint.getColor());
        int[] colorsToPreserve = this.styleCache.getColorsToPreserve();
        TextPaintExtensionsKt.applyColorPreserving(textPaint, emphasisColorFor, Arrays.copyOf(colorsToPreserve, colorsToPreserve.length));
    }
}
