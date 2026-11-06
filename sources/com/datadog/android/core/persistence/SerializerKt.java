package com.datadog.android.core.persistence;

import com.datadog.android.api.InternalLogger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializerKt {
    public static final byte[] serializeToByteArray(Serializer serializer, final Object model, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            String strSerialize = serializer.serialize(model);
            if (strSerialize == null) {
                return null;
            }
            byte[] bytes = strSerialize.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.persistence.SerializerKt.serializeToByteArray.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error serializing %s model", Arrays.copyOf(new Object[]{model.getClass().getSimpleName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, th, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
