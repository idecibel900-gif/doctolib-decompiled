package com.facebook.react.views.text.internal.span;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextInlineImageSpan extends ReplacementSpan implements ReactSpan {
    public static final Companion Companion = new Companion(null);

    public abstract Drawable getDrawable();

    public abstract int getHeight();

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public abstract void onFinishTemporaryDetach();

    public abstract void onStartTemporaryDetach();

    public abstract void setTextView(TextView textView);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void possiblyUpdateInlineImageSpans(Spannable spannable, TextView textView) {
            Intrinsics.checkNotNullParameter(spannable, "spannable");
            Object[] spans = spannable.getSpans(0, spannable.length(), TextInlineImageSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            for (Object obj : spans) {
                TextInlineImageSpan textInlineImageSpan = (TextInlineImageSpan) obj;
                textInlineImageSpan.onAttachedToWindow();
                textInlineImageSpan.setTextView(textView);
            }
        }
    }
}
