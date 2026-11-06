package io.sentry;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface IConnectionStatusProvider extends Closeable {

    public enum ConnectionStatus {
        UNKNOWN,
        CONNECTED,
        DISCONNECTED,
        NO_PERMISSION
    }

    public interface IConnectionStatusObserver {
        void onConnectionStatusChanged(ConnectionStatus connectionStatus);
    }

    boolean addConnectionStatusObserver(IConnectionStatusObserver iConnectionStatusObserver);

    ConnectionStatus getConnectionStatus();

    String getConnectionType();

    void removeConnectionStatusObserver(IConnectionStatusObserver iConnectionStatusObserver);
}
