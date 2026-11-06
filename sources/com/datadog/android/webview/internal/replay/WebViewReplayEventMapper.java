package com.datadog.android.webview.internal.replay;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.webview.internal.rum.TimestampOffsetProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewReplayEventMapper {
    public static final Companion Companion = new Companion(null);
    private final TimestampOffsetProvider offsetProvider;
    private final String webViewId;

    public WebViewReplayEventMapper(String webViewId, TimestampOffsetProvider offsetProvider) {
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        this.webViewId = webViewId;
        this.offsetProvider = offsetProvider;
    }

    public final JsonObject mapEvent(JsonObject event, RumContext rumContext, DatadogContext datadogContext) {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        JsonElement jsonElement2 = event.get("view");
        String asString = null;
        JsonObject asJsonObject2 = jsonElement2 != null ? jsonElement2.getAsJsonObject() : null;
        if (asJsonObject2 != null && (jsonElement = asJsonObject2.get(DiagnosticsEntry.ID_KEY)) != null) {
            asString = jsonElement.getAsString();
        }
        if (asString == null) {
            throw new IllegalStateException("The bundled web Replay event does not contain the mandatory view data");
        }
        JsonElement jsonElement3 = event.get("event");
        if (jsonElement3 != null && (asJsonObject = jsonElement3.getAsJsonObject()) != null) {
            long offset$dd_sdk_android_webview_release = this.offsetProvider.getOffset$dd_sdk_android_webview_release(asString, datadogContext);
            JsonElement jsonElement4 = asJsonObject.get(DiagnosticsEntry.TIMESTAMP_KEY);
            if (jsonElement4 != null) {
                Intrinsics.checkNotNullExpressionValue(jsonElement4, "get(TIMESTAMP_KEY)");
                asJsonObject.addProperty(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(jsonElement4.getAsLong() + offset$dd_sdk_android_webview_release));
            }
            asJsonObject.addProperty("slotId", this.webViewId);
            return bundleIntoEnrichedRecord(asJsonObject, asString, rumContext);
        }
        throw new IllegalStateException("The bundled web Replay event does not contain the record data");
    }

    private final JsonObject bundleIntoEnrichedRecord(JsonObject jsonObject, String str, RumContext rumContext) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("application_id", rumContext.getApplicationId());
        jsonObject2.addProperty("session_id", rumContext.getSessionId());
        jsonObject2.addProperty("view_id", str);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject);
        Unit unit = Unit.INSTANCE;
        jsonObject2.add("records", jsonArray);
        return jsonObject2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
