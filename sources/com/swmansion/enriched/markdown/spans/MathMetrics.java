package com.swmansion.enriched.markdown.spans;

/* JADX INFO: loaded from: classes4.dex */
public final class MathMetrics {
    private final float ascent;
    private final float descent;
    private final int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MathMetrics)) {
            return false;
        }
        MathMetrics mathMetrics = (MathMetrics) obj;
        return this.width == mathMetrics.width && Float.compare(this.ascent, mathMetrics.ascent) == 0 && Float.compare(this.descent, mathMetrics.descent) == 0;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.width) * 31) + Float.hashCode(this.ascent)) * 31) + Float.hashCode(this.descent);
    }

    public String toString() {
        return "MathMetrics(width=" + this.width + ", ascent=" + this.ascent + ", descent=" + this.descent + ")";
    }

    public MathMetrics(int i, float f, float f2) {
        this.width = i;
        this.ascent = f;
        this.descent = f2;
    }

    public final float getAscent() {
        return this.ascent;
    }

    public final float getDescent() {
        return this.descent;
    }
}
