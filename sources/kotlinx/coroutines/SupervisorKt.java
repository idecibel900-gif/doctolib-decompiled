package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SupervisorKt {
    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }

    public static final CompletableJob SupervisorJob(Job job) {
        return new SupervisorJobImpl(job);
    }
}
