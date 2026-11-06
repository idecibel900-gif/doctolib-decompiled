package com.revenuecat.purchases.ui.revenuecatui.extensions;

import android.content.Context;
import coil.ImageLoader;
import com.revenuecat.purchases.Purchases;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getImageLoaderTyped", "Lcoil/ImageLoader;", "Lcom/revenuecat/purchases/Purchases$Companion;", "context", "Landroid/content/Context;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchasesExtensionsKt {
    public static final ImageLoader getImageLoaderTyped(Purchases.Companion companion, Context context) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Object imageLoader = Purchases.INSTANCE.getImageLoader(context);
        Intrinsics.checkNotNull(imageLoader, "null cannot be cast to non-null type coil.ImageLoader");
        return (ImageLoader) imageLoader;
    }
}
