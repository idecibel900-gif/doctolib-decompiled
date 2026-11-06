package com.datadog.reactnative;

import com.adjust.sdk.Constants;
import com.datadog.android.trace.TracingHeaderType;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.TokenRequest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DdSdkConfigurationExtKt {
    public static final DdSdkConfiguration asDdSdkConfiguration(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        String string = readableMap.getString("clientToken");
        if (string == null) {
            string = "";
        }
        String string2 = readableMap.getString("env");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = readableMap.getString("applicationId");
        if (string3 == null) {
            string3 = "";
        }
        Boolean boolValueOf = Boolean.valueOf(readableMap.getBoolean("nativeCrashReportEnabled"));
        Double dValueOf = Double.valueOf(readableMap.getDouble("nativeLongTaskThresholdMs"));
        Double dValueOf2 = Double.valueOf(readableMap.getDouble("longTaskThresholdMs"));
        Double dValueOf3 = Double.valueOf(readableMap.getDouble("sampleRate"));
        String string4 = readableMap.getString("site");
        String string5 = readableMap.getString("trackingConsent");
        Double dValueOf4 = Double.valueOf(readableMap.getDouble("telemetrySampleRate"));
        String string6 = readableMap.getString("vitalsUpdateFrequency");
        Boolean boolValueOf2 = Boolean.valueOf(readableMap.getBoolean("trackFrustrations"));
        String string7 = readableMap.getString("uploadFrequency");
        String string8 = readableMap.getString("batchSize");
        Boolean boolValueOf3 = Boolean.valueOf(readableMap.getBoolean("trackBackgroundEvents"));
        ReadableMap map = readableMap.getMap("customEndpoints");
        CustomEndpoints customEndpointsAsCustomEndpoints = map != null ? asCustomEndpoints(map) : null;
        String str = string;
        ReadableMap map2 = readableMap.getMap("additionalConfiguration");
        HashMap<String, Object> hashMap = map2 != null ? map2.toHashMap() : null;
        ReadableMap map3 = readableMap.getMap("configurationForTelemetry");
        ConfigurationForTelemetry configurationForTelemetryAsConfigurationForTelemetry = map3 != null ? asConfigurationForTelemetry(map3) : null;
        Boolean boolValueOf4 = Boolean.valueOf(readableMap.getBoolean("nativeViewTracking"));
        Boolean boolValueOf5 = Boolean.valueOf(readableMap.getBoolean("nativeInteractionTracking"));
        String string9 = readableMap.getString("verbosity");
        ReadableMap map4 = readableMap.getMap("proxyConfig");
        Pair pairAsProxyConfig = map4 != null ? asProxyConfig(map4) : null;
        String string10 = readableMap.getString("serviceName");
        ReadableArray array = readableMap.getArray("firstPartyHosts");
        return new DdSdkConfiguration(str, string2, string3, boolValueOf, dValueOf, dValueOf2, dValueOf3, string4, string5, dValueOf4, string6, boolValueOf2, string7, string8, boolValueOf3, customEndpointsAsCustomEndpoints, hashMap, configurationForTelemetryAsConfigurationForTelemetry, boolValueOf4, boolValueOf5, string9, pairAsProxyConfig, string10, array != null ? asFirstPartyHosts(array) : null, Boolean.valueOf(readableMap.getBoolean("bundleLogsWithRum")), Boolean.valueOf(readableMap.getBoolean("bundleLogsWithTraces")), DdSdkBridgeExtKt.getBooleanOrNull(readableMap, "trackNonFatalAnrs"), readableMap.getString("batchProcessingLevel"), DdSdkBridgeExtKt.getDoubleOrNull(readableMap, "initialResourceThreshold"));
    }

    public static final ConfigurationForTelemetry asConfigurationForTelemetry(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        return new ConfigurationForTelemetry(readableMap.getString("initializationType"), Boolean.valueOf(readableMap.getBoolean("trackErrors")), Boolean.valueOf(readableMap.getBoolean("trackInteractions")), Boolean.valueOf(readableMap.getBoolean("trackNetworkRequests")), readableMap.getString("reactVersion"), readableMap.getString("reactNativeVersion"));
    }

    public static final CustomEndpoints asCustomEndpoints(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        return new CustomEndpoints(readableMap.getString("rum"), readableMap.getString("logs"), readableMap.getString("trace"));
    }

    public static final Pair asProxyConfig(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        String string = readableMap.getString(AuthorizationRequest.Scope.ADDRESS);
        Integer numValueOf = readableMap.hasKey("port") ? Integer.valueOf(readableMap.getInt("port")) : null;
        String string2 = readableMap.getString("type");
        if (string == null || numValueOf == null || string2 == null) {
            return null;
        }
        return buildProxyConfig(string2, string, numValueOf.intValue(), readableMap.getString("username"), readableMap.getString(TokenRequest.GRANT_TYPE_PASSWORD));
    }

    public static final Map asFirstPartyHosts(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        List list = DdSdkBridgeExtKt.toList(readableArray);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            JSONFirstPartyHost jSONFirstPartyHost = null;
            if (obj != null) {
                if (!(obj instanceof Map)) {
                    readableArray.getClass();
                    obj.toString();
                } else {
                    Map map = (Map) obj;
                    Object obj2 = map.get("match");
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    Object obj3 = map.get("propagatorTypes");
                    List list2 = obj3 instanceof List ? (List) obj3 : null;
                    if (str != null && list2 != null) {
                        jSONFirstPartyHost = new JSONFirstPartyHost(str, list2);
                    }
                }
            }
            if (jSONFirstPartyHost != null) {
                arrayList.add(jSONFirstPartyHost);
            }
        }
        return asFirstPartyHosts(arrayList);
    }

    public static final Map asFirstPartyHosts(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JSONFirstPartyHost jSONFirstPartyHost = (JSONFirstPartyHost) it.next();
            if (!jSONFirstPartyHost.getPropagatorTypes().isEmpty()) {
                Set set = (Set) linkedHashMap.get(jSONFirstPartyHost.getMatch());
                if (set != null) {
                    set.addAll(asTracingHeaderTypes(jSONFirstPartyHost.getPropagatorTypes()));
                } else {
                    linkedHashMap.put(jSONFirstPartyHost.getMatch(), CollectionsKt.toMutableSet(asTracingHeaderTypes(jSONFirstPartyHost.getPropagatorTypes())));
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    public static final Set asTracingHeaderTypes(List list) {
        TracingHeaderType tracingHeaderType;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1654608952) {
                if (iHashCode != -449889078) {
                    if (iHashCode != 3089) {
                        if (iHashCode == 1443200338 && lowerCase.equals("datadog")) {
                            tracingHeaderType = TracingHeaderType.DATADOG;
                        } else {
                            tracingHeaderType = null;
                        }
                    } else if (lowerCase.equals("b3")) {
                        tracingHeaderType = TracingHeaderType.B3;
                    } else {
                        tracingHeaderType = null;
                    }
                } else if (lowerCase.equals("tracecontext")) {
                    tracingHeaderType = TracingHeaderType.TRACECONTEXT;
                } else {
                    tracingHeaderType = null;
                }
            } else if (lowerCase.equals("b3multi")) {
                tracingHeaderType = TracingHeaderType.B3MULTI;
            } else {
                tracingHeaderType = null;
            }
            if (tracingHeaderType != null) {
                arrayList.add(tracingHeaderType);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    private static final Pair buildProxyConfig(String str, String str2, int i, String str3, String str4) {
        Proxy.Type type;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        ProxyAuthenticator proxyAuthenticator = null;
        if (iHashCode != 3213448) {
            if (iHashCode != 99617003) {
                if (iHashCode == 109610287 && lowerCase.equals("socks")) {
                    type = Proxy.Type.SOCKS;
                }
            } else if (lowerCase.equals(Constants.SCHEME)) {
                type = Proxy.Type.HTTP;
            }
            type = null;
        } else if (lowerCase.equals("http")) {
            type = Proxy.Type.HTTP;
        } else {
            type = null;
        }
        if (type == null) {
            return null;
        }
        Proxy proxy = new Proxy(type, new InetSocketAddress(str2, i));
        if (str3 != null && str4 != null) {
            proxyAuthenticator = new ProxyAuthenticator(str3, str4);
        }
        return new Pair(proxy, proxyAuthenticator);
    }
}
