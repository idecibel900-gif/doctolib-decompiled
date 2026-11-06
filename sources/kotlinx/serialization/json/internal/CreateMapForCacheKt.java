package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CreateMapForCacheKt {
    public static final Map createMapForCache(int i) {
        return new ConcurrentHashMap(i);
    }
}
