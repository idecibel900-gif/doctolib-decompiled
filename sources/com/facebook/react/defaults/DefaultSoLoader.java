package com.facebook.react.defaults;

import com.facebook.soloader.SoLoader;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSoLoader {
    public static final DefaultSoLoader INSTANCE = new DefaultSoLoader();

    private DefaultSoLoader() {
    }

    public static final synchronized void maybeLoadSoLibrary() {
        SoLoader.loadLibrary("react_newarchdefaults");
        try {
            SoLoader.loadLibrary("appmodules");
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
