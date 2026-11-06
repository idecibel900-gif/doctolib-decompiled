package com.swmansion.enriched.markdown.spoiler;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import com.swmansion.enriched.markdown.styles.SpoilerStyle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SolidStrategy implements SpoilerStrategy {
    private float borderRadius;
    private int color;
    private final Map segments = new LinkedHashMap();
    private final Paint solidPaint = new Paint();
    private final RectF rectF = new RectF();

    private static final class SegmentState {
        private float alpha;
        private Function0 revealCallback;
        private boolean revealFinished;
        private long revealStartTime;
        private boolean revealing;

        public SegmentState(float f, boolean z, long j, boolean z2, Function0 function0) {
            this.alpha = f;
            this.revealing = z;
            this.revealStartTime = j;
            this.revealFinished = z2;
            this.revealCallback = function0;
        }

        public /* synthetic */ SegmentState(float f, boolean z, long j, boolean z2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? false : z, (i & 4) != 0 ? -1L : j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : function0);
        }

        public final float getAlpha() {
            return this.alpha;
        }

        public final void setAlpha(float f) {
            this.alpha = f;
        }

        public final boolean getRevealing() {
            return this.revealing;
        }

        public final void setRevealing(boolean z) {
            this.revealing = z;
        }

        public final long getRevealStartTime() {
            return this.revealStartTime;
        }

        public final void setRevealStartTime(long j) {
            this.revealStartTime = j;
        }

        public final boolean getRevealFinished() {
            return this.revealFinished;
        }

        public final void setRevealFinished(boolean z) {
            this.revealFinished = z;
        }

        public final Function0 getRevealCallback() {
            return this.revealCallback;
        }

        public final void setRevealCallback(Function0 function0) {
            this.revealCallback = function0;
        }
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void applyStyle(SpoilerStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.color = style.getColor();
        this.borderRadius = style.getSolidBorderRadius() * Resources.getSystem().getDisplayMetrics().density;
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void drawSegment(Canvas canvas, SpoilerDrawContext context, SegmentKey key, SegmentRect rect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Map map = this.segments;
        Object obj = map.get(key);
        if (obj == null) {
            SegmentState segmentState = new SegmentState(0.0f, false, 0L, false, null, 31, null);
            map.put(key, segmentState);
            obj = segmentState;
        }
        SegmentState segmentState2 = (SegmentState) obj;
        if (segmentState2.getRevealing()) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (segmentState2.getRevealStartTime() < 0) {
                segmentState2.setRevealStartTime(jUptimeMillis);
            }
            float fCoerceIn = RangesKt.coerceIn((jUptimeMillis - segmentState2.getRevealStartTime()) / 450, 0.0f, 1.0f);
            float f = 1.0f - fCoerceIn;
            segmentState2.setAlpha(f * f);
            if (fCoerceIn >= 1.0f && !segmentState2.getRevealFinished()) {
                segmentState2.setRevealFinished(true);
                Function0 revealCallback = segmentState2.getRevealCallback();
                if (revealCallback != null) {
                    revealCallback.invoke();
                }
                segmentState2.setRevealCallback(null);
            }
        }
        if (!segmentState2.getRevealFinished()) {
            this.solidPaint.setColor(SpoilerDrawUtilsKt.colorWithAlpha(this.color, segmentState2.getAlpha()));
            this.rectF.set(rect.getLeft(), rect.getTop(), rect.getLeft() + rect.getWidth(), rect.getTop() + rect.getHeight());
            RectF rectF = this.rectF;
            float f2 = this.borderRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.solidPaint);
        }
        if (!segmentState2.getRevealing() || segmentState2.getRevealFinished()) {
            return;
        }
        context.getTextView().postInvalidateOnAnimation();
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void pruneStaleSegments(Set activeKeys) {
        Intrinsics.checkNotNullParameter(activeKeys, "activeKeys");
        Iterator it = SetsKt.minus(this.segments.keySet(), (Iterable) activeKeys).iterator();
        while (it.hasNext()) {
            this.segments.remove((SegmentKey) it.next());
        }
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void revealSpan(SpoilerSpan span, SpoilerDrawContext context, Function0 onAllComplete) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onAllComplete, "onAllComplete");
        SpoilerStrategyKt.revealSegments(span, this.segments.keySet(), onAllComplete, new Function1() { // from class: com.swmansion.enriched.markdown.spoiler.SolidStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SolidStrategy.revealSpan$lambda$2(this.f$0, (List) obj);
            }
        }, new Function2() { // from class: com.swmansion.enriched.markdown.spoiler.SolidStrategy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SolidStrategy.revealSpan$lambda$4(this.f$0, (SegmentKey) obj, (Function0) obj2);
            }
        });
        context.getTextView().invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSpan$lambda$2(SolidStrategy solidStrategy, List keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            solidStrategy.segments.remove((SegmentKey) it.next());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSpan$lambda$4(SolidStrategy solidStrategy, SegmentKey key, Function0 onComplete) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        SegmentState segmentState = (SegmentState) solidStrategy.segments.get(key);
        if (segmentState != null) {
            segmentState.setRevealing(true);
            segmentState.setRevealCallback(onComplete);
        }
        return Unit.INSTANCE;
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void stop() {
        this.segments.clear();
    }
}
