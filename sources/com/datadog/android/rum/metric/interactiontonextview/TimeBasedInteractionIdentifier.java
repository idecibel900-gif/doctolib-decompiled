package com.datadog.android.rum.metric.interactiontonextview;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeBasedInteractionIdentifier implements LastInteractionIdentifier {
    public static final Companion Companion = new Companion(null);
    private final long timeThresholdInMilliseconds;
    private final long timeThresholdInNanoSeconds;

    public TimeBasedInteractionIdentifier(long j) {
        this.timeThresholdInMilliseconds = j;
        this.timeThresholdInNanoSeconds = TimeUnit.MILLISECONDS.toNanos(j);
    }

    public /* synthetic */ TimeBasedInteractionIdentifier(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 3000L : j);
    }

    public final long getTimeThresholdInMilliseconds$dd_sdk_android_rum_release() {
        return this.timeThresholdInMilliseconds;
    }

    @Override // com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier
    public boolean validate(PreviousViewLastInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Long currentViewCreationTimestamp = context.getCurrentViewCreationTimestamp();
        return currentViewCreationTimestamp != null && currentViewCreationTimestamp.longValue() - context.getEventCreatedAtNanos() < this.timeThresholdInNanoSeconds;
    }

    public final boolean defaultThresholdUsed$dd_sdk_android_rum_release() {
        return 3000 == this.timeThresholdInMilliseconds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(TimeBasedInteractionIdentifier.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier");
        return this.timeThresholdInNanoSeconds == ((TimeBasedInteractionIdentifier) obj).timeThresholdInNanoSeconds;
    }

    public int hashCode() {
        return Long.hashCode(this.timeThresholdInNanoSeconds);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
