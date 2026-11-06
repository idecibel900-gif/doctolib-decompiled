package com.swmansion.gesturehandler.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public interface ViewConfigurationHelper {
    PointerEventsConfig getPointerEventsConfigForView(View view);

    boolean isViewClippingChildren(ViewGroup viewGroup);
}
