package com.datadog.android.core.feature.event;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmCrash {
    public /* synthetic */ JvmCrash(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JvmCrash() {
    }

    public static final class Logs extends JvmCrash {
        private final String loggerName;
        private final String message;
        private final String threadName;
        private final List threads;
        private final Throwable throwable;
        private final long timestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Logs)) {
                return false;
            }
            Logs logs = (Logs) obj;
            return Intrinsics.areEqual(this.threadName, logs.threadName) && Intrinsics.areEqual(this.throwable, logs.throwable) && this.timestamp == logs.timestamp && Intrinsics.areEqual(this.message, logs.message) && Intrinsics.areEqual(this.loggerName, logs.loggerName) && Intrinsics.areEqual(this.threads, logs.threads);
        }

        public int hashCode() {
            return (((((((((this.threadName.hashCode() * 31) + this.throwable.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.message.hashCode()) * 31) + this.loggerName.hashCode()) * 31) + this.threads.hashCode();
        }

        public String toString() {
            return "Logs(threadName=" + this.threadName + ", throwable=" + this.throwable + ", timestamp=" + this.timestamp + ", message=" + this.message + ", loggerName=" + this.loggerName + ", threads=" + this.threads + ")";
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public String getMessage() {
            return this.message;
        }

        public final String getLoggerName() {
            return this.loggerName;
        }

        public List getThreads() {
            return this.threads;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Logs(String threadName, Throwable throwable, long j, String message, String loggerName, List threads) {
            super(null);
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(loggerName, "loggerName");
            Intrinsics.checkNotNullParameter(threads, "threads");
            this.threadName = threadName;
            this.throwable = throwable;
            this.timestamp = j;
            this.message = message;
            this.loggerName = loggerName;
            this.threads = threads;
        }
    }

    public static final class Rum extends JvmCrash {
        private final String message;
        private final List threads;
        private final Throwable throwable;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rum)) {
                return false;
            }
            Rum rum = (Rum) obj;
            return Intrinsics.areEqual(this.throwable, rum.throwable) && Intrinsics.areEqual(this.message, rum.message) && Intrinsics.areEqual(this.threads, rum.threads);
        }

        public int hashCode() {
            return (((this.throwable.hashCode() * 31) + this.message.hashCode()) * 31) + this.threads.hashCode();
        }

        public String toString() {
            return "Rum(throwable=" + this.throwable + ", message=" + this.message + ", threads=" + this.threads + ")";
        }

        public Throwable getThrowable() {
            return this.throwable;
        }

        public String getMessage() {
            return this.message;
        }

        public List getThreads() {
            return this.threads;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rum(Throwable throwable, String message, List threads) {
            super(null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(threads, "threads");
            this.throwable = throwable;
            this.message = message;
            this.threads = threads;
        }
    }
}
