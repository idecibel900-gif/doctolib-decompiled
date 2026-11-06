package com.reactnativecommunity.picker;

import android.content.Context;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FabricEnabledPicker extends AppCompatSpinner {
    private StateWrapper mStateWrapper;

    public StateWrapper getStateWrapper() {
        return this.mStateWrapper;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    protected void setMeasuredHeight(int i) {
        updateState(i);
    }

    void updateState(int i) {
        float dIPFromPixel = PixelUtil.toDIPFromPixel(i);
        ReadableNativeMap stateData = this.mStateWrapper.getStateData();
        if (stateData != null) {
            if (Math.abs((stateData.hasKey("measuredHeight") ? stateData.getInt("measuredHeight") : 1.0f) - dIPFromPixel) < 0.9d) {
                return;
            }
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("measuredHeight", dIPFromPixel);
        this.mStateWrapper.updateState(writableNativeMap);
    }

    public FabricEnabledPicker(Context context) {
        super(context);
        this.mStateWrapper = null;
    }

    public FabricEnabledPicker(Context context, int i) {
        super(context, i);
        this.mStateWrapper = null;
    }
}
