package com.swmansion.rnscreens;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStackHeaderHeightUpdateProxy {
    private Integer previousHeaderHeightInPx;

    public final void updateHeaderHeightIfNeeded(ScreenStackHeaderConfig config, Screen screen) {
        Intrinsics.checkNotNullParameter(config, "config");
        int height = config.isHeaderHidden() ? 0 : config.getToolbar().getHeight();
        Integer num = this.previousHeaderHeightInPx;
        if (num != null && height == num.intValue()) {
            return;
        }
        this.previousHeaderHeightInPx = Integer.valueOf(height);
        if (screen != null) {
            screen.notifyHeaderHeightChange$react_native_screens_release(height);
        }
    }
}
