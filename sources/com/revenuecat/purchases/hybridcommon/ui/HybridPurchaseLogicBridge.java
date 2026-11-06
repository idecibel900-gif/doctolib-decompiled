package com.revenuecat.purchases.hybridcommon.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogicParams;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicResult;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aBO\u0012\"\u0010\u0007\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\"\u0010\b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017R0\u0010\u0007\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R0\u0010\b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogic;", "Lkotlin/Function1;", "", "", "", "", "onPerformPurchase", "onPerformRestore", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Landroid/app/Activity;", "activity", "Lcom/revenuecat/purchases/Package;", "rcPackage", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "performPurchase", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "performRestore", "(Lcom/revenuecat/purchases/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPending", "()V", "Lkotlin/jvm/functions/Function1;", "Companion", "PendingRequest", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HybridPurchaseLogicBridge implements PurchaseLogic {
    public static final String EVENT_KEY_PACKAGE_BEING_PURCHASED = "packageBeingPurchased";
    public static final String EVENT_KEY_REQUEST_ID = "requestId";
    public static final String RESULT_CANCELLATION = "CANCELLATION";
    public static final String RESULT_ERROR = "ERROR";
    public static final String RESULT_SUCCESS = "SUCCESS";
    private static final String TAG = "HybridPurchaseLogicBridge";
    private final Function1 onPerformPurchase;
    private final Function1 onPerformRestore;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, PendingRequest> pendingRequests = new ConcurrentHashMap<>();

    public static final void resolveResult(String str, String str2, String str3) {
        INSTANCE.resolveResult(str, str2, str3);
    }

    public HybridPurchaseLogicBridge(Function1 function1, Function1 function2) {
        this.onPerformPurchase = function1;
        this.onPerformRestore = function2;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic, com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation continuation) {
        return PurchaseLogic.DefaultImpls.performPurchase(this, activity, paywallPurchaseLogicParams, continuation);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$Companion;", "", "()V", "EVENT_KEY_PACKAGE_BEING_PURCHASED", "", "EVENT_KEY_REQUEST_ID", "RESULT_CANCELLATION", "RESULT_ERROR", "RESULT_SUCCESS", "TAG", "pendingRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest;", "resolveResult", "", "requestId", "resultString", b.f, "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void resolveResult$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            companion.resolveResult(str, str2, str3);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0059  */
        /* JADX WARN: Code duplicated, block: B:27:0x0061  */
        /* JADX WARN: Instruction removed from duplicated block: B:27:0x0061, please report this as an issue */
        public final void resolveResult(String requestId, String resultString, String errorMessage) {
            Object error;
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(resultString, "resultString");
            PendingRequest pendingRequest = (PendingRequest) HybridPurchaseLogicBridge.pendingRequests.remove(requestId);
            if (pendingRequest == null) {
                return;
            }
            int iHashCode = resultString.hashCode();
            if (iHashCode != -1149187101) {
                if (iHashCode != 66247144) {
                    if (iHashCode == 1196388611 && resultString.equals(HybridPurchaseLogicBridge.RESULT_CANCELLATION)) {
                        error = PurchaseLogicResult.Cancellation.INSTANCE;
                    } else {
                        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
                        if (errorMessage == null) {
                            errorMessage = "Unknown result: " + resultString;
                        }
                        error = new PurchaseLogicResult.Error(new PurchasesError(purchasesErrorCode, errorMessage));
                    }
                } else if (resultString.equals(HybridPurchaseLogicBridge.RESULT_ERROR)) {
                    PurchasesErrorCode purchasesErrorCode2 = PurchasesErrorCode.UnknownError;
                    if (errorMessage == null) {
                        errorMessage = "Operation failed";
                    }
                    error = new PurchaseLogicResult.Error(new PurchasesError(purchasesErrorCode2, errorMessage));
                } else {
                    PurchasesErrorCode purchasesErrorCode3 = PurchasesErrorCode.UnknownError;
                    if (errorMessage == null) {
                        errorMessage = "Unknown result: " + resultString;
                    }
                    error = new PurchaseLogicResult.Error(new PurchasesError(purchasesErrorCode3, errorMessage));
                }
            } else if (resultString.equals(HybridPurchaseLogicBridge.RESULT_SUCCESS)) {
                error = PurchaseLogicResult.Success.INSTANCE;
            } else {
                PurchasesErrorCode purchasesErrorCode4 = PurchasesErrorCode.UnknownError;
                if (errorMessage == null) {
                    errorMessage = "Unknown result: " + resultString;
                }
                error = new PurchaseLogicResult.Error(new PurchasesError(purchasesErrorCode4, errorMessage));
            }
            pendingRequest.getDeferred().complete(error);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\f\rB\u001d\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest;", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "owner", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "(Lkotlinx/coroutines/CompletableDeferred;Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;)V", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "getOwner", "()Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "Purchase", "Restore", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest$Purchase;", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest$Restore;", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static abstract class PendingRequest {
        private final CompletableDeferred deferred;
        private final HybridPurchaseLogicBridge owner;

        public /* synthetic */ PendingRequest(CompletableDeferred completableDeferred, HybridPurchaseLogicBridge hybridPurchaseLogicBridge, DefaultConstructorMarker defaultConstructorMarker) {
            this(completableDeferred, hybridPurchaseLogicBridge);
        }

        private PendingRequest(CompletableDeferred completableDeferred, HybridPurchaseLogicBridge hybridPurchaseLogicBridge) {
            this.deferred = completableDeferred;
            this.owner = hybridPurchaseLogicBridge;
        }

        public final CompletableDeferred getDeferred() {
            return this.deferred;
        }

        public final HybridPurchaseLogicBridge getOwner() {
            return this.owner;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest$Purchase;", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "owner", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "(Lkotlinx/coroutines/CompletableDeferred;Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;)V", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Purchase extends PendingRequest {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Purchase(CompletableDeferred deferred, HybridPurchaseLogicBridge owner) {
                super(deferred, owner, null);
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                Intrinsics.checkNotNullParameter(owner, "owner");
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest$Restore;", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge$PendingRequest;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "owner", "Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;", "(Lkotlinx/coroutines/CompletableDeferred;Lcom/revenuecat/purchases/hybridcommon/ui/HybridPurchaseLogicBridge;)V", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Restore extends PendingRequest {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Restore(CompletableDeferred deferred, HybridPurchaseLogicBridge owner) {
                super(deferred, owner, null);
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                Intrinsics.checkNotNullParameter(owner, "owner");
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic
    public Object performPurchase(Activity activity, Package r6, Continuation continuation) {
        final Function1 function1 = this.onPerformPurchase;
        if (function1 == null) {
            return new PurchaseLogicResult.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "No onPerformPurchase handler registered"));
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        pendingRequests.put(string, new PendingRequest.Purchase(completableDeferredCompletableDeferred$default, this));
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to("requestId", string), TuplesKt.to(EVENT_KEY_PACKAGE_BEING_PURCHASED, OfferingsMapperKt.map(r6)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(mapMapOf);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public Object performRestore(CustomerInfo customerInfo, Continuation continuation) {
        final Function1 function1 = this.onPerformRestore;
        if (function1 == null) {
            return new PurchaseLogicResult.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "No onPerformRestore handler registered"));
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        pendingRequests.put(string, new PendingRequest.Restore(completableDeferredCompletableDeferred$default, this));
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.to("requestId", string));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(mapMapOf);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    public final void cancelPending() {
        Iterator<Map.Entry<String, PendingRequest>> it = pendingRequests.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, PendingRequest> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            Map.Entry<String, PendingRequest> entry = next;
            if (entry.getValue().getOwner() == this) {
                it.remove();
                entry.getValue().getDeferred().complete(PurchaseLogicResult.Cancellation.INSTANCE);
            }
        }
    }
}
