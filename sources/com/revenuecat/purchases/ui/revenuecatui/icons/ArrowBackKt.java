package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"ArrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getArrowBack", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_arrowBack", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    public static final ImageVector getArrowBack() {
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.ArrowBack", Dp.m2551constructorimpl(24.0f), Dp.m2551constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1376getBlack0d7_KjU(), null);
        int iM1500getButtKaPHkGw = StrokeCap.Companion.m1500getButtKaPHkGw();
        int iM1507getBevelLxFBmk8 = StrokeJoin.Companion.m1507getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 11.0f);
        pathBuilder.horizontalLineTo(7.83f);
        pathBuilder.lineToRelative(5.59f, -5.59f);
        pathBuilder.lineTo(12.0f, 4.0f);
        pathBuilder.lineToRelative(-8.0f, 8.0f);
        pathBuilder.lineToRelative(8.0f, 8.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(7.83f, 13.0f);
        pathBuilder.horizontalLineTo(20.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m1652addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1500getButtKaPHkGw, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1507getBevelLxFBmk8, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) != 0 ? 0.0f : 0.0f).build();
        _arrowBack = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
