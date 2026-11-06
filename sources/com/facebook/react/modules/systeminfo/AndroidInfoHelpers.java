package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.amazon.a.a.o.b;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$integer;
import com.facebook.react.R$string;
import com.revenuecat.purchases.common.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidInfoHelpers {
    public static final AndroidInfoHelpers INSTANCE = new AndroidInfoHelpers();
    private static final String TAG = AndroidInfoHelpers.class.getSimpleName();
    private static String metroHostPropValue;

    private AndroidInfoHelpers() {
    }

    private final boolean isRunningOnGenymotion() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        return StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "vbox", false, 2, (Object) null);
    }

    private final boolean isRunningOnStockEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "generic", false, 2, (Object) null)) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        return StringsKt.startsWith$default(FINGERPRINT, "google/sdk_gphone", false, 2, (Object) null);
    }

    public static final String getServerHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidInfoHelpers androidInfoHelpers = INSTANCE;
        return androidInfoHelpers.getServerIpAddress(context, androidInfoHelpers.getDevServerPort(context));
    }

    public static final String getAdbReverseTcpCommand(int i) {
        return "adb reverse tcp:" + i + " tcp:" + i;
    }

    public static final String getAdbReverseTcpCommand(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getAdbReverseTcpCommand(INSTANCE.getDevServerPort(context));
    }

    public static final String getFriendlyDeviceName() {
        if (INSTANCE.isRunningOnGenymotion()) {
            String str = Build.MODEL;
            Intrinsics.checkNotNull(str);
            return str;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    public static final Map getInspectorHostMetadata(Context context) {
        String packageName;
        String string;
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            packageName = context.getPackageName();
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                Intrinsics.checkNotNull(string);
            }
        } else {
            packageName = null;
            string = null;
        }
        return MapsKt.mapOf(TuplesKt.to("appDisplayName", string), TuplesKt.to("appIdentifier", packageName), TuplesKt.to("platform", "android"), TuplesKt.to("deviceName", Build.MODEL), TuplesKt.to("reactNativeVersion", INSTANCE.getReactNativeVersionString()));
    }

    private final String getReactNativeVersionString() {
        String str;
        Map map = ReactNativeVersion.VERSION;
        Object obj = map.get("major");
        Object obj2 = map.get("minor");
        Object obj3 = map.get("patch");
        Object obj4 = map.get("prerelease");
        if (obj4 != null) {
            str = "-" + obj4;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return obj + "." + obj2 + "." + obj3 + str;
    }

    private final int getDevServerPort(Context context) {
        return context.getResources().getInteger(R$integer.react_native_dev_server_port);
    }

    private final String getServerIpAddress(Context context, int i) {
        String metroHostPropValue2;
        if (getMetroHostPropValue().length() > 0) {
            metroHostPropValue2 = getMetroHostPropValue();
        } else if (isRunningOnGenymotion()) {
            metroHostPropValue2 = "10.0.3.2";
        } else {
            metroHostPropValue2 = isRunningOnStockEmulator() ? "10.0.2.2" : "localhost";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s:%d", Arrays.copyOf(new Object[]{metroHostPropValue2, Integer.valueOf(i)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String getDevServerNetworkIpAndPort$ReactAndroid_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getString(R$string.react_native_dev_server_ip) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getDevServerPort(context);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    private final synchronized String getMetroHostPropValue() {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        Exception e;
        String str;
        String str2 = metroHostPropValue;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{b.as, "metro.host"});
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), Charset.forName(com.adjust.sdk.Constants.ENCODING)));
                    String str3 = "";
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str3 = line;
                        } catch (Exception e2) {
                            e = e2;
                            FLog.w(TAG, "Failed to query for metro.host prop:", e);
                            metroHostPropValue = "";
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (processExec != null) {
                            }
                            str = metroHostPropValue;
                            if (str == null) {
                                str = "";
                            }
                            return str;
                        }
                    }
                    metroHostPropValue = str3;
                    bufferedReader.close();
                } catch (Exception e3) {
                    bufferedReader = null;
                    e = e3;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            processExec = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
        processExec.destroy();
        str = metroHostPropValue;
        if (str == null) {
            str = "";
        }
        return str;
    }
}
