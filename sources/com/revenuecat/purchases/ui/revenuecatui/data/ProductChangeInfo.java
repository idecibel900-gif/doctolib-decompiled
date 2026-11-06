package com.revenuecat.purchases.ui.revenuecatui.data;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.models.StoreReplacementMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeInfo;", "", "oldProductId", "", "replacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "(Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreReplacementMode;)V", "getOldProductId", "()Ljava/lang/String;", "getReplacementMode", "()Lcom/revenuecat/purchases/models/StoreReplacementMode;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProductChangeInfo {
    public static final int $stable = 8;
    private final String oldProductId;
    private final StoreReplacementMode replacementMode;

    public static /* synthetic */ ProductChangeInfo copy$default(ProductChangeInfo productChangeInfo, String str, StoreReplacementMode storeReplacementMode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productChangeInfo.oldProductId;
        }
        if ((i & 2) != 0) {
            storeReplacementMode = productChangeInfo.replacementMode;
        }
        return productChangeInfo.copy(str, storeReplacementMode);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOldProductId() {
        return this.oldProductId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final ProductChangeInfo copy(String oldProductId, StoreReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
        return new ProductChangeInfo(oldProductId, replacementMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductChangeInfo)) {
            return false;
        }
        ProductChangeInfo productChangeInfo = (ProductChangeInfo) other;
        return Intrinsics.areEqual(this.oldProductId, productChangeInfo.oldProductId) && Intrinsics.areEqual(this.replacementMode, productChangeInfo.replacementMode);
    }

    public int hashCode() {
        return (this.oldProductId.hashCode() * 31) + this.replacementMode.hashCode();
    }

    public String toString() {
        return "ProductChangeInfo(oldProductId=" + this.oldProductId + ", replacementMode=" + this.replacementMode + ')';
    }

    public ProductChangeInfo(String oldProductId, StoreReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
        this.oldProductId = oldProductId;
        this.replacementMode = replacementMode;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }
}
