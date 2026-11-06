package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TextSpan extends MetricAffectingSpan {
    private final BlockStyle blockStyle;
    private final Context context;

    public TextSpan(BlockStyle blockStyle, Context context) {
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        this.blockStyle = blockStyle;
        this.context = context;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyBlockStyle(tp);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyBlockStyle(tp);
    }

    private final void applyBlockStyle(TextPaint textPaint) {
        textPaint.setTextSize(this.blockStyle.getFontSize());
        textPaint.setColor(this.blockStyle.getColor());
        TextPaintExtensionsKt.applyBlockStyleFont(textPaint, this.blockStyle, this.context);
    }
}
