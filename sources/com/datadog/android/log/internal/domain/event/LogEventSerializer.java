package com.datadog.android.log.internal.domain.event;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.constraints.DataConstraints;
import com.datadog.android.core.constraints.DatadogDataConstraints;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.log.model.LogEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LogEventSerializer implements Serializer {
    public static final Companion Companion = new Companion(null);
    private final DataConstraints dataConstraints;
    private final InternalLogger internalLogger;

    public LogEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.internalLogger = internalLogger;
        this.dataConstraints = dataConstraints;
    }

    public /* synthetic */ LogEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new DatadogDataConstraints(internalLogger) : dataConstraints);
    }

    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(LogEvent model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = sanitizeTagsAndAttributes(model).toJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "sanitizeTagsAndAttribute…odel).toJson().toString()");
        return string;
    }

    private final LogEvent sanitizeTagsAndAttributes(LogEvent logEvent) {
        String strJoinToString$default = CollectionsKt.joinToString$default(this.dataConstraints.validateTags(StringsKt.split$default((CharSequence) logEvent.getDdtags(), new String[]{f.a}, false, 0, 6, (Object) null)), f.a, null, null, 0, null, null, 62, null);
        Map mapValidateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, logEvent.getAdditionalProperties(), null, null, null, 14, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapValidateAttributes$default.entrySet()) {
            if (!StringsKt.isBlank((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LogEvent.Usr usr = logEvent.getUsr();
        return LogEvent.copy$default(logEvent, null, null, null, null, null, null, usr != null ? LogEvent.Usr.copy$default(usr, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, usr.getAdditionalProperties(), "usr", "user extra information", null, 8, null), this.internalLogger)), 7, null) : null, null, null, null, null, strJoinToString$default, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(linkedHashMap, this.internalLogger)), 1983, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
