package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush {
    private final List colors;
    private final long end;
    private final long start;
    private final List stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    private LinearGradient(List list, List list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1348getIntrinsicSizeNHjbRc() {
        float fAbs;
        float fM1223getXimpl = Offset.m1223getXimpl(this.start);
        float fAbs2 = Float.NaN;
        if (Float.isInfinite(fM1223getXimpl) || Float.isNaN(fM1223getXimpl)) {
            fAbs = Float.NaN;
        } else {
            float fM1223getXimpl2 = Offset.m1223getXimpl(this.end);
            if (Float.isInfinite(fM1223getXimpl2) || Float.isNaN(fM1223getXimpl2)) {
                fAbs = Float.NaN;
            } else {
                fAbs = Math.abs(Offset.m1223getXimpl(this.start) - Offset.m1223getXimpl(this.end));
            }
        }
        float fM1224getYimpl = Offset.m1224getYimpl(this.start);
        if (!Float.isInfinite(fM1224getYimpl) && !Float.isNaN(fM1224getYimpl)) {
            float fM1224getYimpl2 = Offset.m1224getYimpl(this.end);
            if (!Float.isInfinite(fM1224getYimpl2) && !Float.isNaN(fM1224getYimpl2)) {
                fAbs2 = Math.abs(Offset.m1224getYimpl(this.start) - Offset.m1224getYimpl(this.end));
            }
        }
        return SizeKt.Size(fAbs, fAbs2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1352createShaderuvyYCjk(long j) {
        return ShaderKt.m1483LinearGradientShaderVjE6UOU(OffsetKt.Offset(Offset.m1223getXimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m1261getWidthimpl(j) : Offset.m1223getXimpl(this.start), Offset.m1224getYimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m1259getHeightimpl(j) : Offset.m1224getYimpl(this.start)), OffsetKt.Offset(Offset.m1223getXimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m1261getWidthimpl(j) : Offset.m1223getXimpl(this.end), Offset.m1224getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m1259getHeightimpl(j) : Offset.m1224getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return Intrinsics.areEqual(this.colors, linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m1220equalsimpl0(this.start, linearGradient.start) && Offset.m1220equalsimpl0(this.end, linearGradient.end) && TileMode.m1511equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m1225hashCodeimpl(this.start)) * 31) + Offset.m1225hashCodeimpl(this.end)) * 31) + TileMode.m1512hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m1236isFinitek4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m1230toStringimpl(this.start)) + ", ";
        } else {
            str = "";
        }
        if (OffsetKt.m1236isFinitek4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m1230toStringimpl(this.end)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m1513toStringimpl(this.tileMode)) + ')';
    }
}
