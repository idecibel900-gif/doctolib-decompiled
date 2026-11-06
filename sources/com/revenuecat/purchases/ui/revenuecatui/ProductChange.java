package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ReplacementMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/ProductChange;", "", "oldProductId", "", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "getOldProductId", "()Ljava/lang/String;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProductChange {
    public static final int $stable = 8;
    private final String oldProductId;
    private final ReplacementMode replacementMode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductChange)) {
            return false;
        }
        ProductChange productChange = (ProductChange) obj;
        return Intrinsics.areEqual(this.oldProductId, productChange.oldProductId) && Intrinsics.areEqual(this.replacementMode, productChange.replacementMode);
    }

    public int hashCode() {
        int iHashCode = this.oldProductId.hashCode() * 31;
        ReplacementMode replacementMode = this.replacementMode;
        return iHashCode + (replacementMode == null ? 0 : replacementMode.hashCode());
    }

    public String toString() {
        return "ProductChange(oldProductId=" + this.oldProductId + ", replacementMode=" + this.replacementMode + ')';
    }

    public ProductChange(String oldProductId, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        this.oldProductId = oldProductId;
        this.replacementMode = replacementMode;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }
}
