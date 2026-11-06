package com.revenuecat.purchases.react.ui.customercenter.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/react/ui/customercenter/events/CustomerCenterEventName;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "ON_DISMISS", "ON_CUSTOM_ACTION_SELECTED", "ON_RESTORE_STARTED", "ON_RESTORE_COMPLETED", "ON_RESTORE_FAILED", "ON_SHOWING_MANAGE_SUBSCRIPTIONS", "ON_FEEDBACK_SURVEY_COMPLETED", "ON_MANAGEMENT_OPTION_SELECTED", "ON_REFUND_REQUEST_STARTED", "ON_REFUND_REQUEST_COMPLETED", "ON_PROMOTIONAL_OFFER_SUCCEEDED", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum CustomerCenterEventName {
    ON_DISMISS("onDismiss"),
    ON_CUSTOM_ACTION_SELECTED("onCustomActionSelected"),
    ON_RESTORE_STARTED("onRestoreStarted"),
    ON_RESTORE_COMPLETED("onRestoreCompleted"),
    ON_RESTORE_FAILED("onRestoreFailed"),
    ON_SHOWING_MANAGE_SUBSCRIPTIONS("onShowingManageSubscriptions"),
    ON_FEEDBACK_SURVEY_COMPLETED("onFeedbackSurveyCompleted"),
    ON_MANAGEMENT_OPTION_SELECTED("onManagementOptionSelected"),
    ON_REFUND_REQUEST_STARTED("onRefundRequestStarted"),
    ON_REFUND_REQUEST_COMPLETED("onRefundRequestCompleted"),
    ON_PROMOTIONAL_OFFER_SUCCEEDED("onPromotionalOfferSucceeded");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String eventName;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    CustomerCenterEventName(String str) {
        this.eventName = str;
    }

    public final String getEventName() {
        return this.eventName;
    }
}
