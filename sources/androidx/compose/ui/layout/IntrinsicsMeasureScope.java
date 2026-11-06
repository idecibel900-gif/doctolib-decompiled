package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicsMeasureScope implements MeasureScope, IntrinsicMeasureScope {
    private final /* synthetic */ IntrinsicMeasureScope $$delegate_0;
    private final LayoutDirection layoutDirection;

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return this.$$delegate_0.isLookingAhead();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo225roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo225roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo226toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo226toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo227toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo227toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo228toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo228toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo229toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo229toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo230toPxR2X_6o(long j) {
        return this.$$delegate_0.mo230toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo231toPx0680j_4(float f) {
        return this.$$delegate_0.mo231toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo232toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo232toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo233toSp0xMU5do(float f) {
        return this.$$delegate_0.mo233toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo234toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo234toSpkPz2Gy4(f);
    }

    public IntrinsicsMeasureScope(IntrinsicMeasureScope intrinsicMeasureScope, LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
        this.$$delegate_0 = intrinsicMeasureScope;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int i, int i2, final Map map, final Function1 function1, Function1 function2) {
        boolean z = false;
        final int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        final int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i2, 0);
        if ((iCoerceAtLeast & (-16777216)) == 0 && ((-16777216) & iCoerceAtLeast2) == 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + iCoerceAtLeast + " x " + iCoerceAtLeast2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.layout.IntrinsicsMeasureScope.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return iCoerceAtLeast;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return iCoerceAtLeast2;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map getAlignmentLines() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 getRulers() {
                return function1;
            }
        };
    }
}
