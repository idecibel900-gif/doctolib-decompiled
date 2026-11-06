package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.RumErrorSourceType;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.model.ActionEvent;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u001e\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u001e&'()*+,-./0123456789:;<=>?@ABC¨\u0006D"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "<init>", "()V", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "ActionDropped", "ActionSent", "AddCustomTiming", "AddError", "AddFeatureFlagEvaluation", "AddLongTask", "AddViewLoadingTime", "ApplicationStarted", "ErrorDropped", "ErrorSent", "KeepAlive", "LongTaskDropped", "LongTaskSent", "ResetSession", "ResourceDropped", "ResourceSent", "SdkInit", "SendCustomActionNow", "SetSyntheticsTestAttribute", "StartAction", "StartResource", "StartView", "StopAction", "StopResource", "StopSession", "StopView", "TelemetryEventWrapper", "UpdateExternalRefreshRate", "UpdatePerformanceMetric", "WebViewEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewLoadingTime;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$KeepAlive;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResetSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SdkInit;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SendCustomActionNow;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetSyntheticsTestAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$TelemetryEventWrapper;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateExternalRefreshRate;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdatePerformanceMetric;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WebViewEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public abstract class RumRawEvent {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResetSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ResetSession extends RumRawEvent {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateExternalRefreshRate;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class UpdateExternalRefreshRate extends RumRawEvent {
    }

    public /* synthetic */ RumRawEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Time getEventTime();

    private RumRawEvent() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "getKey", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StartView extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final RumScopeKey key;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartView)) {
                return false;
            }
            StartView startView = (StartView) other;
            return Intrinsics.areEqual(this.key, startView.key) && Intrinsics.areEqual(this.attributes, startView.attributes) && Intrinsics.areEqual(this.eventTime, startView.eventTime);
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartView(key=" + this.key + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        public /* synthetic */ StartView(RumScopeKey rumScopeKey, Map map, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rumScopeKey, map, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartView(RumScopeKey key, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "getKey", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StopView extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final RumScopeKey key;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopView)) {
                return false;
            }
            StopView stopView = (StopView) other;
            return Intrinsics.areEqual(this.key, stopView.key) && Intrinsics.areEqual(this.attributes, stopView.attributes) && Intrinsics.areEqual(this.eventTime, stopView.eventTime);
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopView(key=" + this.key + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopView(RumScopeKey key, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/RumActionType;", "type", "", "name", "", "waitForStop", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;ZLjava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/RumActionType;", "getType", "()Lcom/datadog/android/rum/RumActionType;", "Ljava/lang/String;", "getName", "Z", "getWaitForStop", "()Z", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StartAction extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final String name;
        private final RumActionType type;
        private final boolean waitForStop;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartAction)) {
                return false;
            }
            StartAction startAction = (StartAction) other;
            return this.type == startAction.type && Intrinsics.areEqual(this.name, startAction.name) && this.waitForStop == startAction.waitForStop && Intrinsics.areEqual(this.attributes, startAction.attributes) && Intrinsics.areEqual(this.eventTime, startAction.eventTime);
        }

        public int hashCode() {
            return (((((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.waitForStop)) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartAction(type=" + this.type + ", name=" + this.name + ", waitForStop=" + this.waitForStop + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumActionType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getWaitForStop() {
            return this.waitForStop;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartAction(RumActionType type, String name, boolean z, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.type = type;
            this.name = name;
            this.waitForStop = z;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/RumActionType;", "type", "", "name", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/RumActionType;", "getType", "()Lcom/datadog/android/rum/RumActionType;", "Ljava/lang/String;", "getName", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StopAction extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final String name;
        private final RumActionType type;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopAction)) {
                return false;
            }
            StopAction stopAction = (StopAction) other;
            return this.type == stopAction.type && Intrinsics.areEqual(this.name, stopAction.name) && Intrinsics.areEqual(this.attributes, stopAction.attributes) && Intrinsics.areEqual(this.eventTime, stopAction.eventTime);
        }

        public int hashCode() {
            RumActionType rumActionType = this.type;
            int iHashCode = (rumActionType == null ? 0 : rumActionType.hashCode()) * 31;
            String str = this.name;
            return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopAction(type=" + this.type + ", name=" + this.name + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumActionType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopAction(RumActionType rumActionType, String str, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.type = rumActionType;
            this.name = str;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJP\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "url", "Lcom/datadog/android/rum/RumResourceMethod;", "method", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/rum/RumResourceMethod;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "copy", "(Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/rum/RumResourceMethod;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Ljava/lang/String;", "getUrl", "Lcom/datadog/android/rum/RumResourceMethod;", "getMethod", "()Lcom/datadog/android/rum/RumResourceMethod;", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StartResource extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final Object key;
        private final RumResourceMethod method;
        private final String url;

        public static /* synthetic */ StartResource copy$default(StartResource startResource, Object obj, String str, RumResourceMethod rumResourceMethod, Map map, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = startResource.key;
            }
            if ((i & 2) != 0) {
                str = startResource.url;
            }
            if ((i & 4) != 0) {
                rumResourceMethod = startResource.method;
            }
            if ((i & 8) != 0) {
                map = startResource.attributes;
            }
            if ((i & 16) != 0) {
                time = startResource.eventTime;
            }
            Time time2 = time;
            RumResourceMethod rumResourceMethod2 = rumResourceMethod;
            return startResource.copy(obj, str, rumResourceMethod2, map, time2);
        }

        public final StartResource copy(Object key, String url, RumResourceMethod method, Map attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StartResource(key, url, method, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartResource)) {
                return false;
            }
            StartResource startResource = (StartResource) other;
            return Intrinsics.areEqual(this.key, startResource.key) && Intrinsics.areEqual(this.url, startResource.url) && this.method == startResource.method && Intrinsics.areEqual(this.attributes, startResource.attributes) && Intrinsics.areEqual(this.eventTime, startResource.eventTime);
        }

        public int hashCode() {
            return (((((((this.key.hashCode() * 31) + this.url.hashCode()) * 31) + this.method.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartResource(key=" + this.key + ", url=" + this.url + ", method=" + this.method + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final String getUrl() {
            return this.url;
        }

        public final RumResourceMethod getMethod() {
            return this.method;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartResource(Object key, String url, RumResourceMethod method, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.url = url;
            this.method = method;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "statusCode", "size", "Lcom/datadog/android/rum/RumResourceKind;", "kind", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Long;", "getStatusCode", "()Ljava/lang/Long;", "getSize", "Lcom/datadog/android/rum/RumResourceKind;", "getKind", "()Lcom/datadog/android/rum/RumResourceKind;", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StopResource extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final Object key;
        private final RumResourceKind kind;
        private final Long size;
        private final Long statusCode;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopResource)) {
                return false;
            }
            StopResource stopResource = (StopResource) other;
            return Intrinsics.areEqual(this.key, stopResource.key) && Intrinsics.areEqual(this.statusCode, stopResource.statusCode) && Intrinsics.areEqual(this.size, stopResource.size) && this.kind == stopResource.kind && Intrinsics.areEqual(this.attributes, stopResource.attributes) && Intrinsics.areEqual(this.eventTime, stopResource.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            Long l = this.statusCode;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.size;
            return ((((((iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31) + this.kind.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopResource(key=" + this.key + ", statusCode=" + this.statusCode + ", size=" + this.size + ", kind=" + this.kind + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final Long getStatusCode() {
            return this.statusCode;
        }

        public final Long getSize() {
            return this.size;
        }

        public final RumResourceKind getKind() {
            return this.kind;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopResource(Object key, Long l, Long l2, RumResourceKind kind, Map attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.statusCode = l;
            this.size = l2;
            this.kind = kind;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b!\b\u0080\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b*\u0010\u001bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b\n\u0010,R%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b3\u0010\u001bR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00104\u001a\u0004\b5\u00106R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u00107\u001a\u0004\b8\u00109R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010:\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "message", "Lcom/datadog/android/rum/RumErrorSource;", Constants.ScionAnalytics.PARAM_SOURCE, "", "throwable", "stacktrace", "", "isFatal", "", "", "attributes", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "type", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "sourceType", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "threads", "", "timeSinceAppStartNs", "<init>", "(Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/lang/String;ZLjava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;Lcom/datadog/android/rum/internal/RumErrorSourceType;Ljava/util/List;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "Lcom/datadog/android/rum/RumErrorSource;", "getSource", "()Lcom/datadog/android/rum/RumErrorSource;", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "getStacktrace", "Z", "()Z", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getType", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "getSourceType", "()Lcom/datadog/android/rum/internal/RumErrorSourceType;", "Ljava/util/List;", "getThreads", "()Ljava/util/List;", "Ljava/lang/Long;", "getTimeSinceAppStartNs", "()Ljava/lang/Long;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class AddError extends RumRawEvent {
        private final Map attributes;
        private final Time eventTime;
        private final boolean isFatal;
        private final String message;
        private final RumErrorSource source;
        private final RumErrorSourceType sourceType;
        private final String stacktrace;
        private final List threads;
        private final Throwable throwable;
        private final Long timeSinceAppStartNs;
        private final String type;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddError)) {
                return false;
            }
            AddError addError = (AddError) other;
            return Intrinsics.areEqual(this.message, addError.message) && this.source == addError.source && Intrinsics.areEqual(this.throwable, addError.throwable) && Intrinsics.areEqual(this.stacktrace, addError.stacktrace) && this.isFatal == addError.isFatal && Intrinsics.areEqual(this.attributes, addError.attributes) && Intrinsics.areEqual(this.eventTime, addError.eventTime) && Intrinsics.areEqual(this.type, addError.type) && this.sourceType == addError.sourceType && Intrinsics.areEqual(this.threads, addError.threads) && Intrinsics.areEqual(this.timeSinceAppStartNs, addError.timeSinceAppStartNs);
        }

        public int hashCode() {
            int iHashCode = ((this.message.hashCode() * 31) + this.source.hashCode()) * 31;
            Throwable th = this.throwable;
            int iHashCode2 = (iHashCode + (th == null ? 0 : th.hashCode())) * 31;
            String str = this.stacktrace;
            int iHashCode3 = (((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isFatal)) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode()) * 31;
            String str2 = this.type;
            int iHashCode4 = (((((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.sourceType.hashCode()) * 31) + this.threads.hashCode()) * 31;
            Long l = this.timeSinceAppStartNs;
            return iHashCode4 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "AddError(message=" + this.message + ", source=" + this.source + ", throwable=" + this.throwable + ", stacktrace=" + this.stacktrace + ", isFatal=" + this.isFatal + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ", type=" + this.type + ", sourceType=" + this.sourceType + ", threads=" + this.threads + ", timeSinceAppStartNs=" + this.timeSinceAppStartNs + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        public final RumErrorSource getSource() {
            return this.source;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final String getStacktrace() {
            return this.stacktrace;
        }

        /* JADX INFO: renamed from: isFatal, reason: from getter */
        public final boolean getIsFatal() {
            return this.isFatal;
        }

        public final Map getAttributes() {
            return this.attributes;
        }

        public /* synthetic */ AddError(String str, RumErrorSource rumErrorSource, Throwable th, String str2, boolean z, Map map, Time time, String str3, RumErrorSourceType rumErrorSourceType, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, rumErrorSource, th, str2, z, map, (i & 64) != 0 ? new Time(0L, 0L, 3, null) : time, (i & 128) != 0 ? null : str3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? RumErrorSourceType.ANDROID : rumErrorSourceType, list, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : l);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final String getType() {
            return this.type;
        }

        public final RumErrorSourceType getSourceType() {
            return this.sourceType;
        }

        public final List getThreads() {
            return this.threads;
        }

        public final Long getTimeSinceAppStartNs() {
            return this.timeSinceAppStartNs;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddError(String message, RumErrorSource source, Throwable th, String str, boolean z, Map attributes, Time eventTime, String str2, RumErrorSourceType sourceType, List threads, Long l) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            Intrinsics.checkNotNullParameter(threads, "threads");
            this.message = message;
            this.source = source;
            this.throwable = th;
            this.stacktrace = str;
            this.isFatal = z;
            this.attributes = attributes;
            this.eventTime = eventTime;
            this.type = str2;
            this.sourceType = sourceType;
            this.threads = threads;
            this.timeSinceAppStartNs = l;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "resourceId", "", "resourceEndTimestampInNanos", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "getResourceId", "J", "getResourceEndTimestampInNanos", "()J", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ResourceSent extends RumRawEvent {
        private final Time eventTime;
        private final long resourceEndTimestampInNanos;
        private final String resourceId;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceSent)) {
                return false;
            }
            ResourceSent resourceSent = (ResourceSent) other;
            return Intrinsics.areEqual(this.viewId, resourceSent.viewId) && Intrinsics.areEqual(this.resourceId, resourceSent.resourceId) && this.resourceEndTimestampInNanos == resourceSent.resourceEndTimestampInNanos && Intrinsics.areEqual(this.eventTime, resourceSent.eventTime);
        }

        public int hashCode() {
            return (((((this.viewId.hashCode() * 31) + this.resourceId.hashCode()) * 31) + Long.hashCode(this.resourceEndTimestampInNanos)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ResourceSent(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", resourceEndTimestampInNanos=" + this.resourceEndTimestampInNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        public /* synthetic */ ResourceSent(String str, String str2, long j, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, j, (i & 8) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceSent(String viewId, String resourceId, long j, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = resourceId;
            this.resourceEndTimestampInNanos = j;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "", "frustrationCount", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "type", "", "eventEndTimestampInNanos", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;ILcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;JLcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "I", "getFrustrationCount", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "getType", "()Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "J", "getEventEndTimestampInNanos", "()J", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ActionSent extends RumRawEvent {
        private final long eventEndTimestampInNanos;
        private final Time eventTime;
        private final int frustrationCount;
        private final ActionEvent.ActionEventActionType type;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionSent)) {
                return false;
            }
            ActionSent actionSent = (ActionSent) other;
            return Intrinsics.areEqual(this.viewId, actionSent.viewId) && this.frustrationCount == actionSent.frustrationCount && this.type == actionSent.type && this.eventEndTimestampInNanos == actionSent.eventEndTimestampInNanos && Intrinsics.areEqual(this.eventTime, actionSent.eventTime);
        }

        public int hashCode() {
            return (((((((this.viewId.hashCode() * 31) + Integer.hashCode(this.frustrationCount)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.eventEndTimestampInNanos)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ActionSent(viewId=" + this.viewId + ", frustrationCount=" + this.frustrationCount + ", type=" + this.type + ", eventEndTimestampInNanos=" + this.eventEndTimestampInNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        public /* synthetic */ ActionSent(String str, int i, ActionEvent.ActionEventActionType actionEventActionType, long j, Time time, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, actionEventActionType, j, (i2 & 16) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSent(String viewId, int i, ActionEvent.ActionEventActionType type, long j, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.frustrationCount = i;
            this.type = type;
            this.eventEndTimestampInNanos = j;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "resourceId", "", "resourceEndTimestampInNanos", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "getResourceId", "Ljava/lang/Long;", "getResourceEndTimestampInNanos", "()Ljava/lang/Long;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ErrorSent extends RumRawEvent {
        private final Time eventTime;
        private final Long resourceEndTimestampInNanos;
        private final String resourceId;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorSent)) {
                return false;
            }
            ErrorSent errorSent = (ErrorSent) other;
            return Intrinsics.areEqual(this.viewId, errorSent.viewId) && Intrinsics.areEqual(this.resourceId, errorSent.resourceId) && Intrinsics.areEqual(this.resourceEndTimestampInNanos, errorSent.resourceEndTimestampInNanos) && Intrinsics.areEqual(this.eventTime, errorSent.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.viewId.hashCode() * 31;
            String str = this.resourceId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.resourceEndTimestampInNanos;
            return ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ErrorSent(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", resourceEndTimestampInNanos=" + this.resourceEndTimestampInNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        public /* synthetic */ ErrorSent(String str, String str2, Long l, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorSent(String viewId, String str, Long l, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = str;
            this.resourceEndTimestampInNanos = l;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "", "isFrozenFrame", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;ZLcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "Z", "()Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class LongTaskSent extends RumRawEvent {
        private final Time eventTime;
        private final boolean isFrozenFrame;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskSent)) {
                return false;
            }
            LongTaskSent longTaskSent = (LongTaskSent) other;
            return Intrinsics.areEqual(this.viewId, longTaskSent.viewId) && this.isFrozenFrame == longTaskSent.isFrozenFrame && Intrinsics.areEqual(this.eventTime, longTaskSent.eventTime);
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + Boolean.hashCode(this.isFrozenFrame)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "LongTaskSent(viewId=" + this.viewId + ", isFrozenFrame=" + this.isFrozenFrame + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: isFrozenFrame, reason: from getter */
        public final boolean getIsFrozenFrame() {
            return this.isFrozenFrame;
        }

        public /* synthetic */ LongTaskSent(String str, boolean z, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongTaskSent(String viewId, boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.isFrozenFrame = z;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "resourceId", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "getResourceId", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ResourceDropped extends RumRawEvent {
        private final Time eventTime;
        private final String resourceId;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceDropped)) {
                return false;
            }
            ResourceDropped resourceDropped = (ResourceDropped) other;
            return Intrinsics.areEqual(this.viewId, resourceDropped.viewId) && Intrinsics.areEqual(this.resourceId, resourceDropped.resourceId) && Intrinsics.areEqual(this.eventTime, resourceDropped.eventTime);
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + this.resourceId.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ResourceDropped(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public /* synthetic */ ResourceDropped(String str, String str2, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceDropped(String viewId, String resourceId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = resourceId;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ActionDropped extends RumRawEvent {
        private final Time eventTime;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionDropped)) {
                return false;
            }
            ActionDropped actionDropped = (ActionDropped) other;
            return Intrinsics.areEqual(this.viewId, actionDropped.viewId) && Intrinsics.areEqual(this.eventTime, actionDropped.eventTime);
        }

        public int hashCode() {
            return (this.viewId.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ActionDropped(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public /* synthetic */ ActionDropped(String str, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionDropped(String viewId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "resourceId", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "getResourceId", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ErrorDropped extends RumRawEvent {
        private final Time eventTime;
        private final String resourceId;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorDropped)) {
                return false;
            }
            ErrorDropped errorDropped = (ErrorDropped) other;
            return Intrinsics.areEqual(this.viewId, errorDropped.viewId) && Intrinsics.areEqual(this.resourceId, errorDropped.resourceId) && Intrinsics.areEqual(this.eventTime, errorDropped.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.viewId.hashCode() * 31;
            String str = this.resourceId;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ErrorDropped(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public /* synthetic */ ErrorDropped(String str, String str2, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorDropped(String viewId, String str, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = str;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "viewId", "", "isFrozenFrame", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;ZLcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getViewId", "Z", "()Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class LongTaskDropped extends RumRawEvent {
        private final Time eventTime;
        private final boolean isFrozenFrame;
        private final String viewId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskDropped)) {
                return false;
            }
            LongTaskDropped longTaskDropped = (LongTaskDropped) other;
            return Intrinsics.areEqual(this.viewId, longTaskDropped.viewId) && this.isFrozenFrame == longTaskDropped.isFrozenFrame && Intrinsics.areEqual(this.eventTime, longTaskDropped.eventTime);
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + Boolean.hashCode(this.isFrozenFrame)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "LongTaskDropped(viewId=" + this.viewId + ", isFrozenFrame=" + this.isFrozenFrame + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: isFrozenFrame, reason: from getter */
        public final boolean getIsFrozenFrame() {
            return this.isFrozenFrame;
        }

        public /* synthetic */ LongTaskDropped(String str, boolean z, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongTaskDropped(String viewId, boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.isFrozenFrame = z;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$KeepAlive;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class KeepAlive extends RumRawEvent {
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof KeepAlive) && Intrinsics.areEqual(this.eventTime, ((KeepAlive) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "KeepAlive(eventTime=" + this.eventTime + ")";
        }

        public /* synthetic */ KeepAlive(Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeepAlive(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "", "applicationStartupNanos", "<init>", "(Lcom/datadog/android/rum/internal/domain/Time;J)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "J", "getApplicationStartupNanos", "()J", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class ApplicationStarted extends RumRawEvent {
        private final long applicationStartupNanos;
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApplicationStarted)) {
                return false;
            }
            ApplicationStarted applicationStarted = (ApplicationStarted) other;
            return Intrinsics.areEqual(this.eventTime, applicationStarted.eventTime) && this.applicationStartupNanos == applicationStarted.applicationStartupNanos;
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + Long.hashCode(this.applicationStartupNanos);
        }

        public String toString() {
            return "ApplicationStarted(eventTime=" + this.eventTime + ", applicationStartupNanos=" + this.applicationStartupNanos + ")";
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final long getApplicationStartupNanos() {
            return this.applicationStartupNanos;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplicationStarted(Time eventTime, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
            this.applicationStartupNanos = j;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "name", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class AddCustomTiming extends RumRawEvent {
        private final Time eventTime;
        private final String name;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddCustomTiming)) {
                return false;
            }
            AddCustomTiming addCustomTiming = (AddCustomTiming) other;
            return Intrinsics.areEqual(this.name, addCustomTiming.name) && Intrinsics.areEqual(this.eventTime, addCustomTiming.eventTime);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddCustomTiming(name=" + this.name + ", eventTime=" + this.eventTime + ")";
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ AddCustomTiming(String str, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddCustomTiming(String name, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewLoadingTime;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "overwrite", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(ZLcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "getOverwrite", "()Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class AddViewLoadingTime extends RumRawEvent {
        private final Time eventTime;
        private final boolean overwrite;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddViewLoadingTime)) {
                return false;
            }
            AddViewLoadingTime addViewLoadingTime = (AddViewLoadingTime) other;
            return this.overwrite == addViewLoadingTime.overwrite && Intrinsics.areEqual(this.eventTime, addViewLoadingTime.eventTime);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.overwrite) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddViewLoadingTime(overwrite=" + this.overwrite + ", eventTime=" + this.eventTime + ")";
        }

        public final boolean getOverwrite() {
            return this.overwrite;
        }

        public /* synthetic */ AddViewLoadingTime(boolean z, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddViewLoadingTime(boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.overwrite = z;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "durationNs", "", "target", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(JLjava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getDurationNs", "()J", "Ljava/lang/String;", "getTarget", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class AddLongTask extends RumRawEvent {
        private final long durationNs;
        private final Time eventTime;
        private final String target;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddLongTask)) {
                return false;
            }
            AddLongTask addLongTask = (AddLongTask) other;
            return this.durationNs == addLongTask.durationNs && Intrinsics.areEqual(this.target, addLongTask.target) && Intrinsics.areEqual(this.eventTime, addLongTask.eventTime);
        }

        public int hashCode() {
            return (((Long.hashCode(this.durationNs) * 31) + this.target.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddLongTask(durationNs=" + this.durationNs + ", target=" + this.target + ", eventTime=" + this.eventTime + ")";
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final String getTarget() {
            return this.target;
        }

        public /* synthetic */ AddLongTask(long j, String str, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddLongTask(long j, String target, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.durationNs = j;
            this.target = target;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SendCustomActionNow;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class SendCustomActionNow extends RumRawEvent {
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SendCustomActionNow) && Intrinsics.areEqual(this.eventTime, ((SendCustomActionNow) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "SendCustomActionNow(eventTime=" + this.eventTime + ")";
        }

        public /* synthetic */ SendCustomActionNow(Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendCustomActionNow(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "name", "", "value", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class AddFeatureFlagEvaluation extends RumRawEvent {
        private final Time eventTime;
        private final String name;
        private final Object value;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddFeatureFlagEvaluation)) {
                return false;
            }
            AddFeatureFlagEvaluation addFeatureFlagEvaluation = (AddFeatureFlagEvaluation) other;
            return Intrinsics.areEqual(this.name, addFeatureFlagEvaluation.name) && Intrinsics.areEqual(this.value, addFeatureFlagEvaluation.value) && Intrinsics.areEqual(this.eventTime, addFeatureFlagEvaluation.eventTime);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddFeatureFlagEvaluation(name=" + this.name + ", value=" + this.value + ", eventTime=" + this.eventTime + ")";
        }

        public final String getName() {
            return this.name;
        }

        public final Object getValue() {
            return this.value;
        }

        public /* synthetic */ AddFeatureFlagEvaluation(String str, Object obj, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, obj, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddFeatureFlagEvaluation(String name, Object value, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.value = value;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class StopSession extends RumRawEvent {
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StopSession) && Intrinsics.areEqual(this.eventTime, ((StopSession) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "StopSession(eventTime=" + this.eventTime + ")";
        }

        public /* synthetic */ StopSession(Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopSession(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdatePerformanceMetric;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/RumPerformanceMetric;", "metric", "", "value", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/RumPerformanceMetric;DLcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/RumPerformanceMetric;", "getMetric", "()Lcom/datadog/android/rum/RumPerformanceMetric;", "D", "getValue", "()D", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class UpdatePerformanceMetric extends RumRawEvent {
        private final Time eventTime;
        private final RumPerformanceMetric metric;
        private final double value;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatePerformanceMetric)) {
                return false;
            }
            UpdatePerformanceMetric updatePerformanceMetric = (UpdatePerformanceMetric) other;
            return this.metric == updatePerformanceMetric.metric && Double.compare(this.value, updatePerformanceMetric.value) == 0 && Intrinsics.areEqual(this.eventTime, updatePerformanceMetric.eventTime);
        }

        public int hashCode() {
            return (((this.metric.hashCode() * 31) + Double.hashCode(this.value)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "UpdatePerformanceMetric(metric=" + this.metric + ", value=" + this.value + ", eventTime=" + this.eventTime + ")";
        }

        public final RumPerformanceMetric getMetric() {
            return this.metric;
        }

        public final double getValue() {
            return this.value;
        }

        public /* synthetic */ UpdatePerformanceMetric(RumPerformanceMetric rumPerformanceMetric, double d, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rumPerformanceMetric, d, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatePerformanceMetric(RumPerformanceMetric metric, double d, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.metric = metric;
            this.value = d;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetSyntheticsTestAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "testId", "resultId", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTestId", "getResultId", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class SetSyntheticsTestAttribute extends RumRawEvent {
        private final Time eventTime;
        private final String resultId;
        private final String testId;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetSyntheticsTestAttribute)) {
                return false;
            }
            SetSyntheticsTestAttribute setSyntheticsTestAttribute = (SetSyntheticsTestAttribute) other;
            return Intrinsics.areEqual(this.testId, setSyntheticsTestAttribute.testId) && Intrinsics.areEqual(this.resultId, setSyntheticsTestAttribute.resultId) && Intrinsics.areEqual(this.eventTime, setSyntheticsTestAttribute.eventTime);
        }

        public int hashCode() {
            return (((this.testId.hashCode() * 31) + this.resultId.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "SetSyntheticsTestAttribute(testId=" + this.testId + ", resultId=" + this.resultId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getTestId() {
            return this.testId;
        }

        public final String getResultId() {
            return this.resultId;
        }

        public /* synthetic */ SetSyntheticsTestAttribute(String str, String str2, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetSyntheticsTestAttribute(String testId, String resultId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.testId = testId;
            this.resultId = resultId;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WebViewEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class WebViewEvent extends RumRawEvent {
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WebViewEvent) && Intrinsics.areEqual(this.eventTime, ((WebViewEvent) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "WebViewEvent(eventTime=" + this.eventTime + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewEvent(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }

        public /* synthetic */ WebViewEvent(Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$TelemetryEventWrapper;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "event", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;Lcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "getEvent", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class TelemetryEventWrapper extends RumRawEvent {
        private final InternalTelemetryEvent event;
        private final Time eventTime;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TelemetryEventWrapper)) {
                return false;
            }
            TelemetryEventWrapper telemetryEventWrapper = (TelemetryEventWrapper) other;
            return Intrinsics.areEqual(this.event, telemetryEventWrapper.event) && Intrinsics.areEqual(this.eventTime, telemetryEventWrapper.eventTime);
        }

        public int hashCode() {
            return (this.event.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "TelemetryEventWrapper(event=" + this.event + ", eventTime=" + this.eventTime + ")";
        }

        public final InternalTelemetryEvent getEvent() {
            return this.event;
        }

        public /* synthetic */ TelemetryEventWrapper(InternalTelemetryEvent internalTelemetryEvent, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(internalTelemetryEvent, (i & 2) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TelemetryEventWrapper(InternalTelemetryEvent event, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.event = event;
            this.eventTime = eventTime;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SdkInit;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "isAppInForeground", "Lcom/datadog/android/rum/internal/domain/Time;", "eventTime", "<init>", "(ZLcom/datadog/android/rum/internal/domain/Time;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    public static final /* data */ class SdkInit extends RumRawEvent {
        private final Time eventTime;
        private final boolean isAppInForeground;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SdkInit)) {
                return false;
            }
            SdkInit sdkInit = (SdkInit) other;
            return this.isAppInForeground == sdkInit.isAppInForeground && Intrinsics.areEqual(this.eventTime, sdkInit.eventTime);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isAppInForeground) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "SdkInit(isAppInForeground=" + this.isAppInForeground + ", eventTime=" + this.eventTime + ")";
        }

        /* JADX INFO: renamed from: isAppInForeground, reason: from getter */
        public final boolean getIsAppInForeground() {
            return this.isAppInForeground;
        }

        public /* synthetic */ SdkInit(boolean z, Time time, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? new Time(0L, 0L, 3, null) : time);
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkInit(boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.isAppInForeground = z;
            this.eventTime = eventTime;
        }
    }
}
