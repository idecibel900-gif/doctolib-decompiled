package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AddAndSetAsPrimaryOp extends FragmentOperation {
    private final boolean addToBackStack;
    private final boolean allowStateLoss;
    private final int containerViewId;
    private final StackScreenFragment fragment;

    public /* synthetic */ AddAndSetAsPrimaryOp(StackScreenFragment stackScreenFragment, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackScreenFragment, i, z, (i2 & 8) != 0 ? true : z2);
    }

    public final StackScreenFragment getFragment() {
        return this.fragment;
    }

    public final int getContainerViewId() {
        return this.containerViewId;
    }

    public final boolean getAddToBackStack() {
        return this.addToBackStack;
    }

    public final boolean getAllowStateLoss() {
        return this.allowStateLoss;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAndSetAsPrimaryOp(StackScreenFragment fragment, int i, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.containerViewId = i;
        this.addToBackStack = z;
        this.allowStateLoss = z2;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.FragmentOperation
    public void execute$react_native_screens_release(FragmentManager fragmentManager, FragmentOperationExecutor executor) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.executeAddAndSetAsPrimaryOp$react_native_screens_release(fragmentManager, this);
    }
}
