package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo1898measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                return LayoutModifierNode.this.mo54measure3p2s80s(measureScope, measurable, j);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo1898measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                return LayoutModifierNode.this.mo54measure3p2s80s(measureScope, measurable, j);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicWidth.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo1898measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                return LayoutModifierNode.this.mo54measure3p2s80s(measureScope, measurable, j);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicHeight.1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult mo1898measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                return LayoutModifierNode.this.mo54measure3p2s80s(measureScope, measurable, j);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }
}
