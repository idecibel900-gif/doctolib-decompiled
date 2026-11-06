package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000fH\u0016¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/amazon/listener/UserDataResponseListener;", "Lcom/amazon/device/iap/PurchasingListener;", "getUserData", "", "onSuccess", "Lkotlin/Function1;", "Lcom/amazon/device/iap/model/UserData;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "onProductDataResponse", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseResponse", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface UserDataResponseListener extends PurchasingListener {
    void getUserData(Function1 onSuccess, Function1 onError);

    default void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onPurchaseResponse(PurchaseResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onProductDataResponse(UserDataResponseListener userDataResponseListener, ProductDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            UserDataResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseResponse(UserDataResponseListener userDataResponseListener, PurchaseResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            UserDataResponseListener.super.onPurchaseResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(UserDataResponseListener userDataResponseListener, PurchaseUpdatesResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            UserDataResponseListener.super.onPurchaseUpdatesResponse(response);
        }
    }
}
