package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    private Continuation continuation;
    private boolean wasPositioned;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1, reason: invalid class name */
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
            return AwaitFirstLayoutModifier.this.waitForFirstLayout(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitForFirstLayout(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Continuation continuation2;
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.wasPositioned) {
                Continuation continuation3 = this.continuation;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = continuation3;
                anonymousClass1.label = 1;
                SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass1));
                this.continuation = safeContinuation;
                Object orThrow = safeContinuation.getOrThrow();
                if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
                }
                if (orThrow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                continuation2 = continuation3;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        continuation2 = (Continuation) anonymousClass1.L$1;
        ResultKt.throwOnFailure(obj);
        if (continuation2 != null) {
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        if (this.wasPositioned) {
            return;
        }
        this.wasPositioned = true;
        Continuation continuation = this.continuation;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
        }
        this.continuation = null;
    }
}
