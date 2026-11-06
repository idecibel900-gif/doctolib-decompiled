package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JpegTranscoderUtils {
    public static final JpegTranscoderUtils INSTANCE = new JpegTranscoderUtils();
    public static final ImmutableList INVERTED_EXIF_ORIENTATIONS;

    public static final boolean isExifOrientationAllowed(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static final int roundNumerator(float f, float f2) {
        return (int) (f2 + (f * 8));
    }

    private JpegTranscoderUtils() {
    }

    static {
        ImmutableList immutableListOf = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
        Intrinsics.checkNotNullExpressionValue(immutableListOf, "of(...)");
        INVERTED_EXIF_ORIENTATIONS = immutableListOf;
    }

    public static final boolean isRotationAngleAllowed(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static final int getSoftwareNumerator(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (!z || resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        int forceRotatedInvertedExifOrientation = INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation())) ? getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage) : 0;
        boolean z2 = rotationAngle == 90 || rotationAngle == 270 || forceRotatedInvertedExifOrientation == 5 || forceRotatedInvertedExifOrientation == 7;
        int iRoundNumerator = roundNumerator(determineResizeRatio(resizeOptions, z2 ? encodedImage.getHeight() : encodedImage.getWidth(), z2 ? encodedImage.getWidth() : encodedImage.getHeight()), resizeOptions.roundUpFraction);
        if (iRoundNumerator > 8) {
            return 8;
        }
        if (iRoundNumerator < 1) {
            return 1;
        }
        return iRoundNumerator;
    }

    public static final int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int iExtractOrientationFromMetadata = INSTANCE.extractOrientationFromMetadata(encodedImage);
        return rotationOptions.useImageMetadata() ? iExtractOrientationFromMetadata : (iExtractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        int exifOrientation = encodedImage.getExifOrientation();
        ImmutableList immutableList = INVERTED_EXIF_ORIENTATIONS;
        int iIndexOf = immutableList.indexOf(Integer.valueOf(exifOrientation));
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        E e = immutableList.get((iIndexOf + ((!rotationOptions.useImageMetadata() ? rotationOptions.getForcedAngle() : 0) / 90)) % immutableList.size());
        Intrinsics.checkNotNullExpressionValue(e, "get(...)");
        return ((Number) e).intValue();
    }

    public static final float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(resizeOptions.width / f, resizeOptions.height / f2);
        float f3 = f * fMax;
        float f4 = resizeOptions.maxBitmapDimension;
        if (f3 > f4) {
            fMax = f4 / f;
        }
        return f2 * fMax > f4 ? f4 / f2 : fMax;
    }

    public static final int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }

    public static final Matrix getTransformationMatrix(EncodedImage encodedImage, RotationOptions rotationOptions) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
            return INSTANCE.getTransformationMatrixFromInvertedExif(getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage));
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        if (rotationAngle == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(rotationAngle);
        return matrix;
    }

    private final Matrix getTransformationMatrixFromInvertedExif(int i) {
        Matrix matrix = new Matrix();
        if (i == 2) {
            matrix.setScale(-1.0f, 1.0f);
            return matrix;
        }
        if (i == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
            return matrix;
        }
        if (i == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
            return matrix;
        }
        if (i != 5) {
            return null;
        }
        matrix.setRotate(90.0f);
        matrix.postScale(-1.0f, 1.0f);
        return matrix;
    }

    private final int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            return encodedImage.getRotationAngle();
        }
        return 0;
    }
}
