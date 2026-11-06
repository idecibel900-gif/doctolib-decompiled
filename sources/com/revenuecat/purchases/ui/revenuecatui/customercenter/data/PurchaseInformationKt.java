package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001a\u0010\f\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0012*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0018H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0012*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u001b"}, d2 = {"determineCancellationStatus", "", "entitlementInfo", "Lcom/revenuecat/purchases/EntitlementInfo;", "transaction", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails;", "determineExpirationOrRenewal", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "dateFormatter", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/DateFormatter;", "locale", "Ljava/util/Locale;", "determineLifetimeStatus", "determinePrice", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "subscribedProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "determineTitle", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "determineTrialStatus", "expirationDate", "isExpiringOrExpired", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/TransactionDetails$Subscription;", "isPromotionalLifetime", "renewalDate", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseInformationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PriceDetails determinePrice(StoreProduct storeProduct, TransactionDetails transactionDetails) {
        Price price;
        if (transactionDetails.getStore() == Store.PROMOTIONAL || ((price = transactionDetails.getPrice()) != null && price.getAmountMicros() == 0)) {
            return PriceDetails.Free.INSTANCE;
        }
        Price price2 = transactionDetails.getPrice();
        if (price2 != null && price2.getAmountMicros() > 0) {
            Price price3 = transactionDetails.getPrice();
            return price3 != null ? new PriceDetails.Paid(price3.getFormatted()) : PriceDetails.Unknown.INSTANCE;
        }
        if (storeProduct == null) {
            return PriceDetails.Unknown.INSTANCE;
        }
        if (storeProduct.getPrice().getAmountMicros() == 0) {
            return PriceDetails.Free.INSTANCE;
        }
        return new PriceDetails.Paid(storeProduct.getPrice().getFormatted());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String determineTitle(EntitlementInfo entitlementInfo, StoreProduct storeProduct, TransactionDetails transactionDetails, CustomerCenterConfigData.Localization localization) {
        String title;
        if (transactionDetails.getStore() == Store.PROMOTIONAL && entitlementInfo != null) {
            return entitlementInfo.getIdentifier();
        }
        if (storeProduct != null && (title = storeProduct.getTitle()) != null) {
            return title;
        }
        if (transactionDetails instanceof TransactionDetails.Subscription) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.TYPE_SUBSCRIPTION);
        }
        if (transactionDetails instanceof TransactionDetails.NonSubscription) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.TYPE_ONE_TIME_PURCHASE);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String expirationDate(EntitlementInfo entitlementInfo, DateFormatter dateFormatter, Locale locale) {
        Date expirationDate;
        if (isPromotionalLifetime(entitlementInfo)) {
            return null;
        }
        if ((entitlementInfo.getWillRenew() && entitlementInfo.getIsActive()) || (expirationDate = entitlementInfo.getExpirationDate()) == null) {
            return null;
        }
        return dateFormatter.format(expirationDate, locale);
    }

    private static final String expirationDate(TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        if (!(transactionDetails instanceof TransactionDetails.Subscription) || ((TransactionDetails.Subscription) transactionDetails).getExpiresDate() == null) {
            return null;
        }
        Intrinsics.checkNotNull(transactionDetails, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails.Subscription");
        if (!isExpiringOrExpired((TransactionDetails.Subscription) transactionDetails)) {
            return null;
        }
        Intrinsics.checkNotNull(transactionDetails, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails.Subscription");
        Date expiresDate = ((TransactionDetails.Subscription) transactionDetails).getExpiresDate();
        Intrinsics.checkNotNull(expiresDate);
        return dateFormatter.format(expiresDate, locale);
    }

    private static final boolean isExpiringOrExpired(TransactionDetails.Subscription subscription) {
        return (subscription.getWillRenew() && subscription.isActive()) ? false : true;
    }

    private static final String renewalDate(EntitlementInfo entitlementInfo, DateFormatter dateFormatter, Locale locale) {
        Date expirationDate;
        if (!entitlementInfo.getWillRenew() || isPromotionalLifetime(entitlementInfo) || (expirationDate = entitlementInfo.getExpirationDate()) == null) {
            return null;
        }
        return dateFormatter.format(expirationDate, locale);
    }

    private static final String renewalDate(TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        if (!(transactionDetails instanceof TransactionDetails.Subscription)) {
            return null;
        }
        TransactionDetails.Subscription subscription = (TransactionDetails.Subscription) transactionDetails;
        if (!subscription.getWillRenew() || subscription.getExpiresDate() == null) {
            return null;
        }
        return dateFormatter.format(subscription.getExpiresDate(), locale);
    }

    private static final boolean isPromotionalLifetime(EntitlementInfo entitlementInfo) {
        return entitlementInfo.getStore() == Store.PROMOTIONAL && StringsKt.endsWith$default(entitlementInfo.getProductIdentifier(), "_lifetime", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineTrialStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        if ((entitlementInfo != null ? entitlementInfo.getPeriodType() : null) != PeriodType.TRIAL) {
            TransactionDetails.Subscription subscription = transactionDetails instanceof TransactionDetails.Subscription ? (TransactionDetails.Subscription) transactionDetails : null;
            if (subscription == null || !subscription.isTrial()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineCancellationStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        boolean z = (entitlementInfo == null || entitlementInfo.getUnsubscribeDetectedAt() == null || entitlementInfo.getWillRenew()) ? false : true;
        TransactionDetails.Subscription subscription = transactionDetails instanceof TransactionDetails.Subscription ? (TransactionDetails.Subscription) transactionDetails : null;
        return z || (subscription != null ? subscription.getWillRenew() ^ true : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean determineLifetimeStatus(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails) {
        return (entitlementInfo != null && isPromotionalLifetime(entitlementInfo)) || (!(transactionDetails instanceof TransactionDetails.Subscription) && transactionDetails.getStore() != Store.PROMOTIONAL && entitlementInfo != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExpirationOrRenewal determineExpirationOrRenewal(EntitlementInfo entitlementInfo, TransactionDetails transactionDetails, DateFormatter dateFormatter, Locale locale) {
        ExpirationOrRenewal expiration;
        String strExpirationDate;
        String strRenewalDate;
        ExpirationOrRenewal expiration2 = null;
        if (entitlementInfo == null || (strRenewalDate = renewalDate(entitlementInfo, dateFormatter, locale)) == null) {
            expiration = (entitlementInfo == null || (strExpirationDate = expirationDate(entitlementInfo, dateFormatter, locale)) == null) ? null : new ExpirationOrRenewal.Expiration(strExpirationDate);
        } else {
            expiration = new ExpirationOrRenewal.Renewal(strRenewalDate);
        }
        String strRenewalDate2 = renewalDate(transactionDetails, dateFormatter, locale);
        if (strRenewalDate2 != null) {
            expiration2 = new ExpirationOrRenewal.Renewal(strRenewalDate2);
        } else {
            String strExpirationDate2 = expirationDate(transactionDetails, dateFormatter, locale);
            if (strExpirationDate2 != null) {
                expiration2 = new ExpirationOrRenewal.Expiration(strExpirationDate2);
            }
        }
        return expiration == null ? expiration2 : expiration;
    }
}
