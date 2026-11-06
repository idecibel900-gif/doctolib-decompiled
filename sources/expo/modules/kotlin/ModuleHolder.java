package expo.modules.kotlin;

import androidx.tracing.Trace;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.MethodNotFoundException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JavaScriptModuleObject_;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.runtime.Runtime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ModuleHolder {
    private final String _name;
    private final ModuleDefinitionData definition;
    private final Lazy jsObject$delegate;
    private final Module module;
    private boolean wasInitialized;

    public ModuleHolder(Module module, String str) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.module = module;
        this._name = str;
        this.definition = module.definition();
        this.jsObject$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.ModuleHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModuleHolder.jsObject_delegate$lambda$3(this.f$0);
            }
        });
    }

    public final Module getModule() {
        return this.module;
    }

    public final ModuleDefinitionData getDefinition() {
        return this.definition;
    }

    public final String getName() {
        String str = this._name;
        return str == null ? this.definition.getName() : str;
    }

    public final JavaScriptModuleObject_ getSafeJSObject() {
        if (this.wasInitialized) {
            return getJsObject();
        }
        return null;
    }

    public final JavaScriptModuleObject_ getJsObject() {
        return (JavaScriptModuleObject_) this.jsObject$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaScriptModuleObject_ jsObject_delegate$lambda$3(ModuleHolder moduleHolder) {
        moduleHolder.wasInitialized = true;
        Trace.beginSection("[ExpoModulesCore] " + (moduleHolder.getName() + ".jsObject"));
        try {
            AppContext appContext = moduleHolder.getModule().getAppContext();
            Runtime runtime = moduleHolder.getModule().getRuntime();
            JNIDeallocator deallocator = runtime.getDeallocator();
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(deallocator);
            moduleHolder.export(jSDecoratorsBridgingObject, appContext, runtime);
            JavaScriptModuleObject_ javaScriptModuleObject = new JavaScriptModuleObject_(deallocator, moduleHolder.getName());
            javaScriptModuleObject.decorate(jSDecoratorsBridgingObject);
            return javaScriptModuleObject;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void export(JSDecoratorsBridgingObject jSDecoratorsBridgingObject, AppContext appContext, Runtime runtime) {
        jSDecoratorsBridgingObject.registerModuleName(getName());
        ModuleDefinitionData moduleDefinitionData = this.definition;
        ObjectDefinitionData objectDefinition = moduleDefinitionData.getObjectDefinition();
        jSDecoratorsBridgingObject.exportConstants(objectDefinition);
        jSDecoratorsBridgingObject.exportFunctions(objectDefinition, moduleDefinitionData.getName(), appContext);
        jSDecoratorsBridgingObject.exportProperties(objectDefinition, appContext);
        jSDecoratorsBridgingObject.exportViewPrototypes(moduleDefinitionData.getViewManagerDefinitions(), moduleDefinitionData.getName(), appContext, runtime);
        jSDecoratorsBridgingObject.exportClasses(moduleDefinitionData.getClassData(), appContext, runtime);
    }

    public final void call(String methodName, Object[] args, Promise promise) throws FunctionCallException {
        CodedException unexpectedException;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = (BaseAsyncFunctionComponent) getDefinition().getAsyncFunctions().get(methodName);
            if (baseAsyncFunctionComponent == null) {
                throw new MethodNotFoundException();
            }
            if (baseAsyncFunctionComponent instanceof AsyncFunctionComponent) {
                ((AsyncFunctionComponent) baseAsyncFunctionComponent).callUserImplementation$expo_modules_core_release(args, promise, getModule().getAppContext());
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Cannot call a " + baseAsyncFunctionComponent + " method in test context");
            }
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new FunctionCallException(methodName, getName(), unexpectedException);
        }
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = (EventListener) this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        BasicEventListener basicEventListener = eventListener instanceof BasicEventListener ? (BasicEventListener) eventListener : null;
        if (basicEventListener != null) {
            basicEventListener.call();
        }
    }

    public final void post(EventName eventName, Object obj) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public final void post(EventName eventName, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = (EventListener) this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        EventListenerWithSenderAndPayload eventListenerWithSenderAndPayload = eventListener instanceof EventListenerWithSenderAndPayload ? (EventListenerWithSenderAndPayload) eventListener : null;
        if (eventListenerWithSenderAndPayload != null) {
            eventListenerWithSenderAndPayload.call(obj, obj2);
        }
    }

    public final void registerContracts() {
        Function2 registerContracts = this.definition.getRegisterContracts();
        if (registerContracts != null) {
            BuildersKt__Builders_commonKt.launch$default(this.module.getAppContext().getMainQueue(), null, null, new ModuleHolder$registerContracts$1$1(registerContracts, this, null), 3, null);
        }
    }
}
