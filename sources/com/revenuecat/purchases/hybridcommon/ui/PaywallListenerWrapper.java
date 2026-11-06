package com.revenuecat.purchases.hybridcommon.ui;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.hybridcommon.mappers.StoreTransactionMapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\f\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u000f\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0015\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH&¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "()V", "onPurchaseCompleted", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "", "", "", "onPurchaseError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchasePackageInitiated", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resume", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/Resumable;", "requestId", "onPurchaseStarted", "onRestoreCompleted", "onRestoreError", "Companion", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallListenerWrapper implements PaywallListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, Function1> pendingResumeCallbacks = new ConcurrentHashMap<>();

    public static final void resumePurchasePackageInitiated(String str, boolean z) {
        INSTANCE.resumePurchasePackageInitiated(str, z);
    }

    public abstract void onPurchaseCompleted(Map<String, ? extends Object> customerInfo, Map<String, ? extends Object> storeTransaction);

    public abstract void onPurchaseError(Map<String, ? extends Object> error);

    public abstract void onPurchaseStarted(Map<String, ? extends Object> rcPackage);

    public abstract void onRestoreCompleted(Map<String, ? extends Object> customerInfo);

    public abstract void onRestoreError(Map<String, ? extends Object> error);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onPurchaseCancelled() {
        PaywallListener.DefaultImpls.onPurchaseCancelled(this);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onRestoreInitiated(Resumable resumable) {
        PaywallListener.DefaultImpls.onRestoreInitiated(this, resumable);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onRestoreStarted() {
        PaywallListener.DefaultImpls.onRestoreStarted(this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallListenerWrapper$Companion;", "", "()V", "pendingResumeCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "", "", "resumePurchasePackageInitiated", "requestId", "shouldProceed", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void resumePurchasePackageInitiated(String requestId, boolean shouldProceed) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Function1 function1 = (Function1) PaywallListenerWrapper.pendingResumeCallbacks.remove(requestId);
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(shouldProceed));
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onPurchasePackageInitiated(Package rcPackage, final Resumable resume) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(resume, "resume");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        pendingResumeCallbacks.put(string, new Function1() { // from class: com.revenuecat.purchases.hybridcommon.ui.PaywallListenerWrapper.onPurchasePackageInitiated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                resume.invoke(z);
            }
        });
        onPurchasePackageInitiated(OfferingsMapperKt.map(rcPackage), string);
    }

    public void onPurchasePackageInitiated(Map<String, ? extends Object> rcPackage, String requestId) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        INSTANCE.resumePurchasePackageInitiated(requestId, true);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onPurchaseStarted(Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        onPurchaseStarted(OfferingsMapperKt.map(rcPackage));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        onPurchaseCompleted(CustomerInfoMapperKt.map(customerInfo), StoreTransactionMapperKt.map(storeTransaction));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onPurchaseError(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        onPurchaseError((Map<String, ? extends Object>) PurchasesErrorKt.map$default(error, null, 1, null).getInfo());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onRestoreCompleted(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        onRestoreCompleted(CustomerInfoMapperKt.map(customerInfo));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
    public void onRestoreError(PurchasesError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        onRestoreError((Map<String, ? extends Object>) PurchasesErrorKt.map$default(error, null, 1, null).getInfo());
    }
}
