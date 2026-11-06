package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenContentWrapper extends ReactViewGroup {
    private OnLayoutCallback delegate;

    public interface OnLayoutCallback {
        void onContentWrapperLayout(boolean z, int i, int i2, int i3, int i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenContentWrapper(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final OnLayoutCallback getDelegate$react_native_screens_release() {
        return this.delegate;
    }

    public final void setDelegate$react_native_screens_release(OnLayoutCallback onLayoutCallback) {
        this.delegate = onLayoutCallback;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        OnLayoutCallback onLayoutCallback = this.delegate;
        if (onLayoutCallback != null) {
            onLayoutCallback.onContentWrapperLayout(z, i, i2, i3, i4);
        }
    }
}
