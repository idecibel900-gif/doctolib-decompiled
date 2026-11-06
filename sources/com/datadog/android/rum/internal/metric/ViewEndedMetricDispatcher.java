package com.datadog.android.rum.internal.metric;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import com.facebook.react.modules.appstate.AppStateModule;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewEndedMetricDispatcher implements ViewMetricDispatcher {
    public static final Companion Companion = new Companion(null);
    private Long duration;
    private final ViewScopeInstrumentationType instrumentationType;
    private final InternalLogger internalLogger;
    private Long loadingTime;
    private boolean metricSent;
    private final float samplingRate;
    private final RumViewType viewType;

    public ViewEndedMetricDispatcher(RumViewType viewType, InternalLogger internalLogger, ViewScopeInstrumentationType viewScopeInstrumentationType, float f) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.viewType = viewType;
        this.internalLogger = internalLogger;
        this.instrumentationType = viewScopeInstrumentationType;
        this.samplingRate = f;
    }

    public /* synthetic */ ViewEndedMetricDispatcher(RumViewType rumViewType, InternalLogger internalLogger, ViewScopeInstrumentationType viewScopeInstrumentationType, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumViewType, internalLogger, (i & 4) != 0 ? null : viewScopeInstrumentationType, (i & 8) != 0 ? 0.75f : f);
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void sendViewEnded(ViewInitializationMetricsState invState, ViewInitializationMetricsState tnsState) {
        Intrinsics.checkNotNullParameter(invState, "invState");
        Intrinsics.checkNotNullParameter(tnsState, "tnsState");
        if (this.metricSent) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher.sendViewEnded.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Trying to send 'view ended' more than once";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            InternalLogger.DefaultImpls.logMetric$default(this.internalLogger, new Function0() { // from class: com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher.sendViewEnded.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[Mobile Metric] RUM View Ended";
                }
            }, buildMetricAttributesMap(invState, tnsState), this.samplingRate, null, 8, null);
            this.metricSent = true;
        }
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onDurationResolved(long j) {
        this.duration = Long.valueOf(j);
    }

    @Override // com.datadog.android.rum.internal.metric.ViewMetricDispatcher
    public void onViewLoadingTimeResolved(long j) {
        this.loadingTime = Long.valueOf(j);
    }

    private final Map buildMetricAttributesMap(ViewInitializationMetricsState viewInitializationMetricsState, ViewInitializationMetricsState viewInitializationMetricsState2) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("metric_type", "rum view ended");
        mapCreateMapBuilder.put("rve", buildAttributesMap(viewInitializationMetricsState, viewInitializationMetricsState2));
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map buildAttributesMap(ViewInitializationMetricsState viewInitializationMetricsState, ViewInitializationMetricsState viewInitializationMetricsState2) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Companion companion = Companion;
        companion.putNonNull(mapCreateMapBuilder, "duration", this.duration);
        if (this.loadingTime != null) {
            Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
            mapCreateMapBuilder2.put("value", this.loadingTime);
            Unit unit = Unit.INSTANCE;
            mapCreateMapBuilder.put("loading_time", MapsKt.build(mapCreateMapBuilder2));
        }
        mapCreateMapBuilder.put("view_type", companion.toAttributeValue$dd_sdk_android_rum_release(this.viewType));
        Map mapCreateMapBuilder3 = MapsKt.createMapBuilder();
        mapCreateMapBuilder3.put("value", viewInitializationMetricsState2.getInitializationTime());
        mapCreateMapBuilder3.put("config", companion.toAttributeValue$dd_sdk_android_rum_release(viewInitializationMetricsState2.getConfig()));
        if (viewInitializationMetricsState2.getInitializationTime() == null) {
            companion.putNonNull(mapCreateMapBuilder3, "no_value_reason", companion.toAttributeValue$dd_sdk_android_rum_release(viewInitializationMetricsState2.getNoValueReason()));
        }
        Unit unit2 = Unit.INSTANCE;
        mapCreateMapBuilder.put("tns", MapsKt.build(mapCreateMapBuilder3));
        Map mapCreateMapBuilder4 = MapsKt.createMapBuilder();
        mapCreateMapBuilder4.put("value", viewInitializationMetricsState.getInitializationTime());
        mapCreateMapBuilder4.put("config", companion.toAttributeValue$dd_sdk_android_rum_release(viewInitializationMetricsState.getConfig()));
        if (viewInitializationMetricsState.getInitializationTime() == null) {
            companion.putNonNull(mapCreateMapBuilder4, "no_value_reason", companion.toAttributeValue$dd_sdk_android_rum_release(viewInitializationMetricsState.getNoValueReason()));
        }
        mapCreateMapBuilder.put("inv", MapsKt.build(mapCreateMapBuilder4));
        companion.putNonNull(mapCreateMapBuilder, "instrumentation_type", companion.toAttributeValue(this.instrumentationType));
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;
            public static final /* synthetic */ int[] $EnumSwitchMapping$3;
            public static final /* synthetic */ int[] $EnumSwitchMapping$4;

            static {
                int[] iArr = new int[RumViewType.values().length];
                try {
                    iArr[RumViewType.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RumViewType.FOREGROUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RumViewType.BACKGROUND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RumViewType.APPLICATION_LAUNCH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[ViewInitializationMetricsConfig.values().length];
                try {
                    iArr2[ViewInitializationMetricsConfig.DISABLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.CUSTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.TIME_BASED_DEFAULT.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[ViewInitializationMetricsConfig.TIME_BASED_CUSTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[ViewScopeInstrumentationType.values().length];
                try {
                    iArr3[ViewScopeInstrumentationType.COMPOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr3[ViewScopeInstrumentationType.MANUAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr3[ViewScopeInstrumentationType.ACTIVITY.ordinal()] = 3;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr3[ViewScopeInstrumentationType.FRAGMENT.ordinal()] = 4;
                } catch (NoSuchFieldError unused12) {
                }
                $EnumSwitchMapping$2 = iArr3;
                int[] iArr4 = new int[NoValueReason.InteractionToNextView.values().length];
                try {
                    iArr4[NoValueReason.InteractionToNextView.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr4[NoValueReason.InteractionToNextView.NO_PREVIOUS_VIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr4[NoValueReason.InteractionToNextView.NO_ACTION.ordinal()] = 3;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr4[NoValueReason.InteractionToNextView.NO_ELIGIBLE_ACTION.ordinal()] = 4;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr4[NoValueReason.InteractionToNextView.DISABLED.ordinal()] = 5;
                } catch (NoSuchFieldError unused17) {
                }
                $EnumSwitchMapping$3 = iArr4;
                int[] iArr5 = new int[NoValueReason.TimeToNetworkSettle.values().length];
                try {
                    iArr5[NoValueReason.TimeToNetworkSettle.UNKNOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr5[NoValueReason.TimeToNetworkSettle.NOT_SETTLED_YET.ordinal()] = 2;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr5[NoValueReason.TimeToNetworkSettle.NO_RESOURCES.ordinal()] = 3;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr5[NoValueReason.TimeToNetworkSettle.NO_INITIAL_RESOURCES.ordinal()] = 4;
                } catch (NoSuchFieldError unused21) {
                }
                $EnumSwitchMapping$4 = iArr5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void putNonNull(Map map, Object obj, Object obj2) {
            if (obj2 != null) {
                map.put(obj, obj2);
            }
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(RumViewType viewType) {
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            int i = WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()];
            if (i == 1 || i == 2) {
                return "custom";
            }
            if (i == 3) {
                return AppStateModule.APP_STATE_BACKGROUND;
            }
            if (i == 4) {
                return "application_launch";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(ViewInitializationMetricsConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            int i = WhenMappings.$EnumSwitchMapping$1[config.ordinal()];
            if (i == 1) {
                return "disabled";
            }
            if (i == 2) {
                return "custom";
            }
            if (i == 3) {
                return "time_based_default";
            }
            if (i == 4) {
                return "time_based_custom";
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String toAttributeValue(ViewScopeInstrumentationType viewScopeInstrumentationType) {
            int i = viewScopeInstrumentationType == null ? -1 : WhenMappings.$EnumSwitchMapping$2[viewScopeInstrumentationType.ordinal()];
            if (i == -1) {
                return "manual";
            }
            if (i == 1) {
                return "compose";
            }
            if (i == 2) {
                return "manual";
            }
            if (i == 3) {
                return "activity";
            }
            if (i == 4) {
                return AuthorizationRequest.ResponseMode.FRAGMENT;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toAttributeValue$dd_sdk_android_rum_release(NoValueReason noValueReason) {
            if (noValueReason == null) {
                return "unknown";
            }
            if (noValueReason instanceof NoValueReason.InteractionToNextView) {
                int i = WhenMappings.$EnumSwitchMapping$3[((NoValueReason.InteractionToNextView) noValueReason).ordinal()];
                if (i == 1) {
                    return "unknown";
                }
                if (i == 2) {
                    return "no_previous_view";
                }
                if (i == 3) {
                    return "no_action";
                }
                if (i == 4) {
                    return "no_eligible_action";
                }
                if (i == 5) {
                    return "disabled";
                }
                throw new NoWhenBranchMatchedException();
            }
            if (!(noValueReason instanceof NoValueReason.TimeToNetworkSettle)) {
                throw new NoWhenBranchMatchedException();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$4[((NoValueReason.TimeToNetworkSettle) noValueReason).ordinal()];
            if (i2 == 1) {
                return "unknown";
            }
            if (i2 == 2) {
                return "not_settled_yet";
            }
            if (i2 == 3) {
                return "no_resources";
            }
            if (i2 == 4) {
                return "no_initial_resources";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
