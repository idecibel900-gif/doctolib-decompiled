package expo.modules.webbrowser;

import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CustomTabsActivitiesHelperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomTabsIntent createDefaultCustomTabsIntent() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.intent.setData(Uri.parse("https://expo.dev"));
        return customTabsIntentBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Intent createDefaultCustomTabsServiceIntent() {
        Intent intent = new Intent();
        intent.setAction("android.support.customtabs.action.CustomTabsService");
        return intent;
    }
}
