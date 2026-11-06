package com.revenuecat.purchases.ui.revenuecatui.extensions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a1\u0010\b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "", "uri", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "fallbackAction", "openUriOrElse", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UrisKt {
    public static final void openUriOrElse(Context context, String uri, Function1 fallbackAction) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(fallbackAction, "fallbackAction");
        try {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
            } catch (ActivityNotFoundException e) {
                fallbackAction.invoke(e);
            }
        } catch (IllegalArgumentException e2) {
            fallbackAction.invoke(e2);
        }
    }
}
