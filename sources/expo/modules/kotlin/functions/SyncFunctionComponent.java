package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ReturnType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SyncFunctionComponent extends AnyFunction {
    private final Function1 body;
    private final ReturnType returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncFunctionComponent(String name, AnyType[] argTypes, ReturnType returnType, Function1 body) {
        super(name, argTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(body, "body");
        this.returnType = returnType;
        this.body = body;
    }

    public final Object callUserImplementation(Object[] args, AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        return this.body.invoke(AnyFunction.convertArgs$default(this, args, appContext, false, 4, null));
    }

    public final JNIFunctionBody getJNIFunctionBody$expo_modules_core_release(final String moduleName, final AppContext appContext) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return new JNIFunctionBody() { // from class: expo.modules.kotlin.functions.SyncFunctionComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return SyncFunctionComponent.getJNIFunctionBody$lambda$2(this.f$0, moduleName, appContext, objArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJNIFunctionBody$lambda$2(SyncFunctionComponent syncFunctionComponent, String str, AppContext appContext, Object[] args) throws FunctionCallException {
        CodedException unexpectedException;
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return syncFunctionComponent.returnType.convertToJS(syncFunctionComponent.callUserImplementation(args, appContext));
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
            throw new FunctionCallException(syncFunctionComponent.getName(), str, unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.functions.AnyFunction
    public void attachToJSObject(AppContext appContext, JSDecoratorsBridgingObject jsObject, String moduleName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        jsObject.registerSyncFunction(getName(), getTakesOwner$expo_modules_core_release(), isEnumerable$expo_modules_core_release(), (ExpectedType[]) getCppRequiredTypes$expo_modules_core_release().toArray(new ExpectedType[0]), this.returnType.getCppType().getValue(), getJNIFunctionBody$expo_modules_core_release(moduleName, appContext));
    }
}
