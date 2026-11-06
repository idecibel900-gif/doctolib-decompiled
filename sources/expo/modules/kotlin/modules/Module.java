package expo.modules.kotlin.modules;

import android.os.Bundle;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.EnumExtensionsKt;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.runtime.MainRuntime;
import expo.modules.kotlin.runtime.Runtime;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Module implements AppContextProvider {
    public Lazy coroutineScopeDelegate;
    private WeakReference _appContextHolder = new WeakReference(null);
    private final Lazy moduleEventEmitter$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.modules.Module$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Module.moduleEventEmitter_delegate$lambda$2(this.f$0);
        }
    });

    public TypeConverterProvider converters() {
        return null;
    }

    public abstract ModuleDefinitionData definition();

    public final void set_appContextHolder$expo_modules_core_release(WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this._appContextHolder = weakReference;
    }

    public final Runtime getRuntime() {
        AppContext appContext = (AppContext) this._appContextHolder.get();
        MainRuntime runtime = appContext != null ? appContext.getRuntime() : null;
        if (runtime != null) {
            return runtime;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the hosting runtime.");
    }

    @Override // expo.modules.kotlin.providers.AppContextProvider
    public AppContext getAppContext() {
        Object obj = this._appContextHolder.get();
        if (obj != null) {
            return (AppContext) obj;
        }
        throw new IllegalArgumentException("You attempted to access the app context before the module was created. Defer accessing the context until after the module initializes.");
    }

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventEmitter moduleEventEmitter_delegate$lambda$2(Module module) {
        return module.getAppContext().eventEmitter(module);
    }

    public final void setCoroutineScopeDelegate(Lazy lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.coroutineScopeDelegate = lazy;
    }

    public static /* synthetic */ void sendEvent$default(Module module, String str, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(str, bundle);
    }

    public final void sendEvent(String name, Bundle bundle) {
        Intrinsics.checkNotNullParameter(name, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, bundle);
        }
    }

    public final void sendEvent(String name, Map body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public final void sendEvent(Enum r2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(EnumExtensionsKt.convertToString(r2), bundle);
        }
    }
}
