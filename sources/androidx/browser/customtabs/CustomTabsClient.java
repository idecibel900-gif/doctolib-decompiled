package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsClient {
    private final Context mApplicationContext;
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = context;
    }

    public static boolean bindCustomTabsService(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static String getPackageName(Context context, List list) {
        return getPackageName(context, list, false);
    }

    public static String getPackageName(Context context, List list, boolean z) {
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        return null;
    }

    public boolean warmup(long j) {
        try {
            return this.mService.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        return newSessionInternal(customTabsCallback, null);
    }

    private CustomTabsSession newSessionInternal(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean zNewSession;
        ICustomTabsCallback.Stub stubCreateCallbackWrapper = createCallbackWrapper(customTabsCallback);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                zNewSession = this.mService.newSessionWithExtras(stubCreateCallbackWrapper, bundle);
            } else {
                zNewSession = this.mService.newSession(stubCreateCallbackWrapper);
            }
            if (zNewSession) {
                return new CustomTabsSession(this.mService, stubCreateCallbackWrapper, this.mServiceComponentName, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    private ICustomTabsCallback.Stub createCallbackWrapper(CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub(customTabsCallback) { // from class: androidx.browser.customtabs.CustomTabsClient.2
            private Handler mHandler = new Handler(Looper.getMainLooper());

            @Override // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(String str, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String str, Bundle bundle) {
                return null;
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onActivityLayout(int i, int i2, int i3, int i4, int i5, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onActivityResized(int i, int i2, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onMinimized(Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(int i, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(String str, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onUnminimized(Bundle bundle) {
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void onWarmupCompleted(Bundle bundle) {
            }
        };
    }
}
