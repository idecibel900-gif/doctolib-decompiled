package com.swmansion.enriched.markdown.spoiler;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentKey {
    private final int line;
    private final int spanIdentity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SegmentKey)) {
            return false;
        }
        SegmentKey segmentKey = (SegmentKey) obj;
        return this.spanIdentity == segmentKey.spanIdentity && this.line == segmentKey.line;
    }

    public int hashCode() {
        return (Integer.hashCode(this.spanIdentity) * 31) + Integer.hashCode(this.line);
    }

    public String toString() {
        return "SegmentKey(spanIdentity=" + this.spanIdentity + ", line=" + this.line + ")";
    }

    public SegmentKey(int i, int i2) {
        this.spanIdentity = i;
        this.line = i2;
    }

    public final int getSpanIdentity() {
        return this.spanIdentity;
    }
}
