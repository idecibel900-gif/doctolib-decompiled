package androidx.work;

/* JADX INFO: loaded from: classes3.dex */
public interface RunnableScheduler {
    void cancel(Runnable runnable);

    void scheduleWithDelay(long j, Runnable runnable);
}
