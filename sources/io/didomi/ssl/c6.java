package io.didomi.ssl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "Lkotlin/Function1;", "", "collector", "Lkotlinx/coroutines/Job;", "a", "(Landroidx/fragment/app/Fragment;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "android_release"}, k = 2, mv = {1, 8, 0})
public final class c6 {

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "io.didomi.sdk.utils.extension.FragmentKt$registerStateFlow$1", f = "Fragment.kt", l = {13}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2 {
        int a;
        final /* synthetic */ StateFlow b;
        final /* synthetic */ Function1 c;

        /* JADX INFO: renamed from: io.didomi.sdk.c6$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C0136a<T> implements FlowCollector {
            final /* synthetic */ Function1 a;

            C0136a(Function1 function1) {
                this.a = function1;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation continuation) {
                this.a.invoke(t);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(StateFlow stateFlow, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.b = stateFlow;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow stateFlow = this.b;
                C0136a c0136a = new C0136a(this.c);
                this.a = 1;
                if (stateFlow.collect(c0136a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public static final <T> Job a(Fragment fragment, StateFlow stateFlow, Function1 collector) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(stateFlow, "stateFlow");
        Intrinsics.checkNotNullParameter(collector, "collector");
        return LifecycleOwnerKt.getLifecycleScope(fragment).launchWhenResumed(new a(stateFlow, collector, null));
    }
}
