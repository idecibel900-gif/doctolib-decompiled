package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CompletableDeferredKt {
    public static final boolean completeWith(CompletableDeferred completableDeferred, Object obj) {
        Throwable thM5246exceptionOrNullimpl = Result.m5246exceptionOrNullimpl(obj);
        return thM5246exceptionOrNullimpl == null ? completableDeferred.complete(obj) : completableDeferred.completeExceptionally(thM5246exceptionOrNullimpl);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }

    public static final CompletableDeferred CompletableDeferred(Job job) {
        return new CompletableDeferredImpl(job);
    }
}
