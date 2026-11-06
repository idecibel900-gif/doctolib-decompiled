package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface ICancelToken extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements ICancelToken {
        public static ICancelToken asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return iInterfaceQueryLocalInterface instanceof ICancelToken ? (ICancelToken) iInterfaceQueryLocalInterface : new zzu(iBinder);
        }
    }
}
