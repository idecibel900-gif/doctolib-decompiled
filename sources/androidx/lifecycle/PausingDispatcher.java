package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Dispatchers.getMain().getImmediate().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }
}
