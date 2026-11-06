package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumEventDeserializer implements Deserializer {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public RumEventDeserializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public Object deserialize(final JsonObject model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            JsonPrimitive asJsonPrimitive = model.getAsJsonPrimitive("type");
            return parseEvent(asJsonPrimitive != null ? asJsonPrimitive.getAsString() : null, model);
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventDeserializer.deserialize.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the RumEvent: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventDeserializer.deserialize.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the RumEvent: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object parseEvent(String str, JsonObject jsonObject) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1422950858:
                    if (str.equals("action")) {
                        return ActionEvent.Companion.fromJsonObject(jsonObject);
                    }
                    break;
                case -341064690:
                    if (str.equals("resource")) {
                        return ResourceEvent.Companion.fromJsonObject(jsonObject);
                    }
                    break;
                case 3619493:
                    if (str.equals("view")) {
                        return ViewEvent.Companion.fromJsonObject(jsonObject);
                    }
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        return ErrorEvent.Companion.fromJsonObject(jsonObject);
                    }
                    break;
                case 128111976:
                    if (str.equals("long_task")) {
                        return LongTaskEvent.Companion.fromJsonObject(jsonObject);
                    }
                    break;
                case 780346297:
                    if (str.equals("telemetry")) {
                        String asString = jsonObject.getAsJsonObject("telemetry").getAsJsonPrimitive("status").getAsString();
                        if (Intrinsics.areEqual(asString, "debug")) {
                            return TelemetryDebugEvent.Companion.fromJsonObject(jsonObject);
                        }
                        if (Intrinsics.areEqual(asString, "error")) {
                            return TelemetryErrorEvent.Companion.fromJsonObject(jsonObject);
                        }
                        throw new JsonParseException("We could not deserialize the telemetry event with status: " + asString);
                    }
                    break;
            }
        }
        throw new JsonParseException("We could not deserialize the event with type: " + str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
