package io.sentry.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
final class CompositePropertiesProvider implements PropertiesProvider {
    private final List providers;

    public CompositePropertiesProvider(List list) {
        this.providers = list;
    }

    @Override // io.sentry.config.PropertiesProvider
    public String getProperty(String str) {
        Iterator it = this.providers.iterator();
        while (it.hasNext()) {
            String property = ((PropertiesProvider) it.next()).getProperty(str);
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    @Override // io.sentry.config.PropertiesProvider
    public Map getMap(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator it = this.providers.iterator();
        while (it.hasNext()) {
            concurrentHashMap.putAll(((PropertiesProvider) it.next()).getMap(str));
        }
        return concurrentHashMap;
    }
}
