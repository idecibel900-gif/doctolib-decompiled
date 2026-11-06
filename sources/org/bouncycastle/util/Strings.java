package org.bouncycastle.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.bouncycastle.util.encoders.UTF8;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Strings {
    private static String LINE_SEPARATOR;

    static {
        try {
            try {
                LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.util.Strings.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty("line.separator");
                    }
                });
            } catch (Exception unused) {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            LINE_SEPARATOR = "\n";
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int iTranscodeToUTF16 = UTF8.transcodeToUTF16(bArr, cArr);
        if (iTranscodeToUTF16 >= 0) {
            return new String(cArr, 0, iTranscodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) (c + ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) (c - ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
