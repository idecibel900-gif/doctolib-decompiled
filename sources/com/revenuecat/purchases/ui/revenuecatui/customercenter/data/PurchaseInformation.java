package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import android.net.Uri;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.DefaultDateFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BA\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eBe\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0002\u0010 J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0019HÆ\u0003J\t\u00102\u001a\u00020\u0019HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0017HÆ\u0003J\t\u00107\u001a\u00020\u0019HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u00109\u001a\u00020\u0019HÆ\u0003J\t\u0010:\u001a\u00020\u0019HÆ\u0003J\u007f\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u0019HÆ\u0001J\u0013\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0016\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\t\u0010@\u001a\u00020AHÖ\u0001J\u0016\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\t\u0010D\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010#R\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010#R\u0011\u0010\u001f\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010#R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u001d\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006E"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "", "entitlementInfo", "Lcom/revenuecat/purchases/EntitlementInfo;", "subscribedProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "transaction", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails;", "dateFormatter", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;", "locale", "Ljava/util/Locale;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "(Lcom/revenuecat/purchases/EntitlementInfo;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails;Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;Ljava/util/Locale;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;)V", b.S, "", "pricePaid", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "expirationOrRenewal", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "product", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "isSubscription", "", "managementURL", "Landroid/net/Uri;", "isExpired", "isTrial", "isCancelled", "isLifetime", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/Store;ZLandroid/net/Uri;ZZZZ)V", "getExpirationOrRenewal", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "()Z", "setSubscription", "(Z)V", "getManagementURL", "()Landroid/net/Uri;", "getPricePaid", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "getProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getTitle", "()Ljava/lang/String;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "expirationString", "expirationDate", "hashCode", "", "renewalString", "renewalDate", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PurchaseInformation {
    public static final int $stable = 8;
    private final ExpirationOrRenewal expirationOrRenewal;
    private final boolean isCancelled;
    private final boolean isExpired;
    private final boolean isLifetime;
    private boolean isSubscription;
    private final boolean isTrial;
    private final Uri managementURL;
    private final PriceDetails pricePaid;
    private final StoreProduct product;
    private final Store store;
    private final String title;

    public static /* synthetic */ PurchaseInformation copy$default(PurchaseInformation purchaseInformation, String str, PriceDetails priceDetails, ExpirationOrRenewal expirationOrRenewal, StoreProduct storeProduct, Store store, boolean z, Uri uri, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = purchaseInformation.title;
        }
        if ((i & 2) != 0) {
            priceDetails = purchaseInformation.pricePaid;
        }
        if ((i & 4) != 0) {
            expirationOrRenewal = purchaseInformation.expirationOrRenewal;
        }
        if ((i & 8) != 0) {
            storeProduct = purchaseInformation.product;
        }
        if ((i & 16) != 0) {
            store = purchaseInformation.store;
        }
        if ((i & 32) != 0) {
            z = purchaseInformation.isSubscription;
        }
        if ((i & 64) != 0) {
            uri = purchaseInformation.managementURL;
        }
        if ((i & 128) != 0) {
            z2 = purchaseInformation.isExpired;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z3 = purchaseInformation.isTrial;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            z4 = purchaseInformation.isCancelled;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            z5 = purchaseInformation.isLifetime;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        boolean z8 = z2;
        boolean z9 = z3;
        boolean z10 = z;
        Uri uri2 = uri;
        Store store2 = store;
        ExpirationOrRenewal expirationOrRenewal2 = expirationOrRenewal;
        return purchaseInformation.copy(str, priceDetails, expirationOrRenewal2, storeProduct, store2, z10, uri2, z8, z9, z6, z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsCancelled() {
        return this.isCancelled;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsLifetime() {
        return this.isLifetime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PriceDetails getPricePaid() {
        return this.pricePaid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExpirationOrRenewal getExpirationOrRenewal() {
        return this.expirationOrRenewal;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreProduct getProduct() {
        return this.product;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSubscription() {
        return this.isSubscription;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Uri getManagementURL() {
        return this.managementURL;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsExpired() {
        return this.isExpired;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsTrial() {
        return this.isTrial;
    }

    public final PurchaseInformation copy(String title, PriceDetails pricePaid, ExpirationOrRenewal expirationOrRenewal, StoreProduct product, Store store, boolean isSubscription, Uri managementURL, boolean isExpired, boolean isTrial, boolean isCancelled, boolean isLifetime) {
        Intrinsics.checkNotNullParameter(pricePaid, "pricePaid");
        Intrinsics.checkNotNullParameter(store, "store");
        return new PurchaseInformation(title, pricePaid, expirationOrRenewal, product, store, isSubscription, managementURL, isExpired, isTrial, isCancelled, isLifetime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseInformation)) {
            return false;
        }
        PurchaseInformation purchaseInformation = (PurchaseInformation) other;
        return Intrinsics.areEqual(this.title, purchaseInformation.title) && Intrinsics.areEqual(this.pricePaid, purchaseInformation.pricePaid) && Intrinsics.areEqual(this.expirationOrRenewal, purchaseInformation.expirationOrRenewal) && Intrinsics.areEqual(this.product, purchaseInformation.product) && this.store == purchaseInformation.store && this.isSubscription == purchaseInformation.isSubscription && Intrinsics.areEqual(this.managementURL, purchaseInformation.managementURL) && this.isExpired == purchaseInformation.isExpired && this.isTrial == purchaseInformation.isTrial && this.isCancelled == purchaseInformation.isCancelled && this.isLifetime == purchaseInformation.isLifetime;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.pricePaid.hashCode()) * 31;
        ExpirationOrRenewal expirationOrRenewal = this.expirationOrRenewal;
        int iHashCode2 = (iHashCode + (expirationOrRenewal == null ? 0 : expirationOrRenewal.hashCode())) * 31;
        StoreProduct storeProduct = this.product;
        int iHashCode3 = (((((iHashCode2 + (storeProduct == null ? 0 : storeProduct.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isSubscription)) * 31;
        Uri uri = this.managementURL;
        return ((((((((iHashCode3 + (uri != null ? uri.hashCode() : 0)) * 31) + Boolean.hashCode(this.isExpired)) * 31) + Boolean.hashCode(this.isTrial)) * 31) + Boolean.hashCode(this.isCancelled)) * 31) + Boolean.hashCode(this.isLifetime);
    }

    public String toString() {
        return "PurchaseInformation(title=" + this.title + ", pricePaid=" + this.pricePaid + ", expirationOrRenewal=" + this.expirationOrRenewal + ", product=" + this.product + ", store=" + this.store + ", isSubscription=" + this.isSubscription + ", managementURL=" + this.managementURL + ", isExpired=" + this.isExpired + ", isTrial=" + this.isTrial + ", isCancelled=" + this.isCancelled + ", isLifetime=" + this.isLifetime + ')';
    }

    public PurchaseInformation(String str, PriceDetails pricePaid, ExpirationOrRenewal expirationOrRenewal, StoreProduct storeProduct, Store store, boolean z, Uri uri, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(pricePaid, "pricePaid");
        Intrinsics.checkNotNullParameter(store, "store");
        this.title = str;
        this.pricePaid = pricePaid;
        this.expirationOrRenewal = expirationOrRenewal;
        this.product = storeProduct;
        this.store = store;
        this.isSubscription = z;
        this.managementURL = uri;
        this.isExpired = z2;
        this.isTrial = z3;
        this.isCancelled = z4;
        this.isLifetime = z5;
    }

    public final String getTitle() {
        return this.title;
    }

    public final PriceDetails getPricePaid() {
        return this.pricePaid;
    }

    public final ExpirationOrRenewal getExpirationOrRenewal() {
        return this.expirationOrRenewal;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public final Store getStore() {
        return this.store;
    }

    public final boolean isSubscription() {
        return this.isSubscription;
    }

    public final void setSubscription(boolean z) {
        this.isSubscription = z;
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public final boolean isTrial() {
        return this.isTrial;
    }

    public final boolean isCancelled() {
        return this.isCancelled;
    }

    public final boolean isLifetime() {
        return this.isLifetime;
    }

    public /* synthetic */ PurchaseInformation(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : entitlementInfo, (i & 2) != 0 ? null : storeProduct, transactionDetails, (i & 8) != 0 ? new DefaultDateFormatter() : dateFormatter, locale, localization);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PurchaseInformation(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transaction, DateFormatter dateFormatter, Locale locale, CustomerCenterConfigData.Localization localization) {
        boolean z;
        Store store;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localization, "localization");
        String strDetermineTitle = PurchaseInformationKt.determineTitle(entitlementInfo, storeProduct, transaction, localization);
        ExpirationOrRenewal expirationOrRenewalDetermineExpirationOrRenewal = PurchaseInformationKt.determineExpirationOrRenewal(entitlementInfo, transaction, dateFormatter, locale);
        Store store2 = (entitlementInfo == null || (store = entitlementInfo.getStore()) == null) ? transaction.getStore() : store;
        PriceDetails priceDetailsDeterminePrice = PurchaseInformationKt.determinePrice(storeProduct, transaction);
        boolean z2 = transaction instanceof TransactionDetails.Subscription;
        boolean z3 = false;
        boolean z4 = z2 && transaction.getStore() != Store.PROMOTIONAL;
        TransactionDetails.Subscription subscription = z2 ? (TransactionDetails.Subscription) transaction : null;
        Uri managementURL = subscription != null ? subscription.getManagementURL() : null;
        if (entitlementInfo != null) {
            z3 = !entitlementInfo.getIsActive();
        } else if (z2) {
            z = ((TransactionDetails.Subscription) transaction).isActive() ? z : true;
            this(strDetermineTitle, priceDetailsDeterminePrice, expirationOrRenewalDetermineExpirationOrRenewal, storeProduct, store2, z4, managementURL, z, PurchaseInformationKt.determineTrialStatus(entitlementInfo, transaction), PurchaseInformationKt.determineCancellationStatus(entitlementInfo, transaction), PurchaseInformationKt.determineLifetimeStatus(entitlementInfo, transaction));
        } else if (!(transaction instanceof TransactionDetails.NonSubscription)) {
            throw new NoWhenBranchMatchedException();
        }
        z = z3;
        this(strDetermineTitle, priceDetailsDeterminePrice, expirationOrRenewalDetermineExpirationOrRenewal, storeProduct, store2, z4, managementURL, z, PurchaseInformationKt.determineTrialStatus(entitlementInfo, transaction), PurchaseInformationKt.determineCancellationStatus(entitlementInfo, transaction), PurchaseInformationKt.determineLifetimeStatus(entitlementInfo, transaction));
    }

    public final String renewalString(String renewalDate, CustomerCenterConfigData.Localization localization) {
        Intrinsics.checkNotNullParameter(renewalDate, "renewalDate");
        Intrinsics.checkNotNullParameter(localization, "localization");
        PriceDetails priceDetails = this.pricePaid;
        if (Intrinsics.areEqual(priceDetails, PriceDetails.Free.INSTANCE) ? true : Intrinsics.areEqual(priceDetails, PriceDetails.Unknown.INSTANCE)) {
            return StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.RENEWS_ON_DATE), "{{ date }}", renewalDate, false, 4, (Object) null);
        }
        if (!(priceDetails instanceof PriceDetails.Paid)) {
            throw new NoWhenBranchMatchedException();
        }
        return StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.LAST_CHARGE_WAS), "{{ price }}", ((PriceDetails.Paid) this.pricePaid).getPrice(), false, 4, (Object) null) + '\n' + StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NEXT_BILLING_DATE_ON), "{{ date }}", renewalDate, false, 4, (Object) null);
    }

    public final String expirationString(String expirationDate, CustomerCenterConfigData.Localization localization) {
        Intrinsics.checkNotNullParameter(expirationDate, "expirationDate");
        Intrinsics.checkNotNullParameter(localization, "localization");
        if (this.isExpired) {
            return StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASE_INFO_EXPIRED_ON_DATE), "{{ date }}", expirationDate, false, 4, (Object) null);
        }
        return StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASE_INFO_EXPIRES_ON_DATE), "{{ date }}", expirationDate, false, 4, (Object) null);
    }
}
