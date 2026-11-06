package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class PlaceableResult implements OwnerScope {
    private final LookaheadCapablePlaceable placeable;
    private final MeasureResult result;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceableResult)) {
            return false;
        }
        PlaceableResult placeableResult = (PlaceableResult) obj;
        return Intrinsics.areEqual(this.result, placeableResult.result) && Intrinsics.areEqual(this.placeable, placeableResult.placeable);
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + this.placeable.hashCode();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.result + ", placeable=" + this.placeable + ')';
    }

    public PlaceableResult(MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.result = measureResult;
        this.placeable = lookaheadCapablePlaceable;
    }

    public final MeasureResult getResult() {
        return this.result;
    }

    public final LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }
}
