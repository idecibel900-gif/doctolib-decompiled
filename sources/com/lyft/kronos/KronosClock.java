package com.lyft.kronos;

/* JADX INFO: loaded from: classes4.dex */
public interface KronosClock extends Clock {
    KronosTime getCurrentTime();

    void shutdown();

    void syncInBackground();

    public static final class DefaultImpls {
        public static long getCurrentTimeMs(KronosClock kronosClock) {
            return kronosClock.getCurrentTime().getPosixTimeMs();
        }
    }
}
