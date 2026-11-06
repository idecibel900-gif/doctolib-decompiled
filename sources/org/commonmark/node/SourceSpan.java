package org.commonmark.node;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class SourceSpan {
    private final int columnIndex;
    private final int length;
    private final int lineIndex;

    public static SourceSpan of(int i, int i2, int i3) {
        return new SourceSpan(i, i2, i3);
    }

    private SourceSpan(int i, int i2, int i3) {
        this.lineIndex = i;
        this.columnIndex = i2;
        this.length = i3;
    }

    public int getLineIndex() {
        return this.lineIndex;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public int getLength() {
        return this.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SourceSpan sourceSpan = (SourceSpan) obj;
            if (this.lineIndex == sourceSpan.lineIndex && this.columnIndex == sourceSpan.columnIndex && this.length == sourceSpan.length) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.lineIndex), Integer.valueOf(this.columnIndex), Integer.valueOf(this.length));
    }

    public String toString() {
        return "SourceSpan{line=" + this.lineIndex + ", column=" + this.columnIndex + ", length=" + this.length + "}";
    }
}
