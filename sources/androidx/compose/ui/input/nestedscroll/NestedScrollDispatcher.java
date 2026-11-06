package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollDispatcher {
    private Function0 calculateNestedScrollScope = new Function0() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return this.this$0.getScope$ui_release();
        }
    };
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    public final NestedScrollNode getNestedScrollNode$ui_release() {
        return this.nestedScrollNode;
    }

    public final void setNestedScrollNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.nestedScrollNode = nestedScrollNode;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0 function0) {
        this.calculateNestedScrollScope = function0;
    }

    public final CoroutineScope getScope$ui_release() {
        return this.scope;
    }

    public final void setScope$ui_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = (CoroutineScope) this.calculateNestedScrollScope.invoke();
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollConnection getParent$ui_release() {
        NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        if (nestedScrollNode != null) {
            return nestedScrollNode.getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m1735dispatchPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo433onPreScrollOzD1aCk(j, i) : Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m1733dispatchPostScrollDzOQY0M(long j, long j2, int i) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo238onPostScrollDzOQY0M(j, j2, i) : Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public final Object m1734dispatchPreFlingQWom1Mo(long j, Continuation continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jM2656getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            int i = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        }
        Object objMo1731onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo1731onPreFlingQWom1Mo);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objMo1731onPreFlingQWom1Mo = parent$ui_release.mo1731onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                if (objMo1731onPreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jM2656getZero9UxMQ8M = Velocity.Companion.m2656getZero9UxMQ8M();
            }
            return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objMo1731onPreFlingQWom1Mo);
        jM2656getZero9UxMQ8M = ((Velocity) objMo1731onPreFlingQWom1Mo).m2655unboximpl();
        return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    public final Object m1732dispatchPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long jM2656getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            int i = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
            }
        } else {
            nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$2 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objMo237onPostFlingRZ2iAVY = nestedScrollDispatcher$dispatchPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollDispatcher$dispatchPostFling$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                nestedScrollDispatcher$dispatchPostFling$2.label = 1;
                objMo237onPostFlingRZ2iAVY = parent$ui_release.mo237onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$2);
                if (objMo237onPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jM2656getZero9UxMQ8M = Velocity.Companion.m2656getZero9UxMQ8M();
            }
            return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
        jM2656getZero9UxMQ8M = ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl();
        return Velocity.m2642boximpl(jM2656getZero9UxMQ8M);
    }
}
