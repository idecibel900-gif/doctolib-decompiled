package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableKeyValidator;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015B]\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\r\u0010'\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0014H\u0002J\u001a\u0010*\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010+\u001a\u00020\u0014H\u0016J\u001a\u0010,\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010-\u001a\u00020\u00142\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/J\u0016\u00102\u001a\u00020\u00142\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u000e\u00103\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u00104\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u00105\u001a\u00020\u00142\b\u00106\u001a\u0004\u0018\u0001002\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007J\u0010\u00109\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010:\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&¨\u0006;²\u0006\n\u0010\u001f\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallView;", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "offering", "Lcom/revenuecat/purchases/Offering;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "shouldDisplayDismissButton", "", "dismissHandler", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "(Landroid/content/Context;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Ljava/lang/Boolean;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lkotlin/jvm/functions/Function0;)V", "initialFontProvider", "initialOfferingInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "internalListener", "value", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "paywallOptions", "getPaywallOptions", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "setPaywallOptions", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;)V", "paywallOptionsState", "Landroidx/compose/runtime/MutableState;", "Ljava/lang/Boolean;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dismiss", "init", "onBackPressed", "parseAttributes", "setCustomVariables", "variables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "setDismissHandler", "setDisplayDismissButton", "setFontProvider", "setOfferingId", "offeringId", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPaywallListener", "setPurchaseLogic", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallView extends CompatComposeView {
    public static final int $stable = 8;
    private Function0 dismissHandler;
    private FontProvider initialFontProvider;
    private OfferingSelection.IdAndPresentedOfferingContext initialOfferingInfo;
    private PaywallListener internalListener;
    private PaywallListener listener;
    private final MutableState paywallOptionsState;
    private PaywallPurchaseLogic purchaseLogic;
    private Boolean shouldDisplayDismissButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context) {
        this(context, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering) {
        this(context, offering, null, null, null, null, null, 124, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener) {
        this(context, offering, paywallListener, null, null, null, null, 120, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider) {
        this(context, offering, paywallListener, fontProvider, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool) {
        this(context, offering, paywallListener, fontProvider, bool, null, null, 96, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic) {
        this(context, offering, paywallListener, fontProvider, bool, paywallPurchaseLogic, null, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setOfferingId(String str) {
        setOfferingId$default(this, str, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4595invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4595invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
            }
        };
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4595invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4595invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
            }
        };
        init(context, attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, Function0 function0) {
        this(context, offering, paywallListener, fontProvider, bool, null, function0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : offering, (i & 4) != 0 ? null : paywallListener, (i & 8) != 0 ? null : fontProvider, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : paywallPurchaseLogic, (i & 64) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic, Function0 function0) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4595invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4595invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreInitiated(resume);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreError(error);
                }
            }
        };
        setPaywallListener(paywallListener);
        setDismissHandler(function0);
        setPurchaseLogic(paywallPurchaseLogic);
        if (offering != null) {
            String identifier = offering.getIdentifier();
            Package r9 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            setOfferingId(identifier, r9 != null ? r9.getPresentedOfferingContext() : null);
        }
        this.shouldDisplayDismissButton = bool;
        this.initialFontProvider = fontProvider;
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallOptions Content$lambda$4(MutableState mutableState) {
        return (PaywallOptions) mutableState.getValue();
    }

    private final PaywallOptions getPaywallOptions() {
        return (PaywallOptions) this.paywallOptionsState.getValue();
    }

    private final void setPaywallOptions(PaywallOptions paywallOptions) {
        this.paywallOptionsState.setValue(paywallOptions);
    }

    public final void setPaywallListener(PaywallListener listener) {
        this.listener = listener;
    }

    public final void setDismissHandler(Function0 dismissHandler) {
        this.dismissHandler = dismissHandler;
    }

    public final void setPurchaseLogic(PaywallPurchaseLogic purchaseLogic) {
        this.purchaseLogic = purchaseLogic;
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, null, null, purchaseLogic, null, null, null, null, 495, null));
    }

    public static /* synthetic */ void setOfferingId$default(PaywallView paywallView, String str, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
        if ((i & 2) != 0) {
            presentedOfferingContext = null;
        }
        paywallView.setOfferingId(str, presentedOfferingContext);
    }

    public final void setOfferingId(String offeringId, PresentedOfferingContext presentedOfferingContext) {
        OfferingSelection idAndPresentedOfferingContext;
        if (offeringId == null) {
            idAndPresentedOfferingContext = OfferingSelection.None.INSTANCE;
        } else {
            idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(offeringId, presentedOfferingContext);
        }
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), idAndPresentedOfferingContext, false, null, null, null, null, null, null, null, 510, null));
    }

    public final void setFontProvider(FontProvider fontProvider) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, fontProvider, null, null, null, null, null, null, 507, null));
    }

    public final void setDisplayDismissButton(boolean shouldDisplayDismissButton) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, shouldDisplayDismissButton, null, null, null, null, null, null, null, 509, null));
    }

    public final void setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, null, null, null, null, null, null, CustomVariableKeyValidator.INSTANCE.validateAndFilter(variables), 255, null));
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

    private final void init(Context context, AttributeSet attrs) {
        parseAttributes(context, attrs);
        PaywallOptions.Builder offeringIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release = new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.init.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4594invoke() {
                PaywallView.this.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4594invoke();
                return Unit.INSTANCE;
            }
        }).setListener(this.internalListener).setFontProvider(this.initialFontProvider).setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(this.initialOfferingInfo);
        Boolean bool = this.shouldDisplayDismissButton;
        setPaywallOptions(offeringIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release.setShouldDisplayDismissButton(bool != null ? bool.booleanValue() : false).setPurchaseLogic(this.purchaseLogic).build());
    }

    private final void parseAttributes(Context context, AttributeSet attrs) {
        PaywallViewAttributesReader.Companion companion = PaywallViewAttributesReader.INSTANCE;
        int[] PaywallView = R.styleable.PaywallView;
        Intrinsics.checkNotNullExpressionValue(PaywallView, "PaywallView");
        PaywallViewAttributesReader.PaywallViewAttributes attributes = companion.parseAttributes(context, attrs, PaywallView);
        if (attributes == null) {
            return;
        }
        String offeringId = attributes.getOfferingId();
        FontProvider fontProvider = attributes.getFontProvider();
        Boolean shouldDisplayDismissButton = attributes.getShouldDisplayDismissButton();
        this.initialOfferingInfo = offeringId != null ? new OfferingSelection.IdAndPresentedOfferingContext(offeringId, null) : null;
        this.initialFontProvider = fontProvider;
        this.shouldDisplayDismissButton = shouldDisplayDismissButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Function0 function0 = this.dismissHandler;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i) {
        composer.startReplaceGroup(1456977972);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1456977972, i, -1, "com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content (PaywallView.kt:228)");
        }
        composer.startReplaceGroup(502098637);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = this.paywallOptionsState;
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        composer.endReplaceGroup();
        RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.rememberComposableLambda(226220304, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content.1
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
                    ComposerKt.traceEventStart(226220304, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content.<anonymous> (PaywallView.kt:233)");
                }
                PaywallKt.Paywall(PaywallView.Content$lambda$4(mutableState), composer2, 0);
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
