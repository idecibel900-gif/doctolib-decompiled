package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import com.BV.LinearGradient.LinearGradientManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/RelativeLinearGradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", LinearGradientManager.PROP_COLORS, "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "degrees", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors$revenuecatui_defaultsBc8Release", "()Ljava/util/List;", "radians", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RelativeLinearGradient extends GradientBrush {
    private final List<Color> colors;
    private final float degrees;
    private final float radians;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RelativeLinearGradient(List list, List list2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, f, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelativeLinearGradient)) {
            return false;
        }
        RelativeLinearGradient relativeLinearGradient = (RelativeLinearGradient) obj;
        return Intrinsics.areEqual(this.colors, relativeLinearGradient.colors) && Intrinsics.areEqual(this.stops, relativeLinearGradient.stops) && TileMode.m1511equalsimpl0(this.tileMode, relativeLinearGradient.tileMode);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + TileMode.m1512hashCodeimpl(this.tileMode);
    }

    public String toString() {
        return "RelativeLinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", tileMode=" + ((Object) TileMode.m1513toStringimpl(this.tileMode)) + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.properties.GradientBrush
    public List<Color> getColors$revenuecatui_defaultsBc8Release() {
        return this.colors;
    }

    public /* synthetic */ RelativeLinearGradient(List list, List list2, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, f, (i2 & 8) != 0 ? TileMode.Companion.m1514getClamp3opZhB0() : i, null);
    }

    private RelativeLinearGradient(List<Color> colors, List<Float> list, float f, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.stops = list;
        this.tileMode = i;
        float f2 = 360;
        float f3 = (((90 - f) % f2) + f2) % f2;
        this.degrees = f3;
        this.radians = (float) Math.toRadians(f3);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1352createShaderuvyYCjk(long size) {
        float f;
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(Size.m1261getWidthimpl(size), d)) + ((float) Math.pow(Size.m1259getHeightimpl(size), d)));
        float fAcos = (float) Math.acos(Size.m1261getWidthimpl(size) / fSqrt);
        float f2 = this.degrees;
        if ((f2 > 90.0f && f2 < 180.0f) || (f2 > 270.0f && f2 < 360.0f)) {
            f = 3.1415927f - this.radians;
        } else {
            f = this.radians;
        }
        float fAbs = Math.abs(((float) Math.cos(f - fAcos)) * fSqrt) / 2;
        float fCos = ((float) Math.cos(this.radians)) * fAbs;
        float fSin = fAbs * ((float) Math.sin(this.radians));
        return ShaderKt.m1483LinearGradientShaderVjE6UOU(Offset.m1228plusMKHz9U(SizeKt.m1268getCenteruvyYCjk(size), OffsetKt.Offset(-fCos, fSin)), Offset.m1228plusMKHz9U(SizeKt.m1268getCenteruvyYCjk(size), OffsetKt.Offset(fCos, -fSin)), getColors$revenuecatui_defaultsBc8Release(), this.stops, this.tileMode);
    }
}
