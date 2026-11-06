package org.apache.commons.lang3;

import com.adjust.sdk.Constants;
import com.amazon.a.a.o.c.a.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClassUtils {
    private static final Map abbreviationMap;
    private static final Map namePrimitiveMap;
    private static final Map primitiveWrapperMap;
    private static final Map reverseAbbreviationMap;
    private static final Map wrapperPrimitiveMap;
    public static final String PACKAGE_SEPARATOR = String.valueOf(b.a);
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    static {
        HashMap map = new HashMap();
        namePrimitiveMap = map;
        Class cls = Boolean.TYPE;
        map.put("boolean", cls);
        Class cls2 = Byte.TYPE;
        map.put("byte", cls2);
        Class cls3 = Character.TYPE;
        map.put("char", cls3);
        Class cls4 = Short.TYPE;
        map.put("short", cls4);
        Class cls5 = Integer.TYPE;
        map.put("int", cls5);
        Class cls6 = Long.TYPE;
        map.put(Constants.LONG, cls6);
        Class cls7 = Double.TYPE;
        map.put("double", cls7);
        Class cls8 = Float.TYPE;
        map.put("float", cls8);
        Class cls9 = Void.TYPE;
        map.put("void", cls9);
        HashMap map2 = new HashMap();
        primitiveWrapperMap = map2;
        map2.put(cls, Boolean.class);
        map2.put(cls2, Byte.class);
        map2.put(cls3, Character.class);
        map2.put(cls4, Short.class);
        map2.put(cls5, Integer.class);
        map2.put(cls6, Long.class);
        map2.put(cls7, Double.class);
        map2.put(cls8, Float.class);
        map2.put(cls9, cls9);
        wrapperPrimitiveMap = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Class cls10 = (Class) entry.getKey();
            Class cls11 = (Class) entry.getValue();
            if (!cls10.equals(cls11)) {
                wrapperPrimitiveMap.put(cls11, cls10);
            }
        }
        HashMap map3 = new HashMap();
        map3.put("int", "I");
        map3.put("boolean", "Z");
        map3.put("float", "F");
        map3.put(Constants.LONG, "J");
        map3.put("short", "S");
        map3.put("byte", "B");
        map3.put("double", "D");
        map3.put("char", "C");
        HashMap map4 = new HashMap();
        for (Map.Entry entry2 : map3.entrySet()) {
            map4.put(entry2.getValue(), entry2.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(map3);
        reverseAbbreviationMap = Collections.unmodifiableMap(map4);
    }

    public static String getShortClassName(Class cls) {
        if (cls == null) {
            return "";
        }
        return getShortClassName(cls.getName());
    }

    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map map = reverseAbbreviationMap;
            if (map.containsKey(str)) {
                str = (String) map.get(str);
            }
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iIndexOf = str.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', b.a);
        }
        return strSubstring + ((Object) sb);
    }

    public static boolean isPrimitiveOrWrapper(Class cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class cls) {
        return wrapperPrimitiveMap.containsKey(cls);
    }
}
