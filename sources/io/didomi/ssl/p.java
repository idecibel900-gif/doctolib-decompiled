package io.didomi.ssl;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0086Bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00028\u0000H¤@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/p;", "Param", "Type", "", "parameters", "Lio/didomi/sdk/a0;", "b", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "param", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class p<Param, Type> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.didomi.sdk.core.base.BaseUseCase", f = "BaseUseCase.kt", l = {22}, m = "invoke")
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ p<Param, Type> b;
        int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p<? super Param, Type> pVar, Continuation continuation) {
            super(continuation);
            this.b = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= LinearLayoutManager.INVALID_OFFSET;
            return this.b.b(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000 \u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"Param", "Type", "Lkotlinx/coroutines/CoroutineScope;", "Lio/didomi/sdk/a0;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "io.didomi.sdk.core.base.BaseUseCase$invoke$2", f = "BaseUseCase.kt", l = {23}, m = "invokeSuspend")
    static final class b extends SuspendLambda implements Function2 {
        int a;
        final /* synthetic */ p<Param, Type> b;
        final /* synthetic */ Param c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(p<? super Param, Type> pVar, Param param, Continuation continuation) {
            super(2, continuation);
            this.b = pVar;
            this.c = param;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            p<Param, Type> pVar = this.b;
            Param param = this.c;
            this.a = 1;
            Object objA = pVar.a(param, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    public p(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher;
    }

    protected abstract Object a(Param param, Continuation continuation) throws RuntimeException;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Param param, Continuation continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.c;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                aVar.c = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object objWithContext = aVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.c;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher coroutineDispatcher = this.coroutineDispatcher;
                b bVar = new b(this, param, null);
                aVar.c = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, bVar, aVar);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            return (a0) objWithContext;
        } catch (Exception e) {
            return a0.INSTANCE.a((Throwable) e);
        }
    }
}
