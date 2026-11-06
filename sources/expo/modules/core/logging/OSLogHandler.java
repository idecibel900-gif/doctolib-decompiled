package expo.modules.core.logging;

import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OSLogHandler extends LogHandler {
    private final String category;

    public OSLogHandler(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.category = category;
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(LogType type, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!OSLogHandlerKt.isAndroid) {
            System.out.println((Object) ("[" + type.getType() + "] " + this.category + "\t" + message));
            if (th != null) {
                System.out.println((Object) (LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(th) + "\n" + ExceptionsKt.stackTraceToString(th)));
                return;
            }
            return;
        }
        LogType.Companion.toOSLogType(type);
    }
}
