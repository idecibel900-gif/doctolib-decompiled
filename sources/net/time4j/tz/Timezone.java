package net.time4j.tz;

import android.util.TimeUtils;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.GregorianDate;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Timezone implements Serializable {
    private static final boolean ALLOW_SYSTEM_TZ_OVERRIDE;
    private static final boolean ANDROID;
    private static final ConcurrentMap CACHE;
    public static final TransitionStrategy DEFAULT_CONFLICT_STRATEGY;
    private static final ZoneModelProvider DEFAULT_PROVIDER;
    private static final Map ETCETERA;
    private static final LinkedList LAST_USED;
    static final ZoneNameProvider NAME_PROVIDER;
    private static final ZoneModelProvider PLATFORM_PROVIDER;
    private static final Map PREDEFINED;
    private static final ConcurrentMap PROVIDERS;
    private static final ReferenceQueue QUEUE;
    public static final TransitionStrategy STRICT_MODE;
    private static final Timezone SYSTEM_TZ_ORIGINAL;
    private static volatile boolean cacheActive;
    private static volatile Timezone currentSystemTZ;
    private static int softLimit;
    private static volatile ZonalKeys zonalKeys;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String REPOSITORY_VERSION = System.getProperty("net.time4j.tz.repository.version");
    private static final Comparator ID_COMPARATOR = new Comparator() { // from class: net.time4j.tz.Timezone.1
        @Override // java.util.Comparator
        public int compare(TZID tzid, TZID tzid2) {
            return tzid.canonical().compareTo(tzid2.canonical());
        }
    };

    public abstract TransitionHistory getHistory();

    public abstract TZID getID();

    public abstract ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime);

    public abstract ZonalOffset getOffset(UnixTime unixTime);

    public abstract TransitionStrategy getStrategy();

    public abstract boolean isDaylightSaving(UnixTime unixTime);

    public abstract boolean isFixed();

    public abstract boolean isInvalid(GregorianDate gregorianDate, WallTime wallTime);

    public abstract Timezone with(TransitionStrategy transitionStrategy);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [net.time4j.tz.Timezone$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [net.time4j.tz.Timezone] */
    /* JADX WARN: Type inference failed for: r0v20, types: [net.time4j.tz.SingleOffsetTimezone] */
    /* JADX WARN: Type inference failed for: r0v21, types: [net.time4j.tz.Timezone] */
    /* JADX WARN: Type inference failed for: r0v25 */
    static {
        List listLoadPredefined;
        GapResolver gapResolver = GapResolver.PUSH_FORWARD;
        OverlapResolver overlapResolver = OverlapResolver.LATER_OFFSET;
        DEFAULT_CONFLICT_STRATEGY = gapResolver.and(overlapResolver);
        STRICT_MODE = GapResolver.ABORT.and(overlapResolver);
        boolean zEqualsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        ANDROID = zEqualsIgnoreCase;
        ALLOW_SYSTEM_TZ_OVERRIDE = zEqualsIgnoreCase || Boolean.getBoolean("net.time4j.allow.system.tz.override");
        ?? model = 0;
        model = 0;
        zonalKeys = null;
        currentSystemTZ = null;
        cacheActive = true;
        softLimit = 11;
        CACHE = new ConcurrentHashMap();
        PROVIDERS = new ConcurrentHashMap();
        QUEUE = new ReferenceQueue();
        LAST_USED = new LinkedList();
        try {
            listLoadPredefined = loadPredefined(Timezone.class.getClassLoader(), "AFRICA", "AMERICA", "AMERICA$ARGENTINA", "AMERICA$INDIANA", "AMERICA$KENTUCKY", "AMERICA$NORTH_DAKOTA", "ANTARCTICA", "ASIA", "ATLANTIC", "AUSTRALIA", "EUROPE", "INDIAN", "PACIFIC");
        } catch (ClassNotFoundException unused) {
            listLoadPredefined = Collections.EMPTY_LIST;
        }
        HashMap map = new HashMap();
        ZonalOffset zonalOffset = ZonalOffset.UTC;
        map.put("Z", zonalOffset);
        map.put("UT", zonalOffset);
        map.put("UTC", zonalOffset);
        map.put("GMT", zonalOffset);
        map.put("UTC0", zonalOffset);
        map.put("GMT0", zonalOffset);
        Iterator it = listLoadPredefined.iterator();
        while (it.hasNext()) {
            for (TZID tzid : (TZID[]) ((Class) it.next()).getEnumConstants()) {
                map.put(tzid.canonical(), tzid);
            }
        }
        PREDEFINED = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        fillEtcetera(map2);
        ETCETERA = Collections.unmodifiableMap(map2);
        ZoneModelProvider zoneModelProviderCompareTZDB = null;
        for (ZoneModelProvider zoneModelProvider : ResourceLoader.getInstance().services(ZoneModelProvider.class)) {
            String name = zoneModelProvider.getName();
            if (name.equals("TZDB")) {
                zoneModelProviderCompareTZDB = compareTZDB(zoneModelProvider, zoneModelProviderCompareTZDB);
            } else if (!name.isEmpty() && !name.equals("DEFAULT")) {
                PROVIDERS.put(name, zoneModelProvider);
            }
        }
        specificZoneNameRepository = null;
        for (ZoneNameProvider specificZoneNameRepository : ResourceLoader.getInstance().services(ZoneNameProvider.class)) {
        }
        PlatformZoneProvider platformZoneProvider = new PlatformZoneProvider();
        PLATFORM_PROVIDER = platformZoneProvider;
        if (specificZoneNameRepository == null) {
            specificZoneNameRepository = platformZoneProvider.getSpecificZoneNameRepository();
        }
        NAME_PROVIDER = specificZoneNameRepository;
        ConcurrentMap concurrentMap = PROVIDERS;
        concurrentMap.put("java.util.TimeZone", platformZoneProvider);
        if (zoneModelProviderCompareTZDB == null) {
            DEFAULT_PROVIDER = platformZoneProvider;
        } else {
            concurrentMap.put("TZDB", zoneModelProviderCompareTZDB);
            DEFAULT_PROVIDER = zoneModelProviderCompareTZDB;
        }
        try {
            String property = System.getProperty("user.timezone");
            if ("Z".equals(property) || "UTC".equals(property)) {
                model = ZonalOffset.UTC.getModel();
            } else if (property != null) {
                model = getTZ(resolve(property), property, false);
            }
        } catch (SecurityException unused2) {
        }
        if (model == 0) {
            SYSTEM_TZ_ORIGINAL = getDefaultTZ();
        } else {
            SYSTEM_TZ_ORIGINAL = model;
        }
        if (ALLOW_SYSTEM_TZ_OVERRIDE) {
            currentSystemTZ = SYSTEM_TZ_ORIGINAL;
        }
        zonalKeys = new ZonalKeys();
    }

    Timezone() {
    }

    public static List getAvailableIDs() {
        return zonalKeys.availables;
    }

    public static List getAvailableIDs(String str) {
        if (!str.equals("INCLUDE_ALIAS")) {
            ZoneModelProvider provider = getProvider(str);
            if (provider == null) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = provider.getAvailableIDs().iterator();
            while (it.hasNext()) {
                arrayList.add(resolve((String) it.next()));
            }
            Collections.sort(arrayList, ID_COMPARATOR);
            return Collections.unmodifiableList(arrayList);
        }
        return zonalKeys.availablesAndAliases;
    }

    public static Set getPreferredIDs(Locale locale, boolean z, String str) {
        ZoneModelProvider provider = getProvider(str);
        if (provider == null) {
            return Collections.EMPTY_SET;
        }
        ZoneNameProvider specificZoneNameRepository = provider.getSpecificZoneNameRepository();
        if (specificZoneNameRepository == null) {
            specificZoneNameRepository = NAME_PROVIDER;
        }
        HashSet hashSet = new HashSet();
        Iterator it = specificZoneNameRepository.getPreferredIDs(locale, z).iterator();
        while (it.hasNext()) {
            hashSet.add(resolve((String) it.next()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static Timezone ofSystem() {
        if (ALLOW_SYSTEM_TZ_OVERRIDE && currentSystemTZ != null) {
            return currentSystemTZ;
        }
        return SYSTEM_TZ_ORIGINAL;
    }

    public static Timezone of(TZID tzid) {
        return getTZ(tzid, true);
    }

    public static Timezone of(String str) {
        return getTZ(null, str, true);
    }

    public String getDisplayName(NameStyle nameStyle, Locale locale) {
        return getDisplayName(getID(), nameStyle, locale);
    }

    public static String getDisplayName(TZID tzid, NameStyle nameStyle, Locale locale) {
        String strSubstring;
        String strCanonical = tzid.canonical();
        int iIndexOf = strCanonical.indexOf(WebSocketProtocol.PAYLOAD_SHORT);
        ZoneModelProvider zoneModelProvider = DEFAULT_PROVIDER;
        if (iIndexOf >= 0) {
            String strSubstring2 = strCanonical.substring(0, iIndexOf);
            if (strSubstring2.equals("DEFAULT") || (zoneModelProvider = (ZoneModelProvider) PROVIDERS.get(strSubstring2)) != null) {
                strSubstring = strCanonical.substring(iIndexOf + 1);
            }
            return strCanonical;
        }
        strSubstring = strCanonical;
        ZoneNameProvider specificZoneNameRepository = zoneModelProvider.getSpecificZoneNameRepository();
        if (specificZoneNameRepository == null) {
            specificZoneNameRepository = NAME_PROVIDER;
        }
        String displayName = specificZoneNameRepository.getDisplayName(strSubstring, nameStyle, locale);
        if (displayName.isEmpty()) {
            ZoneNameProvider zoneNameProvider = NAME_PROVIDER;
            if (specificZoneNameRepository != zoneNameProvider) {
                displayName = zoneNameProvider.getDisplayName(strSubstring, nameStyle, locale);
            }
            if (displayName.isEmpty()) {
                return strCanonical;
            }
        }
        return displayName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Timezone getDefaultTZ() {
        String id = TimeZone.getDefault().getID();
        Timezone tz = getTZ(null, id, false);
        return tz == null ? new PlatformTimezone(new NamedID(id)) : tz;
    }

    private static Timezone getTZ(TZID tzid, boolean z) {
        if (tzid instanceof ZonalOffset) {
            return ((ZonalOffset) tzid).getModel();
        }
        return getTZ(tzid, tzid.canonical(), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Timezone getTZ(TZID tzid, String str, boolean z) {
        Timezone historizedTimezone;
        String strSubstring;
        String str2;
        ConcurrentMap concurrentMap = CACHE;
        NamedReference namedReference = (NamedReference) concurrentMap.get(str);
        if (namedReference != null) {
            historizedTimezone = (Timezone) namedReference.get();
            if (historizedTimezone == null) {
                concurrentMap.remove(namedReference.tzid);
            }
        } else {
            historizedTimezone = null;
        }
        if (historizedTimezone != null) {
            return historizedTimezone;
        }
        String strSubstring2 = "";
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                strSubstring = str;
                break;
            }
            if (str.charAt(i) == '~') {
                strSubstring2 = str.substring(0, i);
                strSubstring = str.substring(i + 1);
                break;
            }
            i++;
        }
        if (strSubstring.isEmpty()) {
            if (z) {
                throw new IllegalArgumentException("Timezone key is empty.");
            }
            return null;
        }
        ZoneModelProvider zoneModelProvider = DEFAULT_PROVIDER;
        boolean z2 = strSubstring2.isEmpty() || strSubstring2.equals("DEFAULT");
        if (!z2 && (zoneModelProvider = (ZoneModelProvider) PROVIDERS.get(strSubstring2)) == null) {
            if (!z) {
                return null;
            }
            if (strSubstring2.equals("TZDB")) {
                str2 = "TZDB provider not available: ";
            } else {
                str2 = "Timezone model provider not registered: ";
            }
            throw new IllegalArgumentException(str2 + str);
        }
        if (tzid == null) {
            if (z2) {
                tzid = resolve(strSubstring);
                if (tzid instanceof ZonalOffset) {
                    return ((ZonalOffset) tzid).getModel();
                }
            } else {
                tzid = new NamedID(str);
            }
        }
        if (zoneModelProvider == PLATFORM_PROVIDER) {
            PlatformTimezone platformTimezone = new PlatformTimezone(tzid, strSubstring);
            if (!platformTimezone.isGMT() || strSubstring.equals("GMT") || strSubstring.startsWith("UT") || strSubstring.equals("Z")) {
                historizedTimezone = platformTimezone;
            }
        } else {
            TransitionHistory transitionHistoryLoad = zoneModelProvider.load(strSubstring);
            if (transitionHistoryLoad == null) {
                historizedTimezone = getZoneByAlias(zoneModelProvider, tzid, strSubstring);
            } else {
                historizedTimezone = new HistorizedTimezone(tzid, transitionHistoryLoad);
            }
        }
        if (historizedTimezone == null) {
            if (!z) {
                return null;
            }
            if (TimeZone.getDefault().getID().equals(str)) {
                return new PlatformTimezone(new NamedID(str));
            }
            throw new IllegalArgumentException("Unknown timezone: " + str);
        }
        if (cacheActive) {
            NamedReference namedReference2 = (NamedReference) CACHE.putIfAbsent(str, new NamedReference(historizedTimezone, QUEUE));
            if (namedReference2 == null) {
                synchronized (Timezone.class) {
                    try {
                        LAST_USED.addFirst(historizedTimezone);
                        while (true) {
                            LinkedList linkedList = LAST_USED;
                            if (linkedList.size() >= softLimit) {
                                linkedList.removeLast();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return historizedTimezone;
            }
            Timezone timezone = (Timezone) namedReference2.get();
            if (timezone != null) {
                return timezone;
            }
        }
        return historizedTimezone;
    }

    private static Timezone getZoneByAlias(ZoneModelProvider zoneModelProvider, TZID tzid, String str) {
        Map aliases = zoneModelProvider.getAliases();
        String str2 = str;
        TransitionHistory transitionHistoryLoad = null;
        while (transitionHistoryLoad == null) {
            str2 = (String) aliases.get(str2);
            if (str2 == null) {
                break;
            }
            transitionHistoryLoad = zoneModelProvider.load(str2);
        }
        if (transitionHistoryLoad == null) {
            String fallback = zoneModelProvider.getFallback();
            if (fallback.isEmpty()) {
                return null;
            }
            if (fallback.equals(zoneModelProvider.getName())) {
                throw new IllegalArgumentException("Circular zone model provider fallback: " + zoneModelProvider.getName());
            }
            return new FallbackTimezone(tzid, of(fallback + "~" + str));
        }
        return new HistorizedTimezone(tzid, transitionHistoryLoad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TZID resolve(String str) {
        TZID tzid = (TZID) PREDEFINED.get(str);
        if (tzid != null) {
            return tzid;
        }
        if (str.startsWith("GMT")) {
            str = "UTC" + str.substring(3);
        }
        ZonalOffset zonalOffset = ZonalOffset.parse(str, false);
        return zonalOffset == null ? new NamedID(str) : zonalOffset;
    }

    private static void fillEtcetera(Map map) {
        ZonalOffset zonalOffset = ZonalOffset.UTC;
        map.put("Etc/GMT", zonalOffset);
        map.put("Etc/Greenwich", zonalOffset);
        map.put("Etc/Universal", zonalOffset);
        map.put("Etc/Zulu", zonalOffset);
        map.put("Etc/GMT+0", zonalOffset);
        map.put("Etc/GMT-0", zonalOffset);
        map.put("Etc/GMT0", zonalOffset);
        map.put("Etc/UTC", zonalOffset);
        map.put("Etc/UCT", zonalOffset);
        map.put("Etc/GMT-14", ZonalOffset.ofTotalSeconds(50400));
        map.put("Etc/GMT-13", ZonalOffset.ofTotalSeconds(46800));
        map.put("Etc/GMT-12", ZonalOffset.ofTotalSeconds(43200));
        map.put("Etc/GMT-11", ZonalOffset.ofTotalSeconds(39600));
        map.put("Etc/GMT-10", ZonalOffset.ofTotalSeconds(36000));
        map.put("Etc/GMT-9", ZonalOffset.ofTotalSeconds(32400));
        map.put("Etc/GMT-8", ZonalOffset.ofTotalSeconds(28800));
        map.put("Etc/GMT-7", ZonalOffset.ofTotalSeconds(25200));
        map.put("Etc/GMT-6", ZonalOffset.ofTotalSeconds(21600));
        map.put("Etc/GMT-5", ZonalOffset.ofTotalSeconds(18000));
        map.put("Etc/GMT-4", ZonalOffset.ofTotalSeconds(14400));
        map.put("Etc/GMT-3", ZonalOffset.ofTotalSeconds(10800));
        map.put("Etc/GMT-2", ZonalOffset.ofTotalSeconds(7200));
        map.put("Etc/GMT-1", ZonalOffset.ofTotalSeconds(3600));
        map.put("Etc/GMT+1", ZonalOffset.ofTotalSeconds(-3600));
        map.put("Etc/GMT+2", ZonalOffset.ofTotalSeconds(-7200));
        map.put("Etc/GMT+3", ZonalOffset.ofTotalSeconds(-10800));
        map.put("Etc/GMT+4", ZonalOffset.ofTotalSeconds(-14400));
        map.put("Etc/GMT+5", ZonalOffset.ofTotalSeconds(-18000));
        map.put("Etc/GMT+6", ZonalOffset.ofTotalSeconds(-21600));
        map.put("Etc/GMT+7", ZonalOffset.ofTotalSeconds(-25200));
        map.put("Etc/GMT+8", ZonalOffset.ofTotalSeconds(-28800));
        map.put("Etc/GMT+9", ZonalOffset.ofTotalSeconds(-32400));
        map.put("Etc/GMT+10", ZonalOffset.ofTotalSeconds(-36000));
        map.put("Etc/GMT+11", ZonalOffset.ofTotalSeconds(-39600));
        map.put("Etc/GMT+12", ZonalOffset.ofTotalSeconds(-43200));
    }

    private static List loadPredefined(ClassLoader classLoader, String... strArr) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Class<?> cls = Class.forName("net.time4j.tz.olson." + str, true, classLoader);
            if (TZID.class.isAssignableFrom(cls)) {
                arrayList.add(cls);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static ZoneModelProvider getProvider(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing zone model provider.");
        }
        return str.equals("DEFAULT") ? DEFAULT_PROVIDER : (ZoneModelProvider) PROVIDERS.get(str);
    }

    private static ZoneModelProvider compareTZDB(ZoneModelProvider zoneModelProvider, ZoneModelProvider zoneModelProvider2) {
        String version = zoneModelProvider.getVersion();
        if (!version.isEmpty()) {
            String str = REPOSITORY_VERSION;
            if (version.equals(str) || (str == null && (zoneModelProvider2 == null || version.compareTo(zoneModelProvider2.getVersion()) > 0 || (version.compareTo(zoneModelProvider2.getVersion()) == 0 && !zoneModelProvider.getLocation().contains("{java.home}"))))) {
                return zoneModelProvider;
            }
        }
        return zoneModelProvider2;
    }

    public static class Cache {
        public static void refresh() {
            synchronized (Timezone.class) {
                do {
                } while (Timezone.QUEUE.poll() != null);
                Timezone.LAST_USED.clear();
            }
            ZonalKeys unused = Timezone.zonalKeys = new ZonalKeys();
            Timezone.CACHE.clear();
            if (Timezone.ALLOW_SYSTEM_TZ_OVERRIDE) {
                Timezone unused2 = Timezone.currentSystemTZ = Timezone.getDefaultTZ();
            }
        }
    }

    private static class NamedReference extends SoftReference {
        private final String tzid;

        NamedReference(Timezone timezone, ReferenceQueue referenceQueue) {
            super(timezone, referenceQueue);
            this.tzid = timezone.getID().canonical();
        }
    }

    private static class ZonalKeys {
        private final List availables;
        private final List availablesAndAliases;

        ZonalKeys() {
            ArrayList arrayList = new ArrayList(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            ArrayList arrayList2 = new ArrayList(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            arrayList.add(ZonalOffset.UTC);
            Iterator it = Timezone.PROVIDERS.entrySet().iterator();
            while (it.hasNext()) {
                ZoneModelProvider zoneModelProvider = (ZoneModelProvider) ((Map.Entry) it.next()).getValue();
                if (zoneModelProvider != Timezone.PLATFORM_PROVIDER || Timezone.DEFAULT_PROVIDER == Timezone.PLATFORM_PROVIDER) {
                    Iterator it2 = zoneModelProvider.getAvailableIDs().iterator();
                    while (it2.hasNext()) {
                        TZID tzidResolve = Timezone.resolve((String) it2.next());
                        if (!arrayList.contains(tzidResolve)) {
                            arrayList.add(tzidResolve);
                        }
                    }
                    arrayList2.addAll(arrayList);
                    Iterator it3 = zoneModelProvider.getAliases().keySet().iterator();
                    while (it3.hasNext()) {
                        TZID tzidResolve2 = Timezone.resolve((String) it3.next());
                        if (!arrayList2.contains(tzidResolve2)) {
                            arrayList2.add(tzidResolve2);
                        }
                    }
                }
            }
            Collections.sort(arrayList, Timezone.ID_COMPARATOR);
            Collections.sort(arrayList2, Timezone.ID_COMPARATOR);
            this.availables = Collections.unmodifiableList(arrayList);
            this.availablesAndAliases = Collections.unmodifiableList(arrayList2);
        }
    }

    private static class PlatformZoneProvider implements ZoneModelProvider, ZoneNameProvider {
        private PlatformZoneProvider() {
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public ZoneNameProvider getSpecificZoneNameRepository() {
            return this;
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public TransitionHistory load(String str) {
            return null;
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public Set getAvailableIDs() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(TimeZone.getAvailableIDs()));
            return hashSet;
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public Map getAliases() {
            return Collections.EMPTY_MAP;
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public String getFallback() {
            return "";
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public String getName() {
            return "java.util.TimeZone";
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public String getLocation() {
            return "";
        }

        @Override // net.time4j.tz.ZoneModelProvider
        public String getVersion() {
            return TimeUtils.getTimeZoneDatabaseVersion();
        }

        @Override // net.time4j.tz.ZoneNameProvider
        public Set getPreferredIDs(Locale locale, boolean z) {
            return Collections.EMPTY_SET;
        }

        @Override // net.time4j.tz.ZoneNameProvider
        public String getDisplayName(String str, NameStyle nameStyle, Locale locale) {
            if (locale == null) {
                throw new NullPointerException("Missing locale.");
            }
            if (str.isEmpty()) {
                return "";
            }
            TimeZone timeZoneFindZone = PlatformTimezone.findZone(str);
            if (timeZoneFindZone.getID().equals(str)) {
                return timeZoneFindZone.getDisplayName(nameStyle.isDaylightSaving(), !nameStyle.isAbbreviation() ? 1 : 0, locale);
            }
            return "";
        }

        @Override // net.time4j.tz.ZoneNameProvider
        public String getStdFormatPattern(boolean z, Locale locale) {
            return z ? "GMT" : "GMT±hh:mm";
        }
    }
}
