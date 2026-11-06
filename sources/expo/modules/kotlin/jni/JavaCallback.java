package expo.modules.kotlin.jni;

import com.amazon.a.a.o.b;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0082 ¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u0007\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0082 ¢\u0006\u0004\b\u0007\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0013J \u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0016J&\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0082 ¢\u0006\u0004\b\u0007\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0019H\u0082 ¢\u0006\u0004\b\u0007\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0082 ¢\u0006\u0004\b\u0007\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001dH\u0082 ¢\u0006\u0004\b\u0007\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001fH\u0082 ¢\u0006\u0004\b\u0007\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020!H\u0082 ¢\u0006\u0004\b\u0007\u0010\"J \u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\b\u0007\u0010%J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020&H\u0082 ¢\u0006\u0004\b'\u0010(J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020)H\u0082 ¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020,H\u0082 ¢\u0006\u0004\b-\u0010.J\u0018\u00100\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020/H\u0082 ¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0086\u0002¢\u0006\u0004\b3\u00104J\u0010\u00103\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b3\u0010\bJ\u0018\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b3\u0010\u000bJ\u0018\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\u0086\u0002¢\u0006\u0004\b3\u0010\rJ\u0018\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b3\u0010\u000fJ\u0018\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b3\u0010\u0011J\u0018\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b3\u0010\u0013J&\u00103\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0086\u0002¢\u0006\u0004\b3\u0010\u0018J \u00103\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b3\u0010%J\u000f\u00105\u001a\u00020\u0006H\u0004¢\u0006\u0004\b5\u0010\bJ\u000f\u00106\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00107R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u00108¨\u00069"}, d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "Lexpo/modules/kotlin/jni/Destructible;", "Lcom/facebook/jni/HybridData;", "mHybridData", "<init>", "(Lcom/facebook/jni/HybridData;)V", "", "invokeNative", "()V", "", "result", "(I)V", "", "(Z)V", "", "(D)V", "", "(F)V", "", "(Ljava/lang/String;)V", "", "", "(Ljava/util/Collection;)V", "", "(Ljava/util/Map;)V", "Lcom/facebook/react/bridge/WritableNativeArray;", "(Lcom/facebook/react/bridge/WritableNativeArray;)V", "Lcom/facebook/react/bridge/WritableNativeMap;", "(Lcom/facebook/react/bridge/WritableNativeMap;)V", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "(Lexpo/modules/kotlin/sharedobjects/SharedObject;)V", "Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;", "(Lexpo/modules/kotlin/jni/JavaScriptArrayBuffer;)V", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "(Lexpo/modules/kotlin/jni/NativeArrayBuffer;)V", ResponseTypeValues.CODE, b.f, "(Ljava/lang/String;Ljava/lang/String;)V", "", "invokeIntArray", "([I)V", "", "invokeLongArray", "([J)V", "", "invokeFloatArray", "([F)V", "", "invokeDoubleArray", "([D)V", "value", "invoke", "(Ljava/lang/Object;)V", "finalize", "getHybridDataForJNIDeallocator", "()Lcom/facebook/jni/HybridData;", "Lcom/facebook/jni/HybridData;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaCallback implements Destructible {
    private final HybridData mHybridData;

    private final native void invokeDoubleArray(double[] result);

    private final native void invokeFloatArray(float[] result);

    private final native void invokeIntArray(int[] result);

    private final native void invokeLongArray(long[] result);

    private final native void invokeNative();

    private final native void invokeNative(double result);

    private final native void invokeNative(float result);

    private final native void invokeNative(int result);

    private final native void invokeNative(WritableNativeArray result);

    private final native void invokeNative(WritableNativeMap result);

    private final native void invokeNative(JavaScriptArrayBuffer result);

    private final native void invokeNative(NativeArrayBuffer result);

    private final native void invokeNative(SharedObject result);

    private final native void invokeNative(String result);

    private final native void invokeNative(String code, String errorMessage);

    private final native void invokeNative(Collection<? extends Object> result);

    private final native void invokeNative(Map<String, ? extends Object> result);

    private final native void invokeNative(boolean result);

    public JavaCallback(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    public final void invoke(Object value) {
        try {
            Object objConvertToJSValue$default = JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, value, null, true, 2, null);
            if (objConvertToJSValue$default == null) {
                invokeNative();
                return;
            }
            if (objConvertToJSValue$default instanceof Integer) {
                invokeNative(((Number) objConvertToJSValue$default).intValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Boolean) {
                invokeNative(((Boolean) objConvertToJSValue$default).booleanValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Double) {
                invokeNative(((Number) objConvertToJSValue$default).doubleValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Float) {
                invokeNative(((Number) objConvertToJSValue$default).floatValue());
                return;
            }
            if (objConvertToJSValue$default instanceof String) {
                invokeNative((String) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Collection) {
                invokeNative((Collection<? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Map) {
                invokeNative((Map<String, ? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeArray) {
                invokeNative((WritableNativeArray) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeMap) {
                invokeNative((WritableNativeMap) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof SharedObject) {
                invokeNative((SharedObject) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof JavaScriptArrayBuffer) {
                invokeNative((JavaScriptArrayBuffer) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof NativeArrayBuffer) {
                invokeNative((NativeArrayBuffer) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof int[]) {
                invokeIntArray((int[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof long[]) {
                invokeLongArray((long[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof float[]) {
                invokeFloatArray((float[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof double[]) {
                invokeDoubleArray((double[]) objConvertToJSValue$default);
                return;
            }
            throw new UnexpectedException("Unknown type: " + objConvertToJSValue$default.getClass());
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke() {
        try {
            invokeNative();
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(int result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(boolean result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(double result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(float result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(JSTypeConverterHelperKt.toJSValueExperimental(result));
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String code, String errorMessage) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        try {
            invokeNative(code, errorMessage);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
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
