package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "", "handleResult", "", "result", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "Result", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RedeemWebPurchaseListener {
    void handleResult(Result result);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "", "()V", "isSuccess", "", "()Z", "Error", "Expired", "InvalidToken", "PurchaseBelongsToOtherUser", "Success", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Error;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Expired;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$InvalidToken;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$PurchaseBelongsToOtherUser;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Success;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Success;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Success extends Result {
            private final CustomerInfo customerInfo;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual(this.customerInfo, ((Success) obj).customerInfo);
            }

            public int hashCode() {
                return this.customerInfo.hashCode();
            }

            public String toString() {
                return "Success(customerInfo=" + this.customerInfo + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(CustomerInfo customerInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                this.customerInfo = customerInfo;
            }

            public final CustomerInfo getCustomerInfo() {
                return this.customerInfo;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Error;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error extends Result {
            private final PurchasesError error;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(PurchasesError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final PurchasesError getError() {
                return this.error;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$InvalidToken;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class InvalidToken extends Result {
            public static final InvalidToken INSTANCE = new InvalidToken();

            private InvalidToken() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$Expired;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "obfuscatedEmail", "", "(Ljava/lang/String;)V", "getObfuscatedEmail", "()Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Expired extends Result {
            private final String obfuscatedEmail;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Expired) && Intrinsics.areEqual(this.obfuscatedEmail, ((Expired) obj).obfuscatedEmail);
            }

            public int hashCode() {
                return this.obfuscatedEmail.hashCode();
            }

            public String toString() {
                return "Expired(obfuscatedEmail=" + this.obfuscatedEmail + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Expired(String obfuscatedEmail) {
                super(null);
                Intrinsics.checkNotNullParameter(obfuscatedEmail, "obfuscatedEmail");
                this.obfuscatedEmail = obfuscatedEmail;
            }

            public final String getObfuscatedEmail() {
                return this.obfuscatedEmail;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result$PurchaseBelongsToOtherUser;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PurchaseBelongsToOtherUser extends Result {
            public static final PurchaseBelongsToOtherUser INSTANCE = new PurchaseBelongsToOtherUser();

            private PurchaseBelongsToOtherUser() {
                super(null);
            }
        }

        public final boolean isSuccess() {
            if (this instanceof Success) {
                return true;
            }
            if ((this instanceof Error) || Intrinsics.areEqual(this, InvalidToken.INSTANCE) || (this instanceof Expired) || Intrinsics.areEqual(this, PurchaseBelongsToOtherUser.INSTANCE)) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
