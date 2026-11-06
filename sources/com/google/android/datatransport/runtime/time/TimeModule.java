package com.google.android.datatransport.runtime.time;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TimeModule {
    static Clock eventClock() {
        return new WallTimeClock();
    }

    static Clock uptimeClock() {
        return new UptimeClock();
    }
}
