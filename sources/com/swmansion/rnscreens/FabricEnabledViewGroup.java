package com.swmansion.rnscreens;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FabricEnabledViewGroup extends ViewGroup {
    private float lastHeaderHeight;
    private float lastHeight;
    private float lastWidth;
    private StateWrapper mStateWrapper;

    public FabricEnabledViewGroup(ReactContext reactContext) {
        super(reactContext);
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    protected final void updateScreenSizeFabric(int i, int i2, int i3) {
        updateState(i, i2, i3);
    }

    public final void updateState(int i, int i2, int i3) {
        float dIPFromPixel = PixelUtil.toDIPFromPixel(i);
        float dIPFromPixel2 = PixelUtil.toDIPFromPixel(i2);
        float dIPFromPixel3 = PixelUtil.toDIPFromPixel(i3);
        if (Math.abs(this.lastWidth - dIPFromPixel) >= 0.9f || Math.abs(this.lastHeight - dIPFromPixel2) >= 0.9f || Math.abs(this.lastHeaderHeight - dIPFromPixel3) >= 0.9f) {
            this.lastWidth = dIPFromPixel;
            this.lastHeight = dIPFromPixel2;
            this.lastHeaderHeight = dIPFromPixel3;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("frameWidth", dIPFromPixel);
            writableNativeMap.putDouble("frameHeight", dIPFromPixel2);
            writableNativeMap.putDouble("contentOffsetX", 0.0d);
            writableNativeMap.putDouble("contentOffsetY", dIPFromPixel3);
            StateWrapper stateWrapper = this.mStateWrapper;
            if (stateWrapper != null) {
                stateWrapper.updateState(writableNativeMap);
            }
        }
    }
}
