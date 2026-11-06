package com.facebook.soloader.nativeloader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeLoader {
    private static NativeLoaderDelegate sDelegate;

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) {
        NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (NativeLoader.class) {
            nativeLoaderDelegate = sDelegate;
            if (nativeLoaderDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.loadLibrary(str, i);
    }

    public static void init(NativeLoaderDelegate nativeLoaderDelegate) {
        synchronized (NativeLoader.class) {
            try {
                if (sDelegate != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                sDelegate = nativeLoaderDelegate;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (NativeLoader.class) {
            z = sDelegate != null;
        }
        return z;
    }

    public static void initIfUninitialized(NativeLoaderDelegate nativeLoaderDelegate) {
        if (isInitialized()) {
            return;
        }
        init(nativeLoaderDelegate);
    }
}
