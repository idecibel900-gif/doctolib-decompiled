package com.swmansion.rnscreens.gamma.stack.screen;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PreventNativeDismissCallback extends OnBackPressedCallback implements LifecycleEventObserver, PreventNativeDismissChangeObserver {
    private boolean canBeEnabled;
    private final StackScreen screen;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreventNativeDismissCallback(LifecycleOwner lifecycleOwner, StackScreen screen, boolean z) {
        super(false);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
        this.canBeEnabled = z;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final void setCanBeEnabled$react_native_screens_release(boolean z) {
        this.canBeEnabled = z;
        determineEnabledStatus();
    }

    private final boolean getShouldBeEnabled() {
        return this.canBeEnabled && this.screen.isPreventNativeDismissEnabled$react_native_screens_release();
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.screen.getScreenKey();
        this.screen.onNativeDismissPrevented$react_native_screens_release();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            this.screen.setPreventNativeDismissChangeObserver$react_native_screens_release(this);
            return;
        }
        if (i == 2) {
            determineEnabledStatus();
            return;
        }
        if (i == 3) {
            setEnabled(false);
        } else {
            if (i != 4) {
                return;
            }
            source.getLifecycle().removeObserver(this);
            this.screen.setPreventNativeDismissChangeObserver$react_native_screens_release(null);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.stack.screen.PreventNativeDismissChangeObserver
    public void preventNativeDismissChanged(boolean z) {
        determineEnabledStatus();
    }

    private final void determineEnabledStatus() {
        setEnabled(getShouldBeEnabled());
    }
}
