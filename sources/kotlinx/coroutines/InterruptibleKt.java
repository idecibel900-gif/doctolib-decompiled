package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InterruptibleKt {
    public static /* synthetic */ Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(coroutineContext, function0, continuation);
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.InterruptibleKt$runInterruptible$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return InterruptibleKt.runInterruptibleInExpectedContext(((CoroutineScope) this.L$0).getCoroutineContext(), this.$block);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final Object runInterruptible(CoroutineContext coroutineContext, Function0 function0, Continuation continuation) {
        return BuildersKt.withContext(coroutineContext, new AnonymousClass2(function0, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0 function0) throws Throwable {
        try {
            ThreadState threadState = new ThreadState();
            threadState.setup(JobKt.getJob(coroutineContext));
            try {
                return function0.invoke();
            } finally {
                threadState.clearInterrupt();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
