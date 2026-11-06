package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class VideoComponentViewKt$VideoComponentView$5$2 extends AdaptedFunctionReference implements Function2 {
    public static final VideoComponentViewKt$VideoComponentView$5$2 INSTANCE = new VideoComponentViewKt$VideoComponentView$5$2();

    VideoComponentViewKt$VideoComponentView$5$2() {
        super(2, OverlayKt.class, "overlay", "overlay(Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Modifier invoke(Modifier p0, ColorStyle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return OverlayKt.overlay$default(p0, p1, null, 2, null);
    }
}
