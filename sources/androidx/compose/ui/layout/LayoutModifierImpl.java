package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutModifierImpl extends Modifier.Node implements LayoutModifierNode {
    private Function3 measureBlock;

    public final void setMeasureBlock(Function3 function3) {
        this.measureBlock = function3;
    }

    public LayoutModifierImpl(Function3 function3) {
        this.measureBlock = function3;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return (MeasureResult) this.measureBlock.invoke(measureScope, measurable, Constraints.m2519boximpl(j));
    }

    public String toString() {
        return "LayoutModifierImpl(measureBlock=" + this.measureBlock + ')';
    }
}
