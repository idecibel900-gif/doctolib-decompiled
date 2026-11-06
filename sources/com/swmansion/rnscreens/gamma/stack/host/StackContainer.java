package com.swmansion.rnscreens.gamma.stack.host;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelper;
import com.swmansion.rnscreens.gamma.helpers.ViewIdGenerator;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreenFragment;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackContainer extends CoordinatorLayout implements FragmentManager.OnBackStackChangedListener {
    public static final Companion Companion = new Companion(null);
    private final WeakReference delegate;
    private FragmentManager fragmentManager;
    private final FragmentOperationExecutor fragmentOpExecutor;
    private final List fragmentOps;
    private final List pendingPopOperations;
    private final List pendingPushOperations;
    private final List stackModel;

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackContainer(Context context, WeakReference delegate) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.stackModel = new ArrayList();
        this.pendingPopOperations = new ArrayList();
        this.pendingPushOperations = new ArrayList();
        this.fragmentOpExecutor = new FragmentOperationExecutor();
        this.fragmentOps = new ArrayList();
        setId(ViewIdGenerator.INSTANCE.generateViewId());
    }

    private final FragmentManager requireFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("[RNScreens] Attempt to use nullish FragmentManager");
    }

    private final StackContainerParent containerParentOrNull() {
        return (StackContainerParent) getParent();
    }

    private final boolean getHasPendingOperations() {
        return (this.pendingPushOperations.isEmpty() && this.pendingPopOperations.isEmpty()) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        RNSLog.INSTANCE.d("StackContainer", "StackContainer [" + getId() + "] attached to window");
        super.onAttachedToWindow();
        setupFragmentManger$react_native_screens_release();
        updateLaidOutFlagIfNeededAndPossible();
        performContainerUpdateIfNeeded$react_native_screens_release();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        requireFragmentManager().removeOnBackStackChangedListener(this);
        this.fragmentManager = null;
    }

    public final void setupFragmentManger$react_native_screens_release() {
        FragmentManager fragmentManagerFindFragmentManagerForView = FragmentManagerHelper.INSTANCE.findFragmentManagerForView(this);
        if (fragmentManagerFindFragmentManagerForView == null) {
            throw new IllegalStateException("[RNScreens] Nullish fragment manager - can't run container operations");
        }
        fragmentManagerFindFragmentManagerForView.addOnBackStackChangedListener(this);
        this.fragmentManager = fragmentManagerFindFragmentManagerForView;
    }

    public final void performContainerUpdateIfNeeded$react_native_screens_release() {
        if (getHasPendingOperations() && isAttachedToWindow()) {
            performOperations(requireFragmentManager());
        }
    }

    public final void enqueuePushOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPushOperations.add(new PushOperation(stackScreen));
    }

    public final void enqueuePopOperation$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.pendingPopOperations.add(new PopOperation(stackScreen));
    }

    private final void performOperations(FragmentManager fragmentManager) {
        applyOperationsAndComputeFragmentManagerOperations();
        this.fragmentOpExecutor.executeOperations$react_native_screens_release(fragmentManager, this.fragmentOps, false);
        dumpStackModel();
    }

    private final void applyOperationsAndComputeFragmentManagerOperations() {
        Object next;
        this.fragmentOps.clear();
        if (getHasPendingOperations()) {
            this.fragmentOps.add(new OnCommitCallbackOp(new Runnable() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackContainer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateTopFragment();
                }
            }, true, false));
        }
        for (PopOperation popOperation : this.pendingPopOperations) {
            Iterator it = this.stackModel.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((StackScreenFragment) next).getStackScreen$react_native_screens_release() != popOperation.getScreen());
            if (next == null) {
                throw new IllegalStateException("[RNScreens] Unable to find a fragment to pop");
            }
            StackScreenFragment stackScreenFragment = (StackScreenFragment) next;
            if (this.stackModel.size() <= 1) {
                throw new IllegalStateException("[RNScreens] Attempt to pop last screen from the stack");
            }
            this.fragmentOps.add(new PopBackStackOp(stackScreenFragment));
            List list = this.stackModel;
            if (list.remove(CollectionsKt.getLastIndex(list)) != stackScreenFragment) {
                throw new IllegalStateException("[RNScreens] Attempt to pop non-top screen");
            }
        }
        Iterator it2 = this.pendingPushOperations.iterator();
        while (it2.hasNext()) {
            StackScreenFragment stackScreenFragmentCreateFragmentForScreen = createFragmentForScreen(((PushOperation) it2.next()).getScreen());
            this.fragmentOps.add(new AddAndSetAsPrimaryOp(stackScreenFragmentCreateFragmentForScreen, getId(), !this.stackModel.isEmpty(), false, 8, null));
            this.stackModel.add(stackScreenFragmentCreateFragmentForScreen);
        }
        if (this.stackModel.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Stack should never be empty after updates");
        }
        this.pendingPopOperations.clear();
        this.pendingPushOperations.clear();
    }

    private final void onNativeFragmentPop(StackScreenFragment stackScreenFragment) {
        if (!this.stackModel.remove(stackScreenFragment)) {
            throw new IllegalArgumentException("[RNScreens] onNativeFragmentPop must be called with the fragment present in stack model");
        }
        if (this.stackModel.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Stack model should not be empty after a native pop");
        }
        if (requireFragmentManager().getPrimaryNavigationFragment() == stackScreenFragment) {
            throw new IllegalStateException("[RNScreens] Primary navigation fragment not updated by native pop");
        }
        updateTopFragment();
    }

    private final void dumpStackModel() {
        getId();
        Iterator it = this.stackModel.iterator();
        while (it.hasNext()) {
            ((StackScreenFragment) it.next()).getStackScreen$react_native_screens_release().getScreenKey();
        }
    }

    private final StackScreenFragment createFragmentForScreen(StackScreen stackScreen) {
        StackScreenFragment stackScreenFragment = new StackScreenFragment(stackScreen);
        stackScreen.getScreenKey();
        stackScreenFragment.toString();
        return stackScreenFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTopFragment() {
        FragmentManager fragmentManagerRequireFragmentManager = requireFragmentManager();
        List fragments = fragmentManagerRequireFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof StackScreenFragment) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("[RNScreens] Empty fragment manager while attempting to update top fragment");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StackScreenFragment) it.next()).onResignTopFragment$react_native_screens_release();
        }
        ((StackScreenFragment) CollectionsKt.last((List) arrayList)).onBecomeTopFragment$react_native_screens_release();
        if (fragmentManagerRequireFragmentManager.getPrimaryNavigationFragment() != CollectionsKt.last((List) arrayList)) {
            throw new IllegalStateException("[RNScreens] Top fragment different from primary navigation fragment");
        }
    }

    private final void updateLaidOutFlagIfNeededAndPossible() {
        StackContainerParent stackContainerParentContainerParentOrNull;
        if (!isAttachedToWindow() || !ViewExtKt.isMeasured(this) || isLaidOut() || isInLayout() || (stackContainerParentContainerParentOrNull = containerParentOrNull()) == null) {
            return;
        }
        stackContainerParentContainerParentOrNull.layoutContainerNow();
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChangeCommitted(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!(fragment instanceof StackScreenFragment)) {
            fragment.getClass();
            return;
        }
        StackScreenFragment stackScreenFragment = (StackScreenFragment) fragment;
        if (stackScreenFragment.isRemoving()) {
            StackContainerDelegate stackContainerDelegate = (StackContainerDelegate) this.delegate.get();
            if (stackContainerDelegate != null) {
                stackContainerDelegate.onScreenDismissCommitted(stackScreenFragment.getStackScreen$react_native_screens_release());
            }
            if (this.stackModel.contains(fragment)) {
                onNativeFragmentPop(stackScreenFragment);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
