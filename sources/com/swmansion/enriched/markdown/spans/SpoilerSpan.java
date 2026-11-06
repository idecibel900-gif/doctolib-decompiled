package com.swmansion.enriched.markdown.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerSpan extends MetricAffectingSpan {
    private final BlockStyle blockStyle;
    private boolean revealed;
    private boolean revealing;
    private final SpanStyleCache styleCache;

    public final SpanStyleCache getStyleCache() {
        return this.styleCache;
    }

    public SpoilerSpan(SpanStyleCache styleCache, BlockStyle blockStyle) {
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
    }

    public final boolean getRevealed() {
        return this.revealed;
    }

    public final boolean getRevealing() {
        return this.revealing;
    }

    public final void markRevealing() {
        this.revealing = true;
    }

    public final void markRevealed() {
        this.revealed = true;
        this.revealing = false;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        tp.setTextSize(this.blockStyle.getFontSize());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        tp.setTextSize(this.blockStyle.getFontSize());
    }
}
