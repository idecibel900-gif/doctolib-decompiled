package app.screeb.sdk.internal;

import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: app.screeb.sdk.internal.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0311k0 {
    public static final int a(View view, Method method) {
        Object objInvoke;
        Method method2 = n0.g;
        if (method != null) {
            try {
                objInvoke = method.invoke(view, null);
            } catch (Throwable unused) {
                return 0;
            }
        } else {
            objInvoke = null;
        }
        Integer num = objInvoke instanceof Integer ? (Integer) objInvoke : null;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final Method a(C0311k0 c0311k0, String str) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod(str, null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }
}
