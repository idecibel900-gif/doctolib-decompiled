package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.views.view.WindowUtilKt;
import com.facebook.systrace.Systrace;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ReactActivityDelegate {
    private final Activity mActivity;
    private final String mMainComponentName;
    private PermissionListener mPermissionListener;
    private Callback mPermissionsCallback;
    private ReactDelegate mReactDelegate;

    protected ReactRootView createRootView() {
        return null;
    }

    protected Bundle getLaunchOptions() {
        return null;
    }

    protected boolean isWideColorGamutEnabled() {
        return false;
    }

    @Deprecated
    public ReactActivityDelegate(Activity activity, String str) {
        this.mActivity = activity;
        this.mMainComponentName = str;
    }

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.mActivity = reactActivity;
        this.mMainComponentName = str;
    }

    protected Bundle composeLaunchOptions() {
        return getLaunchOptions();
    }

    @Deprecated
    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactNativeHost();
    }

    public ReactHost getReactHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactHost();
    }

    protected ReactDelegate getReactDelegate() {
        return this.mReactDelegate;
    }

    @Deprecated
    public ReactInstanceManager getReactInstanceManager() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.getReactInstanceManager();
    }

    public String getMainComponentName() {
        return this.mMainComponentName;
    }

    public void onCreate(Bundle bundle) {
        Systrace.traceSection(0L, "ReactActivityDelegate.onCreate::init", new Runnable() { // from class: com.facebook.react.ReactActivityDelegate$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        Window window;
        String mainComponentName = getMainComponentName();
        Bundle bundleComposeLaunchOptions = composeLaunchOptions();
        Activity activity = this.mActivity;
        if (activity != null && (window = activity.getWindow()) != null) {
            if (WindowUtilKt.isEdgeToEdgeFeatureFlagOn()) {
                WindowUtilKt.enableEdgeToEdge(window);
            }
            if (Build.VERSION.SDK_INT >= 26 && isWideColorGamutEnabled()) {
                window.setColorMode(1);
            }
        }
        if (ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture()) {
            this.mReactDelegate = new ReactDelegate(getPlainActivity(), getReactHost(), mainComponentName, bundleComposeLaunchOptions);
        } else {
            this.mReactDelegate = new ReactDelegate(getPlainActivity(), getReactNativeHost(), mainComponentName, bundleComposeLaunchOptions, isFabricEnabled()) { // from class: com.facebook.react.ReactActivityDelegate.1
                @Override // com.facebook.react.ReactDelegate
                protected ReactRootView createRootView() {
                    ReactRootView reactRootViewCreateRootView = ReactActivityDelegate.this.createRootView();
                    return reactRootViewCreateRootView == null ? super.createRootView() : reactRootViewCreateRootView;
                }
            };
        }
        if (mainComponentName != null) {
            loadApp(mainComponentName);
        }
    }

    protected void loadApp(String str) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        Objects.requireNonNull(str);
        reactDelegate.loadApp(str);
        getPlainActivity().setContentView(this.mReactDelegate.getReactRootView());
    }

    public void setReactSurface(ReactSurface reactSurface) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.setReactSurface(reactSurface);
    }

    public void setReactRootView(ReactRootView reactRootView) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.setReactRootView(reactRootView);
    }

    public void onUserLeaveHint() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onUserLeaveHint();
    }

    public void onPause() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onHostPause();
    }

    public void onResume() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onHostResume();
        Callback callback = this.mPermissionsCallback;
        if (callback != null) {
            callback.invoke(new Object[0]);
            this.mPermissionsCallback = null;
        }
    }

    public void onDestroy() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onHostDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onActivityResult(i, i2, intent, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.shouldShowDevMenuOrReload(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.onKeyLongPress(i);
    }

    public boolean onBackPressed() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.onBackPressed();
    }

    public boolean onNewIntent(Intent intent) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        Objects.requireNonNull(intent);
        return reactDelegate.onNewIntent(intent);
    }

    public void onWindowFocusChanged(boolean z) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onWindowFocusChanged(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        reactDelegate.onConfigurationChanged(configuration);
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        getPlainActivity().requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        LifecycleState lifecycleState;
        Callback callback = new Callback() { // from class: com.facebook.react.ReactActivityDelegate$$ExternalSyntheticLambda1
            @Override // com.facebook.react.bridge.Callback
            public final void invoke(Object[] objArr) {
                this.f$0.lambda$onRequestPermissionsResult$1(i, strArr, iArr, objArr);
            }
        };
        if (isFabricEnabled()) {
            ReactHost reactHost = getReactHost();
            lifecycleState = reactHost != null ? reactHost.getLifecycleState() : LifecycleState.BEFORE_CREATE;
        } else {
            ReactNativeHost reactNativeHost = getReactNativeHost();
            if (!reactNativeHost.hasInstance()) {
                lifecycleState = LifecycleState.BEFORE_CREATE;
            } else {
                lifecycleState = reactNativeHost.getReactInstanceManager().getLifecycleState();
            }
        }
        if (lifecycleState == LifecycleState.RESUMED) {
            callback.invoke(new Object[0]);
        } else {
            this.mPermissionsCallback = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResult$1(int i, String[] strArr, int[] iArr, Object[] objArr) {
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener == null || !permissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
            return;
        }
        this.mPermissionListener = null;
    }

    protected Context getContext() {
        return (Context) Assertions.assertNotNull(this.mActivity);
    }

    protected Activity getPlainActivity() {
        return (Activity) getContext();
    }

    protected ReactActivity getReactActivity() {
        return (ReactActivity) getContext();
    }

    public ReactContext getCurrentReactContext() {
        ReactDelegate reactDelegate = this.mReactDelegate;
        Objects.requireNonNull(reactDelegate);
        return reactDelegate.getCurrentReactContext();
    }

    protected boolean isFabricEnabled() {
        return ReactNativeNewArchitectureFeatureFlags.enableFabricRenderer();
    }
}
