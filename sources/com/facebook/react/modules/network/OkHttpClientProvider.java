package com.facebook.react.modules.network;

import android.content.Context;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpClientProvider {
    public static final OkHttpClientProvider INSTANCE = new OkHttpClientProvider();
    private static OkHttpClient client;

    private OkHttpClientProvider() {
    }

    public static final OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = client;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient okHttpClientCreateClient = createClient();
        client = okHttpClientCreateClient;
        return okHttpClientCreateClient;
    }

    public static final OkHttpClient createClient() {
        return createClientBuilder().build();
    }

    public static final OkHttpClient createClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createClientBuilder(context).build();
    }

    public static final OkHttpClient.Builder createClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(0L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(0L, timeUnit).cookieJar(new ReactCookieJarContainer());
    }

    public static final OkHttpClient.Builder createClientBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createClientBuilder(context, 10485760);
    }

    public static final OkHttpClient.Builder createClientBuilder(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builderCreateClientBuilder = createClientBuilder();
        return i == 0 ? builderCreateClientBuilder : builderCreateClientBuilder.cache(new Cache(new File(context.getCacheDir(), "http-cache"), i));
    }
}
