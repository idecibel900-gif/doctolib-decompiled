package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class BrushStyle implements TextForegroundStyle {
    private final float alpha;
    private final ShaderBrush value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrushStyle)) {
            return false;
        }
        BrushStyle brushStyle = (BrushStyle) obj;
        return Intrinsics.areEqual(this.value, brushStyle.value) && Float.compare(this.alpha, brushStyle.alpha) == 0;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Float.hashCode(this.alpha);
    }

    public String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + this.alpha + ')';
    }

    public BrushStyle(ShaderBrush shaderBrush, float f) {
        this.value = shaderBrush;
        this.alpha = f;
    }

    public final ShaderBrush getValue() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo2417getColor0d7_KjU() {
        return Color.Companion.m1385getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return this.value;
    }
}
