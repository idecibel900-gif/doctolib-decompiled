package expo.modules.core.interfaces;

import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/* JADX INFO: loaded from: classes4.dex */
public interface ReactNativeHostHandler {
    default String getBundleAssetName(boolean z) {
        return null;
    }

    default String getJSBundleFile(boolean z) {
        return null;
    }

    default Boolean getUseDeveloperSupport() {
        return null;
    }

    default void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
    }

    default void onDidCreateReactHost(Context context, ReactHost reactHost) {
    }

    default void onDidCreateReactInstance(boolean z, ReactContext reactContext) {
    }

    void onReactInstanceException(boolean z, Exception exc);

    default void onWillCreateReactInstance(boolean z) {
    }
}
