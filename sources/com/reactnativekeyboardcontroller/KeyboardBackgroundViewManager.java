package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardBackgroundViewManagerImpl;
import com.reactnativekeyboardcontroller.views.background.KeyboardBackgroundViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardBackgroundViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "context", "Lcom/reactnativekeyboardcontroller/views/background/KeyboardBackgroundViewGroup;", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/reactnativekeyboardcontroller/views/background/KeyboardBackgroundViewGroup;", "Lcom/reactnativekeyboardcontroller/managers/KeyboardBackgroundViewManagerImpl;", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardBackgroundViewManagerImpl;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardBackgroundViewManager extends ReactViewManager implements ViewManagerWithGeneratedInterface {
    private final KeyboardBackgroundViewManagerImpl manager = new KeyboardBackgroundViewManagerImpl();

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "KeyboardBackgroundView";
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardBackgroundViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }
}
