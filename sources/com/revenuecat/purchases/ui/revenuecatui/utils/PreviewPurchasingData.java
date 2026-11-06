package com.revenuecat.purchases.ui.revenuecatui.utils;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/PreviewPurchasingData;", "Lcom/revenuecat/purchases/models/PurchasingData;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "productType", "Lcom/revenuecat/purchases/ProductType;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PreviewPurchasingData implements PurchasingData {
    public static final int $stable = 0;
    private final String productId;

    public static /* synthetic */ PreviewPurchasingData copy$default(PreviewPurchasingData previewPurchasingData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = previewPurchasingData.productId;
        }
        return previewPurchasingData.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    public final PreviewPurchasingData copy(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return new PreviewPurchasingData(productId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PreviewPurchasingData) && Intrinsics.areEqual(this.productId, ((PreviewPurchasingData) other).productId);
    }

    public int hashCode() {
        return this.productId.hashCode();
    }

    public String toString() {
        return "PreviewPurchasingData(productId=" + this.productId + ')';
    }

    public PreviewPurchasingData(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.productId = productId;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public /* synthetic */ String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public /* synthetic */ ProductType getProductType() {
        return ProductType.SUBS;
    }
}
