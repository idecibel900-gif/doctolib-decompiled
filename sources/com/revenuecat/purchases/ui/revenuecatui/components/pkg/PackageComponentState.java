package com.revenuecat.purchases.ui.revenuecatui.components.pkg;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007¢\u0006\u0002\u0010\u0011J\u000e\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0003R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/pkg/PackageComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "presentedPartial$delegate", "Landroidx/compose/runtime/State;", "visible", "", "getVisible", "()Z", "visible$delegate", "<set-?>", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PackageComponentState {
    public static final int $stable = 0;
    private final Function0 customVariablesProvider;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;
    private final Function0 selectedOfferEligibilityProvider;
    private final Function0 selectedPackageInfoProvider;
    private final Function0 selectedTabIndexProvider;
    private final PackageComponentStyle style;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    public PackageComponentState(WindowWidthSizeClass initialWindowSize, PackageComponentStyle style, Function0 selectedPackageInfoProvider, Function0 selectedTabIndexProvider, Function0 selectedOfferEligibilityProvider, Function0 customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialWindowSize, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedPackagePartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedPackagePartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialPackageComponent partial;
                Boolean visible;
                PresentedPackagePartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
    }

    public /* synthetic */ PackageComponentState(WindowWidthSizeClass windowWidthSizeClass, PackageComponentStyle packageComponentStyle, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, packageComponentStyle, function0, function1, function2, (i & 32) != 0 ? new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedPackagePartial getPresentedPartial() {
        return (PresentedPackagePartial) this.presentedPartial.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize) {
        Intrinsics.checkNotNullParameter(windowSize, "windowSize");
        setWindowSize(windowSize);
    }
}
