package com.teleport.portal;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.PortalViewManagerDelegate;
import com.facebook.react.viewmanagers.PortalViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.teleport.managers.TeleportViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = PortalViewManager.NAME)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0017R*\u0010\u0006\u001a\u001e\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00000\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/teleport/portal/PortalViewManager;", "Lcom/teleport/managers/TeleportViewManager;", "Lcom/facebook/react/viewmanagers/PortalViewManagerInterface;", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "delegate", "Lcom/facebook/react/viewmanagers/PortalViewManagerDelegate;", "kotlin.jvm.PlatformType", "getName", "", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createTeleportView", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "view", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "setName", "name", "setHostName", "Companion", "react-native-teleport_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PortalViewManager extends TeleportViewManager implements PortalViewManagerInterface {
    public static final String NAME = "PortalView";
    private final PortalViewManagerDelegate delegate = new PortalViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.PortalViewManagerInterface
    @ReactProp(name = "name")
    public void setName(ReactViewGroup view, String name) {
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.teleport.managers.TeleportViewManager
    protected ReactViewGroup createTeleportView(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PortalView(context);
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        PortalView portalView = view instanceof PortalView ? (PortalView) view : null;
        if (portalView != null) {
            portalView.cleanup();
        }
        super.onDropViewInstance(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactViewGroup view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        PortalView portalView = view instanceof PortalView ? (PortalView) view : null;
        if (portalView != null) {
            portalView.setStateWrapper(stateWrapper);
        }
        return super.updateState(view, props, stateWrapper);
    }

    @Override // com.facebook.react.viewmanagers.PortalViewManagerInterface
    @ReactProp(name = "hostName")
    public void setHostName(ReactViewGroup view, String name) {
        PortalView portalView = view instanceof PortalView ? (PortalView) view : null;
        if (portalView != null) {
            portalView.setHostName(name);
        }
    }
}
