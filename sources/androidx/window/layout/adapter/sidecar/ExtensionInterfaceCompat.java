package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import androidx.window.layout.WindowLayoutInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ExtensionInterfaceCompat {

    public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo);
    }

    void onWindowLayoutChangeListenerAdded(Activity activity);

    void onWindowLayoutChangeListenerRemoved(Activity activity);

    void setExtensionCallback(ExtensionCallbackInterface extensionCallbackInterface);
}
