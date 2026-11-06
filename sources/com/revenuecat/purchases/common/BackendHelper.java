package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0080\u0001\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f2\u001a\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100\u001d2 \u0010\u001f\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00100 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/common/BackendHelper;", "", "apiKey", "", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/HTTPClient;)V", "authenticationHeaders", "", "getAuthenticationHeaders$purchases_defaultsBc8Release", "()Ljava/util/Map;", "enqueue", "", "call", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "performRequest", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "body", "postFieldsToSign", "", "Lkotlin/Pair;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onCompleted", "Lkotlin/Function3;", "", "Lorg/json/JSONObject;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackendHelper {
    private final String apiKey;
    private final AppConfig appConfig;
    private final Map<String, String> authenticationHeaders;
    private final Dispatcher dispatcher;
    private final HTTPClient httpClient;

    public BackendHelper(String apiKey, Dispatcher dispatcher, AppConfig appConfig, HTTPClient httpClient) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.apiKey = apiKey;
        this.dispatcher = dispatcher;
        this.appConfig = appConfig;
        this.httpClient = httpClient;
        this.authenticationHeaders = MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + apiKey));
    }

    public final Map<String, String> getAuthenticationHeaders$purchases_defaultsBc8Release() {
        return this.authenticationHeaders;
    }

    public final void performRequest(final Endpoint endpoint, final Map<String, ? extends Object> body, final List<Pair<String, String>> postFieldsToSign, Delay delay, final Function1 onError, final Function3 onCompleted) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        enqueue(new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.BackendHelper.performRequest.1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(BackendHelper.this.httpClient, BackendHelper.this.appConfig.getBaseURL(), endpoint, body, postFieldsToSign, BackendHelper.this.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, BackendHelper.this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                PurchasesError purchasesError;
                Intrinsics.checkNotNullParameter(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    purchasesError = null;
                } else {
                    purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                }
                onCompleted.invoke(purchasesError, Integer.valueOf(result.getResponseCode()), result.getBody());
            }
        }, this.dispatcher, delay);
    }

    public static /* synthetic */ void enqueue$default(BackendHelper backendHelper, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Delay delay, int i, Object obj) {
        if ((i & 4) != 0) {
            delay = Delay.NONE;
        }
        backendHelper.enqueue(asyncCall, dispatcher, delay);
    }

    public final void enqueue(Dispatcher.AsyncCall call, Dispatcher dispatcher, Delay delay) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(delay, "delay");
        if (dispatcher.isClosed()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Enqueuing operation in closed dispatcher.", null);
        } else {
            dispatcher.enqueue(call, delay);
        }
    }
}
