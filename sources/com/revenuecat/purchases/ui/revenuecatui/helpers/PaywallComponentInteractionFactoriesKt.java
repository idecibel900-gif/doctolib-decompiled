package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a0\u0010\u0004\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0001\u001a&\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0001\u001a\u001c\u0010\u000f\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0001\u001a8\u0010\u0011\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0001\u001aQ\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0002\u0010\u001f\u001a0\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\bH\u0001¨\u0006$"}, d2 = {"paywallCarouselPageChange", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "interaction", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/CarouselPageChangeInteraction;", "paywallPackageRowSelection", "componentName", "", "destination", "Lcom/revenuecat/purchases/Package;", "origin", "defaultPackage", "paywallPackageSelectionSheetClose", "sheetComponentName", "sheetSelectedPackage", "resultingRootPackage", "paywallPackageSelectionSheetOpen", "rootSelectedPackage", "paywallPurchaseButtonAction", "componentValue", "componentUrl", "currentPackageIdentifier", "currentProductIdentifier", "paywallTabControlButtonSelection", "tabsComponentName", "destinationTabId", "originIndex", "", "destinationIndex", "originContextName", "destinationContextName", "defaultIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "paywallTierSelection", "tierDisplayName", "originPackage", "destinationPackage", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentInteractionFactoriesKt {
    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallTabControlButtonSelection(String str, String destinationTabId, Integer num, Integer num2, String str2, String str3, Integer num3) {
        Intrinsics.checkNotNullParameter(destinationTabId, "destinationTabId");
        return new PaywallComponentInteractionData(PaywallComponentType.TAB, str, destinationTabId, (String) null, num, num2, str2, str3, num3, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 523784, (DefaultConstructorMarker) null);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallPurchaseButtonAction(String str, String componentValue, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        return new PaywallComponentInteractionData(PaywallComponentType.PURCHASE_BUTTON, str, componentValue, str2, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str3, (String) null, str4, (String) null, 360432, (DefaultConstructorMarker) null);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallCarouselPageChange(CarouselPageChangeInteraction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        return new PaywallComponentInteractionData(PaywallComponentType.CAROUSEL, interaction.getComponentName(), String.valueOf(interaction.getDestinationPageIndex()), (String) null, Integer.valueOf(interaction.getOriginPageIndex()), Integer.valueOf(interaction.getDestinationPageIndex()), interaction.getOriginContextName(), interaction.getDestinationContextName(), Integer.valueOf(interaction.getDefaultPageIndex()), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 523784, (DefaultConstructorMarker) null);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallPackageSelectionSheetOpen(String str, Package r23) {
        StoreProduct product;
        PaywallComponentType paywallComponentType = PaywallComponentType.PACKAGE_SELECTION_SHEET;
        String strPaywallProductIdentifier = null;
        String identifier = r23 != null ? r23.getIdentifier() : null;
        if (r23 != null && (product = r23.getProduct()) != null) {
            strPaywallProductIdentifier = PaywallProductIdentifierKt.paywallProductIdentifier(product);
        }
        return new PaywallComponentInteractionData(paywallComponentType, str, "open", (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, identifier, (String) null, strPaywallProductIdentifier, (String) null, 360440, (DefaultConstructorMarker) null);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallPackageSelectionSheetClose(String str, Package r23, Package r24) {
        StoreProduct product;
        StoreProduct product2;
        PaywallComponentType paywallComponentType = PaywallComponentType.PACKAGE_SELECTION_SHEET;
        String strPaywallProductIdentifier = null;
        String identifier = r23 != null ? r23.getIdentifier() : null;
        String identifier2 = r24 != null ? r24.getIdentifier() : null;
        String strPaywallProductIdentifier2 = (r23 == null || (product2 = r23.getProduct()) == null) ? null : PaywallProductIdentifierKt.paywallProductIdentifier(product2);
        if (r24 != null && (product = r24.getProduct()) != null) {
            strPaywallProductIdentifier = PaywallProductIdentifierKt.paywallProductIdentifier(product);
        }
        return new PaywallComponentInteractionData(paywallComponentType, str, "close", (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, identifier, identifier2, strPaywallProductIdentifier2, strPaywallProductIdentifier, 32760, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaywallComponentInteractionData paywallPackageRowSelection$default(String str, Package r1, Package r2, Package r3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return paywallPackageRowSelection(str, r1, r2, r3);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallPackageRowSelection(String str, Package destination, Package r25, Package r26) {
        StoreProduct product;
        StoreProduct product2;
        Intrinsics.checkNotNullParameter(destination, "destination");
        PaywallComponentType paywallComponentType = PaywallComponentType.PACKAGE;
        String identifier = destination.getIdentifier();
        String strPaywallProductIdentifier = null;
        String identifier2 = r25 != null ? r25.getIdentifier() : null;
        String identifier3 = destination.getIdentifier();
        String identifier4 = r26 != null ? r26.getIdentifier() : null;
        String strPaywallProductIdentifier2 = (r25 == null || (product2 = r25.getProduct()) == null) ? null : PaywallProductIdentifierKt.paywallProductIdentifier(product2);
        String strPaywallProductIdentifier3 = PaywallProductIdentifierKt.paywallProductIdentifier(destination.getProduct());
        if (r26 != null && (product = r26.getProduct()) != null) {
            strPaywallProductIdentifier = PaywallProductIdentifierKt.paywallProductIdentifier(product);
        }
        return new PaywallComponentInteractionData(paywallComponentType, str, identifier, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, identifier2, identifier3, identifier4, strPaywallProductIdentifier2, strPaywallProductIdentifier3, strPaywallProductIdentifier, (String) null, (String) null, (String) null, (String) null, 492024, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaywallComponentInteractionData paywallTierSelection$default(String str, String str2, Package r2, Package r3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return paywallTierSelection(str, str2, r2, r3);
    }

    @InternalRevenueCatAPI
    public static final PaywallComponentInteractionData paywallTierSelection(String tierDisplayName, String str, Package r25, Package r26) {
        StoreProduct product;
        StoreProduct product2;
        Intrinsics.checkNotNullParameter(tierDisplayName, "tierDisplayName");
        PaywallComponentType paywallComponentType = PaywallComponentType.TAB;
        String strPaywallProductIdentifier = null;
        String identifier = r25 != null ? r25.getIdentifier() : null;
        String identifier2 = r26 != null ? r26.getIdentifier() : null;
        String strPaywallProductIdentifier2 = (r25 == null || (product2 = r25.getProduct()) == null) ? null : PaywallProductIdentifierKt.paywallProductIdentifier(product2);
        if (r26 != null && (product = r26.getProduct()) != null) {
            strPaywallProductIdentifier = PaywallProductIdentifierKt.paywallProductIdentifier(product);
        }
        return new PaywallComponentInteractionData(paywallComponentType, str, tierDisplayName, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, identifier, identifier2, (String) null, strPaywallProductIdentifier2, strPaywallProductIdentifier, (String) null, (String) null, (String) null, (String) null, (String) null, 510456, (DefaultConstructorMarker) null);
    }
}
