package com.revenuecat.purchases.ui.revenuecatui.components.state;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "isSelected", "", "()Z", "isSelected$delegate", "Landroidx/compose/runtime/State;", "offerEligibility", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "offerEligibility$delegate", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PackageAwareDelegate {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: isSelected$delegate, reason: from kotlin metadata */
    private final State isSelected;

    /* JADX INFO: renamed from: offerEligibility$delegate, reason: from kotlin metadata */
    private final State offerEligibility;
    private final Function0 selectedOfferEligibilityProvider;
    private final Function0 selectedPackageInfoProvider;
    private final Function0 selectedTabIndexProvider;
    private final PackageContext style;

    public PackageAwareDelegate(PackageContext style, Function0 selectedPackageInfoProvider, Function0 selectedTabIndexProvider, Function0 selectedOfferEligibilityProvider) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.isSelected = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate.isSelected.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(PackageAwareDelegate.this.style.computeIsSelected((PaywallState.Loaded.Components.SelectedPackageInfo) PackageAwareDelegate.this.selectedPackageInfoProvider.invoke(), ((Number) PackageAwareDelegate.this.selectedTabIndexProvider.invoke()).intValue()));
            }
        });
        this.offerEligibility = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate$offerEligibility$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OfferEligibility invoke() {
                return this.this$0.style.resolveOfferEligibility((OfferEligibility) this.this$0.selectedOfferEligibilityProvider.invoke());
            }
        });
    }

    public final boolean isSelected() {
        return ((Boolean) this.isSelected.getValue()).booleanValue();
    }

    public final OfferEligibility getOfferEligibility() {
        return (OfferEligibility) this.offerEligibility.getValue();
    }
}
