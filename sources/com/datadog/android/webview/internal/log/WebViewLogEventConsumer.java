package com.datadog.android.webview.internal.log;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewLogEventConsumer implements WebViewEventConsumer {
    public static final Companion Companion = new Companion(null);
    private static final Set LOG_EVENT_TYPES = SetsKt.setOf("log");
    private final WebViewRumEventContextProvider rumContextProvider;
    private final Sampler sampler;
    private final FeatureSdkCore sdkCore;
    private final DataWriter userLogsWriter;

    public WebViewLogEventConsumer(FeatureSdkCore sdkCore, DataWriter userLogsWriter, WebViewRumEventContextProvider rumContextProvider, float f) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(userLogsWriter, "userLogsWriter");
        Intrinsics.checkNotNullParameter(rumContextProvider, "rumContextProvider");
        this.sdkCore = sdkCore;
        this.userLogsWriter = userLogsWriter;
        this.rumContextProvider = rumContextProvider;
        this.sampler = new RateBasedSampler(f);
    }

    public final DataWriter getUserLogsWriter$dd_sdk_android_webview_release() {
        return this.userLogsWriter;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final Pair event) {
        FeatureScope feature;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getSecond(), "log") && this.sampler.sample(Unit.INSTANCE) && (feature = this.sdkCore.getFeature("web-logs")) != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.consume.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((DatadogContext) obj, (EventBatchWriter) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(DatadogContext datadogContext, EventBatchWriter eventBatchWriter) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                    WebViewLogEventConsumer.this.getUserLogsWriter$dd_sdk_android_webview_release().write(eventBatchWriter, WebViewLogEventConsumer.this.map((JsonObject) event.getFirst(), datadogContext, WebViewLogEventConsumer.this.rumContextProvider.getRumContext(datadogContext)), EventType.DEFAULT);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject jsonObject, DatadogContext datadogContext, RumContext rumContext) {
        addDdTags(jsonObject, datadogContext);
        correctDate(jsonObject, datadogContext);
        if (rumContext != null) {
            jsonObject.addProperty("application_id", rumContext.getApplicationId());
            jsonObject.addProperty("session_id", rumContext.getSessionId());
        }
        return jsonObject;
    }

    private final void correctDate(JsonObject jsonObject, DatadogContext datadogContext) {
        try {
            JsonElement jsonElement = jsonObject.get("date");
            if (jsonElement != null) {
                jsonObject.addProperty("date", Long.valueOf(jsonElement.getAsLong() + datadogContext.getTime().getServerTimeOffsetMs()));
            }
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
        }
    }

    private final void addDdTags(JsonObject jsonObject, DatadogContext datadogContext) {
        String str = "version:" + datadogContext.getVersion() + ",env:" + datadogContext.getEnv();
        String asString = null;
        try {
            JsonElement jsonElement = jsonObject.get("ddtags");
            if (jsonElement != null) {
                asString = jsonElement.getAsString();
            }
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.addDdTags.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.addDdTags.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
        } catch (UnsupportedOperationException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.addDdTags.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web log event could not be deserialized";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
        }
        if (asString == null || asString.length() == 0) {
            jsonObject.addProperty("ddtags", str);
            return;
        }
        jsonObject.addProperty("ddtags", str + f.a + asString);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set getLOG_EVENT_TYPES() {
            return WebViewLogEventConsumer.LOG_EVENT_TYPES;
        }
    }
}
