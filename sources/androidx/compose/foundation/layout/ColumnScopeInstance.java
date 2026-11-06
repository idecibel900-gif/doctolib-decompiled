package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class ColumnScopeInstance implements ColumnScope {
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    private ColumnScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier weight(Modifier modifier, float f, boolean z) {
        if (f <= 0.0d) {
            throw new IllegalArgumentException(("invalid weight " + f + "; must be greater than zero").toString());
        }
        return modifier.then(new LayoutWeightElement(RangesKt.coerceAtMost(f, Float.MAX_VALUE), z));
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier align(Modifier modifier, Alignment.Horizontal horizontal) {
        return modifier.then(new HorizontalAlignElement(horizontal));
    }
}
