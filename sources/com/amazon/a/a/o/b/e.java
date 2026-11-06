package com.amazon.a.a.o.b;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final String a = "SHA384withRSA";
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("SignatureVerifier");

    public static boolean a(String str, String str2, PublicKey publicKey) {
        if (com.amazon.a.a.o.c.a) {
            b.a("Verifying signature of data: '" + str + "', signature: '" + str2 + "', with key: '" + publicKey.toString());
        }
        try {
            byte[] bArrC = com.amazon.c.a.a.c.c(str2.getBytes());
            Signature signature = Signature.getInstance(a);
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            return signature.verify(bArrC);
        } catch (IOException | GeneralSecurityException unused) {
            return false;
        }
    }
}
