package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimationModifierKt {
    private static final long InvalidSize = IntSizeKt.IntSize(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);

    public static final long getInvalidSize() {
        return InvalidSize;
    }

    /* JADX INFO: renamed from: isValid-ozmzZPI, reason: not valid java name */
    public static final boolean m36isValidozmzZPI(long j) {
        return !IntSize.m2607equalsimpl0(j, InvalidSize);
    }
}
