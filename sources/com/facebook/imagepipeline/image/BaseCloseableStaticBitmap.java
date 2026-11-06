package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;

/* JADX INFO: loaded from: classes3.dex */
public class BaseCloseableStaticBitmap extends BaseCloseableImage implements CloseableStaticBitmap {
    private static boolean sUseSimpleCloseableStaticBitmap = false;
    private volatile Bitmap mBitmap;
    private CloseableReference mBitmapReference;
    private final int mExifOrientation;
    private final QualityInfo mQualityInfo;
    private final int mRotationAngle;

    protected BaseCloseableStaticBitmap(Bitmap bitmap, ResourceReleaser resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser));
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    protected BaseCloseableStaticBitmap(CloseableReference closeableReference, QualityInfo qualityInfo, int i, int i2) {
        CloseableReference closeableReference2 = (CloseableReference) Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.mBitmapReference = closeableReference2;
        this.mBitmap = (Bitmap) closeableReference2.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference closeableReferenceDetachBitmapReference = detachBitmapReference();
        if (closeableReferenceDetachBitmapReference != null) {
            closeableReferenceDetachBitmapReference.close();
        }
    }

    private synchronized CloseableReference detachBitmapReference() {
        CloseableReference closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.mBitmapReference == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int i;
        if (this.mRotationAngle % SensibleDefaults.X_OFFSET != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapHeight(this.mBitmap);
        }
        return getBitmapWidth(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int i;
        if (this.mRotationAngle % SensibleDefaults.X_OFFSET != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapWidth(this.mBitmap);
        }
        return getBitmapHeight(this.mBitmap);
    }

    private static int getBitmapWidth(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int getBitmapHeight(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    @Override // com.facebook.imagepipeline.image.BaseCloseableImage, com.facebook.imagepipeline.image.CloseableImage
    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }

    public static boolean shouldUseSimpleCloseableStaticBitmap() {
        return sUseSimpleCloseableStaticBitmap;
    }
}
