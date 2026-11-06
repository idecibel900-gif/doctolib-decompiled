package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.i;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001:\u0001-Bc\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Je\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010 R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\"\u0010 R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010 R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010 R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b%\u0010 R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b&\u0010 R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b'\u0010 R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters;", "Lio/didomi/sdk/i;", "Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", Didomi.VIEW_PURPOSES, "legitimatePurposes", "previousPurposes", "previousLegitimatePurposes", Didomi.VIEW_VENDORS, "vendorsLegInt", "previousVendors", "previousVendorsLegInt", "action", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;", "getPurposes", "()Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;", "getLegitimatePurposes", "getPreviousPurposes", "getPreviousLegitimatePurposes", "getVendors", "getVendorsLegInt", "getPreviousVendors", "getPreviousVendorsLegInt", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "<init>", "(Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;Ljava/lang/String;)V", "ConsentStatus", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ConsentGivenApiEventParameters implements i {

    @SerializedName("action")
    private final String action;

    @SerializedName("purposes_li")
    private final ConsentStatus legitimatePurposes;

    @SerializedName("previous_purposes_li")
    private final ConsentStatus previousLegitimatePurposes;

    @SerializedName("previous_purposes")
    private final ConsentStatus previousPurposes;

    @SerializedName("previous_vendors")
    private final ConsentStatus previousVendors;

    @SerializedName("previous_vendors_li")
    private final ConsentStatus previousVendorsLegInt;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final ConsentStatus purposes;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final ConsentStatus vendors;

    @SerializedName("vendors_li")
    private final ConsentStatus vendorsLegInt;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/apiEvents/ConsentGivenApiEventParameters$ConsentStatus;", "", "disabled", "", "", "enabled", "(Ljava/util/Collection;Ljava/util/Collection;)V", "getDisabled", "()Ljava/util/Collection;", "getEnabled", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ConsentStatus {

        @SerializedName("disabled")
        private final Collection<String> disabled;

        @SerializedName("enabled")
        private final Collection<String> enabled;

        /* JADX WARN: Multi-variable type inference failed */
        public ConsentStatus() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConsentStatus copy$default(ConsentStatus consentStatus, Collection collection, Collection collection2, int i, Object obj) {
            if ((i & 1) != 0) {
                collection = consentStatus.disabled;
            }
            if ((i & 2) != 0) {
                collection2 = consentStatus.enabled;
            }
            return consentStatus.copy(collection, collection2);
        }

        public final Collection<String> component1() {
            return this.disabled;
        }

        public final Collection<String> component2() {
            return this.enabled;
        }

        public final ConsentStatus copy(Collection<String> disabled, Collection<String> enabled) {
            Intrinsics.checkNotNullParameter(disabled, "disabled");
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            return new ConsentStatus(disabled, enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConsentStatus)) {
                return false;
            }
            ConsentStatus consentStatus = (ConsentStatus) other;
            return Intrinsics.areEqual(this.disabled, consentStatus.disabled) && Intrinsics.areEqual(this.enabled, consentStatus.enabled);
        }

        public final Collection<String> getDisabled() {
            return this.disabled;
        }

        public final Collection<String> getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            return (this.disabled.hashCode() * 31) + this.enabled.hashCode();
        }

        public String toString() {
            return "ConsentStatus(disabled=" + this.disabled + ", enabled=" + this.enabled + ')';
        }

        public ConsentStatus(Collection<String> disabled, Collection<String> enabled) {
            Intrinsics.checkNotNullParameter(disabled, "disabled");
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            this.disabled = disabled;
            this.enabled = enabled;
        }

        public /* synthetic */ ConsentStatus(Collection collection, Collection collection2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : collection, (i & 2) != 0 ? CollectionsKt.emptyList() : collection2);
        }
    }

    public ConsentGivenApiEventParameters() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ConsentGivenApiEventParameters copy$default(ConsentGivenApiEventParameters consentGivenApiEventParameters, ConsentStatus consentStatus, ConsentStatus consentStatus2, ConsentStatus consentStatus3, ConsentStatus consentStatus4, ConsentStatus consentStatus5, ConsentStatus consentStatus6, ConsentStatus consentStatus7, ConsentStatus consentStatus8, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            consentStatus = consentGivenApiEventParameters.purposes;
        }
        if ((i & 2) != 0) {
            consentStatus2 = consentGivenApiEventParameters.legitimatePurposes;
        }
        if ((i & 4) != 0) {
            consentStatus3 = consentGivenApiEventParameters.previousPurposes;
        }
        if ((i & 8) != 0) {
            consentStatus4 = consentGivenApiEventParameters.previousLegitimatePurposes;
        }
        if ((i & 16) != 0) {
            consentStatus5 = consentGivenApiEventParameters.vendors;
        }
        if ((i & 32) != 0) {
            consentStatus6 = consentGivenApiEventParameters.vendorsLegInt;
        }
        if ((i & 64) != 0) {
            consentStatus7 = consentGivenApiEventParameters.previousVendors;
        }
        if ((i & 128) != 0) {
            consentStatus8 = consentGivenApiEventParameters.previousVendorsLegInt;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            str = consentGivenApiEventParameters.action;
        }
        ConsentStatus consentStatus9 = consentStatus8;
        String str2 = str;
        ConsentStatus consentStatus10 = consentStatus6;
        ConsentStatus consentStatus11 = consentStatus7;
        ConsentStatus consentStatus12 = consentStatus5;
        ConsentStatus consentStatus13 = consentStatus3;
        return consentGivenApiEventParameters.copy(consentStatus, consentStatus2, consentStatus13, consentStatus4, consentStatus12, consentStatus10, consentStatus11, consentStatus9, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConsentStatus getPurposes() {
        return this.purposes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ConsentStatus getLegitimatePurposes() {
        return this.legitimatePurposes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConsentStatus getPreviousPurposes() {
        return this.previousPurposes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConsentStatus getPreviousLegitimatePurposes() {
        return this.previousLegitimatePurposes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ConsentStatus getVendors() {
        return this.vendors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConsentStatus getVendorsLegInt() {
        return this.vendorsLegInt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ConsentStatus getPreviousVendors() {
        return this.previousVendors;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ConsentStatus getPreviousVendorsLegInt() {
        return this.previousVendorsLegInt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final ConsentGivenApiEventParameters copy(ConsentStatus purposes, ConsentStatus legitimatePurposes, ConsentStatus previousPurposes, ConsentStatus previousLegitimatePurposes, ConsentStatus vendors, ConsentStatus vendorsLegInt, ConsentStatus previousVendors, ConsentStatus previousVendorsLegInt, String action) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(legitimatePurposes, "legitimatePurposes");
        Intrinsics.checkNotNullParameter(previousPurposes, "previousPurposes");
        Intrinsics.checkNotNullParameter(previousLegitimatePurposes, "previousLegitimatePurposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(vendorsLegInt, "vendorsLegInt");
        Intrinsics.checkNotNullParameter(previousVendors, "previousVendors");
        Intrinsics.checkNotNullParameter(previousVendorsLegInt, "previousVendorsLegInt");
        return new ConsentGivenApiEventParameters(purposes, legitimatePurposes, previousPurposes, previousLegitimatePurposes, vendors, vendorsLegInt, previousVendors, previousVendorsLegInt, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentGivenApiEventParameters)) {
            return false;
        }
        ConsentGivenApiEventParameters consentGivenApiEventParameters = (ConsentGivenApiEventParameters) other;
        return Intrinsics.areEqual(this.purposes, consentGivenApiEventParameters.purposes) && Intrinsics.areEqual(this.legitimatePurposes, consentGivenApiEventParameters.legitimatePurposes) && Intrinsics.areEqual(this.previousPurposes, consentGivenApiEventParameters.previousPurposes) && Intrinsics.areEqual(this.previousLegitimatePurposes, consentGivenApiEventParameters.previousLegitimatePurposes) && Intrinsics.areEqual(this.vendors, consentGivenApiEventParameters.vendors) && Intrinsics.areEqual(this.vendorsLegInt, consentGivenApiEventParameters.vendorsLegInt) && Intrinsics.areEqual(this.previousVendors, consentGivenApiEventParameters.previousVendors) && Intrinsics.areEqual(this.previousVendorsLegInt, consentGivenApiEventParameters.previousVendorsLegInt) && Intrinsics.areEqual(this.action, consentGivenApiEventParameters.action);
    }

    public final String getAction() {
        return this.action;
    }

    public final ConsentStatus getLegitimatePurposes() {
        return this.legitimatePurposes;
    }

    public final ConsentStatus getPreviousLegitimatePurposes() {
        return this.previousLegitimatePurposes;
    }

    public final ConsentStatus getPreviousPurposes() {
        return this.previousPurposes;
    }

    public final ConsentStatus getPreviousVendors() {
        return this.previousVendors;
    }

    public final ConsentStatus getPreviousVendorsLegInt() {
        return this.previousVendorsLegInt;
    }

    public final ConsentStatus getPurposes() {
        return this.purposes;
    }

    public final ConsentStatus getVendors() {
        return this.vendors;
    }

    public final ConsentStatus getVendorsLegInt() {
        return this.vendorsLegInt;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.purposes.hashCode() * 31) + this.legitimatePurposes.hashCode()) * 31) + this.previousPurposes.hashCode()) * 31) + this.previousLegitimatePurposes.hashCode()) * 31) + this.vendors.hashCode()) * 31) + this.vendorsLegInt.hashCode()) * 31) + this.previousVendors.hashCode()) * 31) + this.previousVendorsLegInt.hashCode()) * 31;
        String str = this.action;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsentGivenApiEventParameters(purposes=" + this.purposes + ", legitimatePurposes=" + this.legitimatePurposes + ", previousPurposes=" + this.previousPurposes + ", previousLegitimatePurposes=" + this.previousLegitimatePurposes + ", vendors=" + this.vendors + ", vendorsLegInt=" + this.vendorsLegInt + ", previousVendors=" + this.previousVendors + ", previousVendorsLegInt=" + this.previousVendorsLegInt + ", action=" + this.action + ')';
    }

    public ConsentGivenApiEventParameters(ConsentStatus purposes, ConsentStatus legitimatePurposes, ConsentStatus previousPurposes, ConsentStatus previousLegitimatePurposes, ConsentStatus vendors, ConsentStatus vendorsLegInt, ConsentStatus previousVendors, ConsentStatus previousVendorsLegInt, String str) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(legitimatePurposes, "legitimatePurposes");
        Intrinsics.checkNotNullParameter(previousPurposes, "previousPurposes");
        Intrinsics.checkNotNullParameter(previousLegitimatePurposes, "previousLegitimatePurposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(vendorsLegInt, "vendorsLegInt");
        Intrinsics.checkNotNullParameter(previousVendors, "previousVendors");
        Intrinsics.checkNotNullParameter(previousVendorsLegInt, "previousVendorsLegInt");
        this.purposes = purposes;
        this.legitimatePurposes = legitimatePurposes;
        this.previousPurposes = previousPurposes;
        this.previousLegitimatePurposes = previousLegitimatePurposes;
        this.vendors = vendors;
        this.vendorsLegInt = vendorsLegInt;
        this.previousVendors = previousVendors;
        this.previousVendorsLegInt = previousVendorsLegInt;
        this.action = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ConsentGivenApiEventParameters(ConsentStatus consentStatus, ConsentStatus consentStatus2, ConsentStatus consentStatus3, ConsentStatus consentStatus4, ConsentStatus consentStatus5, ConsentStatus consentStatus6, ConsentStatus consentStatus7, ConsentStatus consentStatus8, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = 3;
        this((i & 1) != 0 ? new ConsentStatus(null, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus, (i & 2) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus2, (i & 4) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus3, (i & 8) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus4, (i & 16) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus5, (i & 32) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus6, (i & 64) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus7, (i & 128) != 0 ? new ConsentStatus(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : consentStatus8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str);
    }
}
