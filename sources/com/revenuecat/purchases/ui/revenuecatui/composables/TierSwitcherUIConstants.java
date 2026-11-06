package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/TierSwitcherUIConstants;", "", "()V", "minimumHeight", "Landroidx/compose/ui/unit/Dp;", "getMinimumHeight-D9Ej5fM", "()F", "F", "roundedCorner", "", "selectedTierPadding", "getSelectedTierPadding-D9Ej5fM", "tierHorizontalPadding", "getTierHorizontalPadding-D9Ej5fM", "tierTextPaddingHorizontal", "getTierTextPaddingHorizontal-D9Ej5fM", "tierTextPaddingVertical", "getTierTextPaddingVertical-D9Ej5fM", "tierVerticalPadding", "getTierVerticalPadding-D9Ej5fM", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TierSwitcherUIConstants {
    public static final int roundedCorner = 50;
    public static final TierSwitcherUIConstants INSTANCE = new TierSwitcherUIConstants();
    private static final float minimumHeight = Dp.m2551constructorimpl(40);
    private static final float selectedTierPadding = Dp.m2551constructorimpl(2);
    private static final float tierTextPaddingHorizontal = Dp.m2551constructorimpl(10);
    private static final float tierTextPaddingVertical = Dp.m2551constructorimpl(4);
    private static final float tierHorizontalPadding = Dp.m2551constructorimpl(16);
    private static final float tierVerticalPadding = Dp.m2551constructorimpl(8);

    private TierSwitcherUIConstants() {
    }

    /* JADX INFO: renamed from: getMinimumHeight-D9Ej5fM, reason: not valid java name */
    public final float m4300getMinimumHeightD9Ej5fM() {
        return minimumHeight;
    }

    /* JADX INFO: renamed from: getSelectedTierPadding-D9Ej5fM, reason: not valid java name */
    public final float m4301getSelectedTierPaddingD9Ej5fM() {
        return selectedTierPadding;
    }

    /* JADX INFO: renamed from: getTierTextPaddingHorizontal-D9Ej5fM, reason: not valid java name */
    public final float m4303getTierTextPaddingHorizontalD9Ej5fM() {
        return tierTextPaddingHorizontal;
    }

    /* JADX INFO: renamed from: getTierTextPaddingVertical-D9Ej5fM, reason: not valid java name */
    public final float m4304getTierTextPaddingVerticalD9Ej5fM() {
        return tierTextPaddingVertical;
    }

    /* JADX INFO: renamed from: getTierHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4302getTierHorizontalPaddingD9Ej5fM() {
        return tierHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTierVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4305getTierVerticalPaddingD9Ej5fM() {
        return tierVerticalPadding;
    }
}
