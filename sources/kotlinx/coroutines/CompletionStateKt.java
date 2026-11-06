package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CompletionStateKt {
    public static final Object toState(Object obj) {
        Throwable thM5246exceptionOrNullimpl = Result.m5246exceptionOrNullimpl(obj);
        return thM5246exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM5246exceptionOrNullimpl, false, 2, null);
    }

    public static final Object toState(Object obj, CancellableContinuation cancellableContinuation) {
        Throwable thM5246exceptionOrNullimpl = Result.m5246exceptionOrNullimpl(obj);
        return thM5246exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM5246exceptionOrNullimpl, false, 2, null);
    }

    public static final Object recoverResult(Object obj, Continuation continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.Companion;
            return Result.m5243constructorimpl(ResultKt.createFailure(((CompletedExceptionally) obj).cause));
        }
        return Result.m5243constructorimpl(obj);
    }
}
