package com.datadog.android.webview.internal.rum;

import com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewRumEventMapper {
    public static final Companion Companion = new Companion(null);
    private final NativeRumViewsCache nativeRumViewsCache;

    public WebViewRumEventMapper(NativeRumViewsCache nativeRumViewsCache) {
        Intrinsics.checkNotNullParameter(nativeRumViewsCache, "nativeRumViewsCache");
        this.nativeRumViewsCache = nativeRumViewsCache;
    }

    public final JsonObject mapEvent(JsonObject event, RumContext rumContext, long j, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(Constants.ScionAnalytics.PARAM_SOURCE, "android");
        JsonElement jsonElement = event.get("date");
        if (jsonElement != null) {
            long asLong = jsonElement.getAsLong();
            String strResolveLastParentIdForBrowserEvent = this.nativeRumViewsCache.resolveLastParentIdForBrowserEvent(asLong);
            if (strResolveLastParentIdForBrowserEvent != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(DiagnosticsEntry.ID_KEY, strResolveLastParentIdForBrowserEvent);
                Unit unit = Unit.INSTANCE;
                jsonObject.add("view", jsonObject2);
            }
            event.addProperty("date", Long.valueOf(asLong + j));
        }
        event.add("container", jsonObject);
        JsonElement jsonElement2 = event.get("_dd");
        JsonObject asJsonObject = jsonElement2 != null ? jsonElement2.getAsJsonObject() : null;
        if (asJsonObject != null) {
            JsonElement jsonElement3 = asJsonObject.get("session");
            JsonObject asJsonObject2 = jsonElement3 != null ? jsonElement3.getAsJsonObject() : null;
            if (asJsonObject2 == null) {
                asJsonObject2 = new JsonObject();
            }
            asJsonObject.add("session", asJsonObject2);
            if (!z) {
                asJsonObject.remove("replay_stats");
            }
        }
        if (rumContext != null) {
            JsonObject asJsonObject3 = event.getAsJsonObject("application");
            JsonObject asJsonObject4 = asJsonObject3 != null ? asJsonObject3.getAsJsonObject() : null;
            if (asJsonObject4 == null) {
                asJsonObject4 = new JsonObject();
            }
            JsonObject asJsonObject5 = event.getAsJsonObject("session");
            JsonObject asJsonObject6 = asJsonObject5 != null ? asJsonObject5.getAsJsonObject() : null;
            if (asJsonObject6 == null) {
                asJsonObject6 = new JsonObject();
            }
            asJsonObject4.addProperty(DiagnosticsEntry.ID_KEY, rumContext.getApplicationId());
            asJsonObject6.addProperty(DiagnosticsEntry.ID_KEY, rumContext.getSessionId());
            if (!z) {
                asJsonObject6.remove("has_replay");
            }
            event.add("application", asJsonObject4);
            event.add("session", asJsonObject6);
        }
        return event;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
