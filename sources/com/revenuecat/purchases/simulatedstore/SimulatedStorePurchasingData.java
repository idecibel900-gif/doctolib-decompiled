package com.revenuecat.purchases.simulatedstore;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/simulatedstore/SimulatedStorePurchasingData;", "Lcom/revenuecat/purchases/models/PurchasingData;", "productId", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/StoreProduct;)V", "getProductId", "()Ljava/lang/String;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "getStoreProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SimulatedStorePurchasingData implements PurchasingData {
    private final String productId;
    private final ProductType productType;
    private final StoreProduct storeProduct;

    public static /* synthetic */ SimulatedStorePurchasingData copy$default(SimulatedStorePurchasingData simulatedStorePurchasingData, String str, ProductType productType, StoreProduct storeProduct, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simulatedStorePurchasingData.productId;
        }
        if ((i & 2) != 0) {
            productType = simulatedStorePurchasingData.productType;
        }
        if ((i & 4) != 0) {
            storeProduct = simulatedStorePurchasingData.storeProduct;
        }
        return simulatedStorePurchasingData.copy(str, productType, storeProduct);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    public final SimulatedStorePurchasingData copy(String productId, ProductType productType, StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        return new SimulatedStorePurchasingData(productId, productType, storeProduct);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimulatedStorePurchasingData)) {
            return false;
        }
        SimulatedStorePurchasingData simulatedStorePurchasingData = (SimulatedStorePurchasingData) other;
        return Intrinsics.areEqual(this.productId, simulatedStorePurchasingData.productId) && this.productType == simulatedStorePurchasingData.productType && Intrinsics.areEqual(this.storeProduct, simulatedStorePurchasingData.storeProduct);
    }

    public int hashCode() {
        return (((this.productId.hashCode() * 31) + this.productType.hashCode()) * 31) + this.storeProduct.hashCode();
    }

    public String toString() {
        return "SimulatedStorePurchasingData(productId=" + this.productId + ", productType=" + this.productType + ", storeProduct=" + this.storeProduct + ')';
    }

    public SimulatedStorePurchasingData(String productId, ProductType productType, StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        this.productId = productId;
        this.productType = productType;
        this.storeProduct = storeProduct;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.PurchasingData
    public ProductType getProductType() {
        return this.productType;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }
}
