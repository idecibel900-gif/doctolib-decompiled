package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaq extends zzat implements zzar {
    public zzaq() {
        super("com.android.vending.billing.IInAppBillingServiceCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzat
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzau.zza(parcel, Bundle.CREATOR);
        enforceNoDataAvail(parcel);
        zza(bundle);
        parcel2.writeNoException();
        return true;
    }
}
