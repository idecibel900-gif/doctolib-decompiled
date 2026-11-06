package com.swmansion.enriched.markdown.input.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.input.formatting.MarkdownSpan;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.InputHeadingStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputHeadingSpan extends MetricAffectingSpan implements MarkdownSpan {
    public static final Companion Companion = new Companion(null);
    private final int level;
    private final InputHeadingStyle resolved;

    public InputHeadingSpan(int i, InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.level = i;
        this.resolved = style.headingStyle(i);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyHeadingStyle(tp);
        Integer color = this.resolved.getColor();
        if (color != null) {
            tp.setColor(color.intValue());
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyHeadingStyle(tp);
    }

    private final void applyHeadingStyle(TextPaint textPaint) {
        Typeface typeface;
        Float fontSizePx = this.resolved.getFontSizePx();
        if (fontSizePx != null) {
            textPaint.setTextSize(fontSizePx.floatValue());
        }
        if (this.resolved.getFontWeight() != -1) {
            Typeface typeface2 = textPaint.getTypeface();
            int style = ((typeface2 != null ? typeface2.getStyle() : 0) & 3) | (this.resolved.getFontWeight() >= 700 ? 1 : 0);
            if (style != 0) {
                typeface = Typeface.create(textPaint.getTypeface(), style);
            } else {
                typeface = textPaint.getTypeface();
            }
            textPaint.setTypeface(typeface);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
