package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
abstract class GlideBitmapFactory {
    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options);
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            return imageReader.hasJpegMpf();
        } catch (IOException unused) {
            return false;
        }
    }

    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.checkArgument(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream != null) {
                try {
                    Bitmap bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeStream);
                    bitmapDecodeStream.recycle();
                    options.inPreferredConfig = config2;
                    return bitmapSafeDecodeBitmapWithGainmap;
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmapDecodeStream != null) {
                        bitmapDecodeStream.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            }
            if (bitmapDecodeStream != null) {
                bitmapDecodeStream.recycle();
            }
            options.inPreferredConfig = config2;
            return null;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.checkArgument(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor != null) {
                try {
                    Bitmap bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeFileDescriptor);
                    bitmapDecodeFileDescriptor.recycle();
                    options.inPreferredConfig = config2;
                    return bitmapSafeDecodeBitmapWithGainmap;
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmapDecodeFileDescriptor != null) {
                        bitmapDecodeFileDescriptor.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            }
            if (bitmapDecodeFileDescriptor != null) {
                bitmapDecodeFileDescriptor.recycle();
            }
            options.inPreferredConfig = config2;
            return null;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }

    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    private static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmapM = GlideBitmapFactory$GainmapCopier$$ExternalSyntheticApiModelOutline0.m(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmapM.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmapM.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmapM.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmapM.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmapM.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmapM.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmapM.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmapM;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier() { // from class: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory$GainmapDecoderWorkaroundStateCalculator$$ExternalSyntheticLambda0
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public final Object get() {
                return Boolean.valueOf(GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.calculateNeedsGainmapDecodeWorkaround());
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return ((Boolean) REQUIRES_GAIN_MAP_FIX.get()).booleanValue();
            }
            return false;
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z = bitmapCopy == null;
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z;
        }
    }
}
