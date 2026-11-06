package com.revenuecat.purchases.react;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u0015\u0012\u0002\b\u00030\u0014H\u0007¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/react/RNPurchasesConverters;", "", "<init>", "()V", "convertReadableMapToJson", "Lorg/json/JSONObject;", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "convertReadableArrayToJson", "Lorg/json/JSONArray;", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "convertArrayToWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "array", "", "([Ljava/lang/Object;)Lcom/facebook/react/bridge/WritableArray;", "convertMapToWriteableMap", "Lcom/facebook/react/bridge/WritableMap;", "map", "", "", "react-native-purchases_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNPurchasesConverters {
    public static final RNPurchasesConverters INSTANCE = new RNPurchasesConverters();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RNPurchasesConverters() {
    }

    public static final JSONObject convertReadableMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Intrinsics.checkNotNull(readableMap);
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    jSONObject.put(strNextKey, JSONObject.NULL);
                    break;
                case 2:
                    jSONObject.put(strNextKey, readableMap.getBoolean(strNextKey));
                    break;
                case 3:
                    jSONObject.put(strNextKey, readableMap.getDouble(strNextKey));
                    break;
                case 4:
                    jSONObject.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    jSONObject.put(strNextKey, convertReadableMapToJson(readableMap.getMap(strNextKey)));
                    break;
                case 6:
                    jSONObject.put(strNextKey, INSTANCE.convertReadableArrayToJson(readableMap.getArray(strNextKey)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return jSONObject;
    }

    public final JSONArray convertReadableArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNull(readableArray);
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()]) {
                case 1:
                    Unit unit = Unit.INSTANCE;
                    break;
                case 2:
                    jSONArray.put(readableArray.getBoolean(i));
                    break;
                case 3:
                    jSONArray.put(readableArray.getDouble(i));
                    break;
                case 4:
                    jSONArray.put(readableArray.getString(i));
                    break;
                case 5:
                    jSONArray.put(convertReadableMapToJson(readableArray.getMap(i)));
                    break;
                case 6:
                    jSONArray.put(convertReadableArrayToJson(readableArray.getArray(i)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return jSONArray;
    }

    private final WritableArray convertArrayToWritableArray(Object[] array) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Object obj : array) {
            if (obj == null) {
                writableNativeArray.pushNull();
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                writableNativeArray.pushDouble(((Number) obj).longValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else if (obj instanceof Map) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                writableNativeArray.pushMap(convertMapToWriteableMap((Map) obj));
            } else if (obj instanceof Object[]) {
                writableNativeArray.pushArray(convertArrayToWritableArray((Object[]) obj));
            } else if (obj instanceof List) {
                writableNativeArray.pushArray(convertArrayToWritableArray(((Collection) obj).toArray(new Object[0])));
            }
        }
        return writableNativeArray;
    }

    public static final WritableMap convertMapToWriteableMap(Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                writableNativeMap.putNull(key);
            } else if (value instanceof Boolean) {
                writableNativeMap.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                writableNativeMap.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                writableNativeMap.putDouble(key, ((Number) value).longValue());
            } else if (value instanceof Double) {
                writableNativeMap.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                writableNativeMap.putString(key, (String) value);
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                writableNativeMap.putMap(key, convertMapToWriteableMap((Map) value));
            } else if (value instanceof Object[]) {
                writableNativeMap.putArray(key, INSTANCE.convertArrayToWritableArray((Object[]) value));
            } else if (value instanceof List) {
                writableNativeMap.putArray(key, INSTANCE.convertArrayToWritableArray(((Collection) value).toArray(new Object[0])));
            }
        }
        return writableNativeMap;
    }
}
