package com.datadog.reactnative;

import com.amazon.a.a.o.b;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.RegistrationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class DdRumImplementation {
    public static final Companion Companion = new Companion(null);
    private final DatadogWrapper datadog;

    public DdRumImplementation(DatadogWrapper datadog) {
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        this.datadog = datadog;
    }

    public final void startView(String key, String name, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().startView(key, name, mutableMap);
        promise.resolve(null);
    }

    public final void stopView(String key, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().stopView(key, mutableMap);
        promise.resolve(null);
    }

    public final void startAction(String type, String name, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().startAction(asRumActionType(type), name, mutableMap);
        promise.resolve(null);
    }

    public final void stopAction(String type, String name, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().stopAction(asRumActionType(type), name, mutableMap);
        promise.resolve(null);
    }

    public final void addAction(String type, String name, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().addAction(asRumActionType(type), name, mutableMap);
        promise.resolve(null);
    }

    public final void startResource(String key, String method, String url, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        this.datadog.getRumMonitor().startResource(key, asRumResourceMethod(method), url, mutableMap);
        promise.resolve(null);
    }

    public final void stopResource(String key, double d, String kind, double d2, ReadableMap context, double d3, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d3));
        long j = (long) d2;
        this.datadog.getRumMonitor().stopResource(key, Integer.valueOf((int) d), j == -1 ? null : Long.valueOf(j), asRumResourceKind(kind), mutableMap);
        promise.resolve(null);
    }

    public final void addError(String message, String source, String stacktrace, ReadableMap context, double d, String fingerprint, Promise promise) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map mutableMap = MapsKt.toMutableMap(context.toHashMap());
        mutableMap.put("_dd.timestamp", Long.valueOf((long) d));
        if (fingerprint.length() > 0) {
            mutableMap.put("_dd.error.fingerprint", fingerprint);
        }
        this.datadog.getRumMonitor().addErrorWithStacktrace(message, asErrorSource(source), stacktrace, mutableMap);
        promise.resolve(null);
    }

    public final void addTiming(String name, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().addTiming(name);
        promise.resolve(null);
    }

    public final void addViewLoadingTime(boolean z, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().addViewLoadingTime(z);
        promise.resolve(null);
    }

    public final void stopSession(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().stopSession();
        promise.resolve(null);
    }

    public final void addFeatureFlagEvaluation(String name, ReadableMap valueAsMap, Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(valueAsMap, "valueAsMap");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Object obj = valueAsMap.toHashMap().get("value");
        if (obj != null) {
            this.datadog.getRumMonitor().addFeatureFlagEvaluation(name, obj);
        }
        promise.resolve(null);
    }

    public final void getCurrentSessionId(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.datadog.getRumMonitor().getCurrentSessionId(new Function1() { // from class: com.datadog.reactnative.DdRumImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DdRumImplementation.getCurrentSessionId$lambda$8(promise, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCurrentSessionId$lambda$8(Promise promise, String str) {
        promise.resolve(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumActionType asRumActionType(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -907680051:
                if (lowerCase.equals("scroll")) {
                    return RumActionType.SCROLL;
                }
                break;
            case 114595:
                if (lowerCase.equals("tap")) {
                    return RumActionType.TAP;
                }
                break;
            case 3015911:
                if (lowerCase.equals("back")) {
                    return RumActionType.BACK;
                }
                break;
            case 94750088:
                if (lowerCase.equals("click")) {
                    return RumActionType.CLICK;
                }
                break;
            case 109854522:
                if (lowerCase.equals("swipe")) {
                    return RumActionType.SWIPE;
                }
                break;
        }
        return RumActionType.CUSTOM;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumResourceKind asRumResourceKind(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1393046460:
                if (lowerCase.equals("beacon")) {
                    return RumResourceKind.BEACON;
                }
                break;
            case -1052618729:
                if (lowerCase.equals(RegistrationRequest.APPLICATION_TYPE_NATIVE)) {
                    return RumResourceKind.NATIVE;
                }
                break;
            case 3401:
                if (lowerCase.equals("js")) {
                    return RumResourceKind.JS;
                }
                break;
            case 98819:
                if (lowerCase.equals("css")) {
                    return RumResourceKind.CSS;
                }
                break;
            case 118658:
                if (lowerCase.equals("xhr")) {
                    return RumResourceKind.XHR;
                }
                break;
            case 3148879:
                if (lowerCase.equals("font")) {
                    return RumResourceKind.FONT;
                }
                break;
            case 97322682:
                if (lowerCase.equals("fetch")) {
                    return RumResourceKind.FETCH;
                }
                break;
            case 100313435:
                if (lowerCase.equals("image")) {
                    return RumResourceKind.IMAGE;
                }
                break;
            case 103772132:
                if (lowerCase.equals("media")) {
                    return RumResourceKind.MEDIA;
                }
                break;
            case 106069776:
                if (lowerCase.equals(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER)) {
                    return RumResourceKind.OTHER;
                }
                break;
            case 861720859:
                if (lowerCase.equals("document")) {
                    return RumResourceKind.DOCUMENT;
                }
                break;
        }
        return RumResourceKind.UNKNOWN;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumErrorSource asErrorSource(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1349088399:
                if (lowerCase.equals("custom")) {
                    return RumErrorSource.CUSTOM;
                }
                break;
            case -1097337456:
                if (lowerCase.equals("logger")) {
                    return RumErrorSource.LOGGER;
                }
                break;
            case -934521548:
                if (lowerCase.equals("report")) {
                    return RumErrorSource.REPORT;
                }
                break;
            case -896505829:
                if (lowerCase.equals(Constants.ScionAnalytics.PARAM_SOURCE)) {
                    return RumErrorSource.SOURCE;
                }
                break;
            case 92750597:
                if (lowerCase.equals("agent")) {
                    return RumErrorSource.AGENT;
                }
                break;
            case 951510359:
                if (lowerCase.equals("console")) {
                    return RumErrorSource.CONSOLE;
                }
                break;
            case 1224424441:
                if (lowerCase.equals("webview")) {
                    return RumErrorSource.WEBVIEW;
                }
                break;
            case 1843485230:
                if (lowerCase.equals("network")) {
                    return RumErrorSource.NETWORK;
                }
                break;
        }
        return RumErrorSource.SOURCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumResourceMethod asRumResourceMethod(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1335458389:
                if (lowerCase.equals("delete")) {
                    return RumResourceMethod.DELETE;
                }
                break;
            case -1249474914:
                if (lowerCase.equals("options")) {
                    return RumResourceMethod.OPTIONS;
                }
                break;
            case 102230:
                if (lowerCase.equals(b.au)) {
                    return RumResourceMethod.GET;
                }
                break;
            case 111375:
                if (lowerCase.equals("put")) {
                    return RumResourceMethod.PUT;
                }
                break;
            case 3198432:
                if (lowerCase.equals("head")) {
                    return RumResourceMethod.HEAD;
                }
                break;
            case 3446944:
                if (lowerCase.equals("post")) {
                    return RumResourceMethod.POST;
                }
                break;
            case 106438728:
                if (lowerCase.equals("patch")) {
                    return RumResourceMethod.PATCH;
                }
                break;
            case 110620997:
                if (lowerCase.equals("trace")) {
                    return RumResourceMethod.TRACE;
                }
                break;
            case 951351530:
                if (lowerCase.equals("connect")) {
                    return RumResourceMethod.CONNECT;
                }
                break;
        }
        RumResourceMethod rumResourceMethod = RumResourceMethod.GET;
        Objects.toString(rumResourceMethod);
        return rumResourceMethod;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
