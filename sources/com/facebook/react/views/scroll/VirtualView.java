package com.facebook.react.views.scroll;

import android.graphics.Rect;
import com.facebook.react.views.virtual.VirtualViewMode;

/* JADX INFO: loaded from: classes3.dex */
public interface VirtualView {
    Rect getContainerRelativeRect();

    String getVirtualViewID();

    void onModeChange(VirtualViewMode virtualViewMode, Rect rect);
}
