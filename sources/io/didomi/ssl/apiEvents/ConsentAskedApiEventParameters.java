package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.i;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003JS\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lio/didomi/sdk/apiEvents/ConsentAskedApiEventParameters;", "Lio/didomi/sdk/i;", "", "", "component1", "component2", "component3", "component4", "component5", "purposeIds", "legIntPurposeIds", "vendorIds", "vendorLegIntIds", "position", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/util/Set;", "getPurposeIds", "()Ljava/util/Set;", "getLegIntPurposeIds", "getVendorIds", "getVendorLegIntIds", "Ljava/lang/String;", "getPosition", "()Ljava/lang/String;", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ConsentAskedApiEventParameters implements i {

    @SerializedName("purposes_li")
    private final Set<String> legIntPurposeIds;

    @SerializedName("position")
    private final String position;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final Set<String> purposeIds;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final Set<String> vendorIds;

    @SerializedName("vendors_li")
    private final Set<String> vendorLegIntIds;

    public ConsentAskedApiEventParameters() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentAskedApiEventParameters copy$default(ConsentAskedApiEventParameters consentAskedApiEventParameters, Set set, Set set2, Set set3, Set set4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            set = consentAskedApiEventParameters.purposeIds;
        }
        if ((i & 2) != 0) {
            set2 = consentAskedApiEventParameters.legIntPurposeIds;
        }
        if ((i & 4) != 0) {
            set3 = consentAskedApiEventParameters.vendorIds;
        }
        if ((i & 8) != 0) {
            set4 = consentAskedApiEventParameters.vendorLegIntIds;
        }
        if ((i & 16) != 0) {
            str = consentAskedApiEventParameters.position;
        }
        String str2 = str;
        Set set5 = set3;
        return consentAskedApiEventParameters.copy(set, set2, set5, set4, str2);
    }

    public final Set<String> component1() {
        return this.purposeIds;
    }

    public final Set<String> component2() {
        return this.legIntPurposeIds;
    }

    public final Set<String> component3() {
        return this.vendorIds;
    }

    public final Set<String> component4() {
        return this.vendorLegIntIds;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPosition() {
        return this.position;
    }

    public final ConsentAskedApiEventParameters copy(Set<String> purposeIds, Set<String> legIntPurposeIds, Set<String> vendorIds, Set<String> vendorLegIntIds, String position) {
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(vendorIds, "vendorIds");
        Intrinsics.checkNotNullParameter(vendorLegIntIds, "vendorLegIntIds");
        Intrinsics.checkNotNullParameter(position, "position");
        return new ConsentAskedApiEventParameters(purposeIds, legIntPurposeIds, vendorIds, vendorLegIntIds, position);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentAskedApiEventParameters)) {
            return false;
        }
        ConsentAskedApiEventParameters consentAskedApiEventParameters = (ConsentAskedApiEventParameters) other;
        return Intrinsics.areEqual(this.purposeIds, consentAskedApiEventParameters.purposeIds) && Intrinsics.areEqual(this.legIntPurposeIds, consentAskedApiEventParameters.legIntPurposeIds) && Intrinsics.areEqual(this.vendorIds, consentAskedApiEventParameters.vendorIds) && Intrinsics.areEqual(this.vendorLegIntIds, consentAskedApiEventParameters.vendorLegIntIds) && Intrinsics.areEqual(this.position, consentAskedApiEventParameters.position);
    }

    public final Set<String> getLegIntPurposeIds() {
        return this.legIntPurposeIds;
    }

    public final String getPosition() {
        return this.position;
    }

    public final Set<String> getPurposeIds() {
        return this.purposeIds;
    }

    public final Set<String> getVendorIds() {
        return this.vendorIds;
    }

    public final Set<String> getVendorLegIntIds() {
        return this.vendorLegIntIds;
    }

    public int hashCode() {
        return (((((((this.purposeIds.hashCode() * 31) + this.legIntPurposeIds.hashCode()) * 31) + this.vendorIds.hashCode()) * 31) + this.vendorLegIntIds.hashCode()) * 31) + this.position.hashCode();
    }

    public String toString() {
        return "ConsentAskedApiEventParameters(purposeIds=" + this.purposeIds + ", legIntPurposeIds=" + this.legIntPurposeIds + ", vendorIds=" + this.vendorIds + ", vendorLegIntIds=" + this.vendorLegIntIds + ", position=" + this.position + ')';
    }

    public ConsentAskedApiEventParameters(Set<String> purposeIds, Set<String> legIntPurposeIds, Set<String> vendorIds, Set<String> vendorLegIntIds, String position) {
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(vendorIds, "vendorIds");
        Intrinsics.checkNotNullParameter(vendorLegIntIds, "vendorLegIntIds");
        Intrinsics.checkNotNullParameter(position, "position");
        this.purposeIds = purposeIds;
        this.legIntPurposeIds = legIntPurposeIds;
        this.vendorIds = vendorIds;
        this.vendorLegIntIds = vendorLegIntIds;
        this.position = position;
    }

    public /* synthetic */ ConsentAskedApiEventParameters(Set set, Set set2, Set set3, Set set4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2, (i & 4) != 0 ? SetsKt.emptySet() : set3, (i & 8) != 0 ? SetsKt.emptySet() : set4, (i & 16) != 0 ? "" : str);
    }
}
