package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo187calculateMouseWheelScroll8xgXZGE(Density density, PointerEvent pointerEvent, long j) {
        List changes = pointerEvent.getChanges();
        Offset offsetM1214boximpl = Offset.m1214boximpl(Offset.Companion.m1235getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            offsetM1214boximpl = Offset.m1214boximpl(Offset.m1228plusMKHz9U(offsetM1214boximpl.m1232unboximpl(), ((PointerInputChange) changes.get(i)).m1780getScrollDeltaF1C5BW0()));
        }
        return Offset.m1229timestuRUvjQ(offsetM1214boximpl.m1232unboximpl(), -density.mo231toPx0680j_4(Dp.m2551constructorimpl(64)));
    }
}
