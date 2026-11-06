package com.revenuecat.purchases.ui.revenuecatui.data;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010!\u001a\u00020\"H¦@¢\u0006\u0002\u0010\u0017J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020(H¦@¢\u0006\u0002\u0010\u0017J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H¦@¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u0017J\u000e\u0010/\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u0017J\b\u00100\u001a\u000201H&J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "preferredUILocaleOverride", "", "getPreferredUILocaleOverride", "()Ljava/lang/String;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "storefrontCountryCode", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", AuthorizationRequest.Scope.EMAIL, b.c, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowDataResult;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "track", "event", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PurchasesType {
    Object awaitCreateSupportTicket(String str, String str2, Continuation continuation) throws PurchasesException;

    Object awaitCustomerCenterConfigData(Continuation continuation);

    Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation continuation);

    Object awaitGetProduct(String str, String str2, Continuation continuation);

    Object awaitGetVirtualCurrencies(Continuation continuation) throws PurchasesException;

    Object awaitGetWorkflow(String str, Continuation continuation) throws PurchasesException;

    Object awaitOfferings(Continuation continuation);

    Object awaitPurchase(PurchaseParams.Builder builder, Continuation continuation);

    Object awaitRestore(Continuation continuation);

    Object awaitSyncPurchases(Continuation continuation);

    CustomerCenterListener getCustomerCenterListener();

    String getPreferredUILocaleOverride();

    PurchasesAreCompletedBy getPurchasesAreCompletedBy();

    String getStorefrontCountryCode();

    void invalidateVirtualCurrenciesCache();

    void track(FeatureEvent event);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object awaitCustomerInfo$default(PurchasesType purchasesType, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCustomerInfo");
            }
            if ((i & 1) != 0) {
                cacheFetchPolicy = CacheFetchPolicy.INSTANCE.m3736default();
            }
            return purchasesType.awaitCustomerInfo(cacheFetchPolicy, continuation);
        }
    }
}
