package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AccountAccessor extends IAccountAccessor.Stub {
    public static Account getAccountBinderSafe(IAccountAccessor iAccountAccessor) {
        if (iAccountAccessor != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return iAccountAccessor.zzb();
            } catch (RemoteException unused) {
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return null;
    }
}
