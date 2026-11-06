package com.datadog.android.internal.telemetry;

import com.datadog.android.internal.utils.ThrowableExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InternalTelemetryEvent {
    public /* synthetic */ InternalTelemetryEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InternalTelemetryEvent() {
    }

    public static abstract class Log extends InternalTelemetryEvent {
        private final Map additionalProperties;
        private final String message;

        public /* synthetic */ Log(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, map);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        public static final class Debug extends Log {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Debug(String message, Map map) {
                super(message, map, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        private Log(String str, Map map) {
            super(null);
            this.message = str;
            this.additionalProperties = map;
        }

        public static final class Error extends Log {
            private final Throwable error;
            private final String kind;
            private final String stacktrace;

            public /* synthetic */ Error(String str, Map map, Throwable th, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
            }

            public final String getKind() {
                return this.kind;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message, Map map, Throwable th, String str, String str2) {
                super(message, map, null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.error = th;
                this.stacktrace = str;
                this.kind = str2;
            }

            public final String resolveKind() {
                String canonicalName = this.kind;
                if (canonicalName == null) {
                    Throwable th = this.error;
                    canonicalName = th != null ? th.getClass().getCanonicalName() : null;
                    if (canonicalName == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            return th2.getClass().getSimpleName();
                        }
                        return null;
                    }
                }
                return canonicalName;
            }

            public final String resolveStacktrace() {
                String str = this.stacktrace;
                if (str != null) {
                    return str;
                }
                Throwable th = this.error;
                if (th != null) {
                    return ThrowableExtKt.loggableStackTrace(th);
                }
                return null;
            }
        }
    }

    public static final class Configuration extends InternalTelemetryEvent {
        private final int batchProcessingLevel;
        private final long batchSize;
        private final long batchUploadFrequency;
        private final boolean trackErrors;
        private final boolean useLocalEncryption;
        private final boolean useProxy;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return this.trackErrors == configuration.trackErrors && this.batchSize == configuration.batchSize && this.batchUploadFrequency == configuration.batchUploadFrequency && this.useProxy == configuration.useProxy && this.useLocalEncryption == configuration.useLocalEncryption && this.batchProcessingLevel == configuration.batchProcessingLevel;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.trackErrors) * 31) + Long.hashCode(this.batchSize)) * 31) + Long.hashCode(this.batchUploadFrequency)) * 31) + Boolean.hashCode(this.useProxy)) * 31) + Boolean.hashCode(this.useLocalEncryption)) * 31) + Integer.hashCode(this.batchProcessingLevel);
        }

        public String toString() {
            return "Configuration(trackErrors=" + this.trackErrors + ", batchSize=" + this.batchSize + ", batchUploadFrequency=" + this.batchUploadFrequency + ", useProxy=" + this.useProxy + ", useLocalEncryption=" + this.useLocalEncryption + ", batchProcessingLevel=" + this.batchProcessingLevel + ")";
        }

        public final boolean getTrackErrors() {
            return this.trackErrors;
        }

        public final long getBatchSize() {
            return this.batchSize;
        }

        public final long getBatchUploadFrequency() {
            return this.batchUploadFrequency;
        }

        public final boolean getUseProxy() {
            return this.useProxy;
        }

        public final boolean getUseLocalEncryption() {
            return this.useLocalEncryption;
        }

        public final int getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public Configuration(boolean z, long j, long j2, boolean z2, boolean z3, int i) {
            super(null);
            this.trackErrors = z;
            this.batchSize = j;
            this.batchUploadFrequency = j2;
            this.useProxy = z2;
            this.useLocalEncryption = z3;
            this.batchProcessingLevel = i;
        }
    }

    public static final class Metric extends InternalTelemetryEvent {
        private final Map additionalProperties;
        private final String message;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metric)) {
                return false;
            }
            Metric metric = (Metric) obj;
            return Intrinsics.areEqual(this.message, metric.message) && Intrinsics.areEqual(this.additionalProperties, metric.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            Map map = this.additionalProperties;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "Metric(message=" + this.message + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Metric(String message, Map map) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.additionalProperties = map;
        }
    }

    public static abstract class ApiUsage extends InternalTelemetryEvent {
        private final Map additionalProperties;

        public /* synthetic */ ApiUsage(Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(map);
        }

        public final Map getAdditionalProperties() {
            return this.additionalProperties;
        }

        private ApiUsage(Map map) {
            super(null);
            this.additionalProperties = map;
        }

        public static final class AddViewLoadingTime extends ApiUsage {
            private final boolean noActiveView;
            private final boolean noView;
            private final boolean overwrite;

            public final boolean getOverwrite() {
                return this.overwrite;
            }

            public final boolean getNoView() {
                return this.noView;
            }

            public final boolean getNoActiveView() {
                return this.noActiveView;
            }

            public /* synthetic */ AddViewLoadingTime(boolean z, boolean z2, boolean z3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(z, z2, z3, (i & 8) != 0 ? new LinkedHashMap() : map);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddViewLoadingTime(boolean z, boolean z2, boolean z3, Map additionalProperties) {
                super(additionalProperties, null);
                Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
                this.overwrite = z;
                this.noView = z2;
                this.noActiveView = z3;
            }
        }
    }
}
