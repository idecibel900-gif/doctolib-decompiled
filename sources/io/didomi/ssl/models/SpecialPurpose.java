package io.didomi.ssl.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.amazon.a.a.o.b;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.m1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003JQ\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b!\u0010 R\"\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\"\u0010 \"\u0004\b#\u0010$R\"\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010$R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010$R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lio/didomi/sdk/models/SpecialPurpose;", "Lio/didomi/sdk/m1;", "", "component1", "component2", "component3", "component4", "component5", "", "component6", DiagnosticsEntry.ID_KEY, "iabId", "name", b.c, "descriptionLegal", "illustrations", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getIabId", "getName", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getDescriptionLegal", "setDescriptionLegal", "Ljava/util/List;", "getIllustrations", "()Ljava/util/List;", "setIllustrations", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SpecialPurpose implements m1 {
    public static final Parcelable.Creator<SpecialPurpose> CREATOR = new a();

    @SerializedName(b.c)
    private String description;

    @SerializedName("descriptionLegal")
    private String descriptionLegal;

    @SerializedName("iabId")
    private final String iabId;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    @SerializedName("illustrations")
    private List<String> illustrations;

    @SerializedName("name")
    private String name;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<SpecialPurpose> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SpecialPurpose createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SpecialPurpose(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SpecialPurpose[] newArray(int i) {
            return new SpecialPurpose[i];
        }
    }

    public SpecialPurpose(String id, String str, String name, String description, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.iabId = str;
        this.name = name;
        this.description = description;
        this.descriptionLegal = str2;
        this.illustrations = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpecialPurpose copy$default(SpecialPurpose specialPurpose, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = specialPurpose.id;
        }
        if ((i & 2) != 0) {
            str2 = specialPurpose.iabId;
        }
        if ((i & 4) != 0) {
            str3 = specialPurpose.name;
        }
        if ((i & 8) != 0) {
            str4 = specialPurpose.description;
        }
        if ((i & 16) != 0) {
            str5 = specialPurpose.descriptionLegal;
        }
        if ((i & 32) != 0) {
            list = specialPurpose.illustrations;
        }
        String str6 = str5;
        List list2 = list;
        return specialPurpose.copy(str, str2, str3, str4, str6, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIabId() {
        return this.iabId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescriptionLegal() {
        return this.descriptionLegal;
    }

    public final List<String> component6() {
        return this.illustrations;
    }

    public final SpecialPurpose copy(String id, String iabId, String name, String description, String descriptionLegal, List<String> illustrations) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new SpecialPurpose(id, iabId, name, description, descriptionLegal, illustrations);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpecialPurpose)) {
            return false;
        }
        SpecialPurpose specialPurpose = (SpecialPurpose) other;
        return Intrinsics.areEqual(this.id, specialPurpose.id) && Intrinsics.areEqual(this.iabId, specialPurpose.iabId) && Intrinsics.areEqual(this.name, specialPurpose.name) && Intrinsics.areEqual(this.description, specialPurpose.description) && Intrinsics.areEqual(this.descriptionLegal, specialPurpose.descriptionLegal) && Intrinsics.areEqual(this.illustrations, specialPurpose.illustrations);
    }

    @Override // io.didomi.ssl.m1
    public String getDescription() {
        return this.description;
    }

    @Override // io.didomi.ssl.m1
    public String getDescriptionLegal() {
        return this.descriptionLegal;
    }

    @Override // io.didomi.ssl.m1
    public String getIabId() {
        return this.iabId;
    }

    @Override // io.didomi.ssl.m1
    public String getId() {
        return this.id;
    }

    @Override // io.didomi.ssl.m1
    public List<String> getIllustrations() {
        return this.illustrations;
    }

    @Override // io.didomi.ssl.m1
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.iabId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str2 = this.descriptionLegal;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.illustrations;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @Override // io.didomi.ssl.m1
    public void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    @Override // io.didomi.ssl.m1
    public void setDescriptionLegal(String str) {
        this.descriptionLegal = str;
    }

    @Override // io.didomi.ssl.m1
    public void setIllustrations(List<String> list) {
        this.illustrations = list;
    }

    @Override // io.didomi.ssl.m1
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "SpecialPurpose(id=" + this.id + ", iabId=" + this.iabId + ", name=" + this.name + ", description=" + this.description + ", descriptionLegal=" + this.descriptionLegal + ", illustrations=" + this.illustrations + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.iabId);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.descriptionLegal);
        parcel.writeStringList(this.illustrations);
    }

    public /* synthetic */ SpecialPurpose(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }
}
