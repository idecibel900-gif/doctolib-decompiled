package expo.modules.updates.procedures;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.common.LifecycleState;
import expo.modules.updates.UpdatesController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RestartReactAppExtensionsKt {
    public static final ReactHost resolveReactHostForRestart(Context context) {
        ReactHost reactHost;
        Intrinsics.checkNotNullParameter(context, "context");
        Object applicationContext = context.getApplicationContext();
        ReactApplication reactApplication = applicationContext instanceof ReactApplication ? (ReactApplication) applicationContext : null;
        return (reactApplication == null || (reactHost = reactApplication.getReactHost()) == null) ? (ReactHost) UpdatesController.getInstance().getReactHost().get() : reactHost;
    }

    public static final void restart(ReactHost reactHost, Activity activity, String reason) {
        Intrinsics.checkNotNullParameter(reactHost, "<this>");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (reactHost.getLifecycleState() != LifecycleState.RESUMED && activity != null) {
            reactHost.onHostResume(activity);
        }
        reactHost.reload(reason);
    }
}
