package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.cc, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\rR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/cc;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Map;", "d", "()Ljava/util/Map;", b.S, "b", b.c, "c", "sectionTitle", "", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "Ljava/util/List;", "()Ljava/util/List;", "categories", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SensitivePersonalInformation {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(b.S)
    private final Map<String, String> title;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName(b.c)
    private final Map<String, String> description;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("sectionTitle")
    private final Map<String, String> sectionTitle;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("categories")
    private final List<PurposeCategory> categories;

    public SensitivePersonalInformation() {
        this(null, null, null, null, 15, null);
    }

    public final List<PurposeCategory> a() {
        return this.categories;
    }

    public final Map<String, String> b() {
        return this.description;
    }

    public final Map<String, String> c() {
        return this.sectionTitle;
    }

    public final Map<String, String> d() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SensitivePersonalInformation)) {
            return false;
        }
        SensitivePersonalInformation sensitivePersonalInformation = (SensitivePersonalInformation) other;
        return Intrinsics.areEqual(this.title, sensitivePersonalInformation.title) && Intrinsics.areEqual(this.description, sensitivePersonalInformation.description) && Intrinsics.areEqual(this.sectionTitle, sensitivePersonalInformation.sectionTitle) && Intrinsics.areEqual(this.categories, sensitivePersonalInformation.categories);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.sectionTitle.hashCode()) * 31) + this.categories.hashCode();
    }

    public String toString() {
        return "SensitivePersonalInformation(title=" + this.title + ", description=" + this.description + ", sectionTitle=" + this.sectionTitle + ", categories=" + this.categories + ')';
    }

    public SensitivePersonalInformation(Map<String, String> title, Map<String, String> description, Map<String, String> sectionTitle, List<PurposeCategory> categories) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.title = title;
        this.description = description;
        this.sectionTitle = sectionTitle;
        this.categories = categories;
    }

    public /* synthetic */ SensitivePersonalInformation(Map map, Map map2, Map map3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3, (i & 8) != 0 ? new ArrayList() : list);
    }
}
