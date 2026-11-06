package com.amazon.a.a.o.b;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static final String a = ",";
    public static final String b = "=";
    public static final String c = "|";
    private static final com.amazon.a.a.o.c d = new com.amazon.a.a.o.c("SignedToken");
    private final Map<String, String> e = new HashMap();

    public f(String str, PublicKey publicKey) throws com.amazon.a.a.o.b.a.c, com.amazon.a.a.o.b.a.b {
        String strB = b(str);
        int iLastIndexOf = strB.lastIndexOf(c);
        if (iLastIndexOf == -1) {
            throw com.amazon.a.a.o.b.a.b.d();
        }
        String strSubstring = strB.substring(0, iLastIndexOf);
        String strSubstring2 = strB.substring(iLastIndexOf + 1);
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = d;
            cVar.a("Token data: " + strSubstring);
            cVar.a("Signature: " + strSubstring2);
        }
        a(strSubstring, strSubstring2, publicKey);
        c(strSubstring);
    }

    private String b(String str) throws com.amazon.a.a.o.b.a.b {
        try {
            return new String(com.amazon.c.a.a.c.c(str.getBytes()));
        } catch (IOException e) {
            throw com.amazon.a.a.o.b.a.b.a((Throwable) e);
        }
    }

    private void a(String str, String str2, PublicKey publicKey) throws com.amazon.a.a.o.b.a.c {
        if (!e.a(str, str2, publicKey)) {
            throw new com.amazon.a.a.o.b.a.c();
        }
    }

    private void c(String str) throws com.amazon.a.a.o.b.a.b {
        StringTokenizer stringTokenizer = new StringTokenizer(str, a);
        while (stringTokenizer.hasMoreElements()) {
            String strNextToken = stringTokenizer.nextToken();
            com.amazon.a.a.o.c cVar = d;
            cVar.a("Field: " + strNextToken);
            int iIndexOf = strNextToken.indexOf(b);
            if (iIndexOf == -1) {
                throw com.amazon.a.a.o.b.a.b.d();
            }
            String strSubstring = strNextToken.substring(0, iIndexOf);
            String strSubstring2 = strNextToken.substring(iIndexOf + 1);
            cVar.a("FieldName: " + strSubstring);
            cVar.a("FieldValue: " + strSubstring2);
            this.e.put(strSubstring, strSubstring2);
        }
    }

    public String a(String str) {
        com.amazon.a.a.o.a.a.a((Object) str, SubscriberAttributeKt.JSON_NAME_KEY);
        return this.e.get(str);
    }

    public String toString() {
        return "Signed Token: " + this.e;
    }
}
