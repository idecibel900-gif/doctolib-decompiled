package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"dpOrNull", "Landroidx/compose/ui/unit/Dp;", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class SizeConstraintExtensionsKt {
    public static final /* synthetic */ Dp dpOrNull(SizeConstraint sizeConstraint) {
        Intrinsics.checkNotNullParameter(sizeConstraint, "<this>");
        if (!(sizeConstraint instanceof SizeConstraint.Fixed)) {
            if ((sizeConstraint instanceof SizeConstraint.Fill) || (sizeConstraint instanceof SizeConstraint.Fit)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        return Dp.m2549boximpl(Dp.m2551constructorimpl(((SizeConstraint.Fixed) sizeConstraint).getValue()));
    }
}
