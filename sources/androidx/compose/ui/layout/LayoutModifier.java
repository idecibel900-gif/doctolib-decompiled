package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutModifier extends Modifier.Element {
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo32measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return MeasuringIntrinsics.INSTANCE.minWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return MeasuringIntrinsics.INSTANCE.minHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return MeasuringIntrinsics.INSTANCE.maxWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return MeasuringIntrinsics.INSTANCE.maxHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
