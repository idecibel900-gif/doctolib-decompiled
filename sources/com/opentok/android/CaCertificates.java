package com.opentok.android;

import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public class CaCertificates {
    public static byte[][] getInstalledCaCertificates() {
        OtLog.LogToken logToken = new OtLog.LogToken("CaCertificates", true);
        ArrayList arrayList = new ArrayList();
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            for (X509Certificate x509Certificate : ((X509TrustManager) trustManagerFactory.getTrustManagers()[0]).getAcceptedIssuers()) {
                arrayList.add(x509Certificate.getEncoded());
            }
            return (byte[][]) arrayList.toArray(new byte[0][]);
        } catch (Exception unused) {
            logToken.e("Failed to request installed certificates", new Object[0]);
            return new byte[0][];
        }
    }
}
