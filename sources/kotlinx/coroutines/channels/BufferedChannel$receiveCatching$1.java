package kotlinx.coroutines.channels;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class BufferedChannel$receiveCatching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        Object objM5445receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m5445receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return objM5445receiveCatchingJP2dKIU$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5445receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m5452boximpl(objM5445receiveCatchingJP2dKIU$suspendImpl);
    }
}
