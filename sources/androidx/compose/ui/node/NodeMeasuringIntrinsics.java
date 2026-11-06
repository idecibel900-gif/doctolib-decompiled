package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class NodeMeasuringIntrinsics {
    public static final NodeMeasuringIntrinsics INSTANCE = new NodeMeasuringIntrinsics();

    private enum IntrinsicMinMax {
        Min,
        Max
    }

    private enum IntrinsicWidthHeight {
        Width,
        Height
    }

    public interface MeasureBlock {
        /* JADX INFO: renamed from: measure-3p2s80s */
        MeasureResult mo1898measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);
    }

    private NodeMeasuringIntrinsics() {
    }

    public final int minWidth$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return measureBlock.mo1898measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int minHeight$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return measureBlock.mo1898measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int maxWidth$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return measureBlock.mo1898measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int maxHeight$ui_release(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return measureBlock.mo1898measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    private static final class DefaultIntrinsicMeasurable implements Measurable {
        private final IntrinsicMeasurable measurable;
        private final IntrinsicMinMax minMax;
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMinMax intrinsicMinMax, IntrinsicWidthHeight intrinsicWidthHeight) {
            this.measurable = intrinsicMeasurable;
            this.minMax = intrinsicMinMax;
            this.widthHeight = intrinsicWidthHeight;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public Placeable mo1843measureBRTryo0(long j) {
            int iMinIntrinsicHeight;
            int iMinIntrinsicWidth;
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                if (this.minMax == IntrinsicMinMax.Max) {
                    iMinIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.m2529getMaxHeightimpl(j));
                } else {
                    iMinIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.m2529getMaxHeightimpl(j));
                }
                return new EmptyPlaceable(iMinIntrinsicWidth, Constraints.m2525getHasBoundedHeightimpl(j) ? Constraints.m2529getMaxHeightimpl(j) : 32767);
            }
            if (this.minMax == IntrinsicMinMax.Max) {
                iMinIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.m2530getMaxWidthimpl(j));
            } else {
                iMinIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.m2530getMaxWidthimpl(j));
            }
            return new EmptyPlaceable(Constraints.m2526getHasBoundedWidthimpl(j) ? Constraints.m2530getMaxWidthimpl(j) : 32767, iMinIntrinsicHeight);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            return this.measurable.minIntrinsicWidth(i);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            return this.measurable.maxIntrinsicWidth(i);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            return this.measurable.minIntrinsicHeight(i);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            return this.measurable.maxIntrinsicHeight(i);
        }
    }

    private static final class EmptyPlaceable extends Placeable {
        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            return LinearLayoutManager.INVALID_OFFSET;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* JADX INFO: renamed from: placeAt-f8xVGno */
        public void mo1844placeAtf8xVGno(long j, float f, Function1 function1) {
        }

        public EmptyPlaceable(int i, int i2) {
            m1863setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        }
    }
}
