package kotlinx.coroutines.flow;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class StartedLazily$command$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StartedLazily.AnonymousClass1.C01601 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartedLazily$command$1$1$emit$1(StartedLazily.AnonymousClass1.C01601 c01601, Continuation continuation) {
        super(continuation);
        this.this$0 = c01601;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.emit(0, this);
    }
}
