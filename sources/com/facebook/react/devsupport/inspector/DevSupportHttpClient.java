package com.facebook.react.devsupport.inspector;

import com.adjust.sdk.Constants;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public final class DevSupportHttpClient {
    public static final DevSupportHttpClient INSTANCE = new DevSupportHttpClient();
    private static final OkHttpClient httpClient;
    private static final OkHttpClient websocketClient;

    private DevSupportHttpClient() {
    }

    public final OkHttpClient getHttpClient$ReactAndroid_release() {
        return httpClient;
    }

    static {
        OkHttpClient.Builder builderNewBuilder = OkHttpClientProvider.getOkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient okHttpClientBuild = builderNewBuilder.connectTimeout(5L, timeUnit).writeTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
        httpClient = okHttpClientBuild;
        websocketClient = okHttpClientBuild.newBuilder().connectTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).build();
    }

    public final OkHttpClient getWebsocketClient$ReactAndroid_release() {
        return websocketClient;
    }

    public final String httpScheme$ReactAndroid_release(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? Constants.SCHEME : "http";
    }

    public final String wsScheme$ReactAndroid_release(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? "wss" : "ws";
    }
}
