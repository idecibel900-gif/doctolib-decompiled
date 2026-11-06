package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.revenuecat.purchases.Offering;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1 extends FunctionReferenceImpl implements Function2 {
    PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1(Object obj) {
        super(2, obj, PaywallActivity.class, "onDismissRequest", "onDismissRequest(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Offering) obj, (PaywallResult) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Offering offering, PaywallResult paywallResult) {
        ((PaywallActivity) this.receiver).onDismissRequest(offering, paywallResult);
    }
}
