package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeBackgroundDrawable extends LayerDrawable {
    public static final Companion Companion = new Companion(null);
    private final BackgroundDrawable background;
    private final BackgroundImageDrawable backgroundImage;
    private final BorderDrawable border;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private final Drawable feedbackUnderlay;
    private final List innerShadows;
    private final Drawable originalBackground;
    private final List outerShadows;
    private final OutlineDrawable outline;

    public final Drawable getOriginalBackground() {
        return this.originalBackground;
    }

    public /* synthetic */ CompositeBackgroundDrawable(Context context, Drawable drawable, List list, BackgroundDrawable backgroundDrawable, BackgroundImageDrawable backgroundImageDrawable, BorderDrawable borderDrawable, Drawable drawable2, List list2, OutlineDrawable outlineDrawable, BorderInsets borderInsets, BorderRadiusStyle borderRadiusStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : drawable, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : backgroundDrawable, (i & 16) != 0 ? null : backgroundImageDrawable, (i & 32) != 0 ? null : borderDrawable, (i & 64) != 0 ? null : drawable2, (i & 128) != 0 ? CollectionsKt.emptyList() : list2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : outlineDrawable, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : borderInsets, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : borderRadiusStyle);
    }

    public final List getOuterShadows() {
        return this.outerShadows;
    }

    public final BackgroundDrawable getBackground() {
        return this.background;
    }

    public final BackgroundImageDrawable getBackgroundImage() {
        return this.backgroundImage;
    }

    public final BorderDrawable getBorder() {
        return this.border;
    }

    public final List getInnerShadows() {
        return this.innerShadows;
    }

    public final OutlineDrawable getOutline() {
        return this.outline;
    }

    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeBackgroundDrawable(Context context, Drawable drawable, List outerShadows, BackgroundDrawable backgroundDrawable, BackgroundImageDrawable backgroundImageDrawable, BorderDrawable borderDrawable, Drawable drawable2, List innerShadows, OutlineDrawable outlineDrawable, BorderInsets borderInsets, BorderRadiusStyle borderRadiusStyle) {
        super(Companion.createLayersArray(drawable, outerShadows, backgroundDrawable, backgroundImageDrawable, borderDrawable, drawable2, innerShadows, outlineDrawable));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outerShadows, "outerShadows");
        Intrinsics.checkNotNullParameter(innerShadows, "innerShadows");
        this.context = context;
        this.originalBackground = drawable;
        this.outerShadows = outerShadows;
        this.background = backgroundDrawable;
        this.backgroundImage = backgroundImageDrawable;
        this.border = borderDrawable;
        this.feedbackUnderlay = drawable2;
        this.innerShadows = innerShadows;
        this.outline = outlineDrawable;
        this.borderInsets = borderInsets;
        this.borderRadius = borderRadiusStyle;
        setPaddingMode(1);
    }

    public final CompositeBackgroundDrawable withNewBackgroundImage(BackgroundImageDrawable backgroundImageDrawable) {
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, this.background, backgroundImageDrawable, this.border, this.feedbackUnderlay, this.innerShadows, this.outline, this.borderInsets, this.borderRadius);
    }

    public final CompositeBackgroundDrawable withNewBackground(BackgroundDrawable backgroundDrawable) {
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, backgroundDrawable, this.backgroundImage, this.border, this.feedbackUnderlay, this.innerShadows, this.outline, this.borderInsets, this.borderRadius);
    }

    public final CompositeBackgroundDrawable withNewShadows(List outerShadows, List innerShadows) {
        Intrinsics.checkNotNullParameter(outerShadows, "outerShadows");
        Intrinsics.checkNotNullParameter(innerShadows, "innerShadows");
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, outerShadows, this.background, this.backgroundImage, this.border, this.feedbackUnderlay, innerShadows, this.outline, this.borderInsets, this.borderRadius);
    }

    public final CompositeBackgroundDrawable withNewBorder(BorderDrawable border) {
        Intrinsics.checkNotNullParameter(border, "border");
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, this.background, this.backgroundImage, border, this.feedbackUnderlay, this.innerShadows, this.outline, this.borderInsets, this.borderRadius);
    }

    public final CompositeBackgroundDrawable withNewOutline(OutlineDrawable outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, this.background, this.backgroundImage, this.border, this.feedbackUnderlay, this.innerShadows, outline, this.borderInsets, this.borderRadius);
    }

    public final CompositeBackgroundDrawable withNewFeedbackUnderlay(Drawable drawable) {
        return new CompositeBackgroundDrawable(this.context, this.originalBackground, this.outerShadows, this.background, this.backgroundImage, this.border, drawable, this.innerShadows, this.outline, this.borderInsets, this.borderRadius);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            Path path = new Path();
            BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
            ComputedBorderRadius computedBorderRadiusResolve = borderRadiusStyle2 != null ? borderRadiusStyle2.resolve(getLayoutDirection(), this.context, getBounds().width(), getBounds().height()) : null;
            BorderInsets borderInsets = this.borderInsets;
            RectF rectFResolve = borderInsets != null ? borderInsets.resolve(getLayoutDirection(), this.context) : null;
            if (computedBorderRadiusResolve != null) {
                RectF rectF = new RectF(getBounds());
                PixelUtil pixelUtil = PixelUtil.INSTANCE;
                path.addRoundRect(rectF, new float[]{pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getHorizontal() + (rectFResolve != null ? rectFResolve.left : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getVertical() + (rectFResolve != null ? rectFResolve.top : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getHorizontal() + (rectFResolve != null ? rectFResolve.right : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getVertical() + (rectFResolve != null ? rectFResolve.top : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getHorizontal() + (rectFResolve != null ? rectFResolve.right : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getVertical() + (rectFResolve != null ? rectFResolve.bottom : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getHorizontal() + (rectFResolve != null ? rectFResolve.left : 0.0f)), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getVertical() + (rectFResolve != null ? rectFResolve.bottom : 0.0f))}, Path.Direction.CW);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                outline.setPath(path);
                return;
            } else {
                outline.setConvexPath(path);
                return;
            }
        }
        outline.setRect(getBounds());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable[] createLayersArray(Drawable drawable, List list, BackgroundDrawable backgroundDrawable, BackgroundImageDrawable backgroundImageDrawable, BorderDrawable borderDrawable, Drawable drawable2, List list2, OutlineDrawable outlineDrawable) {
            ArrayList arrayList = new ArrayList();
            if (drawable != null) {
                arrayList.add(drawable);
            }
            arrayList.addAll(CollectionsKt.asReversed(list));
            if (backgroundDrawable != null) {
                arrayList.add(backgroundDrawable);
            }
            if (backgroundImageDrawable != null) {
                arrayList.add(backgroundImageDrawable);
            }
            if (borderDrawable != null) {
                arrayList.add(borderDrawable);
            }
            if (drawable2 != null) {
                arrayList.add(drawable2);
            }
            arrayList.addAll(CollectionsKt.asReversed(list2));
            if (outlineDrawable != null) {
                arrayList.add(outlineDrawable);
            }
            return (Drawable[]) arrayList.toArray(new Drawable[0]);
        }
    }
}
