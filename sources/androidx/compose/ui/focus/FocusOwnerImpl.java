package androidx.compose.ui.focus;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    private final Function0 onClearFocusForOwner;
    private final Function0 onFocusRectInterop;
    private final Function0 onLayoutDirection;
    private final Function1 onMoveFocusInterop;
    private final Function2 onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = FocusPropertiesKt.focusProperties(Modifier.Companion, new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusProperties) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(FocusProperties focusProperties) {
            focusProperties.setCanFocus(false);
        }
    }).then(new ModifierNodeElement() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode$ui_release();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        public int hashCode() {
            return this.this$0.getRootFocusNode$ui_release().hashCode();
        }
    });

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(Function1 function1, Function2 function2, Function1 function3, Function0 function0, Function0 function4, Function0 function5) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function3;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function4;
        this.onLayoutDirection = function5;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) | NodeKind.m1990constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                    if ((NodeKind.m1990constructorimpl(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return node2;
                    }
                    node2 = child$ui_release;
                }
            }
        }
        return node2;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: requestFocusForOwner-7o62pno */
    public boolean mo1175requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect rect) {
        return ((Boolean) this.onRequestFocusForOwner.invoke(focusDirection, rect)).booleanValue();
    }

    /* JADX INFO: renamed from: takeFocus-aToIllA, reason: not valid java name */
    public boolean m1177takeFocusaToIllA(final int i, Rect rect) {
        Boolean boolMo1174focusSearchULY8qGw = mo1174focusSearchULY8qGw(i, rect, new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean boolM1190requestFocusMxy_nc0 = FocusTransactionsKt.m1190requestFocusMxy_nc0(focusTargetNode, i);
                return Boolean.valueOf(boolM1190requestFocusMxy_nc0 != null ? boolM1190requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo1174focusSearchULY8qGw != null) {
            return boolMo1174focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        if (!focusTransactionManager.ongoingTransaction) {
            try {
                focusTransactionManager.beginTransaction();
                FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
                return;
            } finally {
                focusTransactionManager.commitTransaction();
            }
        }
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        mo1171clearFocusI7lrPNg(z, true, true, FocusDirection.Companion.m1161getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: clearFocus-I7lrPNg */
    public boolean mo1171clearFocusI7lrPNg(boolean z, boolean z2, boolean z3, int i) {
        boolean zClearFocus;
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1178invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1178invoke();
                return Unit.INSTANCE;
            }
        };
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                focusTransactionManager.cancellationListener.add(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!z) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m1186performCustomClearFocusMxy_nc0(this.rootFocusNode, i).ordinal()];
                zClearFocus = (i2 == 1 || i2 == 2 || i2 == 3) ? false : FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2);
            }
            focusTransactionManager.commitTransaction();
            if (zClearFocus && z3) {
                this.onClearFocusForOwner.invoke();
            }
            return zClearFocus;
        } catch (Throwable th) {
            focusTransactionManager.commitTransaction();
            throw th;
        }
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo1169moveFocus3ESFkO8(final int i) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = Boolean.FALSE;
        Boolean boolMo1174focusSearchULY8qGw = mo1174focusSearchULY8qGw(i, (Rect) this.onFocusRectInterop.invoke(), new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                ref$ObjectRef.element = FocusTransactionsKt.m1190requestFocusMxy_nc0(focusTargetNode, i);
                Boolean bool = (Boolean) ref$ObjectRef.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        if (boolMo1174focusSearchULY8qGw == null || ref$ObjectRef.element == null) {
            return false;
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolMo1174focusSearchULY8qGw, bool) && Intrinsics.areEqual(ref$ObjectRef.element, bool)) {
            return true;
        }
        if (FocusOwnerImplKt.m1180is1dFocusSearch3ESFkO8(i)) {
            return mo1171clearFocusI7lrPNg(false, true, false, i) && m1177takeFocusaToIllA(i, null);
        }
        return ((Boolean) this.onMoveFocusInterop.invoke(FocusDirection.m1152boximpl(i))).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: focusSearch-ULY8qGw */
    public Boolean mo1174focusSearchULY8qGw(int i, Rect rect, final Function1 function1) {
        final FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusRequester focusRequesterM1193customFocusSearchOMvw8 = FocusTraversalKt.m1193customFocusSearchOMvw8(focusTargetNodeFindActiveFocusNode, i, (LayoutDirection) this.onLayoutDirection.invoke());
            FocusRequester.Companion companion = FocusRequester.Companion;
            if (Intrinsics.areEqual(focusRequesterM1193customFocusSearchOMvw8, companion.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual(focusRequesterM1193customFocusSearchOMvw8, companion.getDefault())) {
                return Boolean.valueOf(focusRequesterM1193customFocusSearchOMvw8.findFocusTargetNode$ui_release(function1));
            }
        } else {
            focusTargetNodeFindActiveFocusNode = null;
        }
        return FocusTraversalKt.m1194focusSearch0X8WOeE(this.rootFocusNode, i, (LayoutDirection) this.onLayoutDirection.invoke(), rect, new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(focusTargetNode, focusTargetNodeFindActiveFocusNode)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode$ui_release())) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    zBooleanValue = ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:103:0x016c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0171  */
    /* JADX WARN: Code duplicated, block: B:228:0x0313  */
    /* JADX WARN: Code duplicated, block: B:304:0x0168 A[EDGE_INSN: B:304:0x0168->B:101:0x0168 BREAK  A[LOOP:14: B:62:0x00eb->B:309:0x00eb, LOOP_LABEL: LOOP:14: B:62:0x00eb->B:309:0x00eb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fc A[ADDED_TO_REGION, LOOP:15: B:65:0x00fc->B:93:0x014f, LOOP_START, PHI: r10
      0x00fc: PHI (r10v9 androidx.compose.ui.Modifier$Node) = (r10v4 androidx.compose.ui.Modifier$Node), (r10v10 androidx.compose.ui.Modifier$Node) binds: [B:64:0x00fa, B:93:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0105  */
    /* JADX WARN: Code duplicated, block: B:70:0x0109  */
    /* JADX WARN: Code duplicated, block: B:73:0x010e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r9v10 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo1173dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0 function0) {
        FocusTargetNode focusTargetNode;
        int iM1990constructorimpl;
        Modifier.Node parent$ui_release;
        LayoutNode layoutNodeRequireLayoutNode;
        ?? Pop;
        KeyInputModifierNode keyInputModifierNode;
        Modifier.Node node;
        NodeChain nodes$ui_release;
        ?? mutableVector;
        ?? Pop2;
        NodeChain nodes$ui_release2;
        NodeChain nodes$ui_release3;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching key event while focus system is invalidated.");
        }
        if (!m1176validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode == null || (node = lastLocalKeyInputNode(focusTargetNodeFindActiveFocusNode)) == null) {
            if (focusTargetNodeFindActiveFocusNode != null) {
                int iM1990constructorimpl2 = NodeKind.m1990constructorimpl(8192);
                if (!focusTargetNodeFindActiveFocusNode.getNode().isAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node2 = focusTargetNodeFindActiveFocusNode.getNode();
                LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                loop10: while (true) {
                    if (layoutNodeRequireLayoutNode2 == null) {
                        Pop2 = 0;
                        break;
                    }
                    if ((layoutNodeRequireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                        while (node2 != null) {
                            if ((node2.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                                ?? mutableVector2 = 0;
                                Pop2 = node2;
                                while (Pop2 != 0) {
                                    if (Pop2 instanceof KeyInputModifierNode) {
                                        break loop10;
                                    }
                                    if ((Pop2.getKindSet$ui_release() & iM1990constructorimpl2) != 0 && (Pop2 instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) Pop2).getDelegate$ui_release();
                                        int i = 0;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    Pop2 = Pop2;
                                                    mutableVector2 = mutableVector2;
                                                    mutableVector2 = mutableVector2;
                                                    Pop2 = delegate$ui_release;
                                                } else {
                                                    if (mutableVector2 == 0) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (Pop2 != 0) {
                                                        mutableVector2.add(Pop2);
                                                        Pop2 = 0;
                                                    }
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            } else {
                                                Pop2 = Pop2;
                                                mutableVector2 = mutableVector2;
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            Pop2 = Pop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                        if (i == 1) {
                                            Pop2 = Pop2;
                                            mutableVector2 = mutableVector2;
                                        } else {
                                            Pop2 = Pop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                    }
                                    Pop2 = DelegatableNodeKt.pop(mutableVector2);
                                }
                            }
                            node2 = node2.getParent$ui_release();
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                    node2 = (layoutNodeRequireLayoutNode2 == null || (nodes$ui_release2 = layoutNodeRequireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                }
                KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) Pop2;
                if (keyInputModifierNode2 != null) {
                    node = keyInputModifierNode2.getNode();
                } else {
                    focusTargetNode = this.rootFocusNode;
                    iM1990constructorimpl = NodeKind.m1990constructorimpl(8192);
                    if (focusTargetNode.getNode().isAttached()) {
                        throw new IllegalStateException("visitAncestors called on an unattached node");
                    }
                    parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
                    layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                    loop14: while (true) {
                        if (layoutNodeRequireLayoutNode != null) {
                            Pop = 0;
                            break;
                        }
                        if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            while (parent$ui_release != null) {
                                if ((parent$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                    mutableVector = 0;
                                    Pop = parent$ui_release;
                                    while (Pop != 0) {
                                        if (Pop instanceof KeyInputModifierNode) {
                                            break loop14;
                                        }
                                        if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) == 0 && (Pop instanceof DelegatingNode)) {
                                            Modifier.Node delegate$ui_release2 = ((DelegatingNode) Pop).getDelegate$ui_release();
                                            int i2 = 0;
                                            while (delegate$ui_release2 != null) {
                                                if ((delegate$ui_release2.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        Pop = Pop;
                                                        mutableVector = mutableVector;
                                                        mutableVector = mutableVector;
                                                        Pop = delegate$ui_release2;
                                                    } else {
                                                        if (mutableVector == 0) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (Pop != 0) {
                                                            mutableVector.add(Pop);
                                                            Pop = 0;
                                                        }
                                                        mutableVector.add(delegate$ui_release2);
                                                    }
                                                } else {
                                                    Pop = Pop;
                                                    mutableVector = mutableVector;
                                                }
                                                delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                            }
                                            if (i2 == 1) {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                            } else {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                            }
                                        }
                                        Pop = DelegatableNodeKt.pop(mutableVector);
                                    }
                                }
                                parent$ui_release = parent$ui_release.getParent$ui_release();
                            }
                        }
                        layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                        parent$ui_release = (layoutNodeRequireLayoutNode != null || (nodes$ui_release = layoutNodeRequireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                    }
                    keyInputModifierNode = (KeyInputModifierNode) Pop;
                    if (keyInputModifierNode != null) {
                        node = keyInputModifierNode.getNode();
                    } else {
                        node = null;
                    }
                }
            } else {
                focusTargetNode = this.rootFocusNode;
                iM1990constructorimpl = NodeKind.m1990constructorimpl(8192);
                if (focusTargetNode.getNode().isAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
                layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                loop14: while (true) {
                    if (layoutNodeRequireLayoutNode != null) {
                        Pop = 0;
                        break;
                    }
                    if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                mutableVector = 0;
                                Pop = parent$ui_release;
                                while (Pop != 0) {
                                    if (Pop instanceof KeyInputModifierNode) {
                                        break loop14;
                                        break loop14;
                                    }
                                    if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) == 0) {
                                    }
                                    Pop = DelegatableNodeKt.pop(mutableVector);
                                }
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                    if (layoutNodeRequireLayoutNode != null) {
                    }
                }
                keyInputModifierNode = (KeyInputModifierNode) Pop;
                if (keyInputModifierNode != null) {
                    node = keyInputModifierNode.getNode();
                } else {
                    node = null;
                }
            }
        }
        if (node != null) {
            int iM1990constructorimpl3 = NodeKind.m1990constructorimpl(8192);
            if (!node.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release2 = node.getNode().getParent$ui_release();
            LayoutNode layoutNodeRequireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode3 != null) {
                if ((layoutNodeRequireLayoutNode3.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl3) != 0) {
                    while (parent$ui_release2 != null) {
                        if ((parent$ui_release2.getKindSet$ui_release() & iM1990constructorimpl3) != 0) {
                            Modifier.Node nodePop = parent$ui_release2;
                            MutableVector mutableVector3 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof KeyInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet$ui_release() & iM1990constructorimpl3) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                                        if ((delegate$ui_release3.getKindSet$ui_release() & iM1990constructorimpl3) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                nodePop = delegate$ui_release3;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector3.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector3.add(delegate$ui_release3);
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector3);
                            }
                        }
                        parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                    }
                }
                layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui_release();
                parent$ui_release2 = (layoutNodeRequireLayoutNode3 == null || (nodes$ui_release3 = layoutNodeRequireLayoutNode3.getNodes$ui_release()) == null) ? null : nodes$ui_release3.getTail$ui_release();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        if (((KeyInputModifierNode) arrayList.get(size)).mo104onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i4 < 0) {
                            break;
                        }
                        size = i4;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            ?? node3 = node.getNode();
            ?? mutableVector4 = 0;
            while (node3 != 0) {
                if (node3 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node3).mo104onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet$ui_release() & iM1990constructorimpl3) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release4 = ((DelegatingNode) node3).getDelegate$ui_release();
                    int i5 = 0;
                    while (delegate$ui_release4 != null) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & iM1990constructorimpl3) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = node3;
                                mutableVector4 = mutableVector4;
                                mutableVector4 = mutableVector4;
                                node3 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == 0) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.add(node3);
                                    node3 = 0;
                                }
                                mutableVector4.add(delegate$ui_release4);
                            }
                        } else {
                            node3 = node3;
                            mutableVector4 = mutableVector4;
                        }
                        delegate$ui_release4 = delegate$ui_release4.getChild$ui_release();
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                    if (i5 == 1) {
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    } else {
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (((Boolean) function0.invoke()).booleanValue()) {
                return true;
            }
            ?? node4 = node.getNode();
            ?? mutableVector5 = 0;
            while (node4 != 0) {
                if (node4 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node4).mo102onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui_release() & iM1990constructorimpl3) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release5 = ((DelegatingNode) node4).getDelegate$ui_release();
                    int i6 = 0;
                    while (delegate$ui_release5 != null) {
                        if ((delegate$ui_release5.getKindSet$ui_release() & iM1990constructorimpl3) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node4 = node4;
                                mutableVector5 = mutableVector5;
                                mutableVector5 = mutableVector5;
                                node4 = delegate$ui_release5;
                            } else {
                                if (mutableVector5 == 0) {
                                    mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    mutableVector5.add(node4);
                                    node4 = 0;
                                }
                                mutableVector5.add(delegate$ui_release5);
                            }
                        } else {
                            node4 = node4;
                            mutableVector5 = mutableVector5;
                        }
                        delegate$ui_release5 = delegate$ui_release5.getChild$ui_release();
                        node4 = node4;
                        mutableVector5 = mutableVector5;
                    }
                    if (i6 == 1) {
                        node4 = node4;
                        mutableVector5 = mutableVector5;
                    } else {
                        node4 = node4;
                        mutableVector5 = mutableVector5;
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector5);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    if (((KeyInputModifierNode) arrayList.get(i7)).mo102onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo1172dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        NodeChain nodes$ui_release;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching intercepted soft keyboard event while focus system is invalidated.");
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(131072);
            if (!focusTargetNodeFindActiveFocusNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeFindActiveFocusNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            Modifier.Node nodePop = node;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if ((nodePop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent$ui_release();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes$ui_release = layoutNodeRequireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(null);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes$ui_release;
        ?? Pop;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.");
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(Http2.INITIAL_MAX_FRAME_SIZE);
            if (!focusTargetNodeFindActiveFocusNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeFindActiveFocusNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            ?? mutableVector = 0;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet$ui_release() & iM1990constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) Pop).getDelegate$ui_release();
                                    int i = 0;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Pop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        } else {
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent$ui_release();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node = (layoutNodeRequireLayoutNode == null || (nodes$ui_release2 = layoutNodeRequireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) Pop;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            int iM1990constructorimpl2 = NodeKind.m1990constructorimpl(Http2.INITIAL_MAX_FRAME_SIZE);
            if (!rotaryInputModifierNode.getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = rotaryInputModifierNode.getNode().getParent$ui_release();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                } else if ((nodePop.getKindSet$ui_release() & iM1990constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate$ui_release2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(delegate$ui_release2);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                parent$ui_release = (layoutNodeRequireLayoutNode2 == null || (nodes$ui_release = layoutNodeRequireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                while (true) {
                    int i3 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                }
            }
            ?? node2 = rotaryInputModifierNode.getNode();
            ?? mutableVector3 = 0;
            while (node2 != 0) {
                if (node2 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node2).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet$ui_release() & iM1990constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release3 = ((DelegatingNode) node2).getDelegate$ui_release();
                    int i4 = 0;
                    while (delegate$ui_release3 != null) {
                        if ((delegate$ui_release3.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                node2 = node2;
                                mutableVector3 = mutableVector3;
                                mutableVector3 = mutableVector3;
                                node2 = delegate$ui_release3;
                            } else {
                                if (mutableVector3 == 0) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    mutableVector3.add(node2);
                                    node2 = 0;
                                }
                                mutableVector3.add(delegate$ui_release3);
                            }
                        } else {
                            node2 = node2;
                            mutableVector3 = mutableVector3;
                        }
                        delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                        node2 = node2;
                        mutableVector3 = mutableVector3;
                    }
                    if (i4 == 1) {
                        node2 = node2;
                        mutableVector3 = mutableVector3;
                    } else {
                        node2 = node2;
                        mutableVector3 = mutableVector3;
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            ?? node3 = rotaryInputModifierNode.getNode();
            ?? mutableVector4 = 0;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet$ui_release() & iM1990constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate$ui_release4 = ((DelegatingNode) node3).getDelegate$ui_release();
                    int i5 = 0;
                    while (delegate$ui_release4 != null) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & iM1990constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = node3;
                                mutableVector4 = mutableVector4;
                                mutableVector4 = mutableVector4;
                                node3 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == 0) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.add(node3);
                                    node3 = 0;
                                }
                                mutableVector4.add(delegate$ui_release4);
                            }
                        } else {
                            node3 = node3;
                            mutableVector4 = mutableVector4;
                        }
                        delegate$ui_release4 = delegate$ui_release4.getChild$ui_release();
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                    if (i5 == 1) {
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    } else {
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((RotaryInputModifierNode) arrayList.get(i6)).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusTargetNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusPropertiesModifierNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m1176validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM1722getKeyZmokQxo = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
        int iM1723getTypeZmokQxo = KeyEvent_androidKt.m1723getTypeZmokQxo(keyEvent);
        KeyEventType.Companion companion = KeyEventType.Companion;
        if (KeyEventType.m1718equalsimpl0(iM1723getTypeZmokQxo, companion.m1719getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM1722getKeyZmokQxo);
        } else if (KeyEventType.m1718equalsimpl0(iM1723getTypeZmokQxo, companion.m1720getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM1722getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM1722getKeyZmokQxo);
            }
        }
        return true;
    }
}
