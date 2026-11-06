package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    private final int endIndex;
    private int firstAscentDiff;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;
    private int firstAscent = LinearLayoutManager.INVALID_OFFSET;
    private int ascent = LinearLayoutManager.INVALID_OFFSET;
    private int descent = LinearLayoutManager.INVALID_OFFSET;
    private int lastDescent = LinearLayoutManager.INVALID_OFFSET;

    public LineHeightStyleSpan(float f, int i, int i2, boolean z, boolean z2, float f2) {
        this.lineHeight = f;
        this.startIndex = i;
        this.endIndex = i2;
        this.trimFirstLineTop = z;
        this.trimLastLineBottom = z2;
        this.topRatio = f2;
        if ((0.0f > f2 || f2 > 1.0f) && f2 != -1.0f) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1");
        }
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z = i == this.startIndex;
        boolean z2 = i2 == this.endIndex;
        if (z && z2 && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z2 ? this.lastDescent : this.descent;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        double dCeil;
        int iLineHeight = LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        int iCeil = (int) Math.ceil(this.lineHeight);
        int i = iCeil - iLineHeight;
        float fAbs = this.topRatio;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        }
        if (i <= 0) {
            dCeil = Math.ceil(i * fAbs);
        } else {
            dCeil = Math.ceil(i * (1.0f - fAbs));
        }
        int i2 = (int) dCeil;
        int i3 = fontMetricsInt.descent;
        int i4 = i2 + i3;
        this.descent = i4;
        int i5 = i4 - iCeil;
        this.ascent = i5;
        if (this.trimFirstLineTop) {
            i5 = fontMetricsInt.ascent;
        }
        this.firstAscent = i5;
        if (this.trimLastLineBottom) {
            i4 = i3;
        }
        this.lastDescent = i4;
        this.firstAscentDiff = fontMetricsInt.ascent - i5;
        this.lastDescentDiff = i4 - i3;
    }

    public final LineHeightStyleSpan copy$ui_text_release(int i, int i2, boolean z) {
        return new LineHeightStyleSpan(this.lineHeight, i, i2, z, this.trimLastLineBottom, this.topRatio);
    }
}
