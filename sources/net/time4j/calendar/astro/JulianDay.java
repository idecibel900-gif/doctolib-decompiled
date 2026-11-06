package net.time4j.calendar.astro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.base.MathUtils;
import net.time4j.engine.EpochDays;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;

/* JADX INFO: loaded from: classes5.dex */
public final class JulianDay implements Serializable {
    private static final long serialVersionUID = 486345450973062467L;
    private final TimeScale scale;
    private final double value;

    private JulianDay(double d, TimeScale timeScale) {
        check(d, timeScale);
        this.value = d;
        this.scale = timeScale;
    }

    public static JulianDay ofEphemerisTime(double d) {
        return new JulianDay(d, TimeScale.TT);
    }

    public static JulianDay ofEphemerisTime(Moment moment) {
        TimeScale timeScale = TimeScale.TT;
        return new JulianDay(getValue(moment, timeScale), timeScale);
    }

    public double getValue() {
        return this.value;
    }

    public double getMJD() {
        return this.value - 2400000.5d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JulianDay) {
            JulianDay julianDay = (JulianDay) obj;
            if (this.value == julianDay.value && this.scale == julianDay.scale) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AstroUtils.hashCode(this.value) ^ this.scale.hashCode();
    }

    public String toString() {
        return "JD(" + this.scale.name() + ')' + this.value;
    }

    public Moment toMoment() {
        TimeScale timeScale;
        double dDeltaT = this.value * 86400.0d;
        TimeScale timeScale2 = this.scale;
        if (!LeapSeconds.getInstance().isEnabled() && timeScale2 != (timeScale = TimeScale.POSIX)) {
            if (timeScale2 == TimeScale.TT) {
                PlainDate plainDateOf = PlainDate.of((long) Math.floor(getMJD()), EpochDays.MODIFIED_JULIAN_DATE);
                dDeltaT -= TimeScale.deltaT(plainDateOf.getYear(), plainDateOf.getMonth());
            }
            dDeltaT += 6.3072E7d;
            timeScale2 = timeScale;
        }
        return Moment.of(MathUtils.safeSubtract((long) dDeltaT, jdOffset(timeScale2)), (int) ((dDeltaT - Math.floor(dDeltaT)) * 1.0E9d), timeScale2);
    }

    static double getValue(Moment moment, TimeScale timeScale) {
        return ((moment.getElapsedTime(timeScale) + jdOffset(timeScale)) + (((double) moment.getNanosecond(timeScale)) / 1.0E9d)) / 86400.0d;
    }

    /* JADX INFO: renamed from: net.time4j.calendar.astro.JulianDay$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$scale$TimeScale;

        static {
            int[] iArr = new int[TimeScale.values().length];
            $SwitchMap$net$time4j$scale$TimeScale = iArr;
            try {
                iArr[TimeScale.UT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.TT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.POSIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static long jdOffset(TimeScale timeScale) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()];
        if (i == 1 || i == 2) {
            return 210929832000L;
        }
        if (i == 3) {
            return 210866760000L;
        }
        throw new UnsupportedOperationException(timeScale.name());
    }

    private static void check(double d, TimeScale timeScale) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Value is not finite: " + d);
        }
        int i = AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            if (Double.compare(990575.0d, d) > 0 || Double.compare(d, 2817152.0d) > 0) {
                throw new IllegalArgumentException("Out of range: " + d);
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported time scale: " + timeScale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        try {
            objectInputStream.defaultReadObject();
            check(this.value, this.scale);
        } catch (ClassNotFoundException unused) {
            throw new StreamCorruptedException();
        } catch (IllegalArgumentException unused2) {
            throw new StreamCorruptedException();
        }
    }
}
