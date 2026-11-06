package com.revenuecat.purchases.hybridcommon.ui;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "", "()V", "DefaultOffering", "Offering", "OfferingIdentifier", "OfferingIdentifierWithPresentedOfferingContext", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$DefaultOffering;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$Offering;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$OfferingIdentifier;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$OfferingIdentifierWithPresentedOfferingContext;", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallSource {
    public /* synthetic */ PaywallSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$Offering;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "value", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$hybridcommon_ui_bc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getValue", "()Lcom/revenuecat/purchases/Offering;", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Offering extends PaywallSource {
        private final com.revenuecat.purchases.Offering value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Offering(com.revenuecat.purchases.Offering value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final com.revenuecat.purchases.Offering getValue() {
            return this.value;
        }

        public final PresentedOfferingContext getPresentedOfferingContext$hybridcommon_ui_bc8Release() {
            Package r0 = (Package) CollectionsKt.firstOrNull((List) this.value.getAvailablePackages());
            if (r0 != null) {
                return r0.getPresentedOfferingContext();
            }
            return null;
        }
    }

    private PaywallSource() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$DefaultOffering;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "()V", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultOffering extends PaywallSource {
        public static final DefaultOffering INSTANCE = new DefaultOffering();

        private DefaultOffering() {
            super(null);
        }
    }

    @Deprecated
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$OfferingIdentifier;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfferingIdentifier extends PaywallSource {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferingIdentifier(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource$OfferingIdentifierWithPresentedOfferingContext;", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallSource;", "offeringIdentifier", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getOfferingIdentifier", "()Ljava/lang/String;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfferingIdentifierWithPresentedOfferingContext extends PaywallSource {
        private final String offeringIdentifier;
        private final PresentedOfferingContext presentedOfferingContext;

        public final String getOfferingIdentifier() {
            return this.offeringIdentifier;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferingIdentifierWithPresentedOfferingContext(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.offeringIdentifier = offeringIdentifier;
            this.presentedOfferingContext = presentedOfferingContext;
        }
    }
}
