package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(String str, int i) {
        return SoLoader.loadLibrary(str, (i & 1) != 0 ? 16 : 0);
    }
}
