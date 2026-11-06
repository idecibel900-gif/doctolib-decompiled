package com.swmansion.enriched.markdown.utils.text;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Spannable;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.swmansion.enriched.markdown.spans.FadeInSpan;
import com.swmansion.enriched.markdown.utils.common.MotionPreferencesKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TailFadeInAnimator {
    public static final Companion Companion = new Companion(null);
    private final Map activeAnimations;
    private final WeakReference viewRef;

    public TailFadeInAnimator(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.viewRef = new WeakReference(textView);
        this.activeAnimations = new LinkedHashMap();
    }

    public final void animate(final int i, final int i2) {
        TextView textView;
        if (i2 > i && (textView = (TextView) this.viewRef.get()) != null) {
            CharSequence text = textView.getText();
            Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
            if (spannable == null) {
                return;
            }
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (MotionPreferencesKt.isReducedMotionEnabled(context)) {
                return;
            }
            final FadeInSpan fadeInSpan = new FadeInSpan();
            fadeInSpan.setAlpha(0.0f);
            spannable.setSpan(fadeInSpan, i, i2, 33);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(150L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.enriched.markdown.utils.text.TailFadeInAnimator$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TailFadeInAnimator.animate$lambda$2$lambda$1(fadeInSpan, this, i2, i, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.enriched.markdown.utils.text.TailFadeInAnimator$animate$animator$1$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.cleanup(fadeInSpan);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.cleanup(fadeInSpan);
                }
            });
            this.activeAnimations.put(fadeInSpan, valueAnimatorOfFloat);
            valueAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animate$lambda$2$lambda$1(FadeInSpan fadeInSpan, TailFadeInAnimator tailFadeInAnimator, int i, int i2, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        fadeInSpan.setAlpha(((Float) animatedValue).floatValue());
        TextView textView = (TextView) tailFadeInAnimator.viewRef.get();
        if (textView == null) {
            return;
        }
        CharSequence text = textView.getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return;
        }
        int iMin = Math.min(i, spannable.length());
        if (iMin > i2) {
            spannable.setSpan(fadeInSpan, i2, iMin, 33);
        }
        textView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanup(FadeInSpan fadeInSpan) {
        this.activeAnimations.remove(fadeInSpan);
        TextView textView = (TextView) this.viewRef.get();
        CharSequence text = textView != null ? textView.getText() : null;
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return;
        }
        fadeInSpan.setAlpha(1.0f);
        spannable.removeSpan(fadeInSpan);
    }

    public final void cancelAll() {
        Iterator it = CollectionsKt.toList(this.activeAnimations.keySet()).iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) this.activeAnimations.get((FadeInSpan) it.next());
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.activeAnimations.clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
