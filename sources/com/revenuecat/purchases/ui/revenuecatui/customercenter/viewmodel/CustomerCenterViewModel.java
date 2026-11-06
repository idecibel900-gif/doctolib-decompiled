package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.app.Activity;
import android.content.Context;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.customercenter.CustomActionData;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H&J\u000e\u0010\u0016\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH&J:\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H¦@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\rH§@¢\u0006\u0002\u0010\u0017J \u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H¦@¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\rH&J\b\u0010*\u001a\u00020\rH&J\u0010\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u001aH&J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/H&J\u001e\u00100\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020\r02H&J\"\u00103\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u000206H&J\"\u00107\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010 H&J\u0018\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001aH&J\u000e\u0010=\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0017J\b\u0010>\u001a\u00020\rH&J\u000e\u0010?\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0017J\u0010\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020 H&J\b\u0010B\u001a\u00020\rH&J\u0010\u0010C\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010D\u001a\u00020\rH&J\b\u0010E\u001a\u00020\rH&R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/CustomerCenterViewModel;", "", "actionError", "Landroidx/compose/runtime/State;", "Lcom/revenuecat/purchases/PurchasesError;", "getActionError", "()Landroidx/compose/runtime/State;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearActionError", "", "contactSupport", "context", "Landroid/content/Context;", "supportEmail", "", "dismissPromotionalOffer", "originalPath", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "dismissRestoreDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissSupportTicketSuccessSnackbar", "loadAndDisplayPromotionalOffer", "", "product", "Lcom/revenuecat/purchases/models/StoreProduct;", "promotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "(Landroid/content/Context;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCustomerCenter", "onAcceptedPromotionalOffer", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "activity", "Landroid/app/Activity;", "(Lcom/revenuecat/purchases/models/SubscriptionOption;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResumed", "onActivityStarted", "onActivityStopped", "isChangingConfigurations", "onCustomActionSelected", "customActionData", "Lcom/revenuecat/purchases/customercenter/CustomActionData;", "onNavigationButtonPressed", "onDismiss", "Lkotlin/Function0;", "openURL", "url", "method", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "pathButtonPressed", "path", "refreshColors", "currentColorScheme", "Landroidx/compose/material3/ColorScheme;", "isSystemInDarkTheme", "refreshCustomerCenter", "refreshStateIfLocaleChanged", "restorePurchases", "selectPurchase", "purchase", "showCreateSupportTicket", "showPaywall", "showVirtualCurrencyBalances", "trackImpressionIfNeeded", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CustomerCenterViewModel {
    void clearActionError();

    void contactSupport(Context context, String supportEmail);

    void dismissPromotionalOffer(Context context, CustomerCenterConfigData.HelpPath originalPath);

    Object dismissRestoreDialog(Continuation continuation);

    void dismissSupportTicketSuccessSnackbar();

    State getActionError();

    StateFlow getState();

    Object loadAndDisplayPromotionalOffer(Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation continuation);

    @InternalRevenueCatAPI
    Object loadCustomerCenter(Continuation continuation);

    Object onAcceptedPromotionalOffer(SubscriptionOption subscriptionOption, Activity activity, Continuation continuation);

    void onActivityResumed();

    void onActivityStarted();

    void onActivityStopped(boolean isChangingConfigurations);

    void onCustomActionSelected(CustomActionData customActionData);

    void onNavigationButtonPressed(Context context, Function0 onDismiss);

    void openURL(Context context, String url, CustomerCenterConfigData.HelpPath.OpenMethod method);

    void pathButtonPressed(Context context, CustomerCenterConfigData.HelpPath path, PurchaseInformation product);

    void refreshColors(ColorScheme currentColorScheme, boolean isSystemInDarkTheme);

    Object refreshCustomerCenter(Continuation continuation);

    void refreshStateIfLocaleChanged();

    Object restorePurchases(Continuation continuation);

    void selectPurchase(PurchaseInformation purchase);

    void showCreateSupportTicket();

    void showPaywall(Context context);

    void showVirtualCurrencyBalances();

    void trackImpressionIfNeeded();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object loadAndDisplayPromotionalOffer$default(CustomerCenterViewModel customerCenterViewModel, Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAndDisplayPromotionalOffer");
            }
            if ((i & 16) != 0) {
                purchaseInformation = null;
            }
            return customerCenterViewModel.loadAndDisplayPromotionalOffer(context, storeProduct, promotionalOffer, helpPath, purchaseInformation, continuation);
        }

        public static /* synthetic */ void openURL$default(CustomerCenterViewModel customerCenterViewModel, Context context, String str, CustomerCenterConfigData.HelpPath.OpenMethod openMethod, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openURL");
            }
            if ((i & 4) != 0) {
                openMethod = CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL;
            }
            customerCenterViewModel.openURL(context, str, openMethod);
        }
    }
}
