package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object objM5243constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            objM5243constructorimpl = Result.m5243constructorimpl(StringsKt.toIntOrNull(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
            objM5243constructorimpl = null;
        }
        Integer num = (Integer) objM5243constructorimpl;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
