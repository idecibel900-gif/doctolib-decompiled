package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.utils.NumberExtKt;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.security.SecureRandom;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class RumSessionScope implements RumScope {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_SESSION_INACTIVITY_NS = TimeUnit.MINUTES.toNanos(15);
    private static final long DEFAULT_SESSION_MAX_DURATION_NS = TimeUnit.HOURS.toNanos(4);
    private final AccessibilitySnapshotManager accessibilitySnapshotManager;
    private final boolean backgroundTrackingEnabled;
    private final InfoProvider batteryInfoProvider;
    private RumViewManagerScope childScope;
    private final InfoProvider displayInfoProvider;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private boolean isActive;
    private final AtomicLong lastUserInteractionNs;
    private final NoOpDataWriter noOpWriter;
    private final RumScope parentScope;
    private final SecureRandom random;
    private final float sampleRate;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private String sessionId;
    private final long sessionInactivityNanos;
    private final RumSessionListener sessionListener;
    private final long sessionMaxDurationNanos;
    private final AtomicLong sessionStartNs;
    private State sessionState;
    private StartReason startReason;
    private final boolean trackFrustrations;

    public RumSessionScope(RumScope parentScope, InternalSdkCore sdkCore, SessionMetricDispatcher sessionEndedMetricDispatcher, float f, boolean z, boolean z2, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, RumSessionListener rumSessionListener, boolean z3, InitialResourceIdentifier networkSettledResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider batteryInfoProvider, InfoProvider displayInfoProvider, long j, long j2, RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(networkSettledResourceIdentifier, "networkSettledResourceIdentifier");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.sampleRate = f;
        this.backgroundTrackingEnabled = z;
        this.trackFrustrations = z2;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.sessionListener = rumSessionListener;
        this.accessibilitySnapshotManager = accessibilitySnapshotManager;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.sessionInactivityNanos = j;
        this.sessionMaxDurationNanos = j2;
        this.sessionId = RumContext.Companion.getNULL_UUID();
        this.sessionState = State.NOT_TRACKED;
        this.startReason = StartReason.USER_APP_LAUNCH;
        this.isActive = true;
        this.sessionStartNs = new AtomicLong(System.nanoTime());
        this.lastUserInteractionNs = new AtomicLong(0L);
        this.random = new SecureRandom();
        this.noOpWriter = new NoOpDataWriter();
        this.childScope = new RumViewManagerScope(this, sdkCore, sessionEndedMetricDispatcher, z, z2, rumViewChangedListener, firstPartyHostHeaderTypeResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, z3, f, networkSettledResourceIdentifier, slowFramesListener, lastInteractionIdentifier, rumSessionType, accessibilitySnapshotManager, batteryInfoProvider, displayInfoProvider);
        sdkCore.updateFeatureContext("rum", new Function1() { // from class: com.datadog.android.rum.internal.domain.scope.RumSessionScope.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.putAll(RumSessionScope.this.getRumContext().toMap());
            }
        });
    }

    public /* synthetic */ RumSessionScope(RumScope rumScope, InternalSdkCore internalSdkCore, SessionMetricDispatcher sessionMetricDispatcher, float f, boolean z, boolean z2, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, RumSessionListener rumSessionListener, boolean z3, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider infoProvider, InfoProvider infoProvider2, long j, long j2, RumSessionType rumSessionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumScope, internalSdkCore, sessionMetricDispatcher, f, z, z2, rumViewChangedListener, firstPartyHostHeaderTypeResolver, vitalMonitor, vitalMonitor2, vitalMonitor3, rumSessionListener, z3, initialResourceIdentifier, lastInteractionIdentifier, slowFramesListener, accessibilitySnapshotManager, infoProvider, infoProvider2, (i & 524288) != 0 ? DEFAULT_SESSION_INACTIVITY_NS : j, (i & 1048576) != 0 ? DEFAULT_SESSION_MAX_DURATION_NS : j2, rumSessionType);
    }

    public enum State {
        NOT_TRACKED("NOT_TRACKED"),
        TRACKED("TRACKED"),
        EXPIRED("EXPIRED");

        public static final Companion Companion = new Companion(null);
        private final String asString;

        State(String str) {
            this.asString = str;
        }

        public final String getAsString() {
            return this.asString;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final State fromString(String str) {
                for (State state : State.values()) {
                    if (Intrinsics.areEqual(state.getAsString(), str)) {
                        return state;
                    }
                }
                return null;
            }
        }
    }

    public enum StartReason {
        USER_APP_LAUNCH("user_app_launch"),
        INACTIVITY_TIMEOUT("inactivity_timeout"),
        MAX_DURATION("max_duration"),
        BACKGROUND_LAUNCH("background_launch"),
        PREWARM("prewarm"),
        FROM_NON_INTERACTIVE_SESSION("from_non_interactive_session"),
        EXPLICIT_STOP("explicit_stop");

        public static final Companion Companion = new Companion(null);
        private final String asString;

        StartReason(String str) {
            this.asString = str;
        }

        public final String getAsString() {
            return this.asString;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final StartReason fromString(String str) {
                for (StartReason startReason : StartReason.values()) {
                    if (Intrinsics.areEqual(startReason.getAsString(), str)) {
                        return startReason;
                    }
                }
                return null;
            }
        }
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DataWriter writer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (event instanceof RumRawEvent.StopSession) {
            stopSession();
        }
        updateSession(event);
        if (this.sessionState != State.TRACKED) {
            writer = this.noOpWriter;
        }
        if (!(event instanceof RumRawEvent.SdkInit)) {
            RumViewManagerScope rumViewManagerScope = this.childScope;
            RumScope rumScopeHandleEvent = rumViewManagerScope != null ? rumViewManagerScope.handleEvent(event, writer) : null;
            this.childScope = rumScopeHandleEvent instanceof RumViewManagerScope ? (RumViewManagerScope) rumScopeHandleEvent : null;
        }
        if (isSessionComplete()) {
            return null;
        }
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumContext getRumContext() {
        RumContext rumContext = this.parentScope.getRumContext();
        return rumContext.copy((32377 & 1) != 0 ? rumContext.applicationId : null, (32377 & 2) != 0 ? rumContext.sessionId : this.sessionId, (32377 & 4) != 0 ? rumContext.isSessionActive : this.isActive, (32377 & 8) != 0 ? rumContext.viewId : null, (32377 & 16) != 0 ? rumContext.viewName : null, (32377 & 32) != 0 ? rumContext.viewUrl : null, (32377 & 64) != 0 ? rumContext.actionId : null, (32377 & 128) != 0 ? rumContext.sessionState : this.sessionState, (32377 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? rumContext.sessionStartReason : this.startReason, (32377 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? rumContext.viewType : null, (32377 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? rumContext.syntheticsTestId : null, (32377 & 2048) != 0 ? rumContext.syntheticsResultId : null, (32377 & 4096) != 0 ? rumContext.viewTimestamp : 0L, (32377 & 8192) != 0 ? rumContext.viewTimestampOffset : 0L, (32377 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? rumContext.hasReplay : false);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public boolean isActive() {
        return this.isActive;
    }

    private final void stopSession() {
        this.isActive = false;
        this.sessionEndedMetricDispatcher.onSessionStopped(this.sessionId);
    }

    private final boolean isSessionComplete() {
        return !this.isActive && this.childScope == null;
    }

    private final void updateSession(RumRawEvent rumRawEvent) {
        StartReason startReason;
        long jNanoTime = System.nanoTime();
        boolean zAreEqual = Intrinsics.areEqual(this.sessionId, RumContext.Companion.getNULL_UUID());
        boolean z = false;
        boolean z2 = jNanoTime - this.lastUserInteractionNs.get() >= this.sessionInactivityNanos;
        boolean z3 = jNanoTime - this.sessionStartNs.get() >= this.sessionMaxDurationNanos;
        boolean z4 = (rumRawEvent instanceof RumRawEvent.StartView) || (rumRawEvent instanceof RumRawEvent.StartAction);
        boolean zContains = ArraysKt.contains(RumViewManagerScope.Companion.getValidBackgroundEventTypes$dd_sdk_android_rum_release(), rumRawEvent.getClass());
        boolean z5 = rumRawEvent instanceof RumRawEvent.SdkInit;
        boolean z6 = z5 && ((RumRawEvent.SdkInit) rumRawEvent).getIsAppInForeground();
        if (z5 && !((RumRawEvent.SdkInit) rumRawEvent).getIsAppInForeground()) {
            z = true;
        }
        if (z2 || z3 || !this.isActive) {
            this.sessionEndedMetricDispatcher.endMetric(this.sessionId, this.sdkCore.getTime().getServerTimeOffsetMs());
        }
        if (z4 || z6) {
            if (zAreEqual || z2 || z3) {
                if (zAreEqual) {
                    startReason = StartReason.USER_APP_LAUNCH;
                } else if (z2) {
                    startReason = StartReason.INACTIVITY_TIMEOUT;
                } else {
                    startReason = StartReason.MAX_DURATION;
                }
                renewSession(rumRawEvent.getEventTime(), startReason);
            }
            this.lastUserInteractionNs.set(jNanoTime);
        } else if (z2) {
            if (this.backgroundTrackingEnabled && (zContains || z)) {
                renewSession(rumRawEvent.getEventTime(), StartReason.BACKGROUND_LAUNCH);
                this.lastUserInteractionNs.set(jNanoTime);
            } else {
                this.sessionState = State.EXPIRED;
            }
        } else if (z3) {
            renewSession(rumRawEvent.getEventTime(), StartReason.MAX_DURATION);
        }
        updateSessionStateForSessionReplay(this.sessionState, this.sessionId);
    }

    private final void renewSession(Time time, StartReason startReason) {
        boolean z = ((double) this.random.nextFloat()) < NumberExtKt.percent(this.sampleRate);
        this.startReason = startReason;
        this.sessionState = z ? State.TRACKED : State.NOT_TRACKED;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.sessionId = string;
        this.sessionStartNs.set(time.getNanoTime());
        RumViewManagerScope rumViewManagerScope = this.childScope;
        if (rumViewManagerScope != null) {
            rumViewManagerScope.renewViewScopes(time);
        }
        if (z) {
            this.sessionEndedMetricDispatcher.startMetric(this.sessionId, startReason, this.sdkCore.getTime().getServerTimeOffsetMs(), this.backgroundTrackingEnabled);
        }
        RumSessionListener rumSessionListener = this.sessionListener;
        if (rumSessionListener != null) {
            rumSessionListener.onSessionStarted(this.sessionId, !z);
        }
    }

    private final void updateSessionStateForSessionReplay(State state, String str) {
        boolean z = state == State.TRACKED;
        FeatureScope feature = this.sdkCore.getFeature("session-replay");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", "rum_session_renewed"), TuplesKt.to("keepSession", Boolean.valueOf(z)), TuplesKt.to("sessionId", str)));
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
