package io.didomi.ssl;

import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.didomi.sdk.pa, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018R'\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u000b\u0010\u0018¨\u0006$"}, d2 = {"Lio/didomi/sdk/pa;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "Lio/didomi/sdk/e7;", "a", "Ljava/util/Map;", "internalPurposes", "b", "internalSpecialPurposes", "c", "internalFeatures", "d", "internalSpecialFeatures", "e", "internalDataCategories", "f", "Lkotlin/Lazy;", "()Ljava/util/Map;", Didomi.VIEW_PURPOSES, "g", "specialPurposes", "h", "features", "i", "specialFeatures", "j", "dataCategories", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposesTranslations {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_PURPOSES)
    private final Map<String, InternalPurpose> internalPurposes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("specialPurposes")
    private final Map<String, InternalPurpose> internalSpecialPurposes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("features")
    private final Map<String, InternalPurpose> internalFeatures;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("specialFeatures")
    private final Map<String, InternalPurpose> internalSpecialFeatures;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("dataCategories")
    private final Map<String, InternalPurpose> internalDataCategories;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy purposes;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy specialPurposes;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy features;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy specialFeatures;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy dataCategories;

    /* JADX INFO: renamed from: io.didomi.sdk.pa$a */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = PurposesTranslations.this.internalDataCategories;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pa$b */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = PurposesTranslations.this.internalFeatures;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pa$c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = PurposesTranslations.this.internalPurposes;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pa$d */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = PurposesTranslations.this.internalSpecialFeatures;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.pa$e */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = PurposesTranslations.this.internalSpecialPurposes;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    public PurposesTranslations() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposesTranslations)) {
            return false;
        }
        PurposesTranslations purposesTranslations = (PurposesTranslations) other;
        return Intrinsics.areEqual(this.internalPurposes, purposesTranslations.internalPurposes) && Intrinsics.areEqual(this.internalSpecialPurposes, purposesTranslations.internalSpecialPurposes) && Intrinsics.areEqual(this.internalFeatures, purposesTranslations.internalFeatures) && Intrinsics.areEqual(this.internalSpecialFeatures, purposesTranslations.internalSpecialFeatures) && Intrinsics.areEqual(this.internalDataCategories, purposesTranslations.internalDataCategories);
    }

    public int hashCode() {
        Map<String, InternalPurpose> map = this.internalPurposes;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, InternalPurpose> map2 = this.internalSpecialPurposes;
        int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, InternalPurpose> map3 = this.internalFeatures;
        int iHashCode3 = (iHashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, InternalPurpose> map4 = this.internalSpecialFeatures;
        int iHashCode4 = (iHashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, InternalPurpose> map5 = this.internalDataCategories;
        return iHashCode4 + (map5 != null ? map5.hashCode() : 0);
    }

    public String toString() {
        return "PurposesTranslations(internalPurposes=" + this.internalPurposes + ", internalSpecialPurposes=" + this.internalSpecialPurposes + ", internalFeatures=" + this.internalFeatures + ", internalSpecialFeatures=" + this.internalSpecialFeatures + ", internalDataCategories=" + this.internalDataCategories + ')';
    }

    public PurposesTranslations(Map<String, InternalPurpose> map, Map<String, InternalPurpose> map2, Map<String, InternalPurpose> map3, Map<String, InternalPurpose> map4, Map<String, InternalPurpose> map5) {
        this.internalPurposes = map;
        this.internalSpecialPurposes = map2;
        this.internalFeatures = map3;
        this.internalSpecialFeatures = map4;
        this.internalDataCategories = map5;
        this.purposes = LazyKt.lazy(new c());
        this.specialPurposes = LazyKt.lazy(new e());
        this.features = LazyKt.lazy(new b());
        this.specialFeatures = LazyKt.lazy(new d());
        this.dataCategories = LazyKt.lazy(new a());
    }

    public final Map<String, InternalPurpose> a() {
        return (Map) this.dataCategories.getValue();
    }

    public final Map<String, InternalPurpose> b() {
        return (Map) this.features.getValue();
    }

    public final Map<String, InternalPurpose> c() {
        return (Map) this.purposes.getValue();
    }

    public final Map<String, InternalPurpose> d() {
        return (Map) this.specialFeatures.getValue();
    }

    public final Map<String, InternalPurpose> e() {
        return (Map) this.specialPurposes.getValue();
    }

    public /* synthetic */ PurposesTranslations(Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3, (i & 8) != 0 ? null : map4, (i & 16) != 0 ? null : map5);
    }
}
