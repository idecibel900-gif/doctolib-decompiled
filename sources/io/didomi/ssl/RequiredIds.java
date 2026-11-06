package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.hb, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/hb;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "consentPurposes", "b", "c", "legIntPurposes", "consentVendors", "d", "legIntVendors", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class RequiredIds {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final Set<String> consentPurposes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Set<String> legIntPurposes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final Set<String> consentVendors;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final Set<String> legIntVendors;

    public RequiredIds() {
        this(null, null, null, null, 15, null);
    }

    public final Set<String> a() {
        return this.consentPurposes;
    }

    public final Set<String> b() {
        return this.consentVendors;
    }

    public final Set<String> c() {
        return this.legIntPurposes;
    }

    public final Set<String> d() {
        return this.legIntVendors;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequiredIds)) {
            return false;
        }
        RequiredIds requiredIds = (RequiredIds) other;
        return Intrinsics.areEqual(this.consentPurposes, requiredIds.consentPurposes) && Intrinsics.areEqual(this.legIntPurposes, requiredIds.legIntPurposes) && Intrinsics.areEqual(this.consentVendors, requiredIds.consentVendors) && Intrinsics.areEqual(this.legIntVendors, requiredIds.legIntVendors);
    }

    public int hashCode() {
        return (((((this.consentPurposes.hashCode() * 31) + this.legIntPurposes.hashCode()) * 31) + this.consentVendors.hashCode()) * 31) + this.legIntVendors.hashCode();
    }

    public String toString() {
        return "RequiredIds(consentPurposes=" + this.consentPurposes + ", legIntPurposes=" + this.legIntPurposes + ", consentVendors=" + this.consentVendors + ", legIntVendors=" + this.legIntVendors + ')';
    }

    public RequiredIds(Set<String> consentPurposes, Set<String> legIntPurposes, Set<String> consentVendors, Set<String> legIntVendors) {
        Intrinsics.checkNotNullParameter(consentPurposes, "consentPurposes");
        Intrinsics.checkNotNullParameter(legIntPurposes, "legIntPurposes");
        Intrinsics.checkNotNullParameter(consentVendors, "consentVendors");
        Intrinsics.checkNotNullParameter(legIntVendors, "legIntVendors");
        this.consentPurposes = consentPurposes;
        this.legIntPurposes = legIntPurposes;
        this.consentVendors = consentVendors;
        this.legIntVendors = legIntVendors;
    }

    public /* synthetic */ RequiredIds(Set set, Set set2, Set set3, Set set4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2, (i & 4) != 0 ? SetsKt.emptySet() : set3, (i & 8) != 0 ? SetsKt.emptySet() : set4);
    }
}
