package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final HashMap placeablesCache = new HashMap();
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int i, int i2, Map map, Function1 function1, Function1 function2) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1, function2);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo225roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo225roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo230toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo230toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo231toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo231toPx0680j_4(f);
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.getItemProvider().invoke();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public List mo420measure0kLqBqw(int i, long j) {
        List list = (List) this.placeablesCache.get(Integer.valueOf(i));
        if (list != null) {
            return list;
        }
        Object key = this.itemProvider.getKey(i);
        List listSubcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key, this.itemProvider.getContentType(i)));
        int size = listSubcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) listSubcompose.get(i2)).mo1843measureBRTryo0(j));
        }
        this.placeablesCache.put(Integer.valueOf(i), arrayList);
        return arrayList;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo226toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.mo226toDpGaN1DYA(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo228toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.mo228toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo227toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.mo227toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo234toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.mo234toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo233toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.mo233toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo232toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.mo232toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo229toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.mo229toDpSizekrfVVM(j);
    }
}
