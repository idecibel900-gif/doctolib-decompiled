package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.systrace.Systrace;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TouchesHelper {
    public static final TouchesHelper INSTANCE = new TouchesHelper();
    public static final String TARGET_KEY = "target";

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchEventType.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchEventType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TouchesHelper() {
    }

    private final WritableMap[] createPointersArray(TouchEvent touchEvent) {
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableMap[] writableMapArr = new WritableMap[motionEvent.getPointerCount()];
        float x = motionEvent.getX() - touchEvent.getViewX();
        float y = motionEvent.getY() - touchEvent.getViewY();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            PixelUtil pixelUtil = PixelUtil.INSTANCE;
            writableMapCreateMap.putDouble("pageX", pixelUtil.pxToDp(motionEvent.getX(i)));
            writableMapCreateMap.putDouble("pageY", pixelUtil.pxToDp(motionEvent.getY(i)));
            float x2 = motionEvent.getX(i) - x;
            float y2 = motionEvent.getY(i) - y;
            writableMapCreateMap.putDouble("locationX", pixelUtil.pxToDp(x2));
            writableMapCreateMap.putDouble("locationY", pixelUtil.pxToDp(y2));
            writableMapCreateMap.putInt("targetSurface", touchEvent.getSurfaceId());
            writableMapCreateMap.putInt(TARGET_KEY, touchEvent.getViewTag());
            writableMapCreateMap.putDouble(DiagnosticsEntry.TIMESTAMP_KEY, touchEvent.getTimestampMs());
            writableMapCreateMap.putDouble("identifier", motionEvent.getPointerId(i));
            writableMapArr[i] = writableMapCreateMap;
        }
        return writableMapArr;
    }

    public static final void sendTouchesLegacy(RCTEventEmitter rctEventEmitter, TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        TouchEventType touchEventType = touchEvent.getTouchEventType();
        TouchesHelper touchesHelper = INSTANCE;
        WritableArray writableArray = touchesHelper.getWritableArray(false, touchesHelper.createPointersArray(touchEvent));
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                writableArrayCreateArray.pushInt(i);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            writableArrayCreateArray.pushInt(motionEvent.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: " + touchEventType);
        }
        rctEventEmitter.receiveTouches(TouchEventType.Companion.getJSEventName(touchEventType), writableArray, writableArrayCreateArray);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a1 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x002d, B:11:0x0051, B:31:0x0097, B:32:0x009b, B:34:0x00a1, B:36:0x00a9, B:38:0x00c4, B:14:0x0059, B:15:0x005e, B:16:0x005f, B:17:0x0062, B:19:0x0065, B:21:0x0069, B:23:0x006f, B:25:0x0076, B:26:0x0083, B:28:0x008b, B:30:0x0091), top: B:44:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x002d, B:11:0x0051, B:31:0x0097, B:32:0x009b, B:34:0x00a1, B:36:0x00a9, B:38:0x00c4, B:14:0x0059, B:15:0x005e, B:16:0x005f, B:17:0x0062, B:19:0x0065, B:21:0x0069, B:23:0x006f, B:25:0x0076, B:26:0x0083, B:28:0x008b, B:30:0x0091), top: B:44:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    public static final void sendTouchEvent(RCTModernEventEmitter rCTModernEventEmitter, TouchEvent event) {
        WritableMap[] writableMapArr;
        WritableMap[] writableMapArr2;
        Iterator it;
        WritableMap writableMap;
        WritableMap writableMap2;
        RCTModernEventEmitter eventEmitter = rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        Intrinsics.checkNotNullParameter(event, "event");
        Systrace.beginSection(0L, "TouchesHelper.sentTouchEventModern(" + event.getEventName() + ")");
        try {
            TouchEventType touchEventType = event.getTouchEventType();
            MotionEvent motionEvent = event.getMotionEvent();
            WritableMap[] writableMapArrCreatePointersArray = INSTANCE.createPointersArray(event);
            int i = WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
            if (i == 1) {
                WritableMap writableMap3 = writableMapArrCreatePointersArray[motionEvent.getActionIndex()];
                writableMapArr = new WritableMap[]{writableMap3 != null ? writableMap3.copy() : null};
            } else if (i == 2) {
                int actionIndex = motionEvent.getActionIndex();
                WritableMap writableMap4 = writableMapArrCreatePointersArray[actionIndex];
                writableMapArrCreatePointersArray[actionIndex] = null;
                writableMapArr = new WritableMap[]{writableMap4};
            } else {
                if (i == 3) {
                    writableMapArr = new WritableMap[writableMapArrCreatePointersArray.length];
                    for (int i2 = 0; i2 < writableMapArrCreatePointersArray.length; i2++) {
                        WritableMap writableMap5 = writableMapArrCreatePointersArray[i2];
                        writableMapArr[i2] = writableMap5 != null ? writableMap5.copy() : null;
                    }
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    writableMapArr2 = new WritableMap[0];
                    writableMapArr = writableMapArrCreatePointersArray;
                }
                it = ArrayIteratorKt.iterator(writableMapArr);
                while (it.hasNext()) {
                    writableMap = (WritableMap) it.next();
                    if (writableMap != null) {
                        WritableMap writableMapCopy = writableMap.copy();
                        TouchesHelper touchesHelper = INSTANCE;
                        WritableArray writableArray = touchesHelper.getWritableArray(true, writableMapArr);
                        WritableArray writableArray2 = touchesHelper.getWritableArray(true, writableMapArr2);
                        writableMapCopy.putArray("changedTouches", writableArray);
                        writableMapCopy.putArray("touches", writableArray2);
                        writableMap2 = writableMapCopy;
                    } else {
                        writableMap2 = null;
                    }
                    eventEmitter.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
                    eventEmitter = rCTModernEventEmitter;
                }
                Systrace.endSection(0L);
            }
            writableMapArr2 = writableMapArrCreatePointersArray;
            it = ArrayIteratorKt.iterator(writableMapArr);
            while (it.hasNext()) {
                writableMap = (WritableMap) it.next();
                if (writableMap != null) {
                    WritableMap writableMapCopy2 = writableMap.copy();
                    TouchesHelper touchesHelper2 = INSTANCE;
                    WritableArray writableArray3 = touchesHelper2.getWritableArray(true, writableMapArr);
                    WritableArray writableArray4 = touchesHelper2.getWritableArray(true, writableMapArr2);
                    writableMapCopy2.putArray("changedTouches", writableArray3);
                    writableMapCopy2.putArray("touches", writableArray4);
                    writableMap2 = writableMapCopy2;
                } else {
                    writableMap2 = null;
                }
                eventEmitter.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
                eventEmitter = rCTModernEventEmitter;
            }
            Systrace.endSection(0L);
        } catch (Throwable th) {
            Systrace.endSection(0L);
            throw th;
        }
    }

    private final WritableArray getWritableArray(boolean z, WritableMap[] writableMapArr) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (WritableMap writableMapCopy : writableMapArr) {
            if (writableMapCopy != null) {
                if (z) {
                    writableMapCopy = writableMapCopy.copy();
                }
                writableArrayCreateArray.pushMap(writableMapCopy);
            }
        }
        return writableArrayCreateArray;
    }
}
