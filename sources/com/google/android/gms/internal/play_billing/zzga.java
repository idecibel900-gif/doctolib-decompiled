package com.google.android.gms.internal.play_billing;

import com.adjust.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzga {
    static final Charset zza = Charset.forName(Constants.ENCODING);
    public static final byte[] zzb;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i = zzey.$r8$clinit;
        try {
            new zzew(bArr, 0, 0, false, null).zza(0);
        } catch (zzgc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
