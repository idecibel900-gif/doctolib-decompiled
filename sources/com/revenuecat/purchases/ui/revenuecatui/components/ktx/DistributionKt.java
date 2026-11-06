package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"toHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;", "spacing", "Landroidx/compose/ui/unit/Dp;", "toHorizontalArrangement-3ABfNKs", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;F)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "toVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "toVerticalArrangement-3ABfNKs", "(Lcom/revenuecat/purchases/paywalls/components/properties/FlexDistribution;F)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class DistributionKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlexDistribution.values().length];
            try {
                iArr[FlexDistribution.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlexDistribution.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlexDistribution.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlexDistribution.SPACE_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FlexDistribution.SPACE_AROUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FlexDistribution.SPACE_EVENLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: toHorizontalArrangement-3ABfNKs, reason: not valid java name */
    public static final /* synthetic */ Arrangement.Horizontal m4075toHorizontalArrangement3ABfNKs(FlexDistribution toHorizontalArrangement, float f) {
        Intrinsics.checkNotNullParameter(toHorizontalArrangement, "$this$toHorizontalArrangement");
        switch (WhenMappings.$EnumSwitchMapping$0[toHorizontalArrangement.ordinal()]) {
            case 1:
                return Arrangement.INSTANCE.m277spacedByD5KLDUw(f, Alignment.Companion.getStart());
            case 2:
                return Arrangement.INSTANCE.m277spacedByD5KLDUw(f, Alignment.Companion.getEnd());
            case 3:
                return Arrangement.INSTANCE.m277spacedByD5KLDUw(f, Alignment.Companion.getCenterHorizontally());
            case 4:
            case 5:
            case 6:
                return Arrangement.INSTANCE.getStart();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: toVerticalArrangement-3ABfNKs, reason: not valid java name */
    public static final /* synthetic */ Arrangement.Vertical m4076toVerticalArrangement3ABfNKs(FlexDistribution toVerticalArrangement, float f) {
        Intrinsics.checkNotNullParameter(toVerticalArrangement, "$this$toVerticalArrangement");
        switch (WhenMappings.$EnumSwitchMapping$0[toVerticalArrangement.ordinal()]) {
            case 1:
                return Arrangement.INSTANCE.m278spacedByD5KLDUw(f, Alignment.Companion.getTop());
            case 2:
                return Arrangement.INSTANCE.m278spacedByD5KLDUw(f, Alignment.Companion.getBottom());
            case 3:
                return Arrangement.INSTANCE.m278spacedByD5KLDUw(f, Alignment.Companion.getCenterVertically());
            case 4:
            case 5:
            case 6:
                return Arrangement.INSTANCE.getTop();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
