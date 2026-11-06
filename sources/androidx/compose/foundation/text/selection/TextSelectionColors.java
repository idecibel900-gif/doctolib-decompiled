package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextSelectionColors {
    private final long backgroundColor;
    private final long handleColor;

    public /* synthetic */ TextSelectionColors(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    private TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    /* JADX INFO: renamed from: getHandleColor-0d7_KjU, reason: not valid java name */
    public final long m666getHandleColor0d7_KjU() {
        return this.handleColor;
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m665getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return Color.m1367equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m1367equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
    }

    public int hashCode() {
        return (Color.m1373hashCodeimpl(this.handleColor) * 31) + Color.m1373hashCodeimpl(this.backgroundColor);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m1374toStringimpl(this.handleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m1374toStringimpl(this.backgroundColor)) + ')';
    }
}
