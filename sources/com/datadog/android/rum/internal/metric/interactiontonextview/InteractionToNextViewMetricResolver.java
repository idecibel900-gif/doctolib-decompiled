package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.metric.NoValueReason;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsConfig;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsState;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.interactiontonextview.PreviousViewLastInteractionContext;
import com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InteractionToNextViewMetricResolver {
    public static final Companion Companion = new Companion(null);
    private final InteractionIngestionValidator ingestionValidator;
    private final InternalLogger internalLogger;
    private final LastInteractionIdentifier lastInteractionIdentifier;
    private final LinkedHashMap lastInteractions;
    private final LinkedHashMap lastViewCreatedTimestamps;

    public InteractionToNextViewMetricResolver(InternalLogger internalLogger, InteractionIngestionValidator ingestionValidator, LastInteractionIdentifier lastInteractionIdentifier) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(ingestionValidator, "ingestionValidator");
        this.internalLogger = internalLogger;
        this.ingestionValidator = ingestionValidator;
        this.lastInteractionIdentifier = lastInteractionIdentifier;
        this.lastInteractions = new LinkedHashMap();
        this.lastViewCreatedTimestamps = new LinkedHashMap();
    }

    public /* synthetic */ InteractionToNextViewMetricResolver(InternalLogger internalLogger, InteractionIngestionValidator interactionIngestionValidator, LastInteractionIdentifier lastInteractionIdentifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new ActionTypeInteractionValidator() : interactionIngestionValidator, (i & 4) != 0 ? new TimeBasedInteractionIdentifier(0L, 1, null) : lastInteractionIdentifier);
    }

    public final void onViewCreated(String viewId, long j) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        if (this.lastInteractionIdentifier == null) {
            return;
        }
        this.lastViewCreatedTimestamps.put(viewId, Long.valueOf(j));
        purgeOldEntries();
    }

    public final void onActionSent(InternalInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.lastInteractionIdentifier == null) {
            return;
        }
        if (this.ingestionValidator.validate(context)) {
            this.lastInteractions.put(context.getViewId$dd_sdk_android_rum_release(), context);
        }
        purgeOldEntries();
    }

    public final Long resolveMetric(final String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        purgeOldEntries();
        Long lResolveCurrentViewCreationTimestamp = resolveCurrentViewCreationTimestamp(viewId);
        if (lResolveCurrentViewCreationTimestamp != null) {
            long jLongValue = lResolveCurrentViewCreationTimestamp.longValue();
            String strResolvePreviousViewId = resolvePreviousViewId(viewId);
            InternalInteractionContext internalInteractionContextResolveLastInteraction = strResolvePreviousViewId != null ? resolveLastInteraction(strResolvePreviousViewId, jLongValue) : null;
            if (internalInteractionContextResolveLastInteraction != null) {
                long eventCreatedAtNanos$dd_sdk_android_rum_release = jLongValue - internalInteractionContextResolveLastInteraction.getEventCreatedAtNanos$dd_sdk_android_rum_release();
                if (eventCreatedAtNanos$dd_sdk_android_rum_release > 0) {
                    return Long.valueOf(eventCreatedAtNanos$dd_sdk_android_rum_release);
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver.resolveMetric.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "[ViewNetworkSettledMetric] The difference between the last interaction and the current view is negative for viewId:" + viewId;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        return null;
    }

    public final ViewInitializationMetricsState getState(String viewId) {
        ViewInitializationMetricsConfig config;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Long lResolveMetric = resolveMetric(viewId);
        LastInteractionIdentifier lastInteractionIdentifier = this.lastInteractionIdentifier;
        if (lastInteractionIdentifier == null || (config = Companion.toConfig(lastInteractionIdentifier)) == null) {
            config = ViewInitializationMetricsConfig.DISABLED;
        }
        return new ViewInitializationMetricsState(lResolveMetric, config, lResolveMetric == null ? resolveNoValueReason(viewId) : null);
    }

    private final NoValueReason.InteractionToNextView resolveNoValueReason(String str) {
        if (this.lastInteractionIdentifier == null) {
            return NoValueReason.InteractionToNextView.DISABLED;
        }
        Long lResolveCurrentViewCreationTimestamp = resolveCurrentViewCreationTimestamp(str);
        if (lResolveCurrentViewCreationTimestamp == null) {
            return NoValueReason.InteractionToNextView.UNKNOWN;
        }
        long jLongValue = lResolveCurrentViewCreationTimestamp.longValue();
        String strResolvePreviousViewId = resolvePreviousViewId(str);
        if (strResolvePreviousViewId == null) {
            return NoValueReason.InteractionToNextView.NO_PREVIOUS_VIEW;
        }
        if (this.lastInteractions.get(strResolvePreviousViewId) == null) {
            return NoValueReason.InteractionToNextView.NO_ACTION;
        }
        if (resolveLastInteraction(strResolvePreviousViewId, jLongValue) == null) {
            return NoValueReason.InteractionToNextView.NO_ELIGIBLE_ACTION;
        }
        return NoValueReason.InteractionToNextView.UNKNOWN;
    }

    private final void purgeOldEntries() {
        while (this.lastInteractions.entrySet().size() > 4) {
            Set setEntrySet = this.lastInteractions.entrySet();
            Set setEntrySet2 = this.lastInteractions.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet2, "lastInteractions.entries");
            setEntrySet.remove(CollectionsKt.first(setEntrySet2));
        }
        while (this.lastViewCreatedTimestamps.entrySet().size() > 4) {
            LinkedHashMap linkedHashMap = this.lastViewCreatedTimestamps;
            Set setKeySet = linkedHashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "lastViewCreatedTimestamps.keys");
            linkedHashMap.remove(CollectionsKt.first(setKeySet));
        }
    }

    private final Long resolveCurrentViewCreationTimestamp(final String str) {
        Long l = (Long) this.lastViewCreatedTimestamps.get(str);
        if (l == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver.resolveCurrentViewCreationTimestamp.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] The view was not yet created for this viewId:" + str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return l;
    }

    private final InternalInteractionContext resolveLastInteraction(String str, long j) {
        InternalInteractionContext it;
        LastInteractionIdentifier lastInteractionIdentifier = this.lastInteractionIdentifier;
        if (lastInteractionIdentifier == null || (it = (InternalInteractionContext) this.lastInteractions.get(str)) == null) {
            return null;
        }
        Companion companion = Companion;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (lastInteractionIdentifier.validate(companion.toPreviousViewLastInteractionContext(it, j))) {
            return it;
        }
        return null;
    }

    private final String resolvePreviousViewId(String str) {
        Set setKeySet = this.lastViewCreatedTimestamps.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "lastViewCreatedTimestamps.keys");
        int iIndexOf = CollectionsKt.indexOf(setKeySet, str);
        Set setKeySet2 = this.lastViewCreatedTimestamps.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet2, "lastViewCreatedTimestamps.keys");
        return (String) CollectionsKt.elementAtOrNull(setKeySet2, iIndexOf - 1);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewInitializationMetricsConfig toConfig(LastInteractionIdentifier lastInteractionIdentifier) {
            if (!(lastInteractionIdentifier instanceof TimeBasedInteractionIdentifier)) {
                return ViewInitializationMetricsConfig.CUSTOM;
            }
            if (((TimeBasedInteractionIdentifier) lastInteractionIdentifier).defaultThresholdUsed$dd_sdk_android_rum_release()) {
                return ViewInitializationMetricsConfig.TIME_BASED_DEFAULT;
            }
            return ViewInitializationMetricsConfig.TIME_BASED_CUSTOM;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PreviousViewLastInteractionContext toPreviousViewLastInteractionContext(InternalInteractionContext internalInteractionContext, long j) {
            return new PreviousViewLastInteractionContext(internalInteractionContext.getActionType$dd_sdk_android_rum_release(), internalInteractionContext.getEventCreatedAtNanos$dd_sdk_android_rum_release(), Long.valueOf(j));
        }
    }
}
