package expo.modules.kotlin.jni;

import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.runtime.Runtime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082 ¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/jni/WorkletRuntimeInstaller;", "", "Lexpo/modules/kotlin/runtime/Runtime;", "runtime", "<init>", "(Lexpo/modules/kotlin/runtime/Runtime;)V", "Ljava/lang/ref/WeakReference;", "runtimeContextHolder", "", "jsRuntimePointer", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JSIContext;", "install", "(Ljava/lang/ref/WeakReference;JLexpo/modules/kotlin/jni/JNIDeallocator;)Lexpo/modules/kotlin/jni/JSIContext;", "(J)Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/runtime/Runtime;", "getRuntime", "()Lexpo/modules/kotlin/runtime/Runtime;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkletRuntimeInstaller {
    private final Runtime runtime;

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator);

    public WorkletRuntimeInstaller(Runtime runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.runtime = runtime;
    }

    public final JSIContext install(long jsRuntimePointer) {
        return install(UtilsKt.weak(this.runtime), jsRuntimePointer, this.runtime.getDeallocator());
    }
}
