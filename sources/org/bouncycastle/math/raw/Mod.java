package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Mod {
    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }
}
