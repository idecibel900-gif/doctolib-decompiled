package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0006H\u0082 ¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u0019\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u000eH\u0086 ¢\u0006\u0004\b\u001a\u0010\u0010J\u0010\u0010\u001c\u001a\u00020\u001bH\u0086 ¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010 \u001a\u00020\u001fH\u0086 ¢\u0006\u0004\b \u0010!J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"H\u0086 ¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%H\u0086 ¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0004¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-¨\u0006."}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptValue;", "Lexpo/modules/kotlin/jni/Destructible;", "Lcom/facebook/jni/HybridData;", "mHybridData", "<init>", "(Lcom/facebook/jni/HybridData;)V", "", "T", "Lexpo/modules/kotlin/jni/JavaScriptFunction;", "jniGetFunction", "()Lexpo/modules/kotlin/jni/JavaScriptFunction;", "", "kind", "()Ljava/lang/String;", "", "isNull", "()Z", "isUndefined", "isBool", "isNumber", "isString", "isSymbol", "isFunction", "isArray", "isTypedArray", "isObject", "getBool", "", "getDouble", "()D", "getString", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "getObject", "()Lexpo/modules/kotlin/jni/JavaScriptObject;", "", "getArray", "()[Lexpo/modules/kotlin/jni/JavaScriptValue;", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "getTypedArray", "()Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "", "finalize", "()V", "getHybridDataForJNIDeallocator", "()Lcom/facebook/jni/HybridData;", "Lcom/facebook/jni/HybridData;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaScriptValue implements Destructible {
    private final HybridData mHybridData;

    private final native <T> JavaScriptFunction<T> jniGetFunction();

    public final native JavaScriptValue[] getArray();

    public final native boolean getBool();

    public final native double getDouble();

    public final native JavaScriptObject getObject();

    public final native String getString();

    public final native JavaScriptTypedArray getTypedArray();

    public final native boolean isArray();

    public final native boolean isBool();

    public final native boolean isFunction();

    public final native boolean isNull();

    public final native boolean isNumber();

    public final native boolean isObject();

    public final native boolean isString();

    public final native boolean isSymbol();

    public final native boolean isTypedArray();

    public final native boolean isUndefined();

    public final native String kind();

    private JavaScriptValue(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    protected final void finalize() {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
