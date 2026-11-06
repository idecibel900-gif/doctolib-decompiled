package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.util.RNLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogBoxDialogSurfaceDelegate implements SurfaceDelegate {
    private final DevSupportManager devSupportManager;
    private LogBoxDialog dialog;
    private View reactRootView;

    public LogBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void createContentView(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Assertions.assertCondition(Intrinsics.areEqual(appKey, "LogBox"), "This surface manager can only create LogBox React application");
        View viewCreateRootView = this.devSupportManager.createRootView("LogBox");
        this.reactRootView = viewCreateRootView;
        if (viewCreateRootView == null) {
            RNLog.e("Unable to launch logbox because react was unable to create the root view");
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isContentViewReady() {
        return this.reactRootView != null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void destroyContentView() {
        View view = this.reactRootView;
        if (view != null) {
            this.devSupportManager.destroyRootView(view);
            this.reactRootView = null;
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void show() {
        if (isShowing() || !isContentViewReady()) {
            return;
        }
        Activity currentActivity = this.devSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            RNLog.e("Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
            return;
        }
        LogBoxDialog logBoxDialog = new LogBoxDialog(currentActivity, this.reactRootView);
        this.dialog = logBoxDialog;
        logBoxDialog.setCancelable(false);
        logBoxDialog.show();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void hide() {
        LogBoxDialog logBoxDialog;
        if (isShowing() && (logBoxDialog = this.dialog) != null) {
            logBoxDialog.dismiss();
        }
        View view = this.reactRootView;
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(this.reactRootView);
        }
        this.dialog = null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isShowing() {
        LogBoxDialog logBoxDialog = this.dialog;
        if (logBoxDialog != null) {
            return logBoxDialog.isShowing();
        }
        return false;
    }
}
