package com.margelo.nitro;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JNIOnLoad {
    private static boolean isInitialized = false;

    public static synchronized void initializeNativeNitro() {
        if (isInitialized) {
            return;
        }
        System.loadLibrary("NitroModules");
        isInitialized = true;
    }
}
