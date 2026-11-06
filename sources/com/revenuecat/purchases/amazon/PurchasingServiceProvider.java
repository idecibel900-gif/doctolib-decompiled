package com.revenuecat.purchases.amazon;

import android.content.Context;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "Landroid/os/Parcelable;", "getProductData", "Lcom/amazon/device/iap/model/RequestId;", b.O, "", "", "getPurchaseUpdates", com.amazon.device.iap.internal.c.b.au, "", "getUserData", "notifyFulfillment", "", b.E, "fulfillmentResult", "Lcom/amazon/device/iap/model/FulfillmentResult;", "purchase", "sku", "registerListener", "context", "Landroid/content/Context;", "listener", "Lcom/amazon/device/iap/PurchasingListener;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PurchasingServiceProvider extends Parcelable {
    RequestId getProductData(Set<String> skus);

    RequestId getPurchaseUpdates(boolean reset);

    RequestId getUserData();

    void notifyFulfillment(String receiptId, FulfillmentResult fulfillmentResult);

    RequestId purchase(String sku);

    void registerListener(Context context, PurchasingListener listener);
}
