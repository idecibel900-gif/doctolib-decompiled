package androidx.metrics.performance;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class JankStatsBaseImpl {
    public static final Companion Companion = new Companion(null);
    private static long frameDuration = -1;
    private final JankStats jankStats;

    public abstract void setupFrameTimer(boolean z);

    public JankStatsBaseImpl(JankStats jankStats) {
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        this.jankStats = jankStats;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getFrameDuration() {
            return JankStatsBaseImpl.frameDuration;
        }

        public final void setFrameDuration(long j) {
            JankStatsBaseImpl.frameDuration = j;
        }
    }
}
