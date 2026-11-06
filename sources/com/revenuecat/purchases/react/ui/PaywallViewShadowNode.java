package com.revenuecat.purchases.react.ui;

import android.view.View;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/react/ui/PaywallViewShadowNode;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "Lcom/facebook/yoga/YogaMeasureFunction;", "<init>", "()V", "measure", "", "yogaNode", "Lcom/facebook/yoga/YogaNode;", "width", "", "yogaMeasureMode", "Lcom/facebook/yoga/YogaMeasureMode;", "height", "yogaMeasureMode1", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaywallViewShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    public PaywallViewShadowNode() {
        setMeasureFunction(this);
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public long measure(YogaNode yogaNode, float width, YogaMeasureMode yogaMeasureMode, float height, YogaMeasureMode yogaMeasureMode1) {
        Intrinsics.checkNotNullParameter(yogaNode, "yogaNode");
        Intrinsics.checkNotNullParameter(yogaMeasureMode, "yogaMeasureMode");
        Intrinsics.checkNotNullParameter(yogaMeasureMode1, "yogaMeasureMode1");
        return YogaMeasureOutput.make(View.MeasureSpec.getSize((int) width), View.MeasureSpec.getSize((int) height));
    }
}
