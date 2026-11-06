package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzan extends zzas implements zzap {
    zzan(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zza(int i, String str, String str2) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(3);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        Parcel parcelZzu = zzu(5, parcelZzt);
        int i2 = parcelZzu.readInt();
        parcelZzu.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zzb(int i, String str, String str2) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(i);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        Parcel parcelZzu = zzu(1, parcelZzt);
        int i2 = parcelZzu.readInt();
        parcelZzu.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final int zzc(int i, String str, String str2, Bundle bundle) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(i);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        zzau.zzb(parcelZzt, bundle);
        Parcel parcelZzu = zzu(10, parcelZzt);
        int i2 = parcelZzu.readInt();
        parcelZzu.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(9);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        zzau.zzb(parcelZzt, bundle);
        Parcel parcelZzu = zzu(902, parcelZzt);
        Bundle bundle2 = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zze(int i, String str, String str2, Bundle bundle) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(9);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        zzau.zzb(parcelZzt, bundle);
        Parcel parcelZzu = zzu(12, parcelZzt);
        Bundle bundle2 = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(3);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        parcelZzt.writeString(str3);
        parcelZzt.writeString(null);
        Parcel parcelZzu = zzu(3, parcelZzt);
        Bundle bundle = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(i);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        parcelZzt.writeString(str3);
        parcelZzt.writeString(null);
        zzau.zzb(parcelZzt, bundle);
        Parcel parcelZzu = zzu(8, parcelZzt);
        Bundle bundle2 = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzh(int i, String str, String str2, String str3) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(3);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        parcelZzt.writeString(str3);
        Parcel parcelZzu = zzu(4, parcelZzt);
        Bundle bundle = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzi(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(i);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        parcelZzt.writeString(str3);
        zzau.zzb(parcelZzt, bundle);
        Parcel parcelZzu = zzu(11, parcelZzt);
        Bundle bundle2 = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final Bundle zzj(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(i);
        parcelZzt.writeString(str);
        parcelZzt.writeString(str2);
        zzau.zzb(parcelZzt, bundle);
        zzau.zzb(parcelZzt, bundle2);
        Parcel parcelZzu = zzu(901, parcelZzt);
        Bundle bundle3 = (Bundle) zzau.zza(parcelZzu, Bundle.CREATOR);
        parcelZzu.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzo(int i, String str, Bundle bundle, zzag zzagVar) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(18);
        parcelZzt.writeString(str);
        zzau.zzb(parcelZzt, bundle);
        zzau.zzc(parcelZzt, zzagVar);
        zzv(1301, parcelZzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zzs(int i, String str, Bundle bundle, zzar zzarVar) {
        Parcel parcelZzt = zzt();
        parcelZzt.writeInt(12);
        parcelZzt.writeString(str);
        zzau.zzb(parcelZzt, bundle);
        zzau.zzc(parcelZzt, zzarVar);
        zzv(1201, parcelZzt);
    }
}
