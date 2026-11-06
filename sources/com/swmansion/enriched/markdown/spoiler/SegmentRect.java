package com.swmansion.enriched.markdown.spoiler;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentRect {
    private final float height;
    private final float left;
    private final float top;
    private final float width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SegmentRect)) {
            return false;
        }
        SegmentRect segmentRect = (SegmentRect) obj;
        return Float.compare(this.left, segmentRect.left) == 0 && Float.compare(this.top, segmentRect.top) == 0 && Float.compare(this.width, segmentRect.width) == 0 && Float.compare(this.height, segmentRect.height) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height);
    }

    public String toString() {
        return "SegmentRect(left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public SegmentRect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.width = f3;
        this.height = f4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }
}
