package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DisplayMetricsHolder {
    public static final DisplayMetricsHolder INSTANCE = new DisplayMetricsHolder();
    private static DisplayMetrics screenDisplayMetrics;
    private static DisplayMetrics windowDisplayMetrics;

    private DisplayMetricsHolder() {
    }

    public static final DisplayMetrics getWindowDisplayMetrics() {
        DisplayMetrics displayMetrics = windowDisplayMetrics;
        if (displayMetrics == null) {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        }
        Intrinsics.checkNotNull(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
        return displayMetrics;
    }

    public static final DisplayMetrics getScreenDisplayMetrics() {
        DisplayMetrics displayMetrics = screenDisplayMetrics;
        if (displayMetrics == null) {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        }
        Intrinsics.checkNotNull(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
        return displayMetrics;
    }

    public static final void initDisplayMetricsIfNotInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (screenDisplayMetrics != null) {
            return;
        }
        initDisplayMetrics(context);
    }

    public static final void initDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        windowDisplayMetrics = displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics2);
        displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
        screenDisplayMetrics = displayMetrics2;
    }

    public static final WritableMap getDisplayMetricsWritableMap(double d) {
        if (windowDisplayMetrics == null) {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        }
        if (screenDisplayMetrics == null) {
            throw new IllegalStateException("DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        DisplayMetricsHolder displayMetricsHolder = INSTANCE;
        DisplayMetrics displayMetrics = windowDisplayMetrics;
        Intrinsics.checkNotNull(displayMetrics, "null cannot be cast to non-null type android.util.DisplayMetrics");
        writableNativeMap.putMap("windowPhysicalPixels", displayMetricsHolder.getPhysicalPixelsWritableMap(displayMetrics, d));
        DisplayMetrics displayMetrics2 = screenDisplayMetrics;
        Intrinsics.checkNotNull(displayMetrics2, "null cannot be cast to non-null type android.util.DisplayMetrics");
        writableNativeMap.putMap("screenPhysicalPixels", displayMetricsHolder.getPhysicalPixelsWritableMap(displayMetrics2, d));
        return writableNativeMap;
    }

    private final WritableMap getPhysicalPixelsWritableMap(DisplayMetrics displayMetrics, double d) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", displayMetrics.widthPixels);
        writableNativeMap.putInt("height", displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d);
        writableNativeMap.putDouble("densityDpi", displayMetrics.densityDpi);
        return writableNativeMap;
    }

    public final int getStatusBarHeightPx$ReactAndroid_release(Activity activity) {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) == null) {
            return 0;
        }
        return rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    public static final long getEncodedScreenSizeWithoutVerticalInsets(Activity activity) {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) == null) {
            return 0L;
        }
        Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        int i = insets.top + insets.bottom;
        DisplayMetricsHolder displayMetricsHolder = INSTANCE;
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        DisplayMetrics displayMetrics = screenDisplayMetrics;
        if (displayMetrics == null) {
            throw new IllegalStateException("Required value was null.");
        }
        float fPxToDp = pixelUtil.pxToDp(displayMetrics.widthPixels);
        DisplayMetrics displayMetrics2 = screenDisplayMetrics;
        if (displayMetrics2 != null) {
            return displayMetricsHolder.encodeFloatsToLong$ReactAndroid_release(fPxToDp, pixelUtil.pxToDp(displayMetrics2.heightPixels - i));
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final long encodeFloatsToLong$ReactAndroid_release(float f, float f2) {
        return ((long) Float.floatToRawIntBits(f2)) | (((long) Float.floatToRawIntBits(f)) << 32);
    }
}
