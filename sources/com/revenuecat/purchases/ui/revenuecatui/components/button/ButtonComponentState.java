package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.intl.Locale;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J*\u0010\u000e\u001a\u0004\u0018\u00010\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u000e\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentState;", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;Lkotlin/jvm/functions/Function0;)V", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "getAction", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "action$delegate", "Landroidx/compose/runtime/State;", "toPaywallAction", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "localeId", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "componentId", "", "toPaywallAction-uY6zL4k", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo;", "toPaywallAction-64pKzr8", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: action$delegate, reason: from kotlin metadata */
    private final State action;
    private final Function0 localeProvider;
    private final ButtonComponentStyle style;

    public ButtonComponentState(ButtonComponentStyle style, Function0 localeProvider) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.action = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentState$action$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaywallAction invoke() {
                ButtonComponentState buttonComponentState = this.this$0;
                return buttonComponentState.m4055toPaywallActionuY6zL4k(buttonComponentState.style.getAction(), LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke()), this.this$0.style.getComponentId());
            }
        });
    }

    public final /* synthetic */ PaywallAction getAction() {
        return (PaywallAction) this.action.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toPaywallAction-uY6zL4k, reason: not valid java name */
    public final PaywallAction m4055toPaywallActionuY6zL4k(ButtonComponentStyle.Action action, String str, String str2) {
        if (action instanceof ButtonComponentStyle.Action.NavigateBack) {
            return PaywallAction.External.NavigateBack.INSTANCE;
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateTo) {
            return m4054toPaywallAction64pKzr8((ButtonComponentStyle.Action.NavigateTo) action, str);
        }
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage) {
            ButtonComponentStyle.Action.PurchasePackage purchasePackage = (ButtonComponentStyle.Action.PurchasePackage) action;
            return new PaywallAction.External.PurchasePackage(purchasePackage.getRcPackage(), purchasePackage.getResolvedOffer());
        }
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases) {
            return PaywallAction.External.RestorePurchases.INSTANCE;
        }
        if (action instanceof ButtonComponentStyle.Action.WebCheckout) {
            ButtonComponentStyle.Action.WebCheckout webCheckout = (ButtonComponentStyle.Action.WebCheckout) action;
            return new PaywallAction.External.LaunchWebCheckout(null, webCheckout.getOpenMethod(), webCheckout.getAutoDismiss(), new PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append(webCheckout.getRcPackage(), null));
        }
        if (action instanceof ButtonComponentStyle.Action.WebProductSelection) {
            ButtonComponentStyle.Action.WebProductSelection webProductSelection = (ButtonComponentStyle.Action.WebProductSelection) action;
            return new PaywallAction.External.LaunchWebCheckout(null, webProductSelection.getOpenMethod(), webProductSelection.getAutoDismiss(), PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.DoNotAppend.INSTANCE);
        }
        if (action instanceof ButtonComponentStyle.Action.CustomWebCheckout) {
            ButtonComponentStyle.Action.CustomWebCheckout customWebCheckout = (ButtonComponentStyle.Action.CustomWebCheckout) action;
            NonEmptyMap<LocaleId, String> urls = customWebCheckout.getUrls();
            return new PaywallAction.External.LaunchWebCheckout((String) urls.getOrDefault(LocaleId.m3953boximpl(str), urls.getEntry().getValue()), customWebCheckout.getOpenMethod(), customWebCheckout.getAutoDismiss(), new PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append(customWebCheckout.getRcPackage(), customWebCheckout.getPackageParam()));
        }
        if (!(action instanceof ButtonComponentStyle.Action.WorkflowTrigger)) {
            throw new NoWhenBranchMatchedException();
        }
        if (str2 != null) {
            return new PaywallAction.External.WorkflowTrigger(str2, WorkflowTriggerType.ON_PRESS);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toPaywallAction-64pKzr8, reason: not valid java name */
    private final PaywallAction m4054toPaywallAction64pKzr8(ButtonComponentStyle.Action.NavigateTo navigateTo, String str) {
        ButtonComponentStyle.Action.NavigateTo.Destination destination = navigateTo.getDestination();
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter) {
            return new PaywallAction.External.NavigateTo(PaywallAction.External.NavigateTo.Destination.CustomerCenter.INSTANCE);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Url) {
            NonEmptyMap urls = ((ButtonComponentStyle.Action.NavigateTo.Destination.Url) navigateTo.getDestination()).getUrls();
            return new PaywallAction.External.NavigateTo(new PaywallAction.External.NavigateTo.Destination.Url((String) urls.getOrDefault(LocaleId.m3953boximpl(str), urls.getEntry().getValue()), ((ButtonComponentStyle.Action.NavigateTo.Destination.Url) navigateTo.getDestination()).getMethod()));
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) {
            return new PaywallAction.Internal.NavigateTo(new PaywallAction.Internal.NavigateTo.Destination.Sheet((ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) navigateTo.getDestination()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
