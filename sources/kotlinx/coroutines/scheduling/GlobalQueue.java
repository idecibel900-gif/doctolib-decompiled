package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.LockFreeTaskQueue;

/* JADX INFO: loaded from: classes5.dex */
public final class GlobalQueue extends LockFreeTaskQueue {
    public GlobalQueue() {
        super(false);
    }
}
