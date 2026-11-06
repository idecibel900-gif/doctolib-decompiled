package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LocaleProvider;
import com.revenuecat.purchases.common.caching.DateExtensionsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.InMemoryCachedObject;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "offeringsCachedObject", "Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "Lcom/revenuecat/purchases/Offerings;", "localeProvider", "Lcom/revenuecat/purchases/common/LocaleProvider;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;Lcom/revenuecat/purchases/common/LocaleProvider;)V", "cachedLanguageTags", "", "cachedOfferings", "getCachedOfferings", "()Lcom/revenuecat/purchases/Offerings;", "cachedOfferingsResponse", "Lorg/json/JSONObject;", "getCachedOfferingsResponse", "()Lorg/json/JSONObject;", "cacheOfferings", "", "offerings", "offeringsResponse", "clearCache", "clearInMemoryOfferingsCache", "forceCacheStale", "isOfferingsCacheStale", "", "appInBackground", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingsCache {
    public static final String ORIGINAL_SOURCE_KEY = "rc_original_source";
    private String cachedLanguageTags;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final LocaleProvider localeProvider;
    private final InMemoryCachedObject<Offerings> offeringsCachedObject;

    public OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject<Offerings> offeringsCachedObject, LocaleProvider localeProvider) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(offeringsCachedObject, "offeringsCachedObject");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.deviceCache = deviceCache;
        this.dateProvider = dateProvider;
        this.offeringsCachedObject = offeringsCachedObject;
        this.localeProvider = localeProvider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject inMemoryCachedObject, LocaleProvider localeProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        dateProvider = (i & 2) != 0 ? new DefaultDateProvider() : dateProvider;
        this(deviceCache, dateProvider, (i & 4) != 0 ? new InMemoryCachedObject(null, dateProvider, 1, null) : inMemoryCachedObject, localeProvider);
    }

    public final synchronized void clearCache() {
        this.offeringsCachedObject.clearCache();
        this.deviceCache.clearOfferingsResponseCache$purchases_defaultsBc8Release();
        this.cachedLanguageTags = null;
    }

    public final synchronized void cacheOfferings(Offerings offerings, JSONObject offeringsResponse) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(offeringsResponse, "offeringsResponse");
        JSONObject jSONObjectCopy = JSONObjectExtensionsKt.copy(offeringsResponse, false);
        jSONObjectCopy.put(ORIGINAL_SOURCE_KEY, offerings.getOriginalSource());
        this.offeringsCachedObject.cacheInstance(offerings);
        this.deviceCache.cacheOfferingsResponse$purchases_defaultsBc8Release(jSONObjectCopy);
        this.offeringsCachedObject.updateCacheTimestamp(this.dateProvider.getNow());
        char[] charArray = this.localeProvider.getCurrentLocalesLanguageTags().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        this.cachedLanguageTags = new String(charArray);
    }

    public final synchronized Offerings getCachedOfferings() {
        return this.offeringsCachedObject.getCachedInstance();
    }

    public final synchronized boolean isOfferingsCacheStale(boolean appInBackground) {
        return DateExtensionsKt.isCacheStale(this.offeringsCachedObject.getLastUpdatedAt(), appInBackground, this.dateProvider) || !Intrinsics.areEqual(this.cachedLanguageTags, this.localeProvider.getCurrentLocalesLanguageTags());
    }

    public final synchronized void clearInMemoryOfferingsCache() {
        this.offeringsCachedObject.clearCache();
        this.cachedLanguageTags = null;
    }

    public final synchronized void forceCacheStale() {
        this.offeringsCachedObject.clearCacheTimestamp();
        this.cachedLanguageTags = null;
    }

    public final synchronized JSONObject getCachedOfferingsResponse() {
        return this.deviceCache.getOfferingsResponseCache$purchases_defaultsBc8Release();
    }
}
