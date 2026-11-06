package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.core.Bounds;
import androidx.window.layout.util.ActivityCompatHelperApi24;
import androidx.window.layout.util.ContextCompatHelper;
import androidx.window.layout.util.ContextCompatHelperApi30;
import androidx.window.layout.util.DisplayCompatHelperApi28;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();
    private static final String TAG;
    private static final ArrayList insetsTypeMasks;

    private WindowMetricsCalculatorCompat() {
    }

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = simpleName;
        insetsTypeMasks = CollectionsKt.arrayListOf(Integer.valueOf(WindowInsetsCompat.Type.statusBars()), Integer.valueOf(WindowInsetsCompat.Type.navigationBars()), Integer.valueOf(WindowInsetsCompat.Type.captionBar()), Integer.valueOf(WindowInsetsCompat.Type.ime()), Integer.valueOf(WindowInsetsCompat.Type.systemGestures()), Integer.valueOf(WindowInsetsCompat.Type.mandatorySystemGestures()), Integer.valueOf(WindowInsetsCompat.Type.tappableElement()), Integer.valueOf(WindowInsetsCompat.Type.displayCutout()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompatHelperApi30.INSTANCE.currentWindowMetrics(context);
        }
        Context contextUnwrapUiContext$window_release = ContextCompatHelper.INSTANCE.unwrapUiContext$window_release(context);
        if (contextUnwrapUiContext$window_release instanceof Activity) {
            return computeCurrentWindowMetrics((Activity) contextUnwrapUiContext$window_release);
        }
        if (contextUnwrapUiContext$window_release instanceof InputMethodService) {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "wm.defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            return new WindowMetrics(new Rect(0, 0, realSizeForDisplay$window_release.x, realSizeForDisplay$window_release.y), null, 2, 0 == true ? 1 : 0);
        }
        throw new IllegalArgumentException(context + " is not a UiContext");
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Activity activity) throws Exception {
        Rect rectComputeWindowBoundsN$window_release;
        WindowInsetsCompat windowInsetsCompatBuild;
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            rectComputeWindowBoundsN$window_release = ContextCompatHelperApi30.INSTANCE.currentWindowBounds(activity);
        } else if (i >= 29) {
            rectComputeWindowBoundsN$window_release = computeWindowBoundsQ$window_release(activity);
        } else if (i >= 28) {
            rectComputeWindowBoundsN$window_release = computeWindowBoundsP$window_release(activity);
        } else {
            rectComputeWindowBoundsN$window_release = computeWindowBoundsN$window_release(activity);
        }
        if (i >= 30) {
            windowInsetsCompatBuild = computeWindowInsetsCompat$window_release(activity);
        } else {
            windowInsetsCompatBuild = new WindowInsetsCompat.Builder().build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new WindowMetrics(new Bounds(rectComputeWindowBoundsN$window_release), windowInsetsCompatBuild);
    }

    public final Rect computeWindowBoundsQ$window_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (IllegalAccessException unused) {
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchFieldException unused2) {
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchMethodException unused3) {
            return computeWindowBoundsP$window_release(activity);
        } catch (InvocationTargetException unused4) {
            return computeWindowBoundsP$window_release(activity);
        }
    }

    public final Rect computeWindowBoundsP$window_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException unused) {
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchFieldException unused2) {
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchMethodException unused3) {
            getRectSizeFromDisplay(activity, rect);
        } catch (InvocationTargetException unused4) {
            getRectSizeFromDisplay(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        currentDisplay.getRealSize(point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i = rect.bottom;
            if (i + navigationBarHeight == point.y) {
                rect.bottom = i + navigationBarHeight;
            } else {
                int i2 = rect.right;
                if (i2 + navigationBarHeight == point.x) {
                    rect.right = i2 + navigationBarHeight;
                } else if (rect.left == navigationBarHeight) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            Intrinsics.checkNotNullExpressionValue(currentDisplay, "currentDisplay");
            DisplayCutout cutoutForDisplay = getCutoutForDisplay(currentDisplay);
            if (cutoutForDisplay != null) {
                int i3 = rect.left;
                DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
                if (i3 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                    rect.left = 0;
                }
                if (point.x - rect.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                    rect.right += displayCompatHelperApi28.safeInsetRight(cutoutForDisplay);
                }
                if (rect.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                    rect.top = 0;
                }
                if (point.y - rect.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                    rect.bottom += displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay);
                }
            }
        }
        return rect;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    public final Rect computeWindowBoundsN$window_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i = rect.bottom;
            if (i + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i + navigationBarHeight;
                return rect;
            }
            int i2 = rect.right;
            if (i2 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                rect.right = i2 + navigationBarHeight;
            }
        }
        return rect;
    }

    public final Point getRealSizeForDisplay$window_release(Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (WindowMetricsCalculatorCompat$$ExternalSyntheticApiModelOutline0.m(obj)) {
                return WindowMetricsCalculatorCompat$$ExternalSyntheticApiModelOutline1.m(obj);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    public final WindowInsetsCompat computeWindowInsetsCompat$window_release(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompatHelperApi30.INSTANCE.currentWindowInsets(context);
        }
        throw new Exception("Incompatible SDK version");
    }
}
