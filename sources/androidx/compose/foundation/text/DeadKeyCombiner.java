package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;

/* JADX INFO: loaded from: classes.dex */
public final class DeadKeyCombiner {
    private Integer deadKeyCode;

    /* JADX INFO: renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m476consumeZmokQxo(KeyEvent keyEvent) {
        int iM1724getUtf16CodePointZmokQxo = KeyEvent_androidKt.m1724getUtf16CodePointZmokQxo(keyEvent);
        if ((Integer.MIN_VALUE & iM1724getUtf16CodePointZmokQxo) != 0) {
            this.deadKeyCode = Integer.valueOf(iM1724getUtf16CodePointZmokQxo & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num != null) {
            this.deadKeyCode = null;
            Integer numValueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), iM1724getUtf16CodePointZmokQxo));
            Integer num2 = numValueOf.intValue() != 0 ? numValueOf : null;
            return num2 == null ? Integer.valueOf(iM1724getUtf16CodePointZmokQxo) : num2;
        }
        return Integer.valueOf(iM1724getUtf16CodePointZmokQxo);
    }
}
