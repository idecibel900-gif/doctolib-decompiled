package com.reactnativekeyboardcontroller.modules;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardControllerModuleImpl {
    public static final Companion Companion = new Companion(null);
    private final KeyboardAnimationController controller;
    private final int mDefaultMode;
    private final ReactApplicationContext mReactContext;

    public final void preload() {
    }

    public KeyboardControllerModuleImpl(ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.controller = new KeyboardAnimationController();
        this.mDefaultMode = getCurrentMode();
    }

    public final void setInputMode(int i) {
        setSoftInputMode(i);
    }

    public final void setDefaultMode() {
        setSoftInputMode(this.mDefaultMode);
    }

    public final void dismiss(final boolean z, final boolean z2) {
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        final EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.dismiss$lambda$2(z2, this, editText, currentActivity, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$2$maybeClearFocus(boolean z, View view) {
        if (z) {
            return;
        }
        view.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$2(boolean z, KeyboardControllerModuleImpl keyboardControllerModuleImpl, final View view, Activity activity, final boolean z2) {
        if (Build.VERSION.SDK_INT >= 30 && !z) {
            keyboardControllerModuleImpl.controller.startControlRequest(view, new Function1() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return KeyboardControllerModuleImpl.dismiss$lambda$2$lambda$1(view, z2, (WindowInsetsAnimationControllerCompat) obj);
                }
            });
            return;
        }
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        dismiss$lambda$2$maybeClearFocus(z2, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismiss$lambda$2$lambda$1(final View view, final boolean z, WindowInsetsAnimationControllerCompat insetsController) {
        Intrinsics.checkNotNullParameter(insetsController, "insetsController");
        insetsController.finish(false);
        view.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.dismiss$lambda$2$maybeClearFocus(z, view);
            }
        });
        return Unit.INSTANCE;
    }

    public final void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (Intrinsics.areEqual(direction, "current")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.setFocusTo$lambda$3();
                }
            });
            return;
        }
        EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            ViewHierarchyNavigator.INSTANCE.setFocusTo(direction, editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusTo$lambda$3() {
        FocusedInputHolder.INSTANCE.focus();
    }

    private final void setSoftInputMode(final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.setSoftInputMode$lambda$4(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSoftInputMode$lambda$4(KeyboardControllerModuleImpl keyboardControllerModuleImpl, int i) {
        Activity currentActivity;
        Window window;
        if (keyboardControllerModuleImpl.getCurrentMode() == i || (currentActivity = keyboardControllerModuleImpl.mReactContext.getCurrentActivity()) == null || (window = currentActivity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(i);
    }

    private final int getCurrentMode() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return 0;
        }
        return attributes.softInputMode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
