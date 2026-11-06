package com.facebook.react.bridge;

import androidx.core.util.Pools$SimplePool;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000fR\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/facebook/react/bridge/DynamicFromMap;", "Lcom/facebook/react/bridge/Dynamic;", "<init>", "()V", "T", "Lkotlin/Function2;", "Lcom/facebook/react/bridge/ReadableMap;", "", "executor", "accessMapSafely", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "", "recycle", "", "asBoolean", "()Z", "", "asDouble", "()D", "", "asInt", "()I", "asString", "()Ljava/lang/String;", "Lcom/facebook/react/bridge/ReadableArray;", "asArray", "()Lcom/facebook/react/bridge/ReadableArray;", "asMap", "()Lcom/facebook/react/bridge/ReadableMap;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "name", "Ljava/lang/String;", "isNull", "Lcom/facebook/react/bridge/ReadableType;", "getType", "()Lcom/facebook/react/bridge/ReadableType;", "type", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicFromMap implements Dynamic {
    private static final String DYNAMIC_VALUE_RECYCLED_FAILURE_MESSAGE = "This dynamic value has been recycled";
    private ReadableMap map;
    private String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadLocal<Pools$SimplePool> pool = new ThreadLocal<Pools$SimplePool>() { // from class: com.facebook.react.bridge.DynamicFromMap$Companion$pool$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Pools$SimplePool initialValue() {
            return new Pools$SimplePool(10);
        }
    };

    public /* synthetic */ DynamicFromMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DynamicFromMap() {
    }

    @Override // com.facebook.react.bridge.Dynamic
    public void recycle() {
        this.map = null;
        this.name = null;
        Pools$SimplePool pools$SimplePool = pool.get();
        if (pools$SimplePool != null) {
            pools$SimplePool.release(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_isNull_$lambda$0(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.isNull(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean isNull() {
        return ((Boolean) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(DynamicFromMap._get_isNull_$lambda$0((ReadableMap) obj, (String) obj2));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBoolean$lambda$1(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getBoolean(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean asBoolean() {
        return ((Boolean) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(DynamicFromMap.asBoolean$lambda$1((ReadableMap) obj, (String) obj2));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double asDouble$lambda$2(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getDouble(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public double asDouble() {
        return ((Number) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Double.valueOf(DynamicFromMap.asDouble$lambda$2((ReadableMap) obj, (String) obj2));
            }
        })).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt$lambda$3(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getInt(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public int asInt() {
        return ((Number) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(DynamicFromMap.asInt$lambda$3((ReadableMap) obj, (String) obj2));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String asString$lambda$4(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getString(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public String asString() {
        return (String) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DynamicFromMap.asString$lambda$4((ReadableMap) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableArray asArray$lambda$5(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getArray(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableArray asArray() {
        return (ReadableArray) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DynamicFromMap.asArray$lambda$5((ReadableMap) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableMap asMap$lambda$6(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getMap(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableMap asMap() {
        return (ReadableMap) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DynamicFromMap.asMap$lambda$6((ReadableMap) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableType _get_type_$lambda$7(ReadableMap map, String name) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        return map.getType(name);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableType getType() {
        return (ReadableType) accessMapSafely(new Function2() { // from class: com.facebook.react.bridge.DynamicFromMap$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DynamicFromMap._get_type_$lambda$7((ReadableMap) obj, (String) obj2);
            }
        });
    }

    private final <T> T accessMapSafely(Function2 executor) {
        String str = this.name;
        if (str == null) {
            throw new IllegalStateException(DYNAMIC_VALUE_RECYCLED_FAILURE_MESSAGE);
        }
        ReadableMap readableMap = this.map;
        if (readableMap == null) {
            throw new IllegalStateException(DYNAMIC_VALUE_RECYCLED_FAILURE_MESSAGE);
        }
        return (T) executor.invoke(readableMap, str);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/bridge/DynamicFromMap$Companion;", "", "<init>", "()V", "pool", "Ljava/lang/ThreadLocal;", "Landroidx/core/util/Pools$SimplePool;", "Lcom/facebook/react/bridge/DynamicFromMap;", "DYNAMIC_VALUE_RECYCLED_FAILURE_MESSAGE", "", "create", "map", "Lcom/facebook/react/bridge/ReadableMap;", "name", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DynamicFromMap create(ReadableMap map, String name) {
            DynamicFromMap dynamicFromMap;
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(name, "name");
            Pools$SimplePool pools$SimplePool = (Pools$SimplePool) DynamicFromMap.pool.get();
            if (pools$SimplePool == null || (dynamicFromMap = (DynamicFromMap) pools$SimplePool.acquire()) == null) {
                dynamicFromMap = new DynamicFromMap(null);
            }
            dynamicFromMap.map = map;
            dynamicFromMap.name = name;
            return dynamicFromMap;
        }
    }
}
