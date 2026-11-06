package io.sentry.ndk;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryNdk {
    private static volatile boolean nativeLibrariesLoaded;

    private static native int initSentryNative(NdkOptions ndkOptions);

    private static native void preloadSentryNative();

    private static native void shutdown();

    private SentryNdk() {
    }

    public static void preload() {
        loadNativeLibraries();
        preloadSentryNative();
    }

    public static void init(NdkOptions ndkOptions) {
        loadNativeLibraries();
        int iInitSentryNative = initSentryNative(ndkOptions);
        if (iInitSentryNative > 0) {
            throw new IllegalStateException("A sentry-native internal init error occurred, please check the logs for more details.");
        }
        if (iInitSentryNative < 0) {
            throw new IllegalStateException("A sentry-native setup failure occurred");
        }
    }

    public static void close() {
        loadNativeLibraries();
        shutdown();
    }

    public static synchronized void loadNativeLibraries() {
        if (!nativeLibrariesLoaded) {
            System.loadLibrary("log");
            System.loadLibrary("sentry");
            System.loadLibrary("sentry-android");
            nativeLibrariesLoaded = true;
        }
    }
}
