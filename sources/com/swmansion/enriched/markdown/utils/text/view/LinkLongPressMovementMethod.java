package com.swmansion.enriched.markdown.utils.text.view;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.swmansion.enriched.markdown.spans.LinkSpan;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import com.swmansion.enriched.markdown.spoiler.SpoilerCapable;
import com.swmansion.enriched.markdown.spoiler.SpoilerOverlayDrawer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkLongPressMovementMethod extends ArrowKeyMovementMethod {
    public static final Companion Companion = new Companion(null);
    private boolean isLinkTouchActive;
    private Runnable longPressRunnable;
    private LinkSpan pressedLink;
    private float startX;
    private float startY;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isTouchWithinTextBounds = true;

    public final boolean isLinkTouchActive() {
        return this.isLinkTouchActive;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.startX = event.getX();
            this.startY = event.getY();
            LinkSpan linkSpanFindLinkSpan = findLinkSpan(widget, buffer, event);
            this.pressedLink = linkSpanFindLinkSpan;
            this.isLinkTouchActive = linkSpanFindLinkSpan != null;
            this.isTouchWithinTextBounds = charOffsetAt(widget, event) != null;
            LinkSpan linkSpan = this.pressedLink;
            if (linkSpan != null) {
                scheduleLongPress(widget, linkSpan);
            }
        } else if (action == 1) {
            cancelLongPress();
            LinkSpan linkSpan2 = this.pressedLink;
            this.isLinkTouchActive = false;
            this.pressedLink = null;
            if (handleSpoilerTap(widget, buffer, event)) {
                return true;
            }
            if (linkSpan2 != null && findLinkSpan(widget, buffer, event) == linkSpan2) {
                linkSpan2.onClick(widget);
                return true;
            }
        } else if (action == 2) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(widget.getContext());
            if (Math.abs(event.getX() - this.startX) > viewConfiguration.getScaledTouchSlop() || Math.abs(event.getY() - this.startY) > viewConfiguration.getScaledTouchSlop()) {
                cancelLongPress();
                this.isLinkTouchActive = false;
                this.pressedLink = null;
            }
        } else if (action == 3) {
            cancelLongPress();
            this.isLinkTouchActive = false;
            this.pressedLink = null;
        }
        if (this.isTouchWithinTextBounds) {
            return super.onTouchEvent(widget, buffer, event);
        }
        return false;
    }

    private final void scheduleLongPress(final TextView textView, final LinkSpan linkSpan) {
        cancelLongPress();
        Runnable runnable = new Runnable() { // from class: com.swmansion.enriched.markdown.utils.text.view.LinkLongPressMovementMethod$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LinkLongPressMovementMethod.scheduleLongPress$lambda$1(linkSpan, textView, this);
            }
        };
        this.handler.postDelayed(runnable, ViewConfiguration.getLongPressTimeout());
        this.longPressRunnable = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleLongPress$lambda$1(LinkSpan linkSpan, TextView textView, LinkLongPressMovementMethod linkLongPressMovementMethod) {
        if (linkSpan.onLongClick(textView)) {
            textView.cancelLongPress();
        }
        linkLongPressMovementMethod.longPressRunnable = null;
    }

    private final void cancelLongPress() {
        Runnable runnable = this.longPressRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.longPressRunnable = null;
    }

    private final Integer charOffsetAt(TextView textView, MotionEvent motionEvent) {
        float x = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        if (layout != null && y >= 0.0f && y <= layout.getHeight()) {
            int lineForVertical = layout.getLineForVertical((int) y);
            if (x >= layout.getLineLeft(lineForVertical) && x <= layout.getLineRight(lineForVertical)) {
                return Integer.valueOf(layout.getOffsetForHorizontal(lineForVertical, x));
            }
        }
        return null;
    }

    private final LinkSpan findLinkSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        Integer numCharOffsetAt = charOffsetAt(textView, motionEvent);
        if (numCharOffsetAt == null) {
            return null;
        }
        int iIntValue = numCharOffsetAt.intValue();
        Object[] spans = spannable.getSpans(iIntValue, iIntValue, LinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        return (LinkSpan) ArraysKt.firstOrNull(spans);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean handleSpoilerTap(final TextView textView, Spannable spannable, MotionEvent motionEvent) {
        Object obj;
        SpoilerOverlayDrawer spoilerOverlayDrawer;
        Integer numCharOffsetAt = charOffsetAt(textView, motionEvent);
        if (numCharOffsetAt != null) {
            int iIntValue = numCharOffsetAt.intValue();
            Object[] spans = spannable.getSpans(iIntValue, iIntValue, SpoilerSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            int length = spans.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    obj = null;
                    break;
                }
                obj = spans[i];
                SpoilerSpan spoilerSpan = (SpoilerSpan) obj;
                if (!spoilerSpan.getRevealed() && !spoilerSpan.getRevealing()) {
                    break;
                }
                i++;
            }
            SpoilerSpan spoilerSpan2 = (SpoilerSpan) obj;
            if (spoilerSpan2 == null) {
                return false;
            }
            SpoilerCapable spoilerCapable = textView instanceof SpoilerCapable ? (SpoilerCapable) textView : null;
            if (spoilerCapable != null && (spoilerOverlayDrawer = spoilerCapable.getSpoilerOverlayDrawer()) != null) {
                List listExpandContiguousSpoilers = expandContiguousSpoilers(spannable, spoilerSpan2);
                final int[] iArr = {listExpandContiguousSpoilers.size()};
                Iterator it = listExpandContiguousSpoilers.iterator();
                while (it.hasNext()) {
                    spoilerOverlayDrawer.revealSpan((SpoilerSpan) it.next(), new Function0() { // from class: com.swmansion.enriched.markdown.utils.text.view.LinkLongPressMovementMethod$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LinkLongPressMovementMethod.handleSpoilerTap$lambda$4(iArr, textView);
                        }
                    });
                }
                textView.invalidate();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleSpoilerTap$lambda$4(int[] iArr, TextView textView) {
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i <= 0) {
            textView.invalidate();
        }
        return Unit.INSTANCE;
    }

    private final List expandContiguousSpoilers(final Spannable spannable, SpoilerSpan spoilerSpan) {
        boolean z;
        SpoilerSpan[] spoilerSpanArr = (SpoilerSpan[]) spannable.getSpans(0, spannable.length(), SpoilerSpan.class);
        if (spoilerSpanArr.length <= 1) {
            return CollectionsKt.listOf(spoilerSpan);
        }
        Set setMutableSetOf = SetsKt.mutableSetOf(spoilerSpan);
        int spanStart = spannable.getSpanStart(spoilerSpan);
        int spanEnd = spannable.getSpanEnd(spoilerSpan);
        for (boolean z2 = true; z2; z2 = z) {
            Iterator it = ArrayIteratorKt.iterator(spoilerSpanArr);
            z = false;
            while (it.hasNext()) {
                SpoilerSpan spoilerSpan2 = (SpoilerSpan) it.next();
                if (!setMutableSetOf.contains(spoilerSpan2)) {
                    int spanStart2 = spannable.getSpanStart(spoilerSpan2);
                    int spanEnd2 = spannable.getSpanEnd(spoilerSpan2);
                    if (spanEnd2 >= spanStart && spanStart2 <= spanEnd) {
                        Intrinsics.checkNotNull(spoilerSpan2);
                        setMutableSetOf.add(spoilerSpan2);
                        if (spanStart2 < spanStart) {
                            spanStart = spanStart2;
                        }
                        if (spanEnd2 > spanEnd) {
                            spanEnd = spanEnd2;
                        }
                        z = true;
                    }
                }
            }
        }
        return CollectionsKt.sortedWith(setMutableSetOf, new Comparator() { // from class: com.swmansion.enriched.markdown.utils.text.view.LinkLongPressMovementMethod$expandContiguousSpoilers$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.compareValues(Integer.valueOf(spannable.getSpanStart((SpoilerSpan) obj)), Integer.valueOf(spannable.getSpanStart((SpoilerSpan) obj2)));
            }
        });
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinkLongPressMovementMethod createInstance() {
            return new LinkLongPressMovementMethod();
        }
    }
}
