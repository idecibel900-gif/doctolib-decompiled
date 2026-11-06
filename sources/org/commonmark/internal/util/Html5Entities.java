package org.commonmark.internal.util;

import com.amazon.a.a.o.b.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Html5Entities {
    private static final Map NAMED_CHARACTER_REFERENCES = readEntities();

    public static String entityToString(String str) {
        int i;
        if (str.startsWith("&") && str.endsWith(";")) {
            String strSubstring = str.substring(1, str.length() - 1);
            if (strSubstring.startsWith("#")) {
                String strSubstring2 = strSubstring.substring(1);
                if (strSubstring2.startsWith("x") || strSubstring2.startsWith("X")) {
                    strSubstring2 = strSubstring2.substring(1);
                    i = 16;
                } else {
                    i = 10;
                }
                try {
                    int i2 = Integer.parseInt(strSubstring2, i);
                    if (i2 == 0) {
                        return "�";
                    }
                    return new String(Character.toChars(i2));
                } catch (IllegalArgumentException unused) {
                    return "�";
                }
            }
            String str2 = (String) NAMED_CHARACTER_REFERENCES.get(strSubstring);
            if (str2 != null) {
                return str2;
            }
        }
        return str;
    }

    private static Map readEntities() {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (line.length() != 0) {
                            int iIndexOf = line.indexOf(f.b);
                            map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                        }
                    } else {
                        bufferedReader.close();
                        map.put("NewLine", "\n");
                        return map;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                throw new IllegalStateException("Failed reading data for HTML named character references", e);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }
}
