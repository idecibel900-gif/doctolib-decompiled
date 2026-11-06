package com.zoontek.rnedgetoedge;

import android.app.Activity;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EdgeToEdgeModuleImpl {
    public static final EdgeToEdgeModuleImpl INSTANCE = new EdgeToEdgeModuleImpl();
    private static final Map boolAttributes = new LinkedHashMap();
    private static boolean navigationBarHidden;
    private static boolean statusBarHidden;

    private EdgeToEdgeModuleImpl() {
    }

    private final boolean resolveBoolAttribute(Activity activity, int i) {
        Map map = boolAttributes;
        Integer numValueOf = Integer.valueOf(i);
        Object objValueOf = map.get(numValueOf);
        if (objValueOf == null) {
            TypedValue typedValue = new TypedValue();
            objValueOf = Boolean.valueOf(activity.getTheme().resolveAttribute(i, typedValue, true) && typedValue.data != 0);
            map.put(numValueOf, objValueOf);
        }
        return ((Boolean) objValueOf).booleanValue();
    }

    private final boolean isDefaultLightSystemBars(Activity activity) {
        return resolveBoolAttribute(activity, R$attr.enforceSystemBarsLightTheme) || (activity.getWindow().getDecorView().getResources().getConfiguration().uiMode & 48) != 32;
    }

    private final boolean isNavigationBarTransparent(Activity activity) {
        return !resolveBoolAttribute(activity, R$attr.enforceNavigationBarContrast);
    }

    private final WindowInsetsControllerCompat initInsetsController(Window window) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
        if (statusBarHidden) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
        }
        if (navigationBarHidden) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
            return windowInsetsControllerCompat;
        }
        windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
        return windowInsetsControllerCompat;
    }

    public final void applyEdgeToEdge(ReactApplicationContext reactApplicationContext) {
        final Activity currentActivity;
        if (reactApplicationContext == null || (currentActivity = reactApplicationContext.getCurrentActivity()) == null) {
            FLog.w("ReactNative", "RNEdgeToEdge: Ignored, current activity is null.");
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    EdgeToEdgeModuleImpl.applyEdgeToEdge$lambda$4(currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyEdgeToEdge$lambda$4(Activity activity) {
        int darkNavigationBarColor;
        final Window window = activity.getWindow();
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Intrinsics.checkNotNull(window);
        WindowInsetsControllerCompat windowInsetsControllerCompatInitInsetsController = edgeToEdgeModuleImpl.initInsetsController(window);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(0);
        int i = Build.VERSION.SDK_INT;
        if (i <= 27) {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda5
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public final void onSystemUiVisibilityChange(int i2) {
                    EdgeToEdgeModuleImpl.applyEdgeToEdge$lambda$4$lambda$2(window, i2);
                }
            });
        }
        if (i >= 27 && edgeToEdgeModuleImpl.isNavigationBarTransparent(activity)) {
            window.setNavigationBarColor(0);
            if (i >= 29) {
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(false);
            }
        } else {
            boolean zIsDefaultLightSystemBars = edgeToEdgeModuleImpl.isDefaultLightSystemBars(activity);
            if (i >= 29) {
                darkNavigationBarColor = 0;
            } else if (i >= 27 && zIsDefaultLightSystemBars) {
                darkNavigationBarColor = EdgeToEdgeModuleImplKt.getLightNavigationBarColor();
            } else {
                darkNavigationBarColor = EdgeToEdgeModuleImplKt.getDarkNavigationBarColor();
            }
            window.setNavigationBarColor(darkNavigationBarColor);
            if (i < 27) {
                zIsDefaultLightSystemBars = false;
            }
            windowInsetsControllerCompatInitInsetsController.setAppearanceLightNavigationBars(zIsDefaultLightSystemBars);
            if (i >= 29) {
                window.setStatusBarContrastEnforced(false);
                window.setNavigationBarContrastEnforced(true);
            }
        }
        if (i >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = i >= 30 ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyEdgeToEdge$lambda$4$lambda$2(Window window, int i) {
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Intrinsics.checkNotNull(window);
        edgeToEdgeModuleImpl.initInsetsController(window);
    }

    public final void setStatusBarStyle(ReactApplicationContext reactApplicationContext, final String style) {
        final Activity currentActivity;
        Intrinsics.checkNotNullParameter(style, "style");
        if (reactApplicationContext == null || (currentActivity = reactApplicationContext.getCurrentActivity()) == null) {
            FLog.w("ReactNative", "RNEdgeToEdge: Ignored system bars change, current activity is null.");
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EdgeToEdgeModuleImpl.setStatusBarStyle$lambda$6(currentActivity, style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBarStyle$lambda$6(Activity activity, String str) {
        boolean zIsDefaultLightSystemBars;
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        WindowInsetsControllerCompat windowInsetsControllerCompatInitInsetsController = edgeToEdgeModuleImpl.initInsetsController(window);
        if (Intrinsics.areEqual(str, "light-content")) {
            zIsDefaultLightSystemBars = false;
        } else {
            zIsDefaultLightSystemBars = Intrinsics.areEqual(str, "dark-content") ? true : edgeToEdgeModuleImpl.isDefaultLightSystemBars(activity);
        }
        windowInsetsControllerCompatInitInsetsController.setAppearanceLightStatusBars(zIsDefaultLightSystemBars);
    }

    public final void setNavigationBarStyle(ReactApplicationContext reactApplicationContext, final String style) {
        final Activity currentActivity;
        Intrinsics.checkNotNullParameter(style, "style");
        if (reactApplicationContext == null || (currentActivity = reactApplicationContext.getCurrentActivity()) == null) {
            FLog.w("ReactNative", "RNEdgeToEdge: Ignored system bars change, current activity is null.");
        } else {
            if (Build.VERSION.SDK_INT < 27 || !isNavigationBarTransparent(currentActivity)) {
                return;
            }
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    EdgeToEdgeModuleImpl.setNavigationBarStyle$lambda$8(currentActivity, style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationBarStyle$lambda$8(Activity activity, String str) {
        boolean zIsDefaultLightSystemBars;
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        WindowInsetsControllerCompat windowInsetsControllerCompatInitInsetsController = edgeToEdgeModuleImpl.initInsetsController(window);
        if (Intrinsics.areEqual(str, "light-content")) {
            zIsDefaultLightSystemBars = false;
        } else {
            zIsDefaultLightSystemBars = Intrinsics.areEqual(str, "dark-content") ? true : edgeToEdgeModuleImpl.isDefaultLightSystemBars(activity);
        }
        windowInsetsControllerCompatInitInsetsController.setAppearanceLightNavigationBars(zIsDefaultLightSystemBars);
    }

    public final void setStatusBarHidden(ReactApplicationContext reactApplicationContext, boolean z) {
        final Activity currentActivity;
        if (reactApplicationContext == null || (currentActivity = reactApplicationContext.getCurrentActivity()) == null) {
            FLog.w("ReactNative", "RNEdgeToEdge: Ignored system bars change, current activity is null.");
        } else {
            statusBarHidden = z;
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    EdgeToEdgeModuleImpl.setStatusBarHidden$lambda$9(currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBarHidden$lambda$9(Activity activity) {
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        edgeToEdgeModuleImpl.initInsetsController(window);
    }

    public final void setNavigationBarHidden(ReactApplicationContext reactApplicationContext, boolean z) {
        final Activity currentActivity;
        if (reactApplicationContext == null || (currentActivity = reactApplicationContext.getCurrentActivity()) == null) {
            FLog.w("ReactNative", "RNEdgeToEdge: Ignored system bars change, current activity is null.");
        } else {
            navigationBarHidden = z;
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zoontek.rnedgetoedge.EdgeToEdgeModuleImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EdgeToEdgeModuleImpl.setNavigationBarHidden$lambda$10(currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationBarHidden$lambda$10(Activity activity) {
        EdgeToEdgeModuleImpl edgeToEdgeModuleImpl = INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        edgeToEdgeModuleImpl.initInsetsController(window);
    }
}
