package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "", "Companion", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "Lcom/revenuecat/purchases/paywalls/components/FallbackHeaderComponent;", "Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;", "Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/TabControlComponent;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return new PaywallComponentSerializer();
        }
    }
}
