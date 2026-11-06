package org.greenrobot.eventbus.android;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AndroidDependenciesDetector {
    public static boolean isAndroidSDKAvailable() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean areAndroidComponentsAvailable() {
        try {
            int i = AndroidComponentsImpl.$r8$clinit;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AndroidComponents instantiateAndroidComponents() {
        try {
            int i = AndroidComponentsImpl.$r8$clinit;
            return (AndroidComponents) AndroidComponentsImpl.class.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
