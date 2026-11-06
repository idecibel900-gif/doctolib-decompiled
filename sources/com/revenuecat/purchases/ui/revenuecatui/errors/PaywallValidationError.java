package com.revenuecat.purchases.ui.revenuecatui.errors;

import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.ui.revenuecatui.strings.PaywallValidationErrorStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0015\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u0082\u0001\u0015\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "", "()V", "associatedErrorString", "", "offering", "Lcom/revenuecat/purchases/Offering;", "AliasedColorIsAlias", "AllLocalizationsMissing", "AllVariableLocalizationsMissing", "InvalidIcons", "InvalidModeForComponentsPaywall", "InvalidTemplate", "InvalidVariables", "MissingColorAlias", "MissingFontAlias", "MissingImageLocalization", "MissingPackage", "MissingPaywall", "MissingStringLocalization", "MissingTierConfigurations", "MissingTiers", "MissingVideoLocalization", "RootComponentUnsupportedProperties", "TabControlNotInTab", "TabsComponentWithoutTabs", "UnsupportedBackgroundType", "WorkflowButtonMissingComponentId", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AliasedColorIsAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllLocalizationsMissing;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllVariableLocalizationsMissing;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidIcons;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidModeForComponentsPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidTemplate;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidVariables;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingColorAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingFontAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingPackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingTierConfigurations;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingTiers;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$RootComponentUnsupportedProperties;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$TabControlNotInTab;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$TabsComponentWithoutTabs;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$UnsupportedBackgroundType;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$WorkflowButtonMissingComponentId;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallValidationError extends Throwable {
    public static final int $stable = 0;

    public /* synthetic */ PaywallValidationError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallValidationError() {
    }

    public final String associatedErrorString(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (this instanceof InvalidIcons) {
            String str = String.format(PaywallValidationErrorStrings.INVALID_ICONS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((InvalidIcons) this).getInvalidIcons(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (this instanceof InvalidTemplate) {
            String str2 = String.format(PaywallValidationErrorStrings.INVALID_TEMPLATE_NAME, Arrays.copyOf(new Object[]{((InvalidTemplate) this).getTemplateName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        if (this instanceof InvalidVariables) {
            String str3 = String.format(PaywallValidationErrorStrings.INVALID_VARIABLES, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((InvalidVariables) this).getUnrecognizedVariables(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
        if (this instanceof MissingPaywall) {
            String str4 = String.format(PaywallValidationErrorStrings.MISSING_PAYWALL, Arrays.copyOf(new Object[]{offering.getIdentifier()}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            return str4;
        }
        if (this instanceof MissingTiers) {
            String str5 = String.format(PaywallValidationErrorStrings.MISSING_TIERS, Arrays.copyOf(new Object[]{offering.getIdentifier()}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            return str5;
        }
        if (this instanceof MissingTierConfigurations) {
            String str6 = String.format(PaywallValidationErrorStrings.MISSING_TIER_CONFIGURATIONS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(((MissingTierConfigurations) this).getTierIds(), null, null, null, 0, null, null, 63, null)}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            return str6;
        }
        if (this instanceof MissingStringLocalization) {
            return ((MissingStringLocalization) this).getMessage();
        }
        if (this instanceof MissingImageLocalization) {
            return ((MissingImageLocalization) this).getMessage();
        }
        if (this instanceof MissingVideoLocalization) {
            return ((MissingVideoLocalization) this).getMessage();
        }
        if (this instanceof AllLocalizationsMissing) {
            return ((AllLocalizationsMissing) this).getMessage();
        }
        if (this instanceof AllVariableLocalizationsMissing) {
            return ((AllVariableLocalizationsMissing) this).getMessage();
        }
        if (this instanceof MissingPackage) {
            return ((MissingPackage) this).getMessage();
        }
        if (this instanceof MissingColorAlias) {
            return ((MissingColorAlias) this).getMessage();
        }
        if (this instanceof AliasedColorIsAlias) {
            return ((AliasedColorIsAlias) this).getMessage();
        }
        if (this instanceof MissingFontAlias) {
            return ((MissingFontAlias) this).getMessage();
        }
        if (this instanceof InvalidModeForComponentsPaywall) {
            return PaywallValidationErrorStrings.INVALID_MODE_FOR_COMPONENTS_PAYWALL;
        }
        if (this instanceof TabsComponentWithoutTabs) {
            return ((TabsComponentWithoutTabs) this).getMessage();
        }
        if (this instanceof TabControlNotInTab) {
            return ((TabControlNotInTab) this).getMessage();
        }
        if (this instanceof UnsupportedBackgroundType) {
            return ((UnsupportedBackgroundType) this).getMessage();
        }
        if (this instanceof RootComponentUnsupportedProperties) {
            return ((RootComponentUnsupportedProperties) this).getMessage();
        }
        if (this instanceof WorkflowButtonMissingComponentId) {
            return ((WorkflowButtonMissingComponentId) this).getMessage();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MissingPaywall extends PaywallValidationError {
        public static final int $stable = 0;
        public static final MissingPaywall INSTANCE = new MissingPaywall();

        private MissingPaywall() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidTemplate;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "templateName", "", "(Ljava/lang/String;)V", "getTemplateName", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidTemplate extends PaywallValidationError {
        public static final int $stable = 0;
        private final String templateName;

        public static /* synthetic */ InvalidTemplate copy$default(InvalidTemplate invalidTemplate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidTemplate.templateName;
            }
            return invalidTemplate.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTemplateName() {
            return this.templateName;
        }

        public final InvalidTemplate copy(String templateName) {
            Intrinsics.checkNotNullParameter(templateName, "templateName");
            return new InvalidTemplate(templateName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidTemplate) && Intrinsics.areEqual(this.templateName, ((InvalidTemplate) other).templateName);
        }

        public int hashCode() {
            return this.templateName.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidTemplate(templateName=" + this.templateName + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidTemplate(String templateName) {
            super(null);
            Intrinsics.checkNotNullParameter(templateName, "templateName");
            this.templateName = templateName;
        }

        public final String getTemplateName() {
            return this.templateName;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidVariables;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "unrecognizedVariables", "", "", "(Ljava/util/Set;)V", "getUnrecognizedVariables", "()Ljava/util/Set;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidVariables extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> unrecognizedVariables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidVariables copy$default(InvalidVariables invalidVariables, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = invalidVariables.unrecognizedVariables;
            }
            return invalidVariables.copy(set);
        }

        public final Set<String> component1() {
            return this.unrecognizedVariables;
        }

        public final InvalidVariables copy(Set<String> unrecognizedVariables) {
            Intrinsics.checkNotNullParameter(unrecognizedVariables, "unrecognizedVariables");
            return new InvalidVariables(unrecognizedVariables);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidVariables) && Intrinsics.areEqual(this.unrecognizedVariables, ((InvalidVariables) other).unrecognizedVariables);
        }

        public int hashCode() {
            return this.unrecognizedVariables.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidVariables(unrecognizedVariables=" + this.unrecognizedVariables + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidVariables(Set<String> unrecognizedVariables) {
            super(null);
            Intrinsics.checkNotNullParameter(unrecognizedVariables, "unrecognizedVariables");
            this.unrecognizedVariables = unrecognizedVariables;
        }

        public final Set<String> getUnrecognizedVariables() {
            return this.unrecognizedVariables;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidIcons;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "invalidIcons", "", "", "(Ljava/util/Set;)V", "getInvalidIcons", "()Ljava/util/Set;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidIcons extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> invalidIcons;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidIcons copy$default(InvalidIcons invalidIcons, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = invalidIcons.invalidIcons;
            }
            return invalidIcons.copy(set);
        }

        public final Set<String> component1() {
            return this.invalidIcons;
        }

        public final InvalidIcons copy(Set<String> invalidIcons) {
            Intrinsics.checkNotNullParameter(invalidIcons, "invalidIcons");
            return new InvalidIcons(invalidIcons);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidIcons) && Intrinsics.areEqual(this.invalidIcons, ((InvalidIcons) other).invalidIcons);
        }

        public int hashCode() {
            return this.invalidIcons.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidIcons(invalidIcons=" + this.invalidIcons + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidIcons(Set<String> invalidIcons) {
            super(null);
            Intrinsics.checkNotNullParameter(invalidIcons, "invalidIcons");
            this.invalidIcons = invalidIcons;
        }

        public final Set<String> getInvalidIcons() {
            return this.invalidIcons;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingTiers;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MissingTiers extends PaywallValidationError {
        public static final int $stable = 0;
        public static final MissingTiers INSTANCE = new MissingTiers();

        private MissingTiers() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingTierConfigurations;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "tierIds", "", "", "(Ljava/util/Set;)V", "getTierIds", "()Ljava/util/Set;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingTierConfigurations extends PaywallValidationError {
        public static final int $stable = 8;
        private final Set<String> tierIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MissingTierConfigurations copy$default(MissingTierConfigurations missingTierConfigurations, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = missingTierConfigurations.tierIds;
            }
            return missingTierConfigurations.copy(set);
        }

        public final Set<String> component1() {
            return this.tierIds;
        }

        public final MissingTierConfigurations copy(Set<String> tierIds) {
            Intrinsics.checkNotNullParameter(tierIds, "tierIds");
            return new MissingTierConfigurations(tierIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingTierConfigurations) && Intrinsics.areEqual(this.tierIds, ((MissingTierConfigurations) other).tierIds);
        }

        public int hashCode() {
            return this.tierIds.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingTierConfigurations(tierIds=" + this.tierIds + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTierConfigurations(Set<String> tierIds) {
            super(null);
            Intrinsics.checkNotNullParameter(tierIds, "tierIds");
            this.tierIds = tierIds;
        }

        public final Set<String> getTierIds() {
            return this.tierIds;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\fHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "locale", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "getLocale-DxqohGs", "message", "", "getMessage", "component1", "component1-z7Tp-4o", "component2", "component2-DxqohGs", "copy", "copy-bzYoJhk", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingStringLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingStringLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingStringLocalization m4500copybzYoJhk$default(MissingStringLocalization missingStringLocalization, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingStringLocalization.key;
            }
            if ((i & 2) != 0) {
                str2 = missingStringLocalization.locale;
            }
            return missingStringLocalization.m4503copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name and from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingStringLocalization m4503copybzYoJhk(String key, String locale) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingStringLocalization(key, locale, null);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0021  */
        public boolean equals(Object other) {
            boolean zM3956equalsimpl0;
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingStringLocalization)) {
                return false;
            }
            MissingStringLocalization missingStringLocalization = (MissingStringLocalization) other;
            if (!LocalizationKey.m3992equalsimpl0(this.key, missingStringLocalization.key)) {
                return false;
            }
            String str = this.locale;
            String str2 = missingStringLocalization.locale;
            if (str == null) {
                if (str2 == null) {
                    zM3956equalsimpl0 = true;
                } else {
                    zM3956equalsimpl0 = false;
                }
            } else if (str2 == null) {
                zM3956equalsimpl0 = false;
            } else {
                zM3956equalsimpl0 = LocaleId.m3956equalsimpl0(str, str2);
            }
            return zM3956equalsimpl0;
        }

        public int hashCode() {
            int iM3993hashCodeimpl = LocalizationKey.m3993hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM3993hashCodeimpl + (str == null ? 0 : LocaleId.m3957hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingStringLocalization(key=");
            sb.append((Object) LocalizationKey.m3994toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m3958toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingStringLocalization(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, null);
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m4504getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m4505getLocaleDxqohGs() {
            return this.locale;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingStringLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_STRING_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_STRING_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\fHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "locale", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "getLocale-DxqohGs", "message", "", "getMessage", "component1", "component1-z7Tp-4o", "component2", "component2-DxqohGs", "copy", "copy-bzYoJhk", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingImageLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingImageLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingImageLocalization m4494copybzYoJhk$default(MissingImageLocalization missingImageLocalization, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingImageLocalization.key;
            }
            if ((i & 2) != 0) {
                str2 = missingImageLocalization.locale;
            }
            return missingImageLocalization.m4497copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name and from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingImageLocalization m4497copybzYoJhk(String key, String locale) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingImageLocalization(key, locale, null);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0021  */
        public boolean equals(Object other) {
            boolean zM3956equalsimpl0;
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingImageLocalization)) {
                return false;
            }
            MissingImageLocalization missingImageLocalization = (MissingImageLocalization) other;
            if (!LocalizationKey.m3992equalsimpl0(this.key, missingImageLocalization.key)) {
                return false;
            }
            String str = this.locale;
            String str2 = missingImageLocalization.locale;
            if (str == null) {
                if (str2 == null) {
                    zM3956equalsimpl0 = true;
                } else {
                    zM3956equalsimpl0 = false;
                }
            } else if (str2 == null) {
                zM3956equalsimpl0 = false;
            } else {
                zM3956equalsimpl0 = LocaleId.m3956equalsimpl0(str, str2);
            }
            return zM3956equalsimpl0;
        }

        public int hashCode() {
            int iM3993hashCodeimpl = LocalizationKey.m3993hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM3993hashCodeimpl + (str == null ? 0 : LocaleId.m3957hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingImageLocalization(key=");
            sb.append((Object) LocalizationKey.m3994toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m3958toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingImageLocalization(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, null);
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m4498getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m4499getLocaleDxqohGs() {
            return this.locale;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingImageLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_IMAGE_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_IMAGE_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\fHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "locale", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "getLocale-DxqohGs", "message", "", "getMessage", "component1", "component1-z7Tp-4o", "component2", "component2-DxqohGs", "copy", "copy-bzYoJhk", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingVideoLocalization extends PaywallValidationError {
        public static final int $stable = 0;
        private final String key;
        private final String locale;
        private final String message;

        public /* synthetic */ MissingVideoLocalization(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-bzYoJhk$default, reason: not valid java name */
        public static /* synthetic */ MissingVideoLocalization m4506copybzYoJhk$default(MissingVideoLocalization missingVideoLocalization, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingVideoLocalization.key;
            }
            if ((i & 2) != 0) {
                str2 = missingVideoLocalization.locale;
            }
            return missingVideoLocalization.m4509copybzYoJhk(str, str2);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2-DxqohGs, reason: not valid java name and from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-bzYoJhk, reason: not valid java name */
        public final MissingVideoLocalization m4509copybzYoJhk(String key, String locale) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new MissingVideoLocalization(key, locale, null);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0021  */
        public boolean equals(Object other) {
            boolean zM3956equalsimpl0;
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingVideoLocalization)) {
                return false;
            }
            MissingVideoLocalization missingVideoLocalization = (MissingVideoLocalization) other;
            if (!LocalizationKey.m3992equalsimpl0(this.key, missingVideoLocalization.key)) {
                return false;
            }
            String str = this.locale;
            String str2 = missingVideoLocalization.locale;
            if (str == null) {
                if (str2 == null) {
                    zM3956equalsimpl0 = true;
                } else {
                    zM3956equalsimpl0 = false;
                }
            } else if (str2 == null) {
                zM3956equalsimpl0 = false;
            } else {
                zM3956equalsimpl0 = LocaleId.m3956equalsimpl0(str, str2);
            }
            return zM3956equalsimpl0;
        }

        public int hashCode() {
            int iM3993hashCodeimpl = LocalizationKey.m3993hashCodeimpl(this.key) * 31;
            String str = this.locale;
            return iM3993hashCodeimpl + (str == null ? 0 : LocaleId.m3957hashCodeimpl(str));
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissingVideoLocalization(key=");
            sb.append((Object) LocalizationKey.m3994toStringimpl(this.key));
            sb.append(", locale=");
            String str = this.locale;
            sb.append((Object) (str == null ? "null" : LocaleId.m3958toStringimpl(str)));
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ MissingVideoLocalization(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, null);
        }

        /* JADX INFO: renamed from: getKey-z7Tp-4o, reason: not valid java name */
        public final String m4510getKeyz7Tp4o() {
            return this.key;
        }

        /* JADX INFO: renamed from: getLocale-DxqohGs, reason: not valid java name */
        public final String m4511getLocaleDxqohGs() {
            return this.locale;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingVideoLocalization(String key, String str) {
            String str2;
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.locale = str;
            if (str != null) {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_VIDEO_LOCALIZATION_WITH_LOCALE, Arrays.copyOf(new Object[]{key, str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            } else {
                str2 = String.format(PaywallValidationErrorStrings.MISSING_VIDEO_LOCALIZATION, Arrays.copyOf(new Object[]{key}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            this.message = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllLocalizationsMissing;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "locale", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLocale-uqtKvyA", "()Ljava/lang/String;", "Ljava/lang/String;", "message", "", "getMessage", "component1", "component1-uqtKvyA", "copy", "copy-_KYeFs0", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllLocalizationsMissing;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AllLocalizationsMissing extends PaywallValidationError {
        public static final int $stable = 0;
        private final String locale;
        private final String message;

        public /* synthetic */ AllLocalizationsMissing(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-_KYeFs0$default, reason: not valid java name */
        public static /* synthetic */ AllLocalizationsMissing m4478copy_KYeFs0$default(AllLocalizationsMissing allLocalizationsMissing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = allLocalizationsMissing.locale;
            }
            return allLocalizationsMissing.m4480copy_KYeFs0(str);
        }

        /* JADX INFO: renamed from: component1-uqtKvyA, reason: not valid java name and from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-_KYeFs0, reason: not valid java name */
        public final AllLocalizationsMissing m4480copy_KYeFs0(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new AllLocalizationsMissing(locale, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AllLocalizationsMissing) && LocaleId.m3956equalsimpl0(this.locale, ((AllLocalizationsMissing) other).locale);
        }

        public int hashCode() {
            return LocaleId.m3957hashCodeimpl(this.locale);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AllLocalizationsMissing(locale=" + ((Object) LocaleId.m3958toStringimpl(this.locale)) + ')';
        }

        /* JADX INFO: renamed from: getLocale-uqtKvyA, reason: not valid java name */
        public final String m4481getLocaleuqtKvyA() {
            return this.locale;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AllLocalizationsMissing(String locale) {
            super(null);
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
            String str = String.format(PaywallValidationErrorStrings.ALL_LOCALIZATIONS_MISSING_FOR_LOCALE, Arrays.copyOf(new Object[]{locale}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllVariableLocalizationsMissing;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "locale", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLocale-uqtKvyA", "()Ljava/lang/String;", "Ljava/lang/String;", "message", "", "getMessage", "component1", "component1-uqtKvyA", "copy", "copy-_KYeFs0", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AllVariableLocalizationsMissing;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AllVariableLocalizationsMissing extends PaywallValidationError {
        public static final int $stable = 0;
        private final String locale;
        private final String message;

        public /* synthetic */ AllVariableLocalizationsMissing(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-_KYeFs0$default, reason: not valid java name */
        public static /* synthetic */ AllVariableLocalizationsMissing m4482copy_KYeFs0$default(AllVariableLocalizationsMissing allVariableLocalizationsMissing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = allVariableLocalizationsMissing.locale;
            }
            return allVariableLocalizationsMissing.m4484copy_KYeFs0(str);
        }

        /* JADX INFO: renamed from: component1-uqtKvyA, reason: not valid java name and from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: copy-_KYeFs0, reason: not valid java name */
        public final AllVariableLocalizationsMissing m4484copy_KYeFs0(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new AllVariableLocalizationsMissing(locale, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AllVariableLocalizationsMissing) && LocaleId.m3956equalsimpl0(this.locale, ((AllVariableLocalizationsMissing) other).locale);
        }

        public int hashCode() {
            return LocaleId.m3957hashCodeimpl(this.locale);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AllVariableLocalizationsMissing(locale=" + ((Object) LocaleId.m3958toStringimpl(this.locale)) + ')';
        }

        /* JADX INFO: renamed from: getLocale-uqtKvyA, reason: not valid java name */
        public final String m4485getLocaleuqtKvyA() {
            return this.locale;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AllVariableLocalizationsMissing(String locale) {
            super(null);
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
            String str = String.format(PaywallValidationErrorStrings.ALL_VARIABLE_LOCALIZATIONS_MISSING_FOR_LOCALE, Arrays.copyOf(new Object[]{locale}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingPackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "offeringId", "", "missingPackageId", "allPackageIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)V", "getAllPackageIds", "()Ljava/util/Collection;", "message", "getMessage", "()Ljava/lang/String;", "getMissingPackageId", "getOfferingId", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingPackage extends PaywallValidationError {
        public static final int $stable = 8;
        private final Collection<String> allPackageIds;
        private final String message;
        private final String missingPackageId;
        private final String offeringId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MissingPackage copy$default(MissingPackage missingPackage, String str, String str2, Collection collection, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingPackage.offeringId;
            }
            if ((i & 2) != 0) {
                str2 = missingPackage.missingPackageId;
            }
            if ((i & 4) != 0) {
                collection = missingPackage.allPackageIds;
            }
            return missingPackage.copy(str, str2, collection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOfferingId() {
            return this.offeringId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMissingPackageId() {
            return this.missingPackageId;
        }

        public final Collection<String> component3() {
            return this.allPackageIds;
        }

        public final MissingPackage copy(String offeringId, String missingPackageId, Collection<String> allPackageIds) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            Intrinsics.checkNotNullParameter(missingPackageId, "missingPackageId");
            Intrinsics.checkNotNullParameter(allPackageIds, "allPackageIds");
            return new MissingPackage(offeringId, missingPackageId, allPackageIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MissingPackage)) {
                return false;
            }
            MissingPackage missingPackage = (MissingPackage) other;
            return Intrinsics.areEqual(this.offeringId, missingPackage.offeringId) && Intrinsics.areEqual(this.missingPackageId, missingPackage.missingPackageId) && Intrinsics.areEqual(this.allPackageIds, missingPackage.allPackageIds);
        }

        public int hashCode() {
            return (((this.offeringId.hashCode() * 31) + this.missingPackageId.hashCode()) * 31) + this.allPackageIds.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingPackage(offeringId=" + this.offeringId + ", missingPackageId=" + this.missingPackageId + ", allPackageIds=" + this.allPackageIds + ')';
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final String getMissingPackageId() {
            return this.missingPackageId;
        }

        public final Collection<String> getAllPackageIds() {
            return this.allPackageIds;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingPackage(String offeringId, String missingPackageId, Collection<String> allPackageIds) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            Intrinsics.checkNotNullParameter(missingPackageId, "missingPackageId");
            Intrinsics.checkNotNullParameter(allPackageIds, "allPackageIds");
            this.offeringId = offeringId;
            this.missingPackageId = missingPackageId;
            this.allPackageIds = allPackageIds;
            String str = String.format(PaywallValidationErrorStrings.MISSING_PACKAGE, Arrays.copyOf(new Object[]{missingPackageId, offeringId, CollectionsKt.joinToString$default(allPackageIds, null, null, null, 0, null, null, 63, null)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingColorAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "alias", "Lcom/revenuecat/purchases/ColorAlias;", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlias-671NwFM", "()Ljava/lang/String;", "Ljava/lang/String;", "message", "", "getMessage", "component1", "component1-671NwFM", "copy", "copy-iZ0V_xs", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingColorAlias;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingColorAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String message;

        public /* synthetic */ MissingColorAlias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-iZ0V_xs$default, reason: not valid java name */
        public static /* synthetic */ MissingColorAlias m4486copyiZ0V_xs$default(MissingColorAlias missingColorAlias, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingColorAlias.alias;
            }
            return missingColorAlias.m4488copyiZ0V_xs(str);
        }

        /* JADX INFO: renamed from: component1-671NwFM, reason: not valid java name and from getter */
        public final String getAlias() {
            return this.alias;
        }

        /* JADX INFO: renamed from: copy-iZ0V_xs, reason: not valid java name */
        public final MissingColorAlias m4488copyiZ0V_xs(String alias) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            return new MissingColorAlias(alias, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingColorAlias) && ColorAlias.m3740equalsimpl0(this.alias, ((MissingColorAlias) other).alias);
        }

        public int hashCode() {
            return ColorAlias.m3741hashCodeimpl(this.alias);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingColorAlias(alias=" + ((Object) ColorAlias.m3742toStringimpl(this.alias)) + ')';
        }

        /* JADX INFO: renamed from: getAlias-671NwFM, reason: not valid java name */
        public final String m4489getAlias671NwFM() {
            return this.alias;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingColorAlias(String alias) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            this.alias = alias;
            String str = String.format(PaywallValidationErrorStrings.MISSING_COLOR_ALIAS, Arrays.copyOf(new Object[]{alias}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\r\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AliasedColorIsAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "alias", "Lcom/revenuecat/purchases/ColorAlias;", "aliasedValue", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlias-671NwFM", "()Ljava/lang/String;", "Ljava/lang/String;", "getAliasedValue-671NwFM", "message", "", "getMessage", "component1", "component1-671NwFM", "component2", "component2-671NwFM", "copy", "copy-tjeIzsg", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$AliasedColorIsAlias;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AliasedColorIsAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String aliasedValue;
        private final String message;

        public /* synthetic */ AliasedColorIsAlias(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-tjeIzsg$default, reason: not valid java name */
        public static /* synthetic */ AliasedColorIsAlias m4472copytjeIzsg$default(AliasedColorIsAlias aliasedColorIsAlias, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aliasedColorIsAlias.alias;
            }
            if ((i & 2) != 0) {
                str2 = aliasedColorIsAlias.aliasedValue;
            }
            return aliasedColorIsAlias.m4475copytjeIzsg(str, str2);
        }

        /* JADX INFO: renamed from: component1-671NwFM, reason: not valid java name and from getter */
        public final String getAlias() {
            return this.alias;
        }

        /* JADX INFO: renamed from: component2-671NwFM, reason: not valid java name and from getter */
        public final String getAliasedValue() {
            return this.aliasedValue;
        }

        /* JADX INFO: renamed from: copy-tjeIzsg, reason: not valid java name */
        public final AliasedColorIsAlias m4475copytjeIzsg(String alias, String aliasedValue) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(aliasedValue, "aliasedValue");
            return new AliasedColorIsAlias(alias, aliasedValue, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AliasedColorIsAlias)) {
                return false;
            }
            AliasedColorIsAlias aliasedColorIsAlias = (AliasedColorIsAlias) other;
            return ColorAlias.m3740equalsimpl0(this.alias, aliasedColorIsAlias.alias) && ColorAlias.m3740equalsimpl0(this.aliasedValue, aliasedColorIsAlias.aliasedValue);
        }

        public int hashCode() {
            return (ColorAlias.m3741hashCodeimpl(this.alias) * 31) + ColorAlias.m3741hashCodeimpl(this.aliasedValue);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "AliasedColorIsAlias(alias=" + ((Object) ColorAlias.m3742toStringimpl(this.alias)) + ", aliasedValue=" + ((Object) ColorAlias.m3742toStringimpl(this.aliasedValue)) + ')';
        }

        /* JADX INFO: renamed from: getAlias-671NwFM, reason: not valid java name */
        public final String m4476getAlias671NwFM() {
            return this.alias;
        }

        /* JADX INFO: renamed from: getAliasedValue-671NwFM, reason: not valid java name */
        public final String m4477getAliasedValue671NwFM() {
            return this.aliasedValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AliasedColorIsAlias(String alias, String aliasedValue) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(aliasedValue, "aliasedValue");
            this.alias = alias;
            this.aliasedValue = aliasedValue;
            String str = String.format(PaywallValidationErrorStrings.ALIASED_COLOR_IS_ALIAS, Arrays.copyOf(new Object[]{alias, aliasedValue}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingFontAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "alias", "Lcom/revenuecat/purchases/FontAlias;", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlias-BejUyPs", "()Ljava/lang/String;", "Ljava/lang/String;", "message", "", "getMessage", "component1", "component1-BejUyPs", "copy", "copy-Qd9eHpM", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingFontAlias;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingFontAlias extends PaywallValidationError {
        public static final int $stable = 0;
        private final String alias;
        private final String message;

        public /* synthetic */ MissingFontAlias(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: renamed from: copy-Qd9eHpM$default, reason: not valid java name */
        public static /* synthetic */ MissingFontAlias m4490copyQd9eHpM$default(MissingFontAlias missingFontAlias, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingFontAlias.alias;
            }
            return missingFontAlias.m4492copyQd9eHpM(str);
        }

        /* JADX INFO: renamed from: component1-BejUyPs, reason: not valid java name and from getter */
        public final String getAlias() {
            return this.alias;
        }

        /* JADX INFO: renamed from: copy-Qd9eHpM, reason: not valid java name */
        public final MissingFontAlias m4492copyQd9eHpM(String alias) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            return new MissingFontAlias(alias, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingFontAlias) && FontAlias.m3759equalsimpl0(this.alias, ((MissingFontAlias) other).alias);
        }

        public int hashCode() {
            return FontAlias.m3760hashCodeimpl(this.alias);
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "MissingFontAlias(alias=" + ((Object) FontAlias.m3761toStringimpl(this.alias)) + ')';
        }

        /* JADX INFO: renamed from: getAlias-BejUyPs, reason: not valid java name */
        public final String m4493getAliasBejUyPs() {
            return this.alias;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private MissingFontAlias(String alias) {
            super(null);
            Intrinsics.checkNotNullParameter(alias, "alias");
            this.alias = alias;
            String str = String.format(PaywallValidationErrorStrings.MISSING_FONT_ALIAS, Arrays.copyOf(new Object[]{alias}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$InvalidModeForComponentsPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InvalidModeForComponentsPaywall extends PaywallValidationError {
        public static final int $stable = 0;
        public static final InvalidModeForComponentsPaywall INSTANCE = new InvalidModeForComponentsPaywall();

        private InvalidModeForComponentsPaywall() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$TabsComponentWithoutTabs;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TabsComponentWithoutTabs extends PaywallValidationError {
        public static final int $stable = 0;
        public static final TabsComponentWithoutTabs INSTANCE = new TabsComponentWithoutTabs();
        private static final String message = PaywallValidationErrorStrings.TABS_COMPONENT_WITHOUT_TABS;

        private TabsComponentWithoutTabs() {
            super(null);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return message;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$TabControlNotInTab;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TabControlNotInTab extends PaywallValidationError {
        public static final int $stable = 0;
        public static final TabControlNotInTab INSTANCE = new TabControlNotInTab();
        private static final String message = PaywallValidationErrorStrings.TAB_CONTROL_NOT_IN_TAB;

        private TabControlNotInTab() {
            super(null);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$UnsupportedBackgroundType;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;", "(Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;)V", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background$Unknown;", "message", "", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnsupportedBackgroundType extends PaywallValidationError {
        public static final int $stable = 8;
        private final Background.Unknown background;
        private final String message;

        public static /* synthetic */ UnsupportedBackgroundType copy$default(UnsupportedBackgroundType unsupportedBackgroundType, Background.Unknown unknown, int i, Object obj) {
            if ((i & 1) != 0) {
                unknown = unsupportedBackgroundType.background;
            }
            return unsupportedBackgroundType.copy(unknown);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Background.Unknown getBackground() {
            return this.background;
        }

        public final UnsupportedBackgroundType copy(Background.Unknown background) {
            Intrinsics.checkNotNullParameter(background, "background");
            return new UnsupportedBackgroundType(background);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnsupportedBackgroundType) && Intrinsics.areEqual(this.background, ((UnsupportedBackgroundType) other).background);
        }

        public int hashCode() {
            return this.background.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "UnsupportedBackgroundType(background=" + this.background + ')';
        }

        public final Background.Unknown getBackground() {
            return this.background;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedBackgroundType(Background.Unknown background) {
            super(null);
            Intrinsics.checkNotNullParameter(background, "background");
            this.background = background;
            String str = String.format(PaywallValidationErrorStrings.UNSUPPORTED_BACKGROUND_TYPE, Arrays.copyOf(new Object[]{background.getType()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$RootComponentUnsupportedProperties;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "component", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;)V", "getComponent", "()Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "message", "", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RootComponentUnsupportedProperties extends PaywallValidationError {
        public static final int $stable = 8;
        private final PaywallComponent component;
        private final String message;

        public static /* synthetic */ RootComponentUnsupportedProperties copy$default(RootComponentUnsupportedProperties rootComponentUnsupportedProperties, PaywallComponent paywallComponent, int i, Object obj) {
            if ((i & 1) != 0) {
                paywallComponent = rootComponentUnsupportedProperties.component;
            }
            return rootComponentUnsupportedProperties.copy(paywallComponent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PaywallComponent getComponent() {
            return this.component;
        }

        public final RootComponentUnsupportedProperties copy(PaywallComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            return new RootComponentUnsupportedProperties(component);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RootComponentUnsupportedProperties) && Intrinsics.areEqual(this.component, ((RootComponentUnsupportedProperties) other).component);
        }

        public int hashCode() {
            return this.component.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "RootComponentUnsupportedProperties(component=" + this.component + ')';
        }

        public final PaywallComponent getComponent() {
            return this.component;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RootComponentUnsupportedProperties(PaywallComponent component) {
            super(null);
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
            String str = String.format(PaywallValidationErrorStrings.ROOT_COMPONENT_UNSUPPORTED_PROPERTIES, Arrays.copyOf(new Object[]{component.getClass().getSimpleName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$WorkflowButtonMissingComponentId;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "componentName", "", "(Ljava/lang/String;)V", "getComponentName", "()Ljava/lang/String;", "message", "getMessage", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WorkflowButtonMissingComponentId extends PaywallValidationError {
        public static final int $stable = 0;
        private final String componentName;
        private final String message;

        public static /* synthetic */ WorkflowButtonMissingComponentId copy$default(WorkflowButtonMissingComponentId workflowButtonMissingComponentId, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = workflowButtonMissingComponentId.componentName;
            }
            return workflowButtonMissingComponentId.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getComponentName() {
            return this.componentName;
        }

        public final WorkflowButtonMissingComponentId copy(String componentName) {
            return new WorkflowButtonMissingComponentId(componentName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WorkflowButtonMissingComponentId) && Intrinsics.areEqual(this.componentName, ((WorkflowButtonMissingComponentId) other).componentName);
        }

        public int hashCode() {
            String str = this.componentName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "WorkflowButtonMissingComponentId(componentName=" + this.componentName + ')';
        }

        public final String getComponentName() {
            return this.componentName;
        }

        public WorkflowButtonMissingComponentId(String str) {
            super(null);
            this.componentName = str;
            String str2 = String.format(PaywallValidationErrorStrings.WORKFLOW_BUTTON_MISSING_COMPONENT_ID, Arrays.copyOf(new Object[]{str == null ? "<unnamed>" : str}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            this.message = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }
}
