package kotlin.ranges;

import com.amazon.a.a.o.c.a.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class RangesKt__RangesKt {
    public static ClosedFloatingPointRange rangeTo(float f, float f2) {
        return new ClosedFloatRange(f, f2);
    }

    public static final void checkStepIsPositive(boolean z, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + b.a);
    }
}
