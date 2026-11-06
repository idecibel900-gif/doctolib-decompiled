package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.google.gson.JsonParseException;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class RumEventMetaDeserializer implements Deserializer {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public RumEventMetaDeserializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public RumEventMeta deserialize(byte[] model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.length == 0) {
            return null;
        }
        try {
            return RumEventMeta.Companion.fromJson(new String(model, Charsets.UTF_8), this.internalLogger);
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMetaDeserializer.deserialize.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to deserialize RUM event meta";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
