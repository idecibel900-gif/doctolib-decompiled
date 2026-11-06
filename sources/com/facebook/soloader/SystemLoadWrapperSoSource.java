package com.facebook.soloader;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes3.dex */
public class SystemLoadWrapperSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        try {
            System.loadLibrary(str.substring(3, str.length() - 3));
            return 1;
        } catch (Exception e) {
            LogUtil.e("SoLoader", "Error loading library: " + str, e);
            return 0;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "SystemLoadWrapperSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getName() + "[" + SysUtil.getClassLoaderLdLoadLibrary() + "]";
    }
}
