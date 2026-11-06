package kotlinx.coroutines.flow.internal;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineKt.AnonymousClass2.AnonymousClass1.C01611 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2$1$1$emit$1(CombineKt.AnonymousClass2.AnonymousClass1.C01611 c01611, Continuation continuation) {
        super(continuation);
        this.this$0 = c01611;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.emit(null, this);
    }
}
