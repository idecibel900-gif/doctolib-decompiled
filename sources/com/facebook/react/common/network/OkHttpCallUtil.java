package com.facebook.react.common.network;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpCallUtil {
    public static final OkHttpCallUtil INSTANCE = new OkHttpCallUtil();

    private OkHttpCallUtil() {
    }

    public static final void cancelTag(OkHttpClient client, Object tag) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Dispatcher dispatcher = client.getDispatcher();
        for (Call call : dispatcher.queuedCalls()) {
            if (Intrinsics.areEqual(tag, call.request().tag())) {
                call.cancel();
                return;
            }
        }
        for (Call call2 : dispatcher.runningCalls()) {
            if (Intrinsics.areEqual(tag, call2.request().tag())) {
                call2.cancel();
                return;
            }
        }
    }
}
