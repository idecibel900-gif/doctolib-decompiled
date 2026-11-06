package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewUtils {
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE;
    private static Method sComputeFitSystemWindowsMethod;
    private static boolean sInitComputeFitSystemWindowsMethod;

    static {
        SDK_LEVEL_SUPPORTS_AUTOSIZE = Build.VERSION.SDK_INT >= 27;
    }

    public static boolean isLayoutRtl(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.computeFitSystemWindows(view, rect, rect2);
            return;
        }
        if (!sInitComputeFitSystemWindowsMethod) {
            sInitComputeFitSystemWindowsMethod = true;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                sComputeFitSystemWindowsMethod = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    sComputeFitSystemWindowsMethod.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
            }
        }
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception unused2) {
            }
        }
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    static class Api29Impl {
        static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
            Insets systemWindowInsets = view.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect)).build(), rect2).getSystemWindowInsets();
            rect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
        }
    }
}
