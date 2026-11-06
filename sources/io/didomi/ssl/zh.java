package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DataCategory;
import io.didomi.ssl.models.Feature;
import io.didomi.ssl.models.SpecialPurpose;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u0000 ^2\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020!¢\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0006\u0010\u001a\u001a\u00020\u0002R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070&8\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b\u0014\u0010(R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110&8\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b*\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010$R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b\r\u00101R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0006¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006¢\u0006\f\n\u0004\b7\u0010$\u001a\u0004\b8\u00105R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0006¢\u0006\f\n\u0004\b8\u0010$\u001a\u0004\b:\u00105R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0006¢\u0006\f\n\u0004\b<\u0010$\u001a\u0004\b=\u00105R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?0-8\u0006¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u00101R!\u0010E\u001a\b\u0012\u0004\u0012\u00020?0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\b\b\u00101R\u0017\u0010J\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\b/\u0010IR\u001b\u0010O\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010D\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010D\u001a\u0004\b\n\u0010NR\u001b\u0010R\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010D\u001a\u0004\b\u000b\u0010NR!\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010D\u001a\u0004\b\u0010\u00105R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e8F¢\u0006\u0006\u001a\u0004\b\u0015\u00105R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b3\u00105R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8F¢\u0006\u0006\u001a\u0004\b<\u00105R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b@\u00105R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8F¢\u0006\u0006\u001a\u0004\bC\u00105R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b7\u00105R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\bS\u00105R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8F¢\u0006\u0006\u001a\u0004\bQ\u00105R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\bG\u00105R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8F¢\u0006\u0006\u001a\u0004\b^\u00105R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\bL\u00105R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\ba\u00105R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\bc\u00105¨\u0006g"}, d2 = {"Lio/didomi/sdk/zh;", "", "", "B", "z", "", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/Purpose;", "e", "Lio/didomi/sdk/models/Feature;", "b", "c", "iabId", "d", "", "purposeIds", "a", "Lio/didomi/sdk/Vendor;", "vendor", "Lio/didomi/sdk/models/SpecialPurpose;", "f", "g", "vendorIds", "Lio/didomi/sdk/m1;", "Lio/didomi/sdk/models/DataCategory;", "essentialPurposes", "A", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/n7;", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/qa;", "Lio/didomi/sdk/qa;", "purposesTranslationsRepository", "Ljava/util/Set;", "customVendors", "", "Ljava/util/Map;", "()Ljava/util/Map;", Didomi.VIEW_PURPOSES, "y", Didomi.VIEW_VENDORS, "nonFilteredRequiredVendors", "", "Lio/didomi/sdk/c9;", "h", "Ljava/util/List;", "()Ljava/util/List;", "publisherRestrictions", "i", "q", "()Ljava/util/Set;", "requiredVendors", "j", "k", "requiredPurposes", "getRequiredFeatures", "requiredFeatures", "l", "getRequiredSpecialPurposes", "requiredSpecialPurposes", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "m", "u", "spiCategories", "n", "Lkotlin/Lazy;", "purposeCategories", "Lio/didomi/sdk/hb;", "o", "Lio/didomi/sdk/hb;", "()Lio/didomi/sdk/hb;", "requiredIds", "", "p", "v", "()I", "totalVendorCount", "iabVendorCount", "r", "nonIabVendorCount", "s", "dataCategories", "requiredAdditionalDataProcessing", "requiredPurposeIds", "requiredPurposesConsent", "requiredPurposesConsentIds", "requiredPurposesLegInt", "requiredPurposeLegIntIds", "requiredVendorsIds", "requiredVendorsConsent", "requiredVendorConsentIds", "t", "requiredVendorsLegInt", "requiredVendorLegIntIds", "w", "vendorIDsWithEssentialPurposesOnly", "x", "vendorIDsWithNoConsentNorLIPurposes", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/n7;Lio/didomi/sdk/qa;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class zh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final qa purposesTranslationsRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Set<Vendor> customVendors;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Map<String, Purpose> purposes;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Map<String, Vendor> vendors;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Set<Vendor> nonFilteredRequiredVendors;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final List<PublisherRestriction> publisherRestrictions;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Set<Vendor> requiredVendors;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Set<Purpose> requiredPurposes;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Set<Feature> requiredFeatures;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Set<SpecialPurpose> requiredSpecialPurposes;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final List<PurposeCategory> spiCategories;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy purposeCategories;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final RequiredIds requiredIds;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy totalVendorCount;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy iabVendorCount;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final Lazy nonIabVendorCount;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final Lazy dataCategories;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lio/didomi/sdk/models/DataCategory;", "a", "()Ljava/util/Set;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<DataCategory> invoke() {
            Collection<InternalPurpose> collectionValues = zh.this.configurationRepository.d().e().values();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                arrayList.add(f7.a((InternalPurpose) it.next()));
            }
            return CollectionsKt.toSet(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((DataCategory) t).getId(), ((DataCategory) t2).getId());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            Set<Vendor> setQ = zh.this.q();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setQ) {
                if (((Vendor) obj).isIabVendor()) {
                    arrayList.add(obj);
                }
            }
            return Integer.valueOf(arrayList.size());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            Set<Vendor> setQ = zh.this.q();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setQ) {
                if (!((Vendor) obj).isIabVendor()) {
                    arrayList.add(obj);
                }
            }
            return Integer.valueOf(arrayList.size());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<PurposeCategory> invoke() {
            return l9.a(zh.this.configurationRepository.b().getPreferences().e(), zh.this.i());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(zh.this.q().size());
        }
    }

    public zh(e0 configurationRepository, n7 languagesHelper, qa purposesTranslationsRepository) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(purposesTranslationsRepository, "purposesTranslationsRepository");
        this.configurationRepository = configurationRepository;
        this.languagesHelper = languagesHelper;
        this.purposesTranslationsRepository = purposesTranslationsRepository;
        Set<Vendor> setA = m.a(configurationRepository.b().getApp().getVendors());
        this.customVendors = setA;
        wh whVar = wh.a;
        Map<String, Purpose> mapA = whVar.a(configurationRepository, languagesHelper);
        this.purposes = mapA;
        Map<String, Vendor> mapA2 = whVar.a(mapA, configurationRepository.d().a().values(), configurationRepository.f().a(), setA);
        this.vendors = mapA2;
        Set<Vendor> setA2 = whVar.a(mapA2, f0.b(configurationRepository), configurationRepository.b().getApp().getVendors().getIab(), configurationRepository.b().getApp().getVendors().b(), setA);
        this.nonFilteredRequiredVendors = setA2;
        this.publisherRestrictions = whVar.a(configurationRepository, mapA, setA2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setA2) {
            if (yh.a((Vendor) obj)) {
                arrayList.add(obj);
            }
        }
        Set<Vendor> set = CollectionsKt.toSet(arrayList);
        ai.b(this, set);
        this.requiredVendors = set;
        wh whVar2 = wh.a;
        this.requiredPurposes = whVar2.a(this.purposes, set);
        this.requiredFeatures = whVar2.a(this.configurationRepository, set);
        this.requiredSpecialPurposes = whVar2.b(this.configurationRepository, set);
        this.spiCategories = whVar2.a(this.configurationRepository.b().getPreferences().getSensitivePersonalInformation(), i());
        this.purposeCategories = LazyKt.lazy(new f());
        this.requiredIds = new RequiredIds(m(), j(), o(), p());
        this.totalVendorCount = LazyKt.lazy(new g());
        this.iabVendorCount = LazyKt.lazy(new d());
        this.nonIabVendorCount = LazyKt.lazy(new e());
        this.dataCategories = LazyKt.lazy(new b());
        A();
    }

    private final void B() {
        this.languagesHelper.a(v(), b(), c());
    }

    private final void z() {
        PurposesTranslations paVarA = this.purposesTranslationsRepository.getTranslations();
        if (paVarA == null) {
            return;
        }
        Collection<Purpose> collectionValues = this.purposes.values();
        ArrayList<Purpose> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            String iabId = ((Purpose) obj).getIabId();
            if (iabId != null && iabId.length() != 0) {
                arrayList.add(obj);
            }
        }
        for (Purpose purpose : arrayList) {
            String iabId2 = purpose.getIabId();
            Intrinsics.checkNotNull(iabId2, "null cannot be cast to non-null type kotlin.String");
            InternalPurpose internalPurpose = purpose.isSpecialFeature() ? paVarA.d().get(iabId2) : paVarA.c().get(iabId2);
            if (internalPurpose != null) {
                q1.a(purpose, internalPurpose);
            }
        }
        q1.a(this.requiredFeatures, paVarA.b());
        q1.a(this.requiredSpecialPurposes, paVarA.e());
        q1.a(a(), paVarA.a());
    }

    public final void A() {
        for (CustomPurpose customPurpose : this.configurationRepository.b().getApp().c()) {
            String id = customPurpose.getId();
            Map<String, String> mapComponent2 = customPurpose.component2();
            Map<String, String> mapComponent3 = customPurpose.component3();
            Purpose purpose = this.purposes.get(id);
            if (purpose != null) {
                purpose.setName(n7.a(this.languagesHelper, mapComponent2, null, 2, null));
                purpose.setDescription(n7.a(this.languagesHelper, mapComponent3, null, 2, null));
            }
        }
        z();
        B();
    }

    public final int b() {
        return ((Number) this.iabVendorCount.getValue()).intValue();
    }

    public final int c() {
        return ((Number) this.nonIabVendorCount.getValue()).intValue();
    }

    public final List<PublisherRestriction> d() {
        return this.publisherRestrictions;
    }

    public final List<PurposeCategory> e() {
        return (List) this.purposeCategories.getValue();
    }

    public final Map<String, Purpose> f() {
        return this.purposes;
    }

    public final Set<m1> g() {
        return SetsKt.plus((Set) this.requiredSpecialPurposes, (Iterable) this.requiredFeatures);
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final RequiredIds getRequiredIds() {
        return this.requiredIds;
    }

    public final Set<String> i() {
        Set<Purpose> set = this.requiredPurposes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((Purpose) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> j() {
        Set<Purpose> setN = n();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setN, 10));
        Iterator<T> it = setN.iterator();
        while (it.hasNext()) {
            arrayList.add(((Purpose) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<Purpose> k() {
        return this.requiredPurposes;
    }

    public final Set<Purpose> l() {
        Set<Purpose> set = this.requiredPurposes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (((Purpose) obj).isConsentNotEssential()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> m() {
        Set<Purpose> setL = l();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setL, 10));
        Iterator<T> it = setL.iterator();
        while (it.hasNext()) {
            arrayList.add(((Purpose) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<Purpose> n() {
        Set<Purpose> set = this.requiredPurposes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (((Purpose) obj).isLegitimateInterestNotEssential()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> o() {
        Set<Vendor> setR = r();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setR, 10));
        Iterator<T> it = setR.iterator();
        while (it.hasNext()) {
            arrayList.add(((Vendor) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> p() {
        Set<Vendor> setT = t();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setT, 10));
        Iterator<T> it = setT.iterator();
        while (it.hasNext()) {
            arrayList.add(((Vendor) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<Vendor> q() {
        return this.requiredVendors;
    }

    public final Set<Vendor> r() {
        Set<Vendor> set = this.requiredVendors;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (!((Vendor) obj).getPurposeIds().isEmpty()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> s() {
        Set<Vendor> set = this.requiredVendors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((Vendor) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<Vendor> t() {
        Set<Vendor> set = this.requiredVendors;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (!((Vendor) obj).getLegIntPurposeIds().isEmpty()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final List<PurposeCategory> u() {
        return this.spiCategories;
    }

    public final int v() {
        return ((Number) this.totalVendorCount.getValue()).intValue();
    }

    public final Set<String> w() {
        Set<Vendor> set = this.requiredVendors;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (yh.b((Vendor) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Vendor) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList2);
    }

    public final Set<String> x() {
        Set<Vendor> set = this.requiredVendors;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (yh.c((Vendor) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Vendor) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList2);
    }

    public final Map<String, Vendor> y() {
        return this.vendors;
    }

    private final Set<DataCategory> a() {
        return (Set) this.dataCategories.getValue();
    }

    private final Purpose e(String id) {
        Object next;
        Iterator<T> it = this.purposes.values().iterator();
        while (it.hasNext()) {
            next = it.next();
            Purpose purpose = (Purpose) next;
            if (purpose.isSpecialFeature() && Intrinsics.areEqual(purpose.getIabId(), id)) {
                return (Purpose) next;
            }
        }
        next = null;
        return (Purpose) next;
    }

    public final Feature b(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredFeatures.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Feature) next).getId(), id)) {
                return (Feature) next;
            }
        }
        next = null;
        return (Feature) next;
    }

    public final Purpose c(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.purposes.get(id);
    }

    public final Purpose d(String iabId) {
        Object next;
        Intrinsics.checkNotNullParameter(iabId, "iabId");
        Collection<Purpose> collectionValues = this.purposes.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Purpose) obj).isSpecialFeature()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Purpose) next).getIabId(), iabId)) {
                return (Purpose) next;
            }
        }
        next = null;
        return (Purpose) next;
    }

    public final SpecialPurpose f(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredSpecialPurposes.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((SpecialPurpose) next).getId(), id)) {
                return (SpecialPurpose) next;
            }
        }
        next = null;
        return (SpecialPurpose) next;
    }

    public final Vendor g(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return yh.b(this.vendors, id);
    }

    public final Set<DataCategory> a(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Set<DataCategory> setA = a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setA) {
            DataCategory dataCategory = (DataCategory) obj;
            Set<String> dataDeclaration = vendor.getDataDeclaration();
            if (dataDeclaration != null && dataDeclaration.contains(dataCategory.getId())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(CollectionsKt.sortedWith(arrayList, new c()));
    }

    public final Set<Purpose> b(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        List<String> essentialPurposeIds = vendor.getEssentialPurposeIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = essentialPurposeIds.iterator();
        while (it.hasNext()) {
            Purpose purposeC = c((String) it.next());
            if (purposeC != null) {
                arrayList.add(purposeC);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<m1> c(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<String> featureIds = vendor.getFeatureIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = featureIds.iterator();
        while (it.hasNext()) {
            Feature featureB = b((String) it.next());
            if (featureB != null) {
                arrayList.add(featureB);
            }
        }
        linkedHashSet.addAll(arrayList);
        List<String> specialFeatureIds = vendor.getSpecialFeatureIds();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = specialFeatureIds.iterator();
        while (it2.hasNext()) {
            Purpose purposeE = e((String) it2.next());
            if (purposeE != null) {
                arrayList2.add(purposeE);
            }
        }
        linkedHashSet.addAll(arrayList2);
        List<String> specialPurposeIds = vendor.getSpecialPurposeIds();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = specialPurposeIds.iterator();
        while (it3.hasNext()) {
            SpecialPurpose specialPurposeF = f((String) it3.next());
            if (specialPurposeF != null) {
                arrayList3.add(specialPurposeF);
            }
        }
        linkedHashSet.addAll(arrayList3);
        return linkedHashSet;
    }

    public final Set<Vendor> b(Set<String> vendorIds) {
        Intrinsics.checkNotNullParameter(vendorIds, "vendorIds");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = vendorIds.iterator();
        while (it.hasNext()) {
            Vendor vendorG = g((String) it.next());
            if (vendorG != null) {
                arrayList.add(vendorG);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final DataCategory a(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = a().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((DataCategory) next).getId(), id)) {
                return (DataCategory) next;
            }
        }
        next = null;
        return (DataCategory) next;
    }

    public final Set<Purpose> a(Set<String> purposeIds) {
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = purposeIds.iterator();
        while (it.hasNext()) {
            Purpose purposeC = c((String) it.next());
            if (purposeC != null) {
                arrayList.add(purposeC);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final void c(Set<Purpose> essentialPurposes) {
        Intrinsics.checkNotNullParameter(essentialPurposes, "essentialPurposes");
        for (Purpose purpose : essentialPurposes) {
            purpose.setEssential(true);
            String id = purpose.getId();
            for (Vendor vendor : this.requiredVendors) {
                boolean zRemove = vendor.getPurposeIds().remove(id);
                boolean zRemove2 = vendor.getLegIntPurposeIds().remove(id);
                if (zRemove || zRemove2) {
                    vendor.getEssentialPurposeIds().add(id);
                }
            }
        }
    }
}
