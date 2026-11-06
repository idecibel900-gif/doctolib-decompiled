package expo.modules.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.RequestManager;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.records.ContentPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoImageView extends AppCompatImageView {
    private ContentFit contentFit;
    private ContentPosition contentPosition;
    private ImageViewWrapperTarget currentTarget;
    private boolean isPlaceholder;
    private ContentFit placeholderContentFit;
    private boolean transformationMatrixChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipToOutline(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.contentFit = ContentFit.Cover;
        this.placeholderContentFit = ContentFit.ScaleDown;
        this.contentPosition = ContentPosition.INSTANCE.getCenter();
    }

    public final ImageViewWrapperTarget getCurrentTarget() {
        return this.currentTarget;
    }

    public final void setCurrentTarget(ImageViewWrapperTarget imageViewWrapperTarget) {
        this.currentTarget = imageViewWrapperTarget;
    }

    public final boolean isPlaceholder() {
        return this.isPlaceholder;
    }

    public final void setPlaceholder(boolean z) {
        this.isPlaceholder = z;
    }

    public final ImageViewWrapperTarget recycleView() {
        setImageDrawable(null);
        ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
        if (imageViewWrapperTarget != null) {
            imageViewWrapperTarget.setUsed(false);
        } else {
            imageViewWrapperTarget = null;
        }
        this.currentTarget = null;
        setVisibility(8);
        this.isPlaceholder = false;
        return imageViewWrapperTarget;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        applyTransformationMatrix();
    }

    public final void applyTransformationMatrix() {
        if (getDrawable() == null) {
            return;
        }
        if (this.isPlaceholder) {
            Drawable drawable = getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
            ContentFit contentFit = this.placeholderContentFit;
            ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
            Integer numValueOf = imageViewWrapperTarget != null ? Integer.valueOf(imageViewWrapperTarget.getPlaceholderHeight()) : null;
            ImageViewWrapperTarget imageViewWrapperTarget2 = this.currentTarget;
            applyTransformationMatrix$default(this, drawable, contentFit, null, imageViewWrapperTarget2 != null ? Integer.valueOf(imageViewWrapperTarget2.getPlaceholderWidth()) : null, numValueOf, 4, null);
            return;
        }
        Drawable drawable2 = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        applyTransformationMatrix$default(this, drawable2, this.contentFit, this.contentPosition, null, null, 24, null);
    }

    static /* synthetic */ void applyTransformationMatrix$default(ExpoImageView expoImageView, Drawable drawable, ContentFit contentFit, ContentPosition contentPosition, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            contentPosition = ContentPosition.INSTANCE.getCenter();
        }
        ContentPosition contentPosition2 = contentPosition;
        if ((i & 8) != 0) {
            ImageViewWrapperTarget imageViewWrapperTarget = expoImageView.currentTarget;
            num = imageViewWrapperTarget != null ? Integer.valueOf(imageViewWrapperTarget.getSourceWidth()) : null;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            ImageViewWrapperTarget imageViewWrapperTarget2 = expoImageView.currentTarget;
            num2 = imageViewWrapperTarget2 != null ? Integer.valueOf(imageViewWrapperTarget2.getSourceHeight()) : null;
        }
        expoImageView.applyTransformationMatrix(drawable, contentFit, contentPosition2, num3, num2);
    }

    private final void applyTransformationMatrix(Drawable drawable, ContentFit contentFit, ContentPosition contentPosition, Integer num, Integer num2) {
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        RectF rectF2 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Matrix matrix$expo_image_release = contentFit.toMatrix$expo_image_release(rectF, rectF2, num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
        matrix$expo_image_release.mapRect(rectF);
        contentPosition.apply$expo_image_release(matrix$expo_image_release, rectF, rectF2);
        setImageMatrix(matrix$expo_image_release);
    }

    public final ContentFit getContentFit$expo_image_release() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentFit = value;
        this.transformationMatrixChanged = true;
    }

    public final ContentFit getPlaceholderContentFit$expo_image_release() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.placeholderContentFit = value;
        this.transformationMatrixChanged = true;
    }

    public final ContentPosition getContentPosition$expo_image_release() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentPosition = value;
        this.transformationMatrixChanged = true;
    }

    public final void setTintColor$expo_image_release(Integer num) {
        if (num != null) {
            setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        } else {
            clearColorFilter();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        ImageViewWrapperTarget imageViewWrapperTargetRecycleView;
        RequestManager requestManager;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null && bitmap.isRecycled() && (imageViewWrapperTargetRecycleView = recycleView()) != null) {
            ViewParent parent = getParent();
            ExpoImageViewWrapper expoImageViewWrapper = parent instanceof ExpoImageViewWrapper ? (ExpoImageViewWrapper) parent : null;
            if (expoImageViewWrapper != null && (requestManager = expoImageViewWrapper.getRequestManager()) != null) {
                imageViewWrapperTargetRecycleView.clear(requestManager);
            }
        }
        super.draw(canvas);
    }
}
