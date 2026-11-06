package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactRoot {
    Bundle getAppProperties();

    int getHeightMeasureSpec();

    String getJSModuleName();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    AtomicInteger getState();

    String getSurfaceID();

    int getUIManagerType();

    int getWidthMeasureSpec();

    void onStage(int i);

    void runApplication();

    void setRootViewTag(int i);

    void setShouldLogContentAppeared(boolean z);
}
