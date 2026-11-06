package io.sentry.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClassLoaderUtils {
    public static ClassLoader classLoaderOrDefault(ClassLoader classLoader) {
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader : ClassLoader.getSystemClassLoader();
    }
}
