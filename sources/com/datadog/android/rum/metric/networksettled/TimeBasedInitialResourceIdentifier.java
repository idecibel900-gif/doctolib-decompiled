package com.datadog.android.rum.metric.networksettled;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeBasedInitialResourceIdentifier implements InitialResourceIdentifier {
    public static final Companion Companion = new Companion(null);
    private final long timeThresholdInMilliseconds;
    private final long timeThresholdInNanoSeconds;

    public TimeBasedInitialResourceIdentifier(long j) {
        this.timeThresholdInMilliseconds = j;
        this.timeThresholdInNanoSeconds = TimeUnit.MILLISECONDS.toNanos(j);
    }

    public /* synthetic */ TimeBasedInitialResourceIdentifier(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 100L : j);
    }

    public final long getTimeThresholdInMilliseconds$dd_sdk_android_rum_release() {
        return this.timeThresholdInMilliseconds;
    }

    @Override // com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier
    public boolean validate(NetworkSettledResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Long viewCreatedTimestamp = context.getViewCreatedTimestamp();
        if (viewCreatedTimestamp != null) {
            if (context.getEventCreatedAtNanos() - viewCreatedTimestamp.longValue() < this.timeThresholdInNanoSeconds) {
                return true;
            }
        }
        return false;
    }

    public final boolean defaultThresholdUsed$dd_sdk_android_rum_release() {
        return 100 == this.timeThresholdInMilliseconds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(TimeBasedInitialResourceIdentifier.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier");
        return this.timeThresholdInNanoSeconds == ((TimeBasedInitialResourceIdentifier) obj).timeThresholdInNanoSeconds;
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
