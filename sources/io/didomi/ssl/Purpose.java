package io.didomi.ssl;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DataProcessingNamespaces;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u008f\u0001\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bT\u0010UJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\u0007HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0091\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020&HÖ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\u0019\u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020&HÖ\u0001R\u001a\u0010\u0018\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b3\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u00101\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u00106R\"\u0010\u001b\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u00101\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u00106R$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u00106R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010@\u001a\u0004\b\u001e\u0010A\"\u0004\bB\u0010CR\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010@\u001a\u0004\b\u001f\u0010A\"\u0004\bD\u0010CR\"\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010@\u001a\u0004\b \u0010A\"\u0004\bE\u0010CR\"\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010@\u001a\u0004\b!\u0010A\"\u0004\bF\u0010CR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\bG\u0010\u0014R\u001c\u0010#\u001a\u0004\u0018\u00010\u00168\u0016X\u0097\u0004¢\u0006\f\n\u0004\b#\u0010H\u001a\u0004\bI\u0010JR*\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\bL\u0010M\u0012\u0004\bR\u0010S\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006X"}, d2 = {"Lio/didomi/sdk/Purpose;", "Lio/didomi/sdk/m1;", "Lio/didomi/sdk/z7;", "", "isConsentNotEssential", "isLegitimateInterestNotEssential", "isLegitimateInterestOnly", "", "component1", "component2", "component3", "component4", "component5", "", "component6", "component7", "component8", "component9", "component10", "component11$android_release", "()Ljava/lang/String;", "component11", "Lio/didomi/sdk/models/DataProcessingNamespaces;", "component12", DiagnosticsEntry.ID_KEY, "iabId", "name", com.amazon.a.a.o.b.c, "descriptionLegal", "illustrations", "isConsent", "isEssential", "isLegitimateInterest", "isSpecialFeature", "type", "namespaces", "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "getIabId", "getName", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getDescriptionLegal", "setDescriptionLegal", "Ljava/util/List;", "getIllustrations", "()Ljava/util/List;", "setIllustrations", "(Ljava/util/List;)V", "Z", "()Z", "setConsent", "(Z)V", "setEssential", "setLegitimateInterest", "setSpecialFeature", "getType$android_release", "Lio/didomi/sdk/models/DataProcessingNamespaces;", "getNamespaces", "()Lio/didomi/sdk/models/DataProcessingNamespaces;", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "getCategory", "()Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "setCategory", "(Lio/didomi/sdk/purpose/common/model/PurposeCategory;)V", "getCategory$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZLjava/lang/String;Lio/didomi/sdk/models/DataProcessingNamespaces;)V", "Companion", "a", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class Purpose implements m1, z7 {
    public static final String personalDataType = "personalDataType";
    private transient PurposeCategory category;

    @SerializedName(com.amazon.a.a.o.b.c)
    private String description;

    @SerializedName("descriptionLegal")
    private String descriptionLegal;

    @SerializedName("iabId")
    private final String iabId;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    @SerializedName("illustrations")
    private List<String> illustrations;
    private transient boolean isConsent;
    private transient boolean isEssential;
    private transient boolean isLegitimateInterest;
    private transient boolean isSpecialFeature;

    @SerializedName("name")
    private String name;

    @SerializedName("namespaces")
    private final DataProcessingNamespaces namespaces;
    private final transient String type;
    public static final Parcelable.Creator<Purpose> CREATOR = new b();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<Purpose> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Purpose createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            boolean z = false;
            boolean z2 = true;
            if (parcel.readInt() != 0) {
                z = true;
            }
            if (parcel.readInt() == 0) {
                z2 = z;
            }
            if (parcel.readInt() == 0) {
                z2 = z;
            }
            return new Purpose(string, string2, string3, string4, string5, arrayListCreateStringArrayList, z, z2, z2, parcel.readInt() != 0, parcel.readString(), parcel.readInt() == 0 ? null : DataProcessingNamespaces.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Purpose[] newArray(int i) {
            return new Purpose[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id) {
        this(id, null, null, null, null, null, false, false, false, false, null, null, 4094, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Purpose copy$default(Purpose purpose, String str, String str2, String str3, String str4, String str5, List list, boolean z, boolean z2, boolean z3, boolean z4, String str6, DataProcessingNamespaces dataProcessingNamespaces, int i, Object obj) {
        if ((i & 1) != 0) {
            str = purpose.id;
        }
        if ((i & 2) != 0) {
            str2 = purpose.iabId;
        }
        if ((i & 4) != 0) {
            str3 = purpose.name;
        }
        if ((i & 8) != 0) {
            str4 = purpose.description;
        }
        if ((i & 16) != 0) {
            str5 = purpose.descriptionLegal;
        }
        if ((i & 32) != 0) {
            list = purpose.illustrations;
        }
        if ((i & 64) != 0) {
            z = purpose.isConsent;
        }
        if ((i & 128) != 0) {
            z2 = purpose.isEssential;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z3 = purpose.isLegitimateInterest;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            z4 = purpose.isSpecialFeature;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            str6 = purpose.type;
        }
        if ((i & 2048) != 0) {
            dataProcessingNamespaces = purpose.namespaces;
        }
        String str7 = str6;
        DataProcessingNamespaces dataProcessingNamespaces2 = dataProcessingNamespaces;
        boolean z5 = z3;
        boolean z6 = z4;
        boolean z7 = z;
        boolean z8 = z2;
        String str8 = str5;
        List list2 = list;
        return purpose.copy(str, str2, str3, str4, str8, list2, z7, z8, z5, z6, str7, dataProcessingNamespaces2);
    }

    public static /* synthetic */ void getCategory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsSpecialFeature() {
        return this.isSpecialFeature;
    }

    /* JADX INFO: renamed from: component11$android_release, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final DataProcessingNamespaces getNamespaces() {
        return this.namespaces;
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

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsConsent() {
        return this.isConsent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsEssential() {
        return this.isEssential;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsLegitimateInterest() {
        return this.isLegitimateInterest;
    }

    public final Purpose copy(String id, String iabId, String name, String description, String descriptionLegal, List<String> illustrations, boolean isConsent, boolean isEssential, boolean isLegitimateInterest, boolean isSpecialFeature, String type, DataProcessingNamespaces namespaces) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new Purpose(id, iabId, name, description, descriptionLegal, illustrations, isConsent, isEssential, isLegitimateInterest, isSpecialFeature, type, namespaces);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Purpose)) {
            return false;
        }
        Purpose purpose = (Purpose) other;
        return Intrinsics.areEqual(this.id, purpose.id) && Intrinsics.areEqual(this.iabId, purpose.iabId) && Intrinsics.areEqual(this.name, purpose.name) && Intrinsics.areEqual(this.description, purpose.description) && Intrinsics.areEqual(this.descriptionLegal, purpose.descriptionLegal) && Intrinsics.areEqual(this.illustrations, purpose.illustrations) && this.isConsent == purpose.isConsent && this.isEssential == purpose.isEssential && this.isLegitimateInterest == purpose.isLegitimateInterest && this.isSpecialFeature == purpose.isSpecialFeature && Intrinsics.areEqual(this.type, purpose.type) && Intrinsics.areEqual(this.namespaces, purpose.namespaces);
    }

    public final PurposeCategory getCategory() {
        return this.category;
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

    public final String getType$android_release() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.iabId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str2 = this.descriptionLegal;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.illustrations;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.isConsent;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        boolean z2 = this.isEssential;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.isLegitimateInterest;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z4 = this.isSpecialFeature;
        int i4 = (i3 + (z4 ? 1 : z4)) * 31;
        String str3 = this.type;
        int iHashCode5 = (i4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DataProcessingNamespaces dataProcessingNamespaces = this.namespaces;
        return iHashCode5 + (dataProcessingNamespaces != null ? dataProcessingNamespaces.hashCode() : 0);
    }

    public final boolean isConsent() {
        return this.isConsent;
    }

    public final boolean isConsentNotEssential() {
        return this.isConsent && !this.isEssential;
    }

    public final boolean isEssential() {
        return this.isEssential;
    }

    public final boolean isLegitimateInterest() {
        return this.isLegitimateInterest;
    }

    public final boolean isLegitimateInterestNotEssential() {
        return this.isLegitimateInterest && !this.isEssential;
    }

    public final boolean isLegitimateInterestOnly() {
        return isLegitimateInterestNotEssential() && !this.isConsent;
    }

    public final boolean isSpecialFeature() {
        return this.isSpecialFeature;
    }

    public final void setCategory(PurposeCategory purposeCategory) {
        this.category = purposeCategory;
    }

    public final void setConsent(boolean z) {
        this.isConsent = z;
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

    public final void setEssential(boolean z) {
        this.isEssential = z;
    }

    @Override // io.didomi.ssl.m1
    public void setIllustrations(List<String> list) {
        this.illustrations = list;
    }

    public final void setLegitimateInterest(boolean z) {
        this.isLegitimateInterest = z;
    }

    @Override // io.didomi.ssl.m1
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSpecialFeature(boolean z) {
        this.isSpecialFeature = z;
    }

    public String toString() {
        return "Purpose(id=" + this.id + ", iabId=" + this.iabId + ", name=" + this.name + ", description=" + this.description + ", descriptionLegal=" + this.descriptionLegal + ", illustrations=" + this.illustrations + ", isConsent=" + this.isConsent + ", isEssential=" + this.isEssential + ", isLegitimateInterest=" + this.isLegitimateInterest + ", isSpecialFeature=" + this.isSpecialFeature + ", type=" + this.type + ", namespaces=" + this.namespaces + ')';
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
        parcel.writeInt(this.isConsent ? 1 : 0);
        parcel.writeInt(this.isEssential ? 1 : 0);
        parcel.writeInt(this.isLegitimateInterest ? 1 : 0);
        parcel.writeInt(this.isSpecialFeature ? 1 : 0);
        parcel.writeString(this.type);
        DataProcessingNamespaces dataProcessingNamespaces = this.namespaces;
        if (dataProcessingNamespaces == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataProcessingNamespaces.writeToParcel(parcel, flags);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str) {
        this(id, str, null, null, null, null, false, false, false, false, null, null, 4092, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // io.didomi.ssl.z7
    public DataProcessingNamespaces getNamespaces() {
        return this.namespaces;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name) {
        this(id, str, name, null, null, null, false, false, false, false, null, null, 4088, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description) {
        this(id, str, name, description, null, null, false, false, false, false, null, null, 4080, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2) {
        this(id, str, name, description, str2, null, false, false, false, false, null, null, 4064, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list) {
        this(id, str, name, description, str2, list, false, false, false, false, null, null, 4032, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z) {
        this(id, str, name, description, str2, list, z, false, false, false, null, null, 3968, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z, boolean z2) {
        this(id, str, name, description, str2, list, z, z2, false, false, null, null, 3840, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z, boolean z2, boolean z3) {
        this(id, str, name, description, str2, list, z, z2, z3, false, null, null, 3584, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z, boolean z2, boolean z3, boolean z4) {
        this(id, str, name, description, str2, list, z, z2, z3, z4, null, null, 3072, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        this(id, str, name, description, str2, list, z, z2, z3, z4, str3, null, 2048, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
    }

    public Purpose(String id, String str, String name, String description, String str2, List<String> list, boolean z, boolean z2, boolean z3, boolean z4, String str3, DataProcessingNamespaces dataProcessingNamespaces) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.iabId = str;
        this.name = name;
        this.description = description;
        this.descriptionLegal = str2;
        this.illustrations = list;
        this.isConsent = z;
        this.isEssential = z2;
        this.isLegitimateInterest = z3;
        this.isSpecialFeature = z4;
        this.type = str3;
        this.namespaces = dataProcessingNamespaces;
    }

    public /* synthetic */ Purpose(String str, String str2, String str3, String str4, String str5, List list, boolean z, boolean z2, boolean z3, boolean z4, String str6, DataProcessingNamespaces dataProcessingNamespaces, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0 ? z4 : false, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str6, (i & 2048) != 0 ? null : dataProcessingNamespaces);
    }
}
