package expo.modules.kotlin;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ReactLifecycleDelegate implements LifecycleEventListener, ActivityEventListener {
    private final WeakReference appContextHolder;

    public ReactLifecycleDelegate(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContextHolder = new WeakReference(appContext);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostResume$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostPause$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onUserLeaveHint(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onUserLeaveHint$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostDestroy$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onActivityResult$expo_modules_core_release(activity, i, i2, intent);
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onNewIntent$expo_modules_core_release(intent);
        }
    }
}
