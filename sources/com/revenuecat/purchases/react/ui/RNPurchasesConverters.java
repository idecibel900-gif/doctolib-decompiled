package com.revenuecat.purchases.react.ui;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u0007H\u0007J\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0002¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/react/ui/RNPurchasesConverters;", "", "<init>", "()V", "convertMapToWriteableMap", "Lcom/facebook/react/bridge/WritableMap;", "map", "", "", "convertArrayToWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "array", "", "([Ljava/lang/Object;)Lcom/facebook/react/bridge/WritableArray;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "offeringIdentifier", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNPurchasesConverters {
    public static final RNPurchasesConverters INSTANCE = new RNPurchasesConverters();

    private RNPurchasesConverters() {
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

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    public final PresentedOfferingContext presentedOfferingContext(String offeringIdentifier, Map<?, ?> presentedOfferingContext) {
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        if (presentedOfferingContext == null) {
            return new PresentedOfferingContext(offeringIdentifier);
        }
        Object obj = presentedOfferingContext.get("targetingContext");
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            Object obj2 = map.get("revision");
            Number number = obj2 instanceof Number ? (Number) obj2 : null;
            Integer numValueOf = number != null ? Integer.valueOf(number.intValue()) : null;
            Object obj3 = map.get("ruleId");
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (numValueOf == null || str == null) {
                targetingContext = null;
            } else {
                targetingContext = new PresentedOfferingContext.TargetingContext(numValueOf.intValue(), str);
            }
        } else {
            targetingContext = null;
        }
        Object obj4 = presentedOfferingContext.get("placementIdentifier");
        return new PresentedOfferingContext(offeringIdentifier, obj4 instanceof String ? (String) obj4 : null, targetingContext);
    }
}
