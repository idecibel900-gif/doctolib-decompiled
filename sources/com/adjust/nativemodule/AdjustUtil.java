package com.adjust.nativemodule;

import android.net.Uri;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustEventFailure;
import com.adjust.sdk.AdjustEventSuccess;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.AdjustRemoteTrigger;
import com.adjust.sdk.AdjustSessionFailure;
import com.adjust.sdk.AdjustSessionSuccess;
import com.adjust.sdk.AdjustThirdPartySharingResult;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
abstract class AdjustUtil {
    public static WritableMap attributionToMap(AdjustAttribution adjustAttribution) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustAttribution == null) {
            return writableMapCreateMap;
        }
        String str = adjustAttribution.trackerToken;
        if (str == null) {
            str = "";
        }
        writableMapCreateMap.putString("trackerToken", str);
        String str2 = adjustAttribution.trackerName;
        if (str2 == null) {
            str2 = "";
        }
        writableMapCreateMap.putString("trackerName", str2);
        String str3 = adjustAttribution.network;
        if (str3 == null) {
            str3 = "";
        }
        writableMapCreateMap.putString("network", str3);
        String str4 = adjustAttribution.campaign;
        if (str4 == null) {
            str4 = "";
        }
        writableMapCreateMap.putString(Constants.ScionAnalytics.PARAM_CAMPAIGN, str4);
        String str5 = adjustAttribution.adgroup;
        if (str5 == null) {
            str5 = "";
        }
        writableMapCreateMap.putString("adgroup", str5);
        String str6 = adjustAttribution.creative;
        if (str6 == null) {
            str6 = "";
        }
        writableMapCreateMap.putString("creative", str6);
        String str7 = adjustAttribution.clickLabel;
        if (str7 == null) {
            str7 = "";
        }
        writableMapCreateMap.putString("clickLabel", str7);
        String str8 = adjustAttribution.costType;
        if (str8 == null) {
            str8 = "";
        }
        writableMapCreateMap.putString("costType", str8);
        Double d = adjustAttribution.costAmount;
        writableMapCreateMap.putDouble("costAmount", (d == null || d.isNaN()) ? 0.0d : adjustAttribution.costAmount.doubleValue());
        String str9 = adjustAttribution.costCurrency;
        if (str9 == null) {
            str9 = "";
        }
        writableMapCreateMap.putString("costCurrency", str9);
        String str10 = adjustAttribution.jsonResponse;
        writableMapCreateMap.putString("jsonResponse", str10 != null ? str10.toString() : "");
        String str11 = adjustAttribution.fbInstallReferrer;
        writableMapCreateMap.putString("fbInstallReferrer", str11 != null ? str11 : "");
        return writableMapCreateMap;
    }

    public static WritableMap eventSuccessToMap(AdjustEventSuccess adjustEventSuccess) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustEventSuccess == null) {
            return writableMapCreateMap;
        }
        String str = adjustEventSuccess.message;
        if (str == null) {
            str = "";
        }
        writableMapCreateMap.putString("message", str);
        String str2 = adjustEventSuccess.timestamp;
        if (str2 == null) {
            str2 = "";
        }
        writableMapCreateMap.putString(DiagnosticsEntry.TIMESTAMP_KEY, str2);
        String str3 = adjustEventSuccess.adid;
        if (str3 == null) {
            str3 = "";
        }
        writableMapCreateMap.putString("adid", str3);
        String str4 = adjustEventSuccess.eventToken;
        if (str4 == null) {
            str4 = "";
        }
        writableMapCreateMap.putString("eventToken", str4);
        String str5 = adjustEventSuccess.callbackId;
        if (str5 == null) {
            str5 = "";
        }
        writableMapCreateMap.putString("callbackId", str5);
        JSONObject jSONObject = adjustEventSuccess.jsonResponse;
        writableMapCreateMap.putString("jsonResponse", jSONObject != null ? jSONObject.toString() : "");
        return writableMapCreateMap;
    }

    public static WritableMap eventFailureToMap(AdjustEventFailure adjustEventFailure) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustEventFailure == null) {
            return writableMapCreateMap;
        }
        String str = adjustEventFailure.message;
        if (str == null) {
            str = "";
        }
        writableMapCreateMap.putString("message", str);
        String str2 = adjustEventFailure.timestamp;
        if (str2 == null) {
            str2 = "";
        }
        writableMapCreateMap.putString(DiagnosticsEntry.TIMESTAMP_KEY, str2);
        String str3 = adjustEventFailure.adid;
        if (str3 == null) {
            str3 = "";
        }
        writableMapCreateMap.putString("adid", str3);
        String str4 = adjustEventFailure.eventToken;
        if (str4 == null) {
            str4 = "";
        }
        writableMapCreateMap.putString("eventToken", str4);
        String str5 = adjustEventFailure.callbackId;
        if (str5 == null) {
            str5 = "";
        }
        writableMapCreateMap.putString("callbackId", str5);
        writableMapCreateMap.putString("willRetry", adjustEventFailure.willRetry ? b.af : b.ag);
        JSONObject jSONObject = adjustEventFailure.jsonResponse;
        writableMapCreateMap.putString("jsonResponse", jSONObject != null ? jSONObject.toString() : "");
        return writableMapCreateMap;
    }

    public static WritableMap sessionSuccessToMap(AdjustSessionSuccess adjustSessionSuccess) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustSessionSuccess == null) {
            return writableMapCreateMap;
        }
        String str = adjustSessionSuccess.message;
        if (str == null) {
            str = "";
        }
        writableMapCreateMap.putString("message", str);
        String str2 = adjustSessionSuccess.timestamp;
        if (str2 == null) {
            str2 = "";
        }
        writableMapCreateMap.putString(DiagnosticsEntry.TIMESTAMP_KEY, str2);
        String str3 = adjustSessionSuccess.adid;
        if (str3 == null) {
            str3 = "";
        }
        writableMapCreateMap.putString("adid", str3);
        JSONObject jSONObject = adjustSessionSuccess.jsonResponse;
        writableMapCreateMap.putString("jsonResponse", jSONObject != null ? jSONObject.toString() : "");
        return writableMapCreateMap;
    }

    public static WritableMap sessionFailureToMap(AdjustSessionFailure adjustSessionFailure) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustSessionFailure == null) {
            return writableMapCreateMap;
        }
        String str = adjustSessionFailure.message;
        if (str == null) {
            str = "";
        }
        writableMapCreateMap.putString("message", str);
        String str2 = adjustSessionFailure.timestamp;
        if (str2 == null) {
            str2 = "";
        }
        writableMapCreateMap.putString(DiagnosticsEntry.TIMESTAMP_KEY, str2);
        String str3 = adjustSessionFailure.adid;
        if (str3 == null) {
            str3 = "";
        }
        writableMapCreateMap.putString("adid", str3);
        writableMapCreateMap.putString("willRetry", adjustSessionFailure.willRetry ? b.af : b.ag);
        JSONObject jSONObject = adjustSessionFailure.jsonResponse;
        writableMapCreateMap.putString("jsonResponse", jSONObject != null ? jSONObject.toString() : "");
        return writableMapCreateMap;
    }

    public static WritableMap deferredDeeplinkToMap(Uri uri) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (uri == null) {
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString(com.adjust.sdk.Constants.DEEPLINK, uri.toString());
        return writableMapCreateMap;
    }

    public static WritableMap remoteTriggerToMap(AdjustRemoteTrigger adjustRemoteTrigger) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustRemoteTrigger == null) {
            writableMapCreateMap.putString(Constants.ScionAnalytics.PARAM_LABEL, "");
            writableMapCreateMap.putString("payloadJson", "{}");
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString(Constants.ScionAnalytics.PARAM_LABEL, adjustRemoteTrigger.getLabel() != null ? adjustRemoteTrigger.getLabel() : "");
        writableMapCreateMap.putString("payloadJson", adjustRemoteTrigger.getPayload() != null ? adjustRemoteTrigger.getPayload().toString() : "{}");
        return writableMapCreateMap;
    }

    public static WritableMap thirdPartySharingResultToMap(AdjustThirdPartySharingResult adjustThirdPartySharingResult) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (adjustThirdPartySharingResult != null) {
            writableMapCreateMap.putString("thirdPartySharingSettingsJson", adjustThirdPartySharingResult.getThirdPartySharingSettingsJson() != null ? adjustThirdPartySharingResult.getThirdPartySharingSettingsJson() : "");
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("thirdPartySharingSettingsJson", "");
        return writableMapCreateMap;
    }

    public static boolean isFieldValid(String str) {
        return (str == null || str.equals("") || str.equals("null")) ? false : true;
    }

    public static Map toMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        if (!readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            return null;
        }
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            String string = toObject(readableMap, strNextKey).toString();
            if (string == null) {
                AdjustFactory.getLogger().warn("Null parameter inside key-value pair with key: " + strNextKey, new Object[0]);
            } else {
                map.put(strNextKey, string);
            }
        }
        return map;
    }

    public static List toList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        List arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    arrayList.add(null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    double d = readableArray.getDouble(i);
                    int i2 = (int) d;
                    if (d == i2) {
                        arrayList.add(Integer.valueOf(i2));
                    } else {
                        arrayList.add(Double.valueOf(d));
                    }
                    break;
                case 4:
                    arrayList.add(readableArray.getString(i));
                    break;
                case 5:
                    arrayList.add(toMap(readableArray.getMap(i)));
                    break;
                case 6:
                    arrayList = toList(readableArray.getArray(i));
                    break;
                default:
                    AdjustFactory.getLogger().error("Could not convert object with index: " + i + ".", new Object[0]);
                    break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.adjust.nativemodule.AdjustUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static Object toObject(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(readableMap.getBoolean(str));
            case 3:
                double d = readableMap.getDouble(str);
                int i = (int) d;
                if (d == i) {
                    return Integer.valueOf(i);
                }
                return Double.valueOf(d);
            case 4:
                return readableMap.getString(str);
            case 5:
                return toMap(readableMap.getMap(str));
            case 6:
                return toList(readableMap.getArray(str));
            default:
                AdjustFactory.getLogger().error("Could not convert object with key: " + str + ".", new Object[0]);
                return null;
        }
    }
}
