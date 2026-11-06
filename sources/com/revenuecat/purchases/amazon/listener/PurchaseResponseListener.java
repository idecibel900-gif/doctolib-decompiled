package com.revenuecat.purchases.amazon.listener;

import android.app.Activity;
import android.os.Handler;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0016JV\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00030\u0018H&¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "Lcom/amazon/device/iap/PurchasingListener;", "onProductDataResponse", "", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "purchase", "mainHandler", "Landroid/os/Handler;", "activity", "Landroid/app/Activity;", "appUserID", "", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "onSuccess", "Lkotlin/Function2;", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PurchaseResponseListener extends PurchasingListener {
    default void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onUserDataResponse(UserDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, Function2 onSuccess, Function1 onError);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onUserDataResponse(PurchaseResponseListener purchaseResponseListener, UserDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onUserDataResponse(response);
        }

        @Deprecated
        public static void onProductDataResponse(PurchaseResponseListener purchaseResponseListener, ProductDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onPurchaseUpdatesResponse(response);
        }
    }
}
