package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final boolean isComposeRootInScrollableContainer(DelegatableNode delegatableNode) {
        return isInScrollableViewGroup(DelegatableNode_androidKt.requireView(delegatableNode));
    }

    private static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* JADX INFO: renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m144isPressZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m1718equalsimpl0(KeyEvent_androidKt.m1723getTypeZmokQxo(keyEvent), KeyEventType.Companion.m1719getKeyDownCS__XNY()) && m143isEnterZmokQxo(keyEvent);
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m142isClickZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m1718equalsimpl0(KeyEvent_androidKt.m1723getTypeZmokQxo(keyEvent), KeyEventType.Companion.m1720getKeyUpCS__XNY()) && m143isEnterZmokQxo(keyEvent);
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m143isEnterZmokQxo(KeyEvent keyEvent) {
        int iM1728getNativeKeyCodeYVgTNJs = Key_androidKt.m1728getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent));
        return iM1728getNativeKeyCodeYVgTNJs == 23 || iM1728getNativeKeyCodeYVgTNJs == 66 || iM1728getNativeKeyCodeYVgTNJs == 160;
    }
}
