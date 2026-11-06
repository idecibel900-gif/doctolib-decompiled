package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidProgressBarManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAnimating(View view, boolean z);

    void setColor(View view, Integer num);

    void setIndeterminate(View view, boolean z);

    void setProgress(View view, double d);

    void setStyleAttr(View view, String str);

    void setTestID(View view, String str);

    void setTypeAttr(View view, String str);
}
