package com.amazon.c.a.a;

import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String a = "Kiwi__Version__Obfuscator";

    private d() {
    }

    public static String a(String str) {
        b(str, "text");
        return c.a(a(str.getBytes()));
    }

    public static void a(String str, String str2) throws Throwable {
        b(str, "text");
        b(str2, "file");
        String strA = c.a(a(str.getBytes()));
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
            try {
                bufferedWriter2.write(strA);
                bufferedWriter2.flush();
                try {
                    bufferedWriter2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str) throws IOException {
        b(str, "text");
        return new String(a(c.c(str.getBytes())), Constants.ENCODING);
    }

    public static String c(String str) throws Throwable {
        b(str, "file");
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String line = bufferedReader2.readLine();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return new String(a(c.c(line.getBytes())), Constants.ENCODING);
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("input '" + str2 + "' cannot be null or empty");
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        byte[] bytes = a.getBytes();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ bytes[i]);
            i++;
            if (i >= bytes.length) {
                i = 0;
            }
        }
        return bArr2;
    }

    public static void a(String[] strArr) throws Exception {
        if (strArr == null || strArr.length == 0) {
            System.out.println("Usage: com.amazon.mas.kiwi.util.KiwiVersionEncrypter <textToBeEncrypted> [<encryptToFileName>]");
        } else if (strArr.length > 1) {
            a(strArr[0], strArr[1]);
        } else {
            System.out.println(a(strArr[0]));
        }
    }
}
