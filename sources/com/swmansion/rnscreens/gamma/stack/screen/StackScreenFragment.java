package com.swmansion.rnscreens.gamma.stack.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.transition.Slide;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenFragment extends Fragment {
    private boolean isTopFragment;
    private PreventNativeDismissCallback preventNativeDismissBackPressedCallback;
    private StackScreenAppearanceEventsEmitter screenLifecycleEventEmitter;
    private final StackScreen stackScreen;

    public final StackScreen getStackScreen$react_native_screens_release() {
        return this.stackScreen;
    }

    public StackScreenFragment(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.stackScreen = stackScreen;
    }

    private final PreventNativeDismissCallback getRequireNativeDismissBackPressedCallback() {
        PreventNativeDismissCallback preventNativeDismissCallback = this.preventNativeDismissBackPressedCallback;
        if (preventNativeDismissCallback != null) {
            return preventNativeDismissCallback;
        }
        throw new IllegalStateException("[RNScreens] Attempt to require nullish OnBackPressedCallback");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupPreventNativeDismissCallback();
        setAllowEnterTransitionOverlap(true);
        setAllowReturnTransitionOverlap(true);
        setEnterTransition(new Slide(5));
        setExitTransition(new Slide(3));
        setReturnTransition(new Slide(5));
        setReenterTransition(new Slide(3));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return this.stackScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        StackScreen stackScreen = this.stackScreen;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.screenLifecycleEventEmitter = stackScreen.createAppearanceEventsEmitter$react_native_screens_release(viewLifecycleOwner);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.screenLifecycleEventEmitter = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.stackScreen.onDismiss$react_native_screens_release();
        teardownPreventNativeDismissCallback();
    }

    public final void onBecomeTopFragment$react_native_screens_release() {
        if (this.isTopFragment) {
            return;
        }
        this.isTopFragment = true;
        getRequireNativeDismissBackPressedCallback().setCanBeEnabled$react_native_screens_release(true);
    }

    public final void onResignTopFragment$react_native_screens_release() {
        if (this.isTopFragment) {
            this.isTopFragment = false;
            getRequireNativeDismissBackPressedCallback().setCanBeEnabled$react_native_screens_release(false);
        }
    }

    private final void setupPreventNativeDismissCallback() {
        this.preventNativeDismissBackPressedCallback = new PreventNativeDismissCallback(this, this.stackScreen, false);
        requireActivity().getOnBackPressedDispatcher().addCallback(getRequireNativeDismissBackPressedCallback());
    }

    private final void teardownPreventNativeDismissCallback() {
        getRequireNativeDismissBackPressedCallback().remove();
        this.preventNativeDismissBackPressedCallback = null;
    }
}
