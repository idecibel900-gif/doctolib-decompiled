package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableKeyValidator;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.ExperimentalPreviewRevenueCatUIPurchasesAPI;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0091\u0001\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000f\u00101\u001a\u0004\u0018\u000102H\u0000¢\u0006\u0002\b3R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001e¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLaunchIfNeededOptions;", "", "offering", "Lcom/revenuecat/purchases/Offering;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", "shouldDisplayDismissButton", "", "edgeToEdge", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "requiredEntitlementIdentifier", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "paywallDisplayCallback", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallDisplayCallback;", "offeringIdentifier", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;ZZLjava/util/Map;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallDisplayCallback;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)V", "getCustomVariables$revenuecatui_defaultsBc8Release", "()Ljava/util/Map;", "getEdgeToEdge$revenuecatui_defaultsBc8Release", "()Z", "getFontProvider$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getOffering$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/Offering;", "getOfferingIdentifier$revenuecatui_defaultsBc8Release", "()Ljava/lang/String;", "getPaywallDisplayCallback$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallDisplayCallback;", "getPresentedOfferingContext$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPurchaseLogic$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getRequiredEntitlementIdentifier$revenuecatui_defaultsBc8Release", "getShouldDisplayBlock$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function1;", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "toOfferingSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "toOfferingSelection$revenuecatui_defaultsBc8Release", "Builder", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallActivityLaunchIfNeededOptions {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final boolean edgeToEdge;
    private final ParcelizableFontProvider fontProvider;
    private final PaywallListener listener;
    private final Offering offering;
    private final String offeringIdentifier;
    private final PaywallDisplayCallback paywallDisplayCallback;
    private final PresentedOfferingContext presentedOfferingContext;
    private final PaywallPurchaseLogic purchaseLogic;
    private final String requiredEntitlementIdentifier;
    private final Function1 shouldDisplayBlock;
    private final boolean shouldDisplayDismissButton;

    public /* synthetic */ PaywallActivityLaunchIfNeededOptions(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, Map map, String str, Function1 function1, PaywallDisplayCallback paywallDisplayCallback, String str2, PresentedOfferingContext presentedOfferingContext, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(offering, parcelizableFontProvider, z, z2, map, str, function1, paywallDisplayCallback, str2, presentedOfferingContext, paywallPurchaseLogic, paywallListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallActivityLaunchIfNeededOptions(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, Map<String, ? extends CustomVariableValue> map, String str, Function1 function1, PaywallDisplayCallback paywallDisplayCallback, String str2, PresentedOfferingContext presentedOfferingContext, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener) {
        this.offering = offering;
        this.fontProvider = parcelizableFontProvider;
        this.shouldDisplayDismissButton = z;
        this.edgeToEdge = z2;
        this.customVariables = map;
        this.requiredEntitlementIdentifier = str;
        this.shouldDisplayBlock = function1;
        this.paywallDisplayCallback = paywallDisplayCallback;
        this.offeringIdentifier = str2;
        this.presentedOfferingContext = presentedOfferingContext;
        this.purchaseLogic = paywallPurchaseLogic;
        this.listener = paywallListener;
    }

    /* JADX INFO: renamed from: getOffering$revenuecatui_defaultsBc8Release, reason: from getter */
    public final Offering getOffering() {
        return this.offering;
    }

    /* JADX INFO: renamed from: getFontProvider$revenuecatui_defaultsBc8Release, reason: from getter */
    public final ParcelizableFontProvider getFontProvider() {
        return this.fontProvider;
    }

    /* JADX INFO: renamed from: getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release, reason: from getter */
    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    /* JADX INFO: renamed from: getEdgeToEdge$revenuecatui_defaultsBc8Release, reason: from getter */
    public final boolean getEdgeToEdge() {
        return this.edgeToEdge;
    }

    public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
        return this.customVariables;
    }

    /* JADX INFO: renamed from: getRequiredEntitlementIdentifier$revenuecatui_defaultsBc8Release, reason: from getter */
    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    /* JADX INFO: renamed from: getShouldDisplayBlock$revenuecatui_defaultsBc8Release, reason: from getter */
    public final Function1 getShouldDisplayBlock() {
        return this.shouldDisplayBlock;
    }

    /* JADX INFO: renamed from: getPaywallDisplayCallback$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PaywallDisplayCallback getPaywallDisplayCallback() {
        return this.paywallDisplayCallback;
    }

    /* JADX INFO: renamed from: getOfferingIdentifier$revenuecatui_defaultsBc8Release, reason: from getter */
    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    /* JADX INFO: renamed from: getPresentedOfferingContext$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX INFO: renamed from: getPurchaseLogic$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    /* JADX INFO: renamed from: getListener$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PaywallListener getListener() {
        return this.listener;
    }

    public final OfferingSelection.IdAndPresentedOfferingContext toOfferingSelection$revenuecatui_defaultsBc8Release() {
        if (this.offeringIdentifier != null) {
            return new OfferingSelection.IdAndPresentedOfferingContext(this.offeringIdentifier, this.presentedOfferingContext);
        }
        if (this.offering == null) {
            return null;
        }
        String identifier = this.offering.getIdentifier();
        Package r3 = (Package) CollectionsKt.firstOrNull((List) this.offering.getAvailablePackages());
        return new OfferingSelection.IdAndPresentedOfferingContext(identifier, r3 != null ? r3.getPresentedOfferingContext() : null);
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010 \u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010!\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010$\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005J\u001a\u0010&\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0018J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLaunchIfNeededOptions$Builder;", "", "()V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "edgeToEdge", "", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "offering", "Lcom/revenuecat/purchases/Offering;", "offeringIdentifier", "paywallDisplayCallback", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallDisplayCallback;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "requiredEntitlementIdentifier", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "shouldDisplayDismissButton", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLaunchIfNeededOptions;", "setCustomVariables", "setEdgeToEdge", "setFontProvider", "setListener", "setOffering", "setOfferingIdentifier", "setPaywallDisplayCallback", "setPurchaseLogic", "setRequiredEntitlementIdentifier", "setShouldDisplayBlock", "setShouldDisplayDismissButton", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private ParcelizableFontProvider fontProvider;
        private PaywallListener listener;
        private Offering offering;
        private String offeringIdentifier;
        private PaywallDisplayCallback paywallDisplayCallback;
        private PresentedOfferingContext presentedOfferingContext;
        private PaywallPurchaseLogic purchaseLogic;
        private String requiredEntitlementIdentifier;
        private Function1 shouldDisplayBlock;
        private boolean shouldDisplayDismissButton = true;
        private boolean edgeToEdge = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        private Map<String, ? extends CustomVariableValue> customVariables = MapsKt.emptyMap();

        public final Builder setOffering(Offering offering) {
            this.offering = offering;
            this.offeringIdentifier = null;
            this.presentedOfferingContext = null;
            return this;
        }

        @InternalRevenueCatAPI
        public final Builder setOfferingIdentifier(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.offeringIdentifier = offeringIdentifier;
            this.presentedOfferingContext = presentedOfferingContext;
            this.offering = null;
            return this;
        }

        public final Builder setFontProvider(ParcelizableFontProvider fontProvider) {
            this.fontProvider = fontProvider;
            return this;
        }

        public final Builder setShouldDisplayDismissButton(boolean shouldDisplayDismissButton) {
            this.shouldDisplayDismissButton = shouldDisplayDismissButton;
            return this;
        }

        public final Builder setEdgeToEdge(boolean edgeToEdge) {
            this.edgeToEdge = edgeToEdge;
            return this;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> customVariables) {
            Intrinsics.checkNotNullParameter(customVariables, "customVariables");
            this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(customVariables);
            return this;
        }

        public final Builder setRequiredEntitlementIdentifier(String requiredEntitlementIdentifier) {
            Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
            this.requiredEntitlementIdentifier = requiredEntitlementIdentifier;
            this.shouldDisplayBlock = null;
            return this;
        }

        public final Builder setShouldDisplayBlock(Function1 shouldDisplayBlock) {
            Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
            this.shouldDisplayBlock = shouldDisplayBlock;
            this.requiredEntitlementIdentifier = null;
            return this;
        }

        public final Builder setPaywallDisplayCallback(PaywallDisplayCallback paywallDisplayCallback) {
            this.paywallDisplayCallback = paywallDisplayCallback;
            return this;
        }

        @ExperimentalPreviewRevenueCatUIPurchasesAPI
        public final Builder setPurchaseLogic(PaywallPurchaseLogic purchaseLogic) {
            this.purchaseLogic = purchaseLogic;
            return this;
        }

        @ExperimentalPreviewRevenueCatUIPurchasesAPI
        public final Builder setListener(PaywallListener listener) {
            this.listener = listener;
            return this;
        }

        public final PaywallActivityLaunchIfNeededOptions build() {
            if (this.requiredEntitlementIdentifier == null && this.shouldDisplayBlock == null) {
                throw new IllegalArgumentException("PaywallActivityLaunchIfNeededOptions requires either requiredEntitlementIdentifier or shouldDisplayBlock to be set. Use PaywallActivityLaunchOptions for unconditional launches.");
            }
            return new PaywallActivityLaunchIfNeededOptions(this.offering, this.fontProvider, this.shouldDisplayDismissButton, this.edgeToEdge, this.customVariables, this.requiredEntitlementIdentifier, this.shouldDisplayBlock, this.paywallDisplayCallback, this.offeringIdentifier, this.presentedOfferingContext, this.purchaseLogic, this.listener, null);
        }
    }
}
