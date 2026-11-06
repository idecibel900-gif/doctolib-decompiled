package io.sentry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAttributes {
    private final Map attributes;

    private SentryAttributes(Map map) {
        this.attributes = map;
    }

    public void add(SentryAttribute sentryAttribute) {
        if (sentryAttribute == null) {
            return;
        }
        this.attributes.put(sentryAttribute.getName(), sentryAttribute);
    }

    public Map getAttributes() {
        return this.attributes;
    }

    public static SentryAttributes fromMap(Map map) {
        if (map == null) {
            return new SentryAttributes(new ConcurrentHashMap());
        }
        SentryAttributes sentryAttributes = new SentryAttributes(new ConcurrentHashMap(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                sentryAttributes.add(SentryAttribute.named(str, entry.getValue()));
            }
        }
        return sentryAttributes;
    }
}
