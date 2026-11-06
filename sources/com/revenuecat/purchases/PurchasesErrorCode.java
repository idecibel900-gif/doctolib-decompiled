package com.revenuecat.purchases;

import com.amazon.a.a.o.b;
import kotlin.Metadata;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/PurchasesErrorCode;", "", ResponseTypeValues.CODE, "", b.c, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "UnknownError", "PurchaseCancelledError", "StoreProblemError", "PurchaseNotAllowedError", "PurchaseInvalidError", "ProductNotAvailableForPurchaseError", "ProductAlreadyPurchasedError", "ReceiptAlreadyInUseError", "InvalidReceiptError", "MissingReceiptFileError", "NetworkError", "InvalidCredentialsError", "UnexpectedBackendResponseError", "InvalidAppUserIdError", "OperationAlreadyInProgressError", "UnknownBackendError", "InvalidAppleSubscriptionKeyError", "IneligibleError", "InsufficientPermissionsError", "PaymentPendingError", "InvalidSubscriberAttributesError", "LogOutWithAnonymousUserError", "ConfigurationError", "UnsupportedError", "EmptySubscriberAttributesError", "CustomerInfoError", "SignatureVerificationError", "TestStoreSimulatedPurchaseError", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum PurchasesErrorCode {
    UnknownError(0, "Unknown error. Check the underlying error for more details."),
    PurchaseCancelledError(1, "Purchase was cancelled."),
    StoreProblemError(2, "There was a problem with the store."),
    PurchaseNotAllowedError(3, "The device or user is not allowed to make the purchase."),
    PurchaseInvalidError(4, "One or more of the arguments provided are invalid."),
    ProductNotAvailableForPurchaseError(5, "The product is not available for purchase."),
    ProductAlreadyPurchasedError(6, "This product is already active for the user."),
    ReceiptAlreadyInUseError(7, "There is already another active subscriber using the same receipt."),
    InvalidReceiptError(8, "The receipt is not valid."),
    MissingReceiptFileError(9, "The receipt is missing."),
    NetworkError(10, "Error performing request."),
    InvalidCredentialsError(11, "There was a credentials issue. Check the underlying error for more details."),
    UnexpectedBackendResponseError(12, "Received unexpected response from the backend."),
    InvalidAppUserIdError(14, "The app user id is not valid."),
    OperationAlreadyInProgressError(15, "The operation is already in progress."),
    UnknownBackendError(16, "There was an unknown backend error."),
    InvalidAppleSubscriptionKeyError(17, "Apple Subscription Key is invalid or not present. In order to provide subscription offers, you must first generate a subscription key. Please see https://docs.revenuecat.com/docs/ios-subscription-offers for more info."),
    IneligibleError(18, "The User is ineligible for that action."),
    InsufficientPermissionsError(19, "App does not have sufficient permissions to make purchases."),
    PaymentPendingError(20, "The payment is pending."),
    InvalidSubscriberAttributesError(21, "One or more of the attributes sent could not be saved."),
    LogOutWithAnonymousUserError(22, "Called logOut but the current user is anonymous."),
    ConfigurationError(23, "There is an issue with your configuration. Check the underlying error for more details."),
    UnsupportedError(24, "There was a problem with the operation. Looks like we don't support that yet. Check the underlying error for more details."),
    EmptySubscriberAttributesError(25, "A request for subscriber attributes returned none."),
    CustomerInfoError(28, "There was a problem related to the customer info."),
    SignatureVerificationError(36, "Request failed signature verification. Please see https://rev.cat/trusted-entitlements for more info."),
    TestStoreSimulatedPurchaseError(42, "Purchase failure simulated successfully in Test Store.");

    private final int code;
    private final String description;

    PurchasesErrorCode(int i, String str) {
        this.code = i;
        this.description = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }
}
