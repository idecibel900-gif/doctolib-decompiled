package io.sentry;

import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SpanFactoryFactory {
    public static ISpanFactory create(LoadClass loadClass, ILogger iLogger) {
        Class clsLoadClass;
        if (Platform.isJvm() && loadClass.isClassAvailable("io.sentry.opentelemetry.OtelSpanFactory", iLogger) && (clsLoadClass = loadClass.loadClass("io.sentry.opentelemetry.OtelSpanFactory", iLogger)) != null) {
            try {
                Object objNewInstance = clsLoadClass.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance != null && (objNewInstance instanceof ISpanFactory)) {
                    return (ISpanFactory) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new DefaultSpanFactory();
    }
}
