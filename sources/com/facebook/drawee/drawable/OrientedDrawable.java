package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class OrientedDrawable extends ForwardingDrawable {
    private final int exifOrientation;
    public final Matrix mRotationMatrix;
    private final int rotationAngle;
    private final Matrix tempMatrix;
    private final RectF tempRectF;

    public OrientedDrawable(Drawable drawable, int i, int i2) {
        super(drawable);
        this.mRotationMatrix = new Matrix();
        this.rotationAngle = i - (i % 90);
        this.exifOrientation = (i2 < 0 || i2 > 8) ? 0 : i2;
        this.tempMatrix = new Matrix();
        this.tempRectF = new RectF();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.rotationAngle <= 0 && ((i = this.exifOrientation) == 0 || i == 1)) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.mRotationMatrix);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.exifOrientation;
        if (i == 5 || i == 7 || this.rotationAngle % SensibleDefaults.X_OFFSET != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.exifOrientation;
        if (i == 5 || i == 7 || this.rotationAngle % SensibleDefaults.X_OFFSET != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        int i;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        int i2 = this.rotationAngle;
        if (i2 > 0 || ((i = this.exifOrientation) != 0 && i != 1)) {
            int i3 = this.exifOrientation;
            if (i3 == 2) {
                this.mRotationMatrix.setScale(-1.0f, 1.0f);
            } else if (i3 == 7) {
                this.mRotationMatrix.setRotate(270.0f, bounds.centerX(), bounds.centerY());
                this.mRotationMatrix.postScale(-1.0f, 1.0f);
            } else if (i3 == 4) {
                this.mRotationMatrix.setScale(1.0f, -1.0f);
            } else if (i3 == 5) {
                this.mRotationMatrix.setRotate(270.0f, bounds.centerX(), bounds.centerY());
                this.mRotationMatrix.postScale(1.0f, -1.0f);
            } else {
                this.mRotationMatrix.setRotate(i2, bounds.centerX(), bounds.centerY());
            }
            this.tempMatrix.reset();
            this.mRotationMatrix.invert(this.tempMatrix);
            this.tempRectF.set(bounds);
            this.tempMatrix.mapRect(this.tempRectF);
            RectF rectF = this.tempRectF;
            current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            return;
        }
        current.setBounds(bounds);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        getParentTransform(transform);
        if (this.mRotationMatrix.isIdentity()) {
            return;
        }
        transform.preConcat(this.mRotationMatrix);
    }
}
