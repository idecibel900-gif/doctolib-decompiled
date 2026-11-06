package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DebugStringsKt {
    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(Continuation continuation) {
        Object objM5243constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5246exceptionOrNullimpl(objM5243constructorimpl) != null) {
            objM5243constructorimpl = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) objM5243constructorimpl;
    }

    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
