package com.teleport.host;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.PortalHostViewManagerDelegate;
import com.facebook.react.viewmanagers.PortalHostViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.teleport.managers.TeleportViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = PortalHostViewManager.NAME)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0017R*\u0010\u0006\u001a\u001e\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00000\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/teleport/host/PortalHostViewManager;", "Lcom/teleport/managers/TeleportViewManager;", "Lcom/facebook/react/viewmanagers/PortalHostViewManagerInterface;", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "delegate", "Lcom/facebook/react/viewmanagers/PortalHostViewManagerDelegate;", "kotlin.jvm.PlatformType", "getName", "", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createTeleportView", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "view", "setName", "name", "Companion", "react-native-teleport_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PortalHostViewManager extends TeleportViewManager implements PortalHostViewManagerInterface {
    public static final String NAME = "PortalHostView";
    private final PortalHostViewManagerDelegate delegate = new PortalHostViewManagerDelegate(this);

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
        return new PortalHostView(context);
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance(view);
        PortalHostView portalHostView = view instanceof PortalHostView ? (PortalHostView) view : null;
        if (portalHostView != null) {
            portalHostView.cleanup(((PortalHostView) view).getId());
        }
    }

    @Override // com.facebook.react.viewmanagers.PortalHostViewManagerInterface
    @ReactProp(name = "name")
    public void setName(ReactViewGroup view, String name) {
        PortalHostView portalHostView = view instanceof PortalHostView ? (PortalHostView) view : null;
        if (portalHostView != null) {
            portalHostView.setName(name);
        }
    }
}
