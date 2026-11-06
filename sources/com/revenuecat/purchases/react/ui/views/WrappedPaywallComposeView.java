package com.revenuecat.purchases.react.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.views.PaywallView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001c\u001a\u00020\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0010\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020\u000bH\u0016R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/react/ui/views/WrappedPaywallComposeView;", "Lcom/revenuecat/purchases/react/ui/views/ComposeViewWrapper;", "Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createWrappedView", "attrs", "Landroid/util/AttributeSet;", "setPaywallListener", "", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "setDismissHandler", "dismissHandler", "Lkotlin/Function0;", "setOfferingId", "offeringId", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "setFontProvider", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "setDisplayDismissButton", "shouldDisplayDismissButton", "", "setCustomVariables", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "setPurchaseLogic", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogic;", "requestLayout", "measureAndLayout", "Ljava/lang/Runnable;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrappedPaywallComposeView extends ComposeViewWrapper<PaywallView> {
    private final Runnable measureAndLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrappedPaywallComposeView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.measureAndLayout = new Runnable() { // from class: com.revenuecat.purchases.react.ui.views.WrappedPaywallComposeView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WrappedPaywallComposeView.measureAndLayout$lambda$0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.revenuecat.purchases.react.ui.views.ComposeViewWrapper
    public PaywallView createWrappedView(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PaywallView(context, attrs);
    }

    public final void setPaywallListener(PaywallListener listener) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setPaywallListener(listener);
        }
    }

    public final void setDismissHandler(Function0 dismissHandler) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setDismissHandler(dismissHandler);
        }
    }

    public static /* synthetic */ void setOfferingId$default(WrappedPaywallComposeView wrappedPaywallComposeView, String str, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
        if ((i & 2) != 0) {
            presentedOfferingContext = null;
        }
        wrappedPaywallComposeView.setOfferingId(str, presentedOfferingContext);
    }

    public final void setOfferingId(String offeringId, PresentedOfferingContext presentedOfferingContext) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setOfferingId(offeringId, presentedOfferingContext);
        }
    }

    public final void setFontProvider(FontProvider fontProvider) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setFontProvider(fontProvider);
        }
    }

    public final void setDisplayDismissButton(boolean shouldDisplayDismissButton) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setDisplayDismissButton(shouldDisplayDismissButton);
        }
    }

    public final void setCustomVariables(Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setCustomVariables(customVariables);
        }
    }

    public final void setPurchaseLogic(PurchaseLogic purchaseLogic) {
        PaywallView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setPurchaseLogic(purchaseLogic);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureAndLayout$lambda$0(WrappedPaywallComposeView wrappedPaywallComposeView) {
        if (wrappedPaywallComposeView.isAttachedToWindow()) {
            wrappedPaywallComposeView.measure(View.MeasureSpec.makeMeasureSpec(wrappedPaywallComposeView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(wrappedPaywallComposeView.getHeight(), 1073741824));
            wrappedPaywallComposeView.layout(wrappedPaywallComposeView.getLeft(), wrappedPaywallComposeView.getTop(), wrappedPaywallComposeView.getRight(), wrappedPaywallComposeView.getBottom());
        }
    }
}
