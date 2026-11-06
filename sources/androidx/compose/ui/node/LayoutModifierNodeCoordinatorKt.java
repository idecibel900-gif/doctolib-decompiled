package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutModifierNodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        int iM2591getXimpl;
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (!(child != null)) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = (Integer) lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
            return num != null ? num.intValue() : LinearLayoutManager.INVALID_OFFSET;
        }
        int i = child.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
        child.setShallowPlacing$ui_release(true);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
        lookaheadCapablePlaceable.replace$ui_release();
        child.setShallowPlacing$ui_release(false);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(false);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            iM2591getXimpl = IntOffset.m2592getYimpl(child.mo1937getPositionnOccac());
        } else {
            iM2591getXimpl = IntOffset.m2591getXimpl(child.mo1937getPositionnOccac());
        }
        return i + iM2591getXimpl;
    }
}
