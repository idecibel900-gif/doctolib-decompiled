package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "", "()V", "animationType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterAnimationType;", "getAnimationType", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterAnimationType;", b.S, "", "getTitle", "()Ljava/lang/String;", "CreateSupportTicket", "FeedbackSurvey", "Main", "PromotionalOffer", "SelectedPurchaseDetail", "VirtualCurrencyBalances", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$CreateSupportTicket;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$FeedbackSurvey;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$Main;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$PromotionalOffer;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$SelectedPurchaseDetail;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$VirtualCurrencyBalances;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CustomerCenterDestination {
    public static final int $stable = 0;
    private final CustomerCenterAnimationType animationType;

    public /* synthetic */ CustomerCenterDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getTitle();

    private CustomerCenterDestination() {
        this.animationType = CustomerCenterAnimationType.SLIDE_HORIZONTAL;
    }

    public final CustomerCenterAnimationType getAnimationType() {
        return this.animationType;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$Main;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "showingActivePurchasesScreen", "", "managementScreenTitle", "", "(ZLjava/lang/String;)V", b.S, "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Main extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final String managementScreenTitle;
        private final boolean showingActivePurchasesScreen;
        private final String title;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final boolean getShowingActivePurchasesScreen() {
            return this.showingActivePurchasesScreen;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final String getManagementScreenTitle() {
            return this.managementScreenTitle;
        }

        public static /* synthetic */ Main copy$default(Main main, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = main.showingActivePurchasesScreen;
            }
            if ((i & 2) != 0) {
                str = main.managementScreenTitle;
            }
            return main.copy(z, str);
        }

        public final Main copy(boolean showingActivePurchasesScreen, String managementScreenTitle) {
            return new Main(showingActivePurchasesScreen, managementScreenTitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Main)) {
                return false;
            }
            Main main = (Main) other;
            return this.showingActivePurchasesScreen == main.showingActivePurchasesScreen && Intrinsics.areEqual(this.managementScreenTitle, main.managementScreenTitle);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.showingActivePurchasesScreen) * 31;
            String str = this.managementScreenTitle;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Main(showingActivePurchasesScreen=" + this.showingActivePurchasesScreen + ", managementScreenTitle=" + this.managementScreenTitle + ')';
        }

        public Main(boolean z, String str) {
            super(null);
            this.showingActivePurchasesScreen = z;
            this.managementScreenTitle = str;
            this.title = z ? str : null;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$FeedbackSurvey;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;", b.S, "", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;Ljava/lang/String;)V", "getData", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/FeedbackSurveyData;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FeedbackSurvey extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final FeedbackSurveyData data;
        private final String title;

        public static /* synthetic */ FeedbackSurvey copy$default(FeedbackSurvey feedbackSurvey, FeedbackSurveyData feedbackSurveyData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                feedbackSurveyData = feedbackSurvey.data;
            }
            if ((i & 2) != 0) {
                str = feedbackSurvey.title;
            }
            return feedbackSurvey.copy(feedbackSurveyData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FeedbackSurveyData getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final FeedbackSurvey copy(FeedbackSurveyData data, String title) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            return new FeedbackSurvey(data, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedbackSurvey)) {
                return false;
            }
            FeedbackSurvey feedbackSurvey = (FeedbackSurvey) other;
            return Intrinsics.areEqual(this.data, feedbackSurvey.data) && Intrinsics.areEqual(this.title, feedbackSurvey.title);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "FeedbackSurvey(data=" + this.data + ", title=" + this.title + ')';
        }

        public final FeedbackSurveyData getData() {
            return this.data;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedbackSurvey(FeedbackSurveyData data, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            this.data = data;
            this.title = title;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$PromotionalOffer;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;)V", "getData", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;", "getPurchaseInformation", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", b.S, "", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PromotionalOffer extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final PromotionalOfferData data;
        private final PurchaseInformation purchaseInformation;
        private final String title;

        public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, PromotionalOfferData promotionalOfferData, PurchaseInformation purchaseInformation, int i, Object obj) {
            if ((i & 1) != 0) {
                promotionalOfferData = promotionalOffer.data;
            }
            if ((i & 2) != 0) {
                purchaseInformation = promotionalOffer.purchaseInformation;
            }
            return promotionalOffer.copy(promotionalOfferData, purchaseInformation);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PromotionalOfferData getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        public final PromotionalOffer copy(PromotionalOfferData data, PurchaseInformation purchaseInformation) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PromotionalOffer(data, purchaseInformation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromotionalOffer)) {
                return false;
            }
            PromotionalOffer promotionalOffer = (PromotionalOffer) other;
            return Intrinsics.areEqual(this.data, promotionalOffer.data) && Intrinsics.areEqual(this.purchaseInformation, promotionalOffer.purchaseInformation);
        }

        public int hashCode() {
            int iHashCode = this.data.hashCode() * 31;
            PurchaseInformation purchaseInformation = this.purchaseInformation;
            return iHashCode + (purchaseInformation == null ? 0 : purchaseInformation.hashCode());
        }

        public String toString() {
            return "PromotionalOffer(data=" + this.data + ", purchaseInformation=" + this.purchaseInformation + ')';
        }

        public final PromotionalOfferData getData() {
            return this.data;
        }

        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PromotionalOffer(PromotionalOfferData data, PurchaseInformation purchaseInformation) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.purchaseInformation = purchaseInformation;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$SelectedPurchaseDetail;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", b.S, "", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Ljava/lang/String;)V", "getPurchaseInformation", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SelectedPurchaseDetail extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final PurchaseInformation purchaseInformation;
        private final String title;

        public static /* synthetic */ SelectedPurchaseDetail copy$default(SelectedPurchaseDetail selectedPurchaseDetail, PurchaseInformation purchaseInformation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                purchaseInformation = selectedPurchaseDetail.purchaseInformation;
            }
            if ((i & 2) != 0) {
                str = selectedPurchaseDetail.title;
            }
            return selectedPurchaseDetail.copy(purchaseInformation, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final SelectedPurchaseDetail copy(PurchaseInformation purchaseInformation, String title) {
            Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
            Intrinsics.checkNotNullParameter(title, "title");
            return new SelectedPurchaseDetail(purchaseInformation, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectedPurchaseDetail)) {
                return false;
            }
            SelectedPurchaseDetail selectedPurchaseDetail = (SelectedPurchaseDetail) other;
            return Intrinsics.areEqual(this.purchaseInformation, selectedPurchaseDetail.purchaseInformation) && Intrinsics.areEqual(this.title, selectedPurchaseDetail.title);
        }

        public int hashCode() {
            return (this.purchaseInformation.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "SelectedPurchaseDetail(purchaseInformation=" + this.purchaseInformation + ", title=" + this.title + ')';
        }

        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedPurchaseDetail(PurchaseInformation purchaseInformation, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
            Intrinsics.checkNotNullParameter(title, "title");
            this.purchaseInformation = purchaseInformation;
            this.title = title;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$VirtualCurrencyBalances;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", b.S, "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VirtualCurrencyBalances extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final String title;

        public static /* synthetic */ VirtualCurrencyBalances copy$default(VirtualCurrencyBalances virtualCurrencyBalances, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = virtualCurrencyBalances.title;
            }
            return virtualCurrencyBalances.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final VirtualCurrencyBalances copy(String title) {
            return new VirtualCurrencyBalances(title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VirtualCurrencyBalances) && Intrinsics.areEqual(this.title, ((VirtualCurrencyBalances) other).title);
        }

        public int hashCode() {
            String str = this.title;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "VirtualCurrencyBalances(title=" + this.title + ')';
        }

        public VirtualCurrencyBalances(String str) {
            super(null);
            this.title = str;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination$CreateSupportTicket;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", b.S, "", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;Ljava/lang/String;)V", "getData", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CreateSupportTicket extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final CreateSupportTicketData data;
        private final String title;

        public static /* synthetic */ CreateSupportTicket copy$default(CreateSupportTicket createSupportTicket, CreateSupportTicketData createSupportTicketData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                createSupportTicketData = createSupportTicket.data;
            }
            if ((i & 2) != 0) {
                str = createSupportTicket.title;
            }
            return createSupportTicket.copy(createSupportTicketData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreateSupportTicketData getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final CreateSupportTicket copy(CreateSupportTicketData data, String title) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            return new CreateSupportTicket(data, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateSupportTicket)) {
                return false;
            }
            CreateSupportTicket createSupportTicket = (CreateSupportTicket) other;
            return Intrinsics.areEqual(this.data, createSupportTicket.data) && Intrinsics.areEqual(this.title, createSupportTicket.title);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "CreateSupportTicket(data=" + this.data + ", title=" + this.title + ')';
        }

        public final CreateSupportTicketData getData() {
            return this.data;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateSupportTicket(CreateSupportTicketData data, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            this.data = data;
            this.title = title;
        }
    }
}
