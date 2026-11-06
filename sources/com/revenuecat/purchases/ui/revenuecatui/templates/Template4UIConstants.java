package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/templates/Template4UIConstants;", "", "()V", "checkmarkPadding", "Landroidx/compose/ui/unit/Dp;", "getCheckmarkPadding-D9Ej5fM", "()F", "F", "checkmarkSize", "getCheckmarkSize-D9Ej5fM", "discountVerticalPadding", "getDiscountVerticalPadding-D9Ej5fM", "maxPackagesToDisplay", "", "packageButtonContentVerticalSpacing", "getPackageButtonContentVerticalSpacing-D9Ej5fM", "packageHorizontalSpacing", "getPackageHorizontalSpacing-D9Ej5fM", "packagesHorizontalPadding", "getPackagesHorizontalPadding-D9Ej5fM", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Template4UIConstants {
    private static final float checkmarkPadding;
    private static final float discountVerticalPadding;
    public static final float maxPackagesToDisplay = 3.0f;
    private static final float packageButtonContentVerticalSpacing;
    private static final float packageHorizontalSpacing;
    public static final Template4UIConstants INSTANCE = new Template4UIConstants();
    private static final float packagesHorizontalPadding = Dp.m2551constructorimpl(24);
    private static final float checkmarkSize = Dp.m2551constructorimpl(18);

    private Template4UIConstants() {
    }

    /* JADX INFO: renamed from: getPackageButtonContentVerticalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4567getPackageButtonContentVerticalSpacingD9Ej5fM() {
        return packageButtonContentVerticalSpacing;
    }

    /* JADX INFO: renamed from: getPackageHorizontalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4568getPackageHorizontalSpacingD9Ej5fM() {
        return packageHorizontalSpacing;
    }

    /* JADX INFO: renamed from: getPackagesHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4569getPackagesHorizontalPaddingD9Ej5fM() {
        return packagesHorizontalPadding;
    }

    /* JADX INFO: renamed from: getCheckmarkSize-D9Ej5fM, reason: not valid java name */
    public final float m4565getCheckmarkSizeD9Ej5fM() {
        return checkmarkSize;
    }

    /* JADX INFO: renamed from: getCheckmarkPadding-D9Ej5fM, reason: not valid java name */
    public final float m4564getCheckmarkPaddingD9Ej5fM() {
        return checkmarkPadding;
    }

    /* JADX INFO: renamed from: getDiscountVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4566getDiscountVerticalPaddingD9Ej5fM() {
        return discountVerticalPadding;
    }

    static {
        float f = 4;
        packageButtonContentVerticalSpacing = Dp.m2551constructorimpl(f);
        float f2 = 8;
        packageHorizontalSpacing = Dp.m2551constructorimpl(f2);
        checkmarkPadding = Dp.m2551constructorimpl(f2);
        discountVerticalPadding = Dp.m2551constructorimpl(f);
    }
}
