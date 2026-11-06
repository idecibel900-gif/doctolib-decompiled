package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface KeyboardGestureAreaManagerInterface extends ViewManagerWithGeneratedInterface {
    void setEnableSwipeToDismiss(View view, boolean z);

    void setInterpolator(View view, String str);

    void setOffset(View view, double d);

    void setShowOnSwipeUp(View view, boolean z);

    void setTextInputNativeID(View view, String str);
}
