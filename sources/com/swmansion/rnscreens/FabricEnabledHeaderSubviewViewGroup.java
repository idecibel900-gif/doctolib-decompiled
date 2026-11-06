package com.swmansion.rnscreens;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FabricEnabledHeaderSubviewViewGroup extends ViewGroup {
    public static final Companion Companion = new Companion(null);
    private float lastHeight;
    private float lastOffsetX;
    private float lastOffsetY;
    private float lastWidth;
    private StateWrapper mStateWrapper;

    public FabricEnabledHeaderSubviewViewGroup(Context context) {
        super(context);
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    protected final void updateSubviewFrameState(int i, int i2, int i3, int i4) {
        updateState(i, i2, i3, i4);
    }

    public final void updateState(int i, int i2, int i3, int i4) {
        float dIPFromPixel = PixelUtil.toDIPFromPixel(i);
        float dIPFromPixel2 = PixelUtil.toDIPFromPixel(i2);
        float dIPFromPixel3 = PixelUtil.toDIPFromPixel(i3);
        float dIPFromPixel4 = PixelUtil.toDIPFromPixel(i4);
        if (Math.abs(this.lastWidth - dIPFromPixel) >= 0.9f || Math.abs(this.lastHeight - dIPFromPixel2) >= 0.9f || Math.abs(this.lastOffsetX - dIPFromPixel3) >= 0.9f || Math.abs(this.lastOffsetY - dIPFromPixel4) >= 0.9f) {
            this.lastWidth = dIPFromPixel;
            this.lastHeight = dIPFromPixel2;
            this.lastOffsetX = dIPFromPixel3;
            this.lastOffsetY = dIPFromPixel4;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("frameWidth", dIPFromPixel);
            writableNativeMap.putDouble("frameHeight", dIPFromPixel2);
            writableNativeMap.putDouble("contentOffsetX", dIPFromPixel3);
            writableNativeMap.putDouble("contentOffsetY", dIPFromPixel4);
            StateWrapper stateWrapper = this.mStateWrapper;
            if (stateWrapper != null) {
                stateWrapper.updateState(writableNativeMap);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
