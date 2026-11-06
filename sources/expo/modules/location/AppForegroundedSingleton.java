package expo.modules.location;

/* JADX INFO: loaded from: classes4.dex */
public final class AppForegroundedSingleton {
    public static final AppForegroundedSingleton INSTANCE = new AppForegroundedSingleton();
    private static boolean isForegrounded;

    private AppForegroundedSingleton() {
    }

    public final boolean isForegrounded() {
        return isForegrounded;
    }

    public final void setForegrounded(boolean z) {
        isForegrounded = z;
    }
}
