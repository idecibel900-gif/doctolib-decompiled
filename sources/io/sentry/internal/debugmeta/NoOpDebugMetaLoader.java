package io.sentry.internal.debugmeta;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpDebugMetaLoader implements IDebugMetaLoader {
    private static final NoOpDebugMetaLoader instance = new NoOpDebugMetaLoader();

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public List loadDebugMeta() {
        return null;
    }

    public static NoOpDebugMetaLoader getInstance() {
        return instance;
    }

    private NoOpDebugMetaLoader() {
    }
}
