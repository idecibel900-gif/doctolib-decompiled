package io.sentry.internal.modules;

import com.adjust.sdk.Constants;
import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryLevel;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ModulesLoader implements IModulesLoader {
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    protected final ILogger logger;
    private final AutoClosableReentrantLock modulesLock = new AutoClosableReentrantLock();
    private volatile Map cachedModules = null;

    protected abstract Map loadModules();

    public ModulesLoader(ILogger iLogger) {
        this.logger = iLogger;
    }

    @Override // io.sentry.internal.modules.IModulesLoader
    public Map getOrLoadModules() {
        if (this.cachedModules == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.modulesLock.acquire();
            try {
                if (this.cachedModules == null) {
                    this.cachedModules = loadModules();
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return this.cachedModules;
    }

    protected Map parseStream(InputStream inputStream) {
        TreeMap treeMap = new TreeMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    int iLastIndexOf = line.lastIndexOf(58);
                    treeMap.put(line.substring(0, iLastIndexOf), line.substring(iLastIndexOf + 1));
                }
                this.logger.log(SentryLevel.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
                bufferedReader.close();
                return treeMap;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error extracting modules.", e);
            return treeMap;
        } catch (RuntimeException e2) {
            this.logger.log(SentryLevel.ERROR, e2, "%s file is malformed.", "sentry-external-modules.txt");
            return treeMap;
        }
    }
}
