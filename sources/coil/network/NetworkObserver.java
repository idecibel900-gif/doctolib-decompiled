package coil.network;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkObserver {

    public interface Listener {
        void onConnectivityChange(boolean z);
    }

    boolean isOnline();

    void shutdown();
}
