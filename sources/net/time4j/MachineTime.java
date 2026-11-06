package net.time4j;

import com.amazon.a.a.o.c.a.b;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import net.time4j.base.MathUtils;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimeSpan;
import net.time4j.scale.TimeScale;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class MachineTime implements TimeSpan, Comparable, Serializable {
    public static final TimeMetric ON_POSIX_SCALE;
    public static final TimeMetric ON_UTC_SCALE;
    private static final MachineTime POSIX_ZERO;
    private static final MachineTime UTC_ZERO;
    private static final long serialVersionUID = -4150291820807606229L;
    private final transient int nanos;
    private final transient TimeScale scale;
    private final transient long seconds;

    static {
        TimeScale timeScale = TimeScale.POSIX;
        POSIX_ZERO = new MachineTime(0L, 0, timeScale);
        TimeScale timeScale2 = TimeScale.UTC;
        UTC_ZERO = new MachineTime(0L, 0, timeScale2);
        ON_POSIX_SCALE = new Metric(timeScale);
        ON_UTC_SCALE = new Metric(timeScale2);
    }

    private MachineTime(long j, int i, TimeScale timeScale) {
        while (i < 0) {
            i += Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            j = MathUtils.safeSubtract(j, 1L);
        }
        while (i >= 1000000000) {
            i -= Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            j = MathUtils.safeAdd(j, 1L);
        }
        if (j < 0 && i > 0) {
            j++;
            i -= Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        }
        this.seconds = j;
        this.nanos = i;
        this.scale = timeScale;
    }

    public static MachineTime ofPosixUnits(long j, int i) {
        if (j == 0 && i == 0) {
            return POSIX_ZERO;
        }
        return new MachineTime(j, i, TimeScale.POSIX);
    }

    public static MachineTime ofSIUnits(long j, int i) {
        if (j == 0 && i == 0) {
            return UTC_ZERO;
        }
        return new MachineTime(j, i, TimeScale.UTC);
    }

    public long getSeconds() {
        long j = this.seconds;
        return this.nanos < 0 ? j - 1 : j;
    }

    public int getFraction() {
        int i = this.nanos;
        return i < 0 ? i + Http2Connection.DEGRADED_PONG_TIMEOUT_NS : i;
    }

    public TimeScale getScale() {
        return this.scale;
    }

    public boolean isNegative() {
        return this.seconds < 0 || this.nanos < 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(MachineTime machineTime) {
        if (this.scale == machineTime.scale) {
            long j = this.seconds;
            long j2 = machineTime.seconds;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.nanos - machineTime.nanos;
        }
        throw new ClassCastException("Different time scales.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MachineTime) {
            MachineTime machineTime = (MachineTime) obj;
            if (this.seconds == machineTime.seconds && this.nanos == machineTime.nanos && this.scale == machineTime.scale) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.seconds;
        return ((((161 + ((int) (j ^ (j >>> 32)))) * 23) + this.nanos) * 23) + this.scale.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        createNumber(sb);
        sb.append("s [");
        sb.append(this.scale.name());
        sb.append(']');
        return sb.toString();
    }

    private void createNumber(StringBuilder sb) {
        if (isNegative()) {
            sb.append('-');
            sb.append(Math.abs(this.seconds));
        } else {
            sb.append(this.seconds);
        }
        if (this.nanos != 0) {
            sb.append(b.a);
            String strValueOf = String.valueOf(Math.abs(this.nanos));
            for (int length = 9 - strValueOf.length(); length > 0; length--) {
                sb.append('0');
            }
            sb.append(strValueOf);
        }
    }

    private Object writeReplace() {
        return new SPX(this, 5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Metric implements TimeMetric {
        private final TimeScale scale;

        private Metric(TimeScale timeScale) {
            this.scale = timeScale;
        }
    }
}
