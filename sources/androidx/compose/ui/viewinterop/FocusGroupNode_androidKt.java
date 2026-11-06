package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.node.DelegatableNodeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class FocusGroupNode_androidKt {
    public static final Modifier focusInteropModifier(Modifier modifier) {
        return FocusModifierKt.focusTarget(FocusModifierKt.focusTarget(modifier.then(FocusGroupPropertiesElement.INSTANCE)).then(FocusTargetPropertiesElement.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View getView(Modifier.Node node) {
        View interopView = DelegatableNodeKt.requireLayoutNode(node.getNode()).getInteropView();
        if (interopView != null) {
            return interopView;
        }
        throw new IllegalStateException("Could not fetch interop view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view.getParent()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCurrentlyFocusedRect(FocusOwner focusOwner, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        androidx.compose.ui.geometry.Rect focusRect = focusOwner.getFocusRect();
        if (focusRect == null) {
            return null;
        }
        return new Rect((((int) focusRect.getLeft()) + iArr[0]) - iArr2[0], (((int) focusRect.getTop()) + iArr[1]) - iArr2[1], (((int) focusRect.getRight()) + iArr[0]) - iArr2[0], (((int) focusRect.getBottom()) + iArr[1]) - iArr2[1]);
    }
}
