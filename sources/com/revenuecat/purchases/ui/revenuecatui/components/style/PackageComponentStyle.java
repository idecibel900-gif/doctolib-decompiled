package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\u0015\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0014HÆ\u0003Ju\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020(HÖ\u0001J\t\u0010=\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u0004\u0018\u00010(8VX\u0096\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0018¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "isSelectedByDefault", "", "componentName", "", "stackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "isSelectable", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "visible", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "(Lcom/revenuecat/purchases/Package;ZLjava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;ZLjava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;)V", "getComponentName", "()Ljava/lang/String;", "()Z", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "()Ljava/util/List;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStackComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "tabIndex", "", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "uniqueId", "getUniqueId", "getVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PackageComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final String componentName;
    private final boolean isSelectable;
    private final boolean isSelectedByDefault;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedPackagePartial>> overrides;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final Integer tabIndex;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackageComponentStyle copy$default(PackageComponentStyle packageComponentStyle, Package r1, boolean z, String str, StackComponentStyle stackComponentStyle, boolean z2, ResolvedOffer resolvedOffer, boolean z3, List list, OfferEligibility offerEligibility, int i, Object obj) {
        if ((i & 1) != 0) {
            r1 = packageComponentStyle.rcPackage;
        }
        if ((i & 2) != 0) {
            z = packageComponentStyle.isSelectedByDefault;
        }
        if ((i & 4) != 0) {
            str = packageComponentStyle.componentName;
        }
        if ((i & 8) != 0) {
            stackComponentStyle = packageComponentStyle.stackComponentStyle;
        }
        if ((i & 16) != 0) {
            z2 = packageComponentStyle.isSelectable;
        }
        if ((i & 32) != 0) {
            resolvedOffer = packageComponentStyle.resolvedOffer;
        }
        if ((i & 64) != 0) {
            z3 = packageComponentStyle.visible;
        }
        if ((i & 128) != 0) {
            list = packageComponentStyle.overrides;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            offerEligibility = packageComponentStyle.offerEligibility;
        }
        List list2 = list;
        OfferEligibility offerEligibility2 = offerEligibility;
        ResolvedOffer resolvedOffer2 = resolvedOffer;
        boolean z4 = z3;
        boolean z5 = z2;
        String str2 = str;
        return packageComponentStyle.copy(r1, z, str2, stackComponentStyle, z5, resolvedOffer2, z4, list2, offerEligibility2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getComponentName() {
        return this.componentName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSelectable() {
        return this.isSelectable;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final List<PresentedOverride<PresentedPackagePartial>> component8() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final PackageComponentStyle copy(Package rcPackage, boolean isSelectedByDefault, String componentName, StackComponentStyle stackComponentStyle, boolean isSelectable, ResolvedOffer resolvedOffer, boolean visible, List<PresentedOverride<PresentedPackagePartial>> overrides, OfferEligibility offerEligibility) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new PackageComponentStyle(rcPackage, isSelectedByDefault, componentName, stackComponentStyle, isSelectable, resolvedOffer, visible, overrides, offerEligibility);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PackageComponentStyle)) {
            return false;
        }
        PackageComponentStyle packageComponentStyle = (PackageComponentStyle) other;
        return Intrinsics.areEqual(this.rcPackage, packageComponentStyle.rcPackage) && this.isSelectedByDefault == packageComponentStyle.isSelectedByDefault && Intrinsics.areEqual(this.componentName, packageComponentStyle.componentName) && Intrinsics.areEqual(this.stackComponentStyle, packageComponentStyle.stackComponentStyle) && this.isSelectable == packageComponentStyle.isSelectable && Intrinsics.areEqual(this.resolvedOffer, packageComponentStyle.resolvedOffer) && this.visible == packageComponentStyle.visible && Intrinsics.areEqual(this.overrides, packageComponentStyle.overrides) && Intrinsics.areEqual(this.offerEligibility, packageComponentStyle.offerEligibility);
    }

    public int hashCode() {
        int iHashCode = ((this.rcPackage.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31;
        String str = this.componentName;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stackComponentStyle.hashCode()) * 31) + Boolean.hashCode(this.isSelectable)) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode3 = (((((iHashCode2 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + Boolean.hashCode(this.visible)) * 31) + this.overrides.hashCode()) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return iHashCode3 + (offerEligibility != null ? offerEligibility.hashCode() : 0);
    }

    public String toString() {
        return "PackageComponentStyle(rcPackage=" + this.rcPackage + ", isSelectedByDefault=" + this.isSelectedByDefault + ", componentName=" + this.componentName + ", stackComponentStyle=" + this.stackComponentStyle + ", isSelectable=" + this.isSelectable + ", resolvedOffer=" + this.resolvedOffer + ", visible=" + this.visible + ", overrides=" + this.overrides + ", offerEligibility=" + this.offerEligibility + ')';
    }

    public PackageComponentStyle(Package rcPackage, boolean z, String str, StackComponentStyle stackComponentStyle, boolean z2, ResolvedOffer resolvedOffer, boolean z3, List<PresentedOverride<PresentedPackagePartial>> overrides, OfferEligibility offerEligibility) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.rcPackage = rcPackage;
        this.isSelectedByDefault = z;
        this.componentName = str;
        this.stackComponentStyle = stackComponentStyle;
        this.isSelectable = z2;
        this.resolvedOffer = resolvedOffer;
        this.visible = z3;
        this.overrides = overrides;
        this.offerEligibility = offerEligibility;
        this.size = stackComponentStyle.getSize();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public /* synthetic */ PackageComponentStyle(Package r2, boolean z, String str, StackComponentStyle stackComponentStyle, boolean z2, ResolvedOffer resolvedOffer, boolean z3, List list, OfferEligibility offerEligibility, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, z, (i & 4) != 0 ? null : str, stackComponentStyle, z2, (i & 32) != 0 ? null : resolvedOffer, z3, list, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : offerEligibility);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    public final /* synthetic */ boolean isSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    public final /* synthetic */ boolean isSelectable() {
        return this.isSelectable;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ String getUniqueId() {
        SubscriptionOption option;
        ResolvedOffer resolvedOffer = getResolvedOffer();
        String str = null;
        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
            str = option.get$id();
        }
        if (str != null) {
            return getRcPackage().getIdentifier() + ':' + str;
        }
        return getRcPackage().getIdentifier();
    }
}
