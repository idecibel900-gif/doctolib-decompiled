package com.datadog.android.rum.internal.metric;

import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.model.ViewEvent;
import com.facebook.react.modules.appstate.AppStateModule;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class SessionEndedMetric {
    public static final Companion Companion = new Companion(null);
    private final Map errorKindFrequencies;
    private TrackedView firstTrackedView;
    private final boolean hasTrackBackgroundEventsEnabled;
    private TrackedView lastTrackedView;
    private final Map missedEventCountByType;
    private final long ntpOffsetAtStartMs;
    private final String sessionId;
    private final AtomicInteger sessionReplaySkippedFramesCount;
    private final RumSessionScope.StartReason startReason;
    private final Map trackedViewsById;
    private boolean wasStopped;

    public SessionEndedMetric(String sessionId, RumSessionScope.StartReason startReason, long j, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(startReason, "startReason");
        this.sessionId = sessionId;
        this.startReason = startReason;
        this.ntpOffsetAtStartMs = j;
        this.hasTrackBackgroundEventsEnabled = z;
        this.trackedViewsById = new LinkedHashMap();
        this.errorKindFrequencies = new LinkedHashMap();
        this.missedEventCountByType = new LinkedHashMap();
        this.sessionReplaySkippedFramesCount = new AtomicInteger(0);
    }

    public final boolean onViewTracked(ViewEvent rumViewEvent) {
        String url;
        Intrinsics.checkNotNullParameter(rumViewEvent, "rumViewEvent");
        if (!Intrinsics.areEqual(rumViewEvent.getSession().getId(), this.sessionId)) {
            return false;
        }
        TrackedView trackedView = (TrackedView) this.trackedViewsById.get(rumViewEvent.getView().getId());
        if (trackedView == null || (url = trackedView.getViewUrl()) == null) {
            url = rumViewEvent.getView().getUrl();
        }
        String str = url;
        TrackedView trackedView2 = (TrackedView) this.trackedViewsById.get(rumViewEvent.getView().getId());
        long startMs = trackedView2 != null ? trackedView2.getStartMs() : rumViewEvent.getDate();
        long timeSpent = rumViewEvent.getView().getTimeSpent();
        Boolean hasReplay = rumViewEvent.getSession().getHasReplay();
        TrackedView trackedView3 = new TrackedView(str, startMs, timeSpent, hasReplay != null ? hasReplay.booleanValue() : false);
        this.trackedViewsById.put(rumViewEvent.getView().getId(), trackedView3);
        if (this.firstTrackedView == null) {
            this.firstTrackedView = trackedView3;
        }
        this.lastTrackedView = trackedView3;
        return true;
    }

    public final void onErrorTracked(String str) {
        if (str == null) {
            str = "Empty error kind";
        }
        Map map = this.errorKindFrequencies;
        Integer num = (Integer) map.get(str);
        map.put(str, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void onSessionStopped() {
        this.wasStopped = true;
    }

    public final void onMissedEventTracked(MissedEventType missedEventType) {
        Intrinsics.checkNotNullParameter(missedEventType, "missedEventType");
        Map map = this.missedEventCountByType;
        Integer num = (Integer) map.get(missedEventType);
        map.put(missedEventType, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void onSessionReplaySkippedFrameTracked() {
        this.sessionReplaySkippedFramesCount.incrementAndGet();
    }

    public final Map toMetricAttributes(long j) {
        return MapsKt.mapOf(TuplesKt.to("metric_type", "rum session ended"), TuplesKt.to("rse", resolveRseAttributes(j)));
    }

    private final long calculateDuration() {
        TrackedView trackedView = this.lastTrackedView;
        if (trackedView == null) {
            return 0L;
        }
        TrackedView trackedView2 = this.firstTrackedView;
        Long lValueOf = trackedView2 != null ? Long.valueOf(TimeUnit.MILLISECONDS.toNanos(trackedView.getStartMs() - trackedView2.getStartMs()) + trackedView.getDurationNs()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    private final Map resolveRseAttributes(long j) {
        return MapsKt.mapOf(TuplesKt.to("process_type", "app"), TuplesKt.to("precondition", this.startReason.getAsString()), TuplesKt.to("duration", Long.valueOf(calculateDuration())), TuplesKt.to("was_stopped", Boolean.valueOf(this.wasStopped)), TuplesKt.to("views_count", resolveViewCountsAttributes()), TuplesKt.to("sdk_errors_count", resolveSDKErrorsCountAttributes()), TuplesKt.to("no_view_events_count", resolveNoViewCountsAttributes()), TuplesKt.to("has_background_events_tracking_enabled", Boolean.valueOf(this.hasTrackBackgroundEventsEnabled)), TuplesKt.to("ntp_offset", resolveNtpOffsetAttributes(j)), TuplesKt.to("sr_skipped_frames_count", Integer.valueOf(this.sessionReplaySkippedFramesCount.get())));
    }

    private final Map resolveNoViewCountsAttributes() {
        Integer num = (Integer) this.missedEventCountByType.get(MissedEventType.ACTION);
        Pair pair = TuplesKt.to("actions", Integer.valueOf(num != null ? num.intValue() : 0));
        Integer num2 = (Integer) this.missedEventCountByType.get(MissedEventType.RESOURCE);
        Pair pair2 = TuplesKt.to("resources", Integer.valueOf(num2 != null ? num2.intValue() : 0));
        Integer num3 = (Integer) this.missedEventCountByType.get(MissedEventType.ERROR);
        Pair pair3 = TuplesKt.to("errors", Integer.valueOf(num3 != null ? num3.intValue() : 0));
        Integer num4 = (Integer) this.missedEventCountByType.get(MissedEventType.LONG_TASK);
        return MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("long_tasks", Integer.valueOf(num4 != null ? num4.intValue() : 0)));
    }

    private final Map resolveNtpOffsetAttributes(long j) {
        return MapsKt.mapOf(TuplesKt.to("at_start", Long.valueOf(this.ntpOffsetAtStartMs)), TuplesKt.to("at_end", Long.valueOf(j)));
    }

    private final Map resolveViewCountsAttributes() {
        int i;
        int i2;
        Pair pair = TuplesKt.to("total", Integer.valueOf(this.trackedViewsById.size()));
        Collection collectionValues = this.trackedViewsById.values();
        int i3 = 0;
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            i = 0;
        } else {
            Iterator it = collectionValues.iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((TrackedView) it.next()).getViewUrl(), "com/datadog/background/view") && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        Pair pair2 = TuplesKt.to(AppStateModule.APP_STATE_BACKGROUND, Integer.valueOf(i));
        Collection collectionValues2 = this.trackedViewsById.values();
        if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
            i2 = 0;
        } else {
            Iterator it2 = collectionValues2.iterator();
            i2 = 0;
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((TrackedView) it2.next()).getViewUrl(), "com/datadog/application-launch/view") && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        Pair pair3 = TuplesKt.to("app_launch", Integer.valueOf(i2));
        Collection collectionValues3 = this.trackedViewsById.values();
        if (!(collectionValues3 instanceof Collection) || !collectionValues3.isEmpty()) {
            Iterator it3 = collectionValues3.iterator();
            while (it3.hasNext()) {
                if (((TrackedView) it3.next()).getHasReplay() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("with_has_replay", Integer.valueOf(i3)));
    }

    private final Map resolveSDKErrorsCountAttributes() {
        return MapsKt.mapOf(TuplesKt.to("total", Integer.valueOf(CollectionsKt.sumOfInt(this.errorKindFrequencies.values()))), TuplesKt.to("by_kind", resolveTop5ErrorsByKind()));
    }

    private final Map resolveTop5ErrorsByKind() {
        List<Map.Entry> listSubList = CollectionsKt.sortedWith(this.errorKindFrequencies.entrySet(), new Comparator() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetric$resolveTop5ErrorsByKind$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.compareValues((Integer) ((Map.Entry) obj2).getValue(), (Integer) ((Map.Entry) obj).getValue());
            }
        }).subList(0, RangesKt.coerceAtMost(5, this.errorKindFrequencies.size()));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSubList, 10)), 16));
        for (Map.Entry entry : listSubList) {
            Pair pair = TuplesKt.to(escapeNonAlphanumericCharacters((String) entry.getKey()), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final String escapeNonAlphanumericCharacters(String str) {
        return new Regex("[^\\w']+").replace(str, "_");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final class TrackedView {
        private final long durationNs;
        private final boolean hasReplay;
        private final long startMs;
        private final String viewUrl;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TrackedView)) {
                return false;
            }
            TrackedView trackedView = (TrackedView) obj;
            return Intrinsics.areEqual(this.viewUrl, trackedView.viewUrl) && this.startMs == trackedView.startMs && this.durationNs == trackedView.durationNs && this.hasReplay == trackedView.hasReplay;
        }

        public int hashCode() {
            return (((((this.viewUrl.hashCode() * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationNs)) * 31) + Boolean.hashCode(this.hasReplay);
        }

        public String toString() {
            return "TrackedView(viewUrl=" + this.viewUrl + ", startMs=" + this.startMs + ", durationNs=" + this.durationNs + ", hasReplay=" + this.hasReplay + ")";
        }

        public TrackedView(String viewUrl, long j, long j2, boolean z) {
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            this.viewUrl = viewUrl;
            this.startMs = j;
            this.durationNs = j2;
            this.hasReplay = z;
        }

        public final String getViewUrl() {
            return this.viewUrl;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final boolean getHasReplay() {
            return this.hasReplay;
        }
    }

    public enum MissedEventType {
        ACTION,
        RESOURCE,
        ERROR,
        LONG_TASK;

        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final MissedEventType fromRawEvent(RumRawEvent rawEvent) {
                Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
                if (rawEvent instanceof RumRawEvent.AddError) {
                    return MissedEventType.ERROR;
                }
                if (rawEvent instanceof RumRawEvent.StartAction) {
                    return MissedEventType.ACTION;
                }
                if (rawEvent instanceof RumRawEvent.StartResource) {
                    return MissedEventType.RESOURCE;
                }
                if (rawEvent instanceof RumRawEvent.AddLongTask) {
                    return MissedEventType.LONG_TASK;
                }
                return null;
            }
        }
    }
}
