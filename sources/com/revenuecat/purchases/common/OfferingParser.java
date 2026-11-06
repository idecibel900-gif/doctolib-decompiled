package com.revenuecat.purchases.common;

import com.amazon.a.a.o.b;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.OfferingsKt;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J>\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J4\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J,\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0017\u001a\u00020\u0006H$¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/OfferingParser;", "", "()V", "createOffering", "Lcom/revenuecat/purchases/Offering;", "offeringJson", "Lorg/json/JSONObject;", "productsById", "", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "createOfferings", "Lcom/revenuecat/purchases/Offerings;", "offeringsJson", "originalSource", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "loadedFromDiskCache", "", "createPackage", "Lcom/revenuecat/purchases/Package;", "packageJson", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "findMatchingProduct", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OfferingParser {
    public final Offerings createOfferings(JSONObject offeringsJson, Map<String, ? extends List<? extends StoreProduct>> productsById) {
        Intrinsics.checkNotNullParameter(offeringsJson, "offeringsJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        return createOfferings$default(this, offeringsJson, productsById, null, false, 12, null);
    }

    public final Offerings createOfferings(JSONObject offeringsJson, Map<String, ? extends List<? extends StoreProduct>> productsById, HTTPResponseOriginalSource originalSource) {
        Intrinsics.checkNotNullParameter(offeringsJson, "offeringsJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        return createOfferings$default(this, offeringsJson, productsById, originalSource, false, 8, null);
    }

    protected abstract StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> productsById, JSONObject packageJson);

    public static /* synthetic */ Offerings createOfferings$default(OfferingParser offeringParser, JSONObject jSONObject, Map map, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createOfferings");
        }
        if ((i & 4) != 0) {
            hTTPResponseOriginalSource = HTTPResponseOriginalSource.MAIN;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return offeringParser.createOfferings(jSONObject, map, hTTPResponseOriginalSource, z);
    }

    public final Offerings createOfferings(JSONObject offeringsJson, final Map<String, ? extends List<? extends StoreProduct>> productsById, HTTPResponseOriginalSource originalSource, boolean loadedFromDiskCache) throws JSONException {
        UiConfig uiConfig;
        Offerings.Targeting targeting;
        Offerings.Placements placements;
        LinkedHashMap linkedHashMap;
        Map mapEmptyMap;
        Map map$default;
        Offerings.Targeting targeting2;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(offeringsJson, "offeringsJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.OfferingParser$createOfferings$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(OfferingStrings.BUILDING_OFFERINGS, Arrays.copyOf(new Object[]{Integer.valueOf(productsById.size())}, 1));
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
        JSONArray jSONArray = offeringsJson.getJSONArray("offerings");
        String string = offeringsJson.getString("current_offering_id");
        JSONObject jSONObjectOptJSONObject = offeringsJson.optJSONObject("ui_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                Json json = JsonTools.INSTANCE.getJson();
                String string2 = jSONObjectOptJSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "it.toString()");
                json.getSerializersModule();
                uiConfig = (UiConfig) json.decodeFromString(UiConfig.INSTANCE.serializer(), string2);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing ui_config", th);
                uiConfig = null;
            }
        } else {
            uiConfig = null;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject offeringJson = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(offeringJson, "offeringJson");
            Offering offeringCreateOffering = createOffering(offeringJson, productsById, uiConfig);
            if (offeringCreateOffering != null) {
                linkedHashMap2.put(offeringCreateOffering.getIdentifier(), offeringCreateOffering);
                if (offeringCreateOffering.getAvailablePackages().isEmpty()) {
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        String str3 = "[Purchases] - " + logLevel11.name();
                        String str4 = String.format(OfferingStrings.OFFERING_EMPTY, Arrays.copyOf(new Object[]{offeringCreateOffering.getIdentifier()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        currentLogHandler8.w(str3, str4);
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject2 = offeringsJson.optJSONObject("targeting");
        if (jSONObjectOptJSONObject2 != null) {
            Integer numOptNullableInt = JSONObjectExtensionsKt.optNullableInt(jSONObjectOptJSONObject2, "revision");
            String strOptNullableString = JSONObjectExtensionsKt.optNullableString(jSONObjectOptJSONObject2, "rule_id");
            if (numOptNullableInt == null || strOptNullableString == null) {
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel12.name(), OfferingStrings.TARGETING_ERROR);
                }
                targeting2 = null;
            } else {
                targeting2 = new Offerings.Targeting(numOptNullableInt.intValue(), strOptNullableString);
            }
            targeting = targeting2;
        } else {
            targeting = null;
        }
        JSONObject jSONObjectOptJSONObject3 = offeringsJson.optJSONObject("placements");
        if (jSONObjectOptJSONObject3 != null) {
            String nullableString = JSONObjectExtensionsKt.getNullableString(jSONObjectOptJSONObject3, "fallback_offering_id");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("offering_ids_by_placement");
            if (jSONObjectOptJSONObject4 == null || (map$default = JSONObjectExtensionsKt.toMap$default(jSONObjectOptJSONObject4, false, 1, null)) == null || (mapEmptyMap = JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull(map$default)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            placements = new Offerings.Placements(nullableString, mapEmptyMap);
        } else {
            placements = null;
        }
        Offering offering = (Offering) linkedHashMap2.get(string);
        Offering offeringWithPresentedContext = null;
        if (offering != null) {
            linkedHashMap = linkedHashMap2;
            offeringWithPresentedContext = OfferingsKt.withPresentedContext(offering, null, targeting);
        } else {
            linkedHashMap = linkedHashMap2;
        }
        return new Offerings(offeringWithPresentedContext, linkedHashMap, placements, targeting, originalSource, loadedFromDiskCache);
    }

    public final Offering createOffering(JSONObject offeringJson, Map<String, ? extends List<? extends StoreProduct>> productsById, UiConfig uiConfig) throws JSONException {
        Map mapEmptyMap;
        PaywallData paywallData;
        PaywallComponentsData paywallComponentsData;
        Intrinsics.checkNotNullParameter(offeringJson, "offeringJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        String offeringIdentifier = offeringJson.getString("identifier");
        JSONObject jSONObjectOptJSONObject = offeringJson.optJSONObject("metadata");
        if (jSONObjectOptJSONObject == null || (mapEmptyMap = JSONObjectExtensionsKt.toMap(jSONObjectOptJSONObject, true)) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map map = mapEmptyMap;
        JSONArray jSONArray = offeringJson.getJSONArray("packages");
        Intrinsics.checkNotNullExpressionValue(offeringIdentifier, "offeringIdentifier");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(offeringIdentifier);
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject packageJson = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(packageJson, "packageJson");
            Package packageCreatePackage = createPackage(packageJson, productsById, presentedOfferingContext);
            if (packageCreatePackage != null) {
                arrayList.add(packageCreatePackage);
            }
        }
        JSONObject jSONObjectOptJSONObject2 = offeringJson.optJSONObject("paywall");
        if (jSONObjectOptJSONObject2 != null) {
            try {
                Json json = JsonTools.INSTANCE.getJson();
                String string = jSONObjectOptJSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "it.toString()");
                json.getSerializersModule();
                paywallData = (PaywallData) json.decodeFromString(PaywallData.INSTANCE.serializer(), string);
            } catch (Exception e) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing paywall data", e);
                paywallData = null;
            }
        } else {
            paywallData = null;
        }
        JSONObject jSONObjectOptJSONObject3 = offeringJson.optJSONObject("paywall_components");
        if (jSONObjectOptJSONObject3 != null) {
            try {
                Json json2 = JsonTools.INSTANCE.getJson();
                String string2 = jSONObjectOptJSONObject3.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "it.toString()");
                json2.getSerializersModule();
                paywallComponentsData = (PaywallComponentsData) json2.decodeFromString(PaywallComponentsData.INSTANCE.serializer(), string2);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing paywall components data", th);
                paywallComponentsData = null;
            }
        } else {
            paywallComponentsData = null;
        }
        Offering.PaywallComponents paywallComponents = (paywallComponentsData == null || uiConfig == null) ? null : new Offering.PaywallComponents(uiConfig, paywallComponentsData);
        URL webCheckoutURL = OfferingParserKt.getWebCheckoutURL(offeringJson);
        if (arrayList.isEmpty()) {
            return null;
        }
        String string3 = offeringJson.getString(b.c);
        Intrinsics.checkNotNullExpressionValue(string3, "offeringJson.getString(\"description\")");
        return new Offering(offeringIdentifier, string3, map, arrayList, paywallData, paywallComponents, webCheckoutURL);
    }

    public final Package createPackage(JSONObject packageJson, Map<String, ? extends List<? extends StoreProduct>> productsById, PresentedOfferingContext presentedOfferingContext) throws JSONException {
        Intrinsics.checkNotNullParameter(packageJson, "packageJson");
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        String packageIdentifier = packageJson.getString("identifier");
        StoreProduct storeProductFindMatchingProduct = findMatchingProduct(productsById, packageJson);
        Intrinsics.checkNotNullExpressionValue(packageIdentifier, "packageIdentifier");
        PackageType packageType = OfferingParserKt.toPackageType(packageIdentifier);
        URL webCheckoutURL = OfferingParserKt.getWebCheckoutURL(packageJson);
        if (storeProductFindMatchingProduct != null) {
            return new Package(packageIdentifier, packageType, storeProductFindMatchingProduct.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext, webCheckoutURL);
        }
        return null;
    }
}
