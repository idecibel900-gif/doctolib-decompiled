package io.didomi.ssl;

import androidx.annotation.Keep;
import com.amazon.a.a.o.b;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DataProcessingNamespaces;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003Js\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R,\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006$"}, d2 = {"Lio/didomi/sdk/CustomPurpose;", "", DiagnosticsEntry.ID_KEY, "", "name", "", b.c, "descriptionLegal", "type", "namespaces", "Lio/didomi/sdk/models/DataProcessingNamespaces;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lio/didomi/sdk/models/DataProcessingNamespaces;)V", "getDescription", "()Ljava/util/Map;", "setDescription", "(Ljava/util/Map;)V", "getDescriptionLegal", "getId", "()Ljava/lang/String;", "getName", "getNamespaces", "()Lio/didomi/sdk/models/DataProcessingNamespaces;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomPurpose {

    @SerializedName(b.c)
    private Map<String, String> description;

    @SerializedName("descriptionLegal")
    private final Map<String, String> descriptionLegal;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    @SerializedName("name")
    private final Map<String, String> name;

    @SerializedName("namespaces")
    private final DataProcessingNamespaces namespaces;

    @SerializedName("type")
    private final String type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPurpose(String id) {
        this(id, null, null, null, null, null, 62, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomPurpose copy$default(CustomPurpose customPurpose, String str, Map map, Map map2, Map map3, String str2, DataProcessingNamespaces dataProcessingNamespaces, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customPurpose.id;
        }
        if ((i & 2) != 0) {
            map = customPurpose.name;
        }
        if ((i & 4) != 0) {
            map2 = customPurpose.description;
        }
        if ((i & 8) != 0) {
            map3 = customPurpose.descriptionLegal;
        }
        if ((i & 16) != 0) {
            str2 = customPurpose.type;
        }
        if ((i & 32) != 0) {
            dataProcessingNamespaces = customPurpose.namespaces;
        }
        String str3 = str2;
        DataProcessingNamespaces dataProcessingNamespaces2 = dataProcessingNamespaces;
        return customPurpose.copy(str, map, map2, map3, str3, dataProcessingNamespaces2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final Map<String, String> component2() {
        return this.name;
    }

    public final Map<String, String> component3() {
        return this.description;
    }

    public final Map<String, String> component4() {
        return this.descriptionLegal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DataProcessingNamespaces getNamespaces() {
        return this.namespaces;
    }

    public final CustomPurpose copy(String id, Map<String, String> name, Map<String, String> description, Map<String, String> descriptionLegal, String type, DataProcessingNamespaces namespaces) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new CustomPurpose(id, name, description, descriptionLegal, type, namespaces);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomPurpose)) {
            return false;
        }
        CustomPurpose customPurpose = (CustomPurpose) other;
        return Intrinsics.areEqual(this.id, customPurpose.id) && Intrinsics.areEqual(this.name, customPurpose.name) && Intrinsics.areEqual(this.description, customPurpose.description) && Intrinsics.areEqual(this.descriptionLegal, customPurpose.descriptionLegal) && Intrinsics.areEqual(this.type, customPurpose.type) && Intrinsics.areEqual(this.namespaces, customPurpose.namespaces);
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final Map<String, String> getDescriptionLegal() {
        return this.descriptionLegal;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final DataProcessingNamespaces getNamespaces() {
        return this.namespaces;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        Map<String, String> map = this.name;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.description;
        int iHashCode3 = (iHashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.descriptionLegal;
        int iHashCode4 = (iHashCode3 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str = this.type;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        DataProcessingNamespaces dataProcessingNamespaces = this.namespaces;
        return iHashCode5 + (dataProcessingNamespaces != null ? dataProcessingNamespaces.hashCode() : 0);
    }

    public final void setDescription(Map<String, String> map) {
        this.description = map;
    }

    public String toString() {
        return "CustomPurpose(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", descriptionLegal=" + this.descriptionLegal + ", type=" + this.type + ", namespaces=" + this.namespaces + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPurpose(String id, Map<String, String> map) {
        this(id, map, null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPurpose(String id, Map<String, String> map, Map<String, String> map2) {
        this(id, map, map2, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPurpose(String id, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        this(id, map, map2, map3, null, null, 48, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPurpose(String id, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str) {
        this(id, map, map2, map3, str, null, 32, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public CustomPurpose(String id, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str, DataProcessingNamespaces dataProcessingNamespaces) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.name = map;
        this.description = map2;
        this.descriptionLegal = map3;
        this.type = str;
        this.namespaces = dataProcessingNamespaces;
    }

    public /* synthetic */ CustomPurpose(String str, Map map, Map map2, Map map3, String str2, DataProcessingNamespaces dataProcessingNamespaces, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) != 0 ? null : map3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : dataProcessingNamespaces);
    }
}
