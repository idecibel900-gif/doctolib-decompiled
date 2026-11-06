package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyEventHelpers_androidKt {
    public static final void showCharacterPalette() {
    }

    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m477cancelsTextSelectionZmokQxo(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 4 && KeyEventType.m1718equalsimpl0(KeyEvent_androidKt.m1723getTypeZmokQxo(keyEvent), KeyEventType.Companion.m1720getKeyUpCS__XNY());
    }
}
