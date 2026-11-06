package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"scrollable", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "scrollOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ScrollableKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ Modifier scrollable(Modifier modifier, ScrollState scrollState, Orientation scrollOrientation) {
        Modifier modifierVerticalScroll$default;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(scrollOrientation, "scrollOrientation");
        int i = WhenMappings.$EnumSwitchMapping$0[scrollOrientation.ordinal()];
        if (i == 1) {
            modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.Companion, scrollState, false, null, false, 14, null);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            modifierVerticalScroll$default = ScrollKt.horizontalScroll$default(Modifier.Companion, scrollState, false, null, false, 14, null);
        }
        return modifier.then(modifierVerticalScroll$default);
    }
}
