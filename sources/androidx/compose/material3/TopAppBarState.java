package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarState {
    public static final Companion Companion = new Companion(null);
    private static final Saver Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List invoke(SaverScope saverScope, TopAppBarState topAppBarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(topAppBarState.getHeightOffsetLimit()), Float.valueOf(topAppBarState.getHeightOffset()), Float.valueOf(topAppBarState.getContentOffset())});
        }
    }, new Function1() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final TopAppBarState invoke(List list) {
            return new TopAppBarState(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue(), ((Number) list.get(2)).floatValue());
        }
    });
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private final MutableFloatState heightOffsetLimit$delegate;

    public TopAppBarState(float f, float f2, float f3) {
        this.heightOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f3);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
    }

    public final float getHeightOffsetLimit() {
        return this.heightOffsetLimit$delegate.getFloatValue();
    }

    public final void setHeightOffsetLimit(float f) {
        this.heightOffsetLimit$delegate.setFloatValue(f);
    }

    public final float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public final void setHeightOffset(float f) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(f, getHeightOffsetLimit(), 0.0f));
    }

    public final float getContentOffset() {
        return this.contentOffset$delegate.getFloatValue();
    }

    public final void setContentOffset(float f) {
        this.contentOffset$delegate.setFloatValue(f);
    }

    public final float getCollapsedFraction() {
        if (getHeightOffsetLimit() == 0.0f) {
            return 0.0f;
        }
        return getHeightOffset() / getHeightOffsetLimit();
    }

    public final float getOverlappedFraction() {
        if (getHeightOffsetLimit() == 0.0f) {
            return 0.0f;
        }
        return 1 - (RangesKt.coerceIn(getHeightOffsetLimit() - getContentOffset(), getHeightOffsetLimit(), 0.0f) / getHeightOffsetLimit());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver getSaver() {
            return TopAppBarState.Saver;
        }
    }
}
