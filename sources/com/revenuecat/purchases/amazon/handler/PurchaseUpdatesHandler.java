package com.revenuecat.purchases.amazon.handler;

import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016JD\u0010\u0016\u001a\u00020\r2\"\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u0011H\u0016J$\u0010\u0019\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010\u0005\u001aJ\u0012\u0004\u0012\u00020\u0007\u0012@\u0012>\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fj\u0002`\u00110\bj\u0002`\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseUpdatesHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseUpdatesResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;)V", "requests", "", "Lcom/amazon/device/iap/model/RequestId;", "Lkotlin/Pair;", "Lkotlin/Function2;", "", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesSuccessCallback;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "Lcom/revenuecat/purchases/amazon/handler/QueryPurchasesCallbacks;", "onPurchaseUpdatesResponse", "response", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "queryPurchases", "onSuccess", "onError", "invokeWithStoreProblem", "message", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseUpdatesHandler implements PurchaseUpdatesResponseListener {
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final Map<RequestId, Pair<Function2, Function1>> requests;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseUpdatesResponse.RequestStatus.values().length];
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseUpdatesResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchaseUpdatesHandler(PurchasingServiceProvider purchasingServiceProvider) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.requests = new LinkedHashMap();
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void queryPurchases(Function2 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        RequestId purchaseUpdates = this.purchasingServiceProvider.getPurchaseUpdates(true);
        synchronized (this) {
            this.requests.put(purchaseUpdates, TuplesKt.to(onSuccess, onError));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseUpdatesResponse(final PurchaseUpdatesResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Pair<Function2, Function1> pairRemove;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.handler.PurchaseUpdatesHandler$onPurchaseUpdatesResponse$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AmazonStrings.RETRIEVED_PRODUCT_DATA, Arrays.copyOf(new Object[]{response}, 1));
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
                        break;
                    }
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseUpdatesResponse", e);
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
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseUpdatesResponse", e);
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
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseUpdatesResponse", e);
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
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseUpdatesResponse", e);
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
            RequestId requestId = response.getRequestId();
            synchronized (this) {
                pairRemove = this.requests.remove(requestId);
            }
            if (pairRemove != null) {
                Function2 function2 = (Function2) pairRemove.getFirst();
                Function1 function1 = (Function1) pairRemove.getSecond();
                PurchaseUpdatesResponse.RequestStatus requestStatus = response.getRequestStatus();
                int i = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
                if (i == -1) {
                    invokeWithStoreProblem(function1, AmazonStrings.ERROR_PURCHASES_UPDATES_STORE_PROBLEM);
                    return;
                }
                if (i == 1) {
                    List<Receipt> receipts = response.getReceipts();
                    Intrinsics.checkNotNullExpressionValue(receipts, "response.receipts");
                    UserData userData = response.getUserData();
                    Intrinsics.checkNotNullExpressionValue(userData, "response.userData");
                    function2.invoke(receipts, userData);
                    return;
                }
                if (i == 2) {
                    invokeWithStoreProblem(function1, AmazonStrings.ERROR_FAILED_PURCHASES_UPDATES);
                } else {
                    if (i != 3) {
                        return;
                    }
                    invokeWithStoreProblem(function1, AmazonStrings.ERROR_UNSUPPORTED_PURCHASES_UPDATES);
                }
            }
        } catch (Exception e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseUpdatesResponse", e);
            throw e;
        }
    }

    private final void invokeWithStoreProblem(Function1 function1, String str) {
        function1.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }
}
