package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class FocusRequester {
    private final MutableVector focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16], 0);
    public static final Companion Companion = new Companion(null);
    private static final FocusRequester Default = new FocusRequester();
    private static final FocusRequester Cancel = new FocusRequester();

    public final MutableVector getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean focus$ui_release() {
        return findFocusTargetNode$ui_release(new Function1() { // from class: androidx.compose.ui.focus.FocusRequester$focus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode));
            }
        });
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }
    }

    public final boolean findFocusTargetNode$ui_release(Function1 function1) {
        boolean zM1202findChildCorrespondingToFocusEnterOMvw8;
        Companion companion = Companion;
        if (this == companion.getDefault()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        if (this == companion.getCancel()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        }
        MutableVector mutableVector = this.focusRequesterNodes;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        boolean z = false;
        do {
            FocusRequesterModifierNode focusRequesterModifierNode = (FocusRequesterModifierNode) content[i];
            int iM1990constructorimpl = NodeKind.m1990constructorimpl(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            if (!focusRequesterModifierNode.getNode().isAttached()) {
                throw new IllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = focusRequesterModifierNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                if ((nodePop.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop);
                } else {
                    while (nodePop != null) {
                        if ((nodePop.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                            MutableVector mutableVector3 = null;
                            while (nodePop != null) {
                                if (!(nodePop instanceof FocusTargetNode)) {
                                    if (((nodePop.getKindSet$ui_release() & iM1990constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodePop = delegate$ui_release;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop != null) {
                                                        mutableVector3.add(nodePop);
                                                        nodePop = null;
                                                    }
                                                    mutableVector3.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                } else {
                                    FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                                    if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                        zM1202findChildCorrespondingToFocusEnterOMvw8 = ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
                                    } else {
                                        zM1202findChildCorrespondingToFocusEnterOMvw8 = TwoDimensionalFocusSearchKt.m1202findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.Companion.m1160getEnterdhqQ8s(), function1);
                                    }
                                    if (zM1202findChildCorrespondingToFocusEnterOMvw8) {
                                        z = true;
                                        break;
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector3);
                            }
                            break;
                        }
                        nodePop = nodePop.getChild$ui_release();
                    }
                }
            }
            i++;
        } while (i < size);
        return z;
    }
}
