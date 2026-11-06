package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzr zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            LocationResult locationResult = (LocationResult) zzc.zza(parcel, LocationResult.CREATOR);
            zzc.zzb(parcel);
            zze(locationResult);
        } else if (i == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR);
            zzc.zzb(parcel);
            zzd(locationAvailability);
        } else {
            if (i != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
