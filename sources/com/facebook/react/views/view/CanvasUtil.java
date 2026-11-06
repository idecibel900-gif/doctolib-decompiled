package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CanvasUtil {
    public static final CanvasUtil INSTANCE = new CanvasUtil();
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;
    private static Method reorderBarrierMethod;

    private CanvasUtil() {
    }

    public static final void enableZ(Canvas canvas, boolean z) {
        Method method;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        INSTANCE.fetchOrderMethods();
        if (z) {
            try {
                Method method2 = reorderBarrierMethod;
                if (method2 != null) {
                    if (method2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    method2.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return;
            }
        }
        if (z || (method = inorderBarrierMethod) == null) {
            return;
        }
        if (method == null) {
            throw new IllegalStateException("Required value was null.");
        }
        method.invoke(canvas, null);
    }

    private final void fetchOrderMethods() {
        if (orderMethodsFetched) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT == 28) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Object[].class);
                Object objInvoke = declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
                reorderBarrierMethod = (Method) objInvoke;
                Object objInvoke2 = declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type java.lang.reflect.Method");
                inorderBarrierMethod = (Method) objInvoke2;
            } else {
                reorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                inorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
            }
            Method method = reorderBarrierMethod;
            if (method != null && inorderBarrierMethod != null) {
                if (method != null) {
                    method.setAccessible(true);
                }
                Method method2 = inorderBarrierMethod;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                orderMethodsFetched = true;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
