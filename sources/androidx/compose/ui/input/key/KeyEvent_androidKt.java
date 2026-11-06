package androidx.compose.ui.input.key;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyEvent_androidKt {
    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m1722getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        return Key_androidKt.Key(keyEvent.getKeyCode());
    }

    /* JADX INFO: renamed from: getUtf16CodePoint-ZmokQxo, reason: not valid java name */
    public static final int m1724getUtf16CodePointZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar();
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m1723getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action == 0) {
            return KeyEventType.Companion.m1719getKeyDownCS__XNY();
        }
        if (action == 1) {
            return KeyEventType.Companion.m1720getKeyUpCS__XNY();
        }
        return KeyEventType.Companion.m1721getUnknownCS__XNY();
    }

    /* JADX INFO: renamed from: isAltPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1725isAltPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isAltPressed();
    }

    /* JADX INFO: renamed from: isCtrlPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1726isCtrlPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    /* JADX INFO: renamed from: isShiftPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m1727isShiftPressedZmokQxo(android.view.KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
