package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface KeyboardControllerViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setEnabled(View view, boolean z);

    void setNavigationBarTranslucent(View view, boolean z);

    void setPreserveEdgeToEdge(View view, boolean z);

    void setStatusBarTranslucent(View view, boolean z);

    void synchronizeFocusedInputLayout(View view);
}
