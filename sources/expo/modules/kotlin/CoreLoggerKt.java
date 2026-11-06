package expo.modules.kotlin;

import expo.modules.core.logging.LogHandlers;
import expo.modules.core.logging.Logger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CoreLoggerKt {
    private static final Logger logger = new Logger(CollectionsKt.listOf(LogHandlers.INSTANCE.createOSLogHandler("ExpoModulesCore")));

    public static final Logger getLogger() {
        return logger;
    }
}
