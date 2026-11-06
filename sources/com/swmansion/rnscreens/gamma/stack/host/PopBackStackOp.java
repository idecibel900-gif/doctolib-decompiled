package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PopBackStackOp extends FragmentOperation {
    private final StackScreenFragment fragment;

    public final StackScreenFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopBackStackOp(StackScreenFragment fragment) {
        super(null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executePopBackStackOp$react_native_screens_release(fragmentManager, this);
    }
}
