package com.swmansion.rnscreens.gamma.stack.host;

import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PushOperation extends StackOperation {
    private final StackScreen screen;

    public final StackScreen getScreen() {
        return this.screen;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushOperation(StackScreen screen) {
        super(null);
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
    }
}
