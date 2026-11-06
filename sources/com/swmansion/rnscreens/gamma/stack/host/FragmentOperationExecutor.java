package com.swmansion.rnscreens.gamma.stack.host;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelperKt;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentOperationExecutor {
    public final void executeOperations$react_native_screens_release(FragmentManager fragmentManager, List ops, boolean z) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(ops, "ops");
        Iterator it = ops.iterator();
        while (it.hasNext()) {
            ((FragmentOperation) it.next()).execute$react_native_screens_release(fragmentManager, this);
        }
        if (z) {
            fragmentManager.executePendingTransactions();
        }
    }

    public final void executeAddAndSetAsPrimaryOp$react_native_screens_release(FragmentManager fragmentManager, AddAndSetAsPrimaryOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(fragmentManager);
        if (op.getAddToBackStack()) {
            fragmentTransactionCreateTransactionWithReordering.addToBackStack(op.getFragment().getStackScreen$react_native_screens_release().getScreenKey());
        }
        fragmentTransactionCreateTransactionWithReordering.add(op.getContainerViewId(), op.getFragment());
        fragmentTransactionCreateTransactionWithReordering.setPrimaryNavigationFragment(op.getFragment());
        commitTransaction$default(this, fragmentTransactionCreateTransactionWithReordering, op.getAllowStateLoss(), false, 4, null);
    }

    public final void executePopBackStackOp$react_native_screens_release(FragmentManager fragmentManager, PopBackStackOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        fragmentManager.popBackStack(op.getFragment().getStackScreen$react_native_screens_release().getScreenKey(), 1);
    }

    public final void executeOnCommitCallbackOp$react_native_screens_release(FragmentManager fragmentManager, OnCommitCallbackOp op) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(op, "op");
        FragmentTransaction fragmentTransactionRunOnCommit = FragmentManagerHelperKt.createTransactionWithReordering(fragmentManager).runOnCommit(op.getOnCommitCallback());
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionRunOnCommit, "runOnCommit(...)");
        commitTransaction(fragmentTransactionRunOnCommit, op.getAllowStateLoss(), op.getFlushSync());
    }

    static /* synthetic */ void commitTransaction$default(FragmentOperationExecutor fragmentOperationExecutor, FragmentTransaction fragmentTransaction, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        fragmentOperationExecutor.commitTransaction(fragmentTransaction, z, z2);
    }

    private final void commitTransaction(FragmentTransaction fragmentTransaction, boolean z, boolean z2) {
        if (z2) {
            commitSync(fragmentTransaction, z);
        } else {
            commitAsync(fragmentTransaction, z);
        }
    }

    private final void commitAsync(FragmentTransaction fragmentTransaction, boolean z) {
        if (z) {
            fragmentTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransaction.commit();
        }
    }

    private final void commitSync(FragmentTransaction fragmentTransaction, boolean z) {
        if (z) {
            fragmentTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransaction.commitNow();
        }
    }
}
