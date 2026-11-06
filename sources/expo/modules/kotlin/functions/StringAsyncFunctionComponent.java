package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StringAsyncFunctionComponent extends UntypedAsyncFunctionComponent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringAsyncFunctionComponent(String name, AnyType[] desiredArgsTypes, Function1 body) {
        super(name, desiredArgsTypes, body);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(body, "body");
    }

    @Override // expo.modules.kotlin.functions.UntypedAsyncFunctionComponent, expo.modules.kotlin.functions.AsyncFunctionComponent
    public void callUserImplementation$expo_modules_core_release(Object[] args, Promise promise, AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        promise.resolve((String) getBody().invoke(AnyFunction.convertArgs$default(this, args, appContext, false, 4, null)));
    }
}
