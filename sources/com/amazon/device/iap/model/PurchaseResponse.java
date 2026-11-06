package com.amazon.device.iap.model;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class PurchaseResponse {
    private static final String RECEIPT = "receipt";
    private static final String REQUEST_ID = "requestId";
    private static final String REQUEST_STATUS = "requestStatus";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)";
    private static final String USER_DATA = "userData";
    private final Receipt receipt;
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final UserData userData;

    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        INVALID_SKU,
        ALREADY_PURCHASED,
        PENDING,
        NOT_SUPPORTED;

        public static RequestStatus safeValueOf(String str) {
            if (f.a(str)) {
                return null;
            }
            if ("ALREADY_ENTITLED".equalsIgnoreCase(str)) {
                return ALREADY_PURCHASED;
            }
            return valueOf(str.toUpperCase());
        }
    }

    public PurchaseResponse(PurchaseResponseBuilder purchaseResponseBuilder) {
        f.a(purchaseResponseBuilder.getRequestId(), "requestId");
        f.a(purchaseResponseBuilder.getRequestStatus(), "requestStatus");
        if (purchaseResponseBuilder.getRequestStatus() == RequestStatus.SUCCESSFUL) {
            f.a(purchaseResponseBuilder.getReceipt(), "receipt");
            f.a(purchaseResponseBuilder.getUserData(), USER_DATA);
        }
        this.requestId = purchaseResponseBuilder.getRequestId();
        this.userData = purchaseResponseBuilder.getUserData();
        this.receipt = purchaseResponseBuilder.getReceipt();
        this.requestStatus = purchaseResponseBuilder.getRequestStatus();
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public Receipt getReceipt() {
        return this.receipt;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public String toString() {
        String string = super.toString();
        RequestId requestId = this.requestId;
        RequestStatus requestStatus = this.requestStatus;
        return String.format(TO_STRING_FORMAT, string, requestId, requestStatus != null ? requestStatus.toString() : "null", this.userData, this.receipt);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("requestStatus", this.requestStatus);
        UserData userData = this.userData;
        jSONObject.put(USER_DATA, userData != null ? userData.toJSON() : "");
        jSONObject.put("receipt", getReceipt() != null ? getReceipt().toJSON() : "");
        return jSONObject;
    }
}
