package coil;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class RealImageLoader$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Companion companion, RealImageLoader realImageLoader) {
        super(companion);
        this.this$0 = realImageLoader;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        this.this$0.getLogger();
    }
}
