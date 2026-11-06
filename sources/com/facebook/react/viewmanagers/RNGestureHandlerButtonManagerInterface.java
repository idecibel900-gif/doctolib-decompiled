package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNGestureHandlerButtonManagerInterface extends ViewManagerWithGeneratedInterface {
    void setBorderColor(View view, Integer num);

    void setBorderStyle(View view, String str);

    void setBorderWidth(View view, float f);

    void setBorderless(View view, boolean z);

    void setEnabled(View view, boolean z);

    void setExclusive(View view, boolean z);

    void setForeground(View view, boolean z);

    void setPointerEvents(View view, String str);

    void setRippleColor(View view, Integer num);

    void setRippleRadius(View view, int i);

    void setTouchSoundDisabled(View view, boolean z);
}
