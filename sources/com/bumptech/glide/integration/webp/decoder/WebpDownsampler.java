package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
public final class WebpDownsampler {
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final List parsers;
    public static final Option DISABLE_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
    public static final Option USE_SYSTEM_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.SystemDecoder", Boolean.TRUE);
    private static final Downsampler.DecodeCallbacks EMPTY_CALLBACKS = new Downsampler.DecodeCallbacks() { // from class: com.bumptech.glide.integration.webp.decoder.WebpDownsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    };
    private static final Queue OPTIONS_QUEUE = Util.createQueue(0);

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public WebpDownsampler(List list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue()) {
            return false;
        }
        if (((Boolean) options.get(USE_SYSTEM_DECODER)).booleanValue()) {
            if (WebpHeaderParser.sIsExtendedWebpSupported) {
                return false;
            }
            WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(inputStream, this.byteArrayPool);
            return WebpHeaderParser.isStaticWebpType(type) && type != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
        }
        return WebpHeaderParser.isStaticWebpType(WebpHeaderParser.getType(inputStream, this.byteArrayPool));
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue()) {
            return false;
        }
        if (((Boolean) options.get(USE_SYSTEM_DECODER)).booleanValue()) {
            if (WebpHeaderParser.sIsExtendedWebpSupported) {
                return false;
            }
            WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(byteBuffer);
            return WebpHeaderParser.isStaticWebpType(type) && type != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
        }
        return WebpHeaderParser.isStaticWebpType(WebpHeaderParser.getType(byteBuffer));
    }

    public Resource decode(InputStream inputStream, int i, int i2, Options options) {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource decode(InputStream inputStream, int i, int i2, Options options, Downsampler.DecodeCallbacks decodeCallbacks) {
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(Downsampler.DOWNSAMPLE_STRATEGY);
        boolean zBooleanValue = ((Boolean) options.get(Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = Downsampler.ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, downsampleStrategy, decodeFormat, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i, i2, zBooleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr, byte[].class);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, Downsampler.DecodeCallbacks decodeCallbacks) throws IOException {
        int i3;
        int i4;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, this.bitmapPool);
        int i5 = dimensions[0];
        int i6 = dimensions[1];
        String str = options.outMimeType;
        boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean zIsExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i7 = i == Integer.MIN_VALUE ? i5 : i;
        if (i2 == Integer.MIN_VALUE) {
            i4 = i7;
            i3 = i6;
        } else {
            int i8 = i7;
            i3 = i2;
            i4 = i8;
        }
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool);
        calculateScaling(type, inputStream, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i5, i6, i4, i3, options);
        int i9 = i4;
        int iRound = i3;
        calculateConfig(inputStream, decodeFormat, z3, zIsExifOrientationRequired, options, i9, iRound);
        if (shouldUsePool(type)) {
            if (!z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                float f2 = options.inSampleSize;
                int iCeil = (int) Math.ceil(i5 / f2);
                int iCeil2 = (int) Math.ceil(i6 / f2);
                int iRound2 = Math.round(iCeil * f);
                iRound = Math.round(iCeil2 * f);
                i9 = iRound2;
            }
            if (i9 > 0 && iRound > 0) {
                setInBitmap(options, this.bitmapPool, i9, iRound);
            }
        }
        Bitmap bitmapDecodeStream = decodeStream(inputStream, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, bitmapDecodeStream);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            logDecode(i5, i6, str, options, bitmapDecodeStream, i, i2, logTime);
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        bitmapDecodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap bitmapRotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, bitmapDecodeStream, orientation);
        if (!bitmapDecodeStream.equals(bitmapRotateImageExif)) {
            this.bitmapPool.put(bitmapDecodeStream);
        }
        return bitmapRotateImageExif;
    }

    static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float scaleFactor;
        int iMin;
        int iFloor;
        int iFloor2;
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        if (i == 90 || i == 270) {
            scaleFactor = downsampleStrategy.getScaleFactor(i3, i2, i4, i5);
        } else {
            scaleFactor = downsampleStrategy.getScaleFactor(i2, i3, i4, i5);
        }
        if (scaleFactor <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i2, i3, i4, i5);
        if (sampleSizeRounding == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i2;
        float f2 = i3;
        int iRound = i2 / round(scaleFactor * f);
        int iRound2 = i3 / round(scaleFactor * f2);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        if (sampleSizeRounding == sampleSizeRounding2) {
            iMin = Math.max(iRound, iRound2);
        } else {
            iMin = Math.min(iRound, iRound2);
        }
        int iMax = Math.max(1, Integer.highestOneBit(iMin));
        if (sampleSizeRounding == sampleSizeRounding2 && iMax < 1.0f / scaleFactor) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f / fMin);
            iFloor2 = (int) Math.ceil(f2 / fMin);
            int i6 = iMax / 8;
            if (i6 > 0) {
                iFloor /= i6;
                iFloor2 /= i6;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f3 = iMax;
            iFloor = (int) Math.floor(f / f3);
            iFloor2 = (int) Math.floor(f2 / f3);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            float f4 = iMax;
            iFloor = Math.round(f / f4);
            iFloor2 = Math.round(f2 / f4);
        } else if (i2 % iMax != 0 || i3 % iMax != 0) {
            int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, bitmapPool);
            iFloor = dimensions[0];
            iFloor2 = dimensions[1];
        } else {
            iFloor = i2 / iMax;
            iFloor2 = i3 / iMax;
        }
        options.inTargetDensity = adjustTargetDensityForError(downsampleStrategy.getScaleFactor(iFloor, iFloor2, i4, i5));
        options.inDensity = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int iRound = round(1.0E9d * d);
        return round((d / ((double) (iRound / 1.0E9f))) * ((double) iRound));
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean zHasAlpha;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable("WebpDownsampler", 3)) {
                Objects.toString(decodeFormat);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto La
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto Ld
        La:
            r7.onObtainBounds()
        Ld:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r7 = com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeStream(r5, r3, r6)     // Catch: java.lang.IllegalArgumentException -> L2e java.lang.Throwable -> L4f
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r8.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L2d
            r5.reset()
        L2d:
            return r7
        L2e:
            r4 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r4, r0, r1, r2, r6)     // Catch: java.lang.Throwable -> L4f
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L4e
            r5.reset()     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L4f
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L4f
            r8.put(r1)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L4f
            r6.inBitmap = r3     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L4f
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch: java.io.IOException -> L4d java.lang.Throwable -> L4f
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L4d:
            throw r0     // Catch: java.lang.Throwable -> L4f
        L4e:
            throw r0     // Catch: java.lang.Throwable -> L4f
        L4f:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.decoder.WebpDownsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        getBitmapString(bitmap);
        getInBitmapString(options);
        int i5 = options.inSampleSize;
        Thread.currentThread().getName();
        LogTime.getElapsedMillis(j);
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = bitmapPool.getDirty(i, i2, options.inPreferredConfig);
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options options;
        Queue queue = OPTIONS_QUEUE;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            resetOptions(options);
        }
        return options;
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
