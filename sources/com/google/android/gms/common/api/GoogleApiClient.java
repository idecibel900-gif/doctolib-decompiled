package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GoogleApiClient {
    private static final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static Set getAllClients() {
        Set set = zaa;
        synchronized (set) {
        }
        return set;
    }

    public abstract BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl);

    public abstract Looper getLooper();

    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }
}
