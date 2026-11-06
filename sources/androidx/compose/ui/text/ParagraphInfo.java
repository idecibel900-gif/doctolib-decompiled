package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class ParagraphInfo {
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        return Intrinsics.areEqual(this.paragraph, paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0;
    }

    public int hashCode() {
        return (((((((((((this.paragraph.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex)) * 31) + Integer.hashCode(this.startLineIndex)) * 31) + Integer.hashCode(this.endLineIndex)) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.bottom);
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    public ParagraphInfo(Paragraph paragraph, int i, int i2, int i3, int i4, float f, float f2) {
        this.paragraph = paragraph;
        this.startIndex = i;
        this.endIndex = i2;
        this.startLineIndex = i3;
        this.endLineIndex = i4;
        this.top = f;
        this.bottom = f2;
    }

    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    public final int toLocalIndex(int i) {
        return RangesKt.coerceIn(i, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toGlobalIndex(int i) {
        return i + this.startIndex;
    }

    public final int toLocalLineIndex(int i) {
        return i - this.startLineIndex;
    }

    public final int toGlobalLineIndex(int i) {
        return i + this.startLineIndex;
    }

    public final float toGlobalYPosition(float f) {
        return f + this.top;
    }

    public final float toLocalYPosition(float f) {
        return f - this.top;
    }

    /* JADX INFO: renamed from: toLocal-MK-Hz9U, reason: not valid java name */
    public final long m2160toLocalMKHz9U(long j) {
        return OffsetKt.Offset(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j) - this.top);
    }

    public final Rect toGlobal(Rect rect) {
        return rect.m1245translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
    }

    public final Rect toLocal(Rect rect) {
        return rect.m1245translatek4lQ0M(OffsetKt.Offset(0.0f, -this.top));
    }

    public final Path toGlobal(Path path) {
        path.mo1307translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
        return path;
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0$default, reason: not valid java name */
    public static /* synthetic */ long m2158toGlobalxdX6G0$default(ParagraphInfo paragraphInfo, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return paragraphInfo.m2159toGlobalxdX6G0(j, z);
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m2159toGlobalxdX6G0(long j, boolean z) {
        if (z) {
            TextRange.Companion companion = TextRange.Companion;
            if (TextRange.m2210equalsimpl0(j, companion.m2222getZerod9O1mEE())) {
                return companion.m2222getZerod9O1mEE();
            }
        }
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m2217getStartimpl(j)), toGlobalIndex(TextRange.m2212getEndimpl(j)));
    }
}
