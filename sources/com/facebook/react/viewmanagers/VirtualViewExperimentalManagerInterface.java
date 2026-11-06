package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface VirtualViewExperimentalManagerInterface extends ViewManagerWithGeneratedInterface {
    void setInitialHidden(View view, boolean z);

    void setRemoveClippedSubviews(View view, boolean z);

    void setRenderState(View view, int i);
}
