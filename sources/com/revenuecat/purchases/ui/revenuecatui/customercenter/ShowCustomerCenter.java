package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/ShowCustomerCenter;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "parseResult", "resultCode", "", "intent", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ShowCustomerCenter extends ActivityResultContract {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: parseResult, reason: collision with other method in class */
    public void m4342parseResult(int resultCode, Intent intent) {
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Object parseResult(int i, Intent intent) {
        m4342parseResult(i, intent);
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, Unit input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return CustomerCenterActivity.INSTANCE.createIntent$revenuecatui_defaultsBc8Release(context);
    }
}
