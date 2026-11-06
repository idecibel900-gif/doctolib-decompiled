package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class PackagerConnectionSettings {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = PackagerConnectionSettings.class.getSimpleName();
    private final Map _additionalOptionsForPackager;
    private Function1 _packagerOptionsUpdater;
    private final Context appContext;
    private String cachedHost;
    private final String packageName;
    private final SharedPreferences preferences;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map _packagerOptionsUpdater$lambda$0(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public PackagerConnectionSettings(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.preferences = defaultSharedPreferences;
        String packageName = appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.packageName = packageName;
        this._additionalOptionsForPackager = new LinkedHashMap();
        this._packagerOptionsUpdater = new Function1() { // from class: com.facebook.react.packagerconnection.PackagerConnectionSettings$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PackagerConnectionSettings._packagerOptionsUpdater$lambda$0((Map) obj);
            }
        };
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public String getDebugServerHost() {
        String str = this.cachedHost;
        if (str != null) {
            return str;
        }
        String string = this.preferences.getString("debug_http_host", null);
        if (string != null && string.length() != 0) {
            return string;
        }
        String serverHost = AndroidInfoHelpers.getServerHost(this.appContext);
        if (Intrinsics.areEqual(serverHost, "localhost")) {
            FLog.w(TAG, "You seem to be running on device. Run '" + AndroidInfoHelpers.getAdbReverseTcpCommand(this.appContext) + "' to forward the debug server's port to the device.");
        }
        this.cachedHost = serverHost;
        return serverHost;
    }

    public void setDebugServerHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (host.length() == 0) {
            this.cachedHost = null;
        } else {
            this.cachedHost = host;
        }
    }

    public final void setPackagerOptionsUpdater(Function1 queryMapper) {
        Intrinsics.checkNotNullParameter(queryMapper, "queryMapper");
        this._packagerOptionsUpdater = queryMapper;
    }

    public final Map updatePackagerOptions(Map options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return (Map) this._packagerOptionsUpdater.invoke(options);
    }

    public final Map getAdditionalOptionsForPackager() {
        return this._additionalOptionsForPackager;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
