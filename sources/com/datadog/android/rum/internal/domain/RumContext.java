package com.datadog.android.rum.internal.domain;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.Map;
import java.util.UUID;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class RumContext {
    public static final Companion Companion = new Companion(null);
    private static final String NULL_UUID;
    private final String actionId;
    private final String applicationId;
    private final boolean hasReplay;
    private final boolean isSessionActive;
    private final String sessionId;
    private final RumSessionScope.StartReason sessionStartReason;
    private final RumSessionScope.State sessionState;
    private final String syntheticsResultId;
    private final String syntheticsTestId;
    private final String viewId;
    private final String viewName;
    private final long viewTimestamp;
    private final long viewTimestampOffset;
    private final RumViewType viewType;
    private final String viewUrl;

    public final RumContext copy(String applicationId, String sessionId, boolean z, String str, String str2, String str3, String str4, RumSessionScope.State sessionState, RumSessionScope.StartReason sessionStartReason, RumViewType viewType, String str5, String str6, long j, long j2, boolean z2) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(sessionStartReason, "sessionStartReason");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        return new RumContext(applicationId, sessionId, z, str, str2, str3, str4, sessionState, sessionStartReason, viewType, str5, str6, j, j2, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumContext)) {
            return false;
        }
        RumContext rumContext = (RumContext) obj;
        return Intrinsics.areEqual(this.applicationId, rumContext.applicationId) && Intrinsics.areEqual(this.sessionId, rumContext.sessionId) && this.isSessionActive == rumContext.isSessionActive && Intrinsics.areEqual(this.viewId, rumContext.viewId) && Intrinsics.areEqual(this.viewName, rumContext.viewName) && Intrinsics.areEqual(this.viewUrl, rumContext.viewUrl) && Intrinsics.areEqual(this.actionId, rumContext.actionId) && this.sessionState == rumContext.sessionState && this.sessionStartReason == rumContext.sessionStartReason && this.viewType == rumContext.viewType && Intrinsics.areEqual(this.syntheticsTestId, rumContext.syntheticsTestId) && Intrinsics.areEqual(this.syntheticsResultId, rumContext.syntheticsResultId) && this.viewTimestamp == rumContext.viewTimestamp && this.viewTimestampOffset == rumContext.viewTimestampOffset && this.hasReplay == rumContext.hasReplay;
    }

    public int hashCode() {
        int iHashCode = ((((this.applicationId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.isSessionActive)) * 31;
        String str = this.viewId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.viewName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.viewUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actionId;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sessionState.hashCode()) * 31) + this.sessionStartReason.hashCode()) * 31) + this.viewType.hashCode()) * 31;
        String str5 = this.syntheticsTestId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.syntheticsResultId;
        return ((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + Long.hashCode(this.viewTimestamp)) * 31) + Long.hashCode(this.viewTimestampOffset)) * 31) + Boolean.hashCode(this.hasReplay);
    }

    public String toString() {
        return "RumContext(applicationId=" + this.applicationId + ", sessionId=" + this.sessionId + ", isSessionActive=" + this.isSessionActive + ", viewId=" + this.viewId + ", viewName=" + this.viewName + ", viewUrl=" + this.viewUrl + ", actionId=" + this.actionId + ", sessionState=" + this.sessionState + ", sessionStartReason=" + this.sessionStartReason + ", viewType=" + this.viewType + ", syntheticsTestId=" + this.syntheticsTestId + ", syntheticsResultId=" + this.syntheticsResultId + ", viewTimestamp=" + this.viewTimestamp + ", viewTimestampOffset=" + this.viewTimestampOffset + ", hasReplay=" + this.hasReplay + ")";
    }

    public RumContext(String applicationId, String sessionId, boolean z, String str, String str2, String str3, String str4, RumSessionScope.State sessionState, RumSessionScope.StartReason sessionStartReason, RumViewType viewType, String str5, String str6, long j, long j2, boolean z2) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(sessionStartReason, "sessionStartReason");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.applicationId = applicationId;
        this.sessionId = sessionId;
        this.isSessionActive = z;
        this.viewId = str;
        this.viewName = str2;
        this.viewUrl = str3;
        this.actionId = str4;
        this.sessionState = sessionState;
        this.sessionStartReason = sessionStartReason;
        this.viewType = viewType;
        this.syntheticsTestId = str5;
        this.syntheticsResultId = str6;
        this.viewTimestamp = j;
        this.viewTimestampOffset = j2;
        this.hasReplay = z2;
    }

    public /* synthetic */ RumContext(String str, String str2, boolean z, String str3, String str4, String str5, String str6, RumSessionScope.State state, RumSessionScope.StartReason startReason, RumViewType rumViewType, String str7, String str8, long j, long j2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NULL_UUID : str, (i & 2) != 0 ? NULL_UUID : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? RumSessionScope.State.NOT_TRACKED : state, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? RumSessionScope.StartReason.USER_APP_LAUNCH : startReason, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? RumViewType.NONE : rumViewType, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str7, (i & 2048) == 0 ? str8 : null, (i & 4096) != 0 ? 0L : j, (i & 8192) == 0 ? j2 : 0L, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? false : z2);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean isSessionActive() {
        return this.isSessionActive;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final String getViewUrl() {
        return this.viewUrl;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final RumSessionScope.State getSessionState() {
        return this.sessionState;
    }

    public final RumSessionScope.StartReason getSessionStartReason() {
        return this.sessionStartReason;
    }

    public final RumViewType getViewType() {
        return this.viewType;
    }

    public final String getSyntheticsTestId() {
        return this.syntheticsTestId;
    }

    public final String getSyntheticsResultId() {
        return this.syntheticsResultId;
    }

    public final Map toMap() {
        return MapsKt.mapOf(TuplesKt.to("application_id", this.applicationId), TuplesKt.to("session_id", this.sessionId), TuplesKt.to("session_active", Boolean.valueOf(this.isSessionActive)), TuplesKt.to("session_state", this.sessionState.getAsString()), TuplesKt.to("session_start_reason", this.sessionStartReason.getAsString()), TuplesKt.to("view_id", this.viewId), TuplesKt.to("view_name", this.viewName), TuplesKt.to("view_url", this.viewUrl), TuplesKt.to("view_type", this.viewType.getAsString()), TuplesKt.to("action_id", this.actionId), TuplesKt.to("synthetics_test_id", this.syntheticsTestId), TuplesKt.to("synthetics_result_id", this.syntheticsResultId), TuplesKt.to("view_timestamp", Long.valueOf(this.viewTimestamp)), TuplesKt.to("view_has_replay", Boolean.valueOf(this.hasReplay)), TuplesKt.to("view_timestamp_offset", Long.valueOf(this.viewTimestampOffset)));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getNULL_UUID() {
            return RumContext.NULL_UUID;
        }

        public final RumContext fromFeatureContext(Map featureContext) {
            Intrinsics.checkNotNullParameter(featureContext, "featureContext");
            Object obj = featureContext.get("application_id");
            String null_uuid = obj instanceof String ? (String) obj : null;
            Object obj2 = featureContext.get("session_id");
            String null_uuid2 = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = featureContext.get("session_active");
            Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            RumSessionScope.State.Companion companion = RumSessionScope.State.Companion;
            Object obj4 = featureContext.get("session_state");
            RumSessionScope.State stateFromString = companion.fromString(obj4 instanceof String ? (String) obj4 : null);
            RumSessionScope.StartReason.Companion companion2 = RumSessionScope.StartReason.Companion;
            Object obj5 = featureContext.get("session_start_reason");
            RumSessionScope.StartReason startReasonFromString = companion2.fromString(obj5 instanceof String ? (String) obj5 : null);
            Object obj6 = featureContext.get("view_id");
            String str = obj6 instanceof String ? (String) obj6 : null;
            Object obj7 = featureContext.get("view_name");
            String str2 = obj7 instanceof String ? (String) obj7 : null;
            Object obj8 = featureContext.get("view_url");
            String str3 = obj8 instanceof String ? (String) obj8 : null;
            RumViewType.Companion companion3 = RumViewType.Companion;
            Object obj9 = featureContext.get("view_type");
            RumViewType rumViewTypeFromString = companion3.fromString(obj9 instanceof String ? (String) obj9 : null);
            Object obj10 = featureContext.get("action_id");
            String str4 = obj10 instanceof String ? (String) obj10 : null;
            Object obj11 = featureContext.get("synthetics_test_id");
            String str5 = obj11 instanceof String ? (String) obj11 : null;
            Object obj12 = featureContext.get("synthetics_result_id");
            String str6 = obj12 instanceof String ? (String) obj12 : null;
            Object obj13 = featureContext.get("view_has_replay");
            Boolean bool2 = obj13 instanceof Boolean ? (Boolean) obj13 : null;
            boolean zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
            Object obj14 = featureContext.get("view_timestamp");
            Long l = obj14 instanceof Long ? (Long) obj14 : null;
            long jLongValue = l != null ? l.longValue() : 0L;
            Object obj15 = featureContext.get("view_timestamp_offset");
            Long l2 = obj15 instanceof Long ? (Long) obj15 : null;
            long jLongValue2 = l2 != null ? l2.longValue() : 0L;
            if (null_uuid == null) {
                null_uuid = getNULL_UUID();
            }
            if (null_uuid2 == null) {
                null_uuid2 = getNULL_UUID();
            }
            String str7 = null_uuid2;
            boolean zBooleanValue2 = bool != null ? bool.booleanValue() : false;
            if (stateFromString == null) {
                stateFromString = RumSessionScope.State.NOT_TRACKED;
            }
            RumSessionScope.State state = stateFromString;
            if (startReasonFromString == null) {
                startReasonFromString = RumSessionScope.StartReason.USER_APP_LAUNCH;
            }
            RumSessionScope.StartReason startReason = startReasonFromString;
            if (rumViewTypeFromString == null) {
                rumViewTypeFromString = RumViewType.NONE;
            }
            return new RumContext(null_uuid, str7, zBooleanValue2, str, str2, str3, str4, state, startReason, rumViewTypeFromString, str5, str6, jLongValue, jLongValue2, zBooleanValue);
        }
    }

    static {
        String string = new UUID(0L, 0L).toString();
        Intrinsics.checkNotNullExpressionValue(string, "UUID(0, 0).toString()");
        NULL_UUID = string;
    }
}
