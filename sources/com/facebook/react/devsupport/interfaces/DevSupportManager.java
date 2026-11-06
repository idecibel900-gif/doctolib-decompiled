package com.facebook.react.devsupport.interfaces;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;

/* JADX INFO: loaded from: classes3.dex */
public interface DevSupportManager extends JSExceptionHandler {

    public interface PausedInDebuggerOverlayCommandListener {
        void onResume();
    }

    void addCustomDevOption(String str, DevOptionHandler devOptionHandler);

    View createRootView(String str);

    SurfaceDelegate createSurfaceDelegate(String str);

    void destroyRootView(View view);

    default String getBundleFilePath() {
        return null;
    }

    Activity getCurrentActivity();

    ReactContext getCurrentReactContext();

    DeveloperSettings getDevSettings();

    boolean getDevSupportEnabled();

    String getDownloadedJSBundleFile();

    boolean getKeyboardShortcutsEnabled();

    StackFrame[] getLastErrorStack();

    String getLastErrorTitle();

    ErrorType getLastErrorType();

    RedBoxHandler getRedBoxHandler();

    String getSourceUrl();

    void handleReloadJS();

    boolean hasUpToDateJSBundleInCache();

    void hidePausedInDebuggerOverlay();

    void hideRedboxDialog();

    void isPackagerRunning(PackagerStatusCallback packagerStatusCallback);

    void onNewReactContextCreated(ReactContext reactContext);

    void onReactInstanceDestroyed(ReactContext reactContext);

    void openDebugger(String str);

    Pair processErrorCustomizers(Pair pair);

    default void setBundleFilePath(String str) {
    }

    void setDevSupportEnabled(boolean z);

    void setFpsDebugEnabled(boolean z);

    void setHotModuleReplacementEnabled(boolean z);

    void showDevOptionsDialog();

    void showPausedInDebuggerOverlay(String str, PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener);

    void startInspector();

    void stopInspector();

    void toggleElementInspector();

    static /* synthetic */ void openDebugger$default(DevSupportManager devSupportManager, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDebugger");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        devSupportManager.openDebugger(str);
    }
}
