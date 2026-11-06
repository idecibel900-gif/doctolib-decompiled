package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes.dex */
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex = MutexKt.Mutex(false);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1, reason: invalid class name and case insensitive filesystem */
    static final class C01931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01931(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int mo225roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo225roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float mo226toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo226toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo227toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo227toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo228toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo228toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long mo229toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo229toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public float mo230toPxR2X_6o(long j) {
        return this.$$delegate_0.mo230toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public float mo231toPx0680j_4(float f) {
        return this.$$delegate_0.mo231toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long mo232toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo232toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public long mo233toSp0xMU5do(float f) {
        return this.$$delegate_0.mo233toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo234toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo234toSpkPz2Gy4(f);
    }

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reset(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        PressGestureScopeImpl pressGestureScopeImpl;
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
            Mutex mutex = this.mutex;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, anonymousClass1, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pressGestureScopeImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pressGestureScopeImpl = (PressGestureScopeImpl) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        pressGestureScopeImpl.isReleased = false;
        pressGestureScopeImpl.isCanceled = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object tryAwaitRelease(Continuation continuation) {
        C01931 c01931;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof C01931) {
            c01931 = (C01931) continuation;
            int i = c01931.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c01931.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c01931 = new C01931(continuation);
            }
        } else {
            c01931 = new C01931(continuation);
        }
        Object obj = c01931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01931.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isReleased || this.isCanceled) {
                pressGestureScopeImpl = this;
            } else {
                Mutex mutex = this.mutex;
                c01931.L$0 = this;
                c01931.label = 1;
                if (Mutex.DefaultImpls.lock$default(mutex, null, c01931, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pressGestureScopeImpl = this;
            }
            return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pressGestureScopeImpl = (PressGestureScopeImpl) c01931.L$0;
        ResultKt.throwOnFailure(obj);
        Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl.mutex, null, 1, null);
        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
    }
}
