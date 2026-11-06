package com.reactnativekeyboardcontroller.modules.statusbar;

import android.app.Activity;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeViewRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StatusBarManagerCompatModuleImpl {
    public static final Companion Companion = new Companion(null);
    private WindowInsetsControllerCompat controller;
    private WeakReference lastActivity;
    private final ReactApplicationContext mReactContext;
    private StatusBarModuleProxy original;

    public StatusBarManagerCompatModuleImpl(ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.original = new StatusBarModuleProxy(mReactContext);
        this.lastActivity = new WeakReference(null);
    }

    public final void setHidden(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StatusBarManagerCompatModuleImpl.setHidden$lambda$0(z, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$0(boolean z, StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl) {
        if (z) {
            WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
            if (controller != null) {
                controller.hide(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat controller2 = statusBarManagerCompatModuleImpl.getController();
        if (controller2 != null) {
            controller2.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    public final void setColor(int i, boolean z) {
        if (isEnabled()) {
            Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarModule: Ignored status bar change, current activity is edge-to-edge.", null, 4, null);
        } else {
            this.original.setColor(i, z);
        }
    }

    public final void setTranslucent(boolean z) {
        if (isEnabled()) {
            Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarModule: Ignored status bar change, current activity is edge-to-edge.", null, 4, null);
        } else {
            this.original.setTranslucent(z);
        }
    }

    public final void setStyle(final String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!isEnabled()) {
            this.original.setStyle(style);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setStyle$lambda$4(this.f$0, style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$4(StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl, String str) {
        WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
        if (controller != null) {
            controller.setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark-content"));
        }
    }

    public final Map getConstants() {
        return this.original.getConstants();
    }

    private final WindowInsetsControllerCompat getController() {
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (this.controller == null || !Intrinsics.areEqual(currentActivity, this.lastActivity.get())) {
            if (currentActivity == null) {
                Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarManagerCompatModule: can not get `WindowInsetsControllerCompat` because current activity is null.", null, 4, null);
                return this.controller;
            }
            Window window = currentActivity.getWindow();
            this.lastActivity = new WeakReference(currentActivity);
            this.controller = new WindowInsetsControllerCompat(window, window.getDecorView());
        }
        return this.controller;
    }

    private final boolean isEnabled() {
        EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroupView = view();
        if (edgeToEdgeReactViewGroupView != null) {
            return edgeToEdgeReactViewGroupView.getActive();
        }
        return false;
    }

    private final EdgeToEdgeReactViewGroup view() {
        return EdgeToEdgeViewRegistry.INSTANCE.get();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
