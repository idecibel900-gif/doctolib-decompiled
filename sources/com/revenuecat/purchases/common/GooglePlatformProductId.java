package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/GooglePlatformProductId;", "Lcom/revenuecat/purchases/common/PlatformProductId;", "productId", "", "basePlanId", "offerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "asMap", "", "getAsMap", "()Ljava/util/Map;", "getBasePlanId", "()Ljava/lang/String;", "getOfferId", "getProductId", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class GooglePlatformProductId extends PlatformProductId {
    private final String basePlanId;
    private final String offerId;
    private final String productId;

    public /* synthetic */ GooglePlatformProductId(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Override // com.revenuecat.purchases.common.PlatformProductId
    public String getProductId() {
        return this.productId;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GooglePlatformProductId(String productId, String str, String str2) {
        super(productId);
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.productId = productId;
        this.basePlanId = str;
        this.offerId = str2;
    }

    @Override // com.revenuecat.purchases.common.PlatformProductId
    public Map<String, String> getAsMap() {
        return MapsKt.mapOf(TuplesKt.to(DiagnosticsTracker.PRODUCT_ID_KEY, getProductId()), TuplesKt.to("base_plan_id", this.basePlanId), TuplesKt.to("offer_id", this.offerId));
    }
}
