package io.didomi.ssl;

import com.iabtcf.v2.RestrictionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003BA\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/d9;", "", "", "a", "Lio/didomi/sdk/s6;", "Lio/didomi/sdk/s6;", "iabConfiguration", "", "", "Lio/didomi/sdk/Purpose;", "b", "Ljava/util/Map;", "availablePurposes", "", "Lio/didomi/sdk/Vendor;", "c", "Ljava/util/Set;", "requiredVendors", "", "Lio/didomi/sdk/c9;", "d", "Ljava/util/List;", "()Ljava/util/List;", "publisherRestrictions", "Lio/didomi/sdk/l$a$b$a$b;", "configRestrictions", "<init>", "(Ljava/util/List;Lio/didomi/sdk/s6;Ljava/util/Map;Ljava/util/Set;)V", "e", "android_release"}, k = 1, mv = {1, 8, 0})
public final class d9 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final s6 iabConfiguration;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Map<String, Purpose> availablePurposes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Set<Vendor> requiredVendors;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<PublisherRestriction> publisherRestrictions;

    /* JADX INFO: renamed from: io.didomi.sdk.d9$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J<\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0016J\u0018\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0002JL\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0002J,\u0010\u000e\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0018\u0010\u000e\u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0007R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lio/didomi/sdk/d9$a;", "", "", "maxVendorId", "", "", "Lio/didomi/sdk/Purpose;", "availablePurposes", "", "Lio/didomi/sdk/Vendor;", "requiredVendors", "Lio/didomi/sdk/l$a$b$a$b;", "configPublisherRestriction", "Lio/didomi/sdk/c9;", "a", "purposeId", "purposeIabId", "", "specialFeature", "Lio/didomi/sdk/l$a$b$a$b$b;", "configRestrictionType", "purpose", "(Lio/didomi/sdk/Purpose;)Ljava/lang/Integer;", "forPurpose", "restrictionType", "restriction", "restrictionId", "excludeVendorsFromList", "Lio/didomi/sdk/l$a$b$a$b$a;", "restrictionVendors", "excludedVendorIds", "", "vendorIds", "", "vendor", "restrictedPurposeId", "restrictedSpecialFeatureIabId", "d", "b", "c", "COOKIES_PURPOSE_ID", "Ljava/lang/String;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: io.didomi.sdk.d9$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class C0137a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;
            public static final /* synthetic */ int[] c;

            static {
                int[] iArr = new int[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.values().length];
                try {
                    iArr[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.DISALLOW.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.ALLOW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.REQUIRE_CONSENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.REQUIRE_LI.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
                int[] iArr2 = new int[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a.values().length];
                try {
                    iArr2[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a.ALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a.LIST.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                b = iArr2;
                int[] iArr3 = new int[RestrictionType.values().length];
                try {
                    iArr3[RestrictionType.NOT_ALLOWED.ordinal()] = 1;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr3[RestrictionType.REQUIRE_CONSENT.ordinal()] = 2;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr3[RestrictionType.REQUIRE_LEGITIMATE_INTEREST.ordinal()] = 3;
                } catch (NoSuchFieldError unused9) {
                }
                c = iArr3;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Vendor vendor, String restrictedPurposeId) {
            if (vendor.getPurposeIds().contains(restrictedPurposeId)) {
                List<String> purposeIds = vendor.getPurposeIds();
                ArrayList arrayList = new ArrayList();
                for (Object obj : purposeIds) {
                    if (!Intrinsics.areEqual((String) obj, restrictedPurposeId)) {
                        arrayList.add(obj);
                    }
                }
                vendor.setPurposeIds(CollectionsKt.toMutableList((Collection) arrayList));
                if (!vendor.getFlexiblePurposeIds().contains(restrictedPurposeId) || vendor.getLegIntPurposeIds().contains(restrictedPurposeId)) {
                    return;
                }
                List<String> listMutableListOf = CollectionsKt.mutableListOf(restrictedPurposeId);
                listMutableListOf.addAll(vendor.getLegIntPurposeIds());
                vendor.setLegIntPurposeIds(listMutableListOf);
            }
        }

        private final void d(Vendor vendor, String restrictedSpecialFeatureIabId) {
            List<String> specialFeatureIds = vendor.getSpecialFeatureIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj : specialFeatureIds) {
                if (!Intrinsics.areEqual((String) obj, restrictedSpecialFeatureIabId)) {
                    arrayList.add(obj);
                }
            }
            vendor.setSpecialFeatureIds(arrayList);
        }

        public final boolean b(Vendor vendor, PublisherRestriction restriction) {
            Intrinsics.checkNotNullParameter(vendor, "vendor");
            Intrinsics.checkNotNullParameter(restriction, "restriction");
            String purposeId = restriction.getPurposeId();
            int i = C0137a.c[restriction.getRestrictionType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 || !vendor.getPurposeIds().contains(purposeId) || !vendor.getFlexiblePurposeIds().contains(purposeId)) {
                        return false;
                    }
                } else if (!vendor.getLegIntPurposeIds().contains(purposeId) || !vendor.getFlexiblePurposeIds().contains(purposeId)) {
                    return false;
                }
            } else {
                if (restriction.getSpecialFeature()) {
                    return false;
                }
                if (!vendor.getPurposeIds().contains(purposeId) && !vendor.getLegIntPurposeIds().contains(purposeId)) {
                    return false;
                }
            }
            return true;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PublisherRestriction a(int maxVendorId, Map<String, Purpose> availablePurposes, Set<Vendor> requiredVendors, AppConfiguration.App.Vendors.IABVendors.PublisherRestriction configPublisherRestriction) {
            String purposeId = configPublisherRestriction.getPurposeId();
            Purpose purpose = availablePurposes.get(purposeId);
            if (purpose == null) {
                Log.e$default("Purpose id " + purposeId + " specified in publisher restrictions is not an existing purpose", null, 2, null);
                return null;
            }
            Integer numA = a(purpose);
            if (numA == null) {
                return null;
            }
            int iIntValue = numA.intValue();
            if (!a(purpose, m.a(configPublisherRestriction))) {
                return null;
            }
            AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors vendors = configPublisherRestriction.getVendors();
            if (vendors == null) {
                Log.e$default("No Vendor information for publisher restriction " + configPublisherRestriction.getId(), null, 2, null);
                return null;
            }
            boolean z = m.a(configPublisherRestriction) == AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.ALLOW;
            boolean zIsSpecialFeature = purpose.isSpecialFeature();
            if (purposeId == null) {
                purposeId = "";
            }
            PublisherRestriction publisherRestrictionA = a(purposeId, iIntValue, zIsSpecialFeature, m.a(configPublisherRestriction));
            if (publisherRestrictionA == null) {
                return null;
            }
            return a(publisherRestrictionA, requiredVendors, maxVendorId, configPublisherRestriction.getId(), z, purpose, vendors);
        }

        private final void b(Vendor vendor, String restrictedPurposeId) {
            if (vendor.getLegIntPurposeIds().contains(restrictedPurposeId)) {
                List<String> legIntPurposeIds = vendor.getLegIntPurposeIds();
                ArrayList arrayList = new ArrayList();
                for (Object obj : legIntPurposeIds) {
                    if (!Intrinsics.areEqual((String) obj, restrictedPurposeId)) {
                        arrayList.add(obj);
                    }
                }
                vendor.setLegIntPurposeIds(CollectionsKt.toMutableList((Collection) arrayList));
                if (!vendor.getFlexiblePurposeIds().contains(restrictedPurposeId) || vendor.getPurposeIds().contains(restrictedPurposeId)) {
                    return;
                }
                List<String> listMutableListOf = CollectionsKt.mutableListOf(restrictedPurposeId);
                listMutableListOf.addAll(vendor.getPurposeIds());
                vendor.setPurposeIds(listMutableListOf);
            }
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0026 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0027  */
        private final PublisherRestriction a(String purposeId, int purposeIabId, boolean specialFeature, AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b configRestrictionType) {
            RestrictionType restrictionType;
            RestrictionType restrictionType2;
            int i = C0137a.a[configRestrictionType.ordinal()];
            if (i == 1 || i == 2) {
                restrictionType = RestrictionType.NOT_ALLOWED;
            } else {
                if (i != 3) {
                    if (i != 4) {
                        restrictionType2 = null;
                    } else {
                        restrictionType = RestrictionType.REQUIRE_LEGITIMATE_INTEREST;
                    }
                    if (restrictionType2 == null) {
                        return null;
                    }
                    return new PublisherRestriction(purposeId, purposeIabId, specialFeature, restrictionType2, null, null, 48, null);
                }
                restrictionType = RestrictionType.REQUIRE_CONSENT;
            }
            restrictionType2 = restrictionType;
            if (restrictionType2 == null) {
                return null;
            }
            return new PublisherRestriction(purposeId, purposeIabId, specialFeature, restrictionType2, null, null, 48, null);
        }

        private final Integer a(Purpose purpose) {
            String iabId = purpose.getIabId();
            if (iabId == null) {
                Log.e$default("Purpose " + purpose.getId() + " specified in publisher restrictions is not a TCF purpose", null, 2, null);
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(iabId));
            } catch (NumberFormatException unused) {
                Log.e$default("Error: Purpose iabId " + iabId + " is not an integer", null, 2, null);
                return null;
            }
        }

        private final boolean a(Purpose forPurpose, AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b restrictionType) {
            if (forPurpose.isSpecialFeature() && restrictionType != AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.DISALLOW) {
                Log.e$default("Invalid restriction type " + restrictionType + " for purpose " + forPurpose.getId() + ": Only 'disallow' type is valid for special features", null, 2, null);
                return false;
            }
            if (!Intrinsics.areEqual(forPurpose.getId(), "cookies") || restrictionType == AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.ALLOW || restrictionType == AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.DISALLOW) {
                return restrictionType != AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.EnumC0148b.UNKNOWN;
            }
            Log.e$default("Invalid restriction type " + restrictionType + " for purpose cookies: Only 'allow' and 'disallow' type are valid for Cookies purpose", null, 2, null);
            return false;
        }

        private final PublisherRestriction a(PublisherRestriction restriction, Set<Vendor> requiredVendors, int maxVendorId, String restrictionId, boolean excludeVendorsFromList, Purpose forPurpose, AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors restrictionVendors) {
            Integer numValueOf;
            if (restrictionVendors == null) {
                Log.e$default("No Vendor information for publisher restriction " + restrictionId, null, 2, null);
                return null;
            }
            AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a enumC0145aB = restrictionVendors.b();
            if (excludeVendorsFromList && enumC0145aB == AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a.ALL) {
                Log.d$default("Ignored restriction of type 'allow' with vendors type 'all' for purpose " + forPurpose.getId(), null, 2, null);
                return null;
            }
            if (forPurpose.isSpecialFeature() && enumC0145aB != AppConfiguration.App.Vendors.IABVendors.PublisherRestriction.RestrictionVendors.EnumC0145a.ALL) {
                Log.e$default("Invalid restriction vendors type " + enumC0145aB + " for purpose " + forPurpose.getId() + ": Only vendor restriction 'all' is valid for special features", null, 2, null);
                return null;
            }
            int i = C0137a.b[enumC0145aB.ordinal()];
            if (i == 1) {
                restriction.b(a(this, requiredVendors, (Set) null, 2, (Object) null));
                restriction.a(a(maxVendorId));
            } else {
                if (i != 2) {
                    Log.e$default("Invalid restriction vendors type: " + restrictionVendors.b(), null, 2, null);
                    return null;
                }
                if (excludeVendorsFromList) {
                    restriction.b(a(requiredVendors, restrictionVendors.a()));
                    Set<String> setA = restrictionVendors.a();
                    ArrayList arrayList = new ArrayList();
                    for (String str : setA) {
                        try {
                            numValueOf = Integer.valueOf(Integer.parseInt(str));
                        } catch (NumberFormatException unused) {
                            Log.e$default("Invalid vendor id " + str + " in publisher restriction for purpose " + forPurpose.getId(), null, 2, null);
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            arrayList.add(numValueOf);
                        }
                    }
                    restriction.a(a(maxVendorId, arrayList));
                } else {
                    a(restriction, requiredVendors, restrictionVendors.a());
                }
            }
            Set<String> setF = restriction.f();
            if (setF != null && !setF.isEmpty()) {
                return restriction;
            }
            Log.e$default("No valid vendor information for publisher restriction " + restrictionId, null, 2, null);
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Set a(Companion companion, Set set, Set set2, int i, Object obj) {
            if ((i & 2) != 0) {
                set2 = null;
            }
            return companion.a((Set<Vendor>) set, (Set<String>) set2);
        }

        private final Set<Integer> a(int maxVendorId) {
            return CollectionsKt.toSet(new IntRange(1, maxVendorId));
        }

        private final Set<Integer> a(int maxVendorId, List<Integer> excludedVendorIds) {
            IntRange intRange = new IntRange(1, maxVendorId);
            ArrayList arrayList = new ArrayList();
            for (Object obj : intRange) {
                if (!excludedVendorIds.contains(Integer.valueOf(((Number) obj).intValue()))) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt.toSet(arrayList);
        }

        private final void a(PublisherRestriction restriction, Set<Vendor> requiredVendors, Set<String> vendorIds) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            for (String str : vendorIds) {
                Vendor vendorB = yh.b(requiredVendors, str);
                if (vendorB != null) {
                    if (vendorB.isIabVendor()) {
                        linkedHashSet.add(str);
                        if (b(vendorB, restriction)) {
                            try {
                                linkedHashSet2.add(Integer.valueOf(Integer.parseInt(str)));
                            } catch (NumberFormatException unused) {
                                Log.e$default("Vendor ids for publisher restrictions should be numerical values. Invalid value: " + str, null, 2, null);
                            }
                        }
                    } else {
                        Log.e$default("Vendor " + str + " specified in publisher restrictions is not a valid IAB vendor.", null, 2, null);
                    }
                }
            }
            restriction.b(linkedHashSet);
            restriction.a(linkedHashSet2);
        }

        public final void a(Vendor vendor, PublisherRestriction restriction) {
            Intrinsics.checkNotNullParameter(vendor, "vendor");
            Intrinsics.checkNotNullParameter(restriction, "restriction");
            int i = C0137a.c[restriction.getRestrictionType().ordinal()];
            if (i == 1) {
                if (restriction.getSpecialFeature()) {
                    d(vendor, String.valueOf(restriction.getPurposeIabId()));
                    return;
                } else {
                    a(vendor, restriction.getPurposeId());
                    return;
                }
            }
            if (i == 2) {
                b(vendor, restriction.getPurposeId());
            } else {
                if (i != 3) {
                    return;
                }
                c(vendor, restriction.getPurposeId());
            }
        }

        private final void a(Vendor vendor, String restrictedPurposeId) {
            if (vendor.getPurposeIds().contains(restrictedPurposeId)) {
                List<String> purposeIds = vendor.getPurposeIds();
                ArrayList arrayList = new ArrayList();
                for (Object obj : purposeIds) {
                    if (!Intrinsics.areEqual((String) obj, restrictedPurposeId)) {
                        arrayList.add(obj);
                    }
                }
                vendor.setPurposeIds(CollectionsKt.toMutableList((Collection) arrayList));
            }
            if (vendor.getLegIntPurposeIds().contains(restrictedPurposeId)) {
                List<String> legIntPurposeIds = vendor.getLegIntPurposeIds();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : legIntPurposeIds) {
                    if (!Intrinsics.areEqual((String) obj2, restrictedPurposeId)) {
                        arrayList2.add(obj2);
                    }
                }
                vendor.setLegIntPurposeIds(CollectionsKt.toMutableList((Collection) arrayList2));
            }
        }

        private final Set<String> a(Set<Vendor> requiredVendors, Set<String> excludedVendorIds) {
            ArrayList arrayList = new ArrayList();
            for (Vendor vendor : requiredVendors) {
                String iabId = vendor.getIabId();
                if (iabId == null) {
                    iabId = vendor.getId();
                }
                if (excludedVendorIds != null && excludedVendorIds.contains(iabId)) {
                    iabId = null;
                }
                if (iabId != null) {
                    arrayList.add(iabId);
                }
            }
            return CollectionsKt.toSet(arrayList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004b  */
    public d9(List<AppConfiguration.App.Vendors.IABVendors.PublisherRestriction> list, s6 iabConfiguration, Map<String, Purpose> availablePurposes, Set<Vendor> requiredVendors) {
        List<PublisherRestriction> listEmptyList;
        Intrinsics.checkNotNullParameter(iabConfiguration, "iabConfiguration");
        Intrinsics.checkNotNullParameter(availablePurposes, "availablePurposes");
        Intrinsics.checkNotNullParameter(requiredVendors, "requiredVendors");
        this.iabConfiguration = iabConfiguration;
        this.availablePurposes = availablePurposes;
        this.requiredVendors = requiredVendors;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PublisherRestriction publisherRestrictionA = INSTANCE.a(this.iabConfiguration.getMaxVendorId(), this.availablePurposes, this.requiredVendors, (AppConfiguration.App.Vendors.IABVendors.PublisherRestriction) it.next());
                if (publisherRestrictionA != null) {
                    arrayList.add(publisherRestrictionA);
                }
            }
            listEmptyList = CollectionsKt.distinct(arrayList);
            listEmptyList = listEmptyList == null ? CollectionsKt.emptyList() : listEmptyList;
        }
        this.publisherRestrictions = listEmptyList;
    }

    public final void a() {
        for (PublisherRestriction publisherRestriction : this.publisherRestrictions) {
            Set<String> setF = publisherRestriction.f();
            if (setF != null) {
                Iterator<T> it = setF.iterator();
                while (it.hasNext()) {
                    Vendor vendorB = yh.b(this.requiredVendors, (String) it.next());
                    if (vendorB != null) {
                        INSTANCE.a(vendorB, publisherRestriction);
                    }
                }
            }
        }
    }

    public final List<PublisherRestriction> b() {
        return this.publisherRestrictions;
    }
}
