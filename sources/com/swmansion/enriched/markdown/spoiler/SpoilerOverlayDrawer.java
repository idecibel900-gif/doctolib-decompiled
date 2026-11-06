package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import com.swmansion.enriched.markdown.styles.SpoilerStyle;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerOverlayDrawer {
    public static final Companion Companion = new Companion(null);
    private final Set activeKeys;
    private final SpoilerAnimator animator;
    private SpoilerStyle cachedStyle;
    private SpoilerOverlay currentMode;
    private SpoilerStrategy strategy;
    private final WeakReference textViewReference;

    public SpoilerOverlayDrawer(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textViewReference = new WeakReference(textView);
        this.animator = new SpoilerAnimator(textView);
        SpoilerOverlay spoilerOverlay = SpoilerOverlay.PARTICLES;
        this.strategy = createStrategy(spoilerOverlay);
        this.currentMode = spoilerOverlay;
        this.activeKeys = new LinkedHashSet();
    }

    public final void setSpoilerOverlay(SpoilerOverlay value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.currentMode == value) {
            return;
        }
        this.strategy.stop();
        this.currentMode = value;
        SpoilerStrategy spoilerStrategyCreateStrategy = createStrategy(value);
        this.strategy = spoilerStrategyCreateStrategy;
        SpoilerStyle spoilerStyle = this.cachedStyle;
        if (spoilerStyle != null) {
            spoilerStrategyCreateStrategy.applyStyle(spoilerStyle);
        }
        TextView textView = (TextView) this.textViewReference.get();
        if (textView != null) {
            textView.invalidate();
        }
    }

    public final void registerSpans(SpoilerSpan[] spans) {
        Intrinsics.checkNotNullParameter(spans, "spans");
        if (spans.length == 0) {
            return;
        }
        SpoilerSpan spoilerSpan = spans[0];
        SpoilerStyle spoilerStyle = new SpoilerStyle(spoilerSpan.getStyleCache().getSpoilerColor(), spoilerSpan.getStyleCache().getSpoilerParticleDensity(), spoilerSpan.getStyleCache().getSpoilerParticleSpeed(), spoilerSpan.getStyleCache().getSpoilerSolidBorderRadius());
        this.cachedStyle = spoilerStyle;
        this.strategy.applyStyle(spoilerStyle);
    }

    public final void draw(Canvas canvas) {
        SegmentRect segmentRectComputeSegmentRect;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SpoilerDrawContext spoilerDrawContextBuildContext = buildContext();
        if (spoilerDrawContextBuildContext == null) {
            return;
        }
        this.activeKeys.clear();
        for (SpoilerSpan spoilerSpan : spoilerDrawContextBuildContext.getSpans()) {
            if (!spoilerSpan.getRevealed()) {
                int spanStart = spoilerDrawContextBuildContext.getText().getSpanStart(spoilerSpan);
                int spanEnd = spoilerDrawContextBuildContext.getText().getSpanEnd(spoilerSpan);
                if (spanStart >= 0 && spanEnd >= 0 && spanStart < spanEnd) {
                    int iIdentityHashCode = System.identityHashCode(spoilerSpan);
                    int lineForOffset = spoilerDrawContextBuildContext.getLayout().getLineForOffset(spanStart);
                    int lineForOffset2 = spoilerDrawContextBuildContext.getLayout().getLineForOffset(spanEnd);
                    if (lineForOffset <= lineForOffset2) {
                        int i = lineForOffset;
                        while (true) {
                            int iMax = Math.max(spanStart, spoilerDrawContextBuildContext.getLayout().getLineStart(i));
                            int iMin = Math.min(spanEnd, spoilerDrawContextBuildContext.getLayout().getLineEnd(i));
                            if (iMax < iMin && (segmentRectComputeSegmentRect = SpoilerDrawUtilsKt.computeSegmentRect(spoilerDrawContextBuildContext.getLayout(), i, iMax, iMin, spoilerDrawContextBuildContext.getFontMetrics(), spoilerDrawContextBuildContext.getPaddingLeft(), spoilerDrawContextBuildContext.getPaddingTop())) != null) {
                                SegmentKey segmentKey = new SegmentKey(iIdentityHashCode, i);
                                this.activeKeys.add(segmentKey);
                                this.strategy.drawSegment(canvas, spoilerDrawContextBuildContext, segmentKey, segmentRectComputeSegmentRect);
                            }
                            if (i != lineForOffset2) {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        this.strategy.pruneStaleSegments(this.activeKeys);
    }

    public final void revealSpan(final SpoilerSpan span, final Function0 onAllComplete) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(onAllComplete, "onAllComplete");
        SpoilerDrawContext spoilerDrawContextBuildContext = buildContext();
        if (spoilerDrawContextBuildContext == null) {
            span.markRevealed();
            onAllComplete.invoke();
        } else {
            span.markRevealing();
            this.strategy.revealSpan(span, spoilerDrawContextBuildContext, new Function0() { // from class: com.swmansion.enriched.markdown.spoiler.SpoilerOverlayDrawer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SpoilerOverlayDrawer.revealSpan$lambda$1(span, this, onAllComplete);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSpan$lambda$1(SpoilerSpan spoilerSpan, SpoilerOverlayDrawer spoilerOverlayDrawer, Function0 function0) {
        spoilerSpan.markRevealed();
        TextView textView = (TextView) spoilerOverlayDrawer.textViewReference.get();
        if (textView != null) {
            textView.invalidate();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void stop() {
        this.animator.stop();
        this.strategy.stop();
    }

    private final SpoilerDrawContext buildContext() {
        Layout layout;
        TextView textView = (TextView) this.textViewReference.get();
        if (textView == null || (layout = textView.getLayout()) == null) {
            return null;
        }
        CharSequence text = textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return null;
        }
        SpoilerSpan[] spoilerSpanArr = (SpoilerSpan[]) spanned.getSpans(0, spanned.length(), SpoilerSpan.class);
        Intrinsics.checkNotNull(spoilerSpanArr);
        if (spoilerSpanArr.length == 0) {
            return null;
        }
        float totalPaddingLeft = textView.getTotalPaddingLeft();
        float totalPaddingTop = textView.getTotalPaddingTop();
        Paint.FontMetrics fontMetrics = layout.getPaint().getFontMetrics();
        Intrinsics.checkNotNullExpressionValue(fontMetrics, "getFontMetrics(...)");
        return new SpoilerDrawContext(textView, layout, spanned, spoilerSpanArr, totalPaddingLeft, totalPaddingTop, fontMetrics, SpoilerDrawContext.Companion.resolveBackgroundColor(textView));
    }

    private final SpoilerStrategy createStrategy(SpoilerOverlay spoilerOverlay) {
        return (SpoilerStrategy) spoilerOverlay.getCreateStrategy$react_native_enriched_markdown_release().invoke(this.animator);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpoilerOverlayDrawer setupIfNeeded(TextView textView, CharSequence styledText, SpoilerOverlayDrawer spoilerOverlayDrawer, SpoilerOverlay spoilerOverlay) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(styledText, "styledText");
            Intrinsics.checkNotNullParameter(spoilerOverlay, "spoilerOverlay");
            if (!(styledText instanceof Spanned)) {
                return (SpoilerOverlayDrawer) tearDown(spoilerOverlayDrawer);
            }
            SpoilerSpan[] spoilerSpanArr = (SpoilerSpan[]) ((Spanned) styledText).getSpans(0, styledText.length(), SpoilerSpan.class);
            Intrinsics.checkNotNull(spoilerSpanArr);
            if (spoilerSpanArr.length == 0) {
                return (SpoilerOverlayDrawer) tearDown(spoilerOverlayDrawer);
            }
            if (spoilerOverlayDrawer == null) {
                spoilerOverlayDrawer = new SpoilerOverlayDrawer(textView);
            }
            spoilerOverlayDrawer.setSpoilerOverlay(spoilerOverlay);
            spoilerOverlayDrawer.registerSpans(spoilerSpanArr);
            return spoilerOverlayDrawer;
        }

        private final Void tearDown(SpoilerOverlayDrawer spoilerOverlayDrawer) {
            if (spoilerOverlayDrawer == null) {
                return null;
            }
            spoilerOverlayDrawer.stop();
            return null;
        }
    }
}
