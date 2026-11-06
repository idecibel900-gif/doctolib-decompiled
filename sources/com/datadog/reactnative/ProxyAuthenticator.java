package com.datadog.reactnative;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: classes3.dex */
public final class ProxyAuthenticator implements Authenticator {
    private static final Companion Companion = new Companion(null);
    private final String password;
    private final String username;

    public ProxyAuthenticator(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getCode() != 407) {
            response.getCode();
            return null;
        }
        for (Challenge challenge : response.challenges()) {
            String scheme = challenge.getScheme();
            if (StringsKt.equals("Basic", scheme, true) || StringsKt.equals("OkHttp-Preemptive", scheme, true)) {
                return response.getRequest().newBuilder().header("Proxy-Authorization", Credentials.basic(this.username, this.password, challenge.m5536deprecated_charset())).build();
            }
        }
        return null;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
