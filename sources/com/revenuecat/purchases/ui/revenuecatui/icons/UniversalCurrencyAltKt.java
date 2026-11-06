package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"UniversalCurrencyAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getUniversalCurrencyAlt", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_Universal_currency_alt", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UniversalCurrencyAltKt {
    private static ImageVector _Universal_currency_alt;

    public static final ImageVector getUniversalCurrencyAlt() {
        ImageVector imageVector = _Universal_currency_alt;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        float f = 24;
        ImageVector.Builder builder = new ImageVector.Builder("UniversalCurrencyAlt", Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f), 960.0f, 960.0f, 0L, 0, false, 224, null);
        SolidColor solidColor = new SolidColor(Color.Companion.m1376getBlack0d7_KjU(), null);
        int iM1500getButtKaPHkGw = StrokeCap.Companion.m1500getButtKaPHkGw();
        int iM1508getMiterLxFBmk8 = StrokeJoin.Companion.m1508getMiterLxFBmk8();
        int iM1468getNonZeroRgk1Os = PathFillType.Companion.m1468getNonZeroRgk1Os();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(600.0f, 640.0f);
        pathBuilder.horizontalLineToRelative(160.0f);
        pathBuilder.verticalLineToRelative(-160.0f);
        pathBuilder.horizontalLineToRelative(-60.0f);
        pathBuilder.verticalLineToRelative(100.0f);
        pathBuilder.horizontalLineTo(600.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(-120.0f, -40.0f);
        pathBuilder.quadToRelative(50.0f, 0.0f, 85.0f, -35.0f);
        pathBuilder.reflectiveQuadToRelative(35.0f, -85.0f);
        pathBuilder.reflectiveQuadToRelative(-35.0f, -85.0f);
        pathBuilder.reflectiveQuadToRelative(-85.0f, -35.0f);
        pathBuilder.reflectiveQuadToRelative(-85.0f, 35.0f);
        pathBuilder.reflectiveQuadToRelative(-35.0f, 85.0f);
        pathBuilder.reflectiveQuadToRelative(35.0f, 85.0f);
        pathBuilder.reflectiveQuadToRelative(85.0f, 35.0f);
        pathBuilder.moveTo(200.0f, 480.0f);
        pathBuilder.horizontalLineToRelative(60.0f);
        pathBuilder.verticalLineToRelative(-100.0f);
        pathBuilder.horizontalLineToRelative(100.0f);
        pathBuilder.verticalLineToRelative(-60.0f);
        pathBuilder.horizontalLineTo(200.0f);
        pathBuilder.close();
        pathBuilder.moveTo(80.0f, 760.0f);
        pathBuilder.verticalLineToRelative(-560.0f);
        pathBuilder.horizontalLineToRelative(800.0f);
        pathBuilder.verticalLineToRelative(560.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(80.0f, -80.0f);
        pathBuilder.horizontalLineToRelative(640.0f);
        pathBuilder.verticalLineToRelative(-400.0f);
        pathBuilder.horizontalLineTo(160.0f);
        pathBuilder.close();
        pathBuilder.moveToRelative(0.0f, 0.0f);
        pathBuilder.verticalLineToRelative(-400.0f);
        pathBuilder.close();
        builder.m1652addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : iM1468getNonZeroRgk1Os, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1500getButtKaPHkGw, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1508getMiterLxFBmk8, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector imageVectorBuild = builder.build();
        _Universal_currency_alt = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
