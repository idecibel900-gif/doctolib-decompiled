package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.e7, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\fR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006\""}, d2 = {"Lio/didomi/sdk/e7;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", DiagnosticsEntry.ID_KEY, "b", "c", "iabId", "f", "name", b.c, "e", "descriptionLegal", "", "Ljava/util/List;", "()Ljava/util/List;", "setIllustrations", "(Ljava/util/List;)V", "illustrations", "g", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isSpecialFeature", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class InternalPurpose {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("iabId")
    private final String iabId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("name")
    private final String name;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName(b.c)
    private final String description;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("descriptionLegal")
    private final String descriptionLegal;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @SerializedName("illustrations")
    private List<String> illustrations;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private final transient Boolean isSpecialFeature;

    public InternalPurpose() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDescriptionLegal() {
        return this.descriptionLegal;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getIabId() {
        return this.iabId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> e() {
        return this.illustrations;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternalPurpose)) {
            return false;
        }
        InternalPurpose internalPurpose = (InternalPurpose) other;
        return Intrinsics.areEqual(this.id, internalPurpose.id) && Intrinsics.areEqual(this.iabId, internalPurpose.iabId) && Intrinsics.areEqual(this.name, internalPurpose.name) && Intrinsics.areEqual(this.description, internalPurpose.description) && Intrinsics.areEqual(this.descriptionLegal, internalPurpose.descriptionLegal) && Intrinsics.areEqual(this.illustrations, internalPurpose.illustrations) && Intrinsics.areEqual(this.isSpecialFeature, internalPurpose.isSpecialFeature);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Boolean getIsSpecialFeature() {
        return this.isSpecialFeature;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iabId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.descriptionLegal;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.illustrations;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isSpecialFeature;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "InternalPurpose(id=" + this.id + ", iabId=" + this.iabId + ", name=" + this.name + ", description=" + this.description + ", descriptionLegal=" + this.descriptionLegal + ", illustrations=" + this.illustrations + ", isSpecialFeature=" + this.isSpecialFeature + ')';
    }

    public InternalPurpose(String str, String str2, String str3, String str4, String str5, List<String> list, Boolean bool) {
        this.id = str;
        this.iabId = str2;
        this.name = str3;
        this.description = str4;
        this.descriptionLegal = str5;
        this.illustrations = list;
        this.isSpecialFeature = bool;
    }

    public /* synthetic */ InternalPurpose(String str, String str2, String str3, String str4, String str5, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : bool);
    }
}
