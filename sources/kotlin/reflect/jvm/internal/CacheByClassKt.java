package kotlin.reflect.jvm.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CacheByClassKt {
    static {
        Object objM5243constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5249isSuccessimpl(objM5243constructorimpl)) {
            objM5243constructorimpl = Boolean.TRUE;
        }
        Object objM5243constructorimpl2 = Result.m5243constructorimpl(objM5243constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m5248isFailureimpl(objM5243constructorimpl2)) {
            objM5243constructorimpl2 = bool;
        }
        ((Boolean) objM5243constructorimpl2).getClass();
    }

    public static final CacheByClass createCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        return new ConcurrentHashMapCache(compute);
    }
}
