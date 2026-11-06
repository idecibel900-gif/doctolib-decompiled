package io.sentry;

import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ScopesStorageFactory {
    public static IScopesStorage create(LoadClass loadClass, ILogger iLogger) {
        IScopesStorage iScopesStorageCreateInternal = createInternal(loadClass, iLogger);
        iScopesStorageCreateInternal.init();
        return iScopesStorageCreateInternal;
    }

    private static IScopesStorage createInternal(LoadClass loadClass, ILogger iLogger) {
        Class clsLoadClass;
        if (Platform.isJvm() && loadClass.isClassAvailable("io.sentry.opentelemetry.OtelContextScopesStorage", iLogger) && (clsLoadClass = loadClass.loadClass("io.sentry.opentelemetry.OtelContextScopesStorage", iLogger)) != null) {
            try {
                Object objNewInstance = clsLoadClass.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance != null && (objNewInstance instanceof IScopesStorage)) {
                    return (IScopesStorage) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new DefaultScopesStorage();
    }
}
