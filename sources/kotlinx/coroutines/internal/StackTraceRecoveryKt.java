package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    public static final Throwable recoverStackTrace(Throwable th) {
        return th;
    }

    static {
        Object objM5243constructorimpl;
        Object objM5243constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5246exceptionOrNullimpl(objM5243constructorimpl) != null) {
            objM5243constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        baseContinuationImplClassName = (String) objM5243constructorimpl;
        try {
            objM5243constructorimpl2 = Result.m5243constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            objM5243constructorimpl2 = Result.m5243constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m5246exceptionOrNullimpl(objM5243constructorimpl2) != null) {
            objM5243constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        stackTraceRecoveryClassName = (String) objM5243constructorimpl2;
    }
}
