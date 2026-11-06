package com.adjust.sdk.sig;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Signer implements ISigner {
    public static final t2 Companion = new t2();
    public static final String EXCEPTION_MSG_SDK4 = "This version of Adjust Signature is not compatible with Adjust SDK v4. Please upgrade to SDK v5.";
    public static boolean c;
    public final NativeLibHelper a = new NativeLibHelper();
    public final t1 b = new t1();

    @Override // com.adjust.sdk.sig.ISigner
    public synchronized void onResume() {
        try {
            if (c) {
                throw new IllegalStateException("sign: Library received error, it has locked down");
            }
            this.a.a();
        } catch (IllegalStateException e) {
            e.getMessage();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @Override // com.adjust.sdk.sig.ISigner
    public void sign(Context context, Map<String, String> map, String str, String str2) {
        throw new UnsupportedOperationException(EXCEPTION_MSG_SDK4);
    }

    @Override // com.adjust.sdk.sig.ISigner
    public synchronized void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        try {
            try {
                try {
                    try {
                        if (c) {
                            throw new IllegalStateException("sign: Library received error, it has locked down");
                        }
                        if (context != null) {
                            t1 t1Var = this.b;
                            NativeLibHelper nativeLibHelper = this.a;
                            if (map == null) {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                            if (map2 == null) {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                            if (map3 != null) {
                                new u2(context, t1Var, nativeLibHelper, map, map2, k3.a(map3)).a();
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        throw new IllegalArgumentException("Required value was null.");
                    } catch (Exception e) {
                        e.getMessage();
                    }
                } catch (IllegalStateException e2) {
                    e2.getMessage();
                }
            } catch (IllegalArgumentException e3) {
                e3.getMessage();
            }
        } catch (b2 e4) {
            c = true;
            e4.getMessage();
        }
    }
}
