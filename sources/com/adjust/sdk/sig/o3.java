package com.adjust.sdk.sig;

import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o3 {
    public static final n1 a;

    static {
        r0 r0Var = new r0() { // from class: com.adjust.sdk.sig.o3$$ExternalSyntheticLambda0
            @Override // com.adjust.sdk.sig.r0
            public final Object a(Object obj) {
                return o3.a((j1) obj);
            }
        };
        j1 j1Var = new j1(i1.b);
        r0Var.a(j1Var);
        a = new n1(new l1(j1Var.a, j1Var.b, j1Var.c));
    }

    public static String a(a0 a0Var) {
        n1 n1Var = a;
        n1Var.getClass();
        z zVar = z.a;
        o1 o1Var = new o1();
        try {
            new v2(new x(o1Var), n1Var, p3.OBJ, new v2[p3.g.a.length]).a(zVar, a0Var);
            String string = o1Var.toString();
            o1Var.a();
            byte[] bArr = s2.a;
            byte[] bArrA = d3.a(string);
            int length = bArrA.length;
            for (int i = 0; i < length; i++) {
                bArrA[i] = (byte) (bArrA[i] ^ bArr[i % 19]);
            }
            return Base64.encodeToString(bArrA, 2);
        } catch (Throwable th) {
            o1Var.a();
            throw th;
        }
    }

    public static final m3 a(j1 j1Var) {
        j1Var.a = true;
        j1Var.b = false;
        return m3.a;
    }
}
