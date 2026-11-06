package com.datadog.android.rum.internal;

import com.datadog.android.api.context.DatadogContext;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FeaturesContextResolver {
    public static final Companion Companion = new Companion(null);

    public final boolean resolveViewHasReplay(DatadogContext datadogContext, String viewId) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Map map = (Map) datadogContext.getFeaturesContext().get("session-replay");
        if (map == null) {
            return false;
        }
        Object obj = map.get(viewId);
        Map map2 = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map2 != null ? map2.get("has_replay") : null;
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final long resolveViewRecordsCount(DatadogContext datadogContext, String viewId) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Map map = (Map) datadogContext.getFeaturesContext().get("session-replay");
        if (map == null) {
            return 0L;
        }
        Object obj = map.get(viewId);
        Map map2 = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map2 != null ? map2.get("records_count") : null;
        Long l = obj2 instanceof Long ? (Long) obj2 : null;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
