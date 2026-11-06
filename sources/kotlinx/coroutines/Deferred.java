package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface Deferred extends Job {
    Object await(Continuation continuation);

    Object getCompleted();
}
