package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponents;

/* JADX INFO: loaded from: classes5.dex */
public interface Logger {
    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    public static class SystemOutLogger implements Logger {
        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    public static class Default {
        public static Logger get() {
            if (AndroidComponents.areAvailable()) {
                return AndroidComponents.get().logger;
            }
            return new SystemOutLogger();
        }
    }
}
