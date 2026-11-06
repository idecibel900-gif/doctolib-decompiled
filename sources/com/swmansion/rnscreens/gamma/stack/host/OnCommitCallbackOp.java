package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnCommitCallbackOp extends FragmentOperation {
    private final boolean allowStateLoss;
    private final boolean flushSync;
    private final Runnable onCommitCallback;

    public final Runnable getOnCommitCallback() {
        return this.onCommitCallback;
    }

    public final boolean getAllowStateLoss() {
        return this.allowStateLoss;
    }

    public final boolean getFlushSync() {
        return this.flushSync;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnCommitCallbackOp(Runnable onCommitCallback, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(onCommitCallback, "onCommitCallback");
        this.onCommitCallback = onCommitCallback;
        this.allowStateLoss = z;
        this.flushSync = z2;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executeOnCommitCallbackOp$react_native_screens_release(fragmentManager, this);
    }
}
