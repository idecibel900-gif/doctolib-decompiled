package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.react.R$style;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RedBoxDialogSurfaceDelegate implements SurfaceDelegate {
    public static final Companion Companion = new Companion(null);
    private final DevSupportManager devSupportManager;
    private Dialog dialog;
    private final DoubleTapReloadRecognizer doubleTapReloadRecognizer;
    private RedBoxContentView redBoxContentView;

    public RedBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
        this.doubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void createContentView(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.devSupportManager.getRedBoxHandler();
        Activity currentActivity = this.devSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            String lastErrorTitle = this.devSupportManager.getLastErrorTitle();
            if (lastErrorTitle == null) {
                lastErrorTitle = "N/A";
            }
            FLog.e("ReactNative", "Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: " + lastErrorTitle);
            return;
        }
        RedBoxContentView redBoxContentView = new RedBoxContentView(currentActivity, this.devSupportManager, null);
        redBoxContentView.init();
        this.redBoxContentView = redBoxContentView;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isContentViewReady() {
        return this.redBoxContentView != null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void destroyContentView() {
        this.redBoxContentView = null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void show() {
        String lastErrorTitle = this.devSupportManager.getLastErrorTitle();
        Activity currentActivity = this.devSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            ReactContext currentReactContext = this.devSupportManager.getCurrentReactContext();
            if (currentReactContext == null) {
                if (lastErrorTitle == null) {
                    lastErrorTitle = "N/A";
                }
                FLog.e("ReactNative", "Unable to launch redbox because react activity and react context is not available, here is the error that redbox would've displayed: " + lastErrorTitle);
                return;
            }
            Companion.runAfterHostResume(currentReactContext, new Runnable() { // from class: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.show();
                }
            });
            return;
        }
        RedBoxContentView redBoxContentView = this.redBoxContentView;
        if ((redBoxContentView != null ? redBoxContentView.getContext() : null) != currentActivity) {
            createContentView(NativeRedBoxSpec.NAME);
        }
        RedBoxContentView redBoxContentView2 = this.redBoxContentView;
        if (redBoxContentView2 != null) {
            redBoxContentView2.refreshContentView();
        }
        if (this.dialog == null) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(currentActivity, this, R$style.Theme_Catalyst_RedBox);
            anonymousClass2.requestWindowFeature(1);
            RedBoxContentView redBoxContentView3 = this.redBoxContentView;
            if (redBoxContentView3 != null) {
                anonymousClass2.setContentView(redBoxContentView3);
                this.dialog = anonymousClass2;
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate$show$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Dialog {
        final /* synthetic */ RedBoxDialogSurfaceDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Activity activity, RedBoxDialogSurfaceDelegate redBoxDialogSurfaceDelegate, int i) {
            super(activity, i);
            this.this$0 = redBoxDialogSurfaceDelegate;
        }

        @Override // android.app.Dialog, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i, KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (i == 82) {
                this.this$0.devSupportManager.showDevOptionsDialog();
                return true;
            }
            if (this.this$0.doubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
                this.this$0.devSupportManager.handleReloadJS();
            }
            return super.onKeyUp(i, event);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            Window window = getWindow();
            if (window == null) {
                throw new IllegalStateException("Required value was null.");
            }
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
            final int iSystemBars = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
            RedBoxContentView redBoxContentView = this.this$0.redBoxContentView;
            if (redBoxContentView == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ViewCompat.setOnApplyWindowInsetsListener(redBoxContentView, new OnApplyWindowInsetsListener() { // from class: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate$show$2$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return RedBoxDialogSurfaceDelegate.AnonymousClass2.onCreate$lambda$0(iSystemBars, view, windowInsetsCompat);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WindowInsetsCompat onCreate$lambda$0(int i, View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
            Insets insets = windowInsetsCompat.getInsets(i);
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).setMargins(insets.left, insets.top, insets.right, insets.bottom);
            return WindowInsetsCompat.CONSUMED;
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void hide() {
        try {
            Dialog dialog = this.dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (IllegalArgumentException e) {
            FLog.e("ReactNative", "RedBoxDialogSurfaceDelegate: error while dismissing dialog: ", e);
        }
        destroyContentView();
        this.dialog = null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isShowing() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runAfterHostResume(final ReactContext reactContext, final Runnable runnable) {
            reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate$Companion$runAfterHostResume$1
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostResume() {
                    runnable.run();
                    reactContext.removeLifecycleEventListener(this);
                }
            });
        }
    }
}
