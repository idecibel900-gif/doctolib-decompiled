package com.revenuecat.purchases.react.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/react/ui/views/WrappedCustomerCenterView;", "Lcom/revenuecat/purchases/react/ui/views/ComposeViewWrapper;", "Lcom/revenuecat/purchases/ui/revenuecatui/views/CustomerCenterView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createWrappedView", "attrs", "Landroid/util/AttributeSet;", "setDismissHandler", "", "dismissHandler", "Lkotlin/Function0;", "setCustomerCenterListener", "listener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "requestLayout", "measureAndLayout", "Ljava/lang/Runnable;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrappedCustomerCenterView extends ComposeViewWrapper<CustomerCenterView> {
    private final Runnable measureAndLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrappedCustomerCenterView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.measureAndLayout = new Runnable() { // from class: com.revenuecat.purchases.react.ui.views.WrappedCustomerCenterView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WrappedCustomerCenterView.measureAndLayout$lambda$0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.revenuecat.purchases.react.ui.views.ComposeViewWrapper
    public CustomerCenterView createWrappedView(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CustomerCenterView(context, attrs);
    }

    public final void setDismissHandler(Function0 dismissHandler) {
        CustomerCenterView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setDismissHandler(dismissHandler);
        }
    }

    public final void setCustomerCenterListener(CustomerCenterListener listener) {
        CustomerCenterView wrappedView = getWrappedView();
        if (wrappedView != null) {
            wrappedView.setCustomerCenterListener(listener);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureAndLayout$lambda$0(WrappedCustomerCenterView wrappedCustomerCenterView) {
        if (wrappedCustomerCenterView.isAttachedToWindow()) {
            wrappedCustomerCenterView.measure(View.MeasureSpec.makeMeasureSpec(wrappedCustomerCenterView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(wrappedCustomerCenterView.getHeight(), 1073741824));
            wrappedCustomerCenterView.layout(wrappedCustomerCenterView.getLeft(), wrappedCustomerCenterView.getTop(), wrappedCustomerCenterView.getRight(), wrappedCustomerCenterView.getBottom());
        }
    }
}
