package com.revenuecat.purchases.ui.revenuecatui.data;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010\u0018J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u0018J\u000e\u00100\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u0018J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u000205H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u00066"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/MockPurchasesType;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "preferredUILocaleOverride", "", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "storefrontCountryCode", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Ljava/lang/String;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getPreferredUILocaleOverride", "()Ljava/lang/String;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", AuthorizationRequest.Scope.EMAIL, b.c, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowDataResult;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "track", "event", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MockPurchasesType implements PurchasesType {
    public static final int $stable = 8;
    private final CustomerCenterListener customerCenterListener;
    private final String preferredUILocaleOverride;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final String storefrontCountryCode;

    public MockPurchasesType() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public MockPurchasesType(String str, PurchasesAreCompletedBy purchasesAreCompletedBy, String str2, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        this.preferredUILocaleOverride = str;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.storefrontCountryCode = str2;
        this.customerCenterListener = customerCenterListener;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.preferredUILocaleOverride;
    }

    public /* synthetic */ MockPurchasesType(String str, PurchasesAreCompletedBy purchasesAreCompletedBy, String str2, CustomerCenterListener customerCenterListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? PurchasesAreCompletedBy.REVENUECAT : purchasesAreCompletedBy, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : customerCenterListener);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetProduct(String str, String str2, Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation continuation) {
        return new CreateSupportTicketResult(true);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetWorkflow(String str, Continuation continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }
}
