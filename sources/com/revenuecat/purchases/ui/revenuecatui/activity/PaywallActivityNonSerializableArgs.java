package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityNonSerializableArgs;", "", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)V", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallActivityNonSerializableArgs {
    public static final int $stable = 0;
    private final PaywallListener listener;
    private final PaywallPurchaseLogic purchaseLogic;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityNonSerializableArgs() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PaywallActivityNonSerializableArgs copy$default(PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, int i, Object obj) {
        if ((i & 1) != 0) {
            paywallPurchaseLogic = paywallActivityNonSerializableArgs.purchaseLogic;
        }
        if ((i & 2) != 0) {
            paywallListener = paywallActivityNonSerializableArgs.listener;
        }
        return paywallActivityNonSerializableArgs.copy(paywallPurchaseLogic, paywallListener);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PaywallListener getListener() {
        return this.listener;
    }

    public final PaywallActivityNonSerializableArgs copy(PaywallPurchaseLogic purchaseLogic, PaywallListener listener) {
        return new PaywallActivityNonSerializableArgs(purchaseLogic, listener);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallActivityNonSerializableArgs)) {
            return false;
        }
        PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs = (PaywallActivityNonSerializableArgs) other;
        return Intrinsics.areEqual(this.purchaseLogic, paywallActivityNonSerializableArgs.purchaseLogic) && Intrinsics.areEqual(this.listener, paywallActivityNonSerializableArgs.listener);
    }

    public int hashCode() {
        PaywallPurchaseLogic paywallPurchaseLogic = this.purchaseLogic;
        int iHashCode = (paywallPurchaseLogic == null ? 0 : paywallPurchaseLogic.hashCode()) * 31;
        PaywallListener paywallListener = this.listener;
        return iHashCode + (paywallListener != null ? paywallListener.hashCode() : 0);
    }

    public String toString() {
        return "PaywallActivityNonSerializableArgs(purchaseLogic=" + this.purchaseLogic + ", listener=" + this.listener + ')';
    }

    public PaywallActivityNonSerializableArgs(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener) {
        this.purchaseLogic = paywallPurchaseLogic;
        this.listener = paywallListener;
    }

    public /* synthetic */ PaywallActivityNonSerializableArgs(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : paywallPurchaseLogic, (i & 2) != 0 ? null : paywallListener);
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public final PaywallListener getListener() {
        return this.listener;
    }
}
