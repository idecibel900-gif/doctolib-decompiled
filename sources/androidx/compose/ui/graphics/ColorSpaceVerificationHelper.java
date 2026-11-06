package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Rgb.TransferParameters transferParametersM;
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSrgb())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAces())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAcescg())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAdobeRgb())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt2020())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt709())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieLab())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieXyz())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDciP3())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDisplayP3())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getNtsc1953())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getProPhotoRgb())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSmpteC())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (colorSpace instanceof Rgb) {
            Rgb rgb = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = rgb.getWhitePoint().toXyz$ui_graphics_release();
            TransferParameters transferParameters = rgb.getTransferParameters();
            if (transferParameters != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline3.m();
                transferParametersM = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline0.m(transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
            } else {
                transferParametersM = null;
            }
            if (transferParametersM != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline4.m();
                return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline1.m(colorSpace.getName(), rgb.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, transferParametersM);
            }
            ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline4.m();
            String name = colorSpace.getName();
            float[] primaries$ui_graphics_release = rgb.getPrimaries$ui_graphics_release();
            final Function1 oetf = rgb.getOetf();
            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda30
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d) {
                    return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(oetf, d);
                }
            };
            final Function1 eotf = rgb.getEotf();
            return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline2.m(name, primaries$ui_graphics_release, xyz$ui_graphics_release, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda31
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d) {
                    return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(eotf, d);
                }
            }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0));
        }
        return ColorSpace.get(ColorSpace.Named.SRGB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace colorSpace) {
        WhitePoint whitePoint;
        int id = colorSpace.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline22.m(colorSpace)) {
            ColorSpace.Rgb rgbM = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline5.m(colorSpace);
            ColorSpace.Rgb.TransferParameters transferParameters = rgbM.getTransferParameters();
            if (rgbM.getWhitePoint().length == 3) {
                whitePoint = new WhitePoint(rgbM.getWhitePoint()[0], rgbM.getWhitePoint()[1], rgbM.getWhitePoint()[2]);
            } else {
                whitePoint = new WhitePoint(rgbM.getWhitePoint()[0], rgbM.getWhitePoint()[1]);
            }
            return new Rgb(rgbM.getName(), rgbM.getPrimaries(), whitePoint, rgbM.getTransform(), new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda32
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    return ColorSpaceVerificationHelper.composeColorSpace$lambda$2(colorSpace, d);
                }
            }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda33
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    return ColorSpaceVerificationHelper.composeColorSpace$lambda$3(colorSpace, d);
                }
            }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0), transferParameters != null ? new TransferParameters(transferParameters.g, transferParameters.a, transferParameters.b, transferParameters.c, transferParameters.d, transferParameters.e, transferParameters.f) : null, rgbM.getId());
        }
        return ColorSpaces.INSTANCE.getSrgb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d) {
        return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline5.m(colorSpace).getOetf().applyAsDouble(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d) {
        return ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline5.m(colorSpace).getEotf().applyAsDouble(d);
    }
}
