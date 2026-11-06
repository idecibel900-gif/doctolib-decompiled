package com.revenuecat.purchases.ui.revenuecatui;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002CBB\u0085\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u0099\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00112\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0000¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b4\u00105R\u001a\u0010\r\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b7\u00108R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u00109\u001a\u0004\b:\u0010;R2\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010<\u001a\u0004\b=\u0010>R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158\u0006¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "offeringSelection", "", "shouldDisplayDismissButton", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "mode", "Lkotlin/Function0;", "", "dismissRequest", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "dismissRequestWithExitOffering", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "customVariables", "<init>", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;ZLcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/util/Map;)V", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;", "builder", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;)V", "", "hashCode", "()I", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "copy$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;ZLcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/util/Map;)Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "copy", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getOfferingSelection$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "Z", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "()Z", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getFontProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getMode$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "Lkotlin/jvm/functions/Function0;", "getDismissRequest", "()Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function2;", "getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function2;", "Ljava/util/Map;", "getCustomVariables", "()Ljava/util/Map;", "Companion", "Builder", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallOptions {
    public static final int $stable = 0;
    private static final int hashMultiplier = 31;
    private final Map<String, CustomVariableValue> customVariables;
    private final Function0 dismissRequest;
    private final Function2 dismissRequestWithExitOffering;
    private final FontProvider fontProvider;
    private final PaywallListener listener;
    private final PaywallMode mode;
    private final OfferingSelection offeringSelection;
    private final PaywallPurchaseLogic purchaseLogic;
    private final boolean shouldDisplayDismissButton;

    public String toString() {
        return "PaywallOptions(offeringSelection=" + this.offeringSelection + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontProvider=" + this.fontProvider + ", listener=" + this.listener + ", purchaseLogic=" + this.purchaseLogic + ", mode=" + this.mode + ", dismissRequest=" + this.dismissRequest + ", dismissRequestWithExitOffering=" + this.dismissRequestWithExitOffering + ", customVariables=" + this.customVariables + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallOptions(OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode mode, Function0 dismissRequest, Function2 function2, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.offeringSelection = offeringSelection;
        this.shouldDisplayDismissButton = z;
        this.fontProvider = fontProvider;
        this.listener = paywallListener;
        this.purchaseLogic = paywallPurchaseLogic;
        this.mode = mode;
        this.dismissRequest = dismissRequest;
        this.dismissRequestWithExitOffering = function2;
        this.customVariables = customVariables;
    }

    /* JADX INFO: renamed from: getOfferingSelection$revenuecatui_defaultsBc8Release, reason: from getter */
    public final OfferingSelection getOfferingSelection() {
        return this.offeringSelection;
    }

    /* JADX INFO: renamed from: getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release, reason: from getter */
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

    /* JADX INFO: renamed from: getMode$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PaywallMode getMode() {
        return this.mode;
    }

    public final Function0 getDismissRequest() {
        return this.dismissRequest;
    }

    /* JADX INFO: renamed from: getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release, reason: from getter */
    public final Function2 getDismissRequestWithExitOffering() {
        return this.dismissRequestWithExitOffering;
    }

    public /* synthetic */ PaywallOptions(OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringSelection, z, fontProvider, paywallListener, paywallPurchaseLogic, paywallMode, function0, (i & 128) != 0 ? null : function2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallOptions(Builder builder) {
        this(builder.getOfferingSelection(), builder.getShouldDisplayDismissButton(), builder.getFontProvider(), builder.getListener(), builder.getPurchaseLogic(), builder.getMode(), builder.getDismissRequest(), builder.getDismissRequestWithExitOffering(), builder.getCustomVariables$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    public int hashCode() {
        String offeringIdentifier = this.offeringSelection.getOfferingIdentifier();
        return ((((((offeringIdentifier != null ? offeringIdentifier.hashCode() : 0) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31) + this.mode.hashCode()) * 31) + this.customVariables.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallOptions)) {
            return false;
        }
        PaywallOptions paywallOptions = (PaywallOptions) other;
        if (Intrinsics.areEqual(this.offeringSelection, paywallOptions.offeringSelection) && this.shouldDisplayDismissButton == paywallOptions.shouldDisplayDismissButton && Intrinsics.areEqual(this.fontProvider, paywallOptions.fontProvider) && Intrinsics.areEqual(this.listener, paywallOptions.listener) && Intrinsics.areEqual(this.purchaseLogic, paywallOptions.purchaseLogic) && this.mode == paywallOptions.mode && Intrinsics.areEqual(this.customVariables, paywallOptions.customVariables)) {
            return Intrinsics.areEqual(this.dismissRequest, paywallOptions.dismissRequest);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallOptions copy$revenuecatui_defaultsBc8Release$default(PaywallOptions paywallOptions, OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            offeringSelection = paywallOptions.offeringSelection;
        }
        if ((i & 2) != 0) {
            z = paywallOptions.shouldDisplayDismissButton;
        }
        if ((i & 4) != 0) {
            fontProvider = paywallOptions.fontProvider;
        }
        if ((i & 8) != 0) {
            paywallListener = paywallOptions.listener;
        }
        if ((i & 16) != 0) {
            paywallPurchaseLogic = paywallOptions.purchaseLogic;
        }
        if ((i & 32) != 0) {
            paywallMode = paywallOptions.mode;
        }
        if ((i & 64) != 0) {
            function0 = paywallOptions.dismissRequest;
        }
        if ((i & 128) != 0) {
            function2 = paywallOptions.dismissRequestWithExitOffering;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            map = paywallOptions.customVariables;
        }
        Function2 function3 = function2;
        Map map2 = map;
        PaywallMode paywallMode2 = paywallMode;
        Function0 function1 = function0;
        PaywallPurchaseLogic paywallPurchaseLogic2 = paywallPurchaseLogic;
        FontProvider fontProvider2 = fontProvider;
        return paywallOptions.copy$revenuecatui_defaultsBc8Release(offeringSelection, z, fontProvider2, paywallListener, paywallPurchaseLogic2, paywallMode2, function1, function3, map2);
    }

    public final PaywallOptions copy$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection, boolean shouldDisplayDismissButton, FontProvider fontProvider, PaywallListener listener, PaywallPurchaseLogic purchaseLogic, PaywallMode mode, Function0 dismissRequest, Function2 dismissRequestWithExitOffering, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        return new PaywallOptions(offeringSelection, shouldDisplayDismissButton, fontProvider, listener, purchaseLogic, mode, dismissRequest, dismissRequestWithExitOffering, customVariables);
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010<\u001a\u00020=J\u001a\u0010>\u001a\u00020\u00002\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J-\u0010@\u001a\u00020\u00002\u001e\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010A\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010B\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0015\u0010C\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b(J\u0010\u0010D\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0012J\u0017\u0010F\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010HH\u0000¢\u0006\u0002\bIJ\u0017\u0010J\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0002\b.J\u0010\u0010K\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u000101J\u000e\u0010L\u001a\u00020\u00002\u0006\u00106\u001a\u000207R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR2\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006M"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;", "", "dismissRequest", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "getCustomVariables$revenuecatui_defaultsBc8Release", "()Ljava/util/Map;", "setCustomVariables$revenuecatui_defaultsBc8Release", "(Ljava/util/Map;)V", "getDismissRequest$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function0;", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function2;", "setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "(Lkotlin/jvm/functions/Function2;)V", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getFontProvider$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "setFontProvider$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;)V", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "setListener$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)V", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getMode$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "setMode$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;)V", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getOfferingSelection$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "setOfferingSelection$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;)V", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "setPurchaseLogic$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;)V", "shouldDisplayDismissButton", "", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "()Z", "setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "(Z)V", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "setCustomVariables", "variables", "setDismissRequestWithExitOffering", "setFontProvider", "setListener", "setMode", "setOffering", "offering", "setOfferingIdAndPresentedOfferingContext", "idAndPresentedOfferingContext", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release", "setOfferingSelection", "setPurchaseLogic", "setShouldDisplayDismissButton", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Map<String, ? extends CustomVariableValue> customVariables;
        private final Function0 dismissRequest;
        private Function2 dismissRequestWithExitOffering;
        private FontProvider fontProvider;
        private PaywallListener listener;
        private PaywallMode mode;
        private OfferingSelection offeringSelection;
        private PaywallPurchaseLogic purchaseLogic;
        private boolean shouldDisplayDismissButton;

        public Builder(Function0 dismissRequest) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            this.dismissRequest = dismissRequest;
            this.offeringSelection = OfferingSelection.None.INSTANCE;
            this.mode = PaywallMode.INSTANCE.getDefault();
            this.customVariables = MapsKt.emptyMap();
        }

        /* JADX INFO: renamed from: getDismissRequest$revenuecatui_defaultsBc8Release, reason: from getter */
        public final Function0 getDismissRequest() {
            return this.dismissRequest;
        }

        /* JADX INFO: renamed from: getOfferingSelection$revenuecatui_defaultsBc8Release, reason: from getter */
        public final OfferingSelection getOfferingSelection() {
            return this.offeringSelection;
        }

        /* JADX INFO: renamed from: setOfferingSelection$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m4038setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            Intrinsics.checkNotNullParameter(offeringSelection, "<set-?>");
            this.offeringSelection = offeringSelection;
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

        /* JADX INFO: renamed from: getMode$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallMode getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: setMode$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m4037setMode$revenuecatui_defaultsBc8Release(PaywallMode paywallMode) {
            Intrinsics.checkNotNullParameter(paywallMode, "<set-?>");
            this.mode = paywallMode;
        }

        /* JADX INFO: renamed from: getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release, reason: from getter */
        public final Function2 getDismissRequestWithExitOffering() {
            return this.dismissRequestWithExitOffering;
        }

        /* JADX INFO: renamed from: setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m4036x1d639bc0(Function2 function2) {
            this.dismissRequestWithExitOffering = function2;
        }

        public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
            return this.customVariables;
        }

        public final void setCustomVariables$revenuecatui_defaultsBc8Release(Map<String, ? extends CustomVariableValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customVariables = map;
        }

        public final Builder setOffering(Offering offering) {
            OfferingSelection offeringType;
            if (offering != null) {
                offeringType = new OfferingSelection.OfferingType(offering);
            } else {
                offeringType = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringType;
            return this;
        }

        public final Builder setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext) {
            OfferingSelection offeringSelection = idAndPresentedOfferingContext;
            if (idAndPresentedOfferingContext == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
            return this;
        }

        public final Builder setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            if (offeringSelection == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
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

        public final Builder setPurchaseLogic(PaywallPurchaseLogic purchaseLogic) {
            this.purchaseLogic = purchaseLogic;
            return this;
        }

        public final Builder setMode$revenuecatui_defaultsBc8Release(PaywallMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final Builder setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(Function2 dismissRequestWithExitOffering) {
            this.dismissRequestWithExitOffering = dismissRequestWithExitOffering;
            return this;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(variables);
            return this;
        }

        public final PaywallOptions build() {
            return new PaywallOptions(this);
        }
    }
}
