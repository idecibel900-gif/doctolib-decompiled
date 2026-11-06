package com.facebook.react.bridge;

import android.annotation.SuppressLint;
import com.facebook.infer.annotation.Assertions;
import com.opentok.android.PublisherKit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082 ¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H\u0082 ¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H\u0082 ¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J6\u0010\u001e\u001a\u0002H\u001f\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\"H\u0083\b¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J,\u0010$\u001a\u0002H\u001f\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\"H\u0082\b¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J.\u0010&\u001a\u0004\u0018\u0001H\u001f\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\"H\u0082\b¢\u0006\u0002\u0010%J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u0002042\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020+H\u0016J\u0013\u0010=\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J(\u0010?\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000e`AH\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R&\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e07068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006C"}, d2 = {"Lcom/facebook/react/bridge/ReadableNativeMap;", "Lcom/facebook/react/bridge/NativeMap;", "Lcom/facebook/react/bridge/ReadableMap;", "<init>", "()V", "keysStorage", "", "", "[Ljava/lang/String;", "keys", "getKeys", "()[Ljava/lang/String;", "localMapStorage", "", "", "localMap", "getLocalMap", "()Ljava/util/Map;", "localTypeMapStorage", "Lcom/facebook/react/bridge/ReadableType;", "localTypeMap", "getLocalTypeMap", "importKeys", "importValues", "()[Ljava/lang/Object;", "importTypes", "hasKey", "", "name", "isNull", "checkInstance", "T", "instance", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "getValue", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getNullableValue", "getBoolean", "getDouble", "", "getInt", "", "getLong", "", "getString", "getArray", "Lcom/facebook/react/bridge/ReadableArray;", "getMap", "getType", "getDynamic", "Lcom/facebook/react/bridge/Dynamic;", "entryIterator", "", "", "getEntryIterator", "()Ljava/util/Iterator;", "keySetIterator", "Lcom/facebook/react/bridge/ReadableMapKeySetIterator;", "hashCode", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "toHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ReadableNativeMap extends NativeMap implements ReadableMap {
    private static final Companion Companion = new Companion(null);
    private static int jniPassCounter;
    private String[] keysStorage;
    private Map<String, ? extends Object> localMapStorage;
    private Map<String, ? extends ReadableType> localTypeMapStorage;

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

    public static final int getJNIPassCounter() {
        return Companion.getJNIPassCounter();
    }

    private final native String[] importKeys();

    private final native Object[] importTypes();

    private final native Object[] importValues();

    protected ReadableNativeMap() {
    }

    private final String[] getKeys() {
        String[] strArrImportKeys;
        String[] strArr = this.keysStorage;
        if (strArr != null) {
            return strArr;
        }
        synchronized (this) {
            strArrImportKeys = this.keysStorage;
            if (strArrImportKeys == null) {
                strArrImportKeys = importKeys();
                this.keysStorage = strArrImportKeys;
                jniPassCounter++;
            }
        }
        return strArrImportKeys;
    }

    private final Map<String, Object> getLocalMap() {
        Map<String, ? extends Object> map;
        Map<String, ? extends Object> map2 = this.localMapStorage;
        if (map2 != null) {
            return map2;
        }
        synchronized (this) {
            try {
                map = this.localMapStorage;
                if (map == null) {
                    String[] keys = getKeys();
                    int length = keys.length;
                    HashMap map3 = new HashMap();
                    Object[] objArrImportValues = importValues();
                    for (int i = 0; i < length; i++) {
                        map3.put(keys[i], objArrImportValues[i]);
                    }
                    this.localMapStorage = map3;
                    jniPassCounter++;
                    map = map3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, ReadableType> getLocalTypeMap() {
        Map map;
        Map map2 = this.localTypeMapStorage;
        if (map2 != null) {
            return map2;
        }
        synchronized (this) {
            try {
                Map map3 = this.localTypeMapStorage;
                map = map3;
                if (map3 == null) {
                    String[] keys = getKeys();
                    Map map4 = new HashMap();
                    Object[] objArrImportTypes = importTypes();
                    int length = keys.length;
                    for (int i = 0; i < length; i++) {
                        String str = keys[i];
                        Object obj = objArrImportTypes[i];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableType");
                        map4.put(str, (ReadableType) obj);
                    }
                    this.localTypeMapStorage = map4;
                    jniPassCounter++;
                    map = map4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getLocalMap().containsKey(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (getLocalMap().containsKey(name)) {
            return getLocalMap().get(name) == null;
        }
        throw new NoSuchKeyException(name);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ReflectionMethodUse"})
    private final /* synthetic */ <T> T checkInstance(String name, Object instance, Class<T> type) {
        Intrinsics.reifiedOperationMarker(2, "T");
        if (instance != 0) {
            return instance;
        }
        throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (instance != 0 ? instance.getClass().getSimpleName() : "NULL") + " to " + type.getSimpleName());
    }

    private final Object getValue(String name) {
        if (hasKey(name)) {
            Object objAssertNotNull = Assertions.assertNotNull(getLocalMap().get(name));
            Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
            return objAssertNotNull;
        }
        throw new NoSuchKeyException(name);
    }

    private final /* synthetic */ <T> T getValue(String name, Class<T> type) {
        T t = (T) getValue(name);
        Intrinsics.reifiedOperationMarker(2, "T");
        if (t != null) {
            return t;
        }
        throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (t != null ? t.getClass().getSimpleName() : "NULL") + " to " + type.getSimpleName());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Boolean bool = (Boolean) (!(value instanceof Boolean) ? null : value);
        if (bool == null) {
            throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (value != null ? value.getClass().getSimpleName() : "NULL") + " to " + Boolean.TYPE.getSimpleName());
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Double d = (Double) (!(value instanceof Double) ? null : value);
        if (d == null) {
            throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (value != null ? value.getClass().getSimpleName() : "NULL") + " to " + Double.TYPE.getSimpleName());
        }
        return d.doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Double d = (Double) (!(value instanceof Double) ? null : value);
        if (d == null) {
            throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (value != null ? value.getClass().getSimpleName() : "NULL") + " to " + Double.TYPE.getSimpleName());
        }
        return (int) d.doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Long l = (Long) (!(value instanceof Long) ? null : value);
        if (l == null) {
            throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + (value != null ? value.getClass().getSimpleName() : "NULL") + " to " + Long.TYPE.getSimpleName());
        }
        return l.longValue();
    }

    private final Object getNullableValue(String name) {
        return getLocalMap().get(name);
    }

    private final /* synthetic */ <T> T getNullableValue(String name, Class<T> type) {
        T t = (T) getNullableValue(name);
        if (t == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableArray getArray(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        ReadableArray readableArray = (ReadableArray) (nullableValue instanceof ReadableArray ? nullableValue : null);
        if (readableArray != null) {
            return readableArray;
        }
        throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + nullableValue.getClass().getSimpleName() + " to " + ReadableArray.class.getSimpleName());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableNativeMap getMap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        ReadableNativeMap readableNativeMap = (ReadableNativeMap) (nullableValue instanceof ReadableNativeMap ? nullableValue : null);
        if (readableNativeMap != null) {
            return readableNativeMap;
        }
        throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + nullableValue.getClass().getSimpleName() + " to " + ReadableNativeMap.class.getSimpleName());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        String str = (String) (nullableValue instanceof String ? nullableValue : null);
        if (str != null) {
            return str;
        }
        throw new UnexpectedNativeTypeException("Value for " + name + " cannot be cast from " + nullableValue.getClass().getSimpleName() + " to " + String.class.getSimpleName());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableType getType(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ReadableType readableType = getLocalTypeMap().get(name);
        if (readableType != null) {
            return readableType;
        }
        throw new NoSuchKeyException(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Dynamic getDynamic(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return DynamicFromMap.INSTANCE.create(this, name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        String[] keys = getKeys();
        Object[] objArrImportValues = importValues();
        jniPassCounter++;
        return new ReadableNativeMap$entryIterator$1(keys, objArrImportValues);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        final String[] keys = getKeys();
        return new ReadableMapKeySetIterator() { // from class: com.facebook.react.bridge.ReadableNativeMap.keySetIterator.1
            private int currentIndex;

            public final int getCurrentIndex() {
                return this.currentIndex;
            }

            public final void setCurrentIndex(int i) {
                this.currentIndex = i;
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.currentIndex < keys.length;
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public String nextKey() {
                String[] strArr = keys;
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                return strArr[i];
            }
        };
    }

    public int hashCode() {
        return getLocalMap().hashCode();
    }

    public boolean equals(Object other) {
        if (other instanceof ReadableNativeMap) {
            return Intrinsics.areEqual(getLocalMap(), ((ReadableNativeMap) other).getLocalMap());
        }
        return false;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>(getLocalMap());
        for (String str : map.keySet()) {
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
            String str2 = str;
            switch (WhenMappings.$EnumSwitchMapping$0[getType(str2).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                case 5:
                    map.put(str2, ((ReadableNativeMap) Assertions.assertNotNull(getMap(str2))).toHashMap());
                    break;
                case 6:
                    map.put(str2, ((ReadableArray) Assertions.assertNotNull(getArray(str2))).toArrayList());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return map;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/bridge/ReadableNativeMap$Companion;", "", "<init>", "()V", "value", "", "jniPassCounter", "getJNIPassCounter", "()I", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getJNIPassCounter() {
            return ReadableNativeMap.jniPassCounter;
        }
    }
}
