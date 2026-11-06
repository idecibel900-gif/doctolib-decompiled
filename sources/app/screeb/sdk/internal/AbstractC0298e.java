package app.screeb.sdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: renamed from: app.screeb.sdk.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0298e {
    public static String a(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0)) : packageManager.getPackageInfo(packageName, 0);
        Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return null;
        }
        try {
            applicationInfo = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Z z = Z.b;
            Y.a();
            Z.a("Command", "error while reading meta-data " + str, e, 8);
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object systemService = context.getSystemService(AuthorizationRequest.Scope.PHONE);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getNetworkOperatorName();
        } catch (Exception e) {
            Z.a("Command", "error while calling getCarrierName", e, 8);
            return null;
        }
    }

    public static List c(Context context) {
        if (context != null && context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            try {
                ArrayList arrayList = new ArrayList();
                Object systemService = context.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(0)) {
                        arrayList.add("cellular");
                    }
                    if (networkCapabilities.hasTransport(1)) {
                        arrayList.add("wifi");
                    }
                    if (networkCapabilities.hasTransport(2)) {
                        arrayList.add("bluetooth");
                    }
                    if (networkCapabilities.hasTransport(8)) {
                        arrayList.add("usb");
                    }
                    if (networkCapabilities.hasTransport(6)) {
                        arrayList.add("lowpan");
                    }
                    if (networkCapabilities.hasTransport(4)) {
                        arrayList.add("vpn");
                    }
                    if (networkCapabilities.hasTransport(5)) {
                        arrayList.add("wifi_aware");
                    }
                    if (networkCapabilities.hasTransport(3)) {
                        arrayList.add("ethernet");
                    }
                }
                return arrayList;
            } catch (Exception e) {
                Z.a("Command", "error while calling getNetworkInfo", e, 8);
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }
}
