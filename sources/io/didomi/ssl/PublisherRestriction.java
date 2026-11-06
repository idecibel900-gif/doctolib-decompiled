package io.didomi.ssl;

import com.iabtcf.v2.RestrictionType;
import com.opentok.android.PublisherKit;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.c9, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a¢\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u000b\u0010\u001fR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001b\u0010\u001e\"\u0004\b\t\u0010\u001f¨\u0006$"}, d2 = {"Lio/didomi/sdk/c9;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "purposeId", "I", "()I", "purposeIabId", "c", "Z", "d", "()Z", "specialFeature", "Lcom/iabtcf/v2/RestrictionType;", "Lcom/iabtcf/v2/RestrictionType;", "()Lcom/iabtcf/v2/RestrictionType;", "restrictionType", "", "e", "Ljava/util/Set;", "f", "()Ljava/util/Set;", "(Ljava/util/Set;)V", "vendorIds", "tcStringVendorIds", "<init>", "(Ljava/lang/String;IZLcom/iabtcf/v2/RestrictionType;Ljava/util/Set;Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PublisherRestriction {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String purposeId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final int purposeIabId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean specialFeature;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final RestrictionType restrictionType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private Set<String> vendorIds;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private Set<Integer> tcStringVendorIds;

    public PublisherRestriction(String purposeId, int i, boolean z, RestrictionType restrictionType, Set<String> set, Set<Integer> set2) {
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        Intrinsics.checkNotNullParameter(restrictionType, "restrictionType");
        this.purposeId = purposeId;
        this.purposeIabId = i;
        this.specialFeature = z;
        this.restrictionType = restrictionType;
        this.vendorIds = set;
        this.tcStringVendorIds = set2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getPurposeIabId() {
        return this.purposeIabId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPurposeId() {
        return this.purposeId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final RestrictionType getRestrictionType() {
        return this.restrictionType;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getSpecialFeature() {
        return this.specialFeature;
    }

    public final Set<Integer> e() {
        return this.tcStringVendorIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublisherRestriction)) {
            return false;
        }
        PublisherRestriction publisherRestriction = (PublisherRestriction) other;
        return Intrinsics.areEqual(this.purposeId, publisherRestriction.purposeId) && this.purposeIabId == publisherRestriction.purposeIabId && this.specialFeature == publisherRestriction.specialFeature && this.restrictionType == publisherRestriction.restrictionType && Intrinsics.areEqual(this.vendorIds, publisherRestriction.vendorIds) && Intrinsics.areEqual(this.tcStringVendorIds, publisherRestriction.tcStringVendorIds);
    }

    public final Set<String> f() {
        return this.vendorIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    public int hashCode() {
        int iHashCode = ((this.purposeId.hashCode() * 31) + Integer.hashCode(this.purposeIabId)) * 31;
        boolean z = this.specialFeature;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.restrictionType.hashCode()) * 31;
        Set<String> set = this.vendorIds;
        int iHashCode3 = (iHashCode2 + (set == null ? 0 : set.hashCode())) * 31;
        Set<Integer> set2 = this.tcStringVendorIds;
        return iHashCode3 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        return "PublisherRestriction(purposeId=" + this.purposeId + ", purposeIabId=" + this.purposeIabId + ", specialFeature=" + this.specialFeature + ", restrictionType=" + this.restrictionType + ", vendorIds=" + this.vendorIds + ", tcStringVendorIds=" + this.tcStringVendorIds + ')';
    }

    public final void a(Set<Integer> set) {
        this.tcStringVendorIds = set;
    }

    public final void b(Set<String> set) {
        this.vendorIds = set;
    }

    public /* synthetic */ PublisherRestriction(String str, int i, boolean z, RestrictionType restrictionType, Set set, Set set2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, z, restrictionType, (i2 & 16) != 0 ? null : set, (i2 & 32) != 0 ? null : set2);
    }
}
