package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState(LazyGridState lazyGridState, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2004349821, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridBeyondBoundsState (LazyGridBeyondBoundsModifier.kt:23)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(lazyGridState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridBeyondBoundsState(lazyGridState);
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyGridBeyondBoundsState lazyGridBeyondBoundsState = (LazyGridBeyondBoundsState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridBeyondBoundsState;
    }
}
