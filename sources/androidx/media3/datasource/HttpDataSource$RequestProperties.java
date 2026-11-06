package androidx.media3.datasource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class HttpDataSource$RequestProperties {
    private final Map requestProperties = new HashMap();
    private Map requestPropertiesSnapshot;

    public synchronized void clearAndSet(Map map) {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.clear();
        this.requestProperties.putAll(map);
    }

    public synchronized Map getSnapshot() {
        try {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.requestPropertiesSnapshot;
    }
}
