package org.bouncycastle.math.raw;

import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Interleave {
    public static int expand16to32(int i) {
        int i2 = i & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        int i3 = (i2 | (i2 << 8)) & 16711935;
        int i4 = (i3 | (i3 << 4)) & 252645135;
        int i5 = (i4 | (i4 << 2)) & 858993459;
        return (i5 | (i5 << 1)) & 1431655765;
    }
}
