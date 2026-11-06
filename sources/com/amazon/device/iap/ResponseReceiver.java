package com.amazon.device.iap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.internal.util.b;

/* JADX INFO: loaded from: classes3.dex */
public final class ResponseReceiver extends BroadcastReceiver {
    private static final String TAG = "ResponseReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            d.f().a(context, intent);
        } catch (Exception e) {
            b.b(TAG, "Error in onReceive: " + e);
        }
    }
}
