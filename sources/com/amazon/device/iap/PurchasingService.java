package com.amazon.device.iap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.amazon.a.a;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class PurchasingService extends Service {
    private static final String APPSTORE_SDK_NAME = "Amazon In-App Purchasing Android SDK :2.10.5.0";
    public static final String SDK_VERSION = "2.10.5.0";
    private static final String TAG = "PurchasingService";
    private final IBinder localBinder = new LocalBinder();

    private class LocalBinder extends Binder {
        private LocalBinder() {
        }

        public PurchasingService getService() {
            return PurchasingService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.localBinder;
    }

    public static void registerListener(Context context, PurchasingListener purchasingListener) {
        a.a(context);
        d.f().a(context, purchasingListener);
    }

    public static void enablePendingPurchases() {
        d.f().c();
    }

    public static RequestId getUserData() {
        return d.f().a(UserDataRequest.newBuilder().build());
    }

    public static RequestId getUserData(UserDataRequest userDataRequest) {
        return d.f().a(userDataRequest);
    }

    public static RequestId purchase(String str) {
        return d.f().a(str);
    }

    public static RequestId getProductData(Set<String> set) {
        return d.f().a(set);
    }

    public static RequestId getPurchaseUpdates(boolean z) {
        return d.f().a(z);
    }

    public static void notifyFulfillment(String str, FulfillmentResult fulfillmentResult) {
        d.f().a(str, fulfillmentResult);
    }
}
