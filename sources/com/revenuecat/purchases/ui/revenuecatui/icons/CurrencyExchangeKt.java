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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"CurrencyExchange", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getCurrencyExchange", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_Currency_exchange", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurrencyExchangeKt {
    private static ImageVector _Currency_exchange;

    public static final ImageVector getCurrencyExchange() {
        ImageVector imageVector = _Currency_exchange;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        float f = 24;
        ImageVector.Builder builder = new ImageVector.Builder("CurrencyExchange", Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f), 960.0f, 960.0f, 0L, 0, false, 224, null);
        SolidColor solidColor = new SolidColor(Color.Companion.m1376getBlack0d7_KjU(), null);
        int iM1500getButtKaPHkGw = StrokeCap.Companion.m1500getButtKaPHkGw();
        int iM1508getMiterLxFBmk8 = StrokeJoin.Companion.m1508getMiterLxFBmk8();
        int iM1468getNonZeroRgk1Os = PathFillType.Companion.m1468getNonZeroRgk1Os();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(480.0f, 920.0f);
        pathBuilder.quadToRelative(-112.0f, 0.0f, -206.0f, -51.0f);
        pathBuilder.reflectiveQuadTo(120.0f, 733.0f);
        pathBuilder.verticalLineToRelative(107.0f);
        pathBuilder.horizontalLineTo(40.0f);
        pathBuilder.verticalLineToRelative(-240.0f);
        pathBuilder.horizontalLineToRelative(240.0f);
        pathBuilder.verticalLineToRelative(80.0f);
        pathBuilder.horizontalLineToRelative(-99.0f);
        pathBuilder.quadToRelative(48.0f, 72.0f, 126.5f, 116.0f);
        pathBuilder.reflectiveQuadTo(480.0f, 840.0f);
        pathBuilder.quadToRelative(75.0f, 0.0f, 140.5f, -28.5f);
        pathBuilder.reflectiveQuadToRelative(114.0f, -77.0f);
        pathBuilder.reflectiveQuadToRelative(77.0f, -114.0f);
        pathBuilder.reflectiveQuadTo(840.0f, 480.0f);
        pathBuilder.horizontalLineToRelative(80.0f);
        pathBuilder.quadToRelative(0.0f, 91.0f, -34.5f, 171.0f);
        pathBuilder.reflectiveQuadTo(791.0f, 791.0f);
        pathBuilder.reflectiveQuadTo(651.0f, 885.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 920.0f);
        pathBuilder.moveToRelative(-36.0f, -160.0f);
        pathBuilder.verticalLineToRelative(-52.0f);
        pathBuilder.quadToRelative(-47.0f, -11.0f, -76.5f, -40.5f);
        pathBuilder.reflectiveQuadTo(324.0f, 590.0f);
        pathBuilder.lineToRelative(66.0f, -26.0f);
        pathBuilder.quadToRelative(12.0f, 41.0f, 37.5f, 61.5f);
        pathBuilder.reflectiveQuadTo(486.0f, 646.0f);
        pathBuilder.reflectiveQuadToRelative(56.5f, -15.5f);
        pathBuilder.reflectiveQuadTo(566.0f, 582.0f);
        pathBuilder.quadToRelative(0.0f, -29.0f, -24.5f, -47.0f);
        pathBuilder.reflectiveQuadTo(454.0f, 494.0f);
        pathBuilder.quadToRelative(-59.0f, -21.0f, -86.5f, -50.0f);
        pathBuilder.reflectiveQuadTo(340.0f, 368.0f);
        pathBuilder.quadToRelative(0.0f, -41.0f, 28.5f, -74.5f);
        pathBuilder.reflectiveQuadTo(446.0f, 250.0f);
        pathBuilder.verticalLineToRelative(-50.0f);
        pathBuilder.horizontalLineToRelative(70.0f);
        pathBuilder.verticalLineToRelative(50.0f);
        pathBuilder.quadToRelative(36.0f, 3.0f, 65.5f, 29.0f);
        pathBuilder.reflectiveQuadToRelative(40.5f, 61.0f);
        pathBuilder.lineToRelative(-64.0f, 26.0f);
        pathBuilder.quadToRelative(-8.0f, -23.0f, -26.0f, -38.5f);
        pathBuilder.reflectiveQuadTo(482.0f, 312.0f);
        pathBuilder.quadToRelative(-35.0f, 0.0f, -53.5f, 15.0f);
        pathBuilder.reflectiveQuadTo(410.0f, 368.0f);
        pathBuilder.reflectiveQuadToRelative(23.0f, 41.0f);
        pathBuilder.reflectiveQuadToRelative(83.0f, 35.0f);
        pathBuilder.quadToRelative(72.0f, 26.0f, 96.0f, 61.0f);
        pathBuilder.reflectiveQuadToRelative(24.0f, 77.0f);
        pathBuilder.quadToRelative(0.0f, 29.0f, -10.0f, 51.0f);
        pathBuilder.reflectiveQuadToRelative(-26.5f, 37.5f);
        pathBuilder.reflectiveQuadToRelative(-38.5f, 25.0f);
        pathBuilder.reflectiveQuadToRelative(-47.0f, 14.5f);
        pathBuilder.verticalLineToRelative(50.0f);
        pathBuilder.close();
        pathBuilder.moveTo(40.0f, 480.0f);
        pathBuilder.quadToRelative(0.0f, -91.0f, 34.5f, -171.0f);
        pathBuilder.reflectiveQuadTo(169.0f, 169.0f);
        pathBuilder.reflectiveQuadToRelative(140.0f, -94.5f);
        pathBuilder.reflectiveQuadTo(480.0f, 40.0f);
        pathBuilder.quadToRelative(112.0f, 0.0f, 206.0f, 51.0f);
        pathBuilder.reflectiveQuadToRelative(154.0f, 136.0f);
        pathBuilder.verticalLineToRelative(-107.0f);
        pathBuilder.horizontalLineToRelative(80.0f);
        pathBuilder.verticalLineToRelative(240.0f);
        pathBuilder.horizontalLineTo(680.0f);
        pathBuilder.verticalLineToRelative(-80.0f);
        pathBuilder.horizontalLineToRelative(99.0f);
        pathBuilder.quadToRelative(-48.0f, -72.0f, -126.5f, -116.0f);
        pathBuilder.reflectiveQuadTo(480.0f, 120.0f);
        pathBuilder.quadToRelative(-75.0f, 0.0f, -140.5f, 28.5f);
        pathBuilder.reflectiveQuadToRelative(-114.0f, 77.0f);
        pathBuilder.reflectiveQuadToRelative(-77.0f, 114.0f);
        pathBuilder.reflectiveQuadTo(120.0f, 480.0f);
        pathBuilder.close();
        builder.m1652addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : iM1468getNonZeroRgk1Os, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1500getButtKaPHkGw, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1508getMiterLxFBmk8, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector imageVectorBuild = builder.build();
        _Currency_exchange = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
