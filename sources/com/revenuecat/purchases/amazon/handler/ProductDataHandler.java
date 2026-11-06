package com.revenuecat.purchases.amazon.handler;

import android.os.Handler;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.StoreProductConversionsKt;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JL\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002JB\u0010\u001e\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u0016\u001a\u00020\t2\u001c\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`!H\u0002J(\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0018j\u0002`%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\b8BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler;", "Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "mainHandler", "Landroid/os/Handler;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/os/Handler;)V", "productDataCache", "", "", "Lcom/amazon/device/iap/model/Product;", "getProductDataCache$purchases_defaultsBc8Release", "()Ljava/util/Map;", "productDataRequests", "Lcom/amazon/device/iap/model/RequestId;", "Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "addTimeoutToProductDataRequest", "", "requestId", "getProductData", b.O, "", b.m, "onReceive", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getRequest", "handleSuccessfulProductDataResponse", "productData", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "handleUnsuccessfulProductDataResponse", "response", "Lcom/amazon/device/iap/model/ProductDataResponse;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onProductDataResponse", "Companion", "Request", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProductDataHandler implements ProductDataResponseListener {
    private static final long GET_PRODUCT_DATA_TIMEOUT_MILLIS = 10000;
    private final Handler mainHandler;
    private final Map<String, Product> productDataCache;
    private final Map<RequestId, Request> productDataRequests;
    private final PurchasingServiceProvider purchasingServiceProvider;

    public ProductDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.mainHandler = mainHandler;
        this.productDataRequests = new LinkedHashMap();
        this.productDataCache = new LinkedHashMap();
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001c\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nHÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\rHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0006\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/ProductDataHandler$Request;", "", "skuList", "", "", b.m, "onReceive", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/models/StoreProduct;", "", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getMarketplace", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getSkuList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class Request {
        private final String marketplace;
        private final Function1 onError;
        private final Function1 onReceive;
        private final List<String> skuList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, List list, String str, Function1 function1, Function1 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = request.skuList;
            }
            if ((i & 2) != 0) {
                str = request.marketplace;
            }
            if ((i & 4) != 0) {
                function1 = request.onReceive;
            }
            if ((i & 8) != 0) {
                function2 = request.onError;
            }
            return request.copy(list, str, function1, function2);
        }

        public final List<String> component1() {
            return this.skuList;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMarketplace() {
            return this.marketplace;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Function1 getOnReceive() {
            return this.onReceive;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Function1 getOnError() {
            return this.onError;
        }

        public final Request copy(List<String> skuList, String marketplace, Function1 onReceive, Function1 onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            return new Request(skuList, marketplace, onReceive, onError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            return Intrinsics.areEqual(this.skuList, request.skuList) && Intrinsics.areEqual(this.marketplace, request.marketplace) && Intrinsics.areEqual(this.onReceive, request.onReceive) && Intrinsics.areEqual(this.onError, request.onError);
        }

        public int hashCode() {
            return (((((this.skuList.hashCode() * 31) + this.marketplace.hashCode()) * 31) + this.onReceive.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(skuList=" + this.skuList + ", marketplace=" + this.marketplace + ", onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }

        public Request(List<String> skuList, String marketplace, Function1 onReceive, Function1 onError) {
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Intrinsics.checkNotNullParameter(marketplace, "marketplace");
            Intrinsics.checkNotNullParameter(onReceive, "onReceive");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.skuList = skuList;
            this.marketplace = marketplace;
            this.onReceive = onReceive;
            this.onError = onError;
        }

        public final List<String> getSkuList() {
            return this.skuList;
        }

        public final String getMarketplace() {
            return this.marketplace;
        }

        public final Function1 getOnReceive() {
            return this.onReceive;
        }

        public final Function1 getOnError() {
            return this.onError;
        }
    }

    public final synchronized Map<String, Product> getProductDataCache$purchases_defaultsBc8Release() {
        return this.productDataCache;
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(final Set<String> skus, String marketplace, Function1 onReceive, Function1 onError) throws JSONException {
        Map map;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$getProductData$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AmazonStrings.REQUESTING_PRODUCTS, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(skus, null, null, null, 0, null, null, 63, null)}, 1));
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
        synchronized (this) {
            map = MapsKt.toMap(this.productDataCache);
        }
        if (!map.keySet().containsAll(skus)) {
            RequestId productData = this.purchasingServiceProvider.getProductData(skus);
            Request request = new Request(CollectionsKt.toList(skus), marketplace, onReceive, onError);
            synchronized (this) {
                this.productDataRequests.put(productData, request);
                addTimeoutToProductDataRequest(productData);
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (skus.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        handleSuccessfulProductDataResponse(linkedHashMap, marketplace, onReceive);
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onProductDataResponse(final ProductDataResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$onProductDataResponse$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AmazonStrings.PRODUCTS_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.getRequestStatus().name()}, 1));
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
                        break;
                    }
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e);
                    throw e;
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
                        break;
                    }
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e);
                    throw e;
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
                        break;
                    }
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e);
                    throw e;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                        break;
                    }
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e);
                    throw e;
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
            Set<String> unavailableSkus = response.getUnavailableSkus();
            Intrinsics.checkNotNullExpressionValue(unavailableSkus, "response.unavailableSkus");
            if (!unavailableSkus.isEmpty()) {
                Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$onProductDataResponse$$inlined$log$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(AmazonStrings.PRODUCTS_REQUEST_UNAVAILABLE, Arrays.copyOf(new Object[]{response.getUnavailableSkus()}, 1));
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
            }
            RequestId requestId = response.getRequestId();
            Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
            Request request = getRequest(requestId);
            if (request == null) {
                return;
            }
            if (response.getRequestStatus() != ProductDataResponse.RequestStatus.SUCCESSFUL) {
                handleUnsuccessfulProductDataResponse(response, request.getOnError());
                return;
            }
            synchronized (this) {
                Map<String, Product> map = this.productDataCache;
                Map<String, Product> productData = response.getProductData();
                Intrinsics.checkNotNullExpressionValue(productData, "response.productData");
                map.putAll(productData);
                Unit unit = Unit.INSTANCE;
            }
            Map<String, Product> productData2 = response.getProductData();
            Intrinsics.checkNotNullExpressionValue(productData2, "response.productData");
            handleSuccessfulProductDataResponse(productData2, request.getMarketplace(), request.getOnReceive());
        } catch (Exception e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e);
            throw e;
        }
    }

    private final void handleSuccessfulProductDataResponse(final Map<String, Product> productData, String marketplace, Function1 onReceive) throws JSONException {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{productData}, 1));
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
        if (productData.isEmpty()) {
            Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AmazonStrings.RETRIEVED_PRODUCT_DATA_EMPTY;
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
        }
        Collection<Product> collectionValues = productData.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            StoreProduct storeProduct = StoreProductConversionsKt.toStoreProduct((Product) it.next(), marketplace);
            if (storeProduct != null) {
                arrayList.add(storeProduct);
            }
        }
        onReceive.invoke(arrayList);
    }

    private final void handleUnsuccessfulProductDataResponse(ProductDataResponse response, Function1 onError) {
        String str;
        if (response.getRequestStatus() == ProductDataResponse.RequestStatus.NOT_SUPPORTED) {
            str = "Couldn't fetch product data, since it's not supported.";
        } else {
            str = "Error when fetching product data.";
        }
        onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }

    private final void addTimeoutToProductDataRequest(final RequestId requestId) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.amazon.handler.ProductDataHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ProductDataHandler.addTimeoutToProductDataRequest$lambda$12(this.f$0, requestId);
            }
        }, GET_PRODUCT_DATA_TIMEOUT_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTimeoutToProductDataRequest$lambda$12(ProductDataHandler productDataHandler, RequestId requestId) {
        Request request = productDataHandler.getRequest(requestId);
        if (request == null) {
            return;
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
        String str = String.format(AmazonStrings.ERROR_TIMEOUT_GETTING_PRODUCT_DATA, Arrays.copyOf(new Object[]{request.getSkuList().toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        request.getOnError().invoke(new PurchasesError(purchasesErrorCode, str));
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.productDataRequests.remove(requestId);
    }
}
