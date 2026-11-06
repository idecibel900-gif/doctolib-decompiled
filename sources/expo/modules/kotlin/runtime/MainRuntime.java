package expo.modules.kotlin.runtime;

import androidx.tracing.Trace;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.jni.MainRuntimeInstaller;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MainRuntime extends Runtime {
    private final WeakReference appContextHolder;
    private final ClassRegistry classRegistry;
    private final ModuleHolder coreModule;
    private final JNIDeallocator deallocator;
    public JSIContext jsiContext;
    private final WeakReference reactContextHolder;
    private final SharedObjectRegistry sharedObjectRegistry;

    public final WeakReference getReactContextHolder() {
        return this.reactContextHolder;
    }

    public MainRuntime(AppContext appContext, WeakReference reactContextHolder) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.reactContextHolder = reactContextHolder;
        WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        this.appContextHolder = weakReferenceWeak;
        CoreModule coreModule = new CoreModule();
        coreModule.set_appContextHolder$expo_modules_core_release(weakReferenceWeak);
        this.coreModule = new ModuleHolder(coreModule, null);
        this.deallocator = new JNIDeallocator(false, 1, null);
        this.sharedObjectRegistry = new SharedObjectRegistry(this);
        this.classRegistry = new ClassRegistry();
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public AppContext getAppContext() {
        return (AppContext) this.appContextHolder.get();
    }

    public ReactApplicationContext getReactContext() {
        return (ReactApplicationContext) this.reactContextHolder.get();
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public JSIContext getJsiContext() {
        JSIContext jSIContext = this.jsiContext;
        if (jSIContext != null) {
            return jSIContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsiContext");
        return null;
    }

    public void setJsiContext(JSIContext jSIContext) {
        Intrinsics.checkNotNullParameter(jSIContext, "<set-?>");
        this.jsiContext = jSIContext;
    }

    private final boolean isJSIContextInitialized() {
        return this.jsiContext != null;
    }

    public JavaScriptValue eval(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getJsiContext().evaluateScript(source);
    }

    public final ModuleHolder getCoreModule$expo_modules_core_release() {
        return this.coreModule;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    /* JADX INFO: renamed from: getDeallocator$expo_modules_core_release, reason: merged with bridge method [inline-methods] */
    public JNIDeallocator getDeallocator() {
        return this.deallocator;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public SharedObjectRegistry getSharedObjectRegistry$expo_modules_core_release() {
        return this.sharedObjectRegistry;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public ClassRegistry getClassRegistry$expo_modules_core_release() {
        return this.classRegistry;
    }

    public final void install$expo_modules_core_release() {
        JavaScriptContextHolder javaScriptContextHolder;
        synchronized (this) {
            if (isJSIContextInitialized()) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", null, 2, null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] " + (this + ".install"));
            try {
                ReactApplicationContext reactApplicationContext = (ReactApplicationContext) getReactContextHolder().get();
                if (reactApplicationContext != null && (javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder()) != null) {
                    Long lValueOf = Long.valueOf(javaScriptContextHolder.getContext());
                    if (lValueOf.longValue() == 0) {
                        lValueOf = null;
                    }
                    if (lValueOf != null) {
                        long jLongValue = lValueOf.longValue();
                        MainRuntimeInstaller mainRuntimeInstaller = new MainRuntimeInstaller(this);
                        RuntimeExecutor runtimeExecutor = reactApplicationContext.getCatalystInstance().getRuntimeExecutor();
                        Intrinsics.checkNotNull(runtimeExecutor);
                        setJsiContext(mainRuntimeInstaller.install(jLongValue, runtimeExecutor));
                        CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                    } else {
                        Logger.error$default(CoreLoggerKt.getLogger(), "❌ Cannot install JSI interop - JS runtime pointer is null", null, 2, null);
                    }
                }
            } catch (Throwable th) {
                try {
                    CoreLoggerKt.getLogger().error("❌ Cannot install JSI interop: " + th, th);
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    public void deallocate$expo_modules_core_release() {
        getDeallocator().deallocate$expo_modules_core_release();
    }
}
