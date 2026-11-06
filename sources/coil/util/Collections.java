package coil.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: coil.util.-Collections, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Collections {
    public static final Map toImmutableMap(Map map) {
        int size = map.size();
        if (size == 0) {
            return MapsKt.emptyMap();
        }
        if (size == 1) {
            Map.Entry entry = (Map.Entry) CollectionsKt.first(map.entrySet());
            return java.util.Collections.singletonMap(entry.getKey(), entry.getValue());
        }
        return java.util.Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static final List toImmutableList(List list) {
        int size = list.size();
        if (size == 0) {
            return CollectionsKt.emptyList();
        }
        if (size == 1) {
            return java.util.Collections.singletonList(CollectionsKt.first(list));
        }
        return java.util.Collections.unmodifiableList(new ArrayList(list));
    }
}
