package androidx.compose.foundation.text;

import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
public final class TextRangeLayoutModifier implements ParentDataModifier {
    private final TextRangeScopeMeasurePolicy measurePolicy;

    @Override // androidx.compose.ui.layout.ParentDataModifier
    public TextRangeLayoutModifier modifyParentData(Density density, Object obj) {
        return this;
    }

    public TextRangeLayoutModifier(TextRangeScopeMeasurePolicy textRangeScopeMeasurePolicy) {
        this.measurePolicy = textRangeScopeMeasurePolicy;
    }

    public final TextRangeScopeMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }
}
