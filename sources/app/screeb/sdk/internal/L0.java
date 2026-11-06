package app.screeb.sdk.internal;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class L0 {
    public static final Lazy a = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.L0$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return L0.a();
        }
    });
    public static final Lazy b = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.L0$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return L0.b();
        }
    });
    public static final Lazy c = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.L0$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return L0.c();
        }
    });

    public static final Class a() {
        try {
            return Class.forName("android.view.WindowManagerGlobal");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final List a(Field field, Object obj) throws IllegalAccessException {
        Object obj2 = field.get(obj);
        if (obj2 instanceof List) {
            return (List) obj2;
        }
        return null;
    }

    public static final List a(Method method, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = method.invoke(obj, null);
        if (objInvoke instanceof List) {
            return (List) objInvoke;
        }
        return null;
    }

    public static void a(Activity activity, ArrayList out) {
        IBinder windowToken;
        View decorView;
        Window window;
        IBinder windowToken2;
        View decorView2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(out, "out");
        out.clear();
        try {
            Window window2 = activity.getWindow();
            windowToken = (window2 == null || (decorView2 = window2.getDecorView()) == null) ? null : decorView2.getWindowToken();
        } catch (Throwable unused) {
        }
        Function0 function0 = (Function0) c.getValue();
        List list = function0 != null ? (List) function0.invoke() : null;
        if (list == null || list.isEmpty()) {
            Window window3 = activity.getWindow();
            if (window3 == null || (decorView = window3.getDecorView()) == null) {
                return;
            }
        } else {
            try {
                for (Object obj : list) {
                    try {
                        if ((obj instanceof View) && ((View) obj).isAttachedToWindow() && ((windowToken2 = ((View) obj).getWindowToken()) == null || windowToken == null || Intrinsics.areEqual(windowToken2, windowToken))) {
                            View v = (View) obj;
                            Intrinsics.checkNotNullParameter(v, "v");
                            if (v.getVisibility() == 0 && v.getWidth() != 0 && v.getHeight() != 0 && v.getAlpha() != 0.0f && !o0.a(v)) {
                                out.add(obj);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                out.clear();
            }
            if (!out.isEmpty() || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
                return;
            }
        }
        out.add(decorView);
    }

    public static final Object b() {
        Method method;
        try {
            Class cls = (Class) a.getValue();
            if (cls == null || (method = cls.getMethod("getInstance", null)) == null) {
                return null;
            }
            return method.invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Function0 c() {
        final Object value;
        Class cls = (Class) a.getValue();
        if (cls == null || (value = b.getValue()) == null) {
            return null;
        }
        try {
            try {
                final Method declaredMethod = cls.getDeclaredMethod("getRootViews", null);
                declaredMethod.setAccessible(true);
                return new Function0() { // from class: app.screeb.sdk.internal.L0$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return L0.a(declaredMethod, value);
                    }
                };
            } catch (Throwable th) {
                Z z = Z.b;
                Y.a();
                Z.b("Mirror", "WindowEnumerator reflection failed: " + th.getClass().getSimpleName());
                return null;
            }
        } catch (NoSuchMethodException unused) {
            final Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return new Function0() { // from class: app.screeb.sdk.internal.L0$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return L0.a(declaredField, value);
                }
            };
        }
    }
}
