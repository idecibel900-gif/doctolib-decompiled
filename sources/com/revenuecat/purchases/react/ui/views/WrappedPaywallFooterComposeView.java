package com.revenuecat.purchases.react.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.fonts.CustomFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/react/ui/views/WrappedPaywallFooterComposeView;", "Lcom/revenuecat/purchases/react/ui/views/ComposeViewWrapper;", "Lcom/revenuecat/purchases/ui/revenuecatui/views/OriginalTemplatePaywallFooterView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createWrappedView", "attrs", "Landroid/util/AttributeSet;", "setOfferingId", "", "offeringId", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "setFontProvider", "customFontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/CustomFontProvider;", "setPaywallListener", "listener", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "setDismissHandler", "handler", "Lkotlin/Function0;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WrappedPaywallFooterComposeView extends ComposeViewWrapper<OriginalTemplatePaywallFooterView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrappedPaywallFooterComposeView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.revenuecat.purchases.react.ui.views.ComposeViewWrapper
    public OriginalTemplatePaywallFooterView createWrappedView(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new OriginalTemplatePaywallFooterView(context, attrs);
    }

    public static /* synthetic */ void setOfferingId$default(WrappedPaywallFooterComposeView wrappedPaywallFooterComposeView, String str, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOfferingId");
        }
        if ((i & 2) != 0) {
            presentedOfferingContext = null;
        }
        wrappedPaywallFooterComposeView.setOfferingId(str, presentedOfferingContext);
    }

    public final void setOfferingId(String offeringId, PresentedOfferingContext presentedOfferingContext) {
        if (offeringId == null) {
            OriginalTemplatePaywallFooterView wrappedView = getWrappedView();
            if (wrappedView != null) {
                wrappedView.setOfferingId(null);
                return;
            }
            return;
        }
        if (presentedOfferingContext == null) {
            presentedOfferingContext = new PresentedOfferingContext(offeringId);
        }
        OriginalTemplatePaywallFooterView wrappedView2 = getWrappedView();
        if (wrappedView2 != null) {
            wrappedView2.setOfferingIdAndPresentedOfferingContext(offeringId, presentedOfferingContext);
        }
    }

    public final void setFontProvider(CustomFontProvider customFontProvider) {
        Intrinsics.checkNotNullParameter(customFontProvider, "customFontProvider");
        OriginalTemplatePaywallFooterView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setFontProvider(customFontProvider);
        }
    }

    public final void setPaywallListener(PaywallListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        OriginalTemplatePaywallFooterView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setPaywallListener(listener);
        }
    }

    public final void setDismissHandler(Function0 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        OriginalTemplatePaywallFooterView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setDismissHandler(handler);
        }
    }
}
