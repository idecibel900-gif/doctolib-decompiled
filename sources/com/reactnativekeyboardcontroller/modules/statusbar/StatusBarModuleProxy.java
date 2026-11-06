package com.reactnativekeyboardcontroller.modules.statusbar;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StatusBarModuleProxy {
    private Method getConstantsMethod;
    private Object instance;
    private Method setColorMethod;
    private Method setHiddenMethod;
    private Method setStyleMethod;
    private Method setTranslucentMethod;

    public StatusBarModuleProxy(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        try {
            StatusBarModule.Companion companion = StatusBarModule.INSTANCE;
            this.instance = StatusBarModule.class.getConstructor(ReactApplicationContext.class).newInstance(reactContext);
            Class cls = Boolean.TYPE;
            this.setHiddenMethod = StatusBarModule.class.getMethod("setHidden", cls);
            this.setColorMethod = StatusBarModule.class.getMethod("setColor", Double.TYPE, cls);
            this.setTranslucentMethod = StatusBarModule.class.getMethod("setTranslucent", cls);
            this.setStyleMethod = StatusBarModule.class.getMethod("setStyle", String.class);
            this.getConstantsMethod = StatusBarModule.class.getMethod("getConstants", null);
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Failed to initialize StatusBarModule via reflection", e);
        }
    }

    public final void setColor(double d, boolean z) {
        try {
            Method method = this.setColorMethod;
            if (method != null) {
                method.invoke(this.instance, Double.valueOf(d), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setColor method", e);
        }
    }

    public final void setTranslucent(boolean z) {
        try {
            Method method = this.setTranslucentMethod;
            if (method != null) {
                method.invoke(this.instance, Boolean.valueOf(z));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setTranslucent method", e);
        }
    }

    public final void setStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        try {
            Method method = this.setStyleMethod;
            if (method != null) {
                method.invoke(this.instance, style);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setStyle method", e);
        }
    }

    public final Map getConstants() {
        try {
            Method method = this.getConstantsMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, null) : null;
            if (TypeIntrinsics.isMutableMap(objInvoke)) {
                return (Map) objInvoke;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.getConstants method", e);
            return null;
        }
    }
}
