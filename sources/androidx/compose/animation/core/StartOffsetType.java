package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class StartOffsetType {
    public static final Companion Companion = new Companion(null);
    private static final int Delay = m84constructorimpl(-1);
    private static final int FastForward = m84constructorimpl(1);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m84constructorimpl(int i) {
        return i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDelay-Eo1U57Q, reason: not valid java name */
        public final int m85getDelayEo1U57Q() {
            return StartOffsetType.Delay;
        }
    }
}
