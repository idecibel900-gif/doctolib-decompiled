package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBO\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010&\u001a\u00020\u00142\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0010\u0010'\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u001c\u0010+\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0007J\u0010\u0010.\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/OriginalTemplatePaywallFooterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "offering", "Lcom/revenuecat/purchases/Offering;", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "condensed", "", "dismissHandler", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;ZLkotlin/jvm/functions/Function0;)V", "initialCondensed", "initialFontProvider", "initialOfferingInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "internalListener", "value", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "paywallOptions", "getPaywallOptions", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "setPaywallOptions", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;)V", "paywallOptionsState", "Landroidx/compose/runtime/MutableState;", "init", "parseAttributes", "setDismissHandler", "setFontProvider", "setOfferingId", "offeringId", "", "setOfferingIdAndPresentedOfferingContext", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPaywallListener", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class OriginalTemplatePaywallFooterView extends FrameLayout {
    public static final int $stable = 8;
    private Function0 dismissHandler;
    private boolean initialCondensed;
    private FontProvider initialFontProvider;
    private OfferingSelection.IdAndPresentedOfferingContext initialOfferingInfo;
    private PaywallListener internalListener;
    private PaywallListener listener;
    private final MutableState paywallOptionsState;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context) {
        this(context, null, null, null, false, null, 62, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering) {
        this(context, offering, null, null, false, null, 60, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener) {
        this(context, offering, paywallListener, null, false, null, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider) {
        this(context, offering, paywallListener, fontProvider, false, null, 48, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z) {
        this(context, offering, paywallListener, fontProvider, z, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4593invoke() {
                Function0 function0 = this.this$0.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4593invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package r1, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r1, resumable);
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
    public OriginalTemplatePaywallFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4593invoke() {
                Function0 function0 = this.this$0.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4593invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package r1, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r1, resumable);
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

    public /* synthetic */ OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : offering, (i & 4) != 0 ? null : paywallListener, (i & 8) != 0 ? null : fontProvider, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : function0);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0017¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"com/revenuecat/purchases/ui/revenuecatui/views/OriginalTemplatePaywallFooterView$init$2", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CompatComposeView;", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release", "paywallOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends CompatComposeView {
        final /* synthetic */ OriginalTemplatePaywallFooterView this$0;

        /* JADX INFO: Access modifiers changed from: private */
        public static final PaywallOptions Content$lambda$1(MutableState mutableState) {
            return (PaywallOptions) mutableState.getValue();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView) {
            super(context, null, 0, 6, null);
            this.this$0 = originalTemplatePaywallFooterView;
        }

        @Override // androidx.compose.ui.platform.AbstractComposeView
        public void Content(Composer composer, int i) {
            composer.startReplaceGroup(951143030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(951143030, i, -1, "com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.<no name provided>.Content (OriginalTemplatePaywallFooterView.kt:192)");
            }
            composer.startReplaceGroup(-704718066);
            OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView = this.this$0;
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = originalTemplatePaywallFooterView.paywallOptionsState;
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composer.endReplaceGroup();
            final OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView2 = this.this$0;
            RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.rememberComposableLambda(-1757622246, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$init$2$Content$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1757622246, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.<no name provided>.Content.<anonymous> (OriginalTemplatePaywallFooterView.kt:197)");
                        }
                        PaywallFooterKt.OriginalTemplatePaywallFooter(OriginalTemplatePaywallFooterView.AnonymousClass2.Content$lambda$1(mutableState), originalTemplatePaywallFooterView2.initialCondensed, null, composer2, 0, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z, Function0 function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4593invoke() {
                Function0 function1 = this.this$0.dismissHandler;
                if (function1 != null) {
                    function1.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4593invoke();
                return Unit.INSTANCE;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package r1, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r1, resumable);
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
        setOfferingId(offering != null ? offering.getIdentifier() : null);
        this.initialFontProvider = fontProvider;
        this.initialCondensed = z;
        init(context, null);
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

    @Deprecated
    public final void setOfferingId(String offeringId) {
        OfferingSelection idAndPresentedOfferingContext;
        if (offeringId == null) {
            idAndPresentedOfferingContext = OfferingSelection.None.INSTANCE;
        } else {
            idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(offeringId, null);
        }
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), idAndPresentedOfferingContext, false, null, null, null, null, null, null, null, 510, null));
    }

    @InternalRevenueCatAPI
    public final void setOfferingIdAndPresentedOfferingContext(String offeringId, PresentedOfferingContext presentedOfferingContext) {
        if (offeringId == null) {
            setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), OfferingSelection.None.INSTANCE, false, null, null, null, null, null, null, null, 510, null));
        } else {
            setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), new OfferingSelection.IdAndPresentedOfferingContext(offeringId, presentedOfferingContext), false, null, null, null, null, null, null, null, 510, null));
        }
    }

    public final void setFontProvider(FontProvider fontProvider) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, fontProvider, null, null, null, null, null, null, 507, null));
    }

    private final void init(Context context, AttributeSet attrs) {
        parseAttributes(context, attrs);
        setPaywallOptions(new PaywallOptions.Builder(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m4592invoke() {
                Function0 function0 = OriginalTemplatePaywallFooterView.this.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m4592invoke();
                return Unit.INSTANCE;
            }
        }).setListener(this.internalListener).setFontProvider(this.initialFontProvider).setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(this.initialOfferingInfo).build());
        addView(new AnonymousClass2(context, this));
    }

    private final void parseAttributes(Context context, AttributeSet attrs) {
        PaywallViewAttributesReader.Companion companion = PaywallViewAttributesReader.INSTANCE;
        int[] PaywallFooterView = R.styleable.PaywallFooterView;
        Intrinsics.checkNotNullExpressionValue(PaywallFooterView, "PaywallFooterView");
        PaywallViewAttributesReader.PaywallViewAttributes attributes = companion.parseAttributes(context, attrs, PaywallFooterView);
        if (attributes == null) {
            return;
        }
        String offeringId = attributes.getOfferingId();
        FontProvider fontProvider = attributes.getFontProvider();
        Boolean condensed = attributes.getCondensed();
        this.initialOfferingInfo = offeringId != null ? new OfferingSelection.IdAndPresentedOfferingContext(offeringId, null) : null;
        this.initialFontProvider = fontProvider;
        if (condensed != null) {
            this.initialCondensed = condensed.booleanValue();
        }
    }
}
