package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class ColorStyle implements TextForegroundStyle {
    private final long value;

    public /* synthetic */ ColorStyle(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && Color.m1367equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return null;
    }

    public int hashCode() {
        return Color.m1373hashCodeimpl(this.value);
    }

    public String toString() {
        return "ColorStyle(value=" + ((Object) Color.m1374toStringimpl(this.value)) + ')';
    }

    private ColorStyle(long j) {
        this.value = j;
        if (j == 16) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
        }
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU */
    public long mo2417getColor0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return Color.m1368getAlphaimpl(mo2417getColor0d7_KjU());
    }
}
