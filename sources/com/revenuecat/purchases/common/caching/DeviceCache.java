package com.revenuecat.purchases.common.caching;

import android.content.SharedPreferences;
import com.amazon.a.a.o.c.a.b;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.CustomerInfoOriginalSource;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SharedPreferencesManager;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.strings.ReceiptStrings;
import com.revenuecat.purchases.strings.VirtualCurrencyStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b<\b\u0017\u0018\u0000 ±\u00012\u00020\u0001:\u0002±\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00052\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0002\u0010=J\u0015\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\b@J\u001d\u0010>\u001a\u00020A2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010B\u001a\u00020AH\u0000¢\u0006\u0002\b@J\u001d\u0010C\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ\u0015\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bNJ\u001d\u0010O\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u001b\u0010S\u001a\u0002092\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050UH\u0000¢\u0006\u0002\bVJ\r\u0010W\u001a\u000209H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\\J\u001d\u0010[\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0006\u0010]\u001a\u00020AH\u0000¢\u0006\u0002\b\\J\u0015\u0010^\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u000209H\u0000¢\u0006\u0002\baJ\u0015\u0010b\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\bcJ\u001d\u0010b\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0006\u0010]\u001a\u00020AH\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0001¢\u0006\u0002\beJ\u0015\u0010f\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0001¢\u0006\u0002\bgJ\u001b\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00050U2\u0006\u0010i\u001a\u00020\u0005H\u0000¢\u0006\u0002\bjJ'\u0010k\u001a\b\u0012\u0004\u0012\u00020m0l2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020m0-H\u0000¢\u0006\u0002\bnJ\u000f\u0010o\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bpJ\u0017\u0010q\u001a\u0004\u0018\u00010E2\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\brJ\u0017\u0010s\u001a\u0004\u0018\u00010Q2\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020v2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0017\u0010w\u001a\u0004\u0018\u00010I2\u0006\u0010x\u001a\u00020\u0005H\u0010¢\u0006\u0002\byJ\u000f\u0010z\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b{J\u000f\u0010|\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\b}J\u0013\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00050UH\u0000¢\u0006\u0002\b\u007fJ\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010MH\u0000¢\u0006\u0003\b\u0081\u0001J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010vH\u0002J)\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020m0l2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020m0-H\u0000¢\u0006\u0003\b\u0084\u0001J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0015\u0010\u0086\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0-H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020v2\u0006\u0010?\u001a\u00020\u0005H\u0002J \u0010\u0088\u0001\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010\u0089\u0001\u001a\u00020<H\u0000¢\u0006\u0003\b\u008a\u0001J\u000f\u0010\u008b\u0001\u001a\u00020<H\u0000¢\u0006\u0003\b\u008c\u0001J \u0010\u008d\u0001\u001a\u00020<2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010\u0089\u0001\u001a\u00020<H\u0000¢\u0006\u0003\b\u008e\u0001J\u0015\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0-H\u0002J\u0017\u0010\u0090\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u0091\u0001J \u0010\u0092\u0001\u001a\u0002092\u0006\u0010i\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0010¢\u0006\u0003\b\u0094\u0001J\u0017\u0010\u0095\u0001\u001a\u0002092\u0006\u0010i\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u0096\u0001J#\u0010\u0097\u0001\u001a\u0002092\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020m0-H\u0000¢\u0006\u0003\b\u0098\u0001J\u001e\u0010\u0099\u0001\u001a\u0002092\u0013\u0010\u009a\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0-H\u0002J \u0010\u009b\u0001\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020vH\u0001¢\u0006\u0003\b\u009d\u0001J\u0017\u0010\u009e\u0001\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u009f\u0001J\u0012\u0010 \u0001\u001a\u0002092\u0007\u0010\u009c\u0001\u001a\u00020vH\u0002J\u000f\u0010¡\u0001\u001a\u000209H\u0001¢\u0006\u0003\b¢\u0001J\u0018\u0010£\u0001\u001a\u0002092\u0007\u0010¤\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\b¥\u0001J\u001a\u0010¦\u0001\u001a\u0002092\u0006\u0010?\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020vH\u0002J\u0011\u0010§\u0001\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0002J\u000f\u0010¨\u0001\u001a\u00020AH\u0000¢\u0006\u0003\b©\u0001J\u0017\u0010ª\u0001\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0001¢\u0006\u0003\b«\u0001J\u0017\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0001¢\u0006\u0003\b\u00ad\u0001J\r\u0010®\u0001\u001a\u00020A*\u00020AH\u0002J\r\u0010¯\u0001\u001a\u00020A*\u00020AH\u0002J\u0014\u0010^\u001a\u00020A*\u00020A2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0014\u0010b\u001a\u00020A*\u00020A2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0015\u0010°\u0001\u001a\u00020A*\u00020A2\u0006\u0010?\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\u00020\u00058@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u001b\u0010\u0015\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0018\u001a\u00020\u00058@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u000bR\u001b\u0010\u001c\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u001f\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b#\u0010\u000bR\u001b\u0010%\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b&\u0010\u000bR!\u0010(\u001a\u00020\u00058@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b+\u0010\r\u0012\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u000bR\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b0\u0010\u000bR\u001b\u00102\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b3\u0010\u000bR\u001b\u00105\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\r\u001a\u0004\b6\u0010\u000b¨\u0006²\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "preferences", "Landroid/content/SharedPreferences;", "apiKey", "", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;)V", "apiKeyPrefix", "getApiKeyPrefix", "()Ljava/lang/String;", "apiKeyPrefix$delegate", "Lkotlin/Lazy;", "appUserIDCacheKey", "getAppUserIDCacheKey$purchases_defaultsBc8Release$annotations", "()V", "getAppUserIDCacheKey$purchases_defaultsBc8Release", "appUserIDCacheKey$delegate", "attributionCacheKey", "getAttributionCacheKey$purchases_defaultsBc8Release", "customerInfoCachesLastUpdatedCacheBaseKey", "getCustomerInfoCachesLastUpdatedCacheBaseKey", "customerInfoCachesLastUpdatedCacheBaseKey$delegate", "legacyAppUserIDCacheKey", "getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release$annotations", "getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release", "legacyAppUserIDCacheKey$delegate", "legacyTokensCacheKey", "getLegacyTokensCacheKey$purchases_defaultsBc8Release", "legacyTokensCacheKey$delegate", "offeringsResponseCacheKey", "getOfferingsResponseCacheKey", "offeringsResponseCacheKey$delegate", "productEntitlementMappingCacheKey", "getProductEntitlementMappingCacheKey", "productEntitlementMappingCacheKey$delegate", "productEntitlementMappingLastUpdatedCacheKey", "getProductEntitlementMappingLastUpdatedCacheKey", "productEntitlementMappingLastUpdatedCacheKey$delegate", "storefrontCacheKey", "getStorefrontCacheKey$purchases_defaultsBc8Release$annotations", "getStorefrontCacheKey$purchases_defaultsBc8Release", "storefrontCacheKey$delegate", "tokenMapCache", "", "Lcom/revenuecat/purchases/common/caching/TokenCacheEntry;", "tokensCacheKey", "getTokensCacheKey$purchases_defaultsBc8Release", "tokensCacheKey$delegate", "virtualCurrenciesCacheBaseKey", "getVirtualCurrenciesCacheBaseKey", "virtualCurrenciesCacheBaseKey$delegate", "virtualCurrenciesLastUpdatedCacheBaseKey", "getVirtualCurrenciesLastUpdatedCacheBaseKey", "virtualCurrenciesLastUpdatedCacheBaseKey$delegate", "addSuccessfullyPostedToken", "", "token", "isAutoRenewing", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "cacheAppUserID", "appUserID", "cacheAppUserID$purchases_defaultsBc8Release", "Landroid/content/SharedPreferences$Editor;", "cacheEditor", "cacheCustomerInfo", "info", "Lcom/revenuecat/purchases/CustomerInfo;", "cacheCustomerInfo$purchases_defaultsBc8Release", "cacheOfferingsResponse", "offeringsResponse", "Lorg/json/JSONObject;", "cacheOfferingsResponse$purchases_defaultsBc8Release", "cacheProductEntitlementMapping", "productEntitlementMapping", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "cacheProductEntitlementMapping$purchases_defaultsBc8Release", "cacheVirtualCurrencies", "virtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "cacheVirtualCurrencies$purchases_defaultsBc8Release", "cleanPreviouslySentTokens", "hashedTokens", "", "cleanPreviouslySentTokens$purchases_defaultsBc8Release", "cleanupOldAttributionData", "cleanupOldAttributionData$purchases_defaultsBc8Release", "clearCachesForAppUserID", "clearCachesForAppUserID$purchases_defaultsBc8Release", "clearCustomerInfoCache", "clearCustomerInfoCache$purchases_defaultsBc8Release", "editor", "clearCustomerInfoCacheTimestamp", "clearCustomerInfoCacheTimestamp$purchases_defaultsBc8Release", "clearOfferingsResponseCache", "clearOfferingsResponseCache$purchases_defaultsBc8Release", "clearVirtualCurrenciesCache", "clearVirtualCurrenciesCache$purchases_defaultsBc8Release", "customerInfoCacheKey", "customerInfoCacheKey$purchases_defaultsBc8Release", "customerInfoLastUpdatedCacheKey", "customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release", "findKeysThatStartWith", "cacheKey", "findKeysThatStartWith$purchases_defaultsBc8Release", "getActivePurchasesNotInCache", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "getActivePurchasesNotInCache$purchases_defaultsBc8Release", "getCachedAppUserID", "getCachedAppUserID$purchases_defaultsBc8Release", "getCachedCustomerInfo", "getCachedCustomerInfo$purchases_defaultsBc8Release", "getCachedVirtualCurrencies", "getCachedVirtualCurrencies$purchases_defaultsBc8Release", "getCustomerInfoCachesLastUpdated", "Ljava/util/Date;", "getJSONObjectOrNull", SubscriberAttributeKt.JSON_NAME_KEY, "getJSONObjectOrNull$purchases_defaultsBc8Release", "getLegacyCachedAppUserID", "getLegacyCachedAppUserID$purchases_defaultsBc8Release", "getOfferingsResponseCache", "getOfferingsResponseCache$purchases_defaultsBc8Release", "getPreviouslySentHashedTokens", "getPreviouslySentHashedTokens$purchases_defaultsBc8Release", "getProductEntitlementMapping", "getProductEntitlementMapping$purchases_defaultsBc8Release", "getProductEntitlementMappingLastUpdated", "getPurchasesWithAutoRenewingChange", "getPurchasesWithAutoRenewingChange$purchases_defaultsBc8Release", "getStorefront", "getTokenMap", "getVirtualCurrenciesCacheLastUpdated", "isCustomerInfoCacheStale", "appInBackground", "isCustomerInfoCacheStale$purchases_defaultsBc8Release", "isProductEntitlementMappingCacheStale", "isProductEntitlementMappingCacheStale$purchases_defaultsBc8Release", "isVirtualCurrenciesCacheStale", "isVirtualCurrenciesCacheStale$purchases_defaultsBc8Release", "loadTokenMapFromPreferences", "newKey", "newKey$purchases_defaultsBc8Release", "putString", "value", "putString$purchases_defaultsBc8Release", "remove", "remove$purchases_defaultsBc8Release", "saveAutoRenewingStatus", "saveAutoRenewingStatus$purchases_defaultsBc8Release", "saveTokenMap", "tokenMap", "setCustomerInfoCacheTimestamp", "date", "setCustomerInfoCacheTimestamp$purchases_defaultsBc8Release", "setCustomerInfoCacheTimestampToNow", "setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release", "setProductEntitlementMappingCacheTimestamp", "setProductEntitlementMappingCacheTimestampToNow", "setProductEntitlementMappingCacheTimestampToNow$purchases_defaultsBc8Release", "setStorefront", "countryCode", "setStorefront$purchases_defaultsBc8Release", "setVirtualCurrenciesCacheTimestamp", "setVirtualCurrenciesCacheTimestampToNow", "startEditing", "startEditing$purchases_defaultsBc8Release", "virtualCurrenciesCacheKey", "virtualCurrenciesCacheKey$purchases_defaultsBc8Release", "virtualCurrenciesLastUpdatedCacheKey", "virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release", "clearAppUserID", "clearCustomerInfo", "clearVirtualCurrenciesCacheTimestamp", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_ORIGINAL_SOURCE_KEY = "customer_info_original_source";
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    private static final Companion Companion = new Companion(null);
    private final String apiKey;

    /* JADX INFO: renamed from: apiKeyPrefix$delegate, reason: from kotlin metadata */
    private final Lazy apiKeyPrefix;

    /* JADX INFO: renamed from: appUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy appUserIDCacheKey;
    private final String attributionCacheKey;

    /* JADX INFO: renamed from: customerInfoCachesLastUpdatedCacheBaseKey$delegate, reason: from kotlin metadata */
    private final Lazy customerInfoCachesLastUpdatedCacheBaseKey;
    private final DateProvider dateProvider;

    /* JADX INFO: renamed from: legacyAppUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy legacyAppUserIDCacheKey;

    /* JADX INFO: renamed from: legacyTokensCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy legacyTokensCacheKey;

    /* JADX INFO: renamed from: offeringsResponseCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy offeringsResponseCacheKey;
    private final SharedPreferences preferences;

    /* JADX INFO: renamed from: productEntitlementMappingCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy productEntitlementMappingCacheKey;

    /* JADX INFO: renamed from: productEntitlementMappingLastUpdatedCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy productEntitlementMappingLastUpdatedCacheKey;

    /* JADX INFO: renamed from: storefrontCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy storefrontCacheKey;
    private Map<String, TokenCacheEntry> tokenMapCache;

    /* JADX INFO: renamed from: tokensCacheKey$delegate, reason: from kotlin metadata */
    private final Lazy tokensCacheKey;

    /* JADX INFO: renamed from: virtualCurrenciesCacheBaseKey$delegate, reason: from kotlin metadata */
    private final Lazy virtualCurrenciesCacheBaseKey;

    /* JADX INFO: renamed from: virtualCurrenciesLastUpdatedCacheBaseKey$delegate, reason: from kotlin metadata */
    private final Lazy virtualCurrenciesLastUpdatedCacheBaseKey;

    public static /* synthetic */ void getAppUserIDCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getStorefrontCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    public final synchronized void setStorefront$purchases_defaultsBc8Release(String countryCode) {
        try {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{countryCode}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.v(str, str2);
            }
            this.preferences.edit().putString(getStorefrontCacheKey$purchases_defaultsBc8Release(), countryCode).apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public DeviceCache(SharedPreferences preferences, String apiKey, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.preferences = preferences;
        this.apiKey = apiKey;
        this.dateProvider = dateProvider;
        this.apiKeyPrefix = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$apiKeyPrefix$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SharedPreferencesManager.SHARED_PREFERENCES_PREFIX + this.this$0.apiKey;
            }
        });
        this.legacyAppUserIDCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$legacyAppUserIDCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix();
            }
        });
        this.appUserIDCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$appUserIDCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".new";
            }
        });
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.legacyTokensCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$legacyTokensCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".tokens";
            }
        });
        this.tokensCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$tokensCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".tokensV2";
            }
        });
        this.storefrontCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$storefrontCacheKey$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "storefrontCacheKey";
            }
        });
        this.productEntitlementMappingCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".productEntitlementMapping";
            }
        });
        this.productEntitlementMappingLastUpdatedCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".productEntitlementMappingLastUpdated";
            }
        });
        this.customerInfoCachesLastUpdatedCacheBaseKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".purchaserInfoLastUpdated";
            }
        });
        this.virtualCurrenciesCacheBaseKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$virtualCurrenciesCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".virtualCurrencies";
            }
        });
        this.virtualCurrenciesLastUpdatedCacheBaseKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$virtualCurrenciesLastUpdatedCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".virtualCurrenciesLastUpdated";
            }
        });
        this.offeringsResponseCacheKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$offeringsResponseCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".offeringsResponse";
            }
        });
    }

    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, str, (i & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache$Companion;", "", "()V", "CUSTOMER_INFO_ORIGINAL_SOURCE_KEY", "", "CUSTOMER_INFO_REQUEST_DATE_KEY", "CUSTOMER_INFO_SCHEMA_VERSION_KEY", "CUSTOMER_INFO_VERIFICATION_RESULT_KEY", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix.getValue();
    }

    public final String getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release() {
        return (String) this.legacyAppUserIDCacheKey.getValue();
    }

    public final String getAppUserIDCacheKey$purchases_defaultsBc8Release() {
        return (String) this.appUserIDCacheKey.getValue();
    }

    /* JADX INFO: renamed from: getAttributionCacheKey$purchases_defaultsBc8Release, reason: from getter */
    public final String getAttributionCacheKey() {
        return this.attributionCacheKey;
    }

    public final String getLegacyTokensCacheKey$purchases_defaultsBc8Release() {
        return (String) this.legacyTokensCacheKey.getValue();
    }

    public final String getTokensCacheKey$purchases_defaultsBc8Release() {
        return (String) this.tokensCacheKey.getValue();
    }

    public final String getStorefrontCacheKey$purchases_defaultsBc8Release() {
        return (String) this.storefrontCacheKey.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey.getValue();
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey.getValue();
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey.getValue();
    }

    private final String getVirtualCurrenciesCacheBaseKey() {
        return (String) this.virtualCurrenciesCacheBaseKey.getValue();
    }

    private final String getVirtualCurrenciesLastUpdatedCacheBaseKey() {
        return (String) this.virtualCurrenciesLastUpdatedCacheBaseKey.getValue();
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey.getValue();
    }

    public final SharedPreferences.Editor startEditing$purchases_defaultsBc8Release() {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        return editorEdit;
    }

    public final synchronized String getLegacyCachedAppUserID$purchases_defaultsBc8Release() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release(), null);
    }

    public final synchronized String getCachedAppUserID$purchases_defaultsBc8Release() {
        return this.preferences.getString(getAppUserIDCacheKey$purchases_defaultsBc8Release(), null);
    }

    public final synchronized void cacheAppUserID$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        cacheAppUserID$purchases_defaultsBc8Release(appUserID, editorEdit).apply();
    }

    public final synchronized SharedPreferences.Editor cacheAppUserID$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor cacheEditor) {
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        editorPutString = cacheEditor.putString(getAppUserIDCacheKey$purchases_defaultsBc8Release(), appUserID);
        Intrinsics.checkNotNullExpressionValue(editorPutString, "cacheEditor.putString(ap…serIDCacheKey, appUserID)");
        return editorPutString;
    }

    public final synchronized void clearCachesForAppUserID$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        clearVirtualCurrenciesCache(clearVirtualCurrenciesCacheTimestamp(clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(editorEdit)), appUserID), appUserID), appUserID).apply();
    }

    private final SharedPreferences.Editor clearCustomerInfo(SharedPreferences.Editor editor) {
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor editor) {
        editor.remove(getAppUserIDCacheKey$purchases_defaultsBc8Release());
        editor.remove(getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release());
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfoCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(str));
        return editor;
    }

    public final String customerInfoCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release() + b.a + appUserID;
    }

    public final String customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + b.a + appUserID;
    }

    public final CustomerInfo getCachedCustomerInfo$purchases_defaultsBc8Release(String appUserID) {
        String verificationResultString;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        String string = this.preferences.getString(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID), null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                int iOptInt = jSONObject.optInt(CUSTOMER_INFO_SCHEMA_VERSION_KEY);
                if (jSONObject.has("verification_result")) {
                    verificationResultString = jSONObject.getString("verification_result");
                } else {
                    verificationResultString = "NOT_REQUESTED";
                }
                Long lValueOf = Long.valueOf(jSONObject.optLong(CUSTOMER_INFO_REQUEST_DATE_KEY));
                if (lValueOf.longValue() <= 0) {
                    lValueOf = null;
                }
                Date date = lValueOf != null ? new Date(lValueOf.longValue()) : null;
                CustomerInfoOriginalSource customerInfoOriginalSourceFromString = CustomerInfoOriginalSource.INSTANCE.fromString(JSONObjectExtensionsKt.optNullableString(jSONObject, CUSTOMER_INFO_ORIGINAL_SOURCE_KEY));
                jSONObject.remove("verification_result");
                jSONObject.remove(CUSTOMER_INFO_REQUEST_DATE_KEY);
                jSONObject.remove(CUSTOMER_INFO_ORIGINAL_SOURCE_KEY);
                Intrinsics.checkNotNullExpressionValue(verificationResultString, "verificationResultString");
                VerificationResult verificationResultValueOf = VerificationResult.valueOf(verificationResultString);
                if (iOptInt == 3) {
                    return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, verificationResultValueOf, customerInfoOriginalSourceFromString, true);
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final synchronized void cacheCustomerInfo$purchases_defaultsBc8Release(String appUserID, CustomerInfo info) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(info, "info");
        JSONObject jsonObject = info.getJsonObject();
        jsonObject.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        jsonObject.put("verification_result", info.getEntitlements().getVerification().name());
        jsonObject.put(CUSTOMER_INFO_REQUEST_DATE_KEY, info.getRequestDate().getTime());
        jsonObject.put(CUSTOMER_INFO_ORIGINAL_SOURCE_KEY, info.getOriginalSource().name());
        this.preferences.edit().putString(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID), jsonObject.toString()).apply();
        setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release(appUserID);
    }

    public final synchronized boolean isCustomerInfoCacheStale$purchases_defaultsBc8Release(String appUserID, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(appUserID), appInBackground, this.dateProvider);
    }

    public final synchronized void clearCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(editorEdit, appUserID).apply();
    }

    public final synchronized void clearCustomerInfoCache$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        clearCustomerInfoCache$purchases_defaultsBc8Release(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearCustomerInfoCache$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(editor, "editor");
        clearCustomerInfoCacheTimestamp(editor, appUserID);
        editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID));
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(appUserID, this.dateProvider.getNow());
    }

    public final synchronized void setCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(String appUserID, Date date) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(appUserID), date.getTime()).apply();
    }

    @Override // com.revenuecat.purchases.interfaces.StorefrontProvider
    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey$purchases_defaultsBc8Release(), null);
        if (string == null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
            }
        }
        return string;
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String appUserID) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(appUserID), 0L));
    }

    public final String virtualCurrenciesCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getVirtualCurrenciesCacheBaseKey() + b.a + appUserID;
    }

    public final String virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getVirtualCurrenciesLastUpdatedCacheBaseKey() + b.a + appUserID;
    }

    public final synchronized VirtualCurrencies getCachedVirtualCurrencies$purchases_defaultsBc8Release(String appUserID) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        String string = this.preferences.getString(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(appUserID), null);
        if (string != null) {
            try {
                return VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(string);
            } catch (SerializationException e) {
                final LogIntent logIntent = LogIntent.WARNING;
                Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                        }
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        }
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler11.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                }
            } catch (IllegalArgumentException e2) {
                final LogIntent logIntent2 = LogIntent.WARNING;
                Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e2}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler12.d("[Purchases] - " + logLevel11.name(), (String) function1.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel12 = LogLevel.WARN;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler13.w("[Purchases] - " + logLevel12.name(), (String) function1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel13 = LogLevel.INFO;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler14.i("[Purchases] - " + logLevel13.name(), (String) function1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel14 = LogLevel.DEBUG;
                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            currentLogHandler15.d("[Purchases] - " + logLevel14.name(), (String) function1.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel15 = LogLevel.INFO;
                        LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler16.i("[Purchases] - " + logLevel15.name(), (String) function1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            currentLogHandler17.d("[Purchases] - " + logLevel16.name(), (String) function1.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            currentLogHandler18.d("[Purchases] - " + logLevel17.name(), (String) function1.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler19.w("[Purchases] - " + logLevel18.name(), (String) function1.invoke());
                        }
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        LogLevel logLevel19 = LogLevel.WARN;
                        LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            currentLogHandler20.w("[Purchases] - " + logLevel19.name(), (String) function1.invoke());
                        }
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler21.w("[Purchases] - " + logLevel20.name(), (String) function1.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                        break;
                }
            } catch (JSONException e3) {
                final LogIntent logIntent3 = LogIntent.WARNING;
                Function0 function2 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e3}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                    case 1:
                        LogLevel logLevel21 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            str = "[Purchases] - " + logLevel21.name();
                            str2 = (String) function2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel22 = LogLevel.WARN;
                        LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                            currentLogHandler22.w("[Purchases] - " + logLevel22.name(), (String) function2.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel23 = LogLevel.INFO;
                        LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                            currentLogHandler23.i("[Purchases] - " + logLevel23.name(), (String) function2.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel24 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                            str = "[Purchases] - " + logLevel24.name();
                            str2 = (String) function2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel25 = LogLevel.INFO;
                        LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                            currentLogHandler24.i("[Purchases] - " + logLevel25.name(), (String) function2.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel26 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                            str = "[Purchases] - " + logLevel26.name();
                            str2 = (String) function2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel27 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                            str = "[Purchases] - " + logLevel27.name();
                            str2 = (String) function2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel28 = LogLevel.WARN;
                        LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                            currentLogHandler25.w("[Purchases] - " + logLevel28.name(), (String) function2.invoke());
                        }
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        LogLevel logLevel29 = LogLevel.WARN;
                        LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                            currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) function2.invoke());
                        }
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel30 = LogLevel.WARN;
                        LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                            currentLogHandler27.w("[Purchases] - " + logLevel30.name(), (String) function2.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                        break;
                }
            }
        }
        return null;
    }

    public final synchronized void cacheVirtualCurrencies$purchases_defaultsBc8Release(String appUserID, VirtualCurrencies virtualCurrencies) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(virtualCurrencies, "virtualCurrencies");
        this.preferences.edit().putString(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(appUserID), Json.Default.encodeToString(VirtualCurrencies.INSTANCE.serializer(), virtualCurrencies)).apply();
        setVirtualCurrenciesCacheTimestampToNow(appUserID);
    }

    public final synchronized boolean isVirtualCurrenciesCacheStale$purchases_defaultsBc8Release(String appUserID, boolean appInBackground) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getVirtualCurrenciesCacheLastUpdated(appUserID), appInBackground, this.dateProvider);
    }

    public final synchronized void clearVirtualCurrenciesCache$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        clearVirtualCurrenciesCache$purchases_defaultsBc8Release(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearVirtualCurrenciesCache$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(editor, "editor");
        clearVirtualCurrenciesCacheTimestamp(editor, appUserID);
        clearVirtualCurrenciesCache(editor, appUserID);
    }

    private final synchronized void setVirtualCurrenciesCacheTimestampToNow(String appUserID) {
        setVirtualCurrenciesCacheTimestamp(appUserID, this.dateProvider.getNow());
    }

    private final synchronized void setVirtualCurrenciesCacheTimestamp(String appUserID, Date date) {
        this.preferences.edit().putLong(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(appUserID), date.getTime()).apply();
    }

    private final synchronized Date getVirtualCurrenciesCacheLastUpdated(String appUserID) {
        return new Date(this.preferences.getLong(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(appUserID), 0L));
    }

    private final SharedPreferences.Editor clearVirtualCurrenciesCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(str));
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearVirtualCurrenciesCache(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(str));
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    public final synchronized void cleanupOldAttributionData$purchases_defaultsBc8Release() {
        try {
            SharedPreferences.Editor editorEdit = this.preferences.edit();
            for (String str : this.preferences.getAll().keySet()) {
                if (str != null && StringsKt.startsWith$default(str, this.attributionCacheKey, false, 2, (Object) null)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized Map<String, TokenCacheEntry> getTokenMap() {
        Map<String, TokenCacheEntry> map = this.tokenMapCache;
        if (map != null) {
            return map;
        }
        Map<String, TokenCacheEntry> mapLoadTokenMapFromPreferences = loadTokenMapFromPreferences();
        this.tokenMapCache = mapLoadTokenMapFromPreferences;
        return mapLoadTokenMapFromPreferences;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Map<String, TokenCacheEntry> loadTokenMapFromPreferences() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        String string = this.preferences.getString(getTokensCacheKey$purchases_defaultsBc8Release(), null);
        if (string != null) {
            try {
                return (Map) Json.Default.decodeFromString(DeviceCacheKt.tokenMapSerializer, string);
            } catch (SerializationException unused) {
                return MapsKt.emptyMap();
            } catch (IllegalArgumentException unused2) {
                return MapsKt.emptyMap();
            }
        }
        try {
            Set<String> stringSet = this.preferences.getStringSet(getLegacyTokensCacheKey$purchases_defaultsBc8Release(), null);
            Set set = stringSet != null ? CollectionsKt.toSet(stringSet) : null;
            if (set == null) {
                return MapsKt.emptyMap();
            }
            Set set2 = set;
            final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
            for (Object obj : set2) {
                linkedHashMap.put(obj, new TokenCacheEntry((Boolean) null, 1, (DefaultConstructorMarker) null));
            }
            saveTokenMap(linkedHashMap);
            this.preferences.edit().remove(getLegacyTokensCacheKey$purchases_defaultsBc8Release()).apply();
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$loadTokenMapFromPreferences$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{linkedHashMap.keySet()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return linkedHashMap;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return linkedHashMap;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return linkedHashMap;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        return linkedHashMap;
                    }
                    return linkedHashMap;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return linkedHashMap;
                default:
                    return linkedHashMap;
            }
        } catch (ClassCastException unused3) {
            return MapsKt.emptyMap();
        }
    }

    private final synchronized void saveTokenMap(final Map<String, TokenCacheEntry> tokenMap) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$saveTokenMap$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.SAVING_TOKENS, Arrays.copyOf(new Object[]{tokenMap.keySet()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            putString$purchases_defaultsBc8Release(getTokensCacheKey$purchases_defaultsBc8Release(), Json.Default.encodeToString(DeviceCacheKt.tokenMapSerializer, tokenMap));
            this.tokenMapCache = tokenMap;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Set<String> getPreviouslySentHashedTokens$purchases_defaultsBc8Release() {
        final Set<String> setKeySet;
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            setKeySet = getTokenMap().keySet();
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getPreviouslySentHashedTokens$lambda$21$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{setKeySet}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
        } catch (Throwable th) {
            throw th;
        }
        return setKeySet;
    }

    public static /* synthetic */ void addSuccessfullyPostedToken$default(DeviceCache deviceCache, String str, Boolean bool, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSuccessfullyPostedToken");
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        deviceCache.addSuccessfullyPostedToken(str, bool);
    }

    @InternalRevenueCatAPI
    public final synchronized void addSuccessfullyPostedToken(final String token, Boolean isAutoRenewing) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(token, "token");
            final String strSha1 = UtilsKt.sha1(token);
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$addSuccessfullyPostedToken$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{token, strSha1}, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            final Map<String, TokenCacheEntry> mutableMap = MapsKt.toMutableMap(getTokenMap());
            Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$addSuccessfullyPostedToken$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_IN_CACHE, Arrays.copyOf(new Object[]{mutableMap.keySet()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel11.name(), (String) function1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel14.name(), (String) function1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel15.name(), (String) function1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) function1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel17.name(), (String) function1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function1.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function1.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function1.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
            }
            TokenCacheEntry tokenCacheEntry = mutableMap.get(strSha1);
            if (tokenCacheEntry == null) {
                mutableMap.put(strSha1, new TokenCacheEntry(isAutoRenewing));
                saveTokenMap(mutableMap);
            } else if (isAutoRenewing != null && !Intrinsics.areEqual(tokenCacheEntry.isAutoRenewing(), isAutoRenewing)) {
                mutableMap.put(strSha1, tokenCacheEntry.copy(isAutoRenewing));
                saveTokenMap(mutableMap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void cleanPreviouslySentTokens$purchases_defaultsBc8Release(Set<String> hashedTokens) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$cleanPreviouslySentTokens$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ReceiptStrings.CLEANING_PREV_SENT_HASHED_TOKEN;
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            Map<String, TokenCacheEntry> tokenMap = getTokenMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, TokenCacheEntry> entry : tokenMap.entrySet()) {
                if (hashedTokens.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            saveTokenMap(linkedHashMap);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
        return CollectionsKt.toList(MapsKt.minus((Map) hashedTokens, (Iterable) getPreviouslySentHashedTokens$purchases_defaultsBc8Release()).values());
    }

    public final synchronized List<StoreTransaction> getPurchasesWithAutoRenewingChange$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        LinkedHashMap linkedHashMap;
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            Map<String, TokenCacheEntry> tokenMap = getTokenMap();
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, StoreTransaction> entry : hashedTokens.entrySet()) {
                String key = entry.getKey();
                StoreTransaction value = entry.getValue();
                TokenCacheEntry tokenCacheEntry = tokenMap.get(key);
                if (tokenCacheEntry != null && tokenCacheEntry.isAutoRenewing() != null && value.getIsAutoRenewing() != null && !Intrinsics.areEqual(value.getIsAutoRenewing(), tokenCacheEntry.isAutoRenewing())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    public final synchronized void saveAutoRenewingStatus$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            Map<String, TokenCacheEntry> mutableMap = MapsKt.toMutableMap(getTokenMap());
            boolean z = false;
            for (Map.Entry<String, StoreTransaction> entry : hashedTokens.entrySet()) {
                String key = entry.getKey();
                StoreTransaction value = entry.getValue();
                TokenCacheEntry tokenCacheEntry = mutableMap.get(key);
                if (tokenCacheEntry != null && value.getIsAutoRenewing() != null && !Intrinsics.areEqual(tokenCacheEntry.isAutoRenewing(), value.getIsAutoRenewing())) {
                    mutableMap.put(key, tokenCacheEntry.copy(value.getIsAutoRenewing()));
                    z = true;
                }
            }
            if (z) {
                saveTokenMap(mutableMap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized JSONObject getOfferingsResponseCache$purchases_defaultsBc8Release() {
        return getJSONObjectOrNull$purchases_defaultsBc8Release(getOfferingsResponseCacheKey());
    }

    public final synchronized void cacheOfferingsResponse$purchases_defaultsBc8Release(JSONObject offeringsResponse) {
        Intrinsics.checkNotNullParameter(offeringsResponse, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), offeringsResponse.toString()).apply();
    }

    public final synchronized void clearOfferingsResponseCache$purchases_defaultsBc8Release() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping$purchases_defaultsBc8Release(ProductEntitlementMapping productEntitlementMapping) {
        Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson$purchases_defaultsBc8Release().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow$purchases_defaultsBc8Release();
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow$purchases_defaultsBc8Release() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale$purchases_defaultsBc8Release() {
        return DateExtensionsKt.m3854isCacheStale8Mi8wO0(getProductEntitlementMappingLastUpdated(), DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD, this.dateProvider);
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping$purchases_defaultsBc8Release() {
        ProductEntitlementMapping productEntitlementMappingFromJson$purchases_defaultsBc8Release = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMappingFromJson$purchases_defaultsBc8Release = ProductEntitlementMapping.INSTANCE.fromJson$purchases_defaultsBc8Release(new JSONObject(string), true);
        } catch (JSONException e) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            currentLogHandler.e("[Purchases] - ERROR", str, e);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMappingFromJson$purchases_defaultsBc8Release;
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1L));
        }
        return null;
    }

    public JSONObject getJSONObjectOrNull$purchases_defaultsBc8Release(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.preferences.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void putString$purchases_defaultsBc8Release(String cacheKey, String value) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(value, "value");
        this.preferences.edit().putString(cacheKey, value).apply();
    }

    public final void remove$purchases_defaultsBc8Release(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.preferences.edit().remove(cacheKey).apply();
    }

    public final Set<String> findKeysThatStartWith$purchases_defaultsBc8Release(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String it = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (StringsKt.startsWith$default(it, cacheKey, false, 2, (Object) null)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Set<String> setKeySet = linkedHashMap.keySet();
                if (setKeySet != null) {
                    return setKeySet;
                }
            }
            return SetsKt.emptySet();
        } catch (NullPointerException unused) {
            return SetsKt.emptySet();
        }
    }

    public final String newKey$purchases_defaultsBc8Release(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getApiKeyPrefix() + b.a + key;
    }
}
