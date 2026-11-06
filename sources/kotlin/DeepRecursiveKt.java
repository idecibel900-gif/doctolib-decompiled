package kotlin;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    public static final Object invoke(DeepRecursiveFunction deepRecursiveFunction, Object obj) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        return new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), obj).runCallLoop();
    }

    static {
        Result.Companion companion = Result.Companion;
        UNDEFINED_RESULT = Result.m5243constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }
}
