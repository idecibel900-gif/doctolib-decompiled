package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "", "onCustomActionSelected", "", "actionIdentifier", "", "purchaseIdentifier", "onFeedbackSurveyCompleted", "feedbackSurveyOptionId", "onManagementOptionSelected", "action", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "onPromotionalOfferSucceeded", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "transaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "onRestoreCompleted", "onRestoreFailed", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onRestoreInitiated", "resume", "Lcom/revenuecat/purchases/customercenter/Resumable;", "onRestoreStarted", "onShowingManageSubscriptions", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CustomerCenterListener {
    default void onCustomActionSelected(String actionIdentifier, String purchaseIdentifier) {
        Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
    }

    default void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
        Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
    }

    default void onManagementOptionSelected(CustomerCenterManagementOption action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    default void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
    }

    default void onRestoreCompleted(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
    }

    default void onRestoreFailed(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    default void onRestoreStarted() {
    }

    default void onShowingManageSubscriptions() {
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onRestoreInitiated(CustomerCenterListener customerCenterListener, Resumable resume) {
            Intrinsics.checkNotNullParameter(resume, "resume");
            CustomerCenterListener.super.onRestoreInitiated(resume);
        }

        @Deprecated
        public static void onRestoreStarted(CustomerCenterListener customerCenterListener) {
            CustomerCenterListener.super.onRestoreStarted();
        }

        @Deprecated
        public static void onRestoreFailed(CustomerCenterListener customerCenterListener, PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            CustomerCenterListener.super.onRestoreFailed(error);
        }

        @Deprecated
        public static void onRestoreCompleted(CustomerCenterListener customerCenterListener, CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            CustomerCenterListener.super.onRestoreCompleted(customerInfo);
        }

        @Deprecated
        public static void onShowingManageSubscriptions(CustomerCenterListener customerCenterListener) {
            CustomerCenterListener.super.onShowingManageSubscriptions();
        }

        @Deprecated
        public static void onFeedbackSurveyCompleted(CustomerCenterListener customerCenterListener, String feedbackSurveyOptionId) {
            Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
            CustomerCenterListener.super.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
        }

        @Deprecated
        public static void onManagementOptionSelected(CustomerCenterListener customerCenterListener, CustomerCenterManagementOption action) {
            Intrinsics.checkNotNullParameter(action, "action");
            CustomerCenterListener.super.onManagementOptionSelected(action);
        }

        @Deprecated
        public static void onCustomActionSelected(CustomerCenterListener customerCenterListener, String actionIdentifier, String str) {
            Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
            CustomerCenterListener.super.onCustomActionSelected(actionIdentifier, str);
        }

        @Deprecated
        public static void onPromotionalOfferSucceeded(CustomerCenterListener customerCenterListener, CustomerInfo customerInfo, StoreTransaction transaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            CustomerCenterListener.super.onPromotionalOfferSucceeded(customerInfo, transaction);
        }
    }

    default void onRestoreInitiated(Resumable resume) {
        Intrinsics.checkNotNullParameter(resume, "resume");
        Resumable.invoke$default(resume, false, 1, null);
    }
}
