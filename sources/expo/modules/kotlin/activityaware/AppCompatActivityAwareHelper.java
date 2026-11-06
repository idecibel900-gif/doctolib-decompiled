package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AppCompatActivityAwareHelper implements AppCompatActivityAware {
    private final CopyOnWriteArrayList listeners = new CopyOnWriteArrayList();
    private WeakReference activityReference = new WeakReference(null);

    public final void dispatchOnActivityAvailable(final AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference(activity);
        activity.runOnUiThread(new Runnable() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AppCompatActivityAwareHelper.dispatchOnActivityAvailable$lambda$0(this.f$0, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchOnActivityAvailable$lambda$0(AppCompatActivityAwareHelper appCompatActivityAwareHelper, AppCompatActivity appCompatActivity) {
        Iterator it = appCompatActivityAwareHelper.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((OnActivityAvailableListener) it.next()).onActivityAvailable(appCompatActivity);
        }
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void addOnActivityAvailableListener(final OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        final AppCompatActivity appCompatActivity = (AppCompatActivity) this.activityReference.get();
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new Runnable() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    listener.onActivityAvailable(appCompatActivity);
                }
            });
        }
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void removeOnActivityAvailableListener(OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
