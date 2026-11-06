package expo.modules.core.logging;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LogHandlers {
    public static final LogHandlers INSTANCE = new LogHandlers();

    private LogHandlers() {
    }

    public final LogHandler createOSLogHandler(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return new OSLogHandler(category);
    }

    public final LogHandler createPersistentFileLogHandler(File filesDirectory, String category) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        Intrinsics.checkNotNullParameter(category, "category");
        return new PersistentFileLogHandler(category, filesDirectory);
    }
}
