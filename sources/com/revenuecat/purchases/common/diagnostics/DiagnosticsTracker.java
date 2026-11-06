package com.revenuecat.purchases.common.diagnostics;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u008d\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0002J>\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\b$\u0010%J.\u0010&\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*ø\u0001\u0000¢\u0006\u0004\b+\u0010,J0\u0010-\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0017J\u000e\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\u0017J\u000e\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0007J$\u0010:\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0002J\u0015\u0010@\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\bAJH\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0006\u0010J\u001a\u00020\u0017J^\u0010K\u001a\u00020\u00172\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010*2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010*2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010E\u001a\u0004\u0018\u00010\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0006\u0010Q\u001a\u00020\u0017JH\u0010R\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0*2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ\u0014\u0010U\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*J\u0006\u0010V\u001a\u00020\u0017J\u001e\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020 J\u0006\u0010[\u001a\u00020\u0017J1\u0010\\\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010]\u001a\u0004\u0018\u00010\u000f2\b\u0010^\u001a\u0004\u0018\u00010(2\b\u0010_\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010`J6\u0010a\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/2\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u000fJ>\u0010f\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ0\u0010j\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ>\u0010m\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0/ø\u0001\u0000¢\u0006\u0004\bn\u0010oJf\u0010p\u001a\u00020\u00172\u0006\u0010q\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020s2\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010X\u001a\u00020 2\b\u0010t\u001a\u0004\u0018\u00010 2\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010E\u001a\u00020F2\u0006\u0010w\u001a\u00020(2\b\u0010x\u001a\u0004\u0018\u00010yø\u0001\u0000¢\u0006\u0004\bz\u0010{J\u0006\u0010|\u001a\u00020\u0017J\u0010\u0010}\u001a\u00020\u00172\b\b\u0002\u0010~\u001a\u00020(J\u0016\u0010\u007f\u001a\u00020\u00172\u0006\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020\u000fJJ\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000f2\u0007\u0010g\u001a\u00030\u0081\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#2\b\u0010E\u001a\u0004\u0018\u00010Fø\u0001\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0018\u0010\u0084\u0001\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000f2\u0007\u0010g\u001a\u00030\u0081\u0001J/\u0010\u0085\u0001\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020\u0017J/\u0010\u0089\u0001\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u0087\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "diagnosticsHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "appSessionID", "Ljava/util/UUID;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/util/UUID;)V", "commonProperties", "", "", "listener", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "getListener", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "setListener", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;)V", "checkAndClearDiagnosticsFileIfTooBig", "", "completion", "Lkotlin/Function0;", "enqueue", "command", "trackAmazonPurchaseAttempt", "productId", b.C, "errorCode", "", b.f, "responseTime", "Lkotlin/time/Duration;", "trackAmazonPurchaseAttempt-9VgGkz4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;J)V", "trackAmazonQueryProductDetailsRequest", "wasSuccessful", "", "requestedProductIds", "", "trackAmazonQueryProductDetailsRequest-KLykuaI", "(JZLjava/util/Set;)V", "trackAmazonQueryPurchasesRequest", "foundProductIds", "", "trackAmazonQueryPurchasesRequest-KLykuaI", "(JZLjava/util/List;)V", "trackClearingDiagnosticsAfterFailedSync", "trackCustomerInfoVerificationResultIfNeeded", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "trackEnteredOfflineEntitlementsMode", "trackErrorEnteringOfflineEntitlementsMode", "error", "Lcom/revenuecat/purchases/PurchasesError;", "trackEvent", "diagnosticsEntry", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "eventName", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntryName;", DiagnosticsEntry.PROPERTIES_KEY, "trackEventInCurrentThread", "trackEventInCurrentThread$purchases_defaultsBc8Release", "trackGetCustomerInfoResult", "cacheFetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "hadUnsyncedPurchasesBefore", "trackGetCustomerInfoResult-17CK4j0", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lcom/revenuecat/purchases/VerificationResult;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;J)V", "trackGetCustomerInfoStarted", "trackGetOfferingsResult", "notFoundProductIds", "cacheStatus", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;", "trackGetOfferingsResult-B8UsjHI", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;J)V", "trackGetOfferingsStarted", "trackGetProductsResult", "trackGetProductsResult-9VgGkz4", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/lang/Integer;J)V", "trackGetProductsStarted", "trackGoogleBillingServiceDisconnected", "trackGoogleBillingSetupFinished", "responseCode", "debugMessage", "pendingRequestCount", "trackGoogleBillingStartConnection", "trackGooglePurchaseStarted", "oldProductId", "hasIntroTrial", "hasIntroPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "trackGooglePurchaseUpdateReceived", "productIds", "purchaseStatuses", "billingResponseCode", "billingDebugMessage", "trackGoogleQueryProductDetailsRequest", "productType", "trackGoogleQueryProductDetailsRequest-9VgGkz4", "(Ljava/util/Set;Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryPurchaseHistoryRequest", "trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y", "(Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryPurchasesRequest", "trackGoogleQueryPurchasesRequest-zkXUZaI", "(Ljava/lang/String;ILjava/lang/String;JLjava/util/List;)V", "trackHttpRequestPerformed", DiagnosticsTracker.HOST_KEY, "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "backendErrorCode", "resultOrigin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "isRetry", "connectionErrorReason", "Lcom/revenuecat/purchases/common/networking/ConnectionErrorReason;", "trackHttpRequestPerformed--XzGXFE", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/networking/Endpoint;JZILjava/lang/Integer;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Lcom/revenuecat/purchases/VerificationResult;ZLcom/revenuecat/purchases/common/networking/ConnectionErrorReason;)V", "trackMaxDiagnosticsSyncRetriesReached", "trackMaxEventsStoredLimitReached", "useCurrentThread", "trackProductDetailsNotSupported", "trackPurchaseResult", "Lcom/revenuecat/purchases/ProductType;", "trackPurchaseResult-myKFqkg", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/Integer;Ljava/lang/String;JLcom/revenuecat/purchases/VerificationResult;)V", "trackPurchaseStarted", "trackRestorePurchasesResult", "trackRestorePurchasesResult-SxA4cEA", "(Ljava/lang/Integer;Ljava/lang/String;J)V", "trackRestorePurchasesStarted", "trackSyncPurchasesResult", "trackSyncPurchasesResult-SxA4cEA", "trackSyncPurchasesStarted", "CacheStatus", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsTracker {

    @Deprecated
    public static final String BACKEND_ERROR_CODE_KEY = "backend_error_code";

    @Deprecated
    public static final String BILLING_DEBUG_MESSAGE = "billing_debug_message";

    @Deprecated
    public static final String BILLING_RESPONSE_CODE = "billing_response_code";

    @Deprecated
    public static final String CACHE_STATUS_KEY = "cache_status";

    @Deprecated
    public static final String CONNECTION_ERROR_REASON_KEY = "connection_error_reason";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ENDPOINT_NAME_KEY = "endpoint_name";

    @Deprecated
    public static final String ERROR_CODE_KEY = "error_code";

    @Deprecated
    public static final String ERROR_MESSAGE_KEY = "error_message";

    @Deprecated
    public static final String ETAG_HIT_KEY = "etag_hit";

    @Deprecated
    public static final String FETCH_POLICY_KEY = "fetch_policy";

    @Deprecated
    public static final String FOUND_PRODUCT_IDS_KEY = "found_product_ids";

    @Deprecated
    public static final String HAD_UNSYNCED_PURCHASES_BEFORE_KEY = "had_unsynced_purchases_before";

    @Deprecated
    public static final String HAS_INTRO_PRICE_KEY = "has_intro_price";

    @Deprecated
    public static final String HAS_INTRO_TRIAL_KEY = "has_intro_trial";

    @Deprecated
    public static final String HOST_KEY = "host";

    @Deprecated
    public static final String IS_RETRY = "is_retry";

    @Deprecated
    public static final String NOT_FOUND_PRODUCT_IDS_KEY = "not_found_product_ids";

    @Deprecated
    public static final String OLD_PRODUCT_ID_KEY = "old_product_id";

    @Deprecated
    public static final String PENDING_REQUEST_COUNT = "pending_request_count";

    @Deprecated
    public static final String PRODUCT_IDS_KEY = "product_ids";

    @Deprecated
    public static final String PRODUCT_ID_KEY = "product_id";

    @Deprecated
    public static final String PRODUCT_TYPE_KEY = "product_type";

    @Deprecated
    public static final String PRODUCT_TYPE_QUERIED_KEY = "product_type_queried";

    @Deprecated
    public static final String PURCHASE_STATUSES_KEY = "purchase_statuses";

    @Deprecated
    public static final String REQUESTED_PRODUCT_IDS_KEY = "requested_product_ids";

    @Deprecated
    public static final String REQUEST_STATUS_KEY = "request_status";

    @Deprecated
    public static final String RESPONSE_CODE_KEY = "response_code";

    @Deprecated
    public static final String RESPONSE_TIME_MILLIS_KEY = "response_time_millis";

    @Deprecated
    public static final String SUCCESSFUL_KEY = "successful";

    @Deprecated
    public static final String VERIFICATION_RESULT_KEY = "verification_result";
    private final AppConfig appConfig;
    private final UUID appSessionID;
    private final Map<String, String> commonProperties;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private DiagnosticsEventTrackerListener listener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;", "", "(Ljava/lang/String;I)V", "NOT_CHECKED", "NOT_FOUND", "STALE", "VALID", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum CacheStatus {
        NOT_CHECKED,
        NOT_FOUND,
        STALE,
        VALID
    }

    public final void trackEventInCurrentThread$purchases_defaultsBc8Release(DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Tracking diagnostics entry: " + diagnosticsEntry);
        }
        try {
            this.diagnosticsFileHelper.appendEvent(diagnosticsEntry);
            DiagnosticsEventTrackerListener diagnosticsEventTrackerListener = this.listener;
            if (diagnosticsEventTrackerListener != null) {
                diagnosticsEventTrackerListener.onEventTracked();
            }
        } catch (IOException e) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Error tracking diagnostics entry: " + e);
            }
        }
    }

    public DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher diagnosticsDispatcher, UUID appSessionID) {
        Map<String, String> mapEmptyMap;
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsHelper, "diagnosticsHelper");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        this.appConfig = appConfig;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.appSessionID = appSessionID;
        if (appConfig.getStore() == Store.PLAY_STORE) {
            mapEmptyMap = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to("play_store_version", appConfig.getPlayStoreVersionName()), TuplesKt.to("play_services_version", appConfig.getPlayServicesVersionName())));
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        this.commonProperties = mapEmptyMap;
    }

    public /* synthetic */ DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher dispatcher, UUID uuid, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, diagnosticsFileHelper, diagnosticsHelper, dispatcher, (i & 16) != 0 ? EventsManager.INSTANCE.getAppSessionID$purchases_defaultsBc8Release() : uuid);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$Companion;", "", "()V", "BACKEND_ERROR_CODE_KEY", "", "BILLING_DEBUG_MESSAGE", "BILLING_RESPONSE_CODE", "CACHE_STATUS_KEY", "CONNECTION_ERROR_REASON_KEY", "ENDPOINT_NAME_KEY", "ERROR_CODE_KEY", "ERROR_MESSAGE_KEY", "ETAG_HIT_KEY", "FETCH_POLICY_KEY", "FOUND_PRODUCT_IDS_KEY", "HAD_UNSYNCED_PURCHASES_BEFORE_KEY", "HAS_INTRO_PRICE_KEY", "HAS_INTRO_TRIAL_KEY", "HOST_KEY", "IS_RETRY", "NOT_FOUND_PRODUCT_IDS_KEY", "OLD_PRODUCT_ID_KEY", "PENDING_REQUEST_COUNT", "PRODUCT_IDS_KEY", "PRODUCT_ID_KEY", "PRODUCT_TYPE_KEY", "PRODUCT_TYPE_QUERIED_KEY", "PURCHASE_STATUSES_KEY", "REQUESTED_PRODUCT_IDS_KEY", "REQUEST_STATUS_KEY", "RESPONSE_CODE_KEY", "RESPONSE_TIME_MILLIS_KEY", "SUCCESSFUL_KEY", "VERIFICATION_RESULT_KEY", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final DiagnosticsEventTrackerListener getListener() {
        return this.listener;
    }

    public final void setListener(DiagnosticsEventTrackerListener diagnosticsEventTrackerListener) {
        this.listener = diagnosticsEventTrackerListener;
    }

    /* JADX INFO: renamed from: trackHttpRequestPerformed--XzGXFE, reason: not valid java name */
    public final void m3867trackHttpRequestPerformedXzGXFE(String host, Endpoint endpoint, long responseTime, boolean wasSuccessful, int responseCode, Integer backendErrorCode, HTTPResult.Origin resultOrigin, VerificationResult verificationResult, boolean isRetry, ConnectionErrorReason connectionErrorReason) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        trackEvent(DiagnosticsEntryName.HTTP_REQUEST_PERFORMED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(HOST_KEY, host), TuplesKt.to(ENDPOINT_NAME_KEY, endpoint.getName()), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), TuplesKt.to(RESPONSE_CODE_KEY, Integer.valueOf(responseCode)), TuplesKt.to(BACKEND_ERROR_CODE_KEY, backendErrorCode), TuplesKt.to(ETAG_HIT_KEY, Boolean.valueOf(resultOrigin == HTTPResult.Origin.CACHE)), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult.name()), TuplesKt.to(IS_RETRY, Boolean.valueOf(isRetry)), TuplesKt.to(CONNECTION_ERROR_REASON_KEY, connectionErrorReason != null ? connectionErrorReason.name() : null))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryProductDetailsRequest-9VgGkz4, reason: not valid java name */
    public final void m3864trackGoogleQueryProductDetailsRequest9VgGkz4(Set<String> requestedProductIds, String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.to(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchasesRequest-zkXUZaI, reason: not valid java name */
    public final void m3866trackGoogleQueryPurchasesRequestzkXUZaI(String productType, int billingResponseCode, String billingDebugMessage, long responseTime, List<String> foundProductIds) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        Intrinsics.checkNotNullParameter(foundProductIds, "foundProductIds");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASES_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(FOUND_PRODUCT_IDS_KEY, foundProductIds)));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m3865trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, MapsKt.mapOf(TuplesKt.to(PRODUCT_TYPE_QUERIED_KEY, productType), TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, billingDebugMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime)))));
    }

    public final void trackGoogleBillingStartConnection() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_START_CONNECTION, MapsKt.emptyMap());
    }

    public final void trackGoogleBillingSetupFinished(int responseCode, String debugMessage, int pendingRequestCount) {
        Intrinsics.checkNotNullParameter(debugMessage, "debugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SETUP_FINISHED, MapsKt.mapOf(TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(responseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, debugMessage), TuplesKt.to(PENDING_REQUEST_COUNT, Integer.valueOf(pendingRequestCount))));
    }

    public final void trackGoogleBillingServiceDisconnected() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SERVICE_DISCONNECTED, MapsKt.emptyMap());
    }

    public final void trackGooglePurchaseStarted(String productId, String oldProductId, Boolean hasIntroTrial, Boolean hasIntroPrice) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASE_STARTED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(PRODUCT_ID_KEY, productId), TuplesKt.to(OLD_PRODUCT_ID_KEY, oldProductId), TuplesKt.to(HAS_INTRO_TRIAL_KEY, hasIntroTrial), TuplesKt.to(HAS_INTRO_PRICE_KEY, hasIntroPrice))));
    }

    public final void trackGooglePurchaseUpdateReceived(List<String> productIds, List<String> purchaseStatuses, int billingResponseCode, String billingDebugMessage) {
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASES_UPDATE_RECEIVED, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(PRODUCT_IDS_KEY, productIds), TuplesKt.to(PURCHASE_STATUSES_KEY, purchaseStatuses), TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, billingDebugMessage))));
    }

    /* JADX INFO: renamed from: trackAmazonQueryProductDetailsRequest-KLykuaI, reason: not valid java name */
    public final void m3859trackAmazonQueryProductDetailsRequestKLykuaI(long responseTime, boolean wasSuccessful, Set<String> requestedProductIds) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PRODUCT_DETAILS_REQUEST, MapsKt.mapOf(TuplesKt.to(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackAmazonQueryPurchasesRequest-KLykuaI, reason: not valid java name */
    public final void m3860trackAmazonQueryPurchasesRequestKLykuaI(long responseTime, boolean wasSuccessful, List<String> foundProductIds) {
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PURCHASES_REQUEST, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(FOUND_PRODUCT_IDS_KEY, foundProductIds))));
    }

    /* JADX INFO: renamed from: trackAmazonPurchaseAttempt-9VgGkz4, reason: not valid java name */
    public final void m3858trackAmazonPurchaseAttempt9VgGkz4(String productId, String requestStatus, Integer errorCode, String errorMessage, long responseTime) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        trackEvent(DiagnosticsEntryName.AMAZON_PURCHASE_ATTEMPT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(PRODUCT_ID_KEY, productId), TuplesKt.to(REQUEST_STATUS_KEY, requestStatus), TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z);
    }

    public final void trackMaxEventsStoredLimitReached(boolean useCurrentThread) {
        DiagnosticsEntry diagnosticsEntry = new DiagnosticsEntry(null, DiagnosticsEntryName.MAX_EVENTS_STORED_LIMIT_REACHED, this.commonProperties, this.appSessionID, null, null, 49, null);
        if (useCurrentThread) {
            trackEventInCurrentThread$purchases_defaultsBc8Release(diagnosticsEntry);
        } else {
            trackEvent(diagnosticsEntry);
        }
    }

    public final void trackMaxDiagnosticsSyncRetriesReached() {
        trackEvent(DiagnosticsEntryName.MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED, MapsKt.emptyMap());
    }

    public final void trackClearingDiagnosticsAfterFailedSync() {
        trackEvent(DiagnosticsEntryName.CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC, MapsKt.emptyMap());
    }

    public final void trackProductDetailsNotSupported(int billingResponseCode, String billingDebugMessage) {
        Intrinsics.checkNotNullParameter(billingDebugMessage, "billingDebugMessage");
        DiagnosticsEntryName diagnosticsEntryName = DiagnosticsEntryName.PRODUCT_DETAILS_NOT_SUPPORTED;
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        Pair pair = TuplesKt.to("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        trackEvent(diagnosticsEntryName, MapsKt.mapOf(pair, TuplesKt.to("play_services_version", playServicesVersionName != null ? playServicesVersionName : ""), TuplesKt.to(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), TuplesKt.to(BILLING_DEBUG_MESSAGE, billingDebugMessage)));
    }

    public final void trackCustomerInfoVerificationResultIfNeeded(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        VerificationResult verification = customerInfo.getEntitlements().getVerification();
        if (verification == VerificationResult.NOT_REQUESTED) {
            return;
        }
        trackEvent(DiagnosticsEntryName.CUSTOMER_INFO_VERIFICATION_RESULT, MapsKt.mapOf(TuplesKt.to(VERIFICATION_RESULT_KEY, verification.name())));
    }

    public final void trackEnteredOfflineEntitlementsMode() {
        trackEvent(DiagnosticsEntryName.ENTERED_OFFLINE_ENTITLEMENTS_MODE, MapsKt.emptyMap());
    }

    public final void trackErrorEnteringOfflineEntitlementsMode(PurchasesError error) {
        String str;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.getCode() == PurchasesErrorCode.UnsupportedError && Intrinsics.areEqual(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES)) {
            str = "one_time_purchase_found";
        } else if (error.getCode() == PurchasesErrorCode.CustomerInfoError && Intrinsics.areEqual(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED)) {
            str = "no_entitlement_mapping_available";
        } else {
            str = "unknown";
        }
        trackEvent(DiagnosticsEntryName.ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE, MapsKt.mapOf(TuplesKt.to("offline_entitlement_error_reason", str), TuplesKt.to(ERROR_MESSAGE_KEY, error.getMessage() + " Underlying error: " + error.getUnderlyingErrorMessage())));
    }

    public final void trackGetOfferingsStarted() {
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackGetOfferingsResult-B8UsjHI, reason: not valid java name */
    public final void m3862trackGetOfferingsResultB8UsjHI(Set<String> requestedProductIds, Set<String> notFoundProductIds, String errorMessage, Integer errorCode, String verificationResult, CacheStatus cacheStatus, long responseTime) {
        Intrinsics.checkNotNullParameter(cacheStatus, "cacheStatus");
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), TuplesKt.to(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult), TuplesKt.to(CACHE_STATUS_KEY, cacheStatus.name()), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public final void trackGetProductsStarted(Set<String> requestedProductIds) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_STARTED, MapsKt.mapOf(TuplesKt.to(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackGetProductsResult-9VgGkz4, reason: not valid java name */
    public final void m3863trackGetProductsResult9VgGkz4(Set<String> requestedProductIds, Set<String> notFoundProductIds, String errorMessage, Integer errorCode, long responseTime) {
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), TuplesKt.to(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public final void trackSyncPurchasesStarted() {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackSyncPurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m3870trackSyncPurchasesResultSxA4cEA(Integer errorCode, String errorMessage, long responseTime) {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public final void trackRestorePurchasesStarted() {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackRestorePurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m3869trackRestorePurchasesResultSxA4cEA(Integer errorCode, String errorMessage, long responseTime) {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public final void trackGetCustomerInfoStarted() {
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_STARTED, MapsKt.emptyMap());
    }

    /* JADX INFO: renamed from: trackGetCustomerInfoResult-17CK4j0, reason: not valid java name */
    public final void m3861trackGetCustomerInfoResult17CK4j0(CacheFetchPolicy cacheFetchPolicy, VerificationResult verificationResult, Boolean hadUnsyncedPurchasesBefore, String errorMessage, Integer errorCode, long responseTime) {
        Intrinsics.checkNotNullParameter(cacheFetchPolicy, "cacheFetchPolicy");
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(FETCH_POLICY_KEY, cacheFetchPolicy.name()), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null), TuplesKt.to(HAD_UNSYNCED_PURCHASES_BEFORE_KEY, hadUnsyncedPurchasesBefore), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))))));
    }

    public final void trackPurchaseStarted(String productId, ProductType productType) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_STARTED, MapsKt.mapOf(TuplesKt.to(PRODUCT_ID_KEY, productId), TuplesKt.to(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType))));
    }

    /* JADX INFO: renamed from: trackPurchaseResult-myKFqkg, reason: not valid java name */
    public final void m3868trackPurchaseResultmyKFqkg(String productId, ProductType productType, Integer errorCode, String errorMessage, long responseTime, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_RESULT, MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(PRODUCT_ID_KEY, productId), TuplesKt.to(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType)), TuplesKt.to(ERROR_CODE_KEY, errorCode), TuplesKt.to(ERROR_MESSAGE_KEY, errorMessage), TuplesKt.to(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(Duration.m5408getInWholeMillisecondsimpl(responseTime))), TuplesKt.to(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null))));
    }

    private final void trackEvent(DiagnosticsEntryName eventName, Map<String, ? extends Object> properties) {
        trackEvent(new DiagnosticsEntry(null, eventName, MapsKt.plus(this.commonProperties, properties), this.appSessionID, null, null, 49, null));
    }

    public final void trackEvent(final DiagnosticsEntry diagnosticsEntry) {
        Intrinsics.checkNotNullParameter(diagnosticsEntry, "diagnosticsEntry");
        checkAndClearDiagnosticsFileIfTooBig(new Function0() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker.trackEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3872invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3872invoke() {
                DiagnosticsTracker.this.trackEventInCurrentThread$purchases_defaultsBc8Release(diagnosticsEntry);
            }
        });
    }

    private final void checkAndClearDiagnosticsFileIfTooBig(final Function0 completion) {
        enqueue(new Function0() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker.checkAndClearDiagnosticsFileIfTooBig.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3871invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3871invoke() {
                if (DiagnosticsTracker.this.diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is too big. Deleting it.");
                    }
                    DiagnosticsTracker.this.diagnosticsHelper.resetDiagnosticsStatus();
                    DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(DiagnosticsTracker.this, false, 1, null);
                }
                completion.invoke();
            }
        });
    }

    private final void enqueue(final Function0 command) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, null, 2, null);
    }
}
