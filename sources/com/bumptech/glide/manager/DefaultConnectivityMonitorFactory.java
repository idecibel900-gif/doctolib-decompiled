package com.bumptech.glide.manager;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
