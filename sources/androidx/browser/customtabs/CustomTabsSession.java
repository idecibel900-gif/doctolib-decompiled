package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsSession {
    private final ICustomTabsCallback mCallback;
    private final ComponentName mComponentName;
    private final PendingIntent mId;
    private final Object mLock = new Object();
    private final ICustomTabsService mService;

    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.mService = iCustomTabsService;
        this.mCallback = iCustomTabsCallback;
        this.mComponentName = componentName;
        this.mId = pendingIntent;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List list) {
        try {
            return this.mService.mayLaunchUrl(this.mCallback, uri, createBundleWithId(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    private Bundle createBundleWithId(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        addIdToBundle(bundle2);
        return bundle2;
    }

    private void addIdToBundle(Bundle bundle) {
        PendingIntent pendingIntent = this.mId;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    PendingIntent getId() {
        return this.mId;
    }
}
