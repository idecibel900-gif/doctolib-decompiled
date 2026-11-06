package com.adjust.sdk;

import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class Reflection {
    public static Object createDefaultInstance(String str) {
        Class clsForName = forName(str);
        if (clsForName == null) {
            return null;
        }
        return createDefaultInstance(clsForName);
    }

    public static Object createInstance(String str, Class[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class forName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getAdvertisingInfoObject(Context context) {
        return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    public static String getAppSetId(Context context) {
        try {
            return (String) invokeInstanceMethod(invokeStaticMethod("com.google.android.gms.tasks.Tasks", "await", new Class[]{forName("com.google.android.gms.tasks.Task"), Long.TYPE, TimeUnit.class}, invokeInstanceMethod(invokeStaticMethod("com.google.android.gms.appset.AppSet", "getClient", new Class[]{Context.class}, context), "getAppSetIdInfo", null, new Object[0]), 1L, TimeUnit.SECONDS), "getId", null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getGoogleAdId(Context context, Object obj) {
        try {
            return (String) invokeInstanceMethod(obj, "getId", null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ReferrerDetails getHuaweiAdsReferrer(Context context, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.huawei.Util", "getHuaweiAdsInstallReferrerDetails", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReferrerDetails getHuaweiAppGalleryReferrer(Context context, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.huawei.Util", "getHuaweiAppGalleryInstallReferrerDetails", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> getImeiParameters(Context context, ILogger iLogger) {
        try {
            Object objInvokeStaticMethod = invokeStaticMethod("com.adjust.sdk.imei.Util", "getImeiParameters", new Class[]{Context.class, ILogger.class}, context, iLogger);
            if (objInvokeStaticMethod == null || !Map.class.isInstance(objInvokeStaticMethod)) {
                return null;
            }
            return (Map) objInvokeStaticMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public static LicenseData getLicenseRequiredData(Context context, ILogger iLogger, long j) {
        try {
            return (LicenseData) invokeStaticMethod("com.adjust.sdk.google.lvl.Util", "getLicenseRequiredData", new Class[]{Context.class, ILogger.class, Long.TYPE}, context, iLogger, Long.valueOf(j));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReferrerDetails getMetaReferrer(Context context, String str, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.meta.Util", "getMetaInstallReferrerDetails", new Class[]{Context.class, String.class, ILogger.class}, context, str, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> getOaidParameters(Context context, ILogger iLogger) {
        try {
            Object objInvokeStaticMethod = invokeStaticMethod("com.adjust.sdk.oaid.Util", "getOaidParameters", new Class[]{Context.class, ILogger.class}, context, iLogger);
            if (objInvokeStaticMethod == null || !Map.class.isInstance(objInvokeStaticMethod)) {
                return null;
            }
            return (Map) objInvokeStaticMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSamsungCloudDevGoogleAdId(Context context, ILogger iLogger) {
        try {
            return (String) invokeStaticMethod("com.adjust.sdk.samsung.clouddev.Util", "getGoogleAdIdInCloudEnvironment", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReferrerDetails getSamsungReferrer(Context context, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.samsung.Util", "getSamsungInstallReferrerDetails", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReferrerDetails getVivoReferrer(Context context, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.vivo.Util", "getVivoInstallReferrerDetails", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ReferrerDetails getXiaomiReferrer(Context context, ILogger iLogger) {
        try {
            return (ReferrerDetails) invokeStaticMethod("com.adjust.sdk.xiaomi.Util", "getXiaomiInstallReferrerDetails", new Class[]{Context.class, ILogger.class}, context, iLogger);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeInstanceMethod(Object obj, String str, Class[] clsArr, Object... objArr) {
        return invokeMethod(obj.getClass(), str, obj, clsArr, objArr);
    }

    public static Object invokeMethod(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (method == null) {
            return null;
        }
        return method.invoke(obj, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object... objArr) {
        return invokeMethod(Class.forName(str), str2, null, clsArr, objArr);
    }

    public static boolean isAppRunningInSamsungCloudEnvironment(Context context, ILogger iLogger) {
        try {
            return ((Boolean) invokeStaticMethod("com.adjust.sdk.samsung.clouddev.Util", "isAppRunningInCloudEnvironment", new Class[]{Context.class, ILogger.class}, context, iLogger)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Boolean isGoogleAdIdTrackingEnabled(Context context, Object obj) {
        try {
            Boolean bool = (Boolean) invokeInstanceMethod(obj, "isLimitAdTrackingEnabled", null, new Object[0]);
            if (bool == null) {
                return null;
            }
            return Boolean.valueOf(!bool.booleanValue());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object readField(String str, String str2) {
        return readField(str, str2, null);
    }

    public static Object readField(String str, String str2, Object obj) {
        Field field;
        Class clsForName = forName(str);
        if (clsForName == null || (field = clsForName.getField(str2)) == null) {
            return null;
        }
        return field.get(obj);
    }

    public static Object createDefaultInstance(Class cls) {
        try {
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
