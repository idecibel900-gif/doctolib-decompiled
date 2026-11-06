package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloseKt {
    private static ImageVector _close;

    public static final ImageVector getClose(Icons$Filled icons$Filled) {
        ImageVector imageVector = _close;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Close", Dp.m2551constructorimpl(24.0f), Dp.m2551constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1376getBlack0d7_KjU(), null);
        int iM1500getButtKaPHkGw = StrokeCap.Companion.m1500getButtKaPHkGw();
        int iM1507getBevelLxFBmk8 = StrokeJoin.Companion.m1507getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 6.41f);
        pathBuilder.lineTo(17.59f, 5.0f);
        pathBuilder.lineTo(12.0f, 10.59f);
        pathBuilder.lineTo(6.41f, 5.0f);
        pathBuilder.lineTo(5.0f, 6.41f);
        pathBuilder.lineTo(10.59f, 12.0f);
        pathBuilder.lineTo(5.0f, 17.59f);
        pathBuilder.lineTo(6.41f, 19.0f);
        pathBuilder.lineTo(12.0f, 13.41f);
        pathBuilder.lineTo(17.59f, 19.0f);
        pathBuilder.lineTo(19.0f, 17.59f);
        pathBuilder.lineTo(13.41f, 12.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m1652addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1500getButtKaPHkGw, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1507getBevelLxFBmk8, (14336 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) != 0 ? 0.0f : 0.0f).build();
        _close = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
