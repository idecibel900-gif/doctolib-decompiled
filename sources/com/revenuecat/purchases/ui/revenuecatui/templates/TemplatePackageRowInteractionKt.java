package com.revenuecat.purchases.ui.revenuecatui.templates;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"trackTemplatePackageRowSelectionIfChanged", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "defaultPackageInfo", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TemplatePackageRowInteractionKt {
    public static /* synthetic */ void trackTemplatePackageRowSelectionIfChanged$default(PaywallViewModel paywallViewModel, PaywallState.Loaded.Legacy legacy, TemplateConfiguration.PackageInfo packageInfo, TemplateConfiguration.PackageInfo packageInfo2, int i, Object obj) {
        if ((i & 4) != 0) {
            packageInfo2 = legacy.getTemplateConfiguration().getPackages().getDefault();
        }
        trackTemplatePackageRowSelectionIfChanged(paywallViewModel, legacy, packageInfo, packageInfo2);
    }

    public static final void trackTemplatePackageRowSelectionIfChanged(PaywallViewModel paywallViewModel, PaywallState.Loaded.Legacy state, TemplateConfiguration.PackageInfo packageInfo, TemplateConfiguration.PackageInfo defaultPackageInfo) {
        Intrinsics.checkNotNullParameter(paywallViewModel, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        Intrinsics.checkNotNullParameter(defaultPackageInfo, "defaultPackageInfo");
        TemplateConfiguration.PackageInfo packageInfo2 = (TemplateConfiguration.PackageInfo) state.getSelectedPackage().getValue();
        Package rcPackage = packageInfo2 != null ? packageInfo2.getRcPackage() : null;
        Package rcPackage2 = packageInfo.getRcPackage();
        if (Intrinsics.areEqual(rcPackage != null ? rcPackage.getIdentifier() : null, rcPackage2.getIdentifier())) {
            return;
        }
        paywallViewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallPackageRowSelection(null, rcPackage2, rcPackage, defaultPackageInfo.getRcPackage()));
    }
}
