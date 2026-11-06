package com.datadog.android.ndk.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.google.gson.JsonParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NdkCrashLogDeserializer implements Deserializer {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public NdkCrashLogDeserializer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public NdkCrashLog deserialize(final String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            return NdkCrashLog.Companion.fromJson$dd_sdk_android_core_release(model);
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.ndk.internal.NdkCrashLogDeserializer.deserialize.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the NDK Crash info: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.ndk.internal.NdkCrashLogDeserializer.deserialize.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error while trying to deserialize the NDK Crash info: %s", Arrays.copyOf(new Object[]{model}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
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
