package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001)B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003JA\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "stackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "transition", "Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "componentName", "", "componentId", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "getComponentId", "()Ljava/lang/String;", "getComponentName", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStackComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getTransition", "()Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "visible", "", "getVisible", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "Action", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ButtonComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Action action;
    private final String componentId;
    private final String componentName;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final PaywallTransition transition;
    private final boolean visible;

    public static /* synthetic */ ButtonComponentStyle copy$default(ButtonComponentStyle buttonComponentStyle, StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            stackComponentStyle = buttonComponentStyle.stackComponentStyle;
        }
        if ((i & 2) != 0) {
            action = buttonComponentStyle.action;
        }
        if ((i & 4) != 0) {
            paywallTransition = buttonComponentStyle.transition;
        }
        if ((i & 8) != 0) {
            str = buttonComponentStyle.componentName;
        }
        if ((i & 16) != 0) {
            str2 = buttonComponentStyle.componentId;
        }
        String str3 = str2;
        PaywallTransition paywallTransition2 = paywallTransition;
        return buttonComponentStyle.copy(stackComponentStyle, action, paywallTransition2, str, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaywallTransition getTransition() {
        return this.transition;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getComponentName() {
        return this.componentName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    public final ButtonComponentStyle copy(StackComponentStyle stackComponentStyle, Action action, PaywallTransition transition, String componentName, String componentId) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ButtonComponentStyle(stackComponentStyle, action, transition, componentName, componentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonComponentStyle)) {
            return false;
        }
        ButtonComponentStyle buttonComponentStyle = (ButtonComponentStyle) other;
        return Intrinsics.areEqual(this.stackComponentStyle, buttonComponentStyle.stackComponentStyle) && Intrinsics.areEqual(this.action, buttonComponentStyle.action) && Intrinsics.areEqual(this.transition, buttonComponentStyle.transition) && Intrinsics.areEqual(this.componentName, buttonComponentStyle.componentName) && Intrinsics.areEqual(this.componentId, buttonComponentStyle.componentId);
    }

    public int hashCode() {
        int iHashCode = ((this.stackComponentStyle.hashCode() * 31) + this.action.hashCode()) * 31;
        PaywallTransition paywallTransition = this.transition;
        int iHashCode2 = (iHashCode + (paywallTransition == null ? 0 : paywallTransition.hashCode())) * 31;
        String str = this.componentName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.componentId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ButtonComponentStyle(stackComponentStyle=" + this.stackComponentStyle + ", action=" + this.action + ", transition=" + this.transition + ", componentName=" + this.componentName + ", componentId=" + this.componentId + ')';
    }

    public ButtonComponentStyle(StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(action, "action");
        this.stackComponentStyle = stackComponentStyle;
        this.action = action;
        this.transition = paywallTransition;
        this.componentName = str;
        this.componentId = str2;
        this.visible = stackComponentStyle.getVisible();
        this.size = stackComponentStyle.getSize();
    }

    public /* synthetic */ ButtonComponentStyle(StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponentStyle, action, (i & 4) != 0 ? null : paywallTransition, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ PaywallTransition getTransition() {
        return this.transition;
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    public final /* synthetic */ String getComponentId() {
        return this.componentId;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\b\u0006\u0007\b\t\n\u000b\f\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "", b.c, "", "getDescription", "()Ljava/lang/String;", "CustomWebCheckout", "NavigateBack", "NavigateTo", "PurchasePackage", "RestorePurchases", "WebCheckout", "WebProductSelection", "WorkflowTrigger", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$CustomWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WebProductSelection;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WorkflowTrigger;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Action {
        /* synthetic */ String getDescription();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RestorePurchases implements Action {
            public static final int $stable = 0;
            public static final RestorePurchases INSTANCE = new RestorePurchases();

            private RestorePurchases() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateBack implements Action {
            public static final int $stable = 0;
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WorkflowTrigger;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class WorkflowTrigger implements Action {
            public static final int $stable = 0;
            public static final WorkflowTrigger INSTANCE = new WorkflowTrigger();

            private WorkflowTrigger() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ String getDescription(Action action) {
                return "unknown";
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;)V", b.c, "", "getDescription", "()Ljava/lang/String;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class PurchasePackage implements Action {
            public static final int $stable = 8;
            private final Package rcPackage;
            private final ResolvedOffer resolvedOffer;

            public static /* synthetic */ PurchasePackage copy$default(PurchasePackage purchasePackage, Package r1, ResolvedOffer resolvedOffer, int i, Object obj) {
                if ((i & 1) != 0) {
                    r1 = purchasePackage.rcPackage;
                }
                if ((i & 2) != 0) {
                    resolvedOffer = purchasePackage.resolvedOffer;
                }
                return purchasePackage.copy(r1, resolvedOffer);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Package getRcPackage() {
                return this.rcPackage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ResolvedOffer getResolvedOffer() {
                return this.resolvedOffer;
            }

            public final PurchasePackage copy(Package rcPackage, ResolvedOffer resolvedOffer) {
                return new PurchasePackage(rcPackage, resolvedOffer);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PurchasePackage)) {
                    return false;
                }
                PurchasePackage purchasePackage = (PurchasePackage) other;
                return Intrinsics.areEqual(this.rcPackage, purchasePackage.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, purchasePackage.resolvedOffer);
            }

            public int hashCode() {
                Package r0 = this.rcPackage;
                int iHashCode = (r0 == null ? 0 : r0.hashCode()) * 31;
                ResolvedOffer resolvedOffer = this.resolvedOffer;
                return iHashCode + (resolvedOffer != null ? resolvedOffer.hashCode() : 0);
            }

            public String toString() {
                return "PurchasePackage(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ')';
            }

            public PurchasePackage(Package r1, ResolvedOffer resolvedOffer) {
                this.rcPackage = r1;
                this.resolvedOffer = resolvedOffer;
            }

            public /* synthetic */ PurchasePackage(Package r1, ResolvedOffer resolvedOffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(r1, (i & 2) != 0 ? null : resolvedOffer);
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final ResolvedOffer getResolvedOffer() {
                return this.resolvedOffer;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "(Lcom/revenuecat/purchases/Package;ZLcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getAutoDismiss", "()Z", b.c, "", "getDescription", "()Ljava/lang/String;", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class WebCheckout implements Action {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;
            private final Package rcPackage;

            public static /* synthetic */ WebCheckout copy$default(WebCheckout webCheckout, Package r1, boolean z, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    r1 = webCheckout.rcPackage;
                }
                if ((i & 2) != 0) {
                    z = webCheckout.autoDismiss;
                }
                if ((i & 4) != 0) {
                    urlMethod = webCheckout.openMethod;
                }
                return webCheckout.copy(r1, z, urlMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Package getRcPackage() {
                return this.rcPackage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final WebCheckout copy(Package rcPackage, boolean autoDismiss, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new WebCheckout(rcPackage, autoDismiss, openMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WebCheckout)) {
                    return false;
                }
                WebCheckout webCheckout = (WebCheckout) other;
                return Intrinsics.areEqual(this.rcPackage, webCheckout.rcPackage) && this.autoDismiss == webCheckout.autoDismiss && this.openMethod == webCheckout.openMethod;
            }

            public int hashCode() {
                Package r0 = this.rcPackage;
                return ((((r0 == null ? 0 : r0.hashCode()) * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.openMethod.hashCode();
            }

            public String toString() {
                return "WebCheckout(rcPackage=" + this.rcPackage + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }

            public WebCheckout(Package r2, boolean z, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.rcPackage = r2;
                this.autoDismiss = z;
                this.openMethod = openMethod;
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "web_checkout";
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$WebProductSelection;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "(ZLcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getAutoDismiss", "()Z", b.c, "", "getDescription", "()Ljava/lang/String;", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class WebProductSelection implements Action {
            public static final int $stable = 0;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            public static /* synthetic */ WebProductSelection copy$default(WebProductSelection webProductSelection, boolean z, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = webProductSelection.autoDismiss;
                }
                if ((i & 2) != 0) {
                    urlMethod = webProductSelection.openMethod;
                }
                return webProductSelection.copy(z, urlMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final WebProductSelection copy(boolean autoDismiss, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new WebProductSelection(autoDismiss, openMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WebProductSelection)) {
                    return false;
                }
                WebProductSelection webProductSelection = (WebProductSelection) other;
                return this.autoDismiss == webProductSelection.autoDismiss && this.openMethod == webProductSelection.openMethod;
            }

            public int hashCode() {
                return (Boolean.hashCode(this.autoDismiss) * 31) + this.openMethod.hashCode();
            }

            public String toString() {
                return "WebProductSelection(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }

            public WebProductSelection(boolean z, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.autoDismiss = z;
                this.openMethod = openMethod;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "web_product_selection";
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$CustomWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "urls", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "packageParam", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;ZLcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lcom/revenuecat/purchases/Package;Ljava/lang/String;)V", "getAutoDismiss", "()Z", b.c, "getDescription", "()Ljava/lang/String;", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getPackageParam", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getUrls", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class CustomWebCheckout implements Action {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;
            private final String packageParam;
            private final Package rcPackage;
            private final NonEmptyMap<LocaleId, String> urls;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CustomWebCheckout copy$default(CustomWebCheckout customWebCheckout, NonEmptyMap nonEmptyMap, boolean z, ButtonComponent.UrlMethod urlMethod, Package r4, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    nonEmptyMap = customWebCheckout.urls;
                }
                if ((i & 2) != 0) {
                    z = customWebCheckout.autoDismiss;
                }
                if ((i & 4) != 0) {
                    urlMethod = customWebCheckout.openMethod;
                }
                if ((i & 8) != 0) {
                    r4 = customWebCheckout.rcPackage;
                }
                if ((i & 16) != 0) {
                    str = customWebCheckout.packageParam;
                }
                String str2 = str;
                ButtonComponent.UrlMethod urlMethod2 = urlMethod;
                return customWebCheckout.copy(nonEmptyMap, z, urlMethod2, r4, str2);
            }

            public final NonEmptyMap<LocaleId, String> component1() {
                return this.urls;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Package getRcPackage() {
                return this.rcPackage;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getPackageParam() {
                return this.packageParam;
            }

            public final CustomWebCheckout copy(NonEmptyMap<LocaleId, String> urls, boolean autoDismiss, ButtonComponent.UrlMethod openMethod, Package rcPackage, String packageParam) {
                Intrinsics.checkNotNullParameter(urls, "urls");
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new CustomWebCheckout(urls, autoDismiss, openMethod, rcPackage, packageParam);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CustomWebCheckout)) {
                    return false;
                }
                CustomWebCheckout customWebCheckout = (CustomWebCheckout) other;
                return Intrinsics.areEqual(this.urls, customWebCheckout.urls) && this.autoDismiss == customWebCheckout.autoDismiss && this.openMethod == customWebCheckout.openMethod && Intrinsics.areEqual(this.rcPackage, customWebCheckout.rcPackage) && Intrinsics.areEqual(this.packageParam, customWebCheckout.packageParam);
            }

            public int hashCode() {
                int iHashCode = ((((this.urls.hashCode() * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.openMethod.hashCode()) * 31;
                Package r1 = this.rcPackage;
                int iHashCode2 = (iHashCode + (r1 == null ? 0 : r1.hashCode())) * 31;
                String str = this.packageParam;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "CustomWebCheckout(urls=" + this.urls + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ", rcPackage=" + this.rcPackage + ", packageParam=" + this.packageParam + ')';
            }

            public CustomWebCheckout(NonEmptyMap<LocaleId, String> urls, boolean z, ButtonComponent.UrlMethod openMethod, Package r5, String str) {
                Intrinsics.checkNotNullParameter(urls, "urls");
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.urls = urls;
                this.autoDismiss = z;
                this.openMethod = openMethod;
                this.rcPackage = r5;
                this.packageParam = str;
            }

            public final NonEmptyMap<LocaleId, String> getUrls() {
                return this.urls;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final String getPackageParam() {
                return this.packageParam;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "custom_web_checkout";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "destination", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "Destination", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateTo implements Action {
            public static final int $stable = 8;
            private final Destination destination;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) obj).destination);
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "", "CustomerCenter", "Sheet", "Url", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Url;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public interface Destination {

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class CustomerCenter implements Destination {
                    public static final int $stable = 0;
                    public static final CustomerCenter INSTANCE = new CustomerCenter();

                    private CustomerCenter() {
                    }
                }

                @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Url;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", "urls", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "componentInteractionValue", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Ljava/lang/String;)V", "getComponentInteractionValue", "()Ljava/lang/String;", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrls", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Url implements Destination {
                    public static final int $stable = 8;
                    private final String componentInteractionValue;
                    private final ButtonComponent.UrlMethod method;
                    private final NonEmptyMap<LocaleId, String> urls;

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Url copy$default(Url url, NonEmptyMap nonEmptyMap, ButtonComponent.UrlMethod urlMethod, String str, int i, Object obj) {
                        if ((i & 1) != 0) {
                            nonEmptyMap = url.urls;
                        }
                        if ((i & 2) != 0) {
                            urlMethod = url.method;
                        }
                        if ((i & 4) != 0) {
                            str = url.componentInteractionValue;
                        }
                        return url.copy(nonEmptyMap, urlMethod, str);
                    }

                    public final NonEmptyMap<LocaleId, String> component1() {
                        return this.urls;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final String getComponentInteractionValue() {
                        return this.componentInteractionValue;
                    }

                    public final Url copy(NonEmptyMap<LocaleId, String> urls, ButtonComponent.UrlMethod method, String componentInteractionValue) {
                        Intrinsics.checkNotNullParameter(urls, "urls");
                        Intrinsics.checkNotNullParameter(method, "method");
                        Intrinsics.checkNotNullParameter(componentInteractionValue, "componentInteractionValue");
                        return new Url(urls, method, componentInteractionValue);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Url)) {
                            return false;
                        }
                        Url url = (Url) other;
                        return Intrinsics.areEqual(this.urls, url.urls) && this.method == url.method && Intrinsics.areEqual(this.componentInteractionValue, url.componentInteractionValue);
                    }

                    public int hashCode() {
                        return (((this.urls.hashCode() * 31) + this.method.hashCode()) * 31) + this.componentInteractionValue.hashCode();
                    }

                    public String toString() {
                        return "Url(urls=" + this.urls + ", method=" + this.method + ", componentInteractionValue=" + this.componentInteractionValue + ')';
                    }

                    public Url(NonEmptyMap<LocaleId, String> urls, ButtonComponent.UrlMethod method, String componentInteractionValue) {
                        Intrinsics.checkNotNullParameter(urls, "urls");
                        Intrinsics.checkNotNullParameter(method, "method");
                        Intrinsics.checkNotNullParameter(componentInteractionValue, "componentInteractionValue");
                        this.urls = urls;
                        this.method = method;
                        this.componentInteractionValue = componentInteractionValue;
                    }

                    public final /* synthetic */ NonEmptyMap getUrls() {
                        return this.urls;
                    }

                    public final /* synthetic */ ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    public /* synthetic */ Url(NonEmptyMap nonEmptyMap, ButtonComponent.UrlMethod urlMethod, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(nonEmptyMap, urlMethod, (i & 4) != 0 ? "navigate_to_url" : str);
                    }

                    public final /* synthetic */ String getComponentInteractionValue() {
                        return this.componentInteractionValue;
                    }
                }

                @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", DiagnosticsEntry.ID_KEY, "", "name", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "backgroundBlur", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;)V", "getBackgroundBlur", "()Z", "getId", "()Ljava/lang/String;", "getName", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Sheet implements Destination {
                    public static final int $stable = 0;
                    private final boolean backgroundBlur;
                    private final String id;
                    private final String name;
                    private final Size size;
                    private final ComponentStyle stack;

                    public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, ComponentStyle componentStyle, boolean z, Size size, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = sheet.id;
                        }
                        if ((i & 2) != 0) {
                            str2 = sheet.name;
                        }
                        if ((i & 4) != 0) {
                            componentStyle = sheet.stack;
                        }
                        if ((i & 8) != 0) {
                            z = sheet.backgroundBlur;
                        }
                        if ((i & 16) != 0) {
                            size = sheet.size;
                        }
                        Size size2 = size;
                        ComponentStyle componentStyle2 = componentStyle;
                        return sheet.copy(str, str2, componentStyle2, z, size2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getId() {
                        return this.id;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getName() {
                        return this.name;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final ComponentStyle getStack() {
                        return this.stack;
                    }

                    /* JADX INFO: renamed from: component4, reason: from getter */
                    public final boolean getBackgroundBlur() {
                        return this.backgroundBlur;
                    }

                    /* JADX INFO: renamed from: component5, reason: from getter */
                    public final Size getSize() {
                        return this.size;
                    }

                    public final Sheet copy(String id, String name, ComponentStyle stack, boolean backgroundBlur, Size size) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(stack, "stack");
                        return new Sheet(id, name, stack, backgroundBlur, size);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Sheet)) {
                            return false;
                        }
                        Sheet sheet = (Sheet) other;
                        return Intrinsics.areEqual(this.id, sheet.id) && Intrinsics.areEqual(this.name, sheet.name) && Intrinsics.areEqual(this.stack, sheet.stack) && this.backgroundBlur == sheet.backgroundBlur && Intrinsics.areEqual(this.size, sheet.size);
                    }

                    public int hashCode() {
                        int iHashCode = this.id.hashCode() * 31;
                        String str = this.name;
                        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.backgroundBlur)) * 31;
                        Size size = this.size;
                        return iHashCode2 + (size != null ? size.hashCode() : 0);
                    }

                    public String toString() {
                        return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
                    }

                    public Sheet(String id, String str, ComponentStyle stack, boolean z, Size size) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(stack, "stack");
                        this.id = id;
                        this.name = str;
                        this.stack = stack;
                        this.backgroundBlur = z;
                        this.size = size;
                    }

                    public final /* synthetic */ String getId() {
                        return this.id;
                    }

                    public final /* synthetic */ String getName() {
                        return this.name;
                    }

                    public final /* synthetic */ ComponentStyle getStack() {
                        return this.stack;
                    }

                    public final /* synthetic */ boolean getBackgroundBlur() {
                        return this.backgroundBlur;
                    }

                    public final /* synthetic */ Size getSize() {
                        return this.size;
                    }
                }
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }
}
