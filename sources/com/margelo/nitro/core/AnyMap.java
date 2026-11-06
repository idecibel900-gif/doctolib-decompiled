package com.margelo.nitro.core;

import androidx.annotation.Keep;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import dalvik.annotation.optimization.FastNative;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ)\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000eH\u0086 J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\rJ'\u0010\u0014\u001a\u00020\u00102\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082 J\u0011\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\t\u0010\u001b\u001a\u00020\u0010H\u0087 J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0086 ¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010 \u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010!\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010\"\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010#\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010$\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010%\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010&\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010(\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0011\u0010+\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0087 J \u0010,\u001a\f\u0012\u0004\u0012\u00020-0\u001dj\u0002`.2\u0006\u0010\u0011\u001a\u00020\rH\u0086 ¢\u0006\u0002\u0010/J!\u00100\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0\u0016j\u0002`12\u0006\u0010\u0011\u001a\u00020\rH\u0086 J\u0011\u00102\u001a\u00020-2\u0006\u0010\u0011\u001a\u00020\rH\u0082 J\u0011\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0087 J\u0019\u00104\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020'H\u0087 J\u0019\u00105\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0018H\u0087 J\u0019\u00106\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020*H\u0087 J\u0019\u00107\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0087 J(\u00108\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020-0\u001dj\u0002`.H\u0086 ¢\u0006\u0002\u00109J)\u0010:\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0\u0016j\u0002`1H\u0086 J\u0019\u0010;\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020-H\u0082 J\u0011\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0000H\u0086 J\t\u0010>\u001a\u00020\bH\u0083 J\u0011\u0010>\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/margelo/nitro/core/AnyMap;", "", "<init>", "()V", "preallocatedSize", "", "(I)V", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "toHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setAny", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "getAny", "fromHashMap", "map", "", "ignoreIncompatible", "", "contains", "remove", "clear", "getAllKeys", "", "()[Ljava/lang/String;", "isNull", "isDouble", "isBoolean", "isInt64", "isString", "isArray", "isObject", "getDouble", "", "getBoolean", "getInt64", "", "getString", "getAnyArray", "Lcom/margelo/nitro/core/AnyValue;", "Lcom/margelo/nitro/core/AnyArray;", "(Ljava/lang/String;)[Lcom/margelo/nitro/core/AnyValue;", "getAnyObject", "Lcom/margelo/nitro/core/AnyObject;", "getAnyValue", "setNull", "setDouble", "setBoolean", "setInt64", "setString", "setAnyArray", "(Ljava/lang/String;[Lcom/margelo/nitro/core/AnyValue;)V", "setAnyObject", "setAnyValue", "merge", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "initHybrid", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyMap {
    private final HybridData mHybridData;

    private final native void fromHashMap(Map<String, ? extends Object> map, boolean ignoreIncompatible);

    public static final native AnyMap fromMap(Map<String, ? extends Object> map, boolean z);

    private final native AnyValue getAnyValue(String key);

    @FastNative
    private final native HybridData initHybrid();

    private final native HybridData initHybrid(int preallocatedSize);

    private final native void setAnyValue(String key, AnyValue value);

    @FastNative
    public final native void clear();

    @FastNative
    public final native boolean contains(String key);

    public final native String[] getAllKeys();

    public final native AnyValue[] getAnyArray(String key);

    public final native Map<String, AnyValue> getAnyObject(String key);

    @FastNative
    public final native boolean getBoolean(String key);

    @FastNative
    public final native double getDouble(String key);

    @FastNative
    public final native long getInt64(String key);

    @FastNative
    public final native String getString(String key);

    @FastNative
    public final native boolean isArray(String key);

    @FastNative
    public final native boolean isBoolean(String key);

    @FastNative
    public final native boolean isDouble(String key);

    @FastNative
    public final native boolean isInt64(String key);

    @FastNative
    public final native boolean isNull(String key);

    @FastNative
    public final native boolean isObject(String key);

    @FastNative
    public final native boolean isString(String key);

    public final native void merge(AnyMap other);

    @FastNative
    public final native void remove(String key);

    public final native void setAnyArray(String key, AnyValue[] value);

    public final native void setAnyObject(String key, Map<String, AnyValue> value);

    @FastNative
    public final native void setBoolean(String key, boolean value);

    @FastNative
    public final native void setDouble(String key, double value);

    @FastNative
    public final native void setInt64(String key, long value);

    @FastNative
    public final native void setNull(String key);

    @FastNative
    public final native void setString(String key, String value);

    public final native HashMap<String, Object> toHashMap();

    public AnyMap() {
        this.mHybridData = initHybrid();
    }

    public AnyMap(int i) {
        this.mHybridData = initHybrid(i);
    }

    private AnyMap(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final void setAny(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setAnyValue(key, AnyValue.INSTANCE.fromAny(value));
    }

    public final Object getAny(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getAnyValue(key).toAny();
    }
}
