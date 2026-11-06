package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyLayoutItemAnimation {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* JADX INFO: renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public abstract void m406animatePlacementDeltaar5cAso(long j, boolean z);

    public abstract void cancelPlacementAnimation();

    /* JADX INFO: renamed from: getFinalOffset-nOcc-ac, reason: not valid java name */
    public abstract long m407getFinalOffsetnOccac();

    public abstract GraphicsLayer getLayer();

    /* JADX INFO: renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name */
    public abstract long m408getLookaheadOffsetnOccac();

    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public abstract long m409getPlacementDeltanOccac();

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name */
    public abstract long m410getRawOffsetnOccac();

    public abstract boolean isRunningMovingAwayAnimation();

    public abstract void release();

    /* JADX INFO: renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public abstract void m411setFinalOffsetgyyYBs(long j);

    /* JADX INFO: renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public abstract void m412setLookaheadOffsetgyyYBs(long j);

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public abstract void m413setRawOffsetgyyYBs(long j);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m414getNotInitializednOccac() {
            return LazyLayoutItemAnimation.NotInitialized;
        }
    }
}
