package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: classes5.dex */
public final class NanoTimeSource extends SchedulerTimeSource {
    public static final NanoTimeSource INSTANCE = new NanoTimeSource();

    private NanoTimeSource() {
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerTimeSource
    public long nanoTime() {
        return System.nanoTime();
    }
}
