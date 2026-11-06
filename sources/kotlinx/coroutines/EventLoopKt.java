package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EventLoopKt {
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}
