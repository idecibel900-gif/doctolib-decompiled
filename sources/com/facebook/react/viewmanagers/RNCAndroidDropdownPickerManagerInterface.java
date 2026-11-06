package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNCAndroidDropdownPickerManagerInterface extends ViewManagerWithGeneratedInterface {
    void blur(View view);

    void focus(View view);

    void setColor(View view, Integer num);

    void setDropdownIconColor(View view, int i);

    void setDropdownIconRippleColor(View view, int i);

    void setEnabled(View view, boolean z);

    void setItems(View view, ReadableArray readableArray);

    void setNativeSelected(View view, int i);

    void setNumberOfLines(View view, int i);

    void setPrompt(View view, String str);

    void setSelected(View view, int i);
}
