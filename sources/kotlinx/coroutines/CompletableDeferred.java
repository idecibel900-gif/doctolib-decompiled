package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public interface CompletableDeferred extends Deferred {
    boolean complete(Object obj);

    boolean completeExceptionally(Throwable th);
}
