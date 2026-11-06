package io.sentry.android.core;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class CurrentActivityHolder {
    private static final CurrentActivityHolder instance = new CurrentActivityHolder();
    private WeakReference currentActivity;

    private CurrentActivityHolder() {
    }

    public static CurrentActivityHolder getInstance() {
        return instance;
    }

    public Activity getActivity() {
        WeakReference weakReference = this.currentActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public void setActivity(Activity activity) {
        WeakReference weakReference = this.currentActivity;
        if (weakReference == null || weakReference.get() != activity) {
            this.currentActivity = new WeakReference(activity);
        }
    }

    public void clearActivity(Activity activity) {
        WeakReference weakReference = this.currentActivity;
        if (weakReference == null || weakReference.get() == activity) {
            this.currentActivity = null;
        }
    }
}
