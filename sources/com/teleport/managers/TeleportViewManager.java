package com.teleport.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H$J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0014¨\u0006\u000e"}, d2 = {"Lcom/teleport/managers/TeleportViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "<init>", "()V", "createTeleportView", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "forceBoxNone", "", "view", "createViewInstance", "prepareToRecycleView", "reactContext", "react-native-teleport_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TeleportViewManager extends ReactViewManager {
    protected abstract ReactViewGroup createTeleportView(ThemedReactContext context);

    public final void forceBoxNone(ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setPointerEvents(view, "box-none");
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ReactViewGroup reactViewGroupCreateTeleportView = createTeleportView(context);
        forceBoxNone(reactViewGroupCreateTeleportView);
        return reactViewGroupCreateTeleportView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup prepareToRecycleView(ThemedReactContext reactContext, ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.prepareToRecycleView(reactContext, view);
        forceBoxNone(view);
        return view;
    }
}
