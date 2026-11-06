package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1 extends FunctionReferenceImpl implements Function0 {
    InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1(Object obj) {
        super(0, obj, PaywallViewModel.class, "clearActionError", "clearActionError()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m4026invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4026invoke() {
        ((PaywallViewModel) this.receiver).clearActionError();
    }
}
