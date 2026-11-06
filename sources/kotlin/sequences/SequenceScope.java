package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SequenceScope {
    public abstract Object yield(Object obj, Continuation continuation);

    public abstract Object yieldAll(Iterator it, Continuation continuation);

    public final Object yieldAll(Sequence sequence, Continuation continuation) {
        Object objYieldAll = yieldAll(sequence.iterator(), continuation);
        return objYieldAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objYieldAll : Unit.INSTANCE;
    }
}
