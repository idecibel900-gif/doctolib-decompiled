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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u0011\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\"\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001cR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u0012\u0004\b!\u0010\"\u001a\u0004\b \u0010\u0019R*\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0004\b#\u0010\u0017\u0012\u0004\b&\u0010\"\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001cR0\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b.\u0010\"\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lio/didomi/sdk/models/DataCategory;", "Lio/didomi/sdk/m1;", "", "component1", "component2", "component3", DiagnosticsEntry.ID_KEY, "name", b.c, "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "iabId", "getIabId", "getIabId$annotations", "()V", "descriptionLegal", "getDescriptionLegal", "setDescriptionLegal", "getDescriptionLegal$annotations", "", "illustrations", "Ljava/util/List;", "getIllustrations", "()Ljava/util/List;", "setIllustrations", "(Ljava/util/List;)V", "getIllustrations$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DataCategory implements m1 {
    public static final Parcelable.Creator<DataCategory> CREATOR = new a();

    @SerializedName(b.c)
    private String description;
    private String descriptionLegal;
    private final String iabId;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;
    private List<String> illustrations;

    @SerializedName("name")
    private String name;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<DataCategory> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DataCategory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataCategory(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DataCategory[] newArray(int i) {
            return new DataCategory[i];
        }
    }

    public DataCategory(String id, String name, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static /* synthetic */ DataCategory copy$default(DataCategory dataCategory, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dataCategory.id;
        }
        if ((i & 2) != 0) {
            str2 = dataCategory.name;
        }
        if ((i & 4) != 0) {
            str3 = dataCategory.description;
        }
        return dataCategory.copy(str, str2, str3);
    }

    public static /* synthetic */ void getDescriptionLegal$annotations() {
    }

    public static /* synthetic */ void getIabId$annotations() {
    }

    public static /* synthetic */ void getIllustrations$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final DataCategory copy(String id, String name, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new DataCategory(id, name, description);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCategory)) {
            return false;
        }
        DataCategory dataCategory = (DataCategory) other;
        return Intrinsics.areEqual(this.id, dataCategory.id) && Intrinsics.areEqual(this.name, dataCategory.name) && Intrinsics.areEqual(this.description, dataCategory.description);
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
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode();
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
        return "DataCategory(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
    }

    public /* synthetic */ DataCategory(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
