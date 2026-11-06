package io.didomi.ssl;

import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.models.SpecialFeature;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0012R(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/kb;", "", "", "", "e", "()Ljava/util/Map;", "setIabPurposeIdsToDidomi", "(Ljava/util/Map;)V", "iabPurposeIdsToDidomi", "f", "setDidomiPurposeIdsToIab", "didomiPurposeIdsToIab", "", "Lio/didomi/sdk/Purpose;", "c", "()Ljava/util/List;", Didomi.VIEW_PURPOSES, "Lio/didomi/sdk/Vendor;", "a", Didomi.VIEW_VENDORS, "Lio/didomi/sdk/models/SpecialFeature;", "b", "specialFeatures", "Lio/didomi/sdk/kb$a;", "g", "()Lio/didomi/sdk/kb$a;", "languages", "d", "gdprCountryCodes", "android_release"}, k = 1, mv = {1, 8, 0})
public interface kb {

    /* JADX INFO: renamed from: io.didomi.sdk.kb$a, reason: from toString */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u000b\b\u0097\b\u0018\u00002\u00020\u0001BM\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0017¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006\""}, d2 = {"Lio/didomi/sdk/kb$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "setAvailable", "(Ljava/util/Set;)V", "available", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setDefaultLanguage", "(Ljava/lang/String;)V", "defaultLanguage", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setDefaultCountries", "(Ljava/util/Map;)V", "defaultCountries", "d", "setFallbackCodes", "fallbackCodes", "<init>", "(Ljava/util/Set;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static /* data */ class Languages {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        @SerializedName("available")
        private Set<String> available;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @SerializedName("default")
        private String defaultLanguage;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        @SerializedName("defaultCountries")
        private Map<String, String> defaultCountries;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        @SerializedName("fallbackCodes")
        private Map<String, String> fallbackCodes;

        public Languages() {
            this(null, null, null, null, 15, null);
        }

        public Set<String> a() {
            return this.available;
        }

        public Map<String, String> b() {
            return this.defaultCountries;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public String getDefaultLanguage() {
            return this.defaultLanguage;
        }

        public Map<String, String> d() {
            return this.fallbackCodes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Languages)) {
                return false;
            }
            Languages languages = (Languages) other;
            return Intrinsics.areEqual(a(), languages.a()) && Intrinsics.areEqual(getDefaultLanguage(), languages.getDefaultLanguage()) && Intrinsics.areEqual(b(), languages.b()) && Intrinsics.areEqual(d(), languages.d());
        }

        public int hashCode() {
            return (((((a().hashCode() * 31) + getDefaultLanguage().hashCode()) * 31) + b().hashCode()) * 31) + d().hashCode();
        }

        public String toString() {
            return "Languages(available=" + a() + ", defaultLanguage=" + getDefaultLanguage() + ", defaultCountries=" + b() + ", fallbackCodes=" + d() + ')';
        }

        public Languages(Set<String> available, String defaultLanguage, Map<String, String> defaultCountries, Map<String, String> fallbackCodes) {
            Intrinsics.checkNotNullParameter(available, "available");
            Intrinsics.checkNotNullParameter(defaultLanguage, "defaultLanguage");
            Intrinsics.checkNotNullParameter(defaultCountries, "defaultCountries");
            Intrinsics.checkNotNullParameter(fallbackCodes, "fallbackCodes");
            this.available = available;
            this.defaultLanguage = defaultLanguage;
            this.defaultCountries = defaultCountries;
            this.fallbackCodes = fallbackCodes;
        }

        public /* synthetic */ Languages(Set set, String str, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? "en" : str, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2);
        }
    }

    List<Vendor> a();

    List<SpecialFeature> b();

    List<Purpose> c();

    List<String> d();

    Map<String, String> e();

    Map<String, String> f();

    Languages g();
}
