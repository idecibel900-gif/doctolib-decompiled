package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public abstract class StylusHandwritingKt {
    private static final float HandwritingBoundsVerticalOffset = Dp.m2551constructorimpl(40);
    private static final float HandwritingBoundsHorizontalOffset = Dp.m2551constructorimpl(10);

    public static final Modifier stylusHandwriting(Modifier modifier, boolean z, Function0 function0) {
        return (z && StylusHandwriting_androidKt.isStylusHandwritingSupported()) ? PaddingKt.m311paddingVpY3zN4(modifier.then(new StylusHandwritingElementWithNegativePadding(function0)), HandwritingBoundsHorizontalOffset, HandwritingBoundsVerticalOffset) : modifier;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return HandwritingBoundsVerticalOffset;
    }

    public static final float getHandwritingBoundsHorizontalOffset() {
        return HandwritingBoundsHorizontalOffset;
    }
}
