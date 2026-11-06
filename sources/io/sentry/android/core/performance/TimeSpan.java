package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.DateUtils;
import io.sentry.SentryDate;
import io.sentry.SentryLongDate;

/* JADX INFO: loaded from: classes5.dex */
public class TimeSpan implements Comparable {
    private String description;
    private long startUnixTimeMs;
    private long startUptimeMs;
    private long stopUptimeMs;

    public void setup(String str, long j, long j2, long j3) {
        this.description = str;
        this.startUnixTimeMs = j;
        this.startUptimeMs = j2;
        this.stopUptimeMs = j3;
    }

    public void setStartedAt(long j) {
        this.startUptimeMs = j;
        this.startUnixTimeMs = System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.startUptimeMs);
    }

    public void stop() {
        this.stopUptimeMs = SystemClock.uptimeMillis();
    }

    public boolean hasStarted() {
        return this.startUptimeMs != 0;
    }

    public boolean hasNotStarted() {
        return this.startUptimeMs == 0;
    }

    public boolean hasStopped() {
        return this.stopUptimeMs != 0;
    }

    public boolean hasNotStopped() {
        return this.stopUptimeMs == 0;
    }

    public long getStartUptimeMs() {
        return this.startUptimeMs;
    }

    public long getStartTimestampMs() {
        return this.startUnixTimeMs;
    }

    public SentryDate getStartTimestamp() {
        if (hasStarted()) {
            return new SentryLongDate(DateUtils.millisToNanos(getStartTimestampMs()));
        }
        return null;
    }

    public double getStartTimestampSecs() {
        return DateUtils.millisToSeconds(this.startUnixTimeMs);
    }

    public long getProjectedStopTimestampMs() {
        if (hasStarted()) {
            return this.startUnixTimeMs + getDurationMs();
        }
        return 0L;
    }

    public double getProjectedStopTimestampSecs() {
        return DateUtils.millisToSeconds(getProjectedStopTimestampMs());
    }

    public SentryDate getProjectedStopTimestamp() {
        if (hasStopped()) {
            return new SentryLongDate(DateUtils.millisToNanos(getProjectedStopTimestampMs()));
        }
        return null;
    }

    public long getDurationMs() {
        if (hasStopped()) {
            return this.stopUptimeMs - this.startUptimeMs;
        }
        return 0L;
    }

    public String getDescription() {
        return this.description;
    }

    public void reset() {
        this.description = null;
        this.startUptimeMs = 0L;
        this.stopUptimeMs = 0L;
        this.startUnixTimeMs = 0L;
    }

    @Override // java.lang.Comparable
    public int compareTo(TimeSpan timeSpan) {
        return Long.compare(this.startUnixTimeMs, timeSpan.startUnixTimeMs);
    }
}
