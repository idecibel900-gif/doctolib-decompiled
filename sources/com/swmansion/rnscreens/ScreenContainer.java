package com.swmansion.rnscreens;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public class ScreenContainer extends ViewGroup {
    protected FragmentManager fragmentManager;
    private boolean isAttached;
    private boolean isLayoutEnqueued;
    private boolean isRetryScheduled;
    private final Choreographer.FrameCallback layoutCallback;
    private boolean needsUpdate;
    private ScreenFragmentWrapper parentScreenWrapper;
    protected final ArrayList screenWrappers;

    public ScreenContainer(Context context) {
        super(context);
        this.screenWrappers = new ArrayList();
        this.layoutCallback = new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.ScreenContainer$layoutCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                this.this$0.isLayoutEnqueued = false;
                ScreenContainer screenContainer = this.this$0;
                screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824));
                ScreenContainer screenContainer2 = this.this$0;
                screenContainer2.layout(screenContainer2.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.isLayoutEnqueued || this.layoutCallback == null) {
            return;
        }
        this.isLayoutEnqueued = true;
        ReactChoreographer.Companion.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.layoutCallback);
    }

    public final void onChildUpdate() {
        performUpdatesNow();
    }

    protected ScreenFragmentWrapper adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final void addScreen(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        ScreenFragmentWrapper screenFragmentWrapperAdapt = adapt(screen);
        screen.setFragmentWrapper(screenFragmentWrapperAdapt);
        this.screenWrappers.add(i, screenFragmentWrapperAdapt);
        screen.setContainer(this);
        onScreenChanged();
    }

    public void removeScreenAt(int i) {
        ((ScreenFragmentWrapper) this.screenWrappers.get(i)).getScreen().setContainer(null);
        this.screenWrappers.remove(i);
        onScreenChanged();
    }

    public void removeAllScreens() {
        Iterator it = this.screenWrappers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ((ScreenFragmentWrapper) next).getScreen().setContainer(null);
        }
        this.screenWrappers.clear();
        onScreenChanged();
    }

    public final int getScreenCount() {
        return this.screenWrappers.size();
    }

    public final Screen getScreenAt(int i) {
        return ((ScreenFragmentWrapper) this.screenWrappers.get(i)).getScreen();
    }

    public final ScreenFragmentWrapper getScreenFragmentWrapperAt(int i) {
        Object obj = this.screenWrappers.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (ScreenFragmentWrapper) obj;
    }

    public Screen getTopScreen() {
        Object next;
        Iterator it = this.screenWrappers.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (getActivityState((ScreenFragmentWrapper) next) != Screen.ActivityState.ON_TOP);
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getScreen();
        }
        return null;
    }

    private final void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        performUpdatesNow();
    }

    private final FragmentManager findFragmentManagerForReactRootView(ReactRootView reactRootView) {
        boolean z;
        Context context = reactRootView.getContext();
        while (true) {
            z = context instanceof FragmentActivity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (!z) {
            throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactActivity");
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity.getSupportFragmentManager().getFragments().isEmpty()) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNull(supportFragmentManager);
            return supportFragmentManager;
        }
        try {
            FragmentManager childFragmentManager = FragmentManager.findFragment(reactRootView).getChildFragmentManager();
            Intrinsics.checkNotNull(childFragmentManager);
            return childFragmentManager;
        } catch (IllegalStateException unused) {
            FragmentManager supportFragmentManager2 = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNull(supportFragmentManager2);
            return supportFragmentManager2;
        }
    }

    private final void setupFragmentManager() {
        boolean z;
        Unit unit;
        ViewParent parent = this;
        while (true) {
            z = parent instanceof ReactRootView;
            if (z || (parent instanceof FragmentProviding) || parent.getParent() == null) {
                break;
            }
            parent = parent.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
        }
        if (parent instanceof Screen) {
            ScreenFragmentWrapper fragmentWrapper = ((Screen) parent).getFragmentWrapper();
            if (fragmentWrapper != null) {
                this.parentScreenWrapper = fragmentWrapper;
                fragmentWrapper.addChildScreenContainer(this);
                FragmentManager childFragmentManager = fragmentWrapper.getFragment().getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                setFragmentManager(childFragmentManager);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("Parent Screen does not have its Fragment attached");
            }
            return;
        }
        if (!(parent instanceof FragmentProviding)) {
            if (!z) {
                throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
            }
            setFragmentManager(findFragmentManagerForReactRootView((ReactRootView) parent));
            return;
        }
        Fragment associatedFragment = ((FragmentProviding) parent).getAssociatedFragment();
        if (associatedFragment != null) {
            FragmentManager childFragmentManager2 = associatedFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            setFragmentManager(childFragmentManager2);
        } else {
            throw new IllegalStateException(("[RNScreens] Parent " + parent + " returned nullish fragment").toString());
        }
    }

    protected final FragmentTransaction createTransaction() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager == null) {
            throw new IllegalArgumentException("fragment manager is null when creating transaction");
        }
        FragmentTransaction reorderingAllowed = fragmentManager.beginTransaction().setReorderingAllowed(true);
        Intrinsics.checkNotNullExpressionValue(reorderingAllowed, "setReorderingAllowed(...)");
        return reorderingAllowed;
    }

    private final void attachScreen(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.add(getId(), fragment);
    }

    public final void attachBelowTop() {
        if (this.screenWrappers.size() < 2) {
            throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        Screen topScreen = getTopScreen();
        Intrinsics.checkNotNull(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
        Fragment fragment = topScreen.getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        detachScreen(fragmentTransactionCreateTransaction, fragment);
        ArrayList arrayList = this.screenWrappers;
        attachScreen(fragmentTransactionCreateTransaction, ((ScreenFragmentWrapper) arrayList.get(arrayList.size() - 2)).getFragment());
        Fragment fragment2 = topScreen.getFragment();
        Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        attachScreen(fragmentTransactionCreateTransaction, fragment2);
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    public final void detachBelowTop() {
        if (this.screenWrappers.size() < 2) {
            throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        ArrayList arrayList = this.screenWrappers;
        detachScreen(fragmentTransactionCreateTransaction, ((ScreenFragmentWrapper) arrayList.get(arrayList.size() - 2)).getFragment());
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    public final void notifyScreenDetached(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (getContext() instanceof ReactContext) {
            int surfaceId = UIManagerHelper.getSurfaceId(getContext());
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, screen.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, screen.getId()));
            }
        }
    }

    public final void notifyTopDetached() {
        Screen topScreen = getTopScreen();
        Intrinsics.checkNotNull(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
        if (getContext() instanceof ReactContext) {
            int surfaceId = UIManagerHelper.getSurfaceId(getContext());
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, topScreen.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, topScreen.getId()));
            }
        }
    }

    private final void detachScreen(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.remove(fragment);
    }

    private final Screen.ActivityState getActivityState(ScreenFragmentWrapper screenFragmentWrapper) {
        return screenFragmentWrapper.getScreen().getActivityState();
    }

    public boolean hasScreen(ScreenFragmentWrapper screenFragmentWrapper) {
        return CollectionsKt.contains(this.screenWrappers, screenFragmentWrapper);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        setupFragmentManager();
    }

    private final void removeMyFragments(final FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        boolean z = false;
        for (Fragment fragment : fragmentManager.getFragments()) {
            if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).getScreen().getContainer() == this) {
                fragmentTransactionBeginTransaction.remove(fragment);
                z = true;
            }
        }
        if (z) {
            try {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
            } catch (IllegalStateException unused) {
                post(new Runnable() { // from class: com.swmansion.rnscreens.ScreenContainer$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenContainer.removeMyFragments$lambda$7(fragmentManager, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeMyFragments$lambda$7(FragmentManager fragmentManager, ScreenContainer screenContainer) {
        if (fragmentManager.isDestroyed() || fragmentManager.isStateSaved()) {
            return;
        }
        try {
            screenContainer.removeMyFragments(fragmentManager);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            removeMyFragments(fragmentManager);
            try {
                fragmentManager.executePendingTransactions();
            } catch (IllegalStateException e) {
                if (!isFragmentManagerBusy(e)) {
                    throw e;
                }
            }
        }
        ScreenFragmentWrapper screenFragmentWrapper = this.parentScreenWrapper;
        if (screenFragmentWrapper != null) {
            screenFragmentWrapper.removeChildScreenContainer(this);
        }
        this.parentScreenWrapper = null;
        super.onDetachedFromWindow();
        this.isAttached = false;
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            } else {
                removeViewAt(childCount);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    private final void onScreenChanged() {
        this.needsUpdate = true;
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenContainer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.performUpdates();
            }
        });
    }

    protected final void performUpdatesNow() {
        this.needsUpdate = true;
        performUpdates();
    }

    public final void performUpdates() {
        FragmentManager fragmentManager;
        if (this.needsUpdate && this.isAttached && (fragmentManager = this.fragmentManager) != null) {
            if (fragmentManager == null || !fragmentManager.isDestroyed()) {
                this.needsUpdate = false;
                onUpdate();
                notifyContainerUpdate();
            }
        }
    }

    public void onUpdate() {
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            HashSet hashSet = new HashSet(fragmentManager.getFragments());
            Iterator it = this.screenWrappers.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
                if (getActivityState(screenFragmentWrapper) == Screen.ActivityState.INACTIVE && screenFragmentWrapper.getFragment().isAdded()) {
                    detachScreen(fragmentTransactionCreateTransaction, screenFragmentWrapper.getFragment());
                }
                hashSet.remove(screenFragmentWrapper.getFragment());
            }
            boolean z = false;
            if (!hashSet.isEmpty()) {
                for (Fragment fragment : (Fragment[]) hashSet.toArray(new Fragment[0])) {
                    if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).getScreen().getContainer() == null) {
                        detachScreen(fragmentTransactionCreateTransaction, fragment);
                    }
                }
            }
            boolean z2 = getTopScreen() == null;
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.screenWrappers.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) next2;
                screenFragmentWrapper2.getScreen().setTransitioning(z2);
                if (getActivityState(screenFragmentWrapper2) != Screen.ActivityState.INACTIVE) {
                    if (screenFragmentWrapper2.getFragment().isAdded()) {
                        if (z) {
                            detachScreen(fragmentTransactionCreateTransaction, screenFragmentWrapper2.getFragment());
                            arrayList.add(screenFragmentWrapper2);
                        }
                    } else if (z) {
                        arrayList.add(screenFragmentWrapper2);
                    } else {
                        attachScreen(fragmentTransactionCreateTransaction, screenFragmentWrapper2.getFragment());
                        z = true;
                    }
                }
            }
            Iterator it3 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                Object next3 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                attachScreen(fragmentTransactionCreateTransaction, ((ScreenFragmentWrapper) next3).getFragment());
            }
            try {
                fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
                return;
            } catch (IllegalStateException e) {
                if (!isFragmentManagerBusy(e)) {
                    throw e;
                }
                if (this.isRetryScheduled) {
                    return;
                }
                this.isRetryScheduled = true;
                post(new Runnable() { // from class: com.swmansion.rnscreens.ScreenContainer$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenContainer.onUpdate$lambda$12$lambda$11(this.f$0);
                    }
                });
                return;
            }
        }
        throw new IllegalArgumentException("fragment manager is null when performing update in ScreenContainer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$12$lambda$11(ScreenContainer screenContainer) {
        screenContainer.isRetryScheduled = false;
        screenContainer.performUpdatesNow();
    }

    protected void notifyContainerUpdate() {
        ScreenFragmentWrapper fragmentWrapper;
        Screen topScreen = getTopScreen();
        if (topScreen == null || (fragmentWrapper = topScreen.getFragmentWrapper()) == null) {
            return;
        }
        fragmentWrapper.onContainerUpdate();
    }

    private final boolean isFragmentManagerBusy(IllegalStateException illegalStateException) {
        String message = illegalStateException.getMessage();
        return message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "already executing transactions", false, 2, (Object) null);
    }
}
