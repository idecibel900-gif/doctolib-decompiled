package com.revenuecat.purchases.react.ui;

import android.view.View;
import com.facebook.react.uimanager.UIManagerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"surfaceId", "", "Landroid/view/View;", "getSurfaceId", "(Landroid/view/View;)I", "react-native-purchases-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ViewExtensionsKt {
    public static final int getSurfaceId(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return UIManagerHelper.getSurfaceId(view);
    }
}
