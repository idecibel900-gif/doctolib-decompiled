package androidx.compose.ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class FocusTransactionManager {
    private boolean ongoingTransaction;
    private final MutableScatterMap states = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector cancellationListener = new MutableVector(new Function0[16], 0);

    public final FocusStateImpl getUncommittedFocusState(FocusTargetNode focusTargetNode) {
        return (FocusStateImpl) this.states.get(focusTargetNode);
    }

    public final void setUncommittedFocusState(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        MutableScatterMap mutableScatterMap = this.states;
        if (focusStateImpl != null) {
            mutableScatterMap.set(focusTargetNode, focusStateImpl);
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x0044 A[LOOP:0: B:5:0x000d->B:15:0x0044, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[EDGE_INSN: B:19:0x0047->B:16:0x0047 BREAK  A[LOOP:0: B:5:0x000d->B:15:0x0044], SYNTHETIC] */
    public final void commitTransaction() {
        MutableScatterMap mutableScatterMap = this.states;
        Object[] objArr = mutableScatterMap.keys;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            ((FocusTargetNode) objArr[(i << 3) + i3]).commitFocusState$ui_release();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        this.states.clear();
        this.ongoingTransaction = false;
        this.cancellationListener.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTransaction() {
        this.states.clear();
        int i = 0;
        this.ongoingTransaction = false;
        MutableVector mutableVector = this.cancellationListener;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                ((Function0) content[i]).invoke();
                i++;
            } while (i < size);
        }
        this.cancellationListener.clear();
    }
}
