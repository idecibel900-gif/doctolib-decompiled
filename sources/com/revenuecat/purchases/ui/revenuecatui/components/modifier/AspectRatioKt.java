package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0001¨\u0006\u0003"}, d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class AspectRatioKt {
    public static final /* synthetic */ Modifier aspectRatio(Modifier modifier, AspectRatio aspectRatio) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        return modifier.then(androidx.compose.foundation.layout.AspectRatioKt.aspectRatio(Modifier.Companion, aspectRatio.getRatio(), aspectRatio.getMatchHeightConstraintsFirst()));
    }
}
