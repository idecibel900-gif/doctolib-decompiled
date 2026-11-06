package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    public KeyboardActionRunner(SoftwareKeyboardController softwareKeyboardController) {
        this.keyboardController = softwareKeyboardController;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        this.keyboardActions = keyboardActions;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager) {
        this.focusManager = focusManager;
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final void m480runActionKlQnJC8(int i) {
        Function1 onSend;
        ImeAction.Companion companion = ImeAction.Companion;
        Unit unit = null;
        if (ImeAction.m2328equalsimpl0(i, companion.m2333getDoneeUduSuo())) {
            onSend = getKeyboardActions().getOnDone();
        } else if (ImeAction.m2328equalsimpl0(i, companion.m2334getGoeUduSuo())) {
            onSend = getKeyboardActions().getOnGo();
        } else if (ImeAction.m2328equalsimpl0(i, companion.m2335getNexteUduSuo())) {
            onSend = getKeyboardActions().getOnNext();
        } else if (ImeAction.m2328equalsimpl0(i, companion.m2337getPreviouseUduSuo())) {
            onSend = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m2328equalsimpl0(i, companion.m2338getSearcheUduSuo())) {
            onSend = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m2328equalsimpl0(i, companion.m2339getSendeUduSuo())) {
            onSend = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m2328equalsimpl0(i, companion.m2332getDefaulteUduSuo()) ? true : ImeAction.m2328equalsimpl0(i, companion.m2336getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction");
            }
            onSend = null;
        }
        if (onSend != null) {
            onSend.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m479defaultKeyboardActionKlQnJC8(i);
        }
    }

    /* JADX INFO: renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void m479defaultKeyboardActionKlQnJC8(int i) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m2328equalsimpl0(i, companion.m2335getNexteUduSuo())) {
            getFocusManager().mo1169moveFocus3ESFkO8(FocusDirection.Companion.m1163getNextdhqQ8s());
            return;
        }
        if (ImeAction.m2328equalsimpl0(i, companion.m2337getPreviouseUduSuo())) {
            getFocusManager().mo1169moveFocus3ESFkO8(FocusDirection.Companion.m1164getPreviousdhqQ8s());
            return;
        }
        if (!ImeAction.m2328equalsimpl0(i, companion.m2333getDoneeUduSuo())) {
            if (ImeAction.m2328equalsimpl0(i, companion.m2334getGoeUduSuo()) ? true : ImeAction.m2328equalsimpl0(i, companion.m2338getSearcheUduSuo()) ? true : ImeAction.m2328equalsimpl0(i, companion.m2339getSendeUduSuo()) ? true : ImeAction.m2328equalsimpl0(i, companion.m2332getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m2328equalsimpl0(i, companion.m2336getNoneeUduSuo());
        } else {
            SoftwareKeyboardController softwareKeyboardController = this.keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
        }
    }
}
