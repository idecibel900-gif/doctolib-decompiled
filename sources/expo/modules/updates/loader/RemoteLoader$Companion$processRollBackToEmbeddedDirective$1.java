package expo.modules.updates.loader;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteLoader.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(RemoteLoader.Companion companion, Continuation continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.processRollBackToEmbeddedDirective(null, null, null, null, null, null, null, null, this);
    }
}
