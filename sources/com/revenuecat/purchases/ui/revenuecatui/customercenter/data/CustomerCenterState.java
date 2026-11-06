package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterNavigationState;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0011\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "", "navigationButtonType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;)V", "getNavigationButtonType", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "Error", "Loading", "NavigationButtonType", "NotLoaded", "Success", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NotLoaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CustomerCenterState {
    public static final int $stable = 0;
    private final NavigationButtonType navigationButtonType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "", "(Ljava/lang/String;I)V", "BACK", "CLOSE", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum NavigationButtonType {
        BACK,
        CLOSE
    }

    public /* synthetic */ CustomerCenterState(NavigationButtonType navigationButtonType, DefaultConstructorMarker defaultConstructorMarker) {
        this(navigationButtonType);
    }

    private CustomerCenterState(NavigationButtonType navigationButtonType) {
        this.navigationButtonType = navigationButtonType;
    }

    public /* synthetic */ CustomerCenterState(NavigationButtonType navigationButtonType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NavigationButtonType.CLOSE : navigationButtonType, null);
    }

    public /* synthetic */ NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NotLoaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NotLoaded extends CustomerCenterState {
        public static final int $stable = 0;
        public static final NotLoaded INSTANCE = new NotLoaded();

        /* JADX WARN: Multi-variable type inference failed */
        private NotLoaded() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Loading extends CustomerCenterState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        /* JADX WARN: Multi-variable type inference failed */
        private Loading() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error extends CustomerCenterState {
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

        public final PurchasesError getError() {
            return this.error;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Error(PurchasesError error) {
            super(null, 1, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0015HÆ\u0003J\t\u00100\u001a\u00020\u0015HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u008f\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001J\u0013\u0010:\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020@HÖ\u0001R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006A"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$Success;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "customerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "purchases", "", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "mainScreenPaths", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "detailScreenPaths", "restorePurchasesState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/dialogs/RestorePurchasesState;", "noActiveScreenOffering", "Lcom/revenuecat/purchases/Offering;", "navigationState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterNavigationState;", "navigationButtonType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "virtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "showSupportTicketSuccessSnackbar", "", "isRefreshing", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/dialogs/RestorePurchasesState;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterNavigationState;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;ZZ)V", "currentDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "getCurrentDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "getCustomerCenterConfigData", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "getDetailScreenPaths", "()Ljava/util/List;", "()Z", "getMainScreenPaths", "getNavigationButtonType", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "getNavigationState", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterNavigationState;", "getNoActiveScreenOffering", "()Lcom/revenuecat/purchases/Offering;", "getPurchases", "getRestorePurchasesState", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/dialogs/RestorePurchasesState;", "getShowSupportTicketSuccessSnackbar", "getVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success extends CustomerCenterState {
        public static final int $stable = 8;
        private final CustomerCenterConfigData customerCenterConfigData;
        private final List<CustomerCenterConfigData.HelpPath> detailScreenPaths;
        private final boolean isRefreshing;
        private final List<CustomerCenterConfigData.HelpPath> mainScreenPaths;
        private final NavigationButtonType navigationButtonType;
        private final CustomerCenterNavigationState navigationState;
        private final Offering noActiveScreenOffering;
        private final List<PurchaseInformation> purchases;
        private final RestorePurchasesState restorePurchasesState;
        private final boolean showSupportTicketSuccessSnackbar;
        private final VirtualCurrencies virtualCurrencies;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, CustomerCenterConfigData customerCenterConfigData, List list, List list2, List list3, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState customerCenterNavigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                customerCenterConfigData = success.customerCenterConfigData;
            }
            if ((i & 2) != 0) {
                list = success.purchases;
            }
            if ((i & 4) != 0) {
                list2 = success.mainScreenPaths;
            }
            if ((i & 8) != 0) {
                list3 = success.detailScreenPaths;
            }
            if ((i & 16) != 0) {
                restorePurchasesState = success.restorePurchasesState;
            }
            if ((i & 32) != 0) {
                offering = success.noActiveScreenOffering;
            }
            if ((i & 64) != 0) {
                customerCenterNavigationState = success.navigationState;
            }
            if ((i & 128) != 0) {
                navigationButtonType = success.navigationButtonType;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
                virtualCurrencies = success.virtualCurrencies;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
                z = success.showSupportTicketSuccessSnackbar;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
                z2 = success.isRefreshing;
            }
            boolean z3 = z;
            boolean z4 = z2;
            NavigationButtonType navigationButtonType2 = navigationButtonType;
            VirtualCurrencies virtualCurrencies2 = virtualCurrencies;
            Offering offering2 = offering;
            CustomerCenterNavigationState customerCenterNavigationState2 = customerCenterNavigationState;
            RestorePurchasesState restorePurchasesState2 = restorePurchasesState;
            List list4 = list2;
            return success.copy(customerCenterConfigData, list, list4, list3, restorePurchasesState2, offering2, customerCenterNavigationState2, navigationButtonType2, virtualCurrencies2, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CustomerCenterConfigData getCustomerCenterConfigData() {
            return this.customerCenterConfigData;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getShowSupportTicketSuccessSnackbar() {
            return this.showSupportTicketSuccessSnackbar;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsRefreshing() {
            return this.isRefreshing;
        }

        public final List<PurchaseInformation> component2() {
            return this.purchases;
        }

        public final List<CustomerCenterConfigData.HelpPath> component3() {
            return this.mainScreenPaths;
        }

        public final List<CustomerCenterConfigData.HelpPath> component4() {
            return this.detailScreenPaths;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final RestorePurchasesState getRestorePurchasesState() {
            return this.restorePurchasesState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Offering getNoActiveScreenOffering() {
            return this.noActiveScreenOffering;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final CustomerCenterNavigationState getNavigationState() {
            return this.navigationState;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final NavigationButtonType getNavigationButtonType() {
            return this.navigationButtonType;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final VirtualCurrencies getVirtualCurrencies() {
            return this.virtualCurrencies;
        }

        public final Success copy(CustomerCenterConfigData customerCenterConfigData, List<PurchaseInformation> purchases, List<CustomerCenterConfigData.HelpPath> mainScreenPaths, List<CustomerCenterConfigData.HelpPath> detailScreenPaths, RestorePurchasesState restorePurchasesState, Offering noActiveScreenOffering, CustomerCenterNavigationState navigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean showSupportTicketSuccessSnackbar, boolean isRefreshing) {
            Intrinsics.checkNotNullParameter(customerCenterConfigData, "customerCenterConfigData");
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(mainScreenPaths, "mainScreenPaths");
            Intrinsics.checkNotNullParameter(detailScreenPaths, "detailScreenPaths");
            Intrinsics.checkNotNullParameter(navigationState, "navigationState");
            Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
            return new Success(customerCenterConfigData, purchases, mainScreenPaths, detailScreenPaths, restorePurchasesState, noActiveScreenOffering, navigationState, navigationButtonType, virtualCurrencies, showSupportTicketSuccessSnackbar, isRefreshing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.customerCenterConfigData, success.customerCenterConfigData) && Intrinsics.areEqual(this.purchases, success.purchases) && Intrinsics.areEqual(this.mainScreenPaths, success.mainScreenPaths) && Intrinsics.areEqual(this.detailScreenPaths, success.detailScreenPaths) && this.restorePurchasesState == success.restorePurchasesState && Intrinsics.areEqual(this.noActiveScreenOffering, success.noActiveScreenOffering) && Intrinsics.areEqual(this.navigationState, success.navigationState) && this.navigationButtonType == success.navigationButtonType && Intrinsics.areEqual(this.virtualCurrencies, success.virtualCurrencies) && this.showSupportTicketSuccessSnackbar == success.showSupportTicketSuccessSnackbar && this.isRefreshing == success.isRefreshing;
        }

        public int hashCode() {
            int iHashCode = ((((((this.customerCenterConfigData.hashCode() * 31) + this.purchases.hashCode()) * 31) + this.mainScreenPaths.hashCode()) * 31) + this.detailScreenPaths.hashCode()) * 31;
            RestorePurchasesState restorePurchasesState = this.restorePurchasesState;
            int iHashCode2 = (iHashCode + (restorePurchasesState == null ? 0 : restorePurchasesState.hashCode())) * 31;
            Offering offering = this.noActiveScreenOffering;
            int iHashCode3 = (((((iHashCode2 + (offering == null ? 0 : offering.hashCode())) * 31) + this.navigationState.hashCode()) * 31) + this.navigationButtonType.hashCode()) * 31;
            VirtualCurrencies virtualCurrencies = this.virtualCurrencies;
            return ((((iHashCode3 + (virtualCurrencies != null ? virtualCurrencies.hashCode() : 0)) * 31) + Boolean.hashCode(this.showSupportTicketSuccessSnackbar)) * 31) + Boolean.hashCode(this.isRefreshing);
        }

        public String toString() {
            return "Success(customerCenterConfigData=" + this.customerCenterConfigData + ", purchases=" + this.purchases + ", mainScreenPaths=" + this.mainScreenPaths + ", detailScreenPaths=" + this.detailScreenPaths + ", restorePurchasesState=" + this.restorePurchasesState + ", noActiveScreenOffering=" + this.noActiveScreenOffering + ", navigationState=" + this.navigationState + ", navigationButtonType=" + this.navigationButtonType + ", virtualCurrencies=" + this.virtualCurrencies + ", showSupportTicketSuccessSnackbar=" + this.showSupportTicketSuccessSnackbar + ", isRefreshing=" + this.isRefreshing + ')';
        }

        public final /* synthetic */ CustomerCenterConfigData getCustomerCenterConfigData() {
            return this.customerCenterConfigData;
        }

        public /* synthetic */ Success(CustomerCenterConfigData customerCenterConfigData, List list, List list2, List list3, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState customerCenterNavigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            CustomerCenterNavigationState customerCenterNavigationState2;
            List listEmptyList = (i & 2) != 0 ? CollectionsKt.emptyList() : list;
            List listEmptyList2 = (i & 4) != 0 ? CollectionsKt.emptyList() : list2;
            List listEmptyList3 = (i & 8) != 0 ? CollectionsKt.emptyList() : list3;
            RestorePurchasesState restorePurchasesState2 = (i & 16) != 0 ? null : restorePurchasesState;
            Offering offering2 = (i & 32) != 0 ? null : offering;
            if ((i & 64) != 0) {
                boolean z3 = !listEmptyList.isEmpty();
                CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
                customerCenterNavigationState2 = new CustomerCenterNavigationState(z3, managementScreen != null ? managementScreen.getTitle() : null, null, 4, null);
            } else {
                customerCenterNavigationState2 = customerCenterNavigationState;
            }
            this(customerCenterConfigData, listEmptyList, listEmptyList2, listEmptyList3, restorePurchasesState2, offering2, customerCenterNavigationState2, (i & 128) != 0 ? NavigationButtonType.CLOSE : navigationButtonType, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : virtualCurrencies, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? false : z, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? false : z2);
        }

        public final /* synthetic */ List getPurchases() {
            return this.purchases;
        }

        public final /* synthetic */ List getMainScreenPaths() {
            return this.mainScreenPaths;
        }

        public final /* synthetic */ List getDetailScreenPaths() {
            return this.detailScreenPaths;
        }

        public final /* synthetic */ RestorePurchasesState getRestorePurchasesState() {
            return this.restorePurchasesState;
        }

        public final /* synthetic */ Offering getNoActiveScreenOffering() {
            return this.noActiveScreenOffering;
        }

        public final /* synthetic */ CustomerCenterNavigationState getNavigationState() {
            return this.navigationState;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState
        public /* synthetic */ NavigationButtonType getNavigationButtonType() {
            return this.navigationButtonType;
        }

        public final /* synthetic */ VirtualCurrencies getVirtualCurrencies() {
            return this.virtualCurrencies;
        }

        public final /* synthetic */ boolean getShowSupportTicketSuccessSnackbar() {
            return this.showSupportTicketSuccessSnackbar;
        }

        public final /* synthetic */ boolean isRefreshing() {
            return this.isRefreshing;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(CustomerCenterConfigData customerCenterConfigData, List<PurchaseInformation> purchases, List<CustomerCenterConfigData.HelpPath> mainScreenPaths, List<CustomerCenterConfigData.HelpPath> detailScreenPaths, RestorePurchasesState restorePurchasesState, Offering offering, CustomerCenterNavigationState navigationState, NavigationButtonType navigationButtonType, VirtualCurrencies virtualCurrencies, boolean z, boolean z2) {
            super(navigationButtonType, null);
            Intrinsics.checkNotNullParameter(customerCenterConfigData, "customerCenterConfigData");
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(mainScreenPaths, "mainScreenPaths");
            Intrinsics.checkNotNullParameter(detailScreenPaths, "detailScreenPaths");
            Intrinsics.checkNotNullParameter(navigationState, "navigationState");
            Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
            this.customerCenterConfigData = customerCenterConfigData;
            this.purchases = purchases;
            this.mainScreenPaths = mainScreenPaths;
            this.detailScreenPaths = detailScreenPaths;
            this.restorePurchasesState = restorePurchasesState;
            this.noActiveScreenOffering = offering;
            this.navigationState = navigationState;
            this.navigationButtonType = navigationButtonType;
            this.virtualCurrencies = virtualCurrencies;
            this.showSupportTicketSuccessSnackbar = z;
            this.isRefreshing = z2;
        }

        public final CustomerCenterDestination getCurrentDestination() {
            return this.navigationState.getCurrentDestination();
        }
    }
}
