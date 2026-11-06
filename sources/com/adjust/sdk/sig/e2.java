package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e2 {
    public static final CharSequence a(l2 l2Var, int i) {
        return l2Var.a(i) + ": " + l2Var.b(i).b();
    }

    public static final String a(final d2 d2Var) {
        return o.a(new f1(0, 0), "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09(", ")", new r0() { // from class: com.adjust.sdk.sig.e2$$ExternalSyntheticLambda0
            @Override // com.adjust.sdk.sig.r0
            public final Object a(Object obj) {
                return e2.a(d2Var, ((Integer) obj).intValue());
            }
        });
    }
}
