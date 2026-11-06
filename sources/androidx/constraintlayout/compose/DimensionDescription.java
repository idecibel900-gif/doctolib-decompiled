package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLObject;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class DimensionDescription implements Dimension.Coercible, Dimension {
    private final DimensionSymbol max;
    private final DimensionSymbol min;
    private final DimensionSymbol valueSymbol;

    public /* synthetic */ DimensionDescription(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DimensionDescription(Dp dp, String str) {
        this.valueSymbol = new DimensionSymbol(dp, str, "base", null);
        this.min = new DimensionSymbol(0 == true ? 1 : 0, 0 == true ? 1 : 0, "min", 0 == true ? 1 : 0);
        this.max = new DimensionSymbol(0 == true ? 1 : 0, 0 == true ? 1 : 0, "max", 0 == true ? 1 : 0);
    }

    private DimensionDescription(float f) {
        this(Dp.m2549boximpl(f), (String) null);
    }

    public DimensionDescription(String str) {
        this((Dp) null, str);
    }

    public final CLElement asCLElement$constraintlayout_compose_release() {
        if (this.min.isUndefined() && this.max.isUndefined()) {
            return this.valueSymbol.asCLElement();
        }
        CLObject cLObject = new CLObject(new char[0]);
        if (!this.min.isUndefined()) {
            cLObject.put("min", this.min.asCLElement());
        }
        if (!this.max.isUndefined()) {
            cLObject.put("max", this.max.asCLElement());
        }
        cLObject.put("value", this.valueSymbol.asCLElement());
        return cLObject;
    }
}
