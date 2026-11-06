package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.drawable.BackgroundDrawable;
import com.facebook.react.uimanager.drawable.BackgroundImageDrawable;
import com.facebook.react.uimanager.drawable.BorderDrawable;
import com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable;
import com.facebook.react.uimanager.drawable.InsetBoxShadowDrawable;
import com.facebook.react.uimanager.drawable.OutlineDrawable;
import com.facebook.react.uimanager.drawable.OutsetBoxShadowDrawable;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.BoxShadow;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.OutlineStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundStyleApplicator {
    public static final BackgroundStyleApplicator INSTANCE = new BackgroundStyleApplicator();

    private BackgroundStyleApplicator() {
    }

    public static final void setBackgroundColor(View view, Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((num == null || num.intValue() == 0) && !(view.getBackground() instanceof CompositeBackgroundDrawable)) {
            return;
        }
        INSTANCE.ensureBackgroundDrawable(view).setBackgroundColor(num != null ? num.intValue() : 0);
    }

    public static final void setBackgroundImage(View view, List list) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureBackgroundImageDrawable(view).setBackgroundImageLayers(list);
    }

    public static final void setBackgroundSize$ReactAndroid_release(View view, List list) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureBackgroundImageDrawable(view).setBackgroundSize(list);
    }

    public static final void setBackgroundPosition$ReactAndroid_release(View view, List list) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureBackgroundImageDrawable(view).setBackgroundPosition(list);
    }

    public static final void setBackgroundRepeat$ReactAndroid_release(View view, List list) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureBackgroundImageDrawable(view).setBackgroundRepeat(list);
    }

    public static final Integer getBackgroundColor(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundDrawable background = INSTANCE.getBackground(view);
        if (background != null) {
            return Integer.valueOf(background.getBackgroundColor());
        }
        return null;
    }

    public static final void setBorderWidth(View view, LogicalEdge edge, Float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view);
        BorderInsets borderInsets = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets == null) {
            borderInsets = new BorderInsets();
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderInsets(borderInsets);
        BorderInsets borderInsets2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets2 != null) {
            borderInsets2.setBorderWidth(edge, f);
        }
        backgroundStyleApplicator.ensureBorderDrawable(view).setBorderWidth(edge.toSpacingType(), f != null ? PixelUtil.INSTANCE.dpToPx(f.floatValue()) : Float.NaN);
        BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background != null) {
            background.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        }
        BackgroundImageDrawable backgroundImage = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackgroundImage();
        if (backgroundImage != null) {
            backgroundImage.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        }
        BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border != null) {
            border.setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        }
        BackgroundDrawable background2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background2 != null) {
            background2.invalidateSelf();
        }
        BackgroundImageDrawable backgroundImage2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackgroundImage();
        if (backgroundImage2 != null) {
            backgroundImage2.invalidateSelf();
        }
        BorderDrawable border2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border2 != null) {
            border2.invalidateSelf();
        }
        BorderInsets borderInsets3 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets3 == null) {
            borderInsets3 = new BorderInsets();
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderInsets(borderInsets3);
        BorderInsets borderInsets4 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        if (borderInsets4 != null) {
            borderInsets4.setBorderWidth(edge, f);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            List innerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getInnerShadows();
            ArrayList arrayList = new ArrayList();
            for (Object obj : innerShadows) {
                if (obj instanceof InsetBoxShadowDrawable) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InsetBoxShadowDrawable) it.next()).setBorderInsets(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
            }
        }
    }

    public static final void setBorderColor(View view, LogicalEdge edge, Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        INSTANCE.ensureBorderDrawable(view).setBorderColor(edge, num);
    }

    public static final void setBorderRadius(View view, BorderRadiusProp corner, LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = backgroundStyleApplicator.ensureCompositeBackgroundDrawable(view);
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        if (borderRadius == null) {
            borderRadius = new BorderRadiusStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.setBorderRadius(borderRadius);
        BorderRadiusStyle borderRadius2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        if (borderRadius2 != null) {
            borderRadius2.set(corner, lengthPercentage);
        }
        if (view instanceof ImageView) {
            backgroundStyleApplicator.ensureBackgroundDrawable(view);
        }
        BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background != null) {
            background.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
        }
        BackgroundImageDrawable backgroundImage = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackgroundImage();
        if (backgroundImage != null) {
            backgroundImage.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
        }
        BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border != null) {
            border.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
        }
        BackgroundDrawable background2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background2 != null) {
            background2.invalidateSelf();
        }
        BackgroundImageDrawable backgroundImage2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackgroundImage();
        if (backgroundImage2 != null) {
            backgroundImage2.invalidateSelf();
        }
        BorderDrawable border2 = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border2 != null) {
            border2.invalidateSelf();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            List outerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOuterShadows();
            ArrayList arrayList = new ArrayList();
            for (Object obj : outerShadows) {
                if (obj instanceof OutsetBoxShadowDrawable) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OutsetBoxShadowDrawable) it.next()).setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            List innerShadows = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getInnerShadows();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : innerShadows) {
                if (obj2 instanceof InsetBoxShadowDrawable) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((InsetBoxShadowDrawable) it2.next()).setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
            }
        }
        OutlineDrawable outline = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOutline();
        if (outline != null) {
            outline.setBorderRadius(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius());
        }
        compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.invalidateSelf();
    }

    public static final void setBorderStyle(View view, BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureBorderDrawable(view).setBorderStyle(borderStyle);
    }

    public static final void setOutlineColor(View view, Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableEnsureOutlineDrawable = INSTANCE.ensureOutlineDrawable(view);
        if (num != null) {
            outlineDrawableEnsureOutlineDrawable.setOutlineColor(num.intValue());
        }
    }

    public static final void setOutlineOffset(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        INSTANCE.ensureOutlineDrawable(view).setOutlineOffset(PixelUtil.INSTANCE.dpToPx(f));
    }

    public static final void setOutlineStyle(View view, OutlineStyle outlineStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableEnsureOutlineDrawable = INSTANCE.ensureOutlineDrawable(view);
        if (outlineStyle != null) {
            outlineDrawableEnsureOutlineDrawable.setOutlineStyle(outlineStyle);
        }
    }

    public static final void setOutlineWidth(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        INSTANCE.ensureOutlineDrawable(view).setOutlineWidth(PixelUtil.INSTANCE.dpToPx(f));
    }

    public static final void setBoxShadow(View view, List shadows) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(shadows, "shadows");
        if (ViewUtil.getUIManagerType(view) != 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = INSTANCE.ensureCompositeBackgroundDrawable(view);
        BorderInsets borderInsets = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets();
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        Iterator it = shadows.iterator();
        while (it.hasNext()) {
            BoxShadow boxShadow = (BoxShadow) it.next();
            float offsetX = boxShadow.getOffsetX();
            float offsetY = boxShadow.getOffsetY();
            Integer color = boxShadow.getColor();
            int iIntValue = color != null ? color.intValue() : -16777216;
            Float blurRadius = boxShadow.getBlurRadius();
            float fFloatValue = blurRadius != null ? blurRadius.floatValue() : 0.0f;
            Float spreadDistance = boxShadow.getSpreadDistance();
            float fFloatValue2 = spreadDistance != null ? spreadDistance.floatValue() : 0.0f;
            Boolean inset = boxShadow.getInset();
            boolean zBooleanValue = inset != null ? inset.booleanValue() : false;
            if (zBooleanValue && Build.VERSION.SDK_INT >= 29) {
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                arrayList.add(new InsetBoxShadowDrawable(context, iIntValue, offsetX, offsetY, fFloatValue, fFloatValue2, borderInsets, borderRadius));
            } else if (!zBooleanValue && Build.VERSION.SDK_INT >= 28) {
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                arrayList2.add(new OutsetBoxShadowDrawable(context2, iIntValue, offsetX, offsetY, fFloatValue, fFloatValue2, borderRadius));
            }
        }
        view.setBackground(INSTANCE.ensureCompositeBackgroundDrawable(view).withNewShadows(arrayList2, arrayList));
    }

    public static final void setBoxShadow(View view, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray == null) {
            setBoxShadow(view, CollectionsKt.emptyList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            BoxShadow.Companion companion = BoxShadow.Companion;
            ReadableMap map = readableArray.getMap(i);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            BoxShadow boxShadow = companion.parse(map, context);
            if (boxShadow == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(boxShadow);
        }
        setBoxShadow(view, arrayList);
    }

    public static final void setFeedbackUnderlay(View view, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.ensureCompositeBackgroundDrawable(view).withNewFeedbackUnderlay(drawable);
    }

    public static final void clipToPaddingBox(View view, Canvas canvas) {
        RectF rectFResolve;
        float fDpToPx;
        float fDpToPx2;
        float fDpToPx3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        BackgroundStyleApplicator backgroundStyleApplicator = INSTANCE;
        CompositeBackgroundDrawable compositeBackgroundDrawable = backgroundStyleApplicator.getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable == null) {
            canvas.clipRect(rect);
            return;
        }
        RectF rectF = new RectF();
        BorderInsets borderInsets = compositeBackgroundDrawable.getBorderInsets();
        if (borderInsets != null) {
            int layoutDirection = compositeBackgroundDrawable.getLayoutDirection();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            rectFResolve = borderInsets.resolve(layoutDirection, context);
        } else {
            rectFResolve = null;
        }
        float f = compositeBackgroundDrawable.getBounds().left;
        float fDpToPx4 = 0.0f;
        if (rectFResolve != null) {
            fDpToPx = PixelUtil.INSTANCE.dpToPx(rectFResolve.left);
        } else {
            fDpToPx = 0.0f;
        }
        rectF.left = f + fDpToPx;
        float f2 = compositeBackgroundDrawable.getBounds().top;
        if (rectFResolve != null) {
            fDpToPx2 = PixelUtil.INSTANCE.dpToPx(rectFResolve.top);
        } else {
            fDpToPx2 = 0.0f;
        }
        rectF.top = f2 + fDpToPx2;
        float f3 = compositeBackgroundDrawable.getBounds().right;
        if (rectFResolve != null) {
            fDpToPx3 = PixelUtil.INSTANCE.dpToPx(rectFResolve.right);
        } else {
            fDpToPx3 = 0.0f;
        }
        rectF.right = f3 - fDpToPx3;
        float f4 = compositeBackgroundDrawable.getBounds().bottom;
        if (rectFResolve != null) {
            fDpToPx4 = PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom);
        }
        rectF.bottom = f4 - fDpToPx4;
        BorderRadiusStyle borderRadius = compositeBackgroundDrawable.getBorderRadius();
        if (borderRadius != null && borderRadius.hasRoundedBorders()) {
            Path pathCreatePaddingBoxPath = backgroundStyleApplicator.createPaddingBoxPath(view, compositeBackgroundDrawable, rectF, rectFResolve);
            pathCreatePaddingBoxPath.offset(rect.left, rect.top);
            canvas.clipPath(pathCreatePaddingBoxPath);
        } else {
            rectF.offset(rect.left, rect.top);
            canvas.clipRect(rectF);
        }
    }

    public static final void reset(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            view.setBackground(((CompositeBackgroundDrawable) background).getOriginalBackground());
        }
    }

    private final CompositeBackgroundDrawable ensureCompositeBackgroundDrawable(View view) {
        if (view.getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            return (CompositeBackgroundDrawable) background;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(context, view.getBackground(), null, null, null, null, null, null, null, null, null, 2044, null);
        view.setBackground(compositeBackgroundDrawable);
        return compositeBackgroundDrawable;
    }

    private final CompositeBackgroundDrawable getCompositeBackgroundDrawable(View view) {
        Drawable background = view.getBackground();
        if (background instanceof CompositeBackgroundDrawable) {
            return (CompositeBackgroundDrawable) background;
        }
        return null;
    }

    private final BackgroundDrawable ensureBackgroundDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        BackgroundDrawable background = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackground();
        if (background != null) {
            return background;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BackgroundDrawable backgroundDrawable = new BackgroundDrawable(context, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius(), compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewBackground(backgroundDrawable));
        return backgroundDrawable;
    }

    private final BackgroundDrawable getBackground(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawable = getCompositeBackgroundDrawable(view);
        if (compositeBackgroundDrawable != null) {
            return compositeBackgroundDrawable.getBackground();
        }
        return null;
    }

    private final BackgroundImageDrawable ensureBackgroundImageDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        BackgroundImageDrawable backgroundImage = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBackgroundImage();
        if (backgroundImage != null) {
            return backgroundImage;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BackgroundImageDrawable backgroundImageDrawable = new BackgroundImageDrawable(context, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius(), compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets());
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewBackgroundImage(backgroundImageDrawable));
        return backgroundImageDrawable;
    }

    private final BorderDrawable ensureBorderDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        BorderDrawable border = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorder();
        if (border != null) {
            return border;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        BorderDrawable borderDrawable = new BorderDrawable(context, new Spacing(0.0f), borderRadius, compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderInsets(), BorderStyle.SOLID);
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewBorder(borderDrawable));
        return borderDrawable;
    }

    private final OutlineDrawable ensureOutlineDrawable(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableEnsureCompositeBackgroundDrawable = ensureCompositeBackgroundDrawable(view);
        OutlineDrawable outline = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getOutline();
        if (outline != null) {
            return outline;
        }
        BorderRadiusStyle borderRadius = compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.getBorderRadius();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        OutlineDrawable outlineDrawable = new OutlineDrawable(context, borderRadius, -16777216, 0.0f, OutlineStyle.SOLID, 0.0f);
        view.setBackground(compositeBackgroundDrawableEnsureCompositeBackgroundDrawable.withNewOutline(outlineDrawable));
        return outlineDrawable;
    }

    private final float getInnerBorderRadius(Float f, Float f2) {
        return RangesKt.coerceAtLeast((f != null ? f.floatValue() : 0.0f) - (f2 != null ? f2.floatValue() : 0.0f), 0.0f);
    }

    private final Path createPaddingBoxPath(View view, CompositeBackgroundDrawable compositeBackgroundDrawable, RectF rectF, RectF rectF2) {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii bottomLeft;
        CornerRadii bottomLeft2;
        CornerRadii bottomRight;
        CornerRadii bottomRight2;
        CornerRadii topRight;
        CornerRadii topRight2;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        BorderRadiusStyle borderRadius = compositeBackgroundDrawable.getBorderRadius();
        if (borderRadius != null) {
            int layoutDirection = compositeBackgroundDrawable.getLayoutDirection();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            computedBorderRadiusResolve = borderRadius.resolve(layoutDirection, context, PixelUtil.toDIPFromPixel(compositeBackgroundDrawable.getBounds().width()), PixelUtil.toDIPFromPixel(compositeBackgroundDrawable.getBounds().height()));
        } else {
            computedBorderRadiusResolve = null;
        }
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{getInnerBorderRadius((computedBorderRadiusResolve == null || (topLeft2 = computedBorderRadiusResolve.getTopLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.left)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topLeft.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.top)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topRight2 = computedBorderRadiusResolve.getTopRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topRight2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.right)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (topRight = computedBorderRadiusResolve.getTopRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(topRight.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.top)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomRight2 = computedBorderRadiusResolve.getBottomRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomRight2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.right)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomRight = computedBorderRadiusResolve.getBottomRight()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomRight.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.bottom)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomLeft2 = computedBorderRadiusResolve.getBottomLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomLeft2.getHorizontal())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.left)) : null), getInnerBorderRadius((computedBorderRadiusResolve == null || (bottomLeft = computedBorderRadiusResolve.getBottomLeft()) == null) ? null : Float.valueOf(PixelUtil.INSTANCE.dpToPx(bottomLeft.getVertical())), rectF2 != null ? Float.valueOf(PixelUtil.INSTANCE.dpToPx(rectF2.bottom)) : null)}, Path.Direction.CW);
        return path;
    }
}
