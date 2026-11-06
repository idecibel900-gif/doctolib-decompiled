package com.facebook.react.views.virtual;

import android.graphics.Rect;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualViewModeChangeEventKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableMap toReadableMap(Rect rect) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        writableMapCreateMap.putDouble("x", pixelUtil.pxToDp(rect.left));
        writableMapCreateMap.putDouble("y", pixelUtil.pxToDp(rect.top));
        writableMapCreateMap.putDouble("width", pixelUtil.pxToDp(rect.width()));
        writableMapCreateMap.putDouble("height", pixelUtil.pxToDp(rect.height()));
        return writableMapCreateMap;
    }
}
