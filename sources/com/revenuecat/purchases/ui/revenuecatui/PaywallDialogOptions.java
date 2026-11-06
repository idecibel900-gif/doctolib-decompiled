package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bs\b\u0000\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\u0010\u0019R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;", "", "builder", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions$Builder;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions$Builder;)V", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "dismissRequest", "Lkotlin/Function0;", "", "offering", "Lcom/revenuecat/purchases/Offering;", "shouldDisplayDismissButton", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/Offering;ZLcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "getDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getFontProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getOfferingSelection$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getShouldDisplayBlock", "()Lkotlin/jvm/functions/Function1;", "getShouldDisplayDismissButton", "()Z", "Builder", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallDialogOptions {
    public static final int $stable = 0;
    private final Map<String, CustomVariableValue> customVariables;
    private final Function0 dismissRequest;
    private final FontProvider fontProvider;
    private final PaywallListener listener;
    private final Offering offering;
    private final PaywallPurchaseLogic purchaseLogic;
    private final Function1 shouldDisplayBlock;
    private final boolean shouldDisplayDismissButton;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallDialogOptions)) {
            return false;
        }
        PaywallDialogOptions paywallDialogOptions = (PaywallDialogOptions) obj;
        return Intrinsics.areEqual(this.shouldDisplayBlock, paywallDialogOptions.shouldDisplayBlock) && Intrinsics.areEqual(this.dismissRequest, paywallDialogOptions.dismissRequest) && Intrinsics.areEqual(this.offering, paywallDialogOptions.offering) && this.shouldDisplayDismissButton == paywallDialogOptions.shouldDisplayDismissButton && Intrinsics.areEqual(this.fontProvider, paywallDialogOptions.fontProvider) && Intrinsics.areEqual(this.listener, paywallDialogOptions.listener) && Intrinsics.areEqual(this.purchaseLogic, paywallDialogOptions.purchaseLogic) && Intrinsics.areEqual(this.customVariables, paywallDialogOptions.customVariables);
    }

    public int hashCode() {
        Function1 function1 = this.shouldDisplayBlock;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function0 function0 = this.dismissRequest;
        int iHashCode2 = (iHashCode + (function0 == null ? 0 : function0.hashCode())) * 31;
        Offering offering = this.offering;
        int iHashCode3 = (((iHashCode2 + (offering == null ? 0 : offering.hashCode())) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31;
        FontProvider fontProvider = this.fontProvider;
        int iHashCode4 = (iHashCode3 + (fontProvider == null ? 0 : fontProvider.hashCode())) * 31;
        PaywallListener paywallListener = this.listener;
        int iHashCode5 = (iHashCode4 + (paywallListener == null ? 0 : paywallListener.hashCode())) * 31;
        PaywallPurchaseLogic paywallPurchaseLogic = this.purchaseLogic;
        return ((iHashCode5 + (paywallPurchaseLogic != null ? paywallPurchaseLogic.hashCode() : 0)) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "PaywallDialogOptions(shouldDisplayBlock=" + this.shouldDisplayBlock + ", dismissRequest=" + this.dismissRequest + ", offering=" + this.offering + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontProvider=" + this.fontProvider + ", listener=" + this.listener + ", purchaseLogic=" + this.purchaseLogic + ", customVariables=" + this.customVariables + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallDialogOptions(Function1 function1, Function0 function0, Offering offering, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.shouldDisplayBlock = function1;
        this.dismissRequest = function0;
        this.offering = offering;
        this.shouldDisplayDismissButton = z;
        this.fontProvider = fontProvider;
        this.listener = paywallListener;
        this.purchaseLogic = paywallPurchaseLogic;
        this.customVariables = customVariables;
    }

    public final Function1 getShouldDisplayBlock() {
        return this.shouldDisplayBlock;
    }

    public final Function0 getDismissRequest() {
        return this.dismissRequest;
    }

    public final Offering getOffering() {
        return this.offering;
    }

    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public final FontProvider getFontProvider() {
        return this.fontProvider;
    }

    public final PaywallListener getListener() {
        return this.listener;
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public /* synthetic */ PaywallDialogOptions(Function1 function1, Function0 function0, Offering offering, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function0, offering, z, fontProvider, paywallListener, paywallPurchaseLogic, (i & 128) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final OfferingSelection getOfferingSelection$revenuecatui_defaultsBc8Release() {
        Offering offering = this.offering;
        return offering != null ? new OfferingSelection.OfferingType(offering) : OfferingSelection.None.INSTANCE;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallDialogOptions(Builder builder) {
        this(builder.getShouldDisplayBlock(), builder.getDismissRequest(), builder.getOffering(), builder.getShouldDisplayDismissButton(), builder.getFontProvider(), builder.getListener(), builder.getPurchaseLogic(), builder.getCustomVariables$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u001a\u0010:\u001a\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0014\u0010<\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010=\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010>\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010?\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010@\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u0005J\u001c\u0010B\u001a\u00020\u00002\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010+J\u000e\u0010C\u001a\u00020\u00002\u0006\u00102\u001a\u00020-R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions$Builder;", "", "()V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "getCustomVariables$revenuecatui_defaultsBc8Release", "()Ljava/util/Map;", "setCustomVariables$revenuecatui_defaultsBc8Release", "(Ljava/util/Map;)V", "dismissRequest", "Lkotlin/Function0;", "", "getDismissRequest$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function0;", "setDismissRequest$revenuecatui_defaultsBc8Release", "(Lkotlin/jvm/functions/Function0;)V", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getFontProvider$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "setFontProvider$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;)V", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "setListener$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)V", "offering", "Lcom/revenuecat/purchases/Offering;", "getOffering$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/Offering;", "setOffering$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/Offering;)V", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "setPurchaseLogic$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;)V", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "getShouldDisplayBlock$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function1;", "setShouldDisplayBlock$revenuecatui_defaultsBc8Release", "(Lkotlin/jvm/functions/Function1;)V", "shouldDisplayDismissButton", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "()Z", "setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "(Z)V", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;", "setCustomPurchaseLogic", "setCustomVariables", "variables", "setDismissRequest", "setFontProvider", "setListener", "setOffering", "setRequiredEntitlementIdentifier", "requiredEntitlementIdentifier", "setShouldDisplayBlock", "setShouldDisplayDismissButton", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Function0 dismissRequest;
        private FontProvider fontProvider;
        private PaywallListener listener;
        private Offering offering;
        private PaywallPurchaseLogic purchaseLogic;
        private Function1 shouldDisplayBlock;
        private boolean shouldDisplayDismissButton = true;
        private Map<String, ? extends CustomVariableValue> customVariables = MapsKt.emptyMap();

        /* JADX INFO: renamed from: getShouldDisplayBlock$revenuecatui_defaultsBc8Release, reason: from getter */
        public final Function1 getShouldDisplayBlock() {
            return this.shouldDisplayBlock;
        }

        public final void setShouldDisplayBlock$revenuecatui_defaultsBc8Release(Function1 function1) {
            this.shouldDisplayBlock = function1;
        }

        /* JADX INFO: renamed from: getDismissRequest$revenuecatui_defaultsBc8Release, reason: from getter */
        public final Function0 getDismissRequest() {
            return this.dismissRequest;
        }

        public final void setDismissRequest$revenuecatui_defaultsBc8Release(Function0 function0) {
            this.dismissRequest = function0;
        }

        /* JADX INFO: renamed from: getOffering$revenuecatui_defaultsBc8Release, reason: from getter */
        public final Offering getOffering() {
            return this.offering;
        }

        public final void setOffering$revenuecatui_defaultsBc8Release(Offering offering) {
            this.offering = offering;
        }

        /* JADX INFO: renamed from: getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release, reason: from getter */
        public final boolean getShouldDisplayDismissButton() {
            return this.shouldDisplayDismissButton;
        }

        public final void setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(boolean z) {
            this.shouldDisplayDismissButton = z;
        }

        /* JADX INFO: renamed from: getFontProvider$revenuecatui_defaultsBc8Release, reason: from getter */
        public final FontProvider getFontProvider() {
            return this.fontProvider;
        }

        public final void setFontProvider$revenuecatui_defaultsBc8Release(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
        }

        /* JADX INFO: renamed from: getListener$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallListener getListener() {
            return this.listener;
        }

        public final void setListener$revenuecatui_defaultsBc8Release(PaywallListener paywallListener) {
            this.listener = paywallListener;
        }

        /* JADX INFO: renamed from: getPurchaseLogic$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallPurchaseLogic getPurchaseLogic() {
            return this.purchaseLogic;
        }

        public final void setPurchaseLogic$revenuecatui_defaultsBc8Release(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
        }

        public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
            return this.customVariables;
        }

        public final void setCustomVariables$revenuecatui_defaultsBc8Release(Map<String, ? extends CustomVariableValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customVariables = map;
        }

        public final Builder setShouldDisplayBlock(Function1 shouldDisplayBlock) {
            this.shouldDisplayBlock = shouldDisplayBlock;
            return this;
        }

        public final Builder setRequiredEntitlementIdentifier(String requiredEntitlementIdentifier) {
            if (requiredEntitlementIdentifier != null) {
                this.shouldDisplayBlock = HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier);
            }
            return this;
        }

        public final Builder setDismissRequest(Function0 dismissRequest) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            this.dismissRequest = dismissRequest;
            return this;
        }

        public final Builder setOffering(Offering offering) {
            this.offering = offering;
            return this;
        }

        public final Builder setShouldDisplayDismissButton(boolean shouldDisplayDismissButton) {
            this.shouldDisplayDismissButton = shouldDisplayDismissButton;
            return this;
        }

        public final Builder setFontProvider(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
            return this;
        }

        public final Builder setListener(PaywallListener listener) {
            this.listener = listener;
            return this;
        }

        public final Builder setCustomPurchaseLogic(PaywallPurchaseLogic purchaseLogic) {
            this.purchaseLogic = purchaseLogic;
            return this;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.customVariables = variables;
            return this;
        }

        public final PaywallDialogOptions build() {
            return new PaywallDialogOptions(this);
        }
    }
}
