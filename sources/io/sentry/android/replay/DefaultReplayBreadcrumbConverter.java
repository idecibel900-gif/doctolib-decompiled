package io.sentry.android.replay;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import com.amazon.a.a.o.c.a.b;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.ReplayBreadcrumbConverter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import io.sentry.util.network.NetworkRequestData;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultReplayBreadcrumbConverter implements ReplayBreadcrumbConverter {
    private static final HashSet supportedNetworkData;
    private final Map httpNetworkDetails;
    private String lastConnectivityState;
    private SentryOptions options;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy snakecasePattern$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.sentry.android.replay.DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2
        @Override // kotlin.jvm.functions.Function0
        public final Regex invoke() {
            return new Regex("_[a-z]");
        }
    });

    public DefaultReplayBreadcrumbConverter() {
        this.httpNetworkDetails = Collections.synchronizedMap(new LinkedHashMap() { // from class: io.sentry.android.replay.DefaultReplayBreadcrumbConverter$httpNetworkDetails$1
            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                return false;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                return false;
            }

            public /* bridge */ boolean containsKey(Breadcrumb breadcrumb) {
                return super.containsKey((Object) breadcrumb);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof Breadcrumb) {
                    return containsKey((Breadcrumb) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set entrySet() {
                return getEntries();
            }

            public /* bridge */ NetworkRequestData get(Breadcrumb breadcrumb) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(super.get((Object) breadcrumb));
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (!(obj instanceof Breadcrumb)) {
                    return null;
                }
                get((Breadcrumb) obj);
                return null;
            }

            public /* bridge */ Set getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set getKeys() {
                return super.keySet();
            }

            public /* bridge */ NetworkRequestData getOrDefault(Breadcrumb breadcrumb, NetworkRequestData networkRequestData) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(super.getOrDefault((Object) breadcrumb, networkRequestData));
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                if (!(obj instanceof Breadcrumb)) {
                    return obj2;
                }
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj2);
                getOrDefault((Breadcrumb) obj, (NetworkRequestData) null);
                return null;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set keySet() {
                return getKeys();
            }

            public /* bridge */ NetworkRequestData remove(Breadcrumb breadcrumb) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(super.remove((Object) breadcrumb));
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (!(obj instanceof Breadcrumb)) {
                    return null;
                }
                remove((Breadcrumb) obj);
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection values() {
                return getValues();
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > 32;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultReplayBreadcrumbConverter(SentryOptions options) {
        this();
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        if (options == null) {
            return;
        }
        options.setBeforeBreadcrumb(new ReplayBeforeBreadcrumbCallback(options.getBeforeBreadcrumb()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Regex getSnakecasePattern() {
            return (Regex) DefaultReplayBreadcrumbConverter.snakecasePattern$delegate.getValue();
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("status_code");
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add("http.response_content_length");
        hashSet.add("http.request_content_length");
        supportedNetworkData = hashSet;
    }

    private final class ReplayBeforeBreadcrumbCallback implements SentryOptions.BeforeBreadcrumbCallback {
        private final SentryOptions.BeforeBreadcrumbCallback delegate;

        public ReplayBeforeBreadcrumbCallback(SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumbCallback) {
            this.delegate = beforeBreadcrumbCallback;
        }

        @Override // io.sentry.SentryOptions.BeforeBreadcrumbCallback
        public Breadcrumb execute(Breadcrumb breadcrumb, Hint hint) {
            Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
            Intrinsics.checkNotNullParameter(hint, "hint");
            SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumbCallback = this.delegate;
            if (beforeBreadcrumbCallback != null) {
                breadcrumb = beforeBreadcrumbCallback.execute(breadcrumb, hint);
            }
            if (breadcrumb != null) {
                extractNetworkRequestDataFromHint(breadcrumb, hint);
            }
            return breadcrumb;
        }

        private final NetworkRequestData extractNetworkRequestDataFromHint(Breadcrumb breadcrumb, Hint hint) {
            if (!Intrinsics.areEqual(breadcrumb.getType(), "http") && !Intrinsics.areEqual(breadcrumb.getCategory(), "http")) {
                return null;
            }
            hint.get("sentry:replayNetworkDetails");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    @Override // io.sentry.ReplayBreadcrumbConverter
    public RRWebEvent convert(Breadcrumb breadcrumb) {
        String message;
        SentryLevel level;
        Object obj;
        String strSubstringAfterLast$default;
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Intrinsics.areEqual(breadcrumb.getCategory(), "http")) {
            if (isValidForRRWebSpan(breadcrumb)) {
                return toRRWebSpanEvent(breadcrumb);
            }
            return null;
        }
        String category = "navigation";
        if (Intrinsics.areEqual(breadcrumb.getType(), "navigation") && Intrinsics.areEqual(breadcrumb.getCategory(), "app.lifecycle")) {
            category = "app." + breadcrumb.getData().get("state");
        } else if (Intrinsics.areEqual(breadcrumb.getType(), "navigation") && Intrinsics.areEqual(breadcrumb.getCategory(), "device.orientation")) {
            category = breadcrumb.getCategory();
            Intrinsics.checkNotNull(category);
            Object obj2 = breadcrumb.getData().get("position");
            if (!Intrinsics.areEqual(obj2, "landscape") && !Intrinsics.areEqual(obj2, "portrait")) {
                return null;
            }
            linkedHashMap.put("position", obj2);
        } else if (Intrinsics.areEqual(breadcrumb.getType(), "navigation")) {
            if (Intrinsics.areEqual(breadcrumb.getData().get("state"), "resumed")) {
                Object obj3 = breadcrumb.getData().get("screen");
                String str = obj3 instanceof String ? (String) obj3 : null;
                if (str != null) {
                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str, b.a, (String) null, 2, (Object) null);
                } else {
                    strSubstringAfterLast$default = null;
                }
            } else {
                Map data = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                if (data.containsKey("to")) {
                    Object obj4 = breadcrumb.getData().get("to");
                    if (obj4 instanceof String) {
                        strSubstringAfterLast$default = (String) obj4;
                    } else {
                        strSubstringAfterLast$default = null;
                    }
                } else {
                    strSubstringAfterLast$default = null;
                }
            }
            if (strSubstringAfterLast$default == null) {
                return null;
            }
            linkedHashMap.put("to", strSubstringAfterLast$default);
        } else {
            if (Intrinsics.areEqual(breadcrumb.getCategory(), "ui.click")) {
                Object obj5 = breadcrumb.getData().get("view.id");
                if (obj5 == null && (obj5 = breadcrumb.getData().get("view.tag")) == null) {
                    obj5 = breadcrumb.getData().get("view.class");
                }
                message = obj5 instanceof String ? (String) obj5 : null;
                if (message == null) {
                    return null;
                }
                Map data2 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                linkedHashMap.putAll(data2);
                category = "ui.tap";
                level = null;
            } else if (Intrinsics.areEqual(breadcrumb.getType(), "system") && Intrinsics.areEqual(breadcrumb.getCategory(), "network.event")) {
                if (!Intrinsics.areEqual(breadcrumb.getData().get("action"), "NETWORK_LOST")) {
                    Map data3 = breadcrumb.getData();
                    Intrinsics.checkNotNullExpressionValue(data3, "getData(...)");
                    if (data3.containsKey("network_type")) {
                        Object obj6 = breadcrumb.getData().get("network_type");
                        String str2 = obj6 instanceof String ? (String) obj6 : null;
                        obj = (str2 == null || str2.length() == 0) ? "offline" : breadcrumb.getData().get("network_type");
                    }
                    return null;
                }
                linkedHashMap.put("state", obj);
                if (Intrinsics.areEqual(this.lastConnectivityState, linkedHashMap.get("state"))) {
                    return null;
                }
                Object obj7 = linkedHashMap.get("state");
                this.lastConnectivityState = obj7 instanceof String ? (String) obj7 : null;
                category = "device.connectivity";
            } else if (Intrinsics.areEqual(breadcrumb.getData().get("action"), "BATTERY_CHANGED")) {
                Map data4 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data4, "getData(...)");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : data4.entrySet()) {
                    String str3 = (String) entry.getKey();
                    if (Intrinsics.areEqual(str3, "level") || Intrinsics.areEqual(str3, "charging")) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                linkedHashMap.putAll(linkedHashMap2);
                category = "device.battery";
            } else {
                category = breadcrumb.getCategory();
                message = breadcrumb.getMessage();
                level = breadcrumb.getLevel();
                Map data5 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data5, "getData(...)");
                linkedHashMap.putAll(data5);
            }
            if (category == null && category.length() != 0) {
                RRWebBreadcrumbEvent rRWebBreadcrumbEvent = new RRWebBreadcrumbEvent();
                rRWebBreadcrumbEvent.setTimestamp(breadcrumb.getTimestamp().getTime());
                rRWebBreadcrumbEvent.setBreadcrumbTimestamp(breadcrumb.getTimestamp().getTime() / 1000.0d);
                rRWebBreadcrumbEvent.setBreadcrumbType("default");
                rRWebBreadcrumbEvent.setCategory(category);
                rRWebBreadcrumbEvent.setMessage(message);
                rRWebBreadcrumbEvent.setLevel(level);
                rRWebBreadcrumbEvent.setData(linkedHashMap);
                return rRWebBreadcrumbEvent;
            }
        }
        message = null;
        level = null;
        return category == null ? null : null;
    }

    private final boolean isValidForRRWebSpan(Breadcrumb breadcrumb) {
        Object obj = breadcrumb.getData().get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() == 0) {
            return false;
        }
        Map data = breadcrumb.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        if (!data.containsKey("http.start_timestamp")) {
            return false;
        }
        Map data2 = breadcrumb.getData();
        Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
        return data2.containsKey("http.end_timestamp");
    }

    private final String snakeToCamelCase(String str) {
        return Companion.getSnakecasePattern().replace(str, new Function1() { // from class: io.sentry.android.replay.DefaultReplayBreadcrumbConverter.snakeToCamelCase.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String upperCase = String.valueOf(StringsKt.last(it.getValue())).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return upperCase;
            }
        });
    }

    private final RRWebSpanEvent toRRWebSpanEvent(Breadcrumb breadcrumb) {
        double dLongValue;
        double dLongValue2;
        Object obj = breadcrumb.getData().get("http.start_timestamp");
        Object obj2 = breadcrumb.getData().get("http.end_timestamp");
        RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
        rRWebSpanEvent.setTimestamp(breadcrumb.getTimestamp().getTime());
        rRWebSpanEvent.setOp("resource.http");
        Object obj3 = breadcrumb.getData().get("url");
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        rRWebSpanEvent.setDescription((String) obj3);
        if (obj instanceof Double) {
            dLongValue = ((Number) obj).doubleValue();
        } else {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            dLongValue = ((Long) obj).longValue();
        }
        rRWebSpanEvent.setStartTimestamp(dLongValue / 1000.0d);
        if (obj2 instanceof Double) {
            dLongValue2 = ((Number) obj2).doubleValue();
        } else {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            dLongValue2 = ((Long) obj2).longValue();
        }
        rRWebSpanEvent.setEndTimestamp(dLongValue2 / 1000.0d);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.httpNetworkDetails.remove(breadcrumb));
        Map data = breadcrumb.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        for (Map.Entry entry : data.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (supportedNetworkData.contains(str)) {
                Intrinsics.checkNotNull(str);
                linkedHashMap.put(snakeToCamelCase(StringsKt.substringAfter$default(StringsKt.replace$default(str, "content_length", "body_size", false, 4, (Object) null), ".", (String) null, 2, (Object) null)), value);
            }
        }
        rRWebSpanEvent.setData(linkedHashMap);
        return rRWebSpanEvent;
    }
}
