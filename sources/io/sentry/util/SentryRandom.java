package io.sentry.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SentryRandom {
    private static final SentryRandomThreadLocal instance = new SentryRandomThreadLocal();

    public static Random current() {
        return (Random) instance.get();
    }

    private static class SentryRandomThreadLocal extends ThreadLocal {
        private SentryRandomThreadLocal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }
}
