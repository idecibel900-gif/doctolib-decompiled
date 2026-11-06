package com.reactnativemenu;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.MenuViewManagerDelegate;
import com.facebook.react.viewmanagers.MenuViewManagerInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reactnativemenu/MenuViewManagerSpec;", "T", "Landroid/view/View;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/facebook/react/viewmanagers/MenuViewManagerInterface;", "<init>", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "react-native-menu_menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MenuViewManagerSpec<T extends View> extends SimpleViewManager<T> implements MenuViewManagerInterface {
    private final ViewManagerDelegate mDelegate = new MenuViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setActions(View view, ReadableArray readableArray);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setActionsHash(View view, String str);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setHitSlop(View view, ReadableMap readableMap);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setShouldOpenOnLongPress(View view, boolean z);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setThemeVariant(View view, String str);

    @Override // com.facebook.react.viewmanagers.MenuViewManagerInterface
    public abstract /* synthetic */ void setTitle(View view, String str);

    @Override // com.facebook.react.uimanager.ViewManager
    /* JADX INFO: renamed from: getDelegate, reason: from getter */
    protected ViewManagerDelegate getMDelegate() {
        return this.mDelegate;
    }
}
