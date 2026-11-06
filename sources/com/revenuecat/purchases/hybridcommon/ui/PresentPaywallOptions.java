package com.revenuecat.purchases.hybridcommon.ui;

import com.facebook.imageutils.JfifUtil;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFontFamily;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jx\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PresentPaywallOptions;", "", "paywallResultListener", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallResultListener;", "paywallSource", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "requiredEntitlementIdentifier", "", "shouldDisplayDismissButton", "", "fontFamily", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "customVariables", "", "paywallListener", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper;", "purchaseLogic", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "(Lcom/revenuecat/purchases/hybridcommon/ui/PaywallResultListener;Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;Ljava/lang/String;Ljava/lang/Boolean;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;Ljava/util/Map;Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper;Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;)V", "getCustomVariables", "()Ljava/util/Map;", "getFontFamily", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "getPaywallListener", "()Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper;", "getPaywallResultListener", "()Lcom/revenuecat/purchases/hybridcommon/ui/PaywallResultListener;", "getPaywallSource", "()Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "getRequiredEntitlementIdentifier", "()Ljava/lang/String;", "getShouldDisplayDismissButton", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/revenuecat/purchases/hybridcommon/ui/PaywallResultListener;Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;Ljava/lang/String;Ljava/lang/Boolean;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;Ljava/util/Map;Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper;Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;)Lcom/revenuecat/purchases/hybridcommon/ui/PresentPaywallOptions;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PresentPaywallOptions {
    private final Map<String, Object> customVariables;
    private final PaywallFontFamily fontFamily;
    private final PaywallListenerWrapper paywallListener;
    private final PaywallResultListener paywallResultListener;
    private final PaywallSource paywallSource;
    private final HybridPurchaseLogicBridge purchaseLogic;
    private final String requiredEntitlementIdentifier;
    private final Boolean shouldDisplayDismissButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener) {
        this(paywallResultListener, null, null, null, null, null, null, null, 254, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource) {
        this(paywallResultListener, paywallSource, null, null, null, null, null, null, 252, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str) {
        this(paywallResultListener, paywallSource, str, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool) {
        this(paywallResultListener, paywallSource, str, bool, null, null, null, null, 240, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily) {
        this(paywallResultListener, paywallSource, str, bool, paywallFontFamily, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily, Map<String, ? extends Object> map) {
        this(paywallResultListener, paywallSource, str, bool, paywallFontFamily, map, null, null, JfifUtil.MARKER_SOFn, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily, Map<String, ? extends Object> map, PaywallListenerWrapper paywallListenerWrapper) {
        this(paywallResultListener, paywallSource, str, bool, paywallFontFamily, map, paywallListenerWrapper, null, 128, null);
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresentPaywallOptions copy$default(PresentPaywallOptions presentPaywallOptions, PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily, Map map, PaywallListenerWrapper paywallListenerWrapper, HybridPurchaseLogicBridge hybridPurchaseLogicBridge, int i, Object obj) {
        if ((i & 1) != 0) {
            paywallResultListener = presentPaywallOptions.paywallResultListener;
        }
        if ((i & 2) != 0) {
            paywallSource = presentPaywallOptions.paywallSource;
        }
        if ((i & 4) != 0) {
            str = presentPaywallOptions.requiredEntitlementIdentifier;
        }
        if ((i & 8) != 0) {
            bool = presentPaywallOptions.shouldDisplayDismissButton;
        }
        if ((i & 16) != 0) {
            paywallFontFamily = presentPaywallOptions.fontFamily;
        }
        if ((i & 32) != 0) {
            map = presentPaywallOptions.customVariables;
        }
        if ((i & 64) != 0) {
            paywallListenerWrapper = presentPaywallOptions.paywallListener;
        }
        if ((i & 128) != 0) {
            hybridPurchaseLogicBridge = presentPaywallOptions.purchaseLogic;
        }
        PaywallListenerWrapper paywallListenerWrapper2 = paywallListenerWrapper;
        HybridPurchaseLogicBridge hybridPurchaseLogicBridge2 = hybridPurchaseLogicBridge;
        PaywallFontFamily paywallFontFamily2 = paywallFontFamily;
        Map map2 = map;
        return presentPaywallOptions.copy(paywallResultListener, paywallSource, str, bool, paywallFontFamily2, map2, paywallListenerWrapper2, hybridPurchaseLogicBridge2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaywallResultListener getPaywallResultListener() {
        return this.paywallResultListener;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PaywallSource getPaywallSource() {
        return this.paywallSource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PaywallFontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final Map<String, Object> component6() {
        return this.customVariables;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PaywallListenerWrapper getPaywallListener() {
        return this.paywallListener;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final HybridPurchaseLogicBridge getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public final PresentPaywallOptions copy(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String requiredEntitlementIdentifier, Boolean shouldDisplayDismissButton, PaywallFontFamily fontFamily, Map<String, ? extends Object> customVariables, PaywallListenerWrapper paywallListener, HybridPurchaseLogicBridge purchaseLogic) {
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
        return new PresentPaywallOptions(paywallResultListener, paywallSource, requiredEntitlementIdentifier, shouldDisplayDismissButton, fontFamily, customVariables, paywallListener, purchaseLogic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PresentPaywallOptions)) {
            return false;
        }
        PresentPaywallOptions presentPaywallOptions = (PresentPaywallOptions) other;
        return Intrinsics.areEqual(this.paywallResultListener, presentPaywallOptions.paywallResultListener) && Intrinsics.areEqual(this.paywallSource, presentPaywallOptions.paywallSource) && Intrinsics.areEqual(this.requiredEntitlementIdentifier, presentPaywallOptions.requiredEntitlementIdentifier) && Intrinsics.areEqual(this.shouldDisplayDismissButton, presentPaywallOptions.shouldDisplayDismissButton) && Intrinsics.areEqual(this.fontFamily, presentPaywallOptions.fontFamily) && Intrinsics.areEqual(this.customVariables, presentPaywallOptions.customVariables) && Intrinsics.areEqual(this.paywallListener, presentPaywallOptions.paywallListener) && Intrinsics.areEqual(this.purchaseLogic, presentPaywallOptions.purchaseLogic);
    }

    public int hashCode() {
        int iHashCode = ((this.paywallResultListener.hashCode() * 31) + this.paywallSource.hashCode()) * 31;
        String str = this.requiredEntitlementIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.shouldDisplayDismissButton;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        PaywallFontFamily paywallFontFamily = this.fontFamily;
        int iHashCode4 = (iHashCode3 + (paywallFontFamily == null ? 0 : paywallFontFamily.hashCode())) * 31;
        Map<String, Object> map = this.customVariables;
        int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
        PaywallListenerWrapper paywallListenerWrapper = this.paywallListener;
        int iHashCode6 = (iHashCode5 + (paywallListenerWrapper == null ? 0 : paywallListenerWrapper.hashCode())) * 31;
        HybridPurchaseLogicBridge hybridPurchaseLogicBridge = this.purchaseLogic;
        return iHashCode6 + (hybridPurchaseLogicBridge != null ? hybridPurchaseLogicBridge.hashCode() : 0);
    }

    public String toString() {
        return "PresentPaywallOptions(paywallResultListener=" + this.paywallResultListener + ", paywallSource=" + this.paywallSource + ", requiredEntitlementIdentifier=" + this.requiredEntitlementIdentifier + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontFamily=" + this.fontFamily + ", customVariables=" + this.customVariables + ", paywallListener=" + this.paywallListener + ", purchaseLogic=" + this.purchaseLogic + ')';
    }

    public PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily, Map<String, ? extends Object> map, PaywallListenerWrapper paywallListenerWrapper, HybridPurchaseLogicBridge hybridPurchaseLogicBridge) {
        Intrinsics.checkNotNullParameter(paywallResultListener, "paywallResultListener");
        Intrinsics.checkNotNullParameter(paywallSource, "paywallSource");
        this.paywallResultListener = paywallResultListener;
        this.paywallSource = paywallSource;
        this.requiredEntitlementIdentifier = str;
        this.shouldDisplayDismissButton = bool;
        this.fontFamily = paywallFontFamily;
        this.customVariables = map;
        this.paywallListener = paywallListenerWrapper;
        this.purchaseLogic = hybridPurchaseLogicBridge;
    }

    public final PaywallResultListener getPaywallResultListener() {
        return this.paywallResultListener;
    }

    public /* synthetic */ PresentPaywallOptions(PaywallResultListener paywallResultListener, PaywallSource paywallSource, String str, Boolean bool, PaywallFontFamily paywallFontFamily, Map map, PaywallListenerWrapper paywallListenerWrapper, HybridPurchaseLogicBridge hybridPurchaseLogicBridge, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(paywallResultListener, (i & 2) != 0 ? PaywallSource.DefaultOffering.INSTANCE : paywallSource, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : paywallFontFamily, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : paywallListenerWrapper, (i & 128) != 0 ? null : hybridPurchaseLogicBridge);
    }

    public final PaywallSource getPaywallSource() {
        return this.paywallSource;
    }

    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    public final Boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public final PaywallFontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final Map<String, Object> getCustomVariables() {
        return this.customVariables;
    }

    public final PaywallListenerWrapper getPaywallListener() {
        return this.paywallListener;
    }

    public final HybridPurchaseLogicBridge getPurchaseLogic() {
        return this.purchaseLogic;
    }
}
