package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerDrawContext {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final Paint.FontMetrics fontMetrics;
    private final Layout layout;
    private final float paddingLeft;
    private final float paddingTop;
    private final SpoilerSpan[] spans;
    private final Spanned text;
    private final TextView textView;

    public SpoilerDrawContext(TextView textView, Layout layout, Spanned text, SpoilerSpan[] spans, float f, float f2, Paint.FontMetrics fontMetrics, int i) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(spans, "spans");
        Intrinsics.checkNotNullParameter(fontMetrics, "fontMetrics");
        this.textView = textView;
        this.layout = layout;
        this.text = text;
        this.spans = spans;
        this.paddingLeft = f;
        this.paddingTop = f2;
        this.fontMetrics = fontMetrics;
        this.backgroundColor = i;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final Spanned getText() {
        return this.text;
    }

    public final SpoilerSpan[] getSpans() {
        return this.spans;
    }

    public final float getPaddingLeft() {
        return this.paddingLeft;
    }

    public final float getPaddingTop() {
        return this.paddingTop;
    }

    public final Paint.FontMetrics getFontMetrics() {
        return this.fontMetrics;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.widget.TextView, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        public final int resolveBackgroundColor(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            while (textView != 0) {
                Integer backgroundColor = BackgroundStyleApplicator.getBackgroundColor(textView);
                if (backgroundColor != null && Color.alpha(backgroundColor.intValue()) > 0) {
                    return backgroundColor.intValue();
                }
                Object parent = textView.getParent();
                textView = parent instanceof View ? (View) parent : 0;
            }
            return -1;
        }
    }
}
