package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostState {
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            snackbarDuration = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        }
        return snackbarHostState.showSnackbar(str, str3, z2, snackbarDuration, continuation);
    }

    public final Object showSnackbar(String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation continuation) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z, snackbarDuration), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object showSnackbar(SnackbarVisuals snackbarVisuals, Continuation continuation) {
        AnonymousClass2 anonymousClass2;
        Mutex mutex;
        SnackbarHostState snackbarHostState;
        SnackbarVisuals snackbarVisuals2;
        Throwable th;
        SnackbarHostState snackbarHostState2;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass2.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.mutex;
                    anonymousClass2.L$0 = this;
                    anonymousClass2.L$1 = snackbarVisuals;
                    anonymousClass2.L$2 = mutex;
                    anonymousClass2.label = 1;
                    if (mutex.lock(null, anonymousClass2) != coroutine_suspended) {
                        snackbarHostState = this;
                        snackbarVisuals2 = snackbarVisuals;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) anonymousClass2.L$2;
                    snackbarHostState2 = (SnackbarHostState) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        snackbarHostState2.setCurrentSnackbarData(null);
                        mutex2.unlock(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        snackbarHostState2.setCurrentSnackbarData(null);
                        throw th;
                    }
                }
                Mutex mutex3 = (Mutex) anonymousClass2.L$2;
                SnackbarVisuals snackbarVisuals3 = (SnackbarVisuals) anonymousClass2.L$1;
                snackbarHostState = (SnackbarHostState) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                snackbarVisuals2 = snackbarVisuals3;
                anonymousClass2.L$0 = snackbarHostState;
                anonymousClass2.L$1 = snackbarVisuals2;
                anonymousClass2.L$2 = mutex;
                anonymousClass2.L$3 = anonymousClass2;
                anonymousClass2.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass2), 1);
                cancellableContinuationImpl.initCancellability();
                snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(snackbarVisuals2, cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
                }
                if (result != coroutine_suspended) {
                    Mutex mutex4 = mutex;
                    obj = result;
                    mutex2 = mutex4;
                    snackbarHostState2 = snackbarHostState;
                    snackbarHostState2.setCurrentSnackbarData(null);
                    mutex2.unlock(null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                snackbarHostState2 = snackbarHostState;
                snackbarHostState2.setCurrentSnackbarData(null);
                throw th;
            }
        } catch (Throwable th4) {
            snackbarVisuals.unlock(null);
            throw th4;
        }
    }

    private static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String str, String str2, boolean z, SnackbarDuration snackbarDuration) {
            this.message = str;
            this.actionLabel = str2;
            this.withDismissAction = z;
            this.duration = snackbarDuration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarVisualsImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            return Intrinsics.areEqual(getMessage(), snackbarVisualsImpl.getMessage()) && Intrinsics.areEqual(getActionLabel(), snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration();
        }

        public int hashCode() {
            int iHashCode = getMessage().hashCode() * 31;
            String actionLabel = getActionLabel();
            return ((((iHashCode + (actionLabel != null ? actionLabel.hashCode() : 0)) * 31) + Boolean.hashCode(getWithDismissAction())) * 31) + getDuration().hashCode();
        }
    }

    private static final class SnackbarDataImpl implements SnackbarData {
        private final CancellableContinuation continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals snackbarVisuals, CancellableContinuation cancellableContinuation) {
            this.visuals = snackbarVisuals;
            this.continuation = cancellableContinuation;
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                CancellableContinuation cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5243constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                CancellableContinuation cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5243constructorimpl(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarDataImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            return Intrinsics.areEqual(getVisuals(), snackbarDataImpl.getVisuals()) && Intrinsics.areEqual(this.continuation, snackbarDataImpl.continuation);
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }
    }
}
