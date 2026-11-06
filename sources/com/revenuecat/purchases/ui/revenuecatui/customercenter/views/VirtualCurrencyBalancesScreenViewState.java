package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "", "Error", "Loaded", "Loading", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Loading;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VirtualCurrencyBalancesScreenViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Loading implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "virtualCurrencyBalanceData", "", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "(Ljava/util/List;)V", "getVirtualCurrencyBalanceData", "()Ljava/util/List;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Loaded implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 8;
        private final List<VirtualCurrency> virtualCurrencyBalanceData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = loaded.virtualCurrencyBalanceData;
            }
            return loaded.copy(list);
        }

        public final List<VirtualCurrency> component1() {
            return this.virtualCurrencyBalanceData;
        }

        public final Loaded copy(List<VirtualCurrency> virtualCurrencyBalanceData) {
            Intrinsics.checkNotNullParameter(virtualCurrencyBalanceData, "virtualCurrencyBalanceData");
            return new Loaded(virtualCurrencyBalanceData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loaded) && Intrinsics.areEqual(this.virtualCurrencyBalanceData, ((Loaded) other).virtualCurrencyBalanceData);
        }

        public int hashCode() {
            return this.virtualCurrencyBalanceData.hashCode();
        }

        public String toString() {
            return "Loaded(virtualCurrencyBalanceData=" + this.virtualCurrencyBalanceData + ')';
        }

        public Loaded(List<VirtualCurrency> virtualCurrencyBalanceData) {
            Intrinsics.checkNotNullParameter(virtualCurrencyBalanceData, "virtualCurrencyBalanceData");
            this.virtualCurrencyBalanceData = virtualCurrencyBalanceData;
        }

        public final List<VirtualCurrency> getVirtualCurrencyBalanceData() {
            return this.virtualCurrencyBalanceData;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error implements VirtualCurrencyBalancesScreenViewState {
        public static final int $stable = 0;
        private final PurchasesError error;

        public static /* synthetic */ Error copy$default(Error error, PurchasesError purchasesError, int i, Object obj) {
            if ((i & 1) != 0) {
                purchasesError = error.error;
            }
            return error.copy(purchasesError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PurchasesError getError() {
            return this.error;
        }

        public final Error copy(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }

        public Error(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final PurchasesError getError() {
            return this.error;
        }
    }
}
