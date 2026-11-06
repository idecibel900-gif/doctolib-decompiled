package com.canhub.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.canhub.cropper.utils.GetUriForFileKt;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapUtils {
    private static int mMaxTextureSize;
    private static Pair mStateBitmap;
    public static final BitmapUtils INSTANCE = new BitmapUtils();
    private static final Rect EMPTY_RECT = new Rect();
    private static final RectF EMPTY_RECT_F = new RectF();
    private static final RectF RECT = new RectF();
    private static final float[] POINTS = new float[6];
    private static final float[] POINTS2 = new float[6];

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BitmapUtils() {
    }

    public final Rect getEMPTY_RECT() {
        return EMPTY_RECT;
    }

    public final RectF getEMPTY_RECT_F() {
        return EMPTY_RECT_F;
    }

    public final RectF getRECT() {
        return RECT;
    }

    public final float[] getPOINTS() {
        return POINTS;
    }

    public final float[] getPOINTS2() {
        return POINTS2;
    }

    public final Pair getMStateBitmap() {
        return mStateBitmap;
    }

    public final void setMStateBitmap(Pair pair) {
        mStateBitmap = pair;
    }

    public final RotateBitmapResult orientateBitmapByExif(Bitmap bitmap, Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ExifInterface exifInterface = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    ExifInterface exifInterface2 = new ExifInterface(inputStreamOpenInputStream);
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                    exifInterface = exifInterface2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (exifInterface != null) {
            return orientateBitmapByExif(bitmap, exifInterface);
        }
        return new RotateBitmapResult(bitmap, 0, false, false);
    }

    public final RotateBitmapResult orientateBitmapByExif(Bitmap bitmap, ExifInterface exif) {
        int i;
        Intrinsics.checkNotNullParameter(exif, "exif");
        boolean z = true;
        int attributeInt = exif.getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            i = SensibleDefaults.X_OFFSET;
        } else if (attributeInt == 5 || attributeInt == 6 || attributeInt == 7) {
            i = 90;
        } else {
            i = attributeInt != 8 ? 0 : 270;
        }
        boolean z2 = attributeInt == 2 || attributeInt == 5;
        if (attributeInt != 4 && attributeInt != 7) {
            z = false;
        }
        return new RotateBitmapResult(bitmap, i, z2, z);
    }

    public final BitmapSampled decodeSampledBitmap(Context context, Uri uri, int i, int i2) throws CropException.FailedToLoadBitmap {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(contentResolver);
            BitmapFactory.Options optionsDecodeImageForOption = decodeImageForOption(contentResolver, uri);
            int i3 = optionsDecodeImageForOption.outWidth;
            if (i3 == -1 && optionsDecodeImageForOption.outHeight == -1) {
                throw new RuntimeException("File is not a picture");
            }
            optionsDecodeImageForOption.inSampleSize = Math.max(calculateInSampleSizeByRequestedSize(i3, optionsDecodeImageForOption.outHeight, i, i2), calculateInSampleSizeByMaxTextureSize(optionsDecodeImageForOption.outWidth, optionsDecodeImageForOption.outHeight));
            return new BitmapSampled(decodeImage(contentResolver, uri, optionsDecodeImageForOption), optionsDecodeImageForOption.inSampleSize);
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(uri, e.getMessage());
        }
    }

    public final BitmapSampled cropBitmapObjectHandleOOM(Bitmap bitmap, float[] cropPoints, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(cropPoints, "cropPoints");
        int i4 = 1;
        do {
            try {
                Intrinsics.checkNotNull(bitmap);
                return new BitmapSampled(cropBitmapObjectWithScale(bitmap, cropPoints, i, z, i2, i3, 1 / i4, z2, z3), i4);
            } catch (OutOfMemoryError e) {
                i4 *= 2;
            }
        } while (i4 <= 8);
        throw e;
    }

    private final Bitmap cropBitmapObjectWithScale(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f, boolean z2, boolean z3) {
        float f2 = f;
        Rect rectFromPoints = getRectFromPoints(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        float f3 = z2 ? -f2 : f2;
        if (z3) {
            f2 = -f2;
        }
        matrix.postScale(f3, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rectFromPoints.left, rectFromPoints.top, rectFromPoints.width(), rectFromPoints.height(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (Intrinsics.areEqual(bitmapCreateBitmap, bitmap)) {
            bitmapCreateBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i % 90 != 0 ? cropForRotatedImage(bitmapCreateBitmap, fArr, rectFromPoints, i, z, i2, i3) : bitmapCreateBitmap;
    }

    public final BitmapSampled cropBitmap(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        float[] cropPoints = fArr;
        Intrinsics.checkNotNullParameter(cropPoints, "cropPoints");
        int i8 = 1;
        while (true) {
            try {
                Intrinsics.checkNotNull(uri);
                return cropBitmap(context2, uri, cropPoints, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
            } catch (OutOfMemoryError e) {
                i8 *= 2;
                if (i8 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e.getMessage(), e);
                }
                context2 = context;
                cropPoints = fArr;
            }
        }
    }

    public final float getRectLeft(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.min(Math.min(Math.min(points[0], points[2]), points[4]), points[6]);
    }

    public final float getRectTop(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.min(Math.min(Math.min(points[1], points[3]), points[5]), points[7]);
    }

    public final float getRectRight(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.max(Math.max(Math.max(points[0], points[2]), points[4]), points[6]);
    }

    public final float getRectBottom(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return Math.max(Math.max(Math.max(points[1], points[3]), points[5]), points[7]);
    }

    public final float getRectWidth(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return getRectRight(points) - getRectLeft(points);
    }

    public final float getRectHeight(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return getRectBottom(points) - getRectTop(points);
    }

    public final float getRectCenterX(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return (getRectRight(points) + getRectLeft(points)) / 2.0f;
    }

    public final float getRectCenterY(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return (getRectBottom(points) + getRectTop(points)) / 2.0f;
    }

    public final Rect getRectFromPoints(float[] cropPoints, int i, int i2, boolean z, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cropPoints, "cropPoints");
        Rect rect = new Rect(MathKt.roundToInt(Math.max(0.0f, getRectLeft(cropPoints))), MathKt.roundToInt(Math.max(0.0f, getRectTop(cropPoints))), MathKt.roundToInt(Math.min(i, getRectRight(cropPoints))), MathKt.roundToInt(Math.min(i2, getRectBottom(cropPoints))));
        if (z) {
            fixRectForAspectRatio(rect, i3, i4);
        }
        return rect;
    }

    private final void fixRectForAspectRatio(Rect rect, int i, int i2) {
        if (i != i2 || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    public final Uri writeTempStateStoreBitmap(Context context, Bitmap bitmap, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intrinsics.checkNotNull(bitmap);
            return writeBitmapToUri(context, bitmap, Bitmap.CompressFormat.JPEG, 95, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void validateOutputUri$cropper_release(Uri uri, Bitmap.CompressFormat compressFormat) {
        List listListOf;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        if (!Intrinsics.areEqual(uri.getScheme(), "content")) {
            throw new SecurityException("Only content:// URIs are allowed for security reasons. Received: " + uri.getScheme() + "://");
        }
        String path = uri.getPath();
        if (path == null) {
            path = uri.toString();
            Intrinsics.checkNotNullExpressionValue(path, "toString(...)");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i == 1) {
            listListOf = CollectionsKt.listOf((Object[]) new String[]{".jpg", ".jpeg"});
        } else if (i == 2) {
            listListOf = CollectionsKt.listOf(".png");
        } else {
            listListOf = CollectionsKt.listOf(".webp");
        }
        List list = listListOf;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.endsWith(path, (String) it.next(), true)) {
                    return;
                }
            }
        }
        throw new SecurityException("File extension does not match compress format. Expected one of: " + CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null) + ", Format: " + compressFormat + ", Path: " + path);
    }

    public final Uri writeBitmapToUri(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        Uri uriBuildUri = uri == null ? buildUri(context, compressFormat) : uri;
        if (uri != null) {
            validateOutputUri$cropper_release(uri, compressFormat);
        }
        OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriBuildUri, "wt");
        Intrinsics.checkNotNull(outputStreamOpenOutputStream);
        try {
            bitmap.compress(compressFormat, i, outputStreamOpenOutputStream);
            CloseableKt.closeFinally(outputStreamOpenOutputStream, null);
            return uriBuildUri;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStreamOpenOutputStream, th);
                throw th2;
            }
        }
    }

    private final Uri buildUri(Context context, Bitmap.CompressFormat compressFormat) {
        String str;
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
            if (i == 1) {
                str = ".jpg";
            } else if (i == 2) {
                str = ".png";
            } else {
                str = ".webp";
            }
            if (Build.VERSION.SDK_INT >= 29) {
                File fileCreateTempFile = File.createTempFile("cropped", str, context.getCacheDir());
                Intrinsics.checkNotNull(fileCreateTempFile);
                return GetUriForFileKt.getUriForFile(context, fileCreateTempFile);
            }
            return Uri.fromFile(File.createTempFile("cropped", str, context.getCacheDir()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create temp file for output image", e);
        }
    }

    public final Bitmap resizeBitmap(Bitmap bitmap, int i, int i2, CropImageView.RequestSizeOptions options) {
        Bitmap bitmapCreateScaledBitmap;
        Intrinsics.checkNotNullParameter(options, "options");
        if (i > 0 && i2 > 0) {
            try {
                CropImageView.RequestSizeOptions requestSizeOptions = CropImageView.RequestSizeOptions.RESIZE_FIT;
                if (options == requestSizeOptions || options == CropImageView.RequestSizeOptions.RESIZE_INSIDE || options == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    if (options == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        Intrinsics.checkNotNull(bitmap);
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        Intrinsics.checkNotNull(bitmap);
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float fMax = Math.max(width / i, height / i2);
                        bitmapCreateScaledBitmap = (fMax > 1.0f || options == requestSizeOptions) ? Bitmap.createScaledBitmap(bitmap, (int) (width / fMax), (int) (height / fMax), false) : null;
                    }
                    if (bitmapCreateScaledBitmap != null) {
                        if (!Intrinsics.areEqual(bitmapCreateScaledBitmap, bitmap)) {
                            bitmap.recycle();
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }
            } catch (Exception unused) {
            }
        }
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }

    private final BitmapSampled cropBitmap(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, int i8) {
        int sampleSize;
        Rect rectFromPoints = getRectFromPoints(fArr, i2, i3, z, i4, i5);
        int iWidth = i6 > 0 ? i6 : rectFromPoints.width();
        int iHeight = i7 > 0 ? i7 : rectFromPoints.height();
        Bitmap bitmap = null;
        try {
            BitmapSampled bitmapSampledDecodeSampledBitmapRegion = decodeSampledBitmapRegion(context, uri, rectFromPoints, iWidth, iHeight, i8);
            try {
                bitmap = bitmapSampledDecodeSampledBitmapRegion.getBitmap();
                sampleSize = bitmapSampledDecodeSampledBitmapRegion.getSampleSize();
            } catch (Exception unused) {
                sampleSize = 1;
            }
        } catch (Exception unused2) {
            rectFromPoints = rectFromPoints;
        }
        int i9 = sampleSize;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            try {
                Bitmap bitmapRotateAndFlipBitmapInt = rotateAndFlipBitmapInt(bitmap2, i, z2, z3);
                try {
                    if (i % 90 != 0) {
                        bitmapRotateAndFlipBitmapInt = cropForRotatedImage(bitmapRotateAndFlipBitmapInt, fArr, rectFromPoints, i, z, i4, i5);
                    }
                    return new BitmapSampled(bitmapRotateAndFlipBitmapInt, i9);
                } catch (OutOfMemoryError e) {
                    e = e;
                    bitmap2 = bitmapRotateAndFlipBitmapInt;
                    bitmap2.recycle();
                    throw e;
                }
            } catch (OutOfMemoryError e2) {
                e = e2;
            }
        } else {
            return cropBitmap(context, uri, fArr, i, z, i4, i5, i8, rectFromPoints, iWidth, iHeight, z2, z3);
        }
    }

    private final BitmapSampled cropBitmap(Context context, Uri uri, float[] fArr, int i, boolean z, int i2, int i3, int i4, Rect rect, int i5, int i6, boolean z2, boolean z3) throws Throwable {
        Bitmap bitmap;
        Bitmap bitmapCropBitmapObjectWithScale = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int iCalculateInSampleSizeByRequestedSize = i4 * calculateInSampleSizeByRequestedSize(rect.width(), rect.height(), i5, i6);
            options.inSampleSize = iCalculateInSampleSizeByRequestedSize;
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            Bitmap bitmapDecodeImage = decodeImage(contentResolver, uri, options);
            if (bitmapDecodeImage != null) {
                try {
                    int length = fArr.length;
                    try {
                        float[] fArr2 = new float[length];
                        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                        for (int i7 = 0; i7 < length; i7++) {
                            fArr2[i7] = fArr2[i7] / options.inSampleSize;
                        }
                        bitmap = bitmapDecodeImage;
                        try {
                            bitmapCropBitmapObjectWithScale = cropBitmapObjectWithScale(bitmap, fArr2, i, z, i2, i3, 1.0f, z2, z3);
                            if (!Intrinsics.areEqual(bitmapCropBitmapObjectWithScale, bitmap)) {
                                bitmap.recycle();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (!Intrinsics.areEqual((Object) null, bitmap)) {
                                bitmap.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = bitmapDecodeImage;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bitmap = bitmapDecodeImage;
                }
            }
            return new BitmapSampled(bitmapCropBitmapObjectWithScale, iCalculateInSampleSizeByRequestedSize);
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(uri, e.getMessage());
        } catch (OutOfMemoryError e2) {
            if (0 != 0) {
                bitmapCropBitmapObjectWithScale.recycle();
            }
            throw e2;
        }
    }

    private final BitmapFactory.Options decodeImageForOption(ContentResolver contentResolver, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, EMPTY_RECT, options);
            options.inJustDecodeBounds = false;
            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
            return options;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final Bitmap decodeImage(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) throws CropException.FailedToDecodeImage, IOException {
        do {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, EMPTY_RECT, options);
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                    return bitmapDecodeStream;
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                    throw th2;
                }
            }
        } while (options.inSampleSize <= 512);
        throw new CropException.FailedToDecodeImage(uri);
    }

    private final BitmapSampled decodeSampledBitmapRegion(Context context, Uri uri, Rect rect, int i, int i2, int i3) throws CropException.FailedToLoadBitmap {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        int i4;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3 * calculateInSampleSizeByRequestedSize(rect.width(), rect.height(), i, i2);
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    Intrinsics.checkNotNull(inputStreamOpenInputStream);
                    bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream);
                } else {
                    Intrinsics.checkNotNull(inputStreamOpenInputStream);
                    bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                }
                do {
                    try {
                        try {
                            Intrinsics.checkNotNull(bitmapRegionDecoderNewInstance);
                            BitmapSampled bitmapSampled = new BitmapSampled(bitmapRegionDecoderNewInstance.decodeRegion(rect, options), options.inSampleSize);
                            bitmapRegionDecoderNewInstance.recycle();
                            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                            return bitmapSampled;
                        } catch (OutOfMemoryError unused) {
                            i4 = options.inSampleSize * 2;
                            options.inSampleSize = i4;
                        }
                    } catch (Throwable th) {
                        if (bitmapRegionDecoderNewInstance != null) {
                            bitmapRegionDecoderNewInstance.recycle();
                        }
                        throw th;
                    }
                } while (i4 <= 512);
                if (bitmapRegionDecoderNewInstance != null) {
                    bitmapRegionDecoderNewInstance.recycle();
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                return new BitmapSampled(null, 1);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(inputStreamOpenInputStream, th2);
                    throw th3;
                }
            }
        } catch (Exception e) {
            throw new CropException.FailedToLoadBitmap(uri, e.getMessage());
        }
    }

    private final Bitmap cropForRotatedImage(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int iAbs;
        int iAbs2;
        int iAbs3;
        if (i % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians(i);
        int i4 = (i < 90 || (181 <= i && i < 270)) ? rect.left : rect.right;
        int iAbs4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= fArr.length) {
                iAbs = 0;
                iAbs2 = 0;
                iAbs3 = 0;
                break;
            }
            float f = fArr[i5];
            if (f >= i4 - 1 && f <= i4 + 1) {
                int i6 = i5 + 1;
                iAbs4 = (int) Math.abs(Math.sin(radians) * ((double) (rect.bottom - fArr[i6])));
                iAbs2 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i6] - rect.top)));
                iAbs3 = (int) Math.abs(((double) (fArr[i6] - rect.top)) / Math.sin(radians));
                iAbs = (int) Math.abs(((double) (rect.bottom - fArr[i6])) / Math.cos(radians));
                break;
            }
            i5 += 2;
        }
        rect.set(iAbs4, iAbs2, iAbs3 + iAbs4, iAbs + iAbs2);
        if (z) {
            fixRectForAspectRatio(rect, i2, i3);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (!Intrinsics.areEqual(bitmap, bitmapCreateBitmap)) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private final int calculateInSampleSizeByRequestedSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 <= i4 && i <= i3) {
            return 1;
        }
        while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
            i5 *= 2;
        }
        return i5;
    }

    private final int calculateInSampleSizeByMaxTextureSize(int i, int i2) {
        if (mMaxTextureSize == 0) {
            mMaxTextureSize = getMaxTextureSize();
        }
        int i3 = 1;
        if (mMaxTextureSize <= 0) {
            return 1;
        }
        while (true) {
            int i4 = i2 / i3;
            int i5 = mMaxTextureSize;
            if (i4 <= i5 && i / i3 <= i5) {
                return i3;
            }
            i3 *= 2;
        }
    }

    private final Bitmap rotateAndFlipBitmapInt(Bitmap bitmap, int i, boolean z, boolean z2) {
        if (i <= 0 && !z && !z2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i);
        matrix.postScale(z ? -1 : 1, z2 ? -1 : 1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (!Intrinsics.areEqual(bitmapCreateBitmap, bitmap)) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private final int getMaxTextureSize() {
        try {
            EGL egl = EGLContext.getEGL();
            Intrinsics.checkNotNull(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            EGL10 egl10 = (EGL10) egl;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, null, 0, iArr);
            int i = iArr[0];
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, i, iArr);
            int[] iArr2 = new int[1];
            int i2 = iArr[0];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i4], 12332, iArr2);
                int i5 = iArr2[0];
                if (i3 < i5) {
                    i3 = i5;
                }
            }
            egl10.eglTerminate(eGLDisplayEglGetDisplay);
            return Math.max(i3, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    public static final class BitmapSampled {
        private final Bitmap bitmap;
        private final int sampleSize;

        public BitmapSampled(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.sampleSize = i;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getSampleSize() {
            return this.sampleSize;
        }
    }

    public static final class RotateBitmapResult {
        private final Bitmap bitmap;
        private final int degrees;
        private final boolean flipHorizontally;
        private final boolean flipVertically;

        public RotateBitmapResult(Bitmap bitmap, int i, boolean z, boolean z2) {
            this.bitmap = bitmap;
            this.degrees = i;
            this.flipHorizontally = z;
            this.flipVertically = z2;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getDegrees() {
            return this.degrees;
        }

        public final boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        public final boolean getFlipVertically() {
            return this.flipVertically;
        }
    }
}
