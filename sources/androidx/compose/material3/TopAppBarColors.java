package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarColors {
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    private TopAppBarColors(long j, long j2, long j3, long j4, long j5) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
    }

    /* JADX INFO: renamed from: getNavigationIconContentColor-0d7_KjU, reason: not valid java name */
    public final long m857getNavigationIconContentColor0d7_KjU() {
        return this.navigationIconContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m858getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: getActionIconContentColor-0d7_KjU, reason: not valid java name */
    public final long m856getActionIconContentColor0d7_KjU() {
        return this.actionIconContentColor;
    }

    /* JADX INFO: renamed from: copy-t635Npw, reason: not valid java name */
    public final TopAppBarColors m855copyt635Npw(long j, long j2, long j3, long j4, long j5) {
        return new TopAppBarColors(j != 16 ? j : this.containerColor, j2 != 16 ? j2 : this.scrolledContainerColor, j3 != 16 ? j3 : this.navigationIconContentColor, j4 != 16 ? j4 : this.titleContentColor, j5 != 16 ? j5 : this.actionIconContentColor, null);
    }

    /* JADX INFO: renamed from: containerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m854containerColorvNxB06k$material3_release(float f) {
        return ColorKt.m1391lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.m1367equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m1367equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m1367equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m1367equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m1367equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor);
    }

    public int hashCode() {
        return (((((((Color.m1373hashCodeimpl(this.containerColor) * 31) + Color.m1373hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m1373hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m1373hashCodeimpl(this.titleContentColor)) * 31) + Color.m1373hashCodeimpl(this.actionIconContentColor);
    }
}
