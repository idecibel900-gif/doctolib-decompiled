package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.PromiseImpl;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncFunctionComponent extends BaseAsyncFunctionComponent {
    public abstract void callUserImplementation$expo_modules_core_release(Object[] objArr, Promise promise, AppContext appContext);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFunctionComponent(String name, AnyType[] desiredArgsTypes) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
    }

    @Override // expo.modules.kotlin.functions.AnyFunction
    public void attachToJSObject(final AppContext appContext, JSDecoratorsBridgingObject jsObject, final String moduleName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        final WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        String name = getName();
        boolean takesOwner$expo_modules_core_release = getTakesOwner$expo_modules_core_release();
        boolean zIsEnumerable$expo_modules_core_release = isEnumerable$expo_modules_core_release();
        AnyType[] desiredArgsTypes = getDesiredArgsTypes();
        ArrayList arrayList = new ArrayList(desiredArgsTypes.length);
        for (AnyType anyType : desiredArgsTypes) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        jsObject.registerAsyncFunction(name, takesOwner$expo_modules_core_release, zIsEnumerable$expo_modules_core_release, (ExpectedType[]) arrayList.toArray(new ExpectedType[0]), new JNIAsyncFunctionBody() { // from class: expo.modules.kotlin.functions.AsyncFunctionComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIAsyncFunctionBody
            public final void invoke(Object[] objArr, PromiseImpl promiseImpl) {
                AsyncFunctionComponent.attachToJSObject$lambda$4(weakReferenceWeak, moduleName, this, appContext, objArr, promiseImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToJSObject$lambda$4(WeakReference weakReference, final String str, final AsyncFunctionComponent asyncFunctionComponent, final AppContext appContext, final Object[] args, final PromiseImpl promiseImpl) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promiseImpl, "promiseImpl");
        asyncFunctionComponent.dispatchOnQueue(appContext, new Function0() { // from class: expo.modules.kotlin.functions.AsyncFunctionComponent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsyncFunctionComponent.attachToJSObject$lambda$4$lambda$3(promiseImpl, asyncFunctionComponent, str, args, appContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToJSObject$lambda$4$lambda$3(PromiseImpl promiseImpl, AsyncFunctionComponent asyncFunctionComponent, String str, Object[] objArr, AppContext appContext) {
        CodedException unexpectedException;
        CodedException codedException;
        CodedException unexpectedException2;
        try {
            asyncFunctionComponent.callUserImplementation$expo_modules_core_release(objArr, promiseImpl, appContext);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (th instanceof CodedException) {
                    unexpectedException2 = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException2 = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                } else {
                    unexpectedException2 = new UnexpectedException(th);
                }
                throw new FunctionCallException(asyncFunctionComponent.getName(), str, unexpectedException2);
            } catch (Throwable th2) {
                if (promiseImpl.getWasSettled()) {
                    throw th2;
                }
                if (th2 instanceof CodedException) {
                    codedException = (CodedException) th2;
                } else {
                    if (th2 instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th2;
                        String code2 = codedException2.getCode();
                        Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                        unexpectedException = new CodedException(code2, codedException2.getMessage(), codedException2.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th2);
                    }
                    codedException = unexpectedException;
                }
                promiseImpl.reject(codedException);
            }
        }
    }

    private final void dispatchOnQueue(AppContext appContext, Function0 function0) {
        FunctionQueue queue = getQueue();
        if (queue == Queues.DEFAULT) {
            BuildersKt__Builders_commonKt.launch$default(appContext.getModulesQueue(), null, null, new AnonymousClass1(function0, null), 3, null);
        } else {
            if (queue == Queues.MAIN) {
                BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new AnonymousClass3(function0, null), 3, null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionComponent$dispatchOnQueue$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionComponent$dispatchOnQueue$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            return Unit.INSTANCE;
        }
    }
}
