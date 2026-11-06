package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAsyncFunctionComponent extends AnyFunction {
    private FunctionQueue queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAsyncFunctionComponent(String name, AnyType[] desiredArgsTypes) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.queue = Queues.DEFAULT;
    }

    protected final FunctionQueue getQueue() {
        return this.queue;
    }

    public final BaseAsyncFunctionComponent runOnQueue(Queues queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        this.queue = queue;
        return this;
    }
}
