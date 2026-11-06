package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class URLOpener$openURL$1 extends FunctionReferenceImpl implements Function1 {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    URLOpener$openURL$1(Context context) {
        super(1, Intrinsics.Kotlin.class, "handleException", "openURL$handleException(Landroid/content/Context;Ljava/lang/Exception;)V", 0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Exception p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        URLOpener.openURL$handleException(this.$context, p0);
    }
}
