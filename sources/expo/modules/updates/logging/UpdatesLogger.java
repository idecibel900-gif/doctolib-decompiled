package expo.modules.updates.logging;

import expo.modules.core.logging.LogHandler;
import expo.modules.core.logging.LogHandlers;
import expo.modules.core.logging.LogType;
import expo.modules.core.logging.Logger;
import expo.modules.core.logging.LoggerTimer;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesLogger implements IUpdatesLogger {
    public static final Companion Companion = new Companion(null);
    private final Logger logger;

    public UpdatesLogger(File filesDirectory) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        LogHandlers logHandlers = LogHandlers.INSTANCE;
        this.logger = new Logger(CollectionsKt.listOf((Object[]) new LogHandler[]{logHandlers.createOSLogHandler("dev.expo.updates"), logHandlers.createPersistentFileLogHandler(filesDirectory, "dev.expo.updates")}));
    }

    public static /* synthetic */ void debug$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.debug(str, updatesErrorCode);
    }

    public final void debug(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        debug(message, code, null, null);
    }

    public final void debug(String message, UpdatesErrorCode code, String str, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.debug(logEntryString(message, code, LogType.Debug, null, str, str2));
    }

    public static /* synthetic */ void info$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.info(str, updatesErrorCode);
    }

    public final void info(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        info(message, code, null, null);
    }

    public final void info(String message, UpdatesErrorCode code, String str, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.info(logEntryString(message, code, LogType.Info, null, str, str2));
    }

    public static /* synthetic */ void warn$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.warn(str, updatesErrorCode);
    }

    public final void warn(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        warn(message, code, null, null);
    }

    public final void warn(String message, UpdatesErrorCode code, String str, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.warn$default(this.logger, logEntryString(message, code, LogType.Warn, null, str, str2), null, 2, null);
    }

    public static /* synthetic */ void error$default(UpdatesLogger updatesLogger, String str, Exception exc, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 4) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.error(str, exc, updatesErrorCode);
    }

    public final void error(String message, Exception cause, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(code, "code");
        error(message, cause, code, null, null);
    }

    public final void error(String message, Exception cause, UpdatesErrorCode code, String str, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.error$default(this.logger, logEntryWithCauseExceptionString(message, cause, code, LogType.Error, null, str, str2), null, 2, null);
    }

    @Override // expo.modules.updates.logging.IUpdatesLogger
    public LoggerTimer startTimer(final String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return this.logger.startTimer(new Function1() { // from class: expo.modules.updates.logging.UpdatesLogger$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesLogger.startTimer$lambda$0(this.f$0, label, ((Long) obj).longValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String startTimer$lambda$0(UpdatesLogger updatesLogger, String str, long j) {
        return updatesLogger.logEntryString(str, UpdatesErrorCode.None, LogType.Timer, Long.valueOf(j), null, null);
    }

    private final String logEntryWithCauseExceptionString(String str, Exception exc, UpdatesErrorCode updatesErrorCode, LogType logType, Long l, String str2, String str3) {
        long time = new Date().getTime();
        String code = updatesErrorCode.getCode();
        String type = logType.getType();
        StackTraceElement[] stackTrace = exc.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        List listTake = ArraysKt.take(stackTrace, 20);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            String string = ((StackTraceElement) it.next()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            arrayList.add(string);
        }
        return new UpdatesLogEntry(time, str, code, type, l, str2, str3, arrayList).asString();
    }

    private final String logEntryString(String str, UpdatesErrorCode updatesErrorCode, LogType logType, Long l, String str2, String str3) {
        return new UpdatesLogEntry(new Date().getTime(), str, updatesErrorCode.getCode(), logType.getType(), l, str2, str3, null).asString();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
