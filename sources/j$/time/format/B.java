package j$.time.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class B {
    public static final ConcurrentMap a = new ConcurrentHashMap(16, 0.75f, 2);
    public static final z b = new z();
    public static final B c = new B();

    public String c(j$.time.temporal.q qVar, long j, G g, Locale locale) {
        Object objA = a(qVar, locale);
        if (objA instanceof A) {
            return ((A) objA).a(j, g);
        }
        return null;
    }

    public String b(j$.time.chrono.m mVar, j$.time.temporal.q qVar, long j, G g, Locale locale) {
        if (mVar == j$.time.chrono.t.c || !(qVar instanceof j$.time.temporal.a)) {
            return c(qVar, j, g, locale);
        }
        return null;
    }

    public Iterator e(j$.time.temporal.q qVar, G g, Locale locale) {
        List list;
        Object objA = a(qVar, locale);
        if (!(objA instanceof A) || (list = (List) ((HashMap) ((A) objA).b).get(g)) == null) {
            return null;
        }
        return list.iterator();
    }

    public Iterator d(j$.time.chrono.m mVar, j$.time.temporal.q qVar, G g, Locale locale) {
        if (mVar == j$.time.chrono.t.c || !(qVar instanceof j$.time.temporal.a)) {
            return e(qVar, g, locale);
        }
        return null;
    }

    public static Object a(j$.time.temporal.q qVar, Locale locale) {
        Object a2;
        String strSubstring;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(qVar, locale);
        Object obj = ((ConcurrentHashMap) a).get(simpleImmutableEntry);
        if (obj != null) {
            return obj;
        }
        HashMap map = new HashMap();
        if (qVar == j$.time.temporal.a.ERA) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            String[] eras = dateFormatSymbols.getEras();
            for (int i = 0; i < eras.length; i++) {
                if (!eras[i].isEmpty()) {
                    long j = i;
                    map2.put(Long.valueOf(j), eras[i]);
                    Long lValueOf = Long.valueOf(j);
                    String str = eras[i];
                    map3.put(lValueOf, str.substring(0, Character.charCount(str.codePointAt(0))));
                }
            }
            if (!map2.isEmpty()) {
                map.put(G.FULL, map2);
                map.put(G.SHORT, map2);
                map.put(G.NARROW, map3);
            }
            a2 = new A(map);
        } else if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            int length = DateFormatSymbols.getInstance(locale).getMonths().length;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (long j2 = 1; j2 <= length; j2++) {
                String strB = j$.time.b.b(j2, "LLLL", locale);
                linkedHashMap.put(Long.valueOf(j2), strB);
                linkedHashMap2.put(Long.valueOf(j2), strB.substring(0, Character.charCount(strB.codePointAt(0))));
                linkedHashMap3.put(Long.valueOf(j2), j$.time.b.b(j2, "LLL", locale));
            }
            if (length > 0) {
                map.put(G.FULL_STANDALONE, linkedHashMap);
                map.put(G.NARROW_STANDALONE, linkedHashMap2);
                map.put(G.SHORT_STANDALONE, linkedHashMap3);
                map.put(G.FULL, linkedHashMap);
                map.put(G.NARROW, linkedHashMap2);
                map.put(G.SHORT, linkedHashMap3);
            }
            a2 = new A(map);
        } else if (qVar == j$.time.temporal.a.DAY_OF_WEEK) {
            int length2 = DateFormatSymbols.getInstance(locale).getWeekdays().length;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            boolean z = locale == Locale.SIMPLIFIED_CHINESE || locale == Locale.TRADITIONAL_CHINESE;
            for (long j3 = 1; j3 <= length2; j3++) {
                String strA = j$.time.b.a(j3, "cccc", locale);
                linkedHashMap4.put(Long.valueOf(j3), strA);
                Long lValueOf2 = Long.valueOf(j3);
                if (!z) {
                    strSubstring = strA.substring(0, Character.charCount(strA.codePointAt(0)));
                } else {
                    strSubstring = new StringBuilder().appendCodePoint(strA.codePointBefore(strA.length())).toString();
                }
                linkedHashMap5.put(lValueOf2, strSubstring);
                linkedHashMap6.put(Long.valueOf(j3), j$.time.b.a(j3, "ccc", locale));
            }
            if (length2 > 0) {
                map.put(G.FULL_STANDALONE, linkedHashMap4);
                map.put(G.NARROW_STANDALONE, linkedHashMap5);
                map.put(G.SHORT_STANDALONE, linkedHashMap6);
                map.put(G.FULL, linkedHashMap4);
                map.put(G.NARROW, linkedHashMap5);
                map.put(G.SHORT, linkedHashMap6);
            }
            a2 = new A(map);
        } else if (qVar == j$.time.temporal.a.AMPM_OF_DAY) {
            DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            String[] amPmStrings = dateFormatSymbols2.getAmPmStrings();
            for (int i2 = 0; i2 < amPmStrings.length; i2++) {
                if (!amPmStrings[i2].isEmpty()) {
                    long j4 = i2;
                    map4.put(Long.valueOf(j4), amPmStrings[i2]);
                    Long lValueOf3 = Long.valueOf(j4);
                    String str2 = amPmStrings[i2];
                    map5.put(lValueOf3, str2.substring(0, Character.charCount(str2.codePointAt(0))));
                }
            }
            if (!map4.isEmpty()) {
                map.put(G.FULL, map4);
                map.put(G.SHORT, map4);
                map.put(G.NARROW, map5);
            }
            a2 = new A(map);
        } else {
            a2 = "";
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) a;
        concurrentHashMap.putIfAbsent(simpleImmutableEntry, a2);
        return concurrentHashMap.get(simpleImmutableEntry);
    }
}
