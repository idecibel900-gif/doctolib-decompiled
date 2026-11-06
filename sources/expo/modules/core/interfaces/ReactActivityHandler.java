package expo.modules.core.interfaces;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactHost;

/* JADX INFO: loaded from: classes4.dex */
public interface ReactActivityHandler {

    public interface DelayLoadAppHandler {
        void whenReady(Runnable runnable);
    }

    default ViewGroup createReactRootViewContainer(Activity activity) {
        return null;
    }

    DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity reactActivity, ReactHost reactHost);

    default ReactActivityDelegate onDidCreateReactActivityDelegate(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        return null;
    }

    default void onDidCreateReactActivityDelegateNotification(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
    }

    default boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }
}
