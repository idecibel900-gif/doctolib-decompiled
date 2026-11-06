package expo.modules.structuredheaders;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Utils {
    protected static boolean isAlpha(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    protected static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    protected static boolean isLcAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    protected static String checkKey(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Key can not be null or empty");
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((i == 0 && cCharAt != '*' && !isLcAlpha(cCharAt)) || (!isLcAlpha(cCharAt) && !isDigit(cCharAt) && cCharAt != '_' && cCharAt != '-' && cCharAt != '.' && cCharAt != '*')) {
                throw new IllegalArgumentException(String.format("Invalid character in key at position %d: '%c' (0x%04x)", Integer.valueOf(i), Character.valueOf(cCharAt), Integer.valueOf(cCharAt)));
            }
        }
        return str;
    }

    protected static Map checkKeys(Map map) {
        Objects.requireNonNull(map, "value must not be null");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey((String) it.next());
        }
        return map;
    }
}
