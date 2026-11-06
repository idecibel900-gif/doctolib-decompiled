package com.revenuecat.purchases.common.offerings;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJF\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u0014J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0002JP\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192$\u0010\u001d\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e\u0012\u0004\u0012\u00020\f0\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "offeringParser", "Lcom/revenuecat/purchases/common/OfferingParser;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/OfferingParser;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/AppConfig;)V", "createOfferings", "", "offeringsJSON", "Lorg/json/JSONObject;", "originalDataSource", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "loadedFromDiskCache", "", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "Lcom/revenuecat/purchases/common/offerings/OfferingsResultData;", "extractProductIdentifiers", "", "", "getStoreProductsById", "productIds", "onCompleted", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingsFactory {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final Dispatcher dispatcher;
    private final OfferingParser offeringParser;

    public OfferingsFactory(BillingAbstract billing, OfferingParser offeringParser, Dispatcher dispatcher, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(offeringParser, "offeringParser");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        this.billing = billing;
        this.offeringParser = offeringParser;
        this.dispatcher = dispatcher;
        this.appConfig = appConfig;
    }

    public final void createOfferings(final JSONObject offeringsJSON, final HTTPResponseOriginalSource originalDataSource, final boolean loadedFromDiskCache, Function1 onError, final Function1 onSuccess) {
        final Function1 function1;
        final JSONException jSONException;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(offeringsJSON, "offeringsJSON");
        Intrinsics.checkNotNullParameter(originalDataSource, "originalDataSource");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        try {
            final Set<String> setExtractProductIdentifiers = extractProductIdentifiers(offeringsJSON);
            if (setExtractProductIdentifiers.isEmpty()) {
                try {
                    onError.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.INSTANCE.getConfigurationErrorNoProductsForOfferings(this.appConfig.getApiKeyValidationResult(), this.appConfig.getStore())));
                    return;
                } catch (JSONException e) {
                    jSONException = e;
                    function1 = onError;
                }
            } else {
                function1 = onError;
                try {
                    getStoreProductsById(setExtractProductIdentifiers, new Function1() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.createOfferings.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Exception {
                            invoke((Map<String, ? extends List<? extends StoreProduct>>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Map<String, ? extends List<? extends StoreProduct>> productsById) throws Exception {
                            LogHandler currentLogHandler2;
                            String str3;
                            String str4;
                            Intrinsics.checkNotNullParameter(productsById, "productsById");
                            try {
                                Set<String> set = setExtractProductIdentifiers;
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : set) {
                                    if (!productsById.containsKey((String) obj)) {
                                        arrayList.add(obj);
                                    }
                                }
                                Set set2 = CollectionsKt.toSet(arrayList);
                                final Set set3 = !set2.isEmpty() ? set2 : null;
                                if (set3 != null) {
                                    final LogIntent logIntent = LogIntent.GOOGLE_WARNING;
                                    Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$1$invoke$lambda$3$$inlined$log$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final String invoke() {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                            sb.append(' ');
                                            String str5 = String.format(OfferingStrings.CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(set3, ", ", null, null, 0, null, null, 62, null)}, 1));
                                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                            sb.append(str5);
                                            return sb.toString();
                                        }
                                    };
                                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                        case 1:
                                            LogLevel logLevel = LogLevel.DEBUG;
                                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                                str3 = "[Purchases] - " + logLevel.name();
                                                str4 = (String) function0.invoke();
                                                currentLogHandler2.d(str3, str4);
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
                                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                                str3 = "[Purchases] - " + logLevel4.name();
                                                str4 = (String) function0.invoke();
                                                currentLogHandler2.d(str3, str4);
                                            }
                                            break;
                                        case 6:
                                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                            break;
                                        case 7:
                                            LogLevel logLevel5 = LogLevel.INFO;
                                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                                currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                                            }
                                            break;
                                        case 8:
                                            LogLevel logLevel6 = LogLevel.DEBUG;
                                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                                str3 = "[Purchases] - " + logLevel6.name();
                                                str4 = (String) function0.invoke();
                                                currentLogHandler2.d(str3, str4);
                                            }
                                            break;
                                        case 9:
                                            LogLevel logLevel7 = LogLevel.DEBUG;
                                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                                str3 = "[Purchases] - " + logLevel7.name();
                                                str4 = (String) function0.invoke();
                                                currentLogHandler2.d(str3, str4);
                                            }
                                            break;
                                        case 10:
                                            LogLevel logLevel8 = LogLevel.WARN;
                                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                                currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                                            }
                                            break;
                                        case BaseVideoCapturer.RGBA /* 11 */:
                                            LogLevel logLevel9 = LogLevel.WARN;
                                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                                currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                                            }
                                            break;
                                        case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                            break;
                                        case 13:
                                            LogLevel logLevel10 = LogLevel.WARN;
                                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                                currentLogHandler8.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                                            }
                                            break;
                                        case 14:
                                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                            break;
                                    }
                                }
                                Offerings offeringsCreateOfferings = this.offeringParser.createOfferings(offeringsJSON, productsById, originalDataSource, loadedFromDiskCache);
                                if (offeringsCreateOfferings.getAll().isEmpty()) {
                                    function1.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND));
                                    return;
                                }
                                LogLevel logLevel11 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    String str5 = "[Purchases] - " + logLevel11.name();
                                    String str6 = String.format(OfferingStrings.CREATED_OFFERINGS, Arrays.copyOf(new Object[]{Integer.valueOf(offeringsCreateOfferings.getAll().size())}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    currentLogHandler9.v(str5, str6);
                                }
                                onSuccess.invoke(new OfferingsResultData(offeringsCreateOfferings, setExtractProductIdentifiers, set2));
                            } catch (Exception e2) {
                                if (!(e2 instanceof JSONException ? true : e2 instanceof SerializationException)) {
                                    throw e2;
                                }
                                final LogIntent logIntent2 = LogIntent.RC_ERROR;
                                Function0 function2 = new Function0() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$1$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                        sb.append(' ');
                                        String str7 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e2.getLocalizedMessage()}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                        sb.append(str7);
                                        return sb.toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel12 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler10.d("[Purchases] - " + logLevel12.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel13 = LogLevel.WARN;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler11.w("[Purchases] - " + logLevel13.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel14 = LogLevel.INFO;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            currentLogHandler12.i("[Purchases] - " + logLevel14.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel15 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler13.d("[Purchases] - " + logLevel15.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel16 = LogLevel.INFO;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            currentLogHandler14.i("[Purchases] - " + logLevel16.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            currentLogHandler15.d("[Purchases] - " + logLevel17.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel18 = LogLevel.DEBUG;
                                        LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler16.d("[Purchases] - " + logLevel18.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler17.w("[Purchases] - " + logLevel19.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case BaseVideoCapturer.RGBA /* 11 */:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler18.w("[Purchases] - " + logLevel20.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel21 = LogLevel.WARN;
                                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                                            currentLogHandler19.w("[Purchases] - " + logLevel21.name(), (String) function2.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                                        break;
                                }
                                function1.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e2.getLocalizedMessage()));
                            }
                        }
                    }, new Function1() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.createOfferings.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchasesError) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PurchasesError error) {
                            Intrinsics.checkNotNullParameter(error, "error");
                            function1.invoke(error);
                        }
                    });
                    return;
                } catch (JSONException e2) {
                    e = e2;
                }
            }
        } catch (JSONException e3) {
            e = e3;
            function1 = onError;
        }
        jSONException = e;
        final LogIntent logIntent = LogIntent.RC_ERROR;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$createOfferings$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{jSONException.getLocalizedMessage()}, 1));
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
        function1.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, jSONException.getLocalizedMessage()));
    }

    private final Set<String> extractProductIdentifiers(JSONObject offeringsJSON) throws JSONException {
        JSONArray jSONArray = offeringsJSON.getJSONArray("offerings");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("packages");
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String it = jSONArray2.getJSONObject(i2).optString("platform_product_identifier");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                if (it != null) {
                    linkedHashSet.add(it);
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subscriptionProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C06071 extends Lambda implements Function1 {
        final /* synthetic */ Function1 $onCompleted;
        final /* synthetic */ Function1 $onError;
        final /* synthetic */ Set<String> $productIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06071(Set<String> set, Function1 function1, Function1 function2) {
            super(1);
            this.$productIds = set;
            this.$onCompleted = function1;
            this.$onError = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends StoreProduct>) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(final List<? extends StoreProduct> subscriptionProducts) {
            Intrinsics.checkNotNullParameter(subscriptionProducts, "subscriptionProducts");
            Dispatcher dispatcher = OfferingsFactory.this.dispatcher;
            final Set<String> set = this.$productIds;
            final OfferingsFactory offeringsFactory = OfferingsFactory.this;
            final Function1 function1 = this.$onCompleted;
            final Function1 function2 = this.$onError;
            Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    OfferingsFactory.C06071.invoke$lambda$1(subscriptionProducts, set, offeringsFactory, function1, function2);
                }
            }, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(List list, Set set, OfferingsFactory offeringsFactory, Function1 function1, final Function1 function2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String productId = ((StoreProduct) obj).getPurchasingData().getProductId();
                Object arrayList = linkedHashMap.get(productId);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(productId, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
            Set<String> setMinus = SetsKt.minus(set, (Iterable) mutableMap.keySet());
            if (!setMinus.isEmpty()) {
                offeringsFactory.billing.queryProductDetailsAsync(ProductType.INAPP, setMinus, new OfferingsFactory$getStoreProductsById$1$1$1(offeringsFactory, mutableMap, function1), new Function1() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory$getStoreProductsById$1$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PurchasesError) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PurchasesError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function2.invoke(it);
                    }
                });
            } else {
                function1.invoke(mutableMap);
            }
        }
    }

    private final void getStoreProductsById(Set<String> productIds, Function1 onCompleted, final Function1 onError) {
        this.billing.queryProductDetailsAsync(ProductType.SUBS, productIds, new C06071(productIds, onCompleted, onError), new Function1() { // from class: com.revenuecat.purchases.common.offerings.OfferingsFactory.getStoreProductsById.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onError.invoke(it);
            }
        });
    }
}
