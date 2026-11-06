package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextPaintHolderSpan implements ReactSpan {
    private final TextPaint textPaint;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReactTextPaintHolderSpan) && Intrinsics.areEqual(this.textPaint, ((ReactTextPaintHolderSpan) obj).textPaint);
    }

    public int hashCode() {
        return this.textPaint.hashCode();
    }

    public String toString() {
        return "ReactTextPaintHolderSpan(textPaint=" + this.textPaint + ")";
    }

    public ReactTextPaintHolderSpan(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.textPaint = textPaint;
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }
}
