package expo.modules.keepawake;

import android.app.Activity;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoKeepAwakeManager {
    private final AppContext appContext;
    private final Set tags = new LinkedHashSet();

    public ExpoKeepAwakeManager(AppContext appContext) {
        this.appContext = appContext;
    }

    private final Activity getCurrentActivity() throws Exceptions$AppContextLost {
        AppContext appContext = this.appContext;
        if (appContext != null) {
            return appContext.getThrowingActivity();
        }
        throw new Exceptions$AppContextLost();
    }

    public final boolean isActivated() {
        return !this.tags.isEmpty();
    }

    public final void activate(String tag) throws Exceptions$AppContextLost {
        Intrinsics.checkNotNullParameter(tag, "tag");
        final Activity currentActivity = getCurrentActivity();
        if (!isActivated()) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.activate$lambda$0(currentActivity);
                }
            });
        }
        this.tags.add(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activate$lambda$0(Activity activity) {
        activity.getWindow().addFlags(128);
    }

    public final void deactivate(String tag) throws Exceptions$AppContextLost {
        Intrinsics.checkNotNullParameter(tag, "tag");
        final Activity currentActivity = getCurrentActivity();
        if (this.tags.size() == 1 && this.tags.contains(tag)) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.deactivate$lambda$1(currentActivity);
                }
            });
        }
        this.tags.remove(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deactivate$lambda$1(Activity activity) {
        activity.getWindow().clearFlags(128);
    }
}
