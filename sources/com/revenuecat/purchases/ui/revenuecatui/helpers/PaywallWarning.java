package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b2\u00020\u0001:\f\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0082\u0001\u000b\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "", "()V", "bodyText", "", "getBodyText", "()Ljava/lang/String;", "helpUrl", "getHelpUrl", b.S, "getTitle", "Companion", "InvalidIcons", "InvalidTemplate", "InvalidVariables", "MissingLocalization", "MissingTier", "MissingTierName", "MissingTiers", "NoOffering", "NoPaywall", "NoProducts", "Other", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidIcons;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidTemplate;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidVariables;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTier;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTierName;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTiers;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoOffering;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoProducts;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$Other;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallWarning {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ PaywallWarning(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoOffering;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoOffering extends PaywallWarning {
        public static final int $stable = 0;
        public static final NoOffering INSTANCE = new NoOffering();

        private NoOffering() {
            super(null);
        }
    }

    private PaywallWarning() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoProducts;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NoProducts extends PaywallWarning {
        public static final int $stable = 8;
        private final Throwable error;

        public static /* synthetic */ NoProducts copy$default(NoProducts noProducts, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = noProducts.error;
            }
            return noProducts.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final NoProducts copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new NoProducts(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoProducts) && Intrinsics.areEqual(this.error, ((NoProducts) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "NoProducts(error=" + this.error + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoProducts(Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$NoPaywall;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "offeringId", "", "(Ljava/lang/String;)V", "getOfferingId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class NoPaywall extends PaywallWarning {
        public static final int $stable = 0;
        private final String offeringId;

        public static /* synthetic */ NoPaywall copy$default(NoPaywall noPaywall, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noPaywall.offeringId;
            }
            return noPaywall.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOfferingId() {
            return this.offeringId;
        }

        public final NoPaywall copy(String offeringId) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            return new NoPaywall(offeringId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoPaywall) && Intrinsics.areEqual(this.offeringId, ((NoPaywall) other).offeringId);
        }

        public int hashCode() {
            return this.offeringId.hashCode();
        }

        public String toString() {
            return "NoPaywall(offeringId=" + this.offeringId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoPaywall(String offeringId) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            this.offeringId = offeringId;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MissingLocalization extends PaywallWarning {
        public static final int $stable = 0;
        public static final MissingLocalization INSTANCE = new MissingLocalization();

        private MissingLocalization() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTiers;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MissingTiers extends PaywallWarning {
        public static final int $stable = 0;
        public static final MissingTiers INSTANCE = new MissingTiers();

        private MissingTiers() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTier;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "tierId", "", "(Ljava/lang/String;)V", "getTierId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingTier extends PaywallWarning {
        public static final int $stable = 0;
        private final String tierId;

        public static /* synthetic */ MissingTier copy$default(MissingTier missingTier, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingTier.tierId;
            }
            return missingTier.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTierId() {
            return this.tierId;
        }

        public final MissingTier copy(String tierId) {
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            return new MissingTier(tierId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingTier) && Intrinsics.areEqual(this.tierId, ((MissingTier) other).tierId);
        }

        public int hashCode() {
            return this.tierId.hashCode();
        }

        public String toString() {
            return "MissingTier(tierId=" + this.tierId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTier(String tierId) {
            super(null);
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            this.tierId = tierId;
        }

        public final String getTierId() {
            return this.tierId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$MissingTierName;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "tierId", "", "(Ljava/lang/String;)V", "getTierId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MissingTierName extends PaywallWarning {
        public static final int $stable = 0;
        private final String tierId;

        public static /* synthetic */ MissingTierName copy$default(MissingTierName missingTierName, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingTierName.tierId;
            }
            return missingTierName.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTierId() {
            return this.tierId;
        }

        public final MissingTierName copy(String tierId) {
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            return new MissingTierName(tierId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingTierName) && Intrinsics.areEqual(this.tierId, ((MissingTierName) other).tierId);
        }

        public int hashCode() {
            return this.tierId.hashCode();
        }

        public String toString() {
            return "MissingTierName(tierId=" + this.tierId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingTierName(String tierId) {
            super(null);
            Intrinsics.checkNotNullParameter(tierId, "tierId");
            this.tierId = tierId;
        }

        public final String getTierId() {
            return this.tierId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidTemplate;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "templateName", "", "(Ljava/lang/String;)V", "getTemplateName", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidTemplate extends PaywallWarning {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidVariables;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "variables", "", "", "(Ljava/util/Set;)V", "getVariables", "()Ljava/util/Set;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidVariables extends PaywallWarning {
        public static final int $stable = 8;
        private final Set<String> variables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidVariables copy$default(InvalidVariables invalidVariables, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = invalidVariables.variables;
            }
            return invalidVariables.copy(set);
        }

        public final Set<String> component1() {
            return this.variables;
        }

        public final InvalidVariables copy(Set<String> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            return new InvalidVariables(variables);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidVariables) && Intrinsics.areEqual(this.variables, ((InvalidVariables) other).variables);
        }

        public int hashCode() {
            return this.variables.hashCode();
        }

        public String toString() {
            return "InvalidVariables(variables=" + this.variables + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidVariables(Set<String> variables) {
            super(null);
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.variables = variables;
        }

        public final Set<String> getVariables() {
            return this.variables;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$InvalidIcons;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "icons", "", "", "(Ljava/util/Set;)V", "getIcons", "()Ljava/util/Set;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidIcons extends PaywallWarning {
        public static final int $stable = 8;
        private final Set<String> icons;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidIcons copy$default(InvalidIcons invalidIcons, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = invalidIcons.icons;
            }
            return invalidIcons.copy(set);
        }

        public final Set<String> component1() {
            return this.icons;
        }

        public final InvalidIcons copy(Set<String> icons) {
            Intrinsics.checkNotNullParameter(icons, "icons");
            return new InvalidIcons(icons);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidIcons) && Intrinsics.areEqual(this.icons, ((InvalidIcons) other).icons);
        }

        public int hashCode() {
            return this.icons.hashCode();
        }

        public String toString() {
            return "InvalidIcons(icons=" + this.icons + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidIcons(Set<String> icons) {
            super(null);
            Intrinsics.checkNotNullParameter(icons, "icons");
            this.icons = icons;
        }

        public final Set<String> getIcons() {
            return this.icons;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$Other;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Other extends PaywallWarning {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ Other copy$default(Other other, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = other.message;
            }
            return other.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Other copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Other(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Other) && Intrinsics.areEqual(this.message, ((Other) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Other(message=" + this.message + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Other(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    public final String getTitle() {
        if (this instanceof NoPaywall) {
            return "No Paywall configured";
        }
        if (this instanceof NoOffering) {
            return "No Offering found";
        }
        if (this instanceof NoProducts) {
            return "Could not fetch products";
        }
        if (this instanceof MissingLocalization) {
            return "Missing localization";
        }
        if (this instanceof MissingTiers) {
            return "No Tiers";
        }
        if (this instanceof MissingTier) {
            return "Tier is missing localization";
        }
        if (this instanceof MissingTierName) {
            return "Tier " + ((MissingTierName) this).getTierId() + " is missing a name";
        }
        if (this instanceof InvalidTemplate) {
            return "Unknown Template";
        }
        if (this instanceof InvalidVariables) {
            return "Unrecognized variables";
        }
        if (this instanceof InvalidIcons) {
            return "Invalid icon names";
        }
        if (this instanceof Other) {
            return "Paywall Misconfigured";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getBodyText() {
        if (this instanceof NoPaywall) {
            return "Your `" + ((NoPaywall) this).getOfferingId() + "` offering has no configured paywalls. Set one up in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof NoOffering) {
            return "We could not detect any offerings. Set one up in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof NoProducts) {
            StringBuilder sb = new StringBuilder();
            sb.append("We could not fetch any products: ");
            NoProducts noProducts = (NoProducts) this;
            String localizedMessage = noProducts.getError().getLocalizedMessage();
            if (localizedMessage == null && (localizedMessage = noProducts.getError().getMessage()) == null) {
                localizedMessage = "Unknown error";
            }
            sb.append(localizedMessage);
            return sb.toString();
        }
        if (this instanceof MissingLocalization) {
            return "Your paywall is missing a localization. Add a localization in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTiers) {
            return "Your paywall is missing any tiers. Add some tiers in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTier) {
            return "The tier with ID: " + ((MissingTier) this).getTierId() + " is missing a localization. Add a localization in the RevenueCat Dashboard to begin.";
        }
        if (this instanceof MissingTierName) {
            return "The tier: " + ((MissingTierName) this).getTierId() + " is missing a name. Add a name in the RevenueCat Dashboard to continue.";
        }
        if (this instanceof InvalidTemplate) {
            return "The template with ID: `" + ((InvalidTemplate) this).getTemplateName() + "` does not exist for this version of the SDK. Please make sure to update your SDK to the latest version and try again.";
        }
        if (this instanceof InvalidVariables) {
            return "The following variables are not recognized: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(((InvalidVariables) this).getVariables()), ", ", null, null, 0, null, null, 62, null) + ". Please check the docs for a list of valid variables.";
        }
        if (this instanceof InvalidIcons) {
            return "The following icon names are not valid: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(((InvalidIcons) this).getIcons()), ", ", null, null, 0, null, null, 62, null) + ". Please check `PaywallIcon` for the list of valid icon names.";
        }
        if (!(this instanceof Other)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Paywall validation failed with message: " + ((Other) this).getMessage();
    }

    public final String getHelpUrl() {
        if (this instanceof NoPaywall ? true : this instanceof MissingTierName ? true : this instanceof MissingTier ? true : this instanceof MissingTiers) {
            return "https://www.revenuecat.com/docs/tools/paywalls";
        }
        if (this instanceof NoOffering) {
            return "https://www.revenuecat.com/docs/offerings/overview";
        }
        if (this instanceof NoProducts) {
            return "https://www.revenuecat.com/docs/offerings/products-overview";
        }
        if (this instanceof InvalidVariables) {
            return "https://www.revenuecat.com/docs/tools/paywalls/creating-paywalls/variables";
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "error", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaywallWarning from(PaywallValidationError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error instanceof PaywallValidationError.MissingPaywall) {
                return new NoPaywall("unknown");
            }
            if (error instanceof PaywallValidationError.InvalidTemplate) {
                return new InvalidTemplate(((PaywallValidationError.InvalidTemplate) error).getTemplateName());
            }
            if (error instanceof PaywallValidationError.InvalidVariables) {
                return new InvalidVariables(((PaywallValidationError.InvalidVariables) error).getUnrecognizedVariables());
            }
            if (error instanceof PaywallValidationError.InvalidIcons) {
                return new InvalidIcons(((PaywallValidationError.InvalidIcons) error).getInvalidIcons());
            }
            if (error instanceof PaywallValidationError.MissingTiers) {
                return MissingTiers.INSTANCE;
            }
            if (error instanceof PaywallValidationError.MissingTierConfigurations) {
                String str = (String) CollectionsKt.firstOrNull(((PaywallValidationError.MissingTierConfigurations) error).getTierIds());
                return new MissingTier(str != null ? str : "unknown");
            }
            if (error instanceof PaywallValidationError.MissingStringLocalization ? true : error instanceof PaywallValidationError.MissingVideoLocalization ? true : error instanceof PaywallValidationError.AllVariableLocalizationsMissing ? true : error instanceof PaywallValidationError.AllLocalizationsMissing ? true : error instanceof PaywallValidationError.MissingImageLocalization) {
                return MissingLocalization.INSTANCE;
            }
            String message = error.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return new Other(message);
        }
    }
}
