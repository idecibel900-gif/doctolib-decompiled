package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityArgs;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "args", "parseResult", "resultCode", "", "intent", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallContract extends ActivityResultContract {
    public static final int $stable = 0;

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, PaywallActivityArgs args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, "args");
        Intent intent = new Intent(context, (Class<?>) PaywallActivity.class);
        intent.putExtra(PaywallActivity.ARGS_EXTRA, args);
        return intent;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public PaywallResult parseResult(int resultCode, Intent intent) {
        PaywallResult paywallResult;
        if (resultCode != -1 || intent == null) {
            return PaywallResult.Cancelled.INSTANCE;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            paywallResult = (PaywallResult) intent.getParcelableExtra(PaywallActivity.RESULT_EXTRA, PaywallResult.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(PaywallActivity.RESULT_EXTRA);
            paywallResult = parcelableExtra instanceof PaywallResult ? (PaywallResult) parcelableExtra : null;
        }
        return paywallResult == null ? new PaywallResult.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "PaywallActivity returned null result")) : paywallResult;
    }
}
