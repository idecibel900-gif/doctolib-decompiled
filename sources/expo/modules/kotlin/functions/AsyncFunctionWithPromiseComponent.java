package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AsyncFunctionWithPromiseComponent extends AsyncFunctionComponent {
    private final Function2 body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFunctionWithPromiseComponent(String name, AnyType[] desiredArgsTypes, Function2 body) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    @Override // expo.modules.kotlin.functions.AsyncFunctionComponent
    public void callUserImplementation$expo_modules_core_release(Object[] args, Promise promise, AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.body.invoke(AnyFunction.convertArgs$default(this, args, appContext, false, 4, null), promise);
    }
}
