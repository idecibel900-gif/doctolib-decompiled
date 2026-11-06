package androidx.compose.foundation.gestures;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class TargetedFlingBehaviorKt {
    private static final Function1 NoOnReport = new Function1() { // from class: androidx.compose.foundation.gestures.TargetedFlingBehaviorKt$NoOnReport$1
        public final void invoke(float f) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).floatValue());
            return Unit.INSTANCE;
        }
    };
}
