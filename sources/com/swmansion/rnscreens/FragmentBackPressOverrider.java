package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBackPressOverrider {
    private final Fragment fragment;
    private boolean isCallbackAdded;
    private final OnBackPressedCallback onBackPressedCallback;
    private boolean overrideBackAction;

    public FragmentBackPressOverrider(Fragment fragment, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.fragment = fragment;
        this.onBackPressedCallback = onBackPressedCallback;
        this.overrideBackAction = true;
    }

    public final boolean getOverrideBackAction() {
        return this.overrideBackAction;
    }

    public final void setOverrideBackAction(boolean z) {
        this.overrideBackAction = z;
    }

    public final void maybeAddBackCallback() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        if (this.isCallbackAdded || !this.overrideBackAction) {
            return;
        }
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(this.fragment, this.onBackPressedCallback);
        }
        this.isCallbackAdded = true;
    }

    public final void removeBackCallbackIfAdded() {
        if (this.isCallbackAdded) {
            this.onBackPressedCallback.remove();
            this.isCallbackAdded = false;
        }
    }
}
