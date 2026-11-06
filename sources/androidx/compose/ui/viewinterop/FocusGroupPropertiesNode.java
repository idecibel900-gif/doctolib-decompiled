package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {
    private View focusedChild;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new AnonymousClass1(this));
        focusProperties.setExit(new AnonymousClass2(this));
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass1(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onEnter", "onEnter-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m2665invoke3ESFkO8(((FocusDirection) obj).m1158unboximpl());
        }

        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m2665invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m2663onEnter3ESFkO8(i);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass2(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onExit", "onExit-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m2666invoke3ESFkO8(((FocusDirection) obj).m1158unboximpl());
        }

        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m2666invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m2664onExit3ESFkO8(i);
        }
    }

    /* JADX INFO: renamed from: onEnter-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2663onEnter3ESFkO8(int i) {
        View view = FocusGroupNode_androidKt.getView(this);
        if (view.isFocused() || view.hasFocus()) {
            return FocusRequester.Companion.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        return FocusInteropUtils_androidKt.requestInteropFocus(view, FocusInteropUtils_androidKt.m1167toAndroidFocusDirection3ESFkO8(i), FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, (View) objRequireOwner, view)) ? FocusRequester.Companion.getDefault() : FocusRequester.Companion.getCancel();
    }

    /* JADX INFO: renamed from: onExit-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2664onExit3ESFkO8(int i) {
        View viewFindNextFocusFromRect;
        View view = FocusGroupNode_androidKt.getView(this);
        if (!view.hasFocus()) {
            return FocusRequester.Companion.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) objRequireOwner;
        if (view instanceof ViewGroup) {
            Rect currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, view2, view);
            Integer numM1167toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1167toAndroidFocusDirection3ESFkO8(i);
            int iIntValue = numM1167toAndroidFocusDirection3ESFkO8 != null ? numM1167toAndroidFocusDirection3ESFkO8.intValue() : 130;
            FocusFinder focusFinder = FocusFinder.getInstance();
            View view3 = this.focusedChild;
            if (view3 != null) {
                viewFindNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) view2, view3, iIntValue);
            } else {
                viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) view2, currentlyFocusedRect, iIntValue);
            }
            if (viewFindNextFocusFromRect != null && FocusGroupNode_androidKt.containsDescendant(view, viewFindNextFocusFromRect)) {
                viewFindNextFocusFromRect.requestFocus(iIntValue, currentlyFocusedRect);
                return FocusRequester.Companion.getCancel();
            }
            if (!view2.requestFocus()) {
                throw new IllegalStateException("host view did not take focus");
            }
            return FocusRequester.Companion.getDefault();
        }
        if (!view2.requestFocus()) {
            throw new IllegalStateException("host view did not take focus");
        }
        return FocusRequester.Companion.getDefault();
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
        if (!getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) != 0) {
            boolean z = false;
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                    Modifier.Node nodePop = child$ui_release;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (!(nodePop instanceof FocusTargetNode)) {
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
                        } else {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner$ui_release() == null) {
            return;
        }
        View view3 = FocusGroupNode_androidKt.getView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner ownerRequireOwner = DelegatableNodeKt.requireOwner(this);
        boolean z = (view == null || Intrinsics.areEqual(view, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view3, view)) ? false : true;
        boolean z2 = (view2 == null || Intrinsics.areEqual(view2, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view3, view2)) ? false : true;
        if (z && z2) {
            this.focusedChild = view2;
            return;
        }
        if (!z2) {
            if (z) {
                this.focusedChild = null;
                if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                    focusOwner.mo1171clearFocusI7lrPNg(false, true, false, FocusDirection.Companion.m1161getExitdhqQ8s());
                    return;
                }
                return;
            }
            this.focusedChild = null;
            return;
        }
        this.focusedChild = view2;
        FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
        if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
            return;
        }
        FocusTransactionManager focusTransactionManager = focusOwner.getFocusTransactionManager();
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.getView(this).addOnAttachStateChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FocusGroupNode_androidKt.getView(this).removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }
}
