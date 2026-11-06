package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberPagerBeyondBoundsState(PagerState pagerState, int i, Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(373558254, i2, -1, "androidx.compose.foundation.pager.rememberPagerBeyondBoundsState (PagerBeyondBoundsModifier.kt:25)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new PagerBeyondBoundsState(pagerState, i);
            composer.updateRememberedValue(objRememberedValue);
        }
        PagerBeyondBoundsState pagerBeyondBoundsState = (PagerBeyondBoundsState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return pagerBeyondBoundsState;
    }
}
