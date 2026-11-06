package com.swmansion.enriched.markdown.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.styles.HeadingStyle;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HeadingSpan extends MetricAffectingSpan {
    public static final Companion Companion = new Companion(null);
    private final Typeface cachedTypeface;
    private final int color;
    private final float fontSize;
    private final int level;

    public final int getLevel() {
        return this.level;
    }

    public HeadingSpan(int i, StyleConfig styleConfig) {
        Intrinsics.checkNotNullParameter(styleConfig, "styleConfig");
        this.level = i;
        HeadingStyle headingStyle = styleConfig.getHeadingStyles()[i];
        Intrinsics.checkNotNull(headingStyle);
        this.fontSize = headingStyle.getFontSize();
        HeadingStyle headingStyle2 = styleConfig.getHeadingStyles()[i];
        Intrinsics.checkNotNull(headingStyle2);
        this.color = headingStyle2.getColor();
        this.cachedTypeface = styleConfig.getHeadingTypefaces()[i];
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyHeadingStyle(tp);
        tp.setColor(this.color);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyHeadingStyle(tp);
    }

    private final void applyHeadingStyle(TextPaint textPaint) {
        textPaint.setTextSize(this.fontSize);
        Typeface typefaceCreate = this.cachedTypeface;
        if (typefaceCreate != null) {
            Typeface typeface = textPaint.getTypeface();
            int style = (typeface != null ? typeface.getStyle() : 0) & 3;
            if (style != 0) {
                typefaceCreate = Typeface.create(typefaceCreate, style);
            }
            textPaint.setTypeface(typefaceCreate);
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
