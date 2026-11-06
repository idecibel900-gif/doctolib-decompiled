package com.datadog.android.webview.internal.replay;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewReplayEventConsumer implements WebViewEventConsumer {
    public static final Companion Companion = new Companion(null);
    private static final Set REPLAY_EVENT_TYPES = SetsKt.setOf("record");
    private final WebViewRumEventContextProvider contextProvider;
    private final DataWriter dataWriter;
    private final FeatureSdkCore sdkCore;
    private final WebViewReplayEventMapper webViewReplayEventMapper;

    public WebViewReplayEventConsumer(FeatureSdkCore sdkCore, DataWriter dataWriter, WebViewRumEventContextProvider contextProvider, WebViewReplayEventMapper webViewReplayEventMapper) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(webViewReplayEventMapper, "webViewReplayEventMapper");
        this.sdkCore = sdkCore;
        this.dataWriter = dataWriter;
        this.contextProvider = contextProvider;
        this.webViewReplayEventMapper = webViewReplayEventMapper;
    }

    public final DataWriter getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final JsonObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeatureScope feature = this.sdkCore.getFeature("web-replay");
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.consume.1
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
                    JsonObject map;
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                    RumContext rumContext = WebViewReplayEventConsumer.this.contextProvider.getRumContext(datadogContext);
                    Map map2 = (Map) datadogContext.getFeaturesContext().get("session-replay");
                    Object obj = map2 != null ? map2.get("session_replay_is_enabled") : null;
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    if (rumContext == null || !Intrinsics.areEqual(rumContext.getSessionState(), "TRACKED") || !zBooleanValue || (map = WebViewReplayEventConsumer.this.map(event, datadogContext, rumContext)) == null) {
                        return;
                    }
                    WebViewReplayEventConsumer.this.getDataWriter$dd_sdk_android_webview_release().write(eventBatchWriter, map, EventType.DEFAULT);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject jsonObject, DatadogContext datadogContext, RumContext rumContext) {
        try {
            return this.webViewReplayEventMapper.mapEvent(jsonObject, rumContext, datadogContext);
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web Replay event could not be deserialized";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web Replay event could not be deserialized";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web Replay event could not be deserialized";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return null;
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "The bundled web Replay event could not be deserialized";
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set getREPLAY_EVENT_TYPES() {
            return WebViewReplayEventConsumer.REPLAY_EVENT_TYPES;
        }
    }
}
