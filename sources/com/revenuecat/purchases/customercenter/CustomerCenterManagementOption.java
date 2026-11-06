package com.revenuecat.purchases.customercenter;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "", "Cancel", "CustomAction", "CustomUrl", "MissingPurchase", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CustomerCenterManagementOption {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption$Cancel;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cancel implements CustomerCenterManagementOption {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption$CustomUrl;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CustomUrl implements CustomerCenterManagementOption {
        private final Uri uri;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomUrl) && Intrinsics.areEqual(this.uri, ((CustomUrl) obj).uri);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "CustomUrl(uri=" + this.uri + ')';
        }

        public CustomUrl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public final Uri getUri() {
            return this.uri;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption$MissingPurchase;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MissingPurchase implements CustomerCenterManagementOption {
        public static final MissingPurchase INSTANCE = new MissingPurchase();

        private MissingPurchase() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption$CustomAction;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "actionIdentifier", "", "purchaseIdentifier", "(Ljava/lang/String;Ljava/lang/String;)V", "getActionIdentifier", "()Ljava/lang/String;", "getPurchaseIdentifier", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CustomAction implements CustomerCenterManagementOption {
        private final String actionIdentifier;
        private final String purchaseIdentifier;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomAction)) {
                return false;
            }
            CustomAction customAction = (CustomAction) obj;
            return Intrinsics.areEqual(this.actionIdentifier, customAction.actionIdentifier) && Intrinsics.areEqual(this.purchaseIdentifier, customAction.purchaseIdentifier);
        }

        public int hashCode() {
            int iHashCode = this.actionIdentifier.hashCode() * 31;
            String str = this.purchaseIdentifier;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomAction(actionIdentifier=" + this.actionIdentifier + ", purchaseIdentifier=" + this.purchaseIdentifier + ')';
        }

        public CustomAction(String actionIdentifier, String str) {
            Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
            this.actionIdentifier = actionIdentifier;
            this.purchaseIdentifier = str;
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final String getPurchaseIdentifier() {
            return this.purchaseIdentifier;
        }
    }
}
