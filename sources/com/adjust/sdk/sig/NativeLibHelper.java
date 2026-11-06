package com.adjust.sdk.sig;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLibHelper {
    static {
        try {
            System.loadLibrary("signer");
        } catch (UnsatisfiedLinkError e) {
            e.getMessage();
        }
    }

    private final native void nOnResume();

    private final native byte[] nSign(Context context, Object obj, byte[] bArr, int i);

    public final byte[] a(Context context, LinkedHashMap linkedHashMap, byte[] bArr, int i) {
        return nSign(context, linkedHashMap, bArr, i);
    }

    public final void a() {
        nOnResume();
    }
}
