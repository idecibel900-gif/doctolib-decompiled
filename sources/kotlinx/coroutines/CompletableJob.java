package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public interface CompletableJob extends Job {
    boolean completeExceptionally(Throwable th);
}
