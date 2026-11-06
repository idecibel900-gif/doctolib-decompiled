package com.datadog.android.webview.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventConsumer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MixedWebViewEventConsumer implements WebViewEventConsumer {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;
    private final WebViewEventConsumer logsEventConsumer;
    private final WebViewEventConsumer replayEventConsumer;
    private final WebViewEventConsumer rumEventConsumer;

    public MixedWebViewEventConsumer(WebViewEventConsumer rumEventConsumer, WebViewEventConsumer replayEventConsumer, WebViewEventConsumer logsEventConsumer, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(rumEventConsumer, "rumEventConsumer");
        Intrinsics.checkNotNullParameter(replayEventConsumer, "replayEventConsumer");
        Intrinsics.checkNotNullParameter(logsEventConsumer, "logsEventConsumer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.rumEventConsumer = rumEventConsumer;
        this.replayEventConsumer = replayEventConsumer;
        this.logsEventConsumer = logsEventConsumer;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            JsonObject webEvent = JsonParser.parseString(event).getAsJsonObject();
            if (!webEvent.has("eventType")) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "The web event: %s is missing the event type.", Arrays.copyOf(new Object[]{event}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            if (!webEvent.has("event")) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "The web event: %s is missing the wrapped event object.", Arrays.copyOf(new Object[]{event}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            final String asString = webEvent.get("eventType").getAsString();
            JsonObject wrappedEvent = webEvent.get("event").getAsJsonObject();
            if (WebViewLogEventConsumer.Companion.getLOG_EVENT_TYPES().contains(asString)) {
                this.logsEventConsumer.consume(TuplesKt.to(wrappedEvent, asString));
                return;
            }
            if (WebViewRumEventConsumer.Companion.getRUM_EVENT_TYPES().contains(asString)) {
                WebViewEventConsumer webViewEventConsumer = this.rumEventConsumer;
                Intrinsics.checkNotNullExpressionValue(wrappedEvent, "wrappedEvent");
                webViewEventConsumer.consume(wrappedEvent);
            } else {
                if (WebViewReplayEventConsumer.Companion.getREPLAY_EVENT_TYPES().contains(asString)) {
                    WebViewEventConsumer webViewEventConsumer2 = this.replayEventConsumer;
                    Intrinsics.checkNotNullExpressionValue(webEvent, "webEvent");
                    webViewEventConsumer2.consume(webEvent);
                    return;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "The event type %s for the bundled web event is unknown.", Arrays.copyOf(new Object[]{asString}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "We could not deserialize the delegated browser event: %s.", Arrays.copyOf(new Object[]{event}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
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
