package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/RCHTTPStatusCodes;", "", "()V", "BAD_REQUEST", "", "CREATED", HybridPurchaseLogicBridge.RESULT_ERROR, "FORBIDDEN", "NOT_FOUND", "NOT_MODIFIED", HybridPurchaseLogicBridge.RESULT_SUCCESS, "UNAUTHORIZED", "UNSUCCESSFUL", "isServerError", "", "statusCode", "isSuccessful", "isSynced", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RCHTTPStatusCodes {
    public static final int BAD_REQUEST = 400;
    public static final int CREATED = 201;
    public static final int ERROR = 500;
    public static final int FORBIDDEN = 403;
    public static final RCHTTPStatusCodes INSTANCE = new RCHTTPStatusCodes();
    public static final int NOT_FOUND = 404;
    public static final int NOT_MODIFIED = 304;
    public static final int SUCCESS = 200;
    public static final int UNAUTHORIZED = 401;
    public static final int UNSUCCESSFUL = 300;

    public final boolean isServerError(int statusCode) {
        return statusCode >= 500;
    }

    public final boolean isSuccessful(int statusCode) {
        return statusCode < 400;
    }

    private RCHTTPStatusCodes() {
    }

    public final boolean isSynced(int statusCode) {
        if (isSuccessful(statusCode)) {
            return true;
        }
        return (isServerError(statusCode) || statusCode == 404) ? false : true;
    }
}
