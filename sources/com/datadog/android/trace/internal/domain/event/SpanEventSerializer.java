package com.datadog.android.trace.internal.domain.event;

import com.adjust.sdk.network.ErrorCodes;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.constraints.DataConstraints;
import com.datadog.android.core.constraints.DatadogDataConstraints;
import com.datadog.android.internal.utils.MapUtilsKt;
import com.datadog.android.trace.internal.storage.ContextAwareSerializer;
import com.datadog.android.trace.model.SpanEvent;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SpanEventSerializer implements ContextAwareSerializer {
    public static final Companion Companion = new Companion(null);
    private final DataConstraints dataConstraints;
    private final InternalLogger internalLogger;

    public SpanEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.internalLogger = internalLogger;
        this.dataConstraints = dataConstraints;
    }

    public /* synthetic */ SpanEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new DatadogDataConstraints(internalLogger) : dataConstraints);
    }

    @Override // com.datadog.android.trace.internal.storage.ContextAwareSerializer
    public String serialize(DatadogContext datadogContext, SpanEvent model) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(model, "model");
        JsonElement json = sanitizeKeys(model).toJson();
        JsonArray jsonArray = new JsonArray(1);
        jsonArray.add(json);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("spans", jsonArray);
        jsonObject.addProperty("env", datadogContext.getEnv());
        String string = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }

    private final SpanEvent sanitizeKeys(SpanEvent spanEvent) {
        return spanEvent.copy((511 & 1) != 0 ? spanEvent.traceId : null, (511 & 2) != 0 ? spanEvent.spanId : null, (511 & 4) != 0 ? spanEvent.parentId : null, (511 & 8) != 0 ? spanEvent.resource : null, (511 & 16) != 0 ? spanEvent.name : null, (511 & 32) != 0 ? spanEvent.service : null, (511 & 64) != 0 ? spanEvent.duration : 0L, (511 & 128) != 0 ? spanEvent.start : 0L, (511 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? spanEvent.error : 0L, (511 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? spanEvent.metrics : sanitizeMetrics(spanEvent.getMetrics()), (511 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? spanEvent.meta : SpanEvent.Meta.copy$default(spanEvent.getMeta(), null, null, null, null, sanitizeUserAttributes(spanEvent.getMeta().getUsr()), null, null, null, null, null, ErrorCodes.IO_EXCEPTION, null));
    }

    private final SpanEvent.Usr sanitizeUserAttributes(SpanEvent.Usr usr) {
        String metaString;
        Map mapValidateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, usr.getAdditionalProperties(), "meta.usr", null, null, 12, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapValidateAttributes$default.size()));
        for (final Map.Entry entry : mapValidateAttributes$default.entrySet()) {
            Object key = entry.getKey();
            try {
                metaString = toMetaString(entry.getValue());
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.trace.internal.domain.event.SpanEventSerializer$sanitizeUserAttributes$transformedAttributes$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Error converting value for key " + entry.getKey() + " to meta string, it will be dropped.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                metaString = null;
            }
            linkedHashMap.put(key, metaString);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((String) entry2.getValue()) != null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return SpanEvent.Usr.copy$default(usr, null, null, null, MapsKt.toMutableMap(linkedHashMap2), 7, null);
    }

    private final SpanEvent.Metrics sanitizeMetrics(SpanEvent.Metrics metrics) {
        return SpanEvent.Metrics.copy$default(metrics, null, DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, metrics.getAdditionalProperties(), "metrics", null, null, 12, null), 1, null);
    }

    private final String toMetaString(Object obj) {
        if (Intrinsics.areEqual(obj, MapUtilsKt.getNULL_MAP_VALUE()) || obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        }
        return obj instanceof JsonPrimitive ? ((JsonPrimitive) obj).getAsString() : obj.toString();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
