package com.datadog.android.ndk.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NdkCrashLog {
    public static final Companion Companion = new Companion(null);
    private final String message;
    private final int signal;
    private final String signalName;
    private final String stacktrace;
    private final Long timeSinceAppStartMs;
    private final long timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NdkCrashLog)) {
            return false;
        }
        NdkCrashLog ndkCrashLog = (NdkCrashLog) obj;
        return this.signal == ndkCrashLog.signal && this.timestamp == ndkCrashLog.timestamp && Intrinsics.areEqual(this.timeSinceAppStartMs, ndkCrashLog.timeSinceAppStartMs) && Intrinsics.areEqual(this.signalName, ndkCrashLog.signalName) && Intrinsics.areEqual(this.message, ndkCrashLog.message) && Intrinsics.areEqual(this.stacktrace, ndkCrashLog.stacktrace);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.signal) * 31) + Long.hashCode(this.timestamp)) * 31;
        Long l = this.timeSinceAppStartMs;
        return ((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.signalName.hashCode()) * 31) + this.message.hashCode()) * 31) + this.stacktrace.hashCode();
    }

    public String toString() {
        return "NdkCrashLog(signal=" + this.signal + ", timestamp=" + this.timestamp + ", timeSinceAppStartMs=" + this.timeSinceAppStartMs + ", signalName=" + this.signalName + ", message=" + this.message + ", stacktrace=" + this.stacktrace + ")";
    }

    public NdkCrashLog(int i, long j, Long l, String signalName, String message, String stacktrace) {
        Intrinsics.checkNotNullParameter(signalName, "signalName");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        this.signal = i;
        this.timestamp = j;
        this.timeSinceAppStartMs = l;
        this.signalName = signalName;
        this.message = message;
        this.stacktrace = stacktrace;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Long getTimeSinceAppStartMs() {
        return this.timeSinceAppStartMs;
    }

    public final String getSignalName() {
        return this.signalName;
    }

    public final String getStacktrace() {
        return this.stacktrace;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NdkCrashLog fromJson$dd_sdk_android_core_release(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JsonObject asJsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            int asInt = asJsonObject.get("signal").getAsInt();
            long asLong = asJsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY).getAsLong();
            JsonElement jsonElement = asJsonObject.get("time_since_app_start_ms");
            Long lValueOf = null;
            if (jsonElement != null && !(jsonElement instanceof JsonNull)) {
                lValueOf = Long.valueOf(jsonElement.getAsLong());
            }
            String asString = asJsonObject.get("signal_name").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(SIGNAL_NAME_KEY_NAME).asString");
            String asString2 = asJsonObject.get("message").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(MESSAGE_KEY_NAME).asString");
            String asString3 = asJsonObject.get("stacktrace").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject.get(STACKTRACE_KEY_NAME).asString");
            return new NdkCrashLog(asInt, asLong, lValueOf, asString, asString2, asString3);
        }
    }
}
