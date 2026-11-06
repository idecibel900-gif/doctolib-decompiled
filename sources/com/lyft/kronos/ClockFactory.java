package com.lyft.kronos;

import com.lyft.kronos.internal.KronosClockImpl;
import com.lyft.kronos.internal.ntp.DatagramFactoryImpl;
import com.lyft.kronos.internal.ntp.DnsResolverImpl;
import com.lyft.kronos.internal.ntp.SntpClient;
import com.lyft.kronos.internal.ntp.SntpResponseCacheImpl;
import com.lyft.kronos.internal.ntp.SntpServiceImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ClockFactory {
    public static final ClockFactory INSTANCE = new ClockFactory();

    private ClockFactory() {
    }

    public static final KronosClock createKronosClock(Clock localClock, SyncResponseCache syncResponseCache, SyncListener syncListener, List ntpHosts, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(localClock, "localClock");
        Intrinsics.checkNotNullParameter(syncResponseCache, "syncResponseCache");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        if (localClock instanceof KronosClock) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new KronosClockImpl(new SntpServiceImpl(new SntpClient(localClock, new DnsResolverImpl(), new DatagramFactoryImpl()), localClock, new SntpResponseCacheImpl(syncResponseCache, localClock), syncListener, ntpHosts, j, j2, j3, j4), localClock);
    }
}
