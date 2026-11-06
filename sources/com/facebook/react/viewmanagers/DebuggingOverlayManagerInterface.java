package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface DebuggingOverlayManagerInterface extends ViewManagerWithGeneratedInterface {
    void clearElementsHighlights(View view);

    void highlightElements(View view, ReadableArray readableArray);

    void highlightTraceUpdates(View view, ReadableArray readableArray);
}
