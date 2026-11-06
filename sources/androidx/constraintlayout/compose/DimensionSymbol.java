package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLString;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class DimensionSymbol {
    private final String debugName;
    private String symbol;
    private Dp value;

    public /* synthetic */ DimensionSymbol(Dp dp, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(dp, str, str2);
    }

    private DimensionSymbol(Dp dp, String str, String str2) {
        this.value = dp;
        this.symbol = str;
        this.debugName = str2;
    }

    public final boolean isUndefined() {
        return this.value == null && this.symbol == null;
    }

    public final CLElement asCLElement() {
        Dp dp = this.value;
        if (dp != null) {
            return new CLNumber(dp.m2557unboximpl());
        }
        String str = this.symbol;
        if (str != null) {
            return CLString.from(str);
        }
        return CLString.from("wrap");
    }
}
