package com.datadog.reactnative;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DdSdkBridgeExtKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Map toMap(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        HashMap<String, Object> hashMap = readableMap.toHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            Intrinsics.checkNotNull(value);
            linkedHashMap2.put(key, value);
        }
        HashMap map = (HashMap) MapsKt.toMap(linkedHashMap2, new HashMap());
        for (Object obj : map.keySet()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            String str = (String) obj;
            try {
                ReadableType type = readableMap.getType(str);
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        ReadableMap map2 = readableMap.getMap(str);
                        toMap$updateMap(map, readableMap, str, map2 != null ? toMap(map2) : null);
                        break;
                    case 2:
                        ReadableArray array = readableMap.getArray(str);
                        toMap$updateMap(map, readableMap, str, array != null ? toList(array) : null);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        break;
                    default:
                        map.remove(str);
                        type.name();
                        break;
                }
            } catch (IllegalArgumentException unused) {
                map.remove(str);
            }
        }
        return map;
    }

    private static final void toMap$updateMap(HashMap map, ReadableMap readableMap, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj);
        } else {
            map.remove(str);
            readableMap.getClass();
        }
    }

    public static final List toList(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            try {
                ReadableType type = readableArray.getType(i);
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        ReadableMap map = readableArray.getMap(i);
                        if (map == null) {
                            map = Arguments.createMap();
                        }
                        arrayList.add(toMap(map));
                        break;
                    case 2:
                        ReadableArray array = readableArray.getArray(i);
                        if (array == null) {
                            array = Arguments.createArray();
                        }
                        arrayList.add(toList(array));
                        break;
                    case 3:
                        arrayList.add(null);
                        break;
                    case 4:
                        arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                        break;
                    case 5:
                        arrayList.add(Double.valueOf(readableArray.getDouble(i)));
                        break;
                    case 6:
                        arrayList.add(readableArray.getString(i));
                        break;
                    default:
                        type.name();
                        break;
                }
            } catch (NullPointerException unused) {
            }
        }
        return arrayList;
    }

    public static final Boolean getBooleanOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key)) {
            return Boolean.valueOf(readableMap.getBoolean(key));
        }
        return null;
    }

    public static final Double getDoubleOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key)) {
            return Double.valueOf(readableMap.getDouble(key));
        }
        return null;
    }
}
