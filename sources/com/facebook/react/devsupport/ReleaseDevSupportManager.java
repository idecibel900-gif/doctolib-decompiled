package com.facebook.react.devsupport;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ReleaseDevSupportManager implements DevSupportManager {
    private final JSExceptionHandler defaultJSExceptionHandler = new DefaultJSExceptionHandler();

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void addCustomDevOption(String optionName, DevOptionHandler optionHandler) {
        Intrinsics.checkNotNullParameter(optionName, "optionName");
        Intrinsics.checkNotNullParameter(optionHandler, "optionHandler");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public View createRootView(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public SurfaceDelegate createSurfaceDelegate(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void destroyRootView(View view) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public Activity getCurrentActivity() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public ReactContext getCurrentReactContext() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings getDevSettings() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean getDevSupportEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getDownloadedJSBundleFile() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean getKeyboardShortcutsEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public StackFrame[] getLastErrorStack() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getLastErrorTitle() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public ErrorType getLastErrorType() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public RedBoxHandler getRedBoxHandler() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getSourceUrl() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void handleReloadJS() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean hasUpToDateJSBundleInCache() {
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hidePausedInDebuggerOverlay() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hideRedboxDialog() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onNewReactContextCreated(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onReactInstanceDestroyed(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void openDebugger(String str) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public Pair processErrorCustomizers(Pair errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        return errorInfo;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setDevSupportEnabled(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setFpsDebugEnabled(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setHotModuleReplacementEnabled(boolean z) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showDevOptionsDialog() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showPausedInDebuggerOverlay(String message, DevSupportManager.PausedInDebuggerOverlayCommandListener listener) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void startInspector() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void stopInspector() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void toggleElementInspector() {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void isPackagerRunning(PackagerStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onPackagerStatusFetched(false);
    }

    @Override // com.facebook.react.bridge.JSExceptionHandler
    public void handleException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.defaultJSExceptionHandler.handleException(e);
    }
}
