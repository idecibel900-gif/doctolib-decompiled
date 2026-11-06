package net.time4j.tz.spi;

import com.adjust.sdk.Constants;
import com.amazon.a.a.o.b.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.ResourceLoader;
import net.time4j.i18n.PropertyBundle;
import net.time4j.tz.NameStyle;
import net.time4j.tz.ZoneNameProvider;

/* JADX INFO: loaded from: classes5.dex */
public class ZoneNameProviderSPI implements ZoneNameProvider {
    private static final Set GMT_ZONES;
    private static final ConcurrentMap NAMES = new ConcurrentHashMap();
    private static final Map PRIMARIES;
    private static final Map TERRITORIES;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("Z");
        hashSet.add("GMT");
        hashSet.add("GMT0");
        hashSet.add("Greenwich");
        hashSet.add("UCT");
        hashSet.add("UTC");
        hashSet.add("UTC0");
        hashSet.add("Universal");
        hashSet.add("Zulu");
        GMT_ZONES = Collections.unmodifiableSet(hashSet);
        HashMap map = new HashMap();
        loadTerritories(map, "data/zone1970.tab");
        TERRITORIES = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        addPrimary(map2, "CL", "America/Santiago");
        addPrimary(map2, "CN", "Asia/Shanghai");
        addPrimary(map2, "DE", "Europe/Berlin");
        addPrimary(map2, "EC", "America/Guayaquil");
        addPrimary(map2, "ES", "Europe/Madrid");
        addPrimary(map2, "MH", "Pacific/Majuro");
        addPrimary(map2, "MY", "Asia/Kuala_Lumpur");
        addPrimary(map2, "NZ", "Pacific/Auckland");
        addPrimary(map2, "PT", "Europe/Lisbon");
        addPrimary(map2, "UA", "Europe/Kiev");
        addPrimary(map2, "UZ", "Asia/Tashkent");
        PRIMARIES = Collections.unmodifiableMap(map2);
    }

    @Override // net.time4j.tz.ZoneNameProvider
    public Set getPreferredIDs(Locale locale, boolean z) {
        String country = locale.getCountry();
        if (z) {
            if (country.equals("US")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add("America/New_York");
                linkedHashSet.add("America/Chicago");
                linkedHashSet.add("America/Denver");
                linkedHashSet.add("America/Los_Angeles");
                linkedHashSet.add("America/Anchorage");
                linkedHashSet.add("Pacific/Honolulu");
                return Collections.unmodifiableSet(linkedHashSet);
            }
            String str = (String) PRIMARIES.get(country);
            if (str != null) {
                return Collections.singleton(str);
            }
        }
        Set set = (Set) TERRITORIES.get(country);
        return set == null ? Collections.EMPTY_SET : set;
    }

    @Override // net.time4j.tz.ZoneNameProvider
    public String getDisplayName(String str, NameStyle nameStyle, Locale locale) {
        if (GMT_ZONES.contains(str)) {
            return "";
        }
        Map map = (Map) NAMES.get(locale);
        if (map == null) {
            String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
            HashMap map2 = new HashMap();
            for (String[] strArr : zoneStrings) {
                EnumMap enumMap = new EnumMap(NameStyle.class);
                enumMap.put(NameStyle.LONG_STANDARD_TIME, strArr[1]);
                enumMap.put(NameStyle.SHORT_STANDARD_TIME, strArr[2]);
                enumMap.put(NameStyle.LONG_DAYLIGHT_TIME, strArr[3]);
                enumMap.put(NameStyle.SHORT_DAYLIGHT_TIME, strArr[4]);
                map2.put(strArr[0], enumMap);
            }
            map = (Map) NAMES.putIfAbsent(locale, map2);
            if (map == null) {
                map = map2;
            }
        }
        Map map3 = (Map) map.get(str);
        return map3 != null ? (String) map3.get(nameStyle) : "";
    }

    @Override // net.time4j.tz.ZoneNameProvider
    public String getStdFormatPattern(boolean z, Locale locale) {
        return getBundle(locale).getString(z ? "utc-literal" : "offset-pattern");
    }

    static void loadTerritories(Map map, String str) {
        InputStream inputStreamLoad = ResourceLoader.getInstance().load(ResourceLoader.getInstance().locate("olson", ZoneNameProviderSPI.class, str), true);
        if (inputStreamLoad == null) {
            inputStreamLoad = ZoneNameProviderSPI.class.getClassLoader().getResourceAsStream(str);
        }
        try {
            if (inputStreamLoad != null) {
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamLoad, Constants.ENCODING));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                if (!line.startsWith("#") && !line.isEmpty()) {
                                    String[] strArrSplit = line.split("\t");
                                    if (strArrSplit.length >= 3) {
                                        for (String str2 : strArrSplit[0].split(f.a)) {
                                            addTerritory(map, str2, strArrSplit[2]);
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                try {
                                    inputStreamLoad.close();
                                    return;
                                } catch (IOException e) {
                                    e.printStackTrace(System.err);
                                    return;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (UnsupportedEncodingException e3) {
                    throw new AssertionError(e3);
                }
            } else {
                System.err.println("Warning: File \"" + str + "\" not found.");
            }
        } catch (Throwable th) {
            try {
                inputStreamLoad.close();
            } catch (IOException e4) {
                e4.printStackTrace(System.err);
            }
            throw th;
        }
    }

    private static void addTerritory(Map map, String str, String str2) {
        Set linkedHashSet = (Set) map.get(str);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            map.put(str, linkedHashSet);
        }
        linkedHashSet.add(str2);
    }

    private static void addPrimary(Map map, String str, String str2) {
        map.put(str, str2);
    }

    private static PropertyBundle getBundle(Locale locale) {
        return PropertyBundle.load("olson/zones/tzname", locale);
    }
}
