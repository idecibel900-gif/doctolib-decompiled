package io.sentry.android.replay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayLifecycle {
    private volatile ReplayState currentState = ReplayState.INITIAL;

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReplayState.values().length];
            try {
                iArr[ReplayState.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReplayState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReplayState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReplayState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReplayState.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReplayState.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ReplayState getCurrentState$sentry_android_replay_release() {
        return this.currentState;
    }

    public final void setCurrentState$sentry_android_replay_release(ReplayState replayState) {
        Intrinsics.checkNotNullParameter(replayState, "<set-?>");
        this.currentState = replayState;
    }

    public final boolean isAllowed(ReplayState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentState.ordinal()]) {
            case 1:
                return newState == ReplayState.STARTED || newState == ReplayState.CLOSED;
            case 2:
                return newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 3:
                return newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 4:
                return newState == ReplayState.RESUMED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 5:
                return newState == ReplayState.STARTED || newState == ReplayState.CLOSED;
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isTouchRecordingAllowed() {
        return this.currentState == ReplayState.STARTED || this.currentState == ReplayState.RESUMED;
    }
}
