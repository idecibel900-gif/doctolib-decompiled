package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "", "onPurchaseCancelled", "", "onPurchaseCompleted", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "onPurchaseError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchasePackageInitiated", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resume", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/Resumable;", "onPurchaseStarted", "onRestoreCompleted", "onRestoreError", "onRestoreInitiated", "onRestoreStarted", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallListener {
    void onPurchaseCancelled();

    void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction);

    void onPurchaseError(PurchasesError error);

    void onPurchasePackageInitiated(Package rcPackage, Resumable resume);

    void onPurchaseStarted(Package rcPackage);

    void onRestoreCompleted(CustomerInfo customerInfo);

    void onRestoreError(PurchasesError error);

    void onRestoreInitiated(Resumable resume);

    void onRestoreStarted();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onPurchaseCancelled(PaywallListener paywallListener) {
        }

        public static void onPurchaseCompleted(PaywallListener paywallListener, CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        }

        public static void onPurchaseError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onPurchaseStarted(PaywallListener paywallListener, Package rcPackage) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        }

        public static void onRestoreCompleted(PaywallListener paywallListener, CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        }

        public static void onRestoreError(PaywallListener paywallListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onRestoreStarted(PaywallListener paywallListener) {
        }

        public static void onPurchasePackageInitiated(PaywallListener paywallListener, Package rcPackage, Resumable resume) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(resume, "resume");
            Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
        }

        public static void onRestoreInitiated(PaywallListener paywallListener, Resumable resume) {
            Intrinsics.checkNotNullParameter(resume, "resume");
            Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
        }
    }
}
