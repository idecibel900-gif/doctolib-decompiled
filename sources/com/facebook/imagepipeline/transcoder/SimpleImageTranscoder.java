package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleImageTranscoder implements ImageTranscoder {
    public static final Companion Companion = new Companion(null);
    private final String identifier = "SimpleImageTranscoder";
    private final int maxBitmapSize;
    private final boolean resizingEnabled;

    public SimpleImageTranscoder(boolean z, int i) {
        this.resizingEnabled = z;
        this.maxBitmapSize = i;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num, ColorSpace colorSpace) throws Throwable {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Integer num2 = num == null ? 85 : num;
        RotationOptions rotationOptionsAutoRotate = rotationOptions == null ? RotationOptions.Companion.autoRotate() : rotationOptions;
        int sampleSize = getSampleSize(encodedImage, rotationOptionsAutoRotate, resizeOptions);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        if (colorSpace != null && Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = colorSpace;
        }
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (bitmapDecodeStream == null) {
                FLog.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            Matrix transformationMatrix = JpegTranscoderUtils.getTransformationMatrix(encodedImage, rotationOptionsAutoRotate);
            if (transformationMatrix != null) {
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), transformationMatrix, false);
                } catch (OutOfMemoryError e) {
                    e = e;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult;
                } catch (Throwable th) {
                    th = th;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    throw th;
                }
            } else {
                bitmapCreateBitmap = bitmapDecodeStream;
            }
            try {
                try {
                    bitmapCreateBitmap.compress(Companion.getOutputFormat(imageFormat), num2.intValue(), outputStream);
                    ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(sampleSize > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult3;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e3) {
            FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e3);
            return new ImageTranscodeResult(2);
        }
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.Companion.autoRotate();
        }
        return this.resizingEnabled && DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.maxBitmapSize) > 1;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return imageFormat == DefaultImageFormats.HEIF || imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return this.identifier;
    }

    private final int getSampleSize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (this.resizingEnabled) {
            return DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.maxBitmapSize);
        }
        return 1;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap.CompressFormat getOutputFormat(ImageFormat imageFormat) {
            if (imageFormat == null) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (imageFormat == DefaultImageFormats.JPEG) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (imageFormat == DefaultImageFormats.PNG) {
                return Bitmap.CompressFormat.PNG;
            }
            if (DefaultImageFormats.isStaticWebpFormat(imageFormat)) {
                return Bitmap.CompressFormat.WEBP;
            }
            return Bitmap.CompressFormat.JPEG;
        }
    }
}
