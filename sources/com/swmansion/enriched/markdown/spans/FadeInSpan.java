package com.swmansion.enriched.markdown.spans;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FadeInSpan extends CharacterStyle {
    private float alpha;

    private final int multiplyAlpha(int i, float f) {
        if (f >= 1.0f) {
            return i;
        }
        if (f <= 0.0f) {
            return i & 16777215;
        }
        return (i & 16777215) | (((int) ((i >>> 24) * f)) << 24);
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        tp.setColor(multiplyAlpha(tp.getColor(), this.alpha));
        tp.underlineColor = multiplyAlpha(tp.underlineColor, this.alpha);
    }
}
