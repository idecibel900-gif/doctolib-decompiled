package com.facebook.imagepipeline.backends.okhttp3;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpNetworkFetcherException extends Exception {
    public static final Companion Companion = new Companion(null);
    private final Integer responseCode;
    private final Headers responseHeaders;

    public OkHttpNetworkFetcherException(Integer num, Headers headers) {
        this.responseCode = num;
        this.responseHeaders = headers;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpNetworkFetcherException fromResponse(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Response responseNetworkResponse = response.networkResponse();
            Integer numValueOf = responseNetworkResponse != null ? Integer.valueOf(responseNetworkResponse.code()) : null;
            Response responseNetworkResponse2 = response.networkResponse();
            return new OkHttpNetworkFetcherException(numValueOf, responseNetworkResponse2 != null ? responseNetworkResponse2.headers() : null);
        }
    }
}
