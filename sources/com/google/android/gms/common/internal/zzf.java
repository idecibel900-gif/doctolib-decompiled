package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes3.dex */
public final class zzf extends zza {
    public final IBinder zze;
    final /* synthetic */ BaseGmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.zzf = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean zza() {
        try {
            IBinder iBinder = this.zze;
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.zzf;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                new StringBuilder(String.valueOf(baseGmsClient.getServiceDescriptor()).length() + 34 + String.valueOf(interfaceDescriptor).length());
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = baseGmsClient.createServiceInterface(this.zze);
            if (iInterfaceCreateServiceInterface == null) {
                return false;
            }
            if (!baseGmsClient.zze(2, 4, iInterfaceCreateServiceInterface) && !baseGmsClient.zze(3, 4, iInterfaceCreateServiceInterface)) {
                return false;
            }
            baseGmsClient.zzn(null);
            BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacksZzk = baseGmsClient.zzk();
            Bundle connectionHint = baseGmsClient.getConnectionHint();
            if (baseConnectionCallbacksZzk != null) {
                baseGmsClient.zzk().onConnected(connectionHint);
            }
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.zzf;
        if (baseGmsClient.zzl() != null) {
            baseGmsClient.zzl().onConnectionFailed(connectionResult);
        }
        baseGmsClient.onConnectionFailed(connectionResult);
    }
}
