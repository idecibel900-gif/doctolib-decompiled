package com.swmansion.enriched.markdown.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BaselineShiftSpan extends MetricAffectingSpan {
    private final float baselineOffsetScale;
    private final float fontScale;
    private final SpanType spanType;

    public enum SpanType {
        SUPERSCRIPT,
        SUBSCRIPT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public final SpanType getSpanType() {
        return this.spanType;
    }

    public BaselineShiftSpan(float f, float f2, SpanType spanType) {
        Intrinsics.checkNotNullParameter(spanType, "spanType");
        this.fontScale = f;
        this.baselineOffsetScale = f2;
        this.spanType = spanType;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyShift(tp);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        applyShift(tp);
    }

    private final void applyShift(TextPaint textPaint) {
        float textSize = textPaint.getTextSize();
        textPaint.setTextSize(this.fontScale * textSize);
        textPaint.baselineShift -= MathKt.roundToInt(textSize * this.baselineOffsetScale);
    }
}
