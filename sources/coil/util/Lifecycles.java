package coil.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: renamed from: coil.util.-Lifecycles, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Lifecycles {

    /* JADX INFO: renamed from: coil.util.-Lifecycles$awaitStarted$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return Lifecycles.awaitStarted(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0092  */
    /* JADX WARN: Code duplicated, block: B:39:0x009e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitStarted(Lifecycle lifecycle, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Lifecycle lifecycle2;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        LifecycleObserver lifecycleObserver;
        LifecycleObserver lifecycleObserver2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$1;
            lifecycle2 = (Lifecycle) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
                if (lifecycleObserver2 != null) {
                    lifecycle2.removeObserver(lifecycleObserver2);
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
                if (lifecycleObserver != null) {
                    lifecycle2.removeObserver(lifecycleObserver);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return Unit.INSTANCE;
        }
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        try {
            anonymousClass1.L$0 = lifecycle;
            anonymousClass1.L$1 = ref$ObjectRef2;
            anonymousClass1.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass1), 1);
            cancellableContinuationImpl.initCancellability();
            DefaultLifecycleObserver defaultLifecycleObserver = new DefaultLifecycleObserver() { // from class: coil.util.-Lifecycles$awaitStarted$2$1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onStart(LifecycleOwner lifecycleOwner) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                }
            };
            ref$ObjectRef2.element = defaultLifecycleObserver;
            Intrinsics.checkNotNull(defaultLifecycleObserver);
            lifecycle.addObserver(defaultLifecycleObserver);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            lifecycle2 = lifecycle;
            ref$ObjectRef = ref$ObjectRef2;
            lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
            if (lifecycleObserver2 != null) {
                lifecycle2.removeObserver(lifecycleObserver2);
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            lifecycle2 = lifecycle;
            ref$ObjectRef = ref$ObjectRef2;
            th = th3;
            lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
            if (lifecycleObserver != null) {
                lifecycle2.removeObserver(lifecycleObserver);
            }
            throw th;
        }
    }
}
