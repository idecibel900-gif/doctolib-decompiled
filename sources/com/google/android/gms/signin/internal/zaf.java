package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zag(zai zaiVar, zae zaeVar) {
        Parcel parcelZaa = zaa();
        com.google.android.gms.internal.base.zac.zac(parcelZaa, zaiVar);
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zaeVar);
        zac(12, parcelZaa);
    }
}
