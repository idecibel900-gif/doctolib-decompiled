package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface MenuViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setActions(View view, ReadableArray readableArray);

    void setActionsHash(View view, String str);

    void setHitSlop(View view, ReadableMap readableMap);

    void setShouldOpenOnLongPress(View view, boolean z);

    void setThemeVariant(View view, String str);

    void setTitle(View view, String str);
}
