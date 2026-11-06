package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes5.dex */
public interface Waiter {
    void invokeOnCancellation(Segment segment, int i);
}
