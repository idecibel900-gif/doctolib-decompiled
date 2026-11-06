package com.amazon.a.a.n.a.a;

import android.os.DeadObjectException;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.amazon.a.a.d.b {
    private static final long a = 1;

    public d(RemoteException remoteException) {
        super(a(remoteException));
    }

    private static String a(RemoteException remoteException) {
        if (remoteException instanceof DeadObjectException) {
            return "COMMAND_SERVICE_DEAD_OBJECT_EXCEPTION";
        }
        return "COMMAND_SERVICE_REMOTE_EXCEPTION";
    }
}
