package expo.modules.webbrowser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import expo.modules.kotlin.AppContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class CustomTabsActivitiesHelper {
    private final AppContext appContext;

    public CustomTabsActivitiesHelper(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    public final boolean canResolveIntent(CustomTabsIntent customTabsIntent) {
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        return !getResolvingActivities(customTabsIntent).isEmpty();
    }

    public final ArrayList getCustomTabsResolvingActivities() {
        List resolvingActivities = getResolvingActivities(CustomTabsActivitiesHelperKt.createDefaultCustomTabsIntent());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = resolvingActivities.iterator();
        while (it.hasNext()) {
            String packageName = ((ResolveInfo) it.next()).activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            linkedHashSet.add(packageName);
        }
        return new ArrayList(linkedHashSet);
    }

    public final ArrayList getCustomTabsResolvingServices() {
        List<ResolveInfo> listQueryIntentServices = getPackageManager().queryIntentServices(CustomTabsActivitiesHelperKt.createDefaultCustomTabsServiceIntent(), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "queryIntentServices(...)");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            String packageName = it.next().serviceInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            linkedHashSet.add(packageName);
        }
        return new ArrayList(linkedHashSet);
    }

    public final String getPreferredCustomTabsResolvingActivity(List list) {
        if (list == null) {
            list = getCustomTabsResolvingActivities();
        }
        return CustomTabsClient.getPackageName(getCurrentActivity(), list);
    }

    public final String getDefaultCustomTabsResolvingActivity() {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfoResolveActivity = getPackageManager().resolveActivity(CustomTabsActivitiesHelperKt.createDefaultCustomTabsIntent().intent, 0);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    public final void startCustomTabs(CustomTabsIntent tabsIntent, OpenBrowserOptions options) throws NoUrlProvidedException {
        Intrinsics.checkNotNullParameter(tabsIntent, "tabsIntent");
        Intrinsics.checkNotNullParameter(options, "options");
        Uri data = tabsIntent.intent.getData();
        if (data == null) {
            throw new NoUrlProvidedException();
        }
        if (!options.getShouldCreateTask()) {
            tabsIntent.launchUrl(getCurrentActivity(), data);
            return;
        }
        if (options.getUseProxyActivity()) {
            Intent intent = new Intent(getCurrentActivity(), (Class<?>) BrowserProxyActivity.class);
            intent.putExtra("expo.modules.webbrowser.EXTRA_URL", data.toString());
            intent.putExtra("expo.modules.webbrowser.EXTRA_CUSTOM_TABS_INTENT_DATA", tabsIntent.intent);
            intent.addFlags(268435456);
            getCurrentActivity().startActivity(intent);
            return;
        }
        tabsIntent.intent.addFlags(268435456);
        if (!options.getShowInRecents()) {
            tabsIntent.intent.addFlags(8388608);
            tabsIntent.intent.addFlags(1073741824);
        }
        tabsIntent.launchUrl(getCurrentActivity(), data);
    }

    private final List getResolvingActivities(CustomTabsIntent customTabsIntent) {
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(customTabsIntent.intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities;
    }

    private final PackageManager getPackageManager() throws PackageManagerNotFoundException {
        PackageManager packageManager = getCurrentActivity().getPackageManager();
        if (packageManager != null) {
            return packageManager;
        }
        throw new PackageManagerNotFoundException();
    }

    private final Activity getCurrentActivity() {
        return this.appContext.getThrowingActivity();
    }
}
