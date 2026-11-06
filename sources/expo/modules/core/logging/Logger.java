package expo.modules.core.logging;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class Logger {
    private final List logHandlers;
    private final int minOSLevel;

    public Logger(List logHandlers) {
        Intrinsics.checkNotNullParameter(logHandlers, "logHandlers");
        this.logHandlers = logHandlers;
        this.minOSLevel = 4;
    }

    public final void debug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Debug, message, null, 4, null);
    }

    public final void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Info, message, null, 4, null);
    }

    public static /* synthetic */ void warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.warn(str, th);
    }

    public final void warn(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Warn, message, th);
    }

    public static /* synthetic */ void error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.error(str, th);
    }

    public final void error(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Error, message, th);
    }

    public final LoggerTimer startTimer(final Function1 logFormatter) {
        Intrinsics.checkNotNullParameter(logFormatter, "logFormatter");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return new LoggerTimer() { // from class: expo.modules.core.logging.Logger.startTimer.1
            @Override // expo.modules.core.logging.LoggerTimer
            /* JADX INFO: renamed from: stop-UwyO8pc, reason: not valid java name */
            public long mo4876stopUwyO8pc() {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                Logger.log$default(this, LogType.Timer, (String) logFormatter.invoke(Long.valueOf(jCurrentTimeMillis2)), null, 4, null);
                return DurationKt.toDuration(jCurrentTimeMillis2, DurationUnit.MILLISECONDS);
            }
        };
    }

    static /* synthetic */ void log$default(Logger logger, LogType logType, String str, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.log(logType, str, th);
    }

    private final void log(LogType logType, String str, Throwable th) {
        if (LogType.Companion.toOSLogType(logType) >= this.minOSLevel) {
            Iterator it = this.logHandlers.iterator();
            while (it.hasNext()) {
                ((LogHandler) it.next()).log$expo_modules_core_release(logType, str, th);
            }
        }
    }
}
