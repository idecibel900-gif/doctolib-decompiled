package com.lyft.kronos;

import android.content.Context;
import android.content.SharedPreferences;
import com.lyft.kronos.internal.AndroidSystemClock;
import com.lyft.kronos.internal.SharedPreferenceSyncResponseCache;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidClockFactory {
    public static final AndroidClockFactory INSTANCE = new AndroidClockFactory();

    private AndroidClockFactory() {
    }

    public static final Clock createDeviceClock() {
        return new AndroidSystemClock();
    }

    public static /* synthetic */ KronosClock createKronosClock$default(Context context, SyncListener syncListener, List list, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 2) != 0) {
            syncListener = null;
        }
        if ((i & 4) != 0) {
            list = DefaultParam.INSTANCE.getNTP_HOSTS();
        }
        if ((i & 8) != 0) {
            j = DefaultParam.INSTANCE.getTIMEOUT_MS();
        }
        if ((i & 16) != 0) {
            j2 = DefaultParam.INSTANCE.getMIN_WAIT_TIME_BETWEEN_SYNC_MS();
        }
        if ((i & 32) != 0) {
            j3 = DefaultParam.INSTANCE.getCACHE_EXPIRATION_MS();
        }
        if ((i & 64) != 0) {
            j4 = DefaultParam.INSTANCE.getMAX_NTP_RESPONSE_TIME_MS();
        }
        long j5 = j4;
        long j6 = j3;
        long j7 = j2;
        return createKronosClock(context, syncListener, list, j, j7, j6, j5);
    }

    public static final KronosClock createKronosClock(Context context, SyncListener syncListener, List ntpHosts, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ntpHosts, "ntpHosts");
        Clock clockCreateDeviceClock = createDeviceClock();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.lyft.kronos.shared_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return ClockFactory.createKronosClock(clockCreateDeviceClock, new SharedPreferenceSyncResponseCache(sharedPreferences), syncListener, ntpHosts, j, j2, j3, j4);
    }
}
