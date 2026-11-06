package com.facebook.react.devsupport;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugOverlayController {
    public static final Companion Companion = new Companion(null);
    private FrameLayout fpsDebugViewContainer;
    private final ReactContext reactContext;
    private final WindowManager windowManager;

    public DebugOverlayController(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        Object systemService = reactContext.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
    }

    public final void setFpsDebugViewVisible(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DebugOverlayController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DebugOverlayController.setFpsDebugViewVisible$lambda$0(z, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFpsDebugViewVisible$lambda$0(boolean z, DebugOverlayController debugOverlayController) {
        FrameLayout frameLayout;
        if (z && debugOverlayController.fpsDebugViewContainer == null) {
            if (!Companion.permissionCheck(debugOverlayController.reactContext)) {
                FLog.d("ReactNative", "Wait for overlay permission to be set");
                return;
            } else {
                debugOverlayController.fpsDebugViewContainer = new FpsView(debugOverlayController.reactContext);
                debugOverlayController.windowManager.addView(debugOverlayController.fpsDebugViewContainer, new WindowManager.LayoutParams(-1, -1, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 24, -3));
                return;
            }
        }
        if (z || (frameLayout = debugOverlayController.fpsDebugViewContainer) == null) {
            return;
        }
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        debugOverlayController.windowManager.removeView(debugOverlayController.fpsDebugViewContainer);
        debugOverlayController.fpsDebugViewContainer = null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void requestPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Settings.canDrawOverlays(context)) {
                return;
            }
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(268435456);
            FLog.w("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
            if (canHandleIntent(context, intent)) {
                context.startActivity(intent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean permissionCheck(Context context) {
            return Settings.canDrawOverlays(context);
        }

        private final boolean canHandleIntent(Context context, Intent intent) {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || intent.resolveActivity(packageManager) == null) ? false : true;
        }
    }
}
