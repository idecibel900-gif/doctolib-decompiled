package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbn extends ResultReceiver {
    final /* synthetic */ InAppMessageResponseListener zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(BillingClientImpl billingClientImpl, Handler handler, InAppMessageResponseListener inAppMessageResponseListener) {
        super(handler);
        this.zza = inAppMessageResponseListener;
        Objects.requireNonNull(billingClientImpl);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        this.zza.onInAppMessageResponse(zzc.zzj(bundle, "BillingClient"));
    }
}
