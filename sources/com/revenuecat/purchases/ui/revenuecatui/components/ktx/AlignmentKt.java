package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0004H\u0000\u001a\u0011\u0010\b\u001a\u00020\t*\u00020\u0002H\u0000¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0000¨\u0006\f"}, d2 = {"toAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "Landroidx/compose/ui/Alignment;", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "Landroidx/compose/ui/Alignment$Vertical;", "Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "toHorizontalAlignmentOrNull", "toTextAlign", "Landroidx/compose/ui/text/style/TextAlign;", "(Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;)I", "toVerticalAlignmentOrNull", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class AlignmentKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[HorizontalAlignment.values().length];
            try {
                iArr[HorizontalAlignment.LEADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HorizontalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HorizontalAlignment.TRAILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VerticalAlignment.values().length];
            try {
                iArr2[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[VerticalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VerticalAlignment.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TwoDimensionalAlignment.values().length];
            try {
                iArr3[TwoDimensionalAlignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[TwoDimensionalAlignment.LEADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TRAILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP_LEADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP_TRAILING.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM_LEADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM_TRAILING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final /* synthetic */ int toTextAlign(HorizontalAlignment horizontalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[horizontalAlignment.ordinal()];
        if (i == 1) {
            return TextAlign.Companion.m2486getStarte0LSkKk();
        }
        if (i == 2) {
            return TextAlign.Companion.m2481getCentere0LSkKk();
        }
        if (i == 3) {
            return TextAlign.Companion.m2482getEnde0LSkKk();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment.Horizontal toAlignment(HorizontalAlignment horizontalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[horizontalAlignment.ordinal()];
        if (i == 1) {
            return Alignment.Companion.getStart();
        }
        if (i == 2) {
            return Alignment.Companion.getCenterHorizontally();
        }
        if (i == 3) {
            return Alignment.Companion.getEnd();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment.Vertical toAlignment(VerticalAlignment verticalAlignment) {
        Intrinsics.checkNotNullParameter(verticalAlignment, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[verticalAlignment.ordinal()];
        if (i == 1) {
            return Alignment.Companion.getTop();
        }
        if (i == 2) {
            return Alignment.Companion.getCenterVertically();
        }
        if (i == 3) {
            return Alignment.Companion.getBottom();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment toAlignment(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.Companion.getCenter();
            case 2:
                return Alignment.Companion.getCenterStart();
            case 3:
                return Alignment.Companion.getCenterEnd();
            case 4:
                return Alignment.Companion.getTopCenter();
            case 5:
                return Alignment.Companion.getBottomCenter();
            case 6:
                return Alignment.Companion.getTopStart();
            case 7:
                return Alignment.Companion.getTopEnd();
            case 8:
                return Alignment.Companion.getBottomStart();
            case 9:
                return Alignment.Companion.getBottomEnd();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ Alignment.Vertical toVerticalAlignmentOrNull(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.Companion.getCenterVertically();
            case 2:
            case 3:
                return null;
            case 4:
                return Alignment.Companion.getTop();
            case 5:
                return Alignment.Companion.getBottom();
            case 6:
                return Alignment.Companion.getTop();
            case 7:
                return Alignment.Companion.getTop();
            case 8:
                return Alignment.Companion.getBottom();
            case 9:
                return Alignment.Companion.getBottom();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ Alignment.Horizontal toHorizontalAlignmentOrNull(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.Companion.getCenterHorizontally();
            case 2:
                return Alignment.Companion.getStart();
            case 3:
                return Alignment.Companion.getEnd();
            case 4:
            case 5:
                return null;
            case 6:
                return Alignment.Companion.getStart();
            case 7:
                return Alignment.Companion.getEnd();
            case 8:
                return Alignment.Companion.getStart();
            case 9:
                return Alignment.Companion.getEnd();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
