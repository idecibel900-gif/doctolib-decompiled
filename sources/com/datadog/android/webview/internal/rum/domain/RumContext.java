package com.datadog.android.webview.internal.rum.domain;

import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumContext {
    public static final Companion Companion = new Companion(null);
    private static final String NULL_UUID;
    private final String applicationId;
    private final String sessionId;
    private final String sessionState;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumContext)) {
            return false;
        }
        RumContext rumContext = (RumContext) obj;
        return Intrinsics.areEqual(this.applicationId, rumContext.applicationId) && Intrinsics.areEqual(this.sessionId, rumContext.sessionId) && Intrinsics.areEqual(this.sessionState, rumContext.sessionState);
    }

    public int hashCode() {
        return (((this.applicationId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.sessionState.hashCode();
    }

    public String toString() {
        return "RumContext(applicationId=" + this.applicationId + ", sessionId=" + this.sessionId + ", sessionState=" + this.sessionState + ")";
    }

    public RumContext(String applicationId, String sessionId, String sessionState) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        this.applicationId = applicationId;
        this.sessionId = sessionId;
        this.sessionState = sessionState;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionState() {
        return this.sessionState;
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
    }

    static {
        String string = new UUID(0L, 0L).toString();
        Intrinsics.checkNotNullExpressionValue(string, "UUID(0, 0).toString()");
        NULL_UUID = string;
    }
}
