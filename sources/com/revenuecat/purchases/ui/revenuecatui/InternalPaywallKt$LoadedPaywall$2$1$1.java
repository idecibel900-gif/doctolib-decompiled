package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class InternalPaywallKt$LoadedPaywall$2$1$1 extends FunctionReferenceImpl implements Function1 {
    InternalPaywallKt$LoadedPaywall$2$1$1(Object obj) {
        super(1, obj, PaywallViewModel.class, "selectPackage", "selectPackage(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TemplateConfiguration.PackageInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TemplateConfiguration.PackageInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PaywallViewModel) this.receiver).selectPackage(p0);
    }
}
