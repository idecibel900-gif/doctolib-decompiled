package com.swmansion.enriched.markdown.spans;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MathMeasureRequest {
    private final float fontSize;
    private final String latex;
    private final MathRenderMode mode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MathMeasureRequest)) {
            return false;
        }
        MathMeasureRequest mathMeasureRequest = (MathMeasureRequest) obj;
        return Float.compare(this.fontSize, mathMeasureRequest.fontSize) == 0 && Intrinsics.areEqual(this.latex, mathMeasureRequest.latex) && this.mode == mathMeasureRequest.mode;
    }

    public int hashCode() {
        return (((Float.hashCode(this.fontSize) * 31) + this.latex.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return "MathMeasureRequest(fontSize=" + this.fontSize + ", latex=" + this.latex + ", mode=" + this.mode + ")";
    }

    public MathMeasureRequest(float f, String latex, MathRenderMode mode) {
        Intrinsics.checkNotNullParameter(latex, "latex");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.fontSize = f;
        this.latex = latex;
        this.mode = mode;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final String getLatex() {
        return this.latex;
    }
}
