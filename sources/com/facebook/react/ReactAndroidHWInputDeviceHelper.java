package com.facebook.react;

import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactAndroidHWInputDeviceHelper {
    private static final Companion Companion = new Companion(null);
    private static final Map KEY_EVENTS_ACTIONS = MapsKt.mapOf(TuplesKt.to(23, "select"), TuplesKt.to(66, "select"), TuplesKt.to(62, "select"), TuplesKt.to(85, "playPause"), TuplesKt.to(89, "rewind"), TuplesKt.to(90, "fastForward"), TuplesKt.to(86, "stop"), TuplesKt.to(87, "next"), TuplesKt.to(88, "previous"), TuplesKt.to(19, "up"), TuplesKt.to(22, "right"), TuplesKt.to(20, "down"), TuplesKt.to(21, "left"), TuplesKt.to(165, "info"), TuplesKt.to(82, "menu"), TuplesKt.to(166, "channelUp"), TuplesKt.to(167, "channelDown"));
    private int lastFocusedViewId = -1;

    public final void handleKeyEvent(KeyEvent ev, ReactContext context) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Intrinsics.checkNotNullParameter(context, "context");
        int keyCode = ev.getKeyCode();
        int action = ev.getAction();
        if (action == 1 || action == 0) {
            Map map = KEY_EVENTS_ACTIONS;
            if (map.containsKey(Integer.valueOf(keyCode))) {
                dispatchEvent(context, (String) map.get(Integer.valueOf(keyCode)), this.lastFocusedViewId, action);
            }
        }
    }

    public final void onFocusChanged(View newFocusedView, ReactContext context) {
        Intrinsics.checkNotNullParameter(newFocusedView, "newFocusedView");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.lastFocusedViewId == newFocusedView.getId()) {
            return;
        }
        int i = this.lastFocusedViewId;
        if (i != -1) {
            dispatchEvent$default(this, context, "blur", i, 0, 8, null);
        }
        this.lastFocusedViewId = newFocusedView.getId();
        dispatchEvent$default(this, context, "focus", newFocusedView.getId(), 0, 8, null);
    }

    public final void clearFocus(ReactContext context) {
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.lastFocusedViewId;
        if (i != -1) {
            reactAndroidHWInputDeviceHelper = this;
            dispatchEvent$default(reactAndroidHWInputDeviceHelper, context, "blur", i, 0, 8, null);
        } else {
            reactAndroidHWInputDeviceHelper = this;
        }
        reactAndroidHWInputDeviceHelper.lastFocusedViewId = -1;
    }

    static /* synthetic */ void dispatchEvent$default(ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper, ReactContext reactContext, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        reactAndroidHWInputDeviceHelper.dispatchEvent(reactContext, str, i, i2);
    }

    private final void dispatchEvent(ReactContext reactContext, String str, int i, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", str);
        writableNativeMap.putInt("eventKeyAction", i2);
        if (i != -1) {
            writableNativeMap.putInt("tag", i);
        }
        reactContext.emitDeviceEvent("onHWKeyEvent", writableNativeMap);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
