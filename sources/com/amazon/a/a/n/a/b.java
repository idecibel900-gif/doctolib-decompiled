package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CommandResultVerifier");

    @com.amazon.a.a.k.a
    private Application b;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b c;

    public void a(String str, String str2) throws com.amazon.a.a.d.b {
        if (com.amazon.a.a.o.c.a) {
            a.a("Verifying auth token: " + str);
        }
        for (Signature signature : a(str2).signatures) {
            if (a(str, signature)) {
                return;
            }
        }
        throw new com.amazon.a.a.n.a.a.a();
    }

    public boolean a(String str, List<String> list) {
        a.a("checkSignatures(" + str + ", " + list);
        try {
            for (Signature signature : a(str).signatures) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (b(it.next(), signature)) {
                        return true;
                    }
                }
            }
        } catch (com.amazon.a.a.n.a.a.c e) {
            a.b("isPackageSignatureValid: caught exception while checking", e);
        }
        return false;
    }

    private boolean a(String str, Signature signature) throws com.amazon.a.a.o.b.a.a {
        try {
            return com.amazon.a.a.o.b.e.a(a(signature), str, this.c.a());
        } catch (CertificateException unused) {
            if (!com.amazon.a.a.o.c.b) {
                return false;
            }
            a.b("Failed to extract fingerprint from signature: " + signature);
            return false;
        }
    }

    private boolean b(String str, Signature signature) {
        boolean zEquals = false;
        try {
            zEquals = str.equals(a(signature));
            a.a("Signature valid: " + zEquals);
            return zEquals;
        } catch (CertificateException unused) {
            a.b("Failed to extract fingerprint from signature");
            return zEquals;
        }
    }

    private PackageInfo a(String str) throws com.amazon.a.a.n.a.a.c {
        try {
            return this.b.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            a.a("getPackageInfo() caught exception" + e);
            throw new com.amazon.a.a.n.a.a.c();
        }
    }

    private String a(Signature signature) throws CertificateException {
        return com.amazon.c.a.a.c.a(b(signature).getSignature());
    }

    private X509Certificate b(Signature signature) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
    }
}
