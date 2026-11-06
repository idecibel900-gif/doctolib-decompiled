package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatioKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class VideoComponentViewKt$VideoComponentView$5$1 extends FunctionReferenceImpl implements Function2 {
    public static final VideoComponentViewKt$VideoComponentView$5$1 INSTANCE = new VideoComponentViewKt$VideoComponentView$5$1();

    VideoComponentViewKt$VideoComponentView$5$1() {
        super(2, AspectRatioKt.class, "aspectRatio", "aspectRatio(Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;)Landroidx/compose/ui/Modifier;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Modifier invoke(Modifier p0, AspectRatio p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return AspectRatioKt.aspectRatio(p0, p1);
    }
}
