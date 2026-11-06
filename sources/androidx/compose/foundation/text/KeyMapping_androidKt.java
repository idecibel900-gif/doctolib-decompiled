package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* JADX INFO: renamed from: map-ZmokQxo */
        public KeyCommand mo478mapZmokQxo(KeyEvent keyEvent) {
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m1727isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m1725isAltPressedZmokQxo(keyEvent)) {
                long jM1722getKeyZmokQxo = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys = MappedKeys.INSTANCE;
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m505getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m506getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m507getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo, mappedKeys.m504getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m1725isAltPressedZmokQxo(keyEvent)) {
                long jM1722getKeyZmokQxo2 = KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m505getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m506getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m507getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m1695equalsimpl0(jM1722getKeyZmokQxo2, mappedKeys2.m504getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo478mapZmokQxo(keyEvent) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
