package com.revenuecat.purchases.ui.revenuecatui.components;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "", "External", "Internal", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallAction {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "NavigateTo", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Internal extends PaywallAction {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", "destination", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "Destination", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateTo implements Internal {
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

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "", "Sheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination$Sheet;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public interface Destination {

                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination$Sheet;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "sheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;)V", "getSheet", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Sheet implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet;

                    public static /* synthetic */ Sheet copy$default(Sheet sheet, ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            sheet2 = sheet.sheet;
                        }
                        return sheet.copy(sheet2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet getSheet() {
                        return this.sheet;
                    }

                    public final Sheet copy(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        return new Sheet(sheet);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Sheet) && Intrinsics.areEqual(this.sheet, ((Sheet) other).sheet);
                    }

                    public int hashCode() {
                        return this.sheet.hashCode();
                    }

                    public String toString() {
                        return "Sheet(sheet=" + this.sheet + ')';
                    }

                    public Sheet(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        this.sheet = sheet;
                    }

                    public final /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet getSheet() {
                        return this.sheet;
                    }
                }
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "LaunchWebCheckout", "NavigateBack", "NavigateTo", "PurchasePackage", "RestorePurchases", "WorkflowTrigger", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$WorkflowTrigger;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface External extends PaywallAction {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RestorePurchases implements External {
            public static final int $stable = 0;
            public static final RestorePurchases INSTANCE = new RestorePurchases();

            private RestorePurchases() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateBack implements External {
            public static final int $stable = 0;
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$WorkflowTrigger;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "componentId", "", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;)V", "getComponentId", "()Ljava/lang/String;", "getTriggerType", "()Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class WorkflowTrigger implements External {
            public static final int $stable = 0;
            private final String componentId;
            private final WorkflowTriggerType triggerType;

            public static /* synthetic */ WorkflowTrigger copy$default(WorkflowTrigger workflowTrigger, String str, WorkflowTriggerType workflowTriggerType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = workflowTrigger.componentId;
                }
                if ((i & 2) != 0) {
                    workflowTriggerType = workflowTrigger.triggerType;
                }
                return workflowTrigger.copy(str, workflowTriggerType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getComponentId() {
                return this.componentId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WorkflowTriggerType getTriggerType() {
                return this.triggerType;
            }

            public final WorkflowTrigger copy(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                return new WorkflowTrigger(componentId, triggerType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WorkflowTrigger)) {
                    return false;
                }
                WorkflowTrigger workflowTrigger = (WorkflowTrigger) other;
                return Intrinsics.areEqual(this.componentId, workflowTrigger.componentId) && this.triggerType == workflowTrigger.triggerType;
            }

            public int hashCode() {
                return (this.componentId.hashCode() * 31) + this.triggerType.hashCode();
            }

            public String toString() {
                return "WorkflowTrigger(componentId=" + this.componentId + ", triggerType=" + this.triggerType + ')';
            }

            public WorkflowTrigger(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                this.componentId = componentId;
                this.triggerType = triggerType;
            }

            public final String getComponentId() {
                return this.componentId;
            }

            public final WorkflowTriggerType getTriggerType() {
                return this.triggerType;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;)V", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class PurchasePackage implements External {
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
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001eB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "customUrl", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "autoDismiss", "", "packageParamBehavior", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;ZLcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;)V", "getAutoDismiss", "()Z", "getCustomUrl", "()Ljava/lang/String;", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getPackageParamBehavior", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;", "component1", "component2", "component3", "component4", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "PackageParamBehavior", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class LaunchWebCheckout implements External {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final String customUrl;
            private final ButtonComponent.UrlMethod openMethod;
            private final PackageParamBehavior packageParamBehavior;

            public static /* synthetic */ LaunchWebCheckout copy$default(LaunchWebCheckout launchWebCheckout, String str, ButtonComponent.UrlMethod urlMethod, boolean z, PackageParamBehavior packageParamBehavior, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchWebCheckout.customUrl;
                }
                if ((i & 2) != 0) {
                    urlMethod = launchWebCheckout.openMethod;
                }
                if ((i & 4) != 0) {
                    z = launchWebCheckout.autoDismiss;
                }
                if ((i & 8) != 0) {
                    packageParamBehavior = launchWebCheckout.packageParamBehavior;
                }
                return launchWebCheckout.copy(str, urlMethod, z, packageParamBehavior);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCustomUrl() {
                return this.customUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final PackageParamBehavior getPackageParamBehavior() {
                return this.packageParamBehavior;
            }

            public final LaunchWebCheckout copy(String customUrl, ButtonComponent.UrlMethod openMethod, boolean autoDismiss, PackageParamBehavior packageParamBehavior) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(packageParamBehavior, "packageParamBehavior");
                return new LaunchWebCheckout(customUrl, openMethod, autoDismiss, packageParamBehavior);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchWebCheckout)) {
                    return false;
                }
                LaunchWebCheckout launchWebCheckout = (LaunchWebCheckout) other;
                return Intrinsics.areEqual(this.customUrl, launchWebCheckout.customUrl) && this.openMethod == launchWebCheckout.openMethod && this.autoDismiss == launchWebCheckout.autoDismiss && Intrinsics.areEqual(this.packageParamBehavior, launchWebCheckout.packageParamBehavior);
            }

            public int hashCode() {
                String str = this.customUrl;
                return ((((((str == null ? 0 : str.hashCode()) * 31) + this.openMethod.hashCode()) * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.packageParamBehavior.hashCode();
            }

            public String toString() {
                return "LaunchWebCheckout(customUrl=" + this.customUrl + ", openMethod=" + this.openMethod + ", autoDismiss=" + this.autoDismiss + ", packageParamBehavior=" + this.packageParamBehavior + ')';
            }

            public LaunchWebCheckout(String str, ButtonComponent.UrlMethod openMethod, boolean z, PackageParamBehavior packageParamBehavior) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(packageParamBehavior, "packageParamBehavior");
                this.customUrl = str;
                this.openMethod = openMethod;
                this.autoDismiss = z;
                this.packageParamBehavior = packageParamBehavior;
            }

            public final String getCustomUrl() {
                return this.customUrl;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final PackageParamBehavior getPackageParamBehavior() {
                return this.packageParamBehavior;
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;", "", "Append", "DoNotAppend", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior$Append;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior$DoNotAppend;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public interface PackageParamBehavior {

                @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior$Append;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "packageParam", "", "(Lcom/revenuecat/purchases/Package;Ljava/lang/String;)V", "getPackageParam", "()Ljava/lang/String;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Append implements PackageParamBehavior {
                    public static final int $stable = 8;
                    private final String packageParam;
                    private final Package rcPackage;

                    public static /* synthetic */ Append copy$default(Append append, Package r1, String str, int i, Object obj) {
                        if ((i & 1) != 0) {
                            r1 = append.rcPackage;
                        }
                        if ((i & 2) != 0) {
                            str = append.packageParam;
                        }
                        return append.copy(r1, str);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final Package getRcPackage() {
                        return this.rcPackage;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getPackageParam() {
                        return this.packageParam;
                    }

                    public final Append copy(Package rcPackage, String packageParam) {
                        return new Append(rcPackage, packageParam);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Append)) {
                            return false;
                        }
                        Append append = (Append) other;
                        return Intrinsics.areEqual(this.rcPackage, append.rcPackage) && Intrinsics.areEqual(this.packageParam, append.packageParam);
                    }

                    public int hashCode() {
                        Package r0 = this.rcPackage;
                        int iHashCode = (r0 == null ? 0 : r0.hashCode()) * 31;
                        String str = this.packageParam;
                        return iHashCode + (str != null ? str.hashCode() : 0);
                    }

                    public String toString() {
                        return "Append(rcPackage=" + this.rcPackage + ", packageParam=" + this.packageParam + ')';
                    }

                    public Append(Package r1, String str) {
                        this.rcPackage = r1;
                        this.packageParam = str;
                    }

                    public final String getPackageParam() {
                        return this.packageParam;
                    }

                    public final Package getRcPackage() {
                        return this.rcPackage;
                    }
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior$DoNotAppend;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$PackageParamBehavior;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class DoNotAppend implements PackageParamBehavior {
                    public static final int $stable = 0;
                    public static final DoNotAppend INSTANCE = new DoNotAppend();

                    private DoNotAppend() {
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "destination", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "Destination", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateTo implements External {
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

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "", "CustomerCenter", "Url", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$Url;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public interface Destination {

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class CustomerCenter implements Destination {
                    public static final int $stable = 0;
                    public static final CustomerCenter INSTANCE = new CustomerCenter();

                    private CustomerCenter() {
                    }
                }

                @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$Url;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "url", "", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Url implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponent.UrlMethod method;
                    private final String url;

                    public static /* synthetic */ Url copy$default(Url url, String str, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = url.url;
                        }
                        if ((i & 2) != 0) {
                            urlMethod = url.method;
                        }
                        return url.copy(str, urlMethod);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getUrl() {
                        return this.url;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    public final Url copy(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        return new Url(url, method);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Url)) {
                            return false;
                        }
                        Url url = (Url) other;
                        return Intrinsics.areEqual(this.url, url.url) && this.method == url.method;
                    }

                    public int hashCode() {
                        return (this.url.hashCode() * 31) + this.method.hashCode();
                    }

                    public String toString() {
                        return "Url(url=" + this.url + ", method=" + this.method + ')';
                    }

                    public Url(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        this.url = url;
                        this.method = method;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public final /* synthetic */ ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }
                }
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }
}
