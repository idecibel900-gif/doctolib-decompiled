package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextExtensionsKt {
    public static final /* synthetic */ Activity getActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "currentContext.baseContext");
        }
        return null;
    }
}
