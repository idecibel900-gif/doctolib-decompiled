package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/URLOpener;", "", "()V", "openURL", "", "context", "Landroid/content/Context;", "url", "", "method", "Lcom/revenuecat/purchases/ui/revenuecatui/utils/URLOpeningMethod;", "openURL$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class URLOpener {
    public static final int $stable = 0;
    public static final URLOpener INSTANCE = new URLOpener();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[URLOpeningMethod.values().length];
            try {
                iArr[URLOpeningMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[URLOpeningMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[URLOpeningMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private URLOpener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL$handleException(Context context, Exception exc) {
        String string;
        if (exc instanceof ActivityNotFoundException) {
            string = context.getString(R.string.no_browser_cannot_open_link);
        } else {
            string = context.getString(R.string.cannot_open_link);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (exception is Activit…_open_link)\n            }");
        Toast.makeText(context, string, 0).show();
        Logger.INSTANCE.e(string, exc);
    }

    public final /* synthetic */ void openURL$revenuecatui_defaultsBc8Release(Context context, String url, URLOpeningMethod method) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                UrisKt.openUriOrElse(context, url, new URLOpener$openURL$1(context));
                return;
            }
            return;
        }
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "Builder()\n                    .build()");
        try {
            customTabsIntentBuild.launchUrl(context, Uri.parse(url));
        } catch (ActivityNotFoundException e) {
            openURL$handleException(context, e);
        } catch (IllegalArgumentException e2) {
            openURL$handleException(context, e2);
        }
    }
}
