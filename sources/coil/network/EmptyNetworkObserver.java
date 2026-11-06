package coil.network;

/* JADX INFO: loaded from: classes3.dex */
public final class EmptyNetworkObserver implements NetworkObserver {
    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        return true;
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
    }
}
