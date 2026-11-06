package expo.modules.updates.reloadscreen;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
public final class ReloadScreenManager {
    private WeakReference currentActivity;
    private ReloadScreenConfiguration currentConfiguration;
    private WeakReference currentReloadScreen;
    private boolean isShowing;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final ReactMarker.MarkerListener reloadListener = new ReactMarker.MarkerListener() { // from class: expo.modules.updates.reloadscreen.ReloadScreenManager$$ExternalSyntheticLambda0
        @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
        public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
            ReloadScreenManager.reloadListener$lambda$0(this.f$0, reactMarkerConstants, str, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reloadListener$lambda$0(ReloadScreenManager reloadScreenManager, ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name == ReactMarkerConstants.RUN_JS_BUNDLE_END && reloadScreenManager.isShowing) {
            BuildersKt__Builders_commonKt.launch$default(reloadScreenManager.scope, null, null, new ReloadScreenManager$reloadListener$1$1(reloadScreenManager, null), 3, null);
        }
    }

    public final void setConfiguration(ReloadScreenOptions reloadScreenOptions) {
        this.currentConfiguration = ReloadScreenConfiguration.Companion.fromOptions(reloadScreenOptions);
    }

    public final void show(Activity activity) {
        if (this.isShowing) {
            return;
        }
        ReactMarker.addListener(this.reloadListener);
        if (activity == null) {
            WeakReference weakReference = this.currentActivity;
            activity = weakReference != null ? (Activity) weakReference.get() : null;
        }
        if (activity == null) {
            return;
        }
        showReloadScreen(activity);
        this.isShowing = true;
    }

    public final void hide() {
        if (this.isShowing) {
            hideReloadScreen();
            this.isShowing = false;
        }
    }

    private final void showReloadScreen(Activity activity) {
        ReloadScreenConfiguration reloadScreenConfigurationFromOptions = this.currentConfiguration;
        if (reloadScreenConfigurationFromOptions == null) {
            reloadScreenConfigurationFromOptions = ReloadScreenConfiguration.Companion.fromOptions(null);
        }
        ReloadScreenView reloadScreenView = new ReloadScreenView(activity, null, 0, 6, null);
        reloadScreenView.updateConfiguration(reloadScreenConfigurationFromOptions);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.addView(reloadScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.currentReloadScreen = new WeakReference(reloadScreenView);
    }

    private final void hideReloadScreen() {
        final ReloadScreenView reloadScreenView;
        WeakReference weakReference = this.currentReloadScreen;
        if (weakReference == null || (reloadScreenView = (ReloadScreenView) weakReference.get()) == null) {
            return;
        }
        ReloadScreenConfiguration reloadScreenConfiguration = this.currentConfiguration;
        if (reloadScreenConfiguration != null && reloadScreenConfiguration.getFade()) {
            reloadScreenView.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: expo.modules.updates.reloadscreen.ReloadScreenManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.removeView(reloadScreenView);
                }
            }).start();
        } else {
            removeView(reloadScreenView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeView(ReloadScreenView reloadScreenView) {
        ViewParent parent = reloadScreenView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(reloadScreenView);
        }
        this.currentReloadScreen = null;
        ReactMarker.removeListener(this.reloadListener);
    }
}
