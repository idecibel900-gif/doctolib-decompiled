package com.lyft.kronos.internal;

import com.lyft.kronos.Clock;
import com.lyft.kronos.KronosClock;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.internal.ntp.SntpService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KronosClockImpl implements KronosClock {
    private final Clock fallbackClock;
    private final SntpService ntpService;

    public KronosClockImpl(SntpService ntpService, Clock fallbackClock) {
        Intrinsics.checkNotNullParameter(ntpService, "ntpService");
        Intrinsics.checkNotNullParameter(fallbackClock, "fallbackClock");
        this.ntpService = ntpService;
        this.fallbackClock = fallbackClock;
    }

    @Override // com.lyft.kronos.Clock
    public long getCurrentTimeMs() {
        return KronosClock.DefaultImpls.getCurrentTimeMs(this);
    }

    @Override // com.lyft.kronos.KronosClock
    public void syncInBackground() {
        this.ntpService.syncInBackground();
    }

    @Override // com.lyft.kronos.KronosClock
    public void shutdown() {
        this.ntpService.shutdown();
    }

    @Override // com.lyft.kronos.Clock
    public long getElapsedTimeMs() {
        return this.fallbackClock.getElapsedTimeMs();
    }

    @Override // com.lyft.kronos.KronosClock
    public KronosTime getCurrentTime() {
        KronosTime kronosTimeCurrentTime = this.ntpService.currentTime();
        return kronosTimeCurrentTime != null ? kronosTimeCurrentTime : new KronosTime(this.fallbackClock.getCurrentTimeMs(), null);
    }
}
