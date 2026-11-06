package io.sentry.android.replay;

import io.sentry.SentryReplayEvent;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class LastSegmentData {
    private final ReplayCache cache;
    private final long duration;
    private final List events;
    private final int id;
    private final ScreenshotRecorderConfig recorderConfig;
    private final SentryReplayEvent.ReplayType replayType;
    private final String screenAtStart;
    private final Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastSegmentData)) {
            return false;
        }
        LastSegmentData lastSegmentData = (LastSegmentData) obj;
        return Intrinsics.areEqual(this.recorderConfig, lastSegmentData.recorderConfig) && Intrinsics.areEqual(this.cache, lastSegmentData.cache) && Intrinsics.areEqual(this.timestamp, lastSegmentData.timestamp) && this.id == lastSegmentData.id && this.duration == lastSegmentData.duration && this.replayType == lastSegmentData.replayType && Intrinsics.areEqual(this.screenAtStart, lastSegmentData.screenAtStart) && Intrinsics.areEqual(this.events, lastSegmentData.events);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.recorderConfig.hashCode() * 31) + this.cache.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + Long.hashCode(this.duration)) * 31) + this.replayType.hashCode()) * 31;
        String str = this.screenAtStart;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.events.hashCode();
    }

    public String toString() {
        return "LastSegmentData(recorderConfig=" + this.recorderConfig + ", cache=" + this.cache + ", timestamp=" + this.timestamp + ", id=" + this.id + ", duration=" + this.duration + ", replayType=" + this.replayType + ", screenAtStart=" + this.screenAtStart + ", events=" + this.events + ')';
    }

    public LastSegmentData(ScreenshotRecorderConfig recorderConfig, ReplayCache cache, Date timestamp, int i, long j, SentryReplayEvent.ReplayType replayType, String str, List events) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(replayType, "replayType");
        Intrinsics.checkNotNullParameter(events, "events");
        this.recorderConfig = recorderConfig;
        this.cache = cache;
        this.timestamp = timestamp;
        this.id = i;
        this.duration = j;
        this.replayType = replayType;
        this.screenAtStart = str;
        this.events = events;
    }

    public final ScreenshotRecorderConfig getRecorderConfig() {
        return this.recorderConfig;
    }

    public final ReplayCache getCache() {
        return this.cache;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final int getId() {
        return this.id;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final SentryReplayEvent.ReplayType getReplayType() {
        return this.replayType;
    }

    public final String getScreenAtStart() {
        return this.screenAtStart;
    }

    public final List getEvents() {
        return this.events;
    }
}
