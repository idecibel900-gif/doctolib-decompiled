package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 32\u00020\u0001:\u00013B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00064"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "", b.S, "", "subtitle", "callToAction", "callToActionWithIntroOffer", "callToActionWithMultipleIntroOffers", "offerDetails", "offerDetailsWithIntroOffer", "offerDetailsWithMultipleIntroOffers", "offerName", "offerBadge", "features", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "tierName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCallToAction", "()Ljava/lang/String;", "getCallToActionWithIntroOffer", "getCallToActionWithMultipleIntroOffers", "getFeatures", "()Ljava/util/List;", "getOfferBadge", "getOfferDetails", "getOfferDetailsWithIntroOffer", "getOfferDetailsWithMultipleIntroOffers", "getOfferName", "getSubtitle", "getTierName", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProcessedLocalizedConfiguration {
    private final String callToAction;
    private final String callToActionWithIntroOffer;
    private final String callToActionWithMultipleIntroOffers;
    private final List<PaywallData.LocalizedConfiguration.Feature> features;
    private final String offerBadge;
    private final String offerDetails;
    private final String offerDetailsWithIntroOffer;
    private final String offerDetailsWithMultipleIntroOffers;
    private final String offerName;
    private final String subtitle;
    private final String tierName;
    private final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProcessedLocalizedConfiguration copy$default(ProcessedLocalizedConfiguration processedLocalizedConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = processedLocalizedConfiguration.title;
        }
        if ((i & 2) != 0) {
            str2 = processedLocalizedConfiguration.subtitle;
        }
        if ((i & 4) != 0) {
            str3 = processedLocalizedConfiguration.callToAction;
        }
        if ((i & 8) != 0) {
            str4 = processedLocalizedConfiguration.callToActionWithIntroOffer;
        }
        if ((i & 16) != 0) {
            str5 = processedLocalizedConfiguration.callToActionWithMultipleIntroOffers;
        }
        if ((i & 32) != 0) {
            str6 = processedLocalizedConfiguration.offerDetails;
        }
        if ((i & 64) != 0) {
            str7 = processedLocalizedConfiguration.offerDetailsWithIntroOffer;
        }
        if ((i & 128) != 0) {
            str8 = processedLocalizedConfiguration.offerDetailsWithMultipleIntroOffers;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            str9 = processedLocalizedConfiguration.offerName;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            str10 = processedLocalizedConfiguration.offerBadge;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            list = processedLocalizedConfiguration.features;
        }
        if ((i & 2048) != 0) {
            str11 = processedLocalizedConfiguration.tierName;
        }
        List list2 = list;
        String str12 = str11;
        String str13 = str9;
        String str14 = str10;
        String str15 = str7;
        String str16 = str8;
        String str17 = str5;
        String str18 = str6;
        return processedLocalizedConfiguration.copy(str, str2, str3, str4, str17, str18, str15, str16, str13, str14, list2, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOfferBadge() {
        return this.offerBadge;
    }

    public final List<PaywallData.LocalizedConfiguration.Feature> component11() {
        return this.features;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCallToAction() {
        return this.callToAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCallToActionWithIntroOffer() {
        return this.callToActionWithIntroOffer;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCallToActionWithMultipleIntroOffers() {
        return this.callToActionWithMultipleIntroOffers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOfferDetails() {
        return this.offerDetails;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOfferDetailsWithIntroOffer() {
        return this.offerDetailsWithIntroOffer;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOfferDetailsWithMultipleIntroOffers() {
        return this.offerDetailsWithMultipleIntroOffers;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOfferName() {
        return this.offerName;
    }

    public final ProcessedLocalizedConfiguration copy(String title, String subtitle, String callToAction, String callToActionWithIntroOffer, String callToActionWithMultipleIntroOffers, String offerDetails, String offerDetailsWithIntroOffer, String offerDetailsWithMultipleIntroOffers, String offerName, String offerBadge, List<PaywallData.LocalizedConfiguration.Feature> features, String tierName) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callToAction, "callToAction");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ProcessedLocalizedConfiguration(title, subtitle, callToAction, callToActionWithIntroOffer, callToActionWithMultipleIntroOffers, offerDetails, offerDetailsWithIntroOffer, offerDetailsWithMultipleIntroOffers, offerName, offerBadge, features, tierName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessedLocalizedConfiguration)) {
            return false;
        }
        ProcessedLocalizedConfiguration processedLocalizedConfiguration = (ProcessedLocalizedConfiguration) other;
        return Intrinsics.areEqual(this.title, processedLocalizedConfiguration.title) && Intrinsics.areEqual(this.subtitle, processedLocalizedConfiguration.subtitle) && Intrinsics.areEqual(this.callToAction, processedLocalizedConfiguration.callToAction) && Intrinsics.areEqual(this.callToActionWithIntroOffer, processedLocalizedConfiguration.callToActionWithIntroOffer) && Intrinsics.areEqual(this.callToActionWithMultipleIntroOffers, processedLocalizedConfiguration.callToActionWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerDetails, processedLocalizedConfiguration.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, processedLocalizedConfiguration.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, processedLocalizedConfiguration.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerName, processedLocalizedConfiguration.offerName) && Intrinsics.areEqual(this.offerBadge, processedLocalizedConfiguration.offerBadge) && Intrinsics.areEqual(this.features, processedLocalizedConfiguration.features) && Intrinsics.areEqual(this.tierName, processedLocalizedConfiguration.tierName);
    }

    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        String str = this.subtitle;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
        String str2 = this.callToActionWithIntroOffer;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.callToActionWithMultipleIntroOffers;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.offerDetails;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.offerDetailsWithIntroOffer;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.offerDetailsWithMultipleIntroOffers;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.offerName;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.offerBadge;
        int iHashCode9 = (((iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.features.hashCode()) * 31;
        String str9 = this.tierName;
        return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "ProcessedLocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", offerBadge=" + this.offerBadge + ", features=" + this.features + ", tierName=" + this.tierName + ')';
    }

    public ProcessedLocalizedConfiguration(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<PaywallData.LocalizedConfiguration.Feature> features, String str9) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callToAction, "callToAction");
        Intrinsics.checkNotNullParameter(features, "features");
        this.title = title;
        this.subtitle = str;
        this.callToAction = callToAction;
        this.callToActionWithIntroOffer = str2;
        this.callToActionWithMultipleIntroOffers = str3;
        this.offerDetails = str4;
        this.offerDetailsWithIntroOffer = str5;
        this.offerDetailsWithMultipleIntroOffers = str6;
        this.offerName = str7;
        this.offerBadge = str8;
        this.features = features;
        this.tierName = str9;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final String getCallToActionWithIntroOffer() {
        return this.callToActionWithIntroOffer;
    }

    public final String getCallToActionWithMultipleIntroOffers() {
        return this.callToActionWithMultipleIntroOffers;
    }

    public final String getOfferDetails() {
        return this.offerDetails;
    }

    public final String getOfferDetailsWithIntroOffer() {
        return this.offerDetailsWithIntroOffer;
    }

    public final String getOfferDetailsWithMultipleIntroOffers() {
        return this.offerDetailsWithMultipleIntroOffers;
    }

    public final String getOfferName() {
        return this.offerName;
    }

    public final String getOfferBadge() {
        return this.offerBadge;
    }

    public /* synthetic */ ProcessedLocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? CollectionsKt.emptyList() : list, str11);
    }

    public final List<PaywallData.LocalizedConfiguration.Feature> getFeatures() {
        return this.features;
    }

    public final String getTierName() {
        return this.tierName;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration$Companion;", "", "()V", "create", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "context", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessor$PackageContext;", "localizedConfiguration", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "locale", "Ljava/util/Locale;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static final String create$processVariables(String str, VariableDataProvider variableDataProvider, VariableProcessor.PackageContext packageContext, Package r9, Locale locale) {
            return VariableProcessor.INSTANCE.processVariables(variableDataProvider, packageContext, str, r9, locale);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0041  */
        public final ProcessedLocalizedConfiguration create(VariableDataProvider variableDataProvider, VariableProcessor.PackageContext context, PaywallData.LocalizedConfiguration localizedConfiguration, Package rcPackage, Locale locale) {
            String strLocalizedRelativeDiscount;
            String str;
            String offerDetails;
            String offerDetailsWithIntroOffer;
            String offerDetailsWithMultipleIntroOffers;
            String offerName;
            Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(localizedConfiguration, "localizedConfiguration");
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(locale, "locale");
            PaywallData.LocalizedConfiguration.OfferOverride offerOverride = localizedConfiguration.getOfferOverrides().get(rcPackage.getIdentifier());
            if (offerOverride != null) {
                String offerBadge = offerOverride.getOfferBadge();
                if (offerBadge != null) {
                    strLocalizedRelativeDiscount = create$processVariables(offerBadge, variableDataProvider, context, rcPackage, locale);
                    str = strLocalizedRelativeDiscount;
                } else {
                    str = null;
                }
            } else {
                Double discountRelativeToMostExpensivePerMonth = context.getDiscountRelativeToMostExpensivePerMonth();
                if (discountRelativeToMostExpensivePerMonth != null) {
                    strLocalizedRelativeDiscount = variableDataProvider.localizedRelativeDiscount(Double.valueOf(discountRelativeToMostExpensivePerMonth.doubleValue()));
                    str = strLocalizedRelativeDiscount;
                } else {
                    str = null;
                }
            }
            String strCreate$processVariables = create$processVariables(localizedConfiguration.getTitle(), variableDataProvider, context, rcPackage, locale);
            String subtitle = localizedConfiguration.getSubtitle();
            String strCreate$processVariables2 = subtitle != null ? create$processVariables(subtitle, variableDataProvider, context, rcPackage, locale) : null;
            String strCreate$processVariables3 = create$processVariables(localizedConfiguration.getCallToAction(), variableDataProvider, context, rcPackage, locale);
            String callToActionWithIntroOffer = localizedConfiguration.getCallToActionWithIntroOffer();
            String strCreate$processVariables4 = callToActionWithIntroOffer != null ? create$processVariables(callToActionWithIntroOffer, variableDataProvider, context, rcPackage, locale) : null;
            String callToActionWithMultipleIntroOffers = localizedConfiguration.getCallToActionWithMultipleIntroOffers();
            String strCreate$processVariables5 = callToActionWithMultipleIntroOffers != null ? create$processVariables(callToActionWithMultipleIntroOffers, variableDataProvider, context, rcPackage, locale) : null;
            if (offerOverride == null || (offerDetails = offerOverride.getOfferDetails()) == null) {
                offerDetails = localizedConfiguration.getOfferDetails();
            }
            String strCreate$processVariables6 = offerDetails != null ? create$processVariables(offerDetails, variableDataProvider, context, rcPackage, locale) : null;
            if (offerOverride == null || (offerDetailsWithIntroOffer = offerOverride.getOfferDetailsWithIntroOffer()) == null) {
                offerDetailsWithIntroOffer = localizedConfiguration.getOfferDetailsWithIntroOffer();
            }
            String strCreate$processVariables7 = offerDetailsWithIntroOffer != null ? create$processVariables(offerDetailsWithIntroOffer, variableDataProvider, context, rcPackage, locale) : null;
            if (offerOverride == null || (offerDetailsWithMultipleIntroOffers = offerOverride.getOfferDetailsWithMultipleIntroOffers()) == null) {
                offerDetailsWithMultipleIntroOffers = localizedConfiguration.getOfferDetailsWithMultipleIntroOffers();
            }
            String strCreate$processVariables8 = offerDetailsWithMultipleIntroOffers != null ? create$processVariables(offerDetailsWithMultipleIntroOffers, variableDataProvider, context, rcPackage, locale) : null;
            if (offerOverride == null || (offerName = offerOverride.getOfferName()) == null) {
                offerName = localizedConfiguration.getOfferName();
            }
            String strCreate$processVariables9 = offerName != null ? create$processVariables(offerName, variableDataProvider, context, rcPackage, locale) : null;
            List<PaywallData.LocalizedConfiguration.Feature> features = localizedConfiguration.getFeatures();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(features, 10));
            for (PaywallData.LocalizedConfiguration.Feature feature : features) {
                String strCreate$processVariables10 = create$processVariables(feature.getTitle(), variableDataProvider, context, rcPackage, locale);
                String content = feature.getContent();
                arrayList.add(PaywallData.LocalizedConfiguration.Feature.copy$default(feature, strCreate$processVariables10, content != null ? create$processVariables(content, variableDataProvider, context, rcPackage, locale) : null, null, 4, null));
            }
            return new ProcessedLocalizedConfiguration(strCreate$processVariables, strCreate$processVariables2, strCreate$processVariables3, strCreate$processVariables4, strCreate$processVariables5, strCreate$processVariables6, strCreate$processVariables7, strCreate$processVariables8, strCreate$processVariables9, str, arrayList, localizedConfiguration.getTierName());
        }
    }
}
