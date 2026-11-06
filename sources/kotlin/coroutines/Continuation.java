package kotlin.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public interface Continuation {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
