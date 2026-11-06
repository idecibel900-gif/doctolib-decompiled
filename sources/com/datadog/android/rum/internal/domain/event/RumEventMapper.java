package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumEventMapper implements EventMapper {
    public static final Companion Companion = new Companion(null);
    private final EventMapper actionEventMapper;
    private final EventMapper errorEventMapper;
    private final InternalLogger internalLogger;
    private final EventMapper longTaskEventMapper;
    private final EventMapper resourceEventMapper;
    private final EventMapper telemetryConfigurationMapper;
    private final EventMapper viewEventMapper;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumEventMapper)) {
            return false;
        }
        RumEventMapper rumEventMapper = (RumEventMapper) obj;
        return Intrinsics.areEqual(this.viewEventMapper, rumEventMapper.viewEventMapper) && Intrinsics.areEqual(this.errorEventMapper, rumEventMapper.errorEventMapper) && Intrinsics.areEqual(this.resourceEventMapper, rumEventMapper.resourceEventMapper) && Intrinsics.areEqual(this.actionEventMapper, rumEventMapper.actionEventMapper) && Intrinsics.areEqual(this.longTaskEventMapper, rumEventMapper.longTaskEventMapper) && Intrinsics.areEqual(this.telemetryConfigurationMapper, rumEventMapper.telemetryConfigurationMapper) && Intrinsics.areEqual(this.internalLogger, rumEventMapper.internalLogger);
    }

    public int hashCode() {
        return (((((((((((this.viewEventMapper.hashCode() * 31) + this.errorEventMapper.hashCode()) * 31) + this.resourceEventMapper.hashCode()) * 31) + this.actionEventMapper.hashCode()) * 31) + this.longTaskEventMapper.hashCode()) * 31) + this.telemetryConfigurationMapper.hashCode()) * 31) + this.internalLogger.hashCode();
    }

    public String toString() {
        return "RumEventMapper(viewEventMapper=" + this.viewEventMapper + ", errorEventMapper=" + this.errorEventMapper + ", resourceEventMapper=" + this.resourceEventMapper + ", actionEventMapper=" + this.actionEventMapper + ", longTaskEventMapper=" + this.longTaskEventMapper + ", telemetryConfigurationMapper=" + this.telemetryConfigurationMapper + ", internalLogger=" + this.internalLogger + ")";
    }

    public RumEventMapper(EventMapper viewEventMapper, EventMapper errorEventMapper, EventMapper resourceEventMapper, EventMapper actionEventMapper, EventMapper longTaskEventMapper, EventMapper telemetryConfigurationMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(viewEventMapper, "viewEventMapper");
        Intrinsics.checkNotNullParameter(errorEventMapper, "errorEventMapper");
        Intrinsics.checkNotNullParameter(resourceEventMapper, "resourceEventMapper");
        Intrinsics.checkNotNullParameter(actionEventMapper, "actionEventMapper");
        Intrinsics.checkNotNullParameter(longTaskEventMapper, "longTaskEventMapper");
        Intrinsics.checkNotNullParameter(telemetryConfigurationMapper, "telemetryConfigurationMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.viewEventMapper = viewEventMapper;
        this.errorEventMapper = errorEventMapper;
        this.resourceEventMapper = resourceEventMapper;
        this.actionEventMapper = actionEventMapper;
        this.longTaskEventMapper = longTaskEventMapper;
        this.telemetryConfigurationMapper = telemetryConfigurationMapper;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.event.EventMapper
    public Object map(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return resolveEvent(event);
    }

    private final Object mapRumEvent(final Object obj) {
        if (obj instanceof ViewEvent) {
            return this.viewEventMapper.map(obj);
        }
        if (obj instanceof ActionEvent) {
            return this.actionEventMapper.map(obj);
        }
        if (obj instanceof ErrorEvent) {
            ErrorEvent errorEvent = (ErrorEvent) obj;
            if (Intrinsics.areEqual(errorEvent.getError().isCrash(), Boolean.TRUE)) {
                ErrorEvent errorEvent2 = (ErrorEvent) this.errorEventMapper.map(obj);
                if (errorEvent2 != null) {
                    return errorEvent2;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.mapRumEvent.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "RumEventMapper: the return from the ErrorEvent mapper was null for a crash. Dropping crashes in from the event mapper is not supported. The original event object will be used instead.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return errorEvent;
            }
            return (ErrorEvent) this.errorEventMapper.map(obj);
        }
        if (obj instanceof ResourceEvent) {
            return this.resourceEventMapper.map(obj);
        }
        if (obj instanceof LongTaskEvent) {
            return this.longTaskEventMapper.map(obj);
        }
        if (obj instanceof TelemetryConfigurationEvent) {
            return this.telemetryConfigurationMapper.map(obj);
        }
        if (obj instanceof TelemetryDebugEvent ? true : obj instanceof TelemetryUsageEvent ? true : obj instanceof TelemetryErrorEvent) {
            return obj;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.mapRumEvent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "RumEventMapper: there was no EventMapper assigned for RUM event type: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return obj;
    }

    private final Object resolveEvent(final Object obj) {
        Object objMapRumEvent = mapRumEvent(obj);
        if ((obj instanceof ViewEvent) && (objMapRumEvent == null || objMapRumEvent != obj)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "RumEventMapper: the returned mapped ViewEvent was null. The original event object will be used instead: %s", Arrays.copyOf(new Object[]{obj}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return obj;
        }
        if (objMapRumEvent == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "RumEventMapper: the returned mapped object was null. This event will be dropped: %s", Arrays.copyOf(new Object[]{obj}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (objMapRumEvent == obj) {
            return obj;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "RumEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s", Arrays.copyOf(new Object[]{obj}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
