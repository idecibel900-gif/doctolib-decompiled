package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    private NestedScrollConnection connection;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (isAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope nestedCoroutineScope;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if (parentNestedScrollNode$ui_release != null && (nestedCoroutineScope = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) != null) {
            return nestedCoroutineScope;
        }
        CoroutineScope scope$ui_release = this.resolvedDispatcher.getScope$ui_release();
        if (scope$ui_release != null) {
            return scope$ui_release;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo433onPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo433onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo433onPreScrollOzD1aCk(j, i) : Offset.Companion.m1235getZeroF1C5BW0();
        return Offset.m1228plusMKHz9U(jMo433onPreScrollOzD1aCk, this.connection.mo433onPreScrollOzD1aCk(Offset.m1227minusMKHz9U(j, jMo433onPreScrollOzD1aCk), i));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo238onPostScrollDzOQY0M(long j, long j2, int i) {
        long jM1235getZeroF1C5BW0;
        long jMo238onPostScrollDzOQY0M = this.connection.mo238onPostScrollDzOQY0M(j, j2, i);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            jM1235getZeroF1C5BW0 = parentConnection.mo238onPostScrollDzOQY0M(Offset.m1228plusMKHz9U(j, jMo238onPostScrollDzOQY0M), Offset.m1227minusMKHz9U(j2, jMo238onPostScrollDzOQY0M), i);
        } else {
            jM1235getZeroF1C5BW0 = Offset.Companion.m1235getZeroF1C5BW0();
        }
        return Offset.m1228plusMKHz9U(jMo238onPostScrollDzOQY0M, jM1235getZeroF1C5BW0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        if (r11 == r1) goto L27;
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo1731onPreFlingQWom1Mo(long r9, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            long r9 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            long r9 = r0.J$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L57
        L40:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r8.getParentConnection()
            if (r11 == 0) goto L61
            r0.L$0 = r8
            r0.J$0 = r9
            r0.label = r4
            java.lang.Object r11 = r11.mo1731onPreFlingQWom1Mo(r9, r0)
            if (r11 != r1) goto L56
            goto L7c
        L56:
            r2 = r8
        L57:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r4 = r11.m2655unboximpl()
        L5d:
            r6 = r4
            r4 = r9
            r9 = r6
            goto L69
        L61:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r11.m2656getZero9UxMQ8M()
            r2 = r8
            goto L5d
        L69:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r2.connection
            long r4 = androidx.compose.ui.unit.Velocity.m2651minusAH228Gc(r4, r9)
            r2 = 0
            r0.L$0 = r2
            r0.J$0 = r9
            r0.label = r3
            java.lang.Object r11 = r11.mo1731onPreFlingQWom1Mo(r4, r0)
            if (r11 != r1) goto L7d
        L7c:
            return r1
        L7d:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r0 = r11.m2655unboximpl()
            long r9 = androidx.compose.ui.unit.Velocity.m2652plusAH228Gc(r9, r0)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m2642boximpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo1731onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo237onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        NestedScrollNode nestedScrollNode;
        long j3;
        long j4;
        long jM2655unboximpl;
        long jM2656getZero9UxMQ8M;
        long j5;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                nestedScrollNode$onPostFling$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        }
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$2 = nestedScrollNode$onPostFling$1;
        Object objMo237onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollNode$onPostFling$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$2.L$0 = this;
            nestedScrollNode$onPostFling$2.J$0 = j;
            nestedScrollNode$onPostFling$2.J$1 = j2;
            nestedScrollNode$onPostFling$2.label = 1;
            objMo237onPostFlingRZ2iAVY = nestedScrollConnection.mo237onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$2);
            if (objMo237onPostFlingRZ2iAVY != coroutine_suspended) {
                nestedScrollNode = this;
                j3 = j;
                j4 = j2;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            j4 = nestedScrollNode$onPostFling$2.J$1;
            j3 = nestedScrollNode$onPostFling$2.J$0;
            nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$2.L$0;
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j5 = nestedScrollNode$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo237onPostFlingRZ2iAVY);
        }
        jM2656getZero9UxMQ8M = ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl();
        jM2655unboximpl = j5;
        return Velocity.m2642boximpl(Velocity.m2652plusAH228Gc(jM2655unboximpl, jM2656getZero9UxMQ8M));
        jM2655unboximpl = ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl();
        NestedScrollConnection parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection != null) {
            long jM2652plusAH228Gc = Velocity.m2652plusAH228Gc(j3, jM2655unboximpl);
            long jM2651minusAH228Gc = Velocity.m2651minusAH228Gc(j4, jM2655unboximpl);
            nestedScrollNode$onPostFling$2.L$0 = null;
            nestedScrollNode$onPostFling$2.J$0 = jM2655unboximpl;
            nestedScrollNode$onPostFling$2.label = 2;
            objMo237onPostFlingRZ2iAVY = parentConnection.mo237onPostFlingRZ2iAVY(jM2652plusAH228Gc, jM2651minusAH228Gc, nestedScrollNode$onPostFling$2);
            if (objMo237onPostFlingRZ2iAVY != coroutine_suspended) {
                j5 = jM2655unboximpl;
                jM2656getZero9UxMQ8M = ((Velocity) objMo237onPostFlingRZ2iAVY).m2655unboximpl();
                jM2655unboximpl = j5;
            }
            return coroutine_suspended;
        }
        jM2656getZero9UxMQ8M = Velocity.Companion.m2656getZero9UxMQ8M();
        return Velocity.m2642boximpl(Velocity.m2652plusAH228Gc(jM2655unboximpl, jM2656getZero9UxMQ8M));
    }

    private final void updateDispatcher(NestedScrollDispatcher nestedScrollDispatcher) {
        resetDispatcherFields();
        if (nestedScrollDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(nestedScrollDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = nestedScrollDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode$ui_release() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        updateDispatcher(nestedScrollDispatcher);
    }
}
