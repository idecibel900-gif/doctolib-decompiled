package com.revenuecat.purchases.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "", "createConnection", "Lcom/revenuecat/purchases/utils/UrlConnection;", "url", "", "requestMethod", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface UrlConnectionFactory {
    UrlConnection createConnection(String url, String requestMethod);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ UrlConnection createConnection$default(UrlConnectionFactory urlConnectionFactory, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConnection");
        }
        if ((i & 2) != 0) {
            str2 = "GET";
        }
        return urlConnectionFactory.createConnection(str, str2);
    }
}
