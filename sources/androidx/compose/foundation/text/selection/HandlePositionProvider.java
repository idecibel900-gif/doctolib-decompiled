package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    private final Alignment handleReferencePoint;
    private final OffsetProvider positionProvider;
    private long prevPosition = Offset.Companion.m1235getZeroF1C5BW0();

    public HandlePositionProvider(Alignment alignment, OffsetProvider offsetProvider) {
        this.handleReferencePoint = alignment;
        this.positionProvider = offsetProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo172calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        long jMo473provideF1C5BW0 = this.positionProvider.mo473provideF1C5BW0();
        if (!OffsetKt.m1237isSpecifiedk4lQ0M(jMo473provideF1C5BW0)) {
            jMo473provideF1C5BW0 = this.prevPosition;
        }
        this.prevPosition = jMo473provideF1C5BW0;
        return IntOffset.m2595plusqkQi6aY(IntOffset.m2595plusqkQi6aY(intRect.m2602getTopLeftnOccac(), IntOffsetKt.m2601roundk4lQ0M(jMo473provideF1C5BW0)), this.handleReferencePoint.mo1118alignKFBX0sM(j2, IntSize.Companion.m2613getZeroYbymL2g(), layoutDirection));
    }
}
