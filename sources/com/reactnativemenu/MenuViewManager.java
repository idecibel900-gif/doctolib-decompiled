package com.reactnativemenu;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/reactnativemenu/MenuViewManager;", "Lcom/reactnativemenu/MenuViewManagerBase;", "<init>", "()V", "createViewInstance", "Lcom/reactnativemenu/MenuView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setBorderColor", "", "view", "Lcom/facebook/react/views/view/ReactViewGroup;", "index", "", "color", "(Lcom/facebook/react/views/view/ReactViewGroup;ILjava/lang/Integer;)V", "react-native-menu_menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuViewManager extends MenuViewManagerBase {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MenuView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new MenuView(reactContext);
    }

    @Override // com.reactnativemenu.MenuViewManagerBase
    public void setBorderColor(ReactViewGroup view, int index, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBorderColor(index, color);
    }
}
