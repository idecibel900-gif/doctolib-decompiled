package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.ContextUtils;
import io.sentry.internal.modules.ModulesLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public final class AssetsModulesLoader extends ModulesLoader {
    private final Context context;

    public AssetsModulesLoader(Context context, SentryOptions sentryOptions) {
        super(sentryOptions.getLogger());
        this.context = ContextUtils.getApplicationContext(context);
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.internal.modules.AssetsModulesLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getOrLoadModules();
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "AssetsModulesLoader submit failed", th);
        }
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    protected Map loadModules() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("sentry-external-modules.txt");
            try {
                Map stream = parseStream(inputStreamOpen);
                if (inputStreamOpen == null) {
                    return stream;
                }
                inputStreamOpen.close();
                return stream;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            this.logger.log(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error extracting modules.", e);
            return treeMap;
        }
    }
}
