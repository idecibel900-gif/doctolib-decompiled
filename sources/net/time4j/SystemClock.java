package net.time4j;

import java.util.Iterator;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.TimeSource;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TickProvider;
import net.time4j.scale.TimeScale;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class SystemClock implements TimeSource {
    public static final SystemClock INSTANCE;
    public static final SystemClock MONOTONIC;
    private static final boolean MONOTON_MODE;
    private static final TickProvider PROVIDER;
    private final boolean monotonic;
    private final long offset;

    static {
        TickProvider stdTickProvider;
        String property = System.getProperty("java.vm.name");
        Iterator it = ResourceLoader.getInstance().services(TickProvider.class).iterator();
        do {
            if (!it.hasNext()) {
                stdTickProvider = null;
                break;
            }
            stdTickProvider = (TickProvider) it.next();
        } while (!property.equals(stdTickProvider.getPlatform()));
        if (stdTickProvider == null) {
            stdTickProvider = new StdTickProvider();
        }
        PROVIDER = stdTickProvider;
        MONOTON_MODE = Boolean.getBoolean("net.time4j.systemclock.nanoTime");
        INSTANCE = new SystemClock(false, calibrate());
        MONOTONIC = new SystemClock(true, calibrate());
    }

    private SystemClock(boolean z, long j) {
        this.monotonic = z;
        this.offset = j;
    }

    public Moment currentTime() {
        if ((this.monotonic || MONOTON_MODE) && LeapSeconds.getInstance().isEnabled()) {
            long jUtcNanos = utcNanos();
            return Moment.of(MathUtils.floorDivide(jUtcNanos, Http2Connection.DEGRADED_PONG_TIMEOUT_NS), MathUtils.floorModulo(jUtcNanos, Http2Connection.DEGRADED_PONG_TIMEOUT_NS), TimeScale.UTC);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        return Moment.of(MathUtils.floorDivide(jCurrentTimeMillis, 1000), MathUtils.floorModulo(jCurrentTimeMillis, 1000) * 1000000, TimeScale.POSIX);
    }

    public static Moment currentMoment() {
        return INSTANCE.currentTime();
    }

    private static long calibrate() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jNanoTime = 0;
        int i = 0;
        while (i < 10) {
            jNanoTime = MONOTON_MODE ? System.nanoTime() : PROVIDER.getNanos();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (jCurrentTimeMillis == jCurrentTimeMillis2) {
                break;
            }
            i++;
            jCurrentTimeMillis = jCurrentTimeMillis2;
        }
        return MathUtils.safeSubtract(MathUtils.safeMultiply(LeapSeconds.getInstance().enhance(MathUtils.floorDivide(jCurrentTimeMillis, 1000)), 1000000000L) + ((long) (MathUtils.floorModulo(jCurrentTimeMillis, 1000) * 1000000)), jNanoTime);
    }

    private long utcNanos() {
        return MathUtils.safeAdd(MONOTON_MODE ? System.nanoTime() : PROVIDER.getNanos(), this.offset);
    }

    private static class StdTickProvider implements TickProvider {
        private StdTickProvider() {
        }

        @Override // net.time4j.scale.TickProvider
        public String getPlatform() {
            return "";
        }

        @Override // net.time4j.scale.TickProvider
        public long getNanos() {
            return System.nanoTime();
        }
    }
}
