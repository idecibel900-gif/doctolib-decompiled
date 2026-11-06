package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridStateKt {
    private static final LazyGridMeasureResult EmptyLazyGridLayoutInfo;

    public static final LazyGridState rememberLazyGridState(final int i, final int i2, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(29186956, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:71)");
        }
        Object[] objArr = new Object[0];
        Saver saver = LazyGridState.Companion.getSaver();
        boolean z = ((((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i2)) || (i3 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$rememberLazyGridState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazyGridState invoke() {
                    return new LazyGridState(i, i2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyGridState lazyGridState = (LazyGridState) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridState;
    }

    static {
        MeasureResult measureResult = new MeasureResult() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$EmptyLazyGridLayoutInfo$1
            private final Map alignmentLines = MapsKt.emptyMap();
            private final int height;
            private final int width;

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map getAlignmentLines() {
                return this.alignmentLines;
            }
        };
        List listEmptyList = CollectionsKt.emptyList();
        Orientation orientation = Orientation.Vertical;
        EmptyLazyGridLayoutInfo = new LazyGridMeasureResult(null, 0, false, 0.0f, measureResult, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1.0f, 0.0f, 2, null), 0, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$EmptyLazyGridLayoutInfo$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final List invoke(int i) {
                return CollectionsKt.emptyList();
            }
        }, listEmptyList, 0, 0, 0, false, orientation, 0, 0);
    }
}
