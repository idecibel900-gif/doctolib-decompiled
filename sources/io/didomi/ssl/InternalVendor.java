package io.didomi.ssl;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.VendorNamespaces;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: renamed from: io.didomi.sdk.g7, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001e(B¡\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0004\bE\u0010FJª\u0002\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010 \u001a\u00020\u0002HÖ\u0001J\t\u0010\"\u001a\u00020!HÖ\u0001J\u0013\u0010$\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u00105\u001a\u0004\b4\u00107R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\b8\u00107R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b9\u00107R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u00105\u001a\u0004\b0\u00107R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00105\u001a\u0004\b:\u00107R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010;\u001a\u0004\b\u001e\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b,\u0010'R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010@\u001a\u0004\b(\u0010AR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010B\u001a\u0004\b*\u0010CR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u00105\u001a\u0004\bD\u00107R\u001f\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b>\u00105\u001a\u0004\b.\u00107¨\u0006G"}, d2 = {"Lio/didomi/sdk/g7;", "", "", DiagnosticsEntry.ID_KEY, "iabId", "name", "privacyPolicyUrl", "namespace", "Lio/didomi/sdk/models/VendorNamespaces;", "namespaces", "", "purposeIds", "", "flexiblePurposeIds", "specialPurposeIds", "legIntPurposeIds", "featureIds", "specialFeatureIds", "", "cookieMaxAgeSeconds", "", "usesNonCookieAccess", "deviceStorageDisclosureUrl", "", "dataDeclaration", "Lio/didomi/sdk/g7$a;", "dataRetention", "Lio/didomi/sdk/g7$b;", "urls", "essentialPurposeIds", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/models/VendorNamespaces;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Set;Lio/didomi/sdk/g7$a;Ljava/util/List;Ljava/util/List;)Lio/didomi/sdk/g7;", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "b", "h", "c", "k", "d", "n", "e", "l", "f", "Lio/didomi/sdk/models/VendorNamespaces;", "m", "()Lio/didomi/sdk/models/VendorNamespaces;", "g", "Ljava/util/List;", "o", "()Ljava/util/List;", "q", "j", "p", "Ljava/lang/Long;", "()Ljava/lang/Long;", "Ljava/lang/Boolean;", "s", "()Ljava/lang/Boolean;", "Ljava/util/Set;", "()Ljava/util/Set;", "Lio/didomi/sdk/g7$a;", "()Lio/didomi/sdk/g7$a;", "r", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/models/VendorNamespaces;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Set;Lio/didomi/sdk/g7$a;Ljava/util/List;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class InternalVendor {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("iabId")
    private final String iabId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("name")
    private final String name;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("policyUrl")
    private final String privacyPolicyUrl;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("namespace")
    private final String namespace;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @SerializedName("namespaces")
    private final VendorNamespaces namespaces;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    @SerializedName(alternate = {"purposeIds"}, value = Didomi.VIEW_PURPOSES)
    private final List<String> purposeIds;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    @SerializedName("flexiblePurposes")
    private final List<String> flexiblePurposeIds;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    @SerializedName("specialPurposes")
    private final List<String> specialPurposeIds;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    @SerializedName(alternate = {"legIntPurposeIds"}, value = "legIntPurposes")
    private final List<String> legIntPurposeIds;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    @SerializedName("features")
    private final List<String> featureIds;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
    @SerializedName("specialFeatures")
    private final List<String> specialFeatureIds;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
    @SerializedName("cookieMaxAgeSeconds")
    private final Long cookieMaxAgeSeconds;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
    @SerializedName("usesNonCookieAccess")
    private final Boolean usesNonCookieAccess;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata and from toString */
    @SerializedName("deviceStorageDisclosureUrl")
    private final String deviceStorageDisclosureUrl;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata and from toString */
    @SerializedName("dataDeclaration")
    private final Set<String> dataDeclaration;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata and from toString */
    @SerializedName("dataRetention")
    private final DataRetention dataRetention;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata and from toString */
    @SerializedName("urls")
    private final List<Url> urls;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata and from toString */
    private final transient List<String> essentialPurposeIds;

    /* JADX INFO: renamed from: io.didomi.sdk.g7$a, reason: from toString */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/g7$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "stdRetention", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", Didomi.VIEW_PURPOSES, "specialPurposes", "<init>", "(Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class DataRetention {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("stdRetention")
        private final Integer stdRetention;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName(Didomi.VIEW_PURPOSES)
        private final Map<String, Integer> purposes;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("specialPurposes")
        private final Map<String, Integer> specialPurposes;

        public DataRetention() {
            this(null, null, null, 7, null);
        }

        public final Map<String, Integer> a() {
            return this.purposes;
        }

        public final Map<String, Integer> b() {
            return this.specialPurposes;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Integer getStdRetention() {
            return this.stdRetention;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataRetention)) {
                return false;
            }
            DataRetention dataRetention = (DataRetention) other;
            return Intrinsics.areEqual(this.stdRetention, dataRetention.stdRetention) && Intrinsics.areEqual(this.purposes, dataRetention.purposes) && Intrinsics.areEqual(this.specialPurposes, dataRetention.specialPurposes);
        }

        public int hashCode() {
            Integer num = this.stdRetention;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Map<String, Integer> map = this.purposes;
            int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
            Map<String, Integer> map2 = this.specialPurposes;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            return "DataRetention(stdRetention=" + this.stdRetention + ", purposes=" + this.purposes + ", specialPurposes=" + this.specialPurposes + ')';
        }

        public DataRetention(Integer num, Map<String, Integer> map, Map<String, Integer> map2) {
            this.stdRetention = num;
            this.purposes = map;
            this.specialPurposes = map2;
        }

        public /* synthetic */ DataRetention(Integer num, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.g7$b, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/g7$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "langId", "b", "c", "privacy", "legIntClaim", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Url {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("langId")
        private final String langId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("privacy")
        private final String privacy;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("legIntClaim")
        private final String legIntClaim;

        public Url() {
            this(null, null, null, 7, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getLangId() {
            return this.langId;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getLegIntClaim() {
            return this.legIntClaim;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getPrivacy() {
            return this.privacy;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            Url url = (Url) other;
            return Intrinsics.areEqual(this.langId, url.langId) && Intrinsics.areEqual(this.privacy, url.privacy) && Intrinsics.areEqual(this.legIntClaim, url.legIntClaim);
        }

        public int hashCode() {
            String str = this.langId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.privacy;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.legIntClaim;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Url(langId=" + this.langId + ", privacy=" + this.privacy + ", legIntClaim=" + this.legIntClaim + ')';
        }

        public Url(String str, String str2, String str3) {
            this.langId = str;
            this.privacy = str2;
            this.legIntClaim = str3;
        }

        public /* synthetic */ Url(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    public InternalVendor() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public final InternalVendor a(String id, String iabId, String name, String privacyPolicyUrl, String namespace, VendorNamespaces namespaces, List<String> purposeIds, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> legIntPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long cookieMaxAgeSeconds, Boolean usesNonCookieAccess, String deviceStorageDisclosureUrl, Set<String> dataDeclaration, DataRetention dataRetention, List<Url> urls, List<String> essentialPurposeIds) {
        return new InternalVendor(id, iabId, name, privacyPolicyUrl, namespace, namespaces, purposeIds, flexiblePurposeIds, specialPurposeIds, legIntPurposeIds, featureIds, specialFeatureIds, cookieMaxAgeSeconds, usesNonCookieAccess, deviceStorageDisclosureUrl, dataDeclaration, dataRetention, urls, essentialPurposeIds);
    }

    public final Set<String> b() {
        return this.dataDeclaration;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final DataRetention getDataRetention() {
        return this.dataRetention;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDeviceStorageDisclosureUrl() {
        return this.deviceStorageDisclosureUrl;
    }

    public final List<String> e() {
        return this.essentialPurposeIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternalVendor)) {
            return false;
        }
        InternalVendor internalVendor = (InternalVendor) other;
        return Intrinsics.areEqual(this.id, internalVendor.id) && Intrinsics.areEqual(this.iabId, internalVendor.iabId) && Intrinsics.areEqual(this.name, internalVendor.name) && Intrinsics.areEqual(this.privacyPolicyUrl, internalVendor.privacyPolicyUrl) && Intrinsics.areEqual(this.namespace, internalVendor.namespace) && Intrinsics.areEqual(this.namespaces, internalVendor.namespaces) && Intrinsics.areEqual(this.purposeIds, internalVendor.purposeIds) && Intrinsics.areEqual(this.flexiblePurposeIds, internalVendor.flexiblePurposeIds) && Intrinsics.areEqual(this.specialPurposeIds, internalVendor.specialPurposeIds) && Intrinsics.areEqual(this.legIntPurposeIds, internalVendor.legIntPurposeIds) && Intrinsics.areEqual(this.featureIds, internalVendor.featureIds) && Intrinsics.areEqual(this.specialFeatureIds, internalVendor.specialFeatureIds) && Intrinsics.areEqual(this.cookieMaxAgeSeconds, internalVendor.cookieMaxAgeSeconds) && Intrinsics.areEqual(this.usesNonCookieAccess, internalVendor.usesNonCookieAccess) && Intrinsics.areEqual(this.deviceStorageDisclosureUrl, internalVendor.deviceStorageDisclosureUrl) && Intrinsics.areEqual(this.dataDeclaration, internalVendor.dataDeclaration) && Intrinsics.areEqual(this.dataRetention, internalVendor.dataRetention) && Intrinsics.areEqual(this.urls, internalVendor.urls) && Intrinsics.areEqual(this.essentialPurposeIds, internalVendor.essentialPurposeIds);
    }

    public final List<String> f() {
        return this.featureIds;
    }

    public final List<String> g() {
        return this.flexiblePurposeIds;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getIabId() {
        return this.iabId;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iabId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.privacyPolicyUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.namespace;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        VendorNamespaces vendorNamespaces = this.namespaces;
        int iHashCode6 = (iHashCode5 + (vendorNamespaces == null ? 0 : vendorNamespaces.hashCode())) * 31;
        List<String> list = this.purposeIds;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.flexiblePurposeIds;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.specialPurposeIds;
        int iHashCode9 = (iHashCode8 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.legIntPurposeIds;
        int iHashCode10 = (iHashCode9 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.featureIds;
        int iHashCode11 = (iHashCode10 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<String> list6 = this.specialFeatureIds;
        int iHashCode12 = (iHashCode11 + (list6 == null ? 0 : list6.hashCode())) * 31;
        Long l = this.cookieMaxAgeSeconds;
        int iHashCode13 = (iHashCode12 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.usesNonCookieAccess;
        int iHashCode14 = (iHashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.deviceStorageDisclosureUrl;
        int iHashCode15 = (iHashCode14 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Set<String> set = this.dataDeclaration;
        int iHashCode16 = (iHashCode15 + (set == null ? 0 : set.hashCode())) * 31;
        DataRetention dataRetention = this.dataRetention;
        int iHashCode17 = (iHashCode16 + (dataRetention == null ? 0 : dataRetention.hashCode())) * 31;
        List<Url> list7 = this.urls;
        int iHashCode18 = (iHashCode17 + (list7 == null ? 0 : list7.hashCode())) * 31;
        List<String> list8 = this.essentialPurposeIds;
        return iHashCode18 + (list8 != null ? list8.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> j() {
        return this.legIntPurposeIds;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final VendorNamespaces getNamespaces() {
        return this.namespaces;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final List<String> o() {
        return this.purposeIds;
    }

    public final List<String> p() {
        return this.specialFeatureIds;
    }

    public final List<String> q() {
        return this.specialPurposeIds;
    }

    public final List<Url> r() {
        return this.urls;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final Boolean getUsesNonCookieAccess() {
        return this.usesNonCookieAccess;
    }

    public String toString() {
        return "InternalVendor(id=" + this.id + ", iabId=" + this.iabId + ", name=" + this.name + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ", namespace=" + this.namespace + ", namespaces=" + this.namespaces + ", purposeIds=" + this.purposeIds + ", flexiblePurposeIds=" + this.flexiblePurposeIds + ", specialPurposeIds=" + this.specialPurposeIds + ", legIntPurposeIds=" + this.legIntPurposeIds + ", featureIds=" + this.featureIds + ", specialFeatureIds=" + this.specialFeatureIds + ", cookieMaxAgeSeconds=" + this.cookieMaxAgeSeconds + ", usesNonCookieAccess=" + this.usesNonCookieAccess + ", deviceStorageDisclosureUrl=" + this.deviceStorageDisclosureUrl + ", dataDeclaration=" + this.dataDeclaration + ", dataRetention=" + this.dataRetention + ", urls=" + this.urls + ", essentialPurposeIds=" + this.essentialPurposeIds + ')';
    }

    public InternalVendor(String str, String str2, String str3, String str4, String str5, VendorNamespaces vendorNamespaces, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, Long l, Boolean bool, String str6, Set<String> set, DataRetention dataRetention, List<Url> list7, List<String> list8) {
        this.id = str;
        this.iabId = str2;
        this.name = str3;
        this.privacyPolicyUrl = str4;
        this.namespace = str5;
        this.namespaces = vendorNamespaces;
        this.purposeIds = list;
        this.flexiblePurposeIds = list2;
        this.specialPurposeIds = list3;
        this.legIntPurposeIds = list4;
        this.featureIds = list5;
        this.specialFeatureIds = list6;
        this.cookieMaxAgeSeconds = l;
        this.usesNonCookieAccess = bool;
        this.deviceStorageDisclosureUrl = str6;
        this.dataDeclaration = set;
        this.dataRetention = dataRetention;
        this.urls = list7;
        this.essentialPurposeIds = list8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InternalVendor a(InternalVendor internalVendor, String str, String str2, String str3, String str4, String str5, VendorNamespaces vendorNamespaces, List list, List list2, List list3, List list4, List list5, List list6, Long l, Boolean bool, String str6, Set set, DataRetention dataRetention, List list7, List list8, int i, Object obj) {
        List list9;
        List list10;
        String str7 = (i & 1) != 0 ? internalVendor.id : str;
        String str8 = (i & 2) != 0 ? internalVendor.iabId : str2;
        String str9 = (i & 4) != 0 ? internalVendor.name : str3;
        String str10 = (i & 8) != 0 ? internalVendor.privacyPolicyUrl : str4;
        String str11 = (i & 16) != 0 ? internalVendor.namespace : str5;
        VendorNamespaces vendorNamespaces2 = (i & 32) != 0 ? internalVendor.namespaces : vendorNamespaces;
        List list11 = (i & 64) != 0 ? internalVendor.purposeIds : list;
        List list12 = (i & 128) != 0 ? internalVendor.flexiblePurposeIds : list2;
        List list13 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? internalVendor.specialPurposeIds : list3;
        List list14 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? internalVendor.legIntPurposeIds : list4;
        List list15 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? internalVendor.featureIds : list5;
        List list16 = (i & 2048) != 0 ? internalVendor.specialFeatureIds : list6;
        Long l2 = (i & 4096) != 0 ? internalVendor.cookieMaxAgeSeconds : l;
        Boolean bool2 = (i & 8192) != 0 ? internalVendor.usesNonCookieAccess : bool;
        String str12 = str7;
        String str13 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? internalVendor.deviceStorageDisclosureUrl : str6;
        Set set2 = (i & 32768) != 0 ? internalVendor.dataDeclaration : set;
        DataRetention dataRetention2 = (i & 65536) != 0 ? internalVendor.dataRetention : dataRetention;
        List list17 = (i & 131072) != 0 ? internalVendor.urls : list7;
        if ((i & 262144) != 0) {
            list10 = list17;
            list9 = internalVendor.essentialPurposeIds;
        } else {
            list9 = list8;
            list10 = list17;
        }
        return internalVendor.a(str12, str8, str9, str10, str11, vendorNamespaces2, list11, list12, list13, list14, list15, list16, l2, bool2, str13, set2, dataRetention2, list10, list9);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getCookieMaxAgeSeconds() {
        return this.cookieMaxAgeSeconds;
    }

    public /* synthetic */ InternalVendor(String str, String str2, String str3, String str4, String str5, VendorNamespaces vendorNamespaces, List list, List list2, List list3, List list4, List list5, List list6, Long l, Boolean bool, String str6, Set set, DataRetention dataRetention, List list7, List list8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : vendorNamespaces, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : list2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : list3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : list4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : list5, (i & 2048) != 0 ? null : list6, (i & 4096) != 0 ? null : l, (i & 8192) != 0 ? null : bool, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str6, (i & 32768) != 0 ? null : set, (i & 65536) != 0 ? null : dataRetention, (i & 131072) != 0 ? null : list7, (i & 262144) != 0 ? null : list8);
    }
}
