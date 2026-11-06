package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DraweeView extends ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio;
    private DraweeHolder mDraweeHolder;
    private Object mExtraData;
    private boolean mInitialised;
    private boolean mLegacyVisibilityHandlingEnabled;
    private final AspectRatioMeasure.Spec mMeasureSpec;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        sGlobalLegacyVisibilityHandlingEnabled = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        this.mExtraData = null;
        init(context);
    }

    private void init(Context context) {
        boolean zIsTracing;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DraweeView#init");
            }
            if (this.mInitialised) {
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            boolean z = true;
            this.mInitialised = true;
            this.mDraweeHolder = DraweeHolder.create(null, context);
            ColorStateList imageTintList = getImageTintList();
            if (imageTintList == null) {
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            setColorFilter(imageTintList.getDefaultColor());
            if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                z = false;
            }
            this.mLegacyVisibilityHandlingEnabled = z;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public void setExtraData(Object obj) {
        this.mExtraData = obj;
    }

    public Object getExtraData() {
        return this.mExtraData;
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        this.mDraweeHolder.setHierarchy(draweeHierarchy);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DraweeHierarchy getHierarchy() {
        return this.mDraweeHolder.getHierarchy();
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public void setController(DraweeController draweeController) {
        this.mDraweeHolder.setController(draweeController);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DraweeController getController() {
        return this.mDraweeHolder.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    protected void onAttach() {
        doAttach();
    }

    protected void onDetach() {
        doDetach();
    }

    protected void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    protected void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDraweeHolder.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.resetActualImage();
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = f;
        requestLayout();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mLegacyVisibilityHandlingEnabled = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        AspectRatioMeasure.Spec spec = this.mMeasureSpec;
        spec.width = i;
        spec.height = i2;
        AspectRatioMeasure.updateMeasureSpec(spec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        AspectRatioMeasure.Spec spec2 = this.mMeasureSpec;
        super.onMeasure(spec2.width, spec2.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        maybeOverrideVisibilityHandling();
    }

    private void maybeOverrideVisibilityHandling() {
        Drawable drawable;
        if (!this.mLegacyVisibilityHandlingEnabled || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    @Override // android.view.View
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        DraweeHolder draweeHolder = this.mDraweeHolder;
        return stringHelper.add("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>").toString();
    }
}
