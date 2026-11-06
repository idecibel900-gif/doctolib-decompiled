package io.didomi.ssl;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.didomi.sdk.u6, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bC\u0010DJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0019R\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\"\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0015R\"\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010$\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u001b\u0010)\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b!\u0010\u0019R'\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b\n\u0010\u0019R'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b\u0014\u0010\u0019R'\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b\r\u0010\u0019R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b\u0017\u0010\u0019R'\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010&\u001a\u0004\b\u001b\u0010\u0019R\u001b\u00109\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010&\u001a\u0004\b8\u0010(R\u001d\u0010>\u001a\u0004\u0018\u00010:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b\u001f\u0010(\"\u0004\b\n\u0010A¨\u0006E"}, d2 = {"Lio/didomi/sdk/u6;", "Lio/didomi/sdk/s6;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/Integer;", "internalVersion", "b", "Ljava/lang/String;", "getLastUpdated", "()Ljava/lang/String;", "lastUpdated", "", "Lio/didomi/sdk/e7;", "c", "Ljava/util/Map;", "internalFeatures", "d", "h", "()Ljava/util/Map;", "internalPurposes", "e", "i", "internalSpecialFeatures", "Lio/didomi/sdk/g7;", "f", "internalVendors", "g", "internalSpecialPurposes", "internalDataCategories", "internalTcfPolicyVersion", "j", "Lkotlin/Lazy;", "getVersion", "()I", DiagnosticsEntry.VERSION_KEY, "k", "features", "Lio/didomi/sdk/Vendor;", "l", Didomi.VIEW_VENDORS, "m", Didomi.VIEW_PURPOSES, "n", "specialFeatures", "o", "specialPurposes", "p", "dataCategories", "q", "getTcfPolicyVersion", "tcfPolicyVersion", "Ljava/util/Date;", "r", "getLastUpdatedDate", "()Ljava/util/Date;", "lastUpdatedDate", "s", "I", "(I)V", "maxVendorId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class IABConfigurationTCFV2 implements s6 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName("vendorListVersion")
    private final Integer internalVersion;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("lastUpdated")
    private final String lastUpdated;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("features")
    private final Map<String, InternalPurpose> internalFeatures;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_PURPOSES)
    private final Map<String, InternalPurpose> internalPurposes;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("specialFeatures")
    private final Map<String, InternalPurpose> internalSpecialFeatures;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_VENDORS)
    private final Map<String, InternalVendor> internalVendors;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    @SerializedName("specialPurposes")
    private final Map<String, InternalPurpose> internalSpecialPurposes;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    @SerializedName("dataCategories")
    private final Map<String, InternalPurpose> internalDataCategories;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    @SerializedName("tcfPolicyVersion")
    private final Integer internalTcfPolicyVersion;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy version;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy features;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy vendors;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy purposes;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy specialFeatures;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy specialPurposes;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy dataCategories;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy tcfPolicyVersion;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final Lazy lastUpdatedDate;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private int maxVendorId;

    /* JADX INFO: renamed from: io.didomi.sdk.u6$a */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = IABConfigurationTCFV2.this.internalDataCategories;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$b */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = IABConfigurationTCFV2.this.internalFeatures;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/Date;", "a", "()Ljava/util/Date;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Date invoke() {
            return t6.a(IABConfigurationTCFV2.this);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$d */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> mapH = IABConfigurationTCFV2.this.h();
            return mapH == null ? MapsKt.emptyMap() : mapH;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$e */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> mapI = IABConfigurationTCFV2.this.i();
            return mapI == null ? MapsKt.emptyMap() : mapI;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$f */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/e7;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, InternalPurpose> invoke() {
            Map<String, InternalPurpose> map = IABConfigurationTCFV2.this.internalSpecialPurposes;
            return map == null ? MapsKt.emptyMap() : map;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$g */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            Integer num = IABConfigurationTCFV2.this.internalTcfPolicyVersion;
            return Integer.valueOf(num != null ? num.intValue() : 2);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$h */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lio/didomi/sdk/Vendor;", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0 {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, Vendor> invoke() {
            Map map = IABConfigurationTCFV2.this.internalVendors;
            if (map == null) {
                return MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), h7.a((InternalVendor) entry.getValue()));
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.u6$i */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0 {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            Integer num = IABConfigurationTCFV2.this.internalVersion;
            return Integer.valueOf(num != null ? num.intValue() : 0);
        }
    }

    public IABConfigurationTCFV2() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IABConfigurationTCFV2)) {
            return false;
        }
        IABConfigurationTCFV2 iABConfigurationTCFV2 = (IABConfigurationTCFV2) other;
        return Intrinsics.areEqual(this.internalVersion, iABConfigurationTCFV2.internalVersion) && Intrinsics.areEqual(this.lastUpdated, iABConfigurationTCFV2.lastUpdated) && Intrinsics.areEqual(this.internalFeatures, iABConfigurationTCFV2.internalFeatures) && Intrinsics.areEqual(this.internalPurposes, iABConfigurationTCFV2.internalPurposes) && Intrinsics.areEqual(this.internalSpecialFeatures, iABConfigurationTCFV2.internalSpecialFeatures) && Intrinsics.areEqual(this.internalVendors, iABConfigurationTCFV2.internalVendors) && Intrinsics.areEqual(this.internalSpecialPurposes, iABConfigurationTCFV2.internalSpecialPurposes) && Intrinsics.areEqual(this.internalDataCategories, iABConfigurationTCFV2.internalDataCategories) && Intrinsics.areEqual(this.internalTcfPolicyVersion, iABConfigurationTCFV2.internalTcfPolicyVersion);
    }

    @Override // io.didomi.ssl.s6
    public Map<String, InternalPurpose> g() {
        return (Map) this.features.getValue();
    }

    @Override // io.didomi.ssl.s6
    public String getLastUpdated() {
        return this.lastUpdated;
    }

    @Override // io.didomi.ssl.s6
    public int getTcfPolicyVersion() {
        return ((Number) this.tcfPolicyVersion.getValue()).intValue();
    }

    @Override // io.didomi.ssl.s6
    public int getVersion() {
        return ((Number) this.version.getValue()).intValue();
    }

    public final Map<String, InternalPurpose> h() {
        return this.internalPurposes;
    }

    public int hashCode() {
        Integer num = this.internalVersion;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.lastUpdated;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, InternalPurpose> map = this.internalFeatures;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, InternalPurpose> map2 = this.internalPurposes;
        int iHashCode4 = (iHashCode3 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, InternalPurpose> map3 = this.internalSpecialFeatures;
        int iHashCode5 = (iHashCode4 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, InternalVendor> map4 = this.internalVendors;
        int iHashCode6 = (iHashCode5 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, InternalPurpose> map5 = this.internalSpecialPurposes;
        int iHashCode7 = (iHashCode6 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<String, InternalPurpose> map6 = this.internalDataCategories;
        int iHashCode8 = (iHashCode7 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Integer num2 = this.internalTcfPolicyVersion;
        return iHashCode8 + (num2 != null ? num2.hashCode() : 0);
    }

    public final Map<String, InternalPurpose> i() {
        return this.internalSpecialFeatures;
    }

    public String toString() {
        return "IABConfigurationTCFV2(internalVersion=" + this.internalVersion + ", lastUpdated=" + this.lastUpdated + ", internalFeatures=" + this.internalFeatures + ", internalPurposes=" + this.internalPurposes + ", internalSpecialFeatures=" + this.internalSpecialFeatures + ", internalVendors=" + this.internalVendors + ", internalSpecialPurposes=" + this.internalSpecialPurposes + ", internalDataCategories=" + this.internalDataCategories + ", internalTcfPolicyVersion=" + this.internalTcfPolicyVersion + ')';
    }

    public IABConfigurationTCFV2(Integer num, String str, Map<String, InternalPurpose> map, Map<String, InternalPurpose> map2, Map<String, InternalPurpose> map3, Map<String, InternalVendor> map4, Map<String, InternalPurpose> map5, Map<String, InternalPurpose> map6, Integer num2) {
        this.internalVersion = num;
        this.lastUpdated = str;
        this.internalFeatures = map;
        this.internalPurposes = map2;
        this.internalSpecialFeatures = map3;
        this.internalVendors = map4;
        this.internalSpecialPurposes = map5;
        this.internalDataCategories = map6;
        this.internalTcfPolicyVersion = num2;
        this.version = LazyKt.lazy(new i());
        this.features = LazyKt.lazy(new b());
        this.vendors = LazyKt.lazy(new h());
        this.purposes = LazyKt.lazy(new d());
        this.specialFeatures = LazyKt.lazy(new e());
        this.specialPurposes = LazyKt.lazy(new f());
        this.dataCategories = LazyKt.lazy(new a());
        this.tcfPolicyVersion = LazyKt.lazy(new g());
        this.lastUpdatedDate = LazyKt.lazy(new c());
    }

    @Override // io.didomi.ssl.s6
    public Map<String, Vendor> a() {
        return (Map) this.vendors.getValue();
    }

    @Override // io.didomi.ssl.s6
    public Map<String, InternalPurpose> b() {
        return (Map) this.specialFeatures.getValue();
    }

    @Override // io.didomi.ssl.s6
    public Map<String, InternalPurpose> c() {
        return (Map) this.purposes.getValue();
    }

    @Override // io.didomi.ssl.s6
    public Map<String, InternalPurpose> d() {
        return (Map) this.specialPurposes.getValue();
    }

    @Override // io.didomi.ssl.s6
    public Map<String, InternalPurpose> e() {
        return (Map) this.dataCategories.getValue();
    }

    @Override // io.didomi.ssl.s6
    /* JADX INFO: renamed from: f, reason: from getter */
    public int getMaxVendorId() {
        return this.maxVendorId;
    }

    @Override // io.didomi.ssl.s6
    public void a(int i2) {
        this.maxVendorId = i2;
    }

    public /* synthetic */ IABConfigurationTCFV2(Integer num, String str, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : map, (i2 & 8) != 0 ? null : map2, (i2 & 16) != 0 ? null : map3, (i2 & 32) != 0 ? null : map4, (i2 & 64) != 0 ? null : map5, (i2 & 128) != 0 ? null : map6, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : num2);
    }
}
