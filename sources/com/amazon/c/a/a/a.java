package com.amazon.c.a.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String a = "com.amazon.content.id.";

    public static String a(JarFile jarFile) {
        String strA;
        if (jarFile == null) {
            throw new IllegalArgumentException("apkSrc must not be null!");
        }
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            if (!jarEntryNextElement.isDirectory() && (strA = a(jarEntryNextElement.getName())) != null && strA.length() != 0) {
                return strA;
            }
        }
        return null;
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("name cannot be null or empty!");
        }
        int iIndexOf = str.indexOf(a);
        if (iIndexOf >= 0 && str.length() > 22) {
            return str.substring(iIndexOf + 22);
        }
        return null;
    }

    public static boolean b(JarFile jarFile) throws IOException {
        if (jarFile == null) {
            throw new IllegalArgumentException("apkSrc must not be null!");
        }
        try {
            e(jarFile);
            return d(jarFile) != null;
        } catch (SecurityException unused) {
            return true;
        }
    }

    public static boolean a(File file) throws Throwable {
        JarFile jarFile = null;
        try {
            JarFile jarFile2 = new JarFile(file);
            try {
                boolean zB = b(jarFile2);
                jarFile2.close();
                return zB;
            } catch (Throwable th) {
                th = th;
                jarFile = jarFile2;
                jarFile.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] b(String str) throws b, IOException {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("apkFileName cannot be null or empty!");
        }
        JarFile jarFile = new JarFile(str);
        try {
            e(jarFile);
            Certificate certificateC = c(jarFile);
            if (certificateC != null && (certificateC instanceof X509Certificate)) {
                return ((X509Certificate) certificateC).getSignature();
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static Certificate c(JarFile jarFile) {
        CodeSigner[] codeSignerArrD = d(jarFile);
        if (codeSignerArrD == null || codeSignerArrD.length <= 0) {
            return null;
        }
        List<? extends Certificate> certificates = codeSignerArrD[0].getSignerCertPath().getCertificates();
        if (certificates.isEmpty()) {
            return null;
        }
        return certificates.get(0);
    }

    private static CodeSigner[] d(JarFile jarFile) {
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        CodeSigner[] codeSigners = null;
        while (enumerationEntries.hasMoreElements() && (codeSigners = enumerationEntries.nextElement().getCodeSigners()) == null) {
        }
        return codeSigners;
    }

    private static void e(JarFile jarFile) throws IOException {
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        byte[] bArr = new byte[8192];
        while (enumerationEntries.hasMoreElements()) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = jarFile.getInputStream(enumerationEntries.nextElement());
                    do {
                    } while (inputStream.read(bArr, 0, 8192) != -1);
                    inputStream.close();
                } catch (Exception e) {
                    throw new b(e);
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }
    }
}
