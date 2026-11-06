package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewRumEventConsumer implements WebViewEventConsumer {
    public static final Companion Companion = new Companion(null);
    private static final Set RUM_EVENT_TYPES = SetsKt.setOf((Object[]) new String[]{"view", "action", "resource", "long_task", "error", "rum"});
    private final WebViewRumEventContextProvider contextProvider;
    private final DataWriter dataWriter;
    private final TimestampOffsetProvider offsetProvider;
    private final FeatureSdkCore sdkCore;
    private final WebViewRumEventMapper webViewRumEventMapper;

    public WebViewRumEventConsumer(FeatureSdkCore sdkCore, DataWriter dataWriter, TimestampOffsetProvider offsetProvider, WebViewRumEventMapper webViewRumEventMapper, WebViewRumEventContextProvider contextProvider) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        Intrinsics.checkNotNullParameter(webViewRumEventMapper, "webViewRumEventMapper");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        this.sdkCore = sdkCore;
        this.dataWriter = dataWriter;
        this.offsetProvider = offsetProvider;
        this.webViewRumEventMapper = webViewRumEventMapper;
        this.contextProvider = contextProvider;
    }

    public final DataWriter getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final JsonObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", "web_view_ingested_notification")));
        }
        FeatureScope feature2 = this.sdkCore.getFeature("web-rum");
        if (feature2 != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature2, false, new Function2() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.consume.1
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
                    RumContext rumContext = WebViewRumEventConsumer.this.contextProvider.getRumContext(datadogContext);
                    if (rumContext == null || !Intrinsics.areEqual(rumContext.getSessionState(), "TRACKED")) {
                        return;
                    }
                    Map map = (Map) datadogContext.getFeaturesContext().get("session-replay");
                    Object obj = map != null ? map.get("session_replay_is_enabled") : null;
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    WebViewRumEventConsumer.this.getDataWriter$dd_sdk_android_webview_release().write(eventBatchWriter, WebViewRumEventConsumer.this.map(event, datadogContext, rumContext, bool != null ? bool.booleanValue() : false), EventType.DEFAULT);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject jsonObject, DatadogContext datadogContext, RumContext rumContext, boolean z) {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        try {
            JsonElement jsonElement2 = jsonObject.get("view");
            return this.webViewRumEventMapper.mapEvent(jsonObject, rumContext, (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null || (jsonElement = asJsonObject.get(DiagnosticsEntry.ID_KEY)) == null || (asString = jsonElement.getAsString()) == null) ? 0L : this.offsetProvider.getOffset$dd_sdk_android_webview_release(asString, datadogContext), z);
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web RUM event could not be deserialized";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return jsonObject;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web RUM event could not be deserialized";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return jsonObject;
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web RUM event could not be deserialized";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return jsonObject;
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web RUM event could not be deserialized";
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return jsonObject;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set getRUM_EVENT_TYPES() {
            return WebViewRumEventConsumer.RUM_EVENT_TYPES;
        }
    }
}
