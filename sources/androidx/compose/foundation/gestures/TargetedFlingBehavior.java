package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface TargetedFlingBehavior extends FlingBehavior {
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    default Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return performFling$suspendImpl(this, scrollScope, f, continuation);
    }

    Object performFling(ScrollScope scrollScope, float f, Function1 function1, Continuation continuation);

    static /* synthetic */ Object performFling$suspendImpl(TargetedFlingBehavior targetedFlingBehavior, ScrollScope scrollScope, float f, Continuation continuation) {
        return targetedFlingBehavior.performFling(scrollScope, f, TargetedFlingBehaviorKt.NoOnReport, continuation);
    }
}
