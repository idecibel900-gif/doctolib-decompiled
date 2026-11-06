package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/PlatformProductId;", "", "productId", "", "(Ljava/lang/String;)V", "asMap", "", "getAsMap", "()Ljava/util/Map;", "getProductId", "()Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
class PlatformProductId {
    private final String productId;

    public PlatformProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.productId = productId;
    }

    public String getProductId() {
        return this.productId;
    }

    public Map<String, String> getAsMap() {
        return MapsKt.mapOf(TuplesKt.to(DiagnosticsTracker.PRODUCT_ID_KEY, getProductId()));
    }
}
