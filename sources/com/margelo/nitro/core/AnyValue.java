package com.margelo.nitro.core;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import dalvik.annotation.optimization.FastNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0002\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u0002\u0010\u000fB\u001b\b\u0016\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011¢\u0006\u0004\b\u0002\u0010\u0012B!\b\u0016\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014¢\u0006\u0004\b\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\nH\u0087 J\t\u0010\u0017\u001a\u00020\nH\u0087 J\t\u0010\u0018\u001a\u00020\nH\u0087 J\t\u0010\u0019\u001a\u00020\nH\u0087 J\t\u0010\u001a\u001a\u00020\nH\u0087 J\t\u0010\u001b\u001a\u00020\nH\u0087 J\t\u0010\u001c\u001a\u00020\nH\u0087 J\t\u0010\u001d\u001a\u00020\bH\u0087 J\t\u0010\u001e\u001a\u00020\nH\u0087 J\t\u0010\u001f\u001a\u00020\fH\u0087 J\t\u0010 \u001a\u00020\u000eH\u0087 J\u0018\u0010!\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011H\u0086 ¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014H\u0086 J\t\u0010$\u001a\u00020\u0005H\u0083 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0083 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\nH\u0083 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\fH\u0083 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eH\u0083 J \u0010$\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011H\u0082 ¢\u0006\u0002\u0010%J!\u0010$\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014H\u0082 J\b\u0010&\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/margelo/nitro/core/AnyValue;", "", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "value", "", "(D)V", "", "(Z)V", "", "(J)V", "", "(Ljava/lang/String;)V", "", "Lcom/margelo/nitro/core/AnyArray;", "([Lcom/margelo/nitro/core/AnyValue;)V", "", "Lcom/margelo/nitro/core/AnyObject;", "(Ljava/util/Map;)V", "isNull", "isDouble", "isBoolean", "isInt64", "isString", "isAnyArray", "isAnyObject", "asDouble", "asBoolean", "asInt64", "asString", "asAnyArray", "()[Lcom/margelo/nitro/core/AnyValue;", "asAnyObject", "initHybrid", "([Lcom/margelo/nitro/core/AnyValue;)Lcom/facebook/jni/HybridData;", "toAny", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyValue {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    @FastNative
    private final native HybridData initHybrid();

    @FastNative
    private final native HybridData initHybrid(double value);

    @FastNative
    private final native HybridData initHybrid(long value);

    @FastNative
    private final native HybridData initHybrid(String value);

    private final native HybridData initHybrid(Map<String, AnyValue> value);

    @FastNative
    private final native HybridData initHybrid(boolean value);

    private final native HybridData initHybrid(AnyValue[] value);

    public final native AnyValue[] asAnyArray();

    public final native Map<String, AnyValue> asAnyObject();

    @FastNative
    public final native boolean asBoolean();

    @FastNative
    public final native double asDouble();

    @FastNative
    public final native long asInt64();

    @FastNative
    public final native String asString();

    @FastNative
    public final native boolean isAnyArray();

    @FastNative
    public final native boolean isAnyObject();

    @FastNative
    public final native boolean isBoolean();

    @FastNative
    public final native boolean isDouble();

    @FastNative
    public final native boolean isInt64();

    @FastNative
    public final native boolean isNull();

    @FastNative
    public final native boolean isString();

    public AnyValue() {
        this.mHybridData = initHybrid();
    }

    @DoNotStrip
    @Keep
    private AnyValue(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public AnyValue(double d) {
        this.mHybridData = initHybrid(d);
    }

    public AnyValue(boolean z) {
        this.mHybridData = initHybrid(z);
    }

    public AnyValue(long j) {
        this.mHybridData = initHybrid(j);
    }

    public AnyValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public AnyValue(AnyValue[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public AnyValue(Map<String, AnyValue> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public final Object toAny() {
        if (isNull()) {
            return null;
        }
        if (isDouble()) {
            return Double.valueOf(asDouble());
        }
        if (isInt64()) {
            return Long.valueOf(asInt64());
        }
        if (isBoolean()) {
            return Boolean.valueOf(asBoolean());
        }
        if (isString()) {
            return asString();
        }
        if (isAnyArray()) {
            AnyValue[] anyValueArrAsAnyArray = asAnyArray();
            ArrayList arrayList = new ArrayList(anyValueArrAsAnyArray.length);
            for (AnyValue anyValue : anyValueArrAsAnyArray) {
                arrayList.add(anyValue.toAny());
            }
            return arrayList.toArray(new Object[0]);
        }
        if (isAnyObject()) {
            Map<String, AnyValue> mapAsAnyObject = asAnyObject();
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapAsAnyObject.size()));
            Iterator<T> it = mapAsAnyObject.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                linkedHashMap.put(key, ((AnyValue) entry.getValue()).toAny());
            }
            return linkedHashMap;
        }
        throw new Error("AnyValue holds unknown type!");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnyValue fromAny(Object obj) {
            if (obj == null) {
                return new AnyValue();
            }
            if (obj instanceof Double) {
                return new AnyValue(((Number) obj).doubleValue());
            }
            if (obj instanceof Float) {
                return new AnyValue(((Number) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return new AnyValue(((Number) obj).intValue());
            }
            if (obj instanceof Boolean) {
                return new AnyValue(((Boolean) obj).booleanValue());
            }
            if (obj instanceof Long) {
                return new AnyValue(((Number) obj).longValue());
            }
            if (obj instanceof String) {
                return new AnyValue((String) obj);
            }
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                ArrayList arrayList = new ArrayList(objArr.length);
                for (Object obj2 : objArr) {
                    arrayList.add(AnyValue.INSTANCE.fromAny(obj2));
                }
                return new AnyValue((AnyValue[]) arrayList.toArray(new AnyValue[0]));
            }
            if (obj instanceof List) {
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AnyValue.INSTANCE.fromAny(it.next()));
                }
                return new AnyValue((AnyValue[]) arrayList2.toArray(new AnyValue[0]));
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                ArrayList arrayList3 = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList3.add(TuplesKt.to(String.valueOf(entry.getKey()), AnyValue.INSTANCE.fromAny(entry.getValue())));
                }
                return new AnyValue((Map<String, AnyValue>) MapsKt.toMap(arrayList3));
            }
            if ((obj instanceof AnyValue) || (obj instanceof AnyMap)) {
                throw new Error("Cannot box AnyValue (" + obj + ") twice!");
            }
            throw new Error("Value \"" + obj + "\" cannot be represented as AnyValue!");
        }
    }
}
