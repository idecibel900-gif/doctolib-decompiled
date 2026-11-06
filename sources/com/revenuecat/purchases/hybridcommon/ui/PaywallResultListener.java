package com.revenuecat.purchases.hybridcommon.ui;

import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallResultListener;", "", "onPaywallResult", "", "paywallResult", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallResultListener {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onPaywallResult(PaywallResultListener paywallResultListener, PaywallResult paywallResult) {
            Intrinsics.checkNotNullParameter(paywallResult, "paywallResult");
        }
    }

    @Deprecated
    void onPaywallResult(PaywallResult paywallResult);

    void onPaywallResult(String paywallResult);
}
