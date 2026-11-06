package com.swmansion.enriched.markdown.spans;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StrikethroughSpan extends CharacterStyle {
    private final int strikethroughColor;

    public StrikethroughSpan(int i) {
        this.strikethroughColor = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        tp.setStrikeThruText(true);
    }
}
