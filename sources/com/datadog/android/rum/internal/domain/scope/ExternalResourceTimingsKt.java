package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExternalResourceTimingsKt {
    private static final List ALL_TIMINGS = CollectionsKt.listOf((Object[]) new String[]{"firstByte", "download", "ssl", "connect", "dns"});

    public static final ResourceTiming extractResourceTiming(Map map) {
        if (map == null) {
            return null;
        }
        List list = ALL_TIMINGS;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, extractTiming((String) obj, map));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Timing) entry.getValue()) != null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap2.isEmpty()) {
            return null;
        }
        return createResourceTiming(linkedHashMap2);
    }

    private static final ResourceTiming createResourceTiming(Map map) {
        Timing timing = (Timing) map.get("firstByte");
        long startTime = timing != null ? timing.getStartTime() : 0L;
        Timing timing2 = (Timing) map.get("firstByte");
        long duration = timing2 != null ? timing2.getDuration() : 0L;
        Timing timing3 = (Timing) map.get("download");
        long startTime2 = timing3 != null ? timing3.getStartTime() : 0L;
        Timing timing4 = (Timing) map.get("download");
        long duration2 = timing4 != null ? timing4.getDuration() : 0L;
        Timing timing5 = (Timing) map.get("dns");
        long startTime3 = timing5 != null ? timing5.getStartTime() : 0L;
        Timing timing6 = (Timing) map.get("dns");
        long duration3 = timing6 != null ? timing6.getDuration() : 0L;
        Timing timing7 = (Timing) map.get("connect");
        long startTime4 = timing7 != null ? timing7.getStartTime() : 0L;
        Timing timing8 = (Timing) map.get("connect");
        long duration4 = timing8 != null ? timing8.getDuration() : 0L;
        Timing timing9 = (Timing) map.get("ssl");
        long startTime5 = timing9 != null ? timing9.getStartTime() : 0L;
        Timing timing10 = (Timing) map.get("ssl");
        return new ResourceTiming(startTime3, duration3, startTime4, duration4, startTime5, timing10 != null ? timing10.getDuration() : 0L, startTime, duration, startTime2, duration2);
    }

    private static final Timing extractTiming(String str, Map map) {
        Object obj = map.get(str);
        if (obj == null || !(obj instanceof Map)) {
            return null;
        }
        Map map2 = (Map) obj;
        Object obj2 = map2.get("startTime");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj3 = map2.get("duration");
        Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
        Long lValueOf2 = number2 != null ? Long.valueOf(number2.longValue()) : null;
        if (lValueOf == null || lValueOf2 == null) {
            return null;
        }
        return new Timing(lValueOf.longValue(), lValueOf2.longValue());
    }
}
