package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ContextMenuColors {
    private final long backgroundColor;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long iconColor;
    private final long textColor;

    public /* synthetic */ ContextMenuColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private ContextMenuColors(long j, long j2, long j3, long j4, long j5) {
        this.backgroundColor = j;
        this.textColor = j2;
        this.iconColor = j3;
        this.disabledTextColor = j4;
        this.disabledIconColor = j5;
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m166getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m170getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getIconColor-0d7_KjU, reason: not valid java name */
    public final long m169getIconColor0d7_KjU() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m168getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledIconColor-0d7_KjU, reason: not valid java name */
    public final long m167getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextMenuColors)) {
            return false;
        }
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
        return Color.m1367equalsimpl0(this.backgroundColor, contextMenuColors.backgroundColor) && Color.m1367equalsimpl0(this.textColor, contextMenuColors.textColor) && Color.m1367equalsimpl0(this.iconColor, contextMenuColors.iconColor) && Color.m1367equalsimpl0(this.disabledTextColor, contextMenuColors.disabledTextColor) && Color.m1367equalsimpl0(this.disabledIconColor, contextMenuColors.disabledIconColor);
    }

    public int hashCode() {
        return (((((((Color.m1373hashCodeimpl(this.backgroundColor) * 31) + Color.m1373hashCodeimpl(this.textColor)) * 31) + Color.m1373hashCodeimpl(this.iconColor)) * 31) + Color.m1373hashCodeimpl(this.disabledTextColor)) * 31) + Color.m1373hashCodeimpl(this.disabledIconColor);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + ((Object) Color.m1374toStringimpl(this.backgroundColor)) + ", textColor=" + ((Object) Color.m1374toStringimpl(this.textColor)) + ", iconColor=" + ((Object) Color.m1374toStringimpl(this.iconColor)) + ", disabledTextColor=" + ((Object) Color.m1374toStringimpl(this.disabledTextColor)) + ", disabledIconColor=" + ((Object) Color.m1374toStringimpl(this.disabledIconColor)) + ')';
    }
}
