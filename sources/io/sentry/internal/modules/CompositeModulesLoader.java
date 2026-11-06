package io.sentry.internal.modules;

import io.sentry.ILogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public final class CompositeModulesLoader extends ModulesLoader {
    private final List loaders;

    public CompositeModulesLoader(List list, ILogger iLogger) {
        super(iLogger);
        this.loaders = list;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    protected Map loadModules() {
        TreeMap treeMap = new TreeMap();
        Iterator it = this.loaders.iterator();
        while (it.hasNext()) {
            Map orLoadModules = ((IModulesLoader) it.next()).getOrLoadModules();
            if (orLoadModules != null) {
                treeMap.putAll(orLoadModules);
            }
        }
        return treeMap;
    }
}
