package com.revenuecat.purchases.common.offlineentitlements;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "", "productIdentifier", "", "basePlanId", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", CustomerInfoResponseJsonKeys.ENTITLEMENTS, "", "expiresDate", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreTransaction;Ljava/util/List;Ljava/util/Date;)V", "getBasePlanId", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "getExpiresDate", "()Ljava/util/Date;", "getProductIdentifier", "getStoreTransaction", "()Lcom/revenuecat/purchases/models/StoreTransaction;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PurchasedProduct {
    private final String basePlanId;
    private final List<String> entitlements;
    private final Date expiresDate;
    private final String productIdentifier;
    private final StoreTransaction storeTransaction;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PurchasedProduct copy$default(PurchasedProduct purchasedProduct, String str, String str2, StoreTransaction storeTransaction, List list, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = purchasedProduct.productIdentifier;
        }
        if ((i & 2) != 0) {
            str2 = purchasedProduct.basePlanId;
        }
        if ((i & 4) != 0) {
            storeTransaction = purchasedProduct.storeTransaction;
        }
        if ((i & 8) != 0) {
            list = purchasedProduct.entitlements;
        }
        if ((i & 16) != 0) {
            date = purchasedProduct.expiresDate;
        }
        Date date2 = date;
        StoreTransaction storeTransaction2 = storeTransaction;
        return purchasedProduct.copy(str, str2, storeTransaction2, list, date2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBasePlanId() {
        return this.basePlanId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreTransaction getStoreTransaction() {
        return this.storeTransaction;
    }

    public final List<String> component4() {
        return this.entitlements;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final PurchasedProduct copy(String productIdentifier, String basePlanId, StoreTransaction storeTransaction, List<String> entitlements, Date expiresDate) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new PurchasedProduct(productIdentifier, basePlanId, storeTransaction, entitlements, expiresDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchasedProduct)) {
            return false;
        }
        PurchasedProduct purchasedProduct = (PurchasedProduct) other;
        return Intrinsics.areEqual(this.productIdentifier, purchasedProduct.productIdentifier) && Intrinsics.areEqual(this.basePlanId, purchasedProduct.basePlanId) && Intrinsics.areEqual(this.storeTransaction, purchasedProduct.storeTransaction) && Intrinsics.areEqual(this.entitlements, purchasedProduct.entitlements) && Intrinsics.areEqual(this.expiresDate, purchasedProduct.expiresDate);
    }

    public int hashCode() {
        int iHashCode = this.productIdentifier.hashCode() * 31;
        String str = this.basePlanId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.storeTransaction.hashCode()) * 31) + this.entitlements.hashCode()) * 31;
        Date date = this.expiresDate;
        return iHashCode2 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "PurchasedProduct(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", storeTransaction=" + this.storeTransaction + ", entitlements=" + this.entitlements + ", expiresDate=" + this.expiresDate + ')';
    }

    public PurchasedProduct(String productIdentifier, String str, StoreTransaction storeTransaction, List<String> entitlements, Date date) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.productIdentifier = productIdentifier;
        this.basePlanId = str;
        this.storeTransaction = storeTransaction;
        this.entitlements = entitlements;
        this.expiresDate = date;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final StoreTransaction getStoreTransaction() {
        return this.storeTransaction;
    }

    public final List<String> getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }
}
