package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GenericDraweeHierarchyBuilder {
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private Matrix mActualImageMatrix;
    private ScalingUtils$ScaleType mActualImageScaleType;
    private Drawable mBackground;
    private float mDesiredAspectRatio;
    private int mFadeDuration;
    private Drawable mFailureImage;
    private ScalingUtils$ScaleType mFailureImageScaleType;
    private List mOverlays;
    private Drawable mPlaceholderImage;
    private ScalingUtils$ScaleType mPlaceholderImageScaleType;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarImage;
    private ScalingUtils$ScaleType mProgressBarImageScaleType;
    private Resources mResources;
    private Drawable mRetryImage;
    private ScalingUtils$ScaleType mRetryImageScaleType;
    private RoundingParams mRoundingParams;
    public static final ScalingUtils$ScaleType DEFAULT_SCALE_TYPE = ScalingUtils$ScaleType.CENTER_INSIDE;
    public static final ScalingUtils$ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils$ScaleType.CENTER_CROP;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.mResources = resources;
        init();
    }

    public static GenericDraweeHierarchyBuilder newInstance(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources);
    }

    private void init() {
        this.mFadeDuration = 300;
        this.mDesiredAspectRatio = 0.0f;
        this.mPlaceholderImage = null;
        ScalingUtils$ScaleType scalingUtils$ScaleType = DEFAULT_SCALE_TYPE;
        this.mPlaceholderImageScaleType = scalingUtils$ScaleType;
        this.mRetryImage = null;
        this.mRetryImageScaleType = scalingUtils$ScaleType;
        this.mFailureImage = null;
        this.mFailureImageScaleType = scalingUtils$ScaleType;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = scalingUtils$ScaleType;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageMatrix = null;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    public Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    public ScalingUtils$ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    public Drawable getRetryImage() {
        return this.mRetryImage;
    }

    public ScalingUtils$ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    public Drawable getFailureImage() {
        return this.mFailureImage;
    }

    public ScalingUtils$ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    public Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    public ScalingUtils$ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public ScalingUtils$ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    public PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    public ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public List getOverlays() {
        return this.mOverlays;
    }

    public Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    public GenericDraweeHierarchyBuilder setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        return this;
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    private void validate() {
        List list = this.mOverlays;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Preconditions.checkNotNull((Drawable) it.next());
            }
        }
    }

    public GenericDraweeHierarchy build() {
        validate();
        return new GenericDraweeHierarchy(this);
    }
}
