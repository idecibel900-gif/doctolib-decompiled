package expo.modules.core.logging;

import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PersistentFileLogHandler extends LogHandler {
    private final PersistentFileLog persistentFileLog;

    public PersistentFileLogHandler(String category, File filesDirectory) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.persistentFileLog = new PersistentFileLog(category, filesDirectory);
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(LogType type, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        PersistentFileLog.appendEntry$default(this.persistentFileLog, message, null, 2, null);
        if (th != null) {
            PersistentFileLog.appendEntry$default(this.persistentFileLog, LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(th) + "\n" + ExceptionsKt.stackTraceToString(th), null, 2, null);
        }
    }
}
