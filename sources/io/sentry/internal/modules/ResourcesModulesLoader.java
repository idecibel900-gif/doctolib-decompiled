package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.ClassLoaderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ResourcesModulesLoader extends ModulesLoader {
    private final ClassLoader classLoader;

    public ResourcesModulesLoader(ILogger iLogger) {
        this(iLogger, ResourcesModulesLoader.class.getClassLoader());
    }

    ResourcesModulesLoader(ILogger iLogger, ClassLoader classLoader) {
        super(iLogger);
        this.classLoader = ClassLoaderUtils.classLoaderOrDefault(classLoader);
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    protected Map loadModules() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream resourceAsStream = this.classLoader.getResourceAsStream("sentry-external-modules.txt");
            try {
                if (resourceAsStream == null) {
                    this.logger.log(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                        return treeMap;
                    }
                    return treeMap;
                }
                Map stream = parseStream(resourceAsStream);
                resourceAsStream.close();
                return stream;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            this.logger.log(SentryLevel.INFO, "Access to resources failed.", e);
        } catch (SecurityException e2) {
            this.logger.log(SentryLevel.INFO, "Access to resources denied.", e2);
        }
    }
}
