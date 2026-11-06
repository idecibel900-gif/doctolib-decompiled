package expo.modules.kotlin.jni;

import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.runtime.MainRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082 ¢\u0006\u0004\b\u000f\u0010\u0013J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/MainRuntimeInstaller;", "", "Lexpo/modules/kotlin/runtime/MainRuntime;", "runtimeContext", "<init>", "(Lexpo/modules/kotlin/runtime/MainRuntime;)V", "Ljava/lang/ref/WeakReference;", "runtimeContextHolder", "", "jsRuntimePointer", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "jniDeallocator", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "jsInvokerHolder", "Lexpo/modules/kotlin/jni/JSIContext;", "install", "(Ljava/lang/ref/WeakReference;JLexpo/modules/kotlin/jni/JNIDeallocator;Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;)Lexpo/modules/kotlin/jni/JSIContext;", "Lcom/facebook/react/bridge/RuntimeExecutor;", "runtimeExecutor", "(Ljava/lang/ref/WeakReference;JLexpo/modules/kotlin/jni/JNIDeallocator;Lcom/facebook/react/bridge/RuntimeExecutor;)Lexpo/modules/kotlin/jni/JSIContext;", "(JLcom/facebook/react/bridge/RuntimeExecutor;)Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getCoreModuleObject", "()Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/runtime/MainRuntime;", "getRuntimeContext", "()Lexpo/modules/kotlin/runtime/MainRuntime;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainRuntimeInstaller {
    private final MainRuntime runtimeContext;

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator, RuntimeExecutor runtimeExecutor);

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator, CallInvokerHolderImpl jsInvokerHolder);

    public MainRuntimeInstaller(MainRuntime runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        this.runtimeContext = runtimeContext;
    }

    public final JSIContext install(long jsRuntimePointer, RuntimeExecutor runtimeExecutor) {
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        return install(UtilsKt.weak(this.runtimeContext), jsRuntimePointer, this.runtimeContext.getDeallocator(), runtimeExecutor);
    }

    public final JavaScriptModuleObject_ getCoreModuleObject() {
        return this.runtimeContext.getCoreModule$expo_modules_core_release().getJsObject();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
