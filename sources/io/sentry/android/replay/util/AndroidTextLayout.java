package io.sentry.android.replay.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidTextLayout implements TextLayout {
    private final Layout layout;

    public AndroidTextLayout(Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public Integer getDominantTextColor() {
        int i;
        if (!(this.layout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) ((Spanned) text).getSpans(0, this.layout.getText().length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNull(foregroundColorSpanArr);
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        Integer numValueOf = null;
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            CharSequence text2 = this.layout.getText();
            Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
            int spanStart = ((Spanned) text2).getSpanStart(foregroundColorSpan);
            CharSequence text3 = this.layout.getText();
            Intrinsics.checkNotNull(text3, "null cannot be cast to non-null type android.text.Spanned");
            int spanEnd = ((Spanned) text3).getSpanEnd(foregroundColorSpan);
            if (spanStart != -1 && spanEnd != -1 && (i = spanEnd - spanStart) > i2) {
                numValueOf = Integer.valueOf(foregroundColorSpan.getForegroundColor());
                i2 = i;
            }
        }
        if (numValueOf != null) {
            return Integer.valueOf(ViewsKt.toOpaque(numValueOf.intValue()));
        }
        return null;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getLineLeft(int i) {
        if (this.layout.getEllipsizedWidth() <= 0 || this.layout.getEllipsizedWidth() >= this.layout.getWidth()) {
            return this.layout.getLineLeft(i);
        }
        return 0.0f;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getLineRight(int i) {
        if (this.layout.getEllipsizedWidth() > 0 && this.layout.getEllipsizedWidth() < this.layout.getWidth()) {
            return this.layout.getEllipsizedWidth();
        }
        return this.layout.getLineRight(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }
}
