package io.sentry.android.replay.util;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ComposeTextLayout implements TextLayout {
    public static final int $stable = TextLayoutResult.$stable;
    private final TextLayoutResult layout;

    @Override // io.sentry.android.replay.util.TextLayout
    public Integer getDominantTextColor() {
        return null;
    }

    public ComposeTextLayout(TextLayoutResult layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    private final boolean getParagraphWidthExceedsNode() {
        return this.layout.getMultiParagraph().getWidth() > ((float) ((int) (this.layout.m2203getSizeYbymL2g() >> 32)));
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getLineLeft(int i) {
        if (getParagraphWidthExceedsNode()) {
            return 0.0f;
        }
        return this.layout.getLineLeft(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public float getLineRight(int i) {
        if (getParagraphWidthExceedsNode()) {
            return this.layout.getMultiParagraph().getLineWidth(i);
        }
        return this.layout.getLineRight(i);
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineTop(int i) {
        return MathKt.roundToInt(this.layout.getLineTop(i));
    }

    @Override // io.sentry.android.replay.util.TextLayout
    public int getLineBottom(int i) {
        return MathKt.roundToInt(this.layout.getLineBottom(i));
    }
}
