package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.customercenter.CustomerCenterManagementOption;
import com.revenuecat.purchases.customercenter.Resumable;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\n*\u0001\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\r\u0010\u0016\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u001c\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/CustomerCenterView;", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dismissHandler", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Landroid/content/Context;Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;Lkotlin/jvm/functions/Function0;)V", "customerCenterOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions;", "internalListener", "com/revenuecat/purchases/ui/revenuecatui/views/CustomerCenterView$internalListener$1", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CustomerCenterView$internalListener$1;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dismiss", "init", "onBackPressed", "setCustomerCenterListener", "setDismissHandler", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterView extends CompatComposeView {
    public static final int $stable = 8;
    private CustomerCenterListener customerCenterListener;
    private final CustomerCenterOptions customerCenterOptions;
    private Function0 dismissHandler;
    private final CustomerCenterView$internalListener$1 internalListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context) {
        this(context, null, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context, CustomerCenterListener customerCenterListener) {
        this(context, customerCenterListener, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r8 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onShowingManageSubscriptions();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String purchaseIdentifier) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onCustomActionSelected(actionIdentifier, purchaseIdentifier);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }
        };
        this.internalListener = r8;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r8).build();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r2 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onShowingManageSubscriptions();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String purchaseIdentifier) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onCustomActionSelected(actionIdentifier, purchaseIdentifier);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }
        };
        this.internalListener = r2;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r2).build();
        init();
    }

    public /* synthetic */ CustomerCenterView(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context, Function0 function0) {
        this(context, (CustomerCenterListener) null, function0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomerCenterView(Context context, CustomerCenterListener customerCenterListener, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : customerCenterListener, (i & 4) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, CustomerCenterListener customerCenterListener, Function0 function0) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r8 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onShowingManageSubscriptions();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String purchaseIdentifier) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onCustomActionSelected(actionIdentifier, purchaseIdentifier);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }
        };
        this.internalListener = r8;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r8).build();
        this.customerCenterListener = customerCenterListener;
        this.dismissHandler = function0;
        init();
    }

    public final void setDismissHandler(Function0 dismissHandler) {
        this.dismissHandler = dismissHandler;
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.customerCenterListener = customerCenterListener;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView
    public void onBackPressed() {
        Unit unit;
        if (this.dismissHandler != null) {
            dismiss();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onBackPressed();
        }
    }

    private final void init() {
        Logger.INSTANCE.d("Initialized CustomerCenterView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Function0 function0 = this.dismissHandler;
        if (function0 != null) {
            function0.invoke();
        }
        destroy();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i) {
        composer.startReplaceGroup(1372663828);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1372663828, i, -1, "com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content (CustomerCenterView.kt:130)");
        }
        RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.rememberComposableLambda(1061986288, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1061986288, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content.<anonymous> (CustomerCenterView.kt:132)");
                }
                CustomerCenterOptions customerCenterOptions = CustomerCenterView.this.customerCenterOptions;
                composer2.startReplaceGroup(573881428);
                boolean zChangedInstance = composer2.changedInstance(CustomerCenterView.this);
                final CustomerCenterView customerCenterView = CustomerCenterView.this;
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$Content$1$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m4591invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m4591invoke() {
                            customerCenterView.dismiss();
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                composer2.endReplaceGroup();
                CustomerCenterKt.CustomerCenter(null, customerCenterOptions, (Function0) objRememberedValue, composer2, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
