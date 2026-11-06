package androidx.window.layout.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.layout.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextCompatHelperApi30 {
    public static final ContextCompatHelperApi30 INSTANCE = new ContextCompatHelperApi30();

    private ContextCompatHelperApi30() {
    }

    public final WindowMetrics currentWindowMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowManager.getCurrentWindowMetrics().getWindowInsets());
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return new WindowMetrics(bounds, windowInsetsCompat);
    }

    public final Rect currentWindowBounds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final WindowInsetsCompat currentWindowInsets(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(platformInsets)");
        return windowInsetsCompat;
    }
}
