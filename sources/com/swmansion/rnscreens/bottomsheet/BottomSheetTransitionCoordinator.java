package com.swmansion.rnscreens.bottomsheet;

import com.swmansion.rnscreens.Screen;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BottomSheetTransitionCoordinator {
    private boolean areInsetsApplied;
    private boolean isLayoutComplete;

    public final void onScreenContainerLayoutChanged$react_native_screens_release(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.isLayoutComplete = true;
        triggerSheetEnterTransitionIfReady(screen);
    }

    public final void onScreenContainerInsetsApplied$react_native_screens_release(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.areInsetsApplied = true;
        triggerSheetEnterTransitionIfReady(screen);
    }

    private final void triggerSheetEnterTransitionIfReady(Screen screen) {
        if (this.isLayoutComplete && this.areInsetsApplied) {
            screen.requestTriggeringPostponedEnterTransition$react_native_screens_release();
            screen.triggerPostponedEnterTransitionIfNeeded$react_native_screens_release();
        }
    }
}
