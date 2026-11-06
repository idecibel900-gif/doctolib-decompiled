package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzn extends zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.auth.blockstore.internal.IStoreBytesCallback");
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        int i3 = parcel.readInt();
        enforceNoDataAvail(parcel);
        zza(status, i3);
        return true;
    }
}
