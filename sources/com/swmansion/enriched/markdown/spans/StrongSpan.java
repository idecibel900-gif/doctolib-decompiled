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
public final class StrongSpan extends MetricAffectingSpan {
    private final BlockStyle blockStyle;
    private final int strongColor;
    private final SpanStyleCache styleCache;

    public StrongSpan(SpanStyleCache styleCache, BlockStyle blockStyle) {
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
        this.strongColor = styleCache.getStrongColorFor(blockStyle.getColor());
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyStrongStyle(tp);
        int i = this.strongColor;
        int[] colorsToPreserve = this.styleCache.getColorsToPreserve();
        TextPaintExtensionsKt.applyColorPreserving(tp, i, Arrays.copyOf(colorsToPreserve, colorsToPreserve.length));
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyStrongStyle(tp);
    }

    private final void applyStrongStyle(TextPaint textPaint) {
        Typeface typefaceCreate;
        textPaint.setTextSize(this.blockStyle.getFontSize());
        Typeface typeface = textPaint.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        int i = (typeface.getStyle() & 2) != 0 ? 3 : 1;
        if (this.styleCache.getStrongFontFamily().length() > 0) {
            if (Intrinsics.areEqual(this.styleCache.getStrongFontWeight(), Constants.NORMAL)) {
                i = 0;
            }
            SpanStyleCache spanStyleCache = this.styleCache;
            typefaceCreate = spanStyleCache.getTypeface(spanStyleCache.getStrongFontFamily(), i);
        } else {
            typefaceCreate = Typeface.create(typeface, i);
        }
        textPaint.setTypeface(typefaceCreate);
    }
}
