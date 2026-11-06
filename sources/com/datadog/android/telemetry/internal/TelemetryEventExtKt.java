package com.datadog.android.telemetry.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TelemetryEventExtKt {
    public static final TelemetryDebugEvent.Source tryFromSource(TelemetryDebugEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryErrorEvent.Source tryFromSource(TelemetryErrorEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryUsageEvent.Source tryFromSource(TelemetryUsageEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TelemetryConfigurationEvent.Source tryFromSource(TelemetryConfigurationEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.telemetry.internal.TelemetryEventExtKt.tryFromSource.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
