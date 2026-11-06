package com.revenuecat.purchases.common.offlineentitlements;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import com.revenuecat.purchases.common.HTTPResponseOriginalSourceKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\r\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "", "mappings", "", "", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "originalSource", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "loadedFromCache", "", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;Z)V", "getLoadedFromCache", "()Z", "getMappings", "()Ljava/util/Map;", "getOriginalSource", "()Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toJson$purchases_defaultsBc8Release", "toString", "Companion", "Mapping", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProductEntitlementMapping {
    private static final String BASE_PLAN_ID_KEY = "base_plan_id";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENTITLEMENTS_KEY = "entitlements";
    private static final String ORIGINAL_SOURCE_KEY = "rc_original_source";
    private static final String PRODUCT_ENTITLEMENT_MAPPING_KEY = "product_entitlement_mapping";
    private static final String PRODUCT_ID_KEY = "product_identifier";
    private final boolean loadedFromCache;
    private final Map<String, Mapping> mappings;
    private final HTTPResponseOriginalSource originalSource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductEntitlementMapping copy$default(ProductEntitlementMapping productEntitlementMapping, Map map, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            map = productEntitlementMapping.mappings;
        }
        if ((i & 2) != 0) {
            hTTPResponseOriginalSource = productEntitlementMapping.originalSource;
        }
        if ((i & 4) != 0) {
            z = productEntitlementMapping.loadedFromCache;
        }
        return productEntitlementMapping.copy(map, hTTPResponseOriginalSource, z);
    }

    public final Map<String, Mapping> component1() {
        return this.mappings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HTTPResponseOriginalSource getOriginalSource() {
        return this.originalSource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final ProductEntitlementMapping copy(Map<String, Mapping> mappings, HTTPResponseOriginalSource originalSource, boolean loadedFromCache) {
        Intrinsics.checkNotNullParameter(mappings, "mappings");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        return new ProductEntitlementMapping(mappings, originalSource, loadedFromCache);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductEntitlementMapping)) {
            return false;
        }
        ProductEntitlementMapping productEntitlementMapping = (ProductEntitlementMapping) other;
        return Intrinsics.areEqual(this.mappings, productEntitlementMapping.mappings) && this.originalSource == productEntitlementMapping.originalSource && this.loadedFromCache == productEntitlementMapping.loadedFromCache;
    }

    public int hashCode() {
        return (((this.mappings.hashCode() * 31) + this.originalSource.hashCode()) * 31) + Boolean.hashCode(this.loadedFromCache);
    }

    public String toString() {
        return "ProductEntitlementMapping(mappings=" + this.mappings + ", originalSource=" + this.originalSource + ", loadedFromCache=" + this.loadedFromCache + ')';
    }

    public ProductEntitlementMapping(Map<String, Mapping> mappings, HTTPResponseOriginalSource originalSource, boolean z) {
        Intrinsics.checkNotNullParameter(mappings, "mappings");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        this.mappings = mappings;
        this.originalSource = originalSource;
        this.loadedFromCache = z;
    }

    public final Map<String, Mapping> getMappings() {
        return this.mappings;
    }

    public /* synthetic */ ProductEntitlementMapping(Map map, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? HTTPResponseOriginalSource.MAIN : hTTPResponseOriginalSource, (i & 4) != 0 ? false : z);
    }

    public final HTTPResponseOriginalSource getOriginalSource() {
        return this.originalSource;
    }

    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Companion;", "", "()V", "BASE_PLAN_ID_KEY", "", "ENTITLEMENTS_KEY", "ORIGINAL_SOURCE_KEY", "PRODUCT_ENTITLEMENT_MAPPING_KEY", "PRODUCT_ID_KEY", "fromJson", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "json", "Lorg/json/JSONObject;", "loadedFromCache", "", "fromJson$purchases_defaultsBc8Release", "fromNetwork", "httpResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "fromNetwork$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ProductEntitlementMapping fromJson$purchases_defaultsBc8Release$default(Companion companion, JSONObject jSONObject, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromJson$purchases_defaultsBc8Release(jSONObject, z);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x009e  */
        public final ProductEntitlementMapping fromJson$purchases_defaultsBc8Release(JSONObject json, boolean loadedFromCache) throws JSONException {
            HTTPResponseOriginalSource hTTPResponseOriginalSourceValueOf;
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject jSONObject = json.getJSONObject(ProductEntitlementMapping.PRODUCT_ENTITLEMENT_MAPPING_KEY);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "productsObject.keys()");
            while (itKeys.hasNext()) {
                String mappingIdentifier = itKeys.next();
                JSONObject productObject = jSONObject.getJSONObject(mappingIdentifier);
                String productIdentifier = productObject.getString("product_identifier");
                Intrinsics.checkNotNullExpressionValue(productObject, "productObject");
                String strOptNullableString = JSONObjectExtensionsKt.optNullableString(productObject, ProductEntitlementMapping.BASE_PLAN_ID_KEY);
                JSONArray jSONArray = productObject.getJSONArray("entitlements");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "entitlementsArray.getString(entitlementIndex)");
                    arrayList.add(string);
                }
                Intrinsics.checkNotNullExpressionValue(mappingIdentifier, "mappingIdentifier");
                Intrinsics.checkNotNullExpressionValue(productIdentifier, "productIdentifier");
                linkedHashMap.put(mappingIdentifier, new Mapping(productIdentifier, strOptNullableString, arrayList));
            }
            String strOptNullableString2 = JSONObjectExtensionsKt.optNullableString(json, "rc_original_source");
            if (strOptNullableString2 != null) {
                try {
                    hTTPResponseOriginalSourceValueOf = HTTPResponseOriginalSource.valueOf(strOptNullableString2);
                } catch (IllegalArgumentException e) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Invalid original source when reading it from JSON: " + strOptNullableString2 + ". Defaulting to MAIN.", e);
                    hTTPResponseOriginalSourceValueOf = null;
                }
                if (hTTPResponseOriginalSourceValueOf == null) {
                    hTTPResponseOriginalSourceValueOf = HTTPResponseOriginalSource.MAIN;
                }
            } else {
                hTTPResponseOriginalSourceValueOf = HTTPResponseOriginalSource.MAIN;
            }
            return new ProductEntitlementMapping(linkedHashMap, hTTPResponseOriginalSourceValueOf, loadedFromCache);
        }

        public final ProductEntitlementMapping fromNetwork$purchases_defaultsBc8Release(JSONObject json, HTTPResult httpResult) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(httpResult, "httpResult");
            JSONObject jsonWithSource = JSONObjectExtensionsKt.copy(json, false).put("rc_original_source", HTTPResponseOriginalSourceKt.getOriginalDataSource(httpResult).name());
            Intrinsics.checkNotNullExpressionValue(jsonWithSource, "jsonWithSource");
            return fromJson$purchases_defaultsBc8Release(jsonWithSource, false);
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "", "productIdentifier", "", "basePlanId", "entitlements", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBasePlanId", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "getProductIdentifier", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Mapping {
        private final String basePlanId;
        private final List<String> entitlements;
        private final String productIdentifier;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Mapping copy$default(Mapping mapping, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mapping.productIdentifier;
            }
            if ((i & 2) != 0) {
                str2 = mapping.basePlanId;
            }
            if ((i & 4) != 0) {
                list = mapping.entitlements;
            }
            return mapping.copy(str, str2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final List<String> component3() {
            return this.entitlements;
        }

        public final Mapping copy(String productIdentifier, String basePlanId, List<String> entitlements) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            return new Mapping(productIdentifier, basePlanId, entitlements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mapping)) {
                return false;
            }
            Mapping mapping = (Mapping) other;
            return Intrinsics.areEqual(this.productIdentifier, mapping.productIdentifier) && Intrinsics.areEqual(this.basePlanId, mapping.basePlanId) && Intrinsics.areEqual(this.entitlements, mapping.entitlements);
        }

        public int hashCode() {
            int iHashCode = this.productIdentifier.hashCode() * 31;
            String str = this.basePlanId;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.entitlements.hashCode();
        }

        public String toString() {
            return "Mapping(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", entitlements=" + this.entitlements + ')';
        }

        public Mapping(String productIdentifier, String str, List<String> entitlements) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            this.productIdentifier = productIdentifier;
            this.basePlanId = str;
            this.entitlements = entitlements;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final List<String> getEntitlements() {
            return this.entitlements;
        }
    }

    public final JSONObject toJson$purchases_defaultsBc8Release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, Mapping> map = this.mappings;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Mapping mapping = (Mapping) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("product_identifier", mapping.getProductIdentifier());
            String basePlanId = mapping.getBasePlanId();
            if (basePlanId != null) {
                jSONObject2.put(BASE_PLAN_ID_KEY, basePlanId);
            }
            jSONObject2.put("entitlements", new JSONArray((Collection) mapping.getEntitlements()));
            linkedHashMap.put(key, jSONObject2);
        }
        jSONObject.put(PRODUCT_ENTITLEMENT_MAPPING_KEY, new JSONObject(linkedHashMap));
        jSONObject.put("rc_original_source", this.originalSource.name());
        return jSONObject;
    }
}
