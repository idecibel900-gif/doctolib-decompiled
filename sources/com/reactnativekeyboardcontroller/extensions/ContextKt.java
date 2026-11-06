package com.reactnativekeyboardcontroller.extensions;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ContextKt {
    public static final Point getDisplaySize(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            point.x = bounds.width();
            point.y = bounds.height();
            return point;
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getDefaultDisplay(...)");
        defaultDisplay.getRealSize(point);
        return point;
    }

    public static final boolean isSystemDarkMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 29) {
            Object systemService = context.getSystemService("uimode");
            UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
            if (uiModeManager != null && uiModeManager.getNightMode() == 2) {
                return true;
            }
        }
        return false;
    }

    public static final String currentImePackage(Context context) {
        ComponentName componentNameUnflattenFromString;
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        if (string == null || (componentNameUnflattenFromString = ComponentName.unflattenFromString(string)) == null) {
            return null;
        }
        return componentNameUnflattenFromString.getPackageName();
    }
}
