package coil.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class RealNetworkObserver implements NetworkObserver {
    private final ConnectivityManager connectivityManager;
    private final NetworkObserver.Listener listener;
    private final RealNetworkObserver$networkCallback$1 networkCallback;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.net.ConnectivityManager$NetworkCallback, coil.network.RealNetworkObserver$networkCallback$1] */
    public RealNetworkObserver(ConnectivityManager connectivityManager, NetworkObserver.Listener listener) {
        this.connectivityManager = connectivityManager;
        this.listener = listener;
        ?? r4 = new ConnectivityManager.NetworkCallback() { // from class: coil.network.RealNetworkObserver$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                this.this$0.onConnectivityChange(network, true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                this.this$0.onConnectivityChange(network, false);
            }
        };
        this.networkCallback = r4;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) r4);
    }

    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        for (Network network : this.connectivityManager.getAllNetworks()) {
            if (isOnline(network)) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
        this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectivityChange(Network network, boolean z) {
        boolean z2 = false;
        for (Network network2 : this.connectivityManager.getAllNetworks()) {
            if (Intrinsics.areEqual(network2, network) ? z : isOnline(network2)) {
                z2 = true;
                break;
            }
        }
        this.listener.onConnectivityChange(z2);
    }

    private final boolean isOnline(Network network) {
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}
