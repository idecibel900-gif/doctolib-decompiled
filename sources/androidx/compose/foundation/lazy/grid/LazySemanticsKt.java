package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazySemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyGridSemanticState(final LazyGridState lazyGridState, boolean z, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1247008005, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:33)");
        }
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(lazyGridState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.grid.LazySemanticsKt$rememberLazyGridSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float getScrollOffset() {
                    return LazyLayoutSemanticsKt.estimatedLazyScrollOffset(lazyGridState.getFirstVisibleItemIndex(), lazyGridState.getFirstVisibleItemScrollOffset());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public float getMaxScrollOffset() {
                    return LazyLayoutSemanticsKt.estimatedLazyMaxScrollOffset(lazyGridState.getFirstVisibleItemIndex(), lazyGridState.getFirstVisibleItemScrollOffset(), lazyGridState.getCanScrollForward());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public Object scrollToItem(int i2, Continuation continuation) {
                    Object objScrollToItem$default = LazyGridState.scrollToItem$default(lazyGridState, i2, 0, continuation, 2, null);
                    return objScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public CollectionInfo collectionInfo() {
                    return new CollectionInfo(-1, -1);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int getViewport() {
                    if (lazyGridState.getLayoutInfo().getOrientation() == Orientation.Vertical) {
                        return IntSize.m2608getHeightimpl(lazyGridState.getLayoutInfo().mo393getViewportSizeYbymL2g());
                    }
                    return IntSize.m2609getWidthimpl(lazyGridState.getLayoutInfo().mo393getViewportSizeYbymL2g());
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public int getContentPadding() {
                    return lazyGridState.getLayoutInfo().getBeforeContentPadding() + lazyGridState.getLayoutInfo().getAfterContentPadding();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        LazySemanticsKt$rememberLazyGridSemanticState$1$1 lazySemanticsKt$rememberLazyGridSemanticState$1$1 = (LazySemanticsKt$rememberLazyGridSemanticState$1$1) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazySemanticsKt$rememberLazyGridSemanticState$1$1;
    }
}
