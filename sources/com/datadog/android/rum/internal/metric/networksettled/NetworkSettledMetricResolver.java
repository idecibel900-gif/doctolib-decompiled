package com.datadog.android.rum.internal.metric.networksettled;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.metric.NoValueReason;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsConfig;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsState;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.metric.networksettled.NetworkSettledResourceContext;
import com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkSettledMetricResolver {
    public static final Companion Companion = new Companion(null);
    private volatile Companion.Diagnostic currentViewDiagnostic;
    private final InitialResourceIdentifier initialResourceIdentifier;
    private final InternalLogger internalLogger;
    private volatile Long lastComputedMetric;
    private volatile Long networkSettleMaxValue;
    private final HashSet resourceStartedTimestamps;
    private volatile Long viewCreatedTimestamp;
    private volatile boolean viewWasStopped;

    public NetworkSettledMetricResolver(InitialResourceIdentifier initialResourceIdentifier, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.initialResourceIdentifier = initialResourceIdentifier;
        this.internalLogger = internalLogger;
        this.resourceStartedTimestamps = new HashSet();
        this.currentViewDiagnostic = new Companion.Diagnostic(null, null, null, null, 15, null);
    }

    public final void viewWasCreated(long j) {
        this.viewCreatedTimestamp = Long.valueOf(j);
        this.currentViewDiagnostic = new Companion.Diagnostic(null, null, null, null, 15, null);
    }

    public final void resourceWasStarted(InternalResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.viewWasStopped) {
            return;
        }
        this.currentViewDiagnostic.getStarted().incrementAndGet();
        if (this.initialResourceIdentifier.validate(new NetworkSettledResourceContext(context.getResourceId$dd_sdk_android_rum_release(), context.getEventCreatedAtNanos$dd_sdk_android_rum_release(), this.viewCreatedTimestamp))) {
            this.currentViewDiagnostic.getInitial().incrementAndGet();
            this.resourceStartedTimestamps.add(context.getResourceId$dd_sdk_android_rum_release());
        }
    }

    public final void resourceWasStopped(InternalResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.viewWasStopped) {
            return;
        }
        Long l = this.viewCreatedTimestamp;
        Long l2 = this.networkSettleMaxValue;
        long jLongValue = l2 != null ? l2.longValue() : 0L;
        boolean zRemove = this.resourceStartedTimestamps.remove(context.getResourceId$dd_sdk_android_rum_release());
        if (l == null || !zRemove) {
            return;
        }
        this.currentViewDiagnostic.getStopped().incrementAndGet();
        long eventCreatedAtNanos$dd_sdk_android_rum_release = context.getEventCreatedAtNanos$dd_sdk_android_rum_release() - l.longValue();
        if (eventCreatedAtNanos$dd_sdk_android_rum_release > jLongValue) {
            this.networkSettleMaxValue = Long.valueOf(eventCreatedAtNanos$dd_sdk_android_rum_release);
        }
    }

    public final void resourceWasDropped(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        if (this.viewWasStopped) {
            return;
        }
        this.currentViewDiagnostic.getDropped().incrementAndGet();
        this.resourceStartedTimestamps.remove(resourceId);
    }

    public final void viewWasStopped() {
        this.viewWasStopped = true;
        this.resourceStartedTimestamps.clear();
    }

    public final Long resolveMetric() {
        if (this.viewWasStopped) {
            return this.lastComputedMetric;
        }
        this.lastComputedMetric = computeMetric();
        return this.lastComputedMetric;
    }

    public final ViewInitializationMetricsState getState() {
        Long lResolveMetric = resolveMetric();
        return new ViewInitializationMetricsState(lResolveMetric, Companion.toConfig(this.initialResourceIdentifier), lResolveMetric == null ? this.currentViewDiagnostic.resolveNoValueReason() : null);
    }

    private final Long computeMetric() {
        if (this.viewCreatedTimestamp == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver.computeMetric.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] There was no view created yet for this resource";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (this.resourceStartedTimestamps.size() > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver.computeMetric.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] Not all the initial resources were stopped for this view";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        return this.networkSettleMaxValue;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewInitializationMetricsConfig toConfig(InitialResourceIdentifier initialResourceIdentifier) {
            if (!(initialResourceIdentifier instanceof TimeBasedInitialResourceIdentifier)) {
                return ViewInitializationMetricsConfig.CUSTOM;
            }
            if (((TimeBasedInitialResourceIdentifier) initialResourceIdentifier).defaultThresholdUsed$dd_sdk_android_rum_release()) {
                return ViewInitializationMetricsConfig.TIME_BASED_DEFAULT;
            }
            return ViewInitializationMetricsConfig.TIME_BASED_CUSTOM;
        }

        private static final class Diagnostic {
            private final AtomicInteger dropped;
            private final AtomicInteger initial;
            private final AtomicInteger started;
            private final AtomicInteger stopped;

            public Diagnostic(AtomicInteger started, AtomicInteger initial, AtomicInteger stopped, AtomicInteger dropped) {
                Intrinsics.checkNotNullParameter(started, "started");
                Intrinsics.checkNotNullParameter(initial, "initial");
                Intrinsics.checkNotNullParameter(stopped, "stopped");
                Intrinsics.checkNotNullParameter(dropped, "dropped");
                this.started = started;
                this.initial = initial;
                this.stopped = stopped;
                this.dropped = dropped;
            }

            public /* synthetic */ Diagnostic(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3, AtomicInteger atomicInteger4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new AtomicInteger(0) : atomicInteger, (i & 2) != 0 ? new AtomicInteger(0) : atomicInteger2, (i & 4) != 0 ? new AtomicInteger(0) : atomicInteger3, (i & 8) != 0 ? new AtomicInteger(0) : atomicInteger4);
            }

            public final AtomicInteger getStarted() {
                return this.started;
            }

            public final AtomicInteger getInitial() {
                return this.initial;
            }

            public final AtomicInteger getStopped() {
                return this.stopped;
            }

            public final AtomicInteger getDropped() {
                return this.dropped;
            }

            public final NoValueReason.TimeToNetworkSettle resolveNoValueReason() {
                int i = this.started.get();
                int i2 = this.initial.get();
                int i3 = this.dropped.get();
                int i4 = this.stopped.get();
                if (i == 0) {
                    return NoValueReason.TimeToNetworkSettle.NO_RESOURCES;
                }
                if (i2 == 0) {
                    return NoValueReason.TimeToNetworkSettle.NO_INITIAL_RESOURCES;
                }
                if (i2 > i3 + i4) {
                    return NoValueReason.TimeToNetworkSettle.NOT_SETTLED_YET;
                }
                return NoValueReason.TimeToNetworkSettle.UNKNOWN;
            }
        }
    }
}
