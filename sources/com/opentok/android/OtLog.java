package com.opentok.android;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes4.dex */
public class OtLog {

    public static class LogToken {
        private String caller;
        private final boolean enabled;
        private final String tag;

        public LogToken() {
            this("[" + getCallerClassName() + "]", true);
        }

        private String addCallerReference(String str) {
            if (this.caller == null) {
                return str;
            }
            return str + " [" + this.caller + "] (" + System.currentTimeMillis() + ") {" + Thread.currentThread().getName() + "}";
        }

        private static String appendStackTraceString(String str, Throwable th) {
            StringWriter stringWriter = new StringWriter(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            if (str == null) {
                return stringWriter.toString();
            }
            return str + "\n" + stringWriter.toString();
        }

        private static String getCallerClassName() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = OtLog.class.getName();
            String name2 = LogToken.class.getName();
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!z && stackTraceElement.getClassName().equals(name2)) {
                    z = true;
                } else if (z && !stackTraceElement.getClassName().equals(name2) && !stackTraceElement.getClassName().equals(name)) {
                    try {
                        return Class.forName(stackTraceElement.getClassName()).getSimpleName();
                    } catch (ClassNotFoundException unused) {
                        return stackTraceElement.getClassName();
                    }
                }
            }
            return name;
        }

        public void d(String str, Object... objArr) {
            if (this.enabled) {
                addCallerReference(String.format(str, objArr));
            }
        }

        public void e(String str, Object... objArr) {
            if (this.enabled) {
                addCallerReference(String.format(str, objArr));
            }
        }

        public void i(String str, Object... objArr) {
            if (this.enabled) {
                addCallerReference(String.format(str, objArr));
            }
        }

        public void v(String str, Object... objArr) {
            if (this.enabled) {
                addCallerReference(String.format(str, objArr));
            }
        }

        public void w(String str, Object... objArr) {
            if (this.enabled) {
                addCallerReference(String.format(str, objArr));
            }
        }

        public LogToken(Object obj) {
            this("[" + obj.getClass().getCanonicalName() + "]", true);
            this.caller = obj.toString();
        }

        public void d(Throwable th, String str, Object... objArr) {
            d(appendStackTraceString(str, th), objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            e(appendStackTraceString(str, th), objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            i(appendStackTraceString(str, th), objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            v(appendStackTraceString(str, th), objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            w(appendStackTraceString(str, th), objArr);
        }

        public LogToken(boolean z) {
            this(getCallerClassName(), z);
        }

        public LogToken(String str, boolean z) {
            this.caller = null;
            this.tag = str;
            this.enabled = false;
        }
    }

    public static LogToken LogToken() {
        return new LogToken();
    }

    public static void d(String str, Object... objArr) {
        new LogToken().d(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        new LogToken().e(str, objArr);
    }

    public static void i(String str, Object... objArr) {
        new LogToken().i(str, objArr);
    }

    public static void v(String str, Object... objArr) {
        new LogToken().v(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        new LogToken().w(str, objArr);
    }

    public static LogToken LogToken(String str) {
        return new LogToken(str, true);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        new LogToken().d(th, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        new LogToken().e(th, str, objArr);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        new LogToken().i(th, str, objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        new LogToken().v(th, str, objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        new LogToken().w(th, str, objArr);
    }
}
