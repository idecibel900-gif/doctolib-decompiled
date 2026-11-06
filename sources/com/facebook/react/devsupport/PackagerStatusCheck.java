package com.facebook.react.devsupport;

import com.facebook.common.logging.FLog;
import com.facebook.react.devsupport.inspector.DevSupportHttpClient;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class PackagerStatusCheck {
    private static final Companion Companion = new Companion(null);
    private final OkHttpClient client;

    public PackagerStatusCheck(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    public final void run(String host, final PackagerStatusCallback callback) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.client.newCall(new Request.Builder().url(Companion.createPackagerStatusURL(host)).build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.PackagerStatusCheck.run.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                FLog.w("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + e.getMessage());
                callback.onPackagerStatusFetched(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    FLog.e("ReactNative", "Got non-success http code from packager when requesting status: " + response.getCode());
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.getBody();
                if (body == null) {
                    FLog.e("ReactNative", "Got null body response from packager when requesting status");
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                String strString = body.string();
                if (!Intrinsics.areEqual("packager-status:running", strString)) {
                    FLog.e("ReactNative", "Got unexpected response from packager when requesting status: " + strString);
                    callback.onPackagerStatusFetched(false);
                    return;
                }
                callback.onPackagerStatusFetched(true);
            }
        });
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String createPackagerStatusURL(String str) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%s://%s/status", Arrays.copyOf(new Object[]{DevSupportHttpClient.INSTANCE.httpScheme$ReactAndroid_release(str), str}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
    }
}
