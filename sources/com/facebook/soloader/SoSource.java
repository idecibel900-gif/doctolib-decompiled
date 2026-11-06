package com.facebook.soloader;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SoSource {
    public abstract String getName();

    public abstract int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy);

    protected void prepare(int i) {
    }

    public String toString() {
        return getName();
    }
}
