package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidSwitchManagerInterface extends ViewManagerWithGeneratedInterface {
    void setDisabled(View view, boolean z);

    void setEnabled(View view, boolean z);

    void setNativeValue(View view, boolean z);

    void setOn(View view, boolean z);

    void setThumbColor(View view, Integer num);

    void setThumbTintColor(View view, Integer num);

    void setTrackColorForFalse(View view, Integer num);

    void setTrackColorForTrue(View view, Integer num);

    void setTrackTintColor(View view, Integer num);

    void setValue(View view, boolean z);
}
