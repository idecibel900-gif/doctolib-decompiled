package kotlinx.coroutines;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AwaitKt {
    public static final Object awaitAll(Collection collection, Continuation continuation) {
        return collection.isEmpty() ? CollectionsKt.emptyList() : new AwaitAll((Deferred[]) collection.toArray(new Deferred[0])).await(continuation);
    }
}
