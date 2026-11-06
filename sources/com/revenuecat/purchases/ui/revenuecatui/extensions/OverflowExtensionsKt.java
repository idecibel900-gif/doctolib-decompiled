package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.foundation.gestures.Orientation;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class OverflowExtensionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackComponent.Overflow.values().length];
            try {
                iArr[StackComponent.Overflow.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackComponent.Overflow.SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ Orientation toOrientation(StackComponent.Overflow overflow, Dimension dimension) {
        Intrinsics.checkNotNullParameter(overflow, "<this>");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        int i = WhenMappings.$EnumSwitchMapping$0[overflow.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (dimension instanceof Dimension.Horizontal) {
            return Orientation.Horizontal;
        }
        if (dimension instanceof Dimension.Vertical) {
            return Orientation.Vertical;
        }
        if (dimension instanceof Dimension.ZLayer) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
