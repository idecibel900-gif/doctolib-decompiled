package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "productInfoByProductId", "", "", "Lcom/revenuecat/purchases/common/networking/PostReceiptProductInfo;", "body", "Lorg/json/JSONObject;", "(Lcom/revenuecat/purchases/CustomerInfo;Ljava/util/Map;Lorg/json/JSONObject;)V", "getBody", "()Lorg/json/JSONObject;", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "getProductInfoByProductId", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostReceiptResponse {
    private final JSONObject body;
    private final CustomerInfo customerInfo;
    private final Map<String, PostReceiptProductInfo> productInfoByProductId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostReceiptResponse copy$default(PostReceiptResponse postReceiptResponse, CustomerInfo customerInfo, Map map, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            customerInfo = postReceiptResponse.customerInfo;
        }
        if ((i & 2) != 0) {
            map = postReceiptResponse.productInfoByProductId;
        }
        if ((i & 4) != 0) {
            jSONObject = postReceiptResponse.body;
        }
        return postReceiptResponse.copy(customerInfo, map, jSONObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> component2() {
        return this.productInfoByProductId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JSONObject getBody() {
        return this.body;
    }

    public final PostReceiptResponse copy(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> productInfoByProductId, JSONObject body) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(body, "body");
        return new PostReceiptResponse(customerInfo, productInfoByProductId, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostReceiptResponse)) {
            return false;
        }
        PostReceiptResponse postReceiptResponse = (PostReceiptResponse) other;
        return Intrinsics.areEqual(this.customerInfo, postReceiptResponse.customerInfo) && Intrinsics.areEqual(this.productInfoByProductId, postReceiptResponse.productInfoByProductId) && Intrinsics.areEqual(this.body, postReceiptResponse.body);
    }

    public int hashCode() {
        int iHashCode = this.customerInfo.hashCode() * 31;
        Map<String, PostReceiptProductInfo> map = this.productInfoByProductId;
        return ((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "PostReceiptResponse(customerInfo=" + this.customerInfo + ", productInfoByProductId=" + this.productInfoByProductId + ", body=" + this.body + ')';
    }

    public PostReceiptResponse(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> map, JSONObject body) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(body, "body");
        this.customerInfo = customerInfo;
        this.productInfoByProductId = map;
        this.body = body;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> getProductInfoByProductId() {
        return this.productInfoByProductId;
    }

    public final JSONObject getBody() {
        return this.body;
    }
}
