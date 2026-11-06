package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = R$style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = R$attr.badgeStyle;
    private WeakReference anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final WeakReference contextRef;
    private float cornerRadius;
    private WeakReference customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final MaterialShapeDrawable shapeDrawable;
    private final BadgeState state;
    private final TextDrawableHelper textDrawableHelper;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    static BadgeDrawable createFromSavedState(Context context, BadgeState.State state) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, state);
    }

    public static BadgeDrawable create(Context context) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public void setVisible(boolean z) {
        this.state.setVisible(z);
        onVisibilityUpdated();
    }

    private void onVisibilityUpdated() {
        setVisible(this.state.isVisible(), false);
    }

    public void setBadgeFixedEdge(int i) {
        BadgeState badgeState = this.state;
        if (badgeState.badgeFixedEdge != i) {
            badgeState.badgeFixedEdge = i;
            updateCenterAndBounds();
        }
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxBadgeLengthUpdated();
        onBadgeContentUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private BadgeDrawable(Context context, int i, int i2, int i3, BadgeState.State state) {
        int badgeShapeAppearanceResId;
        int badgeShapeAppearanceOverlayResId;
        this.contextRef = new WeakReference(context);
        ThemeEnforcement.checkMaterialTheme(context);
        this.badgeBounds = new Rect();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i, i2, i3, state);
        this.state = badgeState;
        if (hasBadgeContent()) {
            badgeShapeAppearanceResId = badgeState.getBadgeWithTextShapeAppearanceResId();
        } else {
            badgeShapeAppearanceResId = badgeState.getBadgeShapeAppearanceResId();
        }
        if (hasBadgeContent()) {
            badgeShapeAppearanceOverlayResId = badgeState.getBadgeWithTextShapeAppearanceOverlayResId();
        } else {
            badgeShapeAppearanceOverlayResId = badgeState.getBadgeShapeAppearanceOverlayResId();
        }
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context, badgeShapeAppearanceResId, badgeShapeAppearanceOverlayResId).build());
        restoreState();
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference(view);
        this.customBadgeParentRef = new WeakReference(frameLayout);
        updateAnchorParentToNotClip(view);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public void setBackgroundColor(int i) {
        this.state.setBackgroundColor(i);
        onBackgroundColorUpdated();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() != colorStateListValueOf) {
            this.shapeDrawable.setFillColor(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void setBadgeTextColor(int i) {
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.state.setBadgeTextColor(i);
            onBadgeTextColorUpdated();
        }
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    public boolean hasNumber() {
        return !this.state.hasText() && this.state.hasNumber();
    }

    public int getNumber() {
        if (this.state.hasNumber()) {
            return this.state.getNumber();
        }
        return 0;
    }

    public void setNumber(int i) {
        int iMax = Math.max(0, i);
        if (this.state.getNumber() != iMax) {
            this.state.setNumber(iMax);
            onNumberUpdated();
        }
    }

    public void clearNumber() {
        if (this.state.hasNumber()) {
            this.state.clearNumber();
            onNumberUpdated();
        }
    }

    private void onNumberUpdated() {
        if (hasText()) {
            return;
        }
        onBadgeContentUpdated();
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    public String getText() {
        return this.state.getText();
    }

    public void setText(String str) {
        if (TextUtils.equals(this.state.getText(), str)) {
            return;
        }
        this.state.setText(str);
        onTextUpdated();
    }

    public void clearText() {
        if (this.state.hasText()) {
            this.state.clearText();
            onTextUpdated();
        }
    }

    private void onTextUpdated() {
        onBadgeContentUpdated();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    private void onMaxBadgeLengthUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        WeakReference weakReference = this.anchorViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.anchorViewRef.get();
        WeakReference weakReference2 = this.customBadgeParentRef;
        updateBadgeCoordinates(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.state.setAlpha(i);
        onAlphaUpdated();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasBadgeContent()) {
            drawBadgeContent(canvas);
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public CharSequence getContentDescription() {
        if (!isVisible()) {
            return null;
        }
        if (hasText()) {
            return getTextContentDescription();
        }
        if (hasNumber()) {
            return getNumberContentDescription();
        }
        return getEmptyContentDescription();
    }

    private String getNumberContentDescription() {
        Context context;
        if (this.state.getContentDescriptionQuantityStrings() == 0 || (context = (Context) this.contextRef.get()) == null) {
            return null;
        }
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), Integer.valueOf(getNumber()));
        }
        return context.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), Integer.valueOf(this.maxBadgeNumber));
    }

    private CharSequence getTextContentDescription() {
        CharSequence contentDescriptionForText = this.state.getContentDescriptionForText();
        return contentDescriptionForText != null ? contentDescriptionForText : getText();
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    private void onBadgeTextAppearanceUpdated() {
        TextAppearance textAppearance;
        Context context = (Context) this.contextRef.get();
        if (context == null || this.textDrawableHelper.getTextAppearance() == (textAppearance = new TextAppearance(context, this.state.getTextAppearanceResId()))) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        onBadgeTextColorUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeShapeAppearanceUpdated() {
        int badgeShapeAppearanceResId;
        int badgeShapeAppearanceOverlayResId;
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (hasBadgeContent()) {
            badgeShapeAppearanceResId = this.state.getBadgeWithTextShapeAppearanceResId();
        } else {
            badgeShapeAppearanceResId = this.state.getBadgeShapeAppearanceResId();
        }
        if (hasBadgeContent()) {
            badgeShapeAppearanceOverlayResId = this.state.getBadgeWithTextShapeAppearanceOverlayResId();
        } else {
            badgeShapeAppearanceOverlayResId = this.state.getBadgeShapeAppearanceOverlayResId();
        }
        materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder(context, badgeShapeAppearanceResId, badgeShapeAppearanceOverlayResId).build());
        invalidateSelf();
    }

    private void updateCenterAndBounds() {
        Context context = (Context) this.contextRef.get();
        WeakReference weakReference = this.anchorViewRef;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.badgeBounds);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.customBadgeParentRef;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(rect2, view);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        float f = this.cornerRadius;
        if (f != -1.0f) {
            this.shapeDrawable.setCornerSize(f);
        }
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private int getTotalVerticalOffsetForState() {
        int verticalOffsetWithoutText = this.state.getVerticalOffsetWithoutText();
        if (hasBadgeContent()) {
            verticalOffsetWithoutText = this.state.getVerticalOffsetWithText();
            Context context = (Context) this.contextRef.get();
            if (context != null) {
                verticalOffsetWithoutText = AnimationUtils.lerp(verticalOffsetWithoutText, verticalOffsetWithoutText - this.state.getLargeFontVerticalOffsetAdjustment(), AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context) - 1.0f));
            }
        }
        if (this.state.offsetAlignmentMode == 0) {
            verticalOffsetWithoutText -= Math.round(this.halfBadgeHeight);
        }
        return verticalOffsetWithoutText + this.state.getAdditionalVerticalOffset();
    }

    private int getTotalHorizontalOffsetForState() {
        int horizontalOffsetWithoutText;
        if (hasBadgeContent()) {
            horizontalOffsetWithoutText = this.state.getHorizontalOffsetWithText();
        } else {
            horizontalOffsetWithoutText = this.state.getHorizontalOffsetWithoutText();
        }
        if (this.state.offsetAlignmentMode == 1) {
            horizontalOffsetWithoutText += hasBadgeContent() ? this.state.horizontalInsetWithText : this.state.horizontalInset;
        }
        return horizontalOffsetWithoutText + this.state.getAdditionalHorizontalOffset();
    }

    private void calculateCenterAndBounds(Rect rect, View view) {
        float f;
        float f2;
        float f3 = hasBadgeContent() ? this.state.badgeWithTextRadius : this.state.badgeRadius;
        this.cornerRadius = f3;
        if (f3 != -1.0f) {
            this.halfBadgeWidth = f3;
            this.halfBadgeHeight = f3;
        } else {
            this.halfBadgeWidth = Math.round((hasBadgeContent() ? this.state.badgeWithTextWidth : this.state.badgeWidth) / 2.0f);
            this.halfBadgeHeight = Math.round((hasBadgeContent() ? this.state.badgeWithTextHeight : this.state.badgeHeight) / 2.0f);
        }
        if (hasBadgeContent()) {
            String badgeContent = getBadgeContent();
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(badgeContent) / 2.0f) + this.state.getBadgeHorizontalPadding());
            float fMax = Math.max(this.halfBadgeHeight, (this.textDrawableHelper.getTextHeight(badgeContent) / 2.0f) + this.state.getBadgeVerticalPadding());
            this.halfBadgeHeight = fMax;
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, fMax);
        }
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int badgeGravity = this.state.getBadgeGravity();
        if (badgeGravity == 8388691 || badgeGravity == 8388693) {
            this.badgeCenterY = rect.bottom - totalVerticalOffsetForState;
        } else {
            this.badgeCenterY = rect.top + totalVerticalOffsetForState;
        }
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int badgeGravity2 = this.state.getBadgeGravity();
        if (badgeGravity2 == 8388659 || badgeGravity2 == 8388691) {
            if (this.state.badgeFixedEdge == 0) {
                if (view.getLayoutDirection() == 0) {
                    f = (rect.left + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState);
                } else {
                    f = (rect.right - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState);
                }
            } else if (view.getLayoutDirection() == 0) {
                f = (rect.left - this.halfBadgeWidth) + totalHorizontalOffsetForState;
            } else {
                f = (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState;
            }
            this.badgeCenterX = f;
        } else {
            if (this.state.badgeFixedEdge == 0) {
                if (view.getLayoutDirection() == 0) {
                    f2 = (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState;
                } else {
                    f2 = (rect.left - this.halfBadgeWidth) + totalHorizontalOffsetForState;
                }
            } else if (view.getLayoutDirection() == 0) {
                f2 = (rect.right - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState);
            } else {
                f2 = (rect.left + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState);
            }
            this.badgeCenterX = f2;
        }
        if (this.state.isAutoAdjustedToGrandparentBounds()) {
            autoAdjustWithinGrandparentBounds(view);
        } else {
            autoAdjustWithinViewBounds(view, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void autoAdjustWithinViewBounds(View view, View view2) {
        float y;
        float x;
        ViewParent parent;
        boolean z;
        FrameLayout customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            float y2 = view.getY();
            x = view.getX();
            parent = view.getParent();
            y = y2;
        } else {
            y = 0.0f;
            x = 0.0f;
            parent = customBadgeParent;
        }
        while (true) {
            z = parent instanceof View;
            if (!z || parent == view2) {
                break;
            }
            ViewParent parent2 = parent.getParent();
            if (!(parent2 instanceof ViewGroup) || ((ViewGroup) parent2).getClipChildren()) {
                break;
            }
            View view3 = (View) parent;
            y += view3.getY();
            x += view3.getX();
            parent = parent.getParent();
        }
        if (z) {
            float topCutOff = getTopCutOff(y);
            float leftCutOff = getLeftCutOff(x);
            View view4 = (View) parent;
            float bottomCutOff = getBottomCutOff(view4.getHeight(), y);
            float rightCutoff = getRightCutoff(view4.getWidth(), x);
            if (topCutOff < 0.0f) {
                this.badgeCenterY += Math.abs(topCutOff);
            }
            if (leftCutOff < 0.0f) {
                this.badgeCenterX += Math.abs(leftCutOff);
            }
            if (bottomCutOff > 0.0f) {
                this.badgeCenterY -= Math.abs(bottomCutOff);
            }
            if (rightCutoff > 0.0f) {
                this.badgeCenterX -= Math.abs(rightCutoff);
            }
        }
    }

    private void autoAdjustWithinGrandparentBounds(View view) {
        ViewParent customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            customBadgeParent = view.getParent();
        }
        if ((customBadgeParent instanceof View) && (customBadgeParent.getParent() instanceof View)) {
            autoAdjustWithinViewBounds(view, (View) customBadgeParent.getParent());
        }
    }

    private float getTopCutOff(float f) {
        return (this.badgeCenterY - this.halfBadgeHeight) + f;
    }

    private float getLeftCutOff(float f) {
        return (this.badgeCenterX - this.halfBadgeWidth) + f;
    }

    private float getBottomCutOff(float f, float f2) {
        return ((this.badgeCenterY + this.halfBadgeHeight) - f) + f2;
    }

    private float getRightCutoff(float f, float f2) {
        return ((this.badgeCenterX + this.halfBadgeWidth) - f) + f2;
    }

    private void drawBadgeContent(Canvas canvas) {
        String badgeContent = getBadgeContent();
        if (badgeContent != null) {
            Rect rect = new Rect();
            this.textDrawableHelper.getTextPaint().getTextBounds(badgeContent, 0, badgeContent.length(), rect);
            float fExactCenterY = this.badgeCenterY - rect.exactCenterY();
            canvas.drawText(badgeContent, this.badgeCenterX, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.textDrawableHelper.getTextPaint());
        }
    }

    private boolean hasBadgeContent() {
        return hasText() || hasNumber();
    }

    private String getBadgeContent() {
        if (hasText()) {
            return getTextBadgeText();
        }
        if (hasNumber()) {
            return getNumberBadgeText();
        }
        return null;
    }

    private String getTextBadgeText() {
        String text = getText();
        int maxCharacterCount = getMaxCharacterCount();
        if (maxCharacterCount == -2 || text == null || text.length() <= maxCharacterCount) {
            return text;
        }
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R$string.m3_exceed_max_badge_text_suffix), text.substring(0, maxCharacterCount - 1), "…");
    }

    private String getNumberBadgeText() {
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance(this.state.getNumberLocale()).format(getNumber());
        }
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(this.state.getNumberLocale(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.maxBadgeNumber), "+");
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void updateMaxBadgeNumber() {
        if (getMaxCharacterCount() != -2) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
        } else {
            this.maxBadgeNumber = getMaxNumber();
        }
    }
}
