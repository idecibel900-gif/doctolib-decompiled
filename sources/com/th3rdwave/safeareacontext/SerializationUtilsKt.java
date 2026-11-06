package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SerializationUtilsKt {
    public static final WritableMap edgeInsetsToJsMap(EdgeInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("top", PixelUtil.toDIPFromPixel(insets.getTop()));
        writableMapCreateMap.putDouble("right", PixelUtil.toDIPFromPixel(insets.getRight()));
        writableMapCreateMap.putDouble("bottom", PixelUtil.toDIPFromPixel(insets.getBottom()));
        writableMapCreateMap.putDouble("left", PixelUtil.toDIPFromPixel(insets.getLeft()));
        return writableMapCreateMap;
    }

    public static final Map edgeInsetsToJavaMap(EdgeInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return MapsKt.mapOf(TuplesKt.to("top", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getTop()))), TuplesKt.to("right", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getRight()))), TuplesKt.to("bottom", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getBottom()))), TuplesKt.to("left", Float.valueOf(PixelUtil.toDIPFromPixel(insets.getLeft()))));
    }

    public static final WritableMap rectToJsMap(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("x", PixelUtil.toDIPFromPixel(rect.getX()));
        writableMapCreateMap.putDouble("y", PixelUtil.toDIPFromPixel(rect.getY()));
        writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(rect.getWidth()));
        writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(rect.getHeight()));
        return writableMapCreateMap;
    }

    public static final Map rectToJavaMap(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return MapsKt.mapOf(TuplesKt.to("x", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getX()))), TuplesKt.to("y", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getY()))), TuplesKt.to("width", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getWidth()))), TuplesKt.to("height", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getHeight()))));
    }
}
