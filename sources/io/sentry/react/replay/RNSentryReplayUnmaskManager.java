package io.sentry.react.replay;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.viewmanagers.RNSentryReplayUnmaskManagerDelegate;

/* JADX INFO: loaded from: classes5.dex */
@ReactModule(name = "RNSentryReplayUnmask")
public class RNSentryReplayUnmaskManager extends ViewGroupManager<RNSentryReplayUnmask> implements ViewManagerWithGeneratedInterface {
    private final RNSentryReplayUnmaskManagerDelegate delegate = new RNSentryReplayUnmaskManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    /* JADX INFO: renamed from: getDelegate */
    public ViewManagerDelegate getMDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSentryReplayUnmask";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNSentryReplayUnmask createViewInstance(ThemedReactContext themedReactContext) {
        return new RNSentryReplayUnmask(themedReactContext);
    }
}
