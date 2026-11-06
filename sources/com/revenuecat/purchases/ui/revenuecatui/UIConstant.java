package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001d\"\u0004\b\u0000\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0011\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0015\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u001a\u0010\rR\u000e\u0010\u001b\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/UIConstant;", "", "()V", "defaultAnimationDurationMillis", "", "defaultColorAnimation", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/graphics/Color;", "getDefaultColorAnimation", "()Landroidx/compose/animation/core/AnimationSpec;", "defaultCornerRadius", "Landroidx/compose/ui/unit/Dp;", "getDefaultCornerRadius-D9Ej5fM", "()F", "F", "defaultHorizontalPadding", "getDefaultHorizontalPadding-D9Ej5fM", "defaultPackageBorderWidth", "getDefaultPackageBorderWidth-D9Ej5fM", "defaultPackageCornerRadius", "getDefaultPackageCornerRadius-D9Ej5fM", "defaultVerticalSpacing", "getDefaultVerticalSpacing-D9Ej5fM", "halfWeight", "", "iconButtonSize", "getIconButtonSize-D9Ej5fM", "purchaseInProgressButtonOpacity", "defaultAnimation", "Landroidx/compose/animation/core/TweenSpec;", "T", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UIConstant {
    public static final int defaultAnimationDurationMillis = 200;
    private static final float defaultHorizontalPadding;
    private static final float defaultVerticalSpacing;
    public static final float halfWeight = 0.5f;
    public static final float purchaseInProgressButtonOpacity = 0.4f;
    public static final UIConstant INSTANCE = new UIConstant();
    private static final float defaultCornerRadius = Dp.m2551constructorimpl(20);
    private static final float defaultPackageCornerRadius = Dp.m2551constructorimpl(16);
    private static final float defaultPackageBorderWidth = Dp.m2551constructorimpl((float) 1.5d);
    private static final AnimationSpec defaultColorAnimation = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);
    private static final float iconButtonSize = Dp.m2551constructorimpl(48);
    public static final int $stable = 8;

    private UIConstant() {
    }

    /* JADX INFO: renamed from: getDefaultHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4040getDefaultHorizontalPaddingD9Ej5fM() {
        return defaultHorizontalPadding;
    }

    /* JADX INFO: renamed from: getDefaultVerticalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4043getDefaultVerticalSpacingD9Ej5fM() {
        return defaultVerticalSpacing;
    }

    /* JADX INFO: renamed from: getDefaultCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m4039getDefaultCornerRadiusD9Ej5fM() {
        return defaultCornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultPackageCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m4042getDefaultPackageCornerRadiusD9Ej5fM() {
        return defaultPackageCornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultPackageBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m4041getDefaultPackageBorderWidthD9Ej5fM() {
        return defaultPackageBorderWidth;
    }

    public final AnimationSpec getDefaultColorAnimation() {
        return defaultColorAnimation;
    }

    /* JADX INFO: renamed from: getIconButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m4044getIconButtonSizeD9Ej5fM() {
        return iconButtonSize;
    }

    public final <T> TweenSpec defaultAnimation() {
        return AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
    }

    static {
        float f = 12;
        defaultHorizontalPadding = Dp.m2551constructorimpl(f);
        defaultVerticalSpacing = Dp.m2551constructorimpl(f);
    }
}
