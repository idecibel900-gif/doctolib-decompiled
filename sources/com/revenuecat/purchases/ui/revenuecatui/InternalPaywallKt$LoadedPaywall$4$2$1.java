package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class InternalPaywallKt$LoadedPaywall$4$2$1 extends AdaptedFunctionReference implements Function0 {
    InternalPaywallKt$LoadedPaywall$4$2$1(Object obj) {
        super(0, obj, PaywallViewModel.class, "closePaywall", "closePaywall(Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m4030invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4030invoke() {
        PaywallViewModel.DefaultImpls.closePaywall$default((PaywallViewModel) this.receiver, null, 1, null);
    }
}
