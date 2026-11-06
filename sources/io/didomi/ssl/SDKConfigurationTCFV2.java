package io.didomi.ssl;

import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.models.SpecialFeature;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.didomi.sdk.mb, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u001c\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\rR.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\"\u0010\u001fR!\u0010(\u001a\b\u0012\u0004\u0012\u00020$0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u0012\u0010'R!\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b\f\u0010'R!\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b\u0010\u0010'R\u001b\u00101\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b!\u00100R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b\u0015\u0010'¨\u00066"}, d2 = {"Lio/didomi/sdk/mb;", "Lio/didomi/sdk/kb;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "Lio/didomi/sdk/e7;", "a", "Ljava/util/List;", "internalPurposes", "Lio/didomi/sdk/g7;", "b", "internalVendors", "c", "internalSpecialFeatures", "Lio/didomi/sdk/kb$a;", "d", "Lio/didomi/sdk/kb$a;", "internalLanguages", "e", "internalGdprCountryCodes", "", "f", "Ljava/util/Map;", "()Ljava/util/Map;", "setIabPurposeIdsToDidomi", "(Ljava/util/Map;)V", "iabPurposeIdsToDidomi", "g", "setDidomiPurposeIdsToIab", "didomiPurposeIdsToIab", "Lio/didomi/sdk/Purpose;", "h", "Lkotlin/Lazy;", "()Ljava/util/List;", Didomi.VIEW_PURPOSES, "Lio/didomi/sdk/Vendor;", "i", Didomi.VIEW_VENDORS, "Lio/didomi/sdk/models/SpecialFeature;", "j", "specialFeatures", "k", "()Lio/didomi/sdk/kb$a;", "languages", "l", "gdprCountryCodes", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/didomi/sdk/kb$a;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SDKConfigurationTCFV2 implements kb {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_PURPOSES)
    private final List<InternalPurpose> internalPurposes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_VENDORS)
    private final List<InternalVendor> internalVendors;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("specialFeatures")
    private final List<InternalPurpose> internalSpecialFeatures;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("languages")
    private final kb.Languages internalLanguages;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("gdprCountryCodes")
    private final List<String> internalGdprCountryCodes;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Map<String, String> iabPurposeIdsToDidomi;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Map<String, String> didomiPurposeIdsToIab;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy purposes;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy vendors;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy specialFeatures;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy languages;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy gdprCountryCodes;

    /* JADX INFO: renamed from: io.didomi.sdk.mb$a */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<String> invoke() {
            List<String> list = SDKConfigurationTCFV2.this.internalGdprCountryCodes;
            return list == null ? CollectionsKt.emptyList() : list;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.mb$b */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/kb$a;", "a", "()Lio/didomi/sdk/kb$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kb.Languages invoke() {
            kb.Languages languages = SDKConfigurationTCFV2.this.internalLanguages;
            return languages == null ? new kb.Languages(null, null, null, null, 15, null) : languages;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.mb$c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lio/didomi/sdk/Purpose;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Purpose> invoke() {
            List<Purpose> listA;
            List list = SDKConfigurationTCFV2.this.internalPurposes;
            return (list == null || (listA = f7.a(list)) == null) ? CollectionsKt.emptyList() : listA;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.mb$d */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lio/didomi/sdk/models/SpecialFeature;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<SpecialFeature> invoke() {
            List<SpecialFeature> listB;
            List list = SDKConfigurationTCFV2.this.internalSpecialFeatures;
            return (list == null || (listB = f7.b(list)) == null) ? CollectionsKt.emptyList() : listB;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.mb$e */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lio/didomi/sdk/Vendor;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Vendor> invoke() {
            List<Vendor> listA;
            List list = SDKConfigurationTCFV2.this.internalVendors;
            return (list == null || (listA = h7.a(list)) == null) ? CollectionsKt.emptyList() : listA;
        }
    }

    public SDKConfigurationTCFV2() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SDKConfigurationTCFV2)) {
            return false;
        }
        SDKConfigurationTCFV2 sDKConfigurationTCFV2 = (SDKConfigurationTCFV2) other;
        return Intrinsics.areEqual(this.internalPurposes, sDKConfigurationTCFV2.internalPurposes) && Intrinsics.areEqual(this.internalVendors, sDKConfigurationTCFV2.internalVendors) && Intrinsics.areEqual(this.internalSpecialFeatures, sDKConfigurationTCFV2.internalSpecialFeatures) && Intrinsics.areEqual(this.internalLanguages, sDKConfigurationTCFV2.internalLanguages) && Intrinsics.areEqual(this.internalGdprCountryCodes, sDKConfigurationTCFV2.internalGdprCountryCodes);
    }

    @Override // io.didomi.ssl.kb
    public Map<String, String> f() {
        return this.didomiPurposeIdsToIab;
    }

    @Override // io.didomi.ssl.kb
    public kb.Languages g() {
        return (kb.Languages) this.languages.getValue();
    }

    public int hashCode() {
        List<InternalPurpose> list = this.internalPurposes;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<InternalVendor> list2 = this.internalVendors;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<InternalPurpose> list3 = this.internalSpecialFeatures;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        kb.Languages languages = this.internalLanguages;
        int iHashCode4 = (iHashCode3 + (languages == null ? 0 : languages.hashCode())) * 31;
        List<String> list4 = this.internalGdprCountryCodes;
        return iHashCode4 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "SDKConfigurationTCFV2(internalPurposes=" + this.internalPurposes + ", internalVendors=" + this.internalVendors + ", internalSpecialFeatures=" + this.internalSpecialFeatures + ", internalLanguages=" + this.internalLanguages + ", internalGdprCountryCodes=" + this.internalGdprCountryCodes + ')';
    }

    public SDKConfigurationTCFV2(List<InternalPurpose> list, List<InternalVendor> list2, List<InternalPurpose> list3, kb.Languages languages, List<String> list4) {
        this.internalPurposes = list;
        this.internalVendors = list2;
        this.internalSpecialFeatures = list3;
        this.internalLanguages = languages;
        this.internalGdprCountryCodes = list4;
        this.iabPurposeIdsToDidomi = new LinkedHashMap();
        this.didomiPurposeIdsToIab = new LinkedHashMap();
        this.purposes = LazyKt.lazy(new c());
        this.vendors = LazyKt.lazy(new e());
        this.specialFeatures = LazyKt.lazy(new d());
        this.languages = LazyKt.lazy(new b());
        this.gdprCountryCodes = LazyKt.lazy(new a());
    }

    @Override // io.didomi.ssl.kb
    public List<Vendor> a() {
        return (List) this.vendors.getValue();
    }

    @Override // io.didomi.ssl.kb
    public List<SpecialFeature> b() {
        return (List) this.specialFeatures.getValue();
    }

    @Override // io.didomi.ssl.kb
    public List<Purpose> c() {
        return (List) this.purposes.getValue();
    }

    @Override // io.didomi.ssl.kb
    public List<String> d() {
        return (List) this.gdprCountryCodes.getValue();
    }

    @Override // io.didomi.ssl.kb
    public Map<String, String> e() {
        return this.iabPurposeIdsToDidomi;
    }

    public /* synthetic */ SDKConfigurationTCFV2(List list, List list2, List list3, kb.Languages languages, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : languages, (i & 16) != 0 ? null : list4);
    }
}
