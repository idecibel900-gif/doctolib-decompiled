package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH¦@¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\u0016\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "startWork", "()Lcom/google/common/util/concurrent/ListenableFuture;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ForegroundInfo;", "getForegroundInfo", "getForegroundInfoAsync", "", "onStopped", "()V", "Landroidx/work/WorkerParameters;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "DeprecatedDispatcher", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final WorkerParameters params;

    public abstract Object doWork(Continuation continuation);

    public Object getForegroundInfo(Continuation continuation) {
        return getForegroundInfo$suspendImpl(this, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.coroutineContext = DeprecatedDispatcher.INSTANCE;
    }

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        CoroutineContext workerContext;
        if (!Intrinsics.areEqual(getCoroutineContext(), DeprecatedDispatcher.INSTANCE)) {
            workerContext = getCoroutineContext();
        } else {
            workerContext = this.params.getWorkerContext();
        }
        Intrinsics.checkNotNull(workerContext);
        return ListenableFutureKt.launchFuture$default(workerContext.plus(JobKt__JobKt.Job$default(null, 1, null)), null, new C02861(null), 2, null);
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    static final class C02861 extends SuspendLambda implements Function2 {
        int label;

        C02861(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new C02861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            this.label = 1;
            Object objDoWork = coroutineWorker.doWork(this);
            return objDoWork == coroutine_suspended ? coroutine_suspended : objDoWork;
        }
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            this.label = 1;
            Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
            return foregroundInfo == coroutine_suspended ? coroutine_suspended : foregroundInfo;
        }
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        return ListenableFutureKt.launchFuture$default(getCoroutineContext().plus(JobKt__JobKt.Job$default(null, 1, null)), null, new AnonymousClass1(null), 2, null);
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
    }

    private static final class DeprecatedDispatcher extends CoroutineDispatcher {
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();
        private static final CoroutineDispatcher dispatcher = Dispatchers.getDefault();

        private DeprecatedDispatcher() {
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(CoroutineContext context, Runnable block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            dispatcher.dispatch(context, block);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public boolean isDispatchNeeded(CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return dispatcher.isDispatchNeeded(context);
        }
    }
}
