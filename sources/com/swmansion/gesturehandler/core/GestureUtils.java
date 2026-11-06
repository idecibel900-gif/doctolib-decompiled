package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class GestureUtils {
    public static final GestureUtils INSTANCE = new GestureUtils();

    private GestureUtils() {
    }

    public final float getLastPointerX(MotionEvent event, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (z) {
            int pointerCount = event.getPointerCount();
            float x = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    x += event.getX(i2);
                    i++;
                }
            }
            return x / i;
        }
        int pointerCount2 = event.getPointerCount();
        int i3 = pointerCount2 - 1;
        if (i3 == actionIndex) {
            i3 = pointerCount2 - 2;
        }
        return event.getX(i3);
    }

    public final float getLastPointerY(MotionEvent event, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (z) {
            int pointerCount = event.getPointerCount();
            float y = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    y += event.getY(i2);
                    i++;
                }
            }
            return y / i;
        }
        int pointerCount2 = event.getPointerCount();
        int i3 = pointerCount2 - 1;
        if (i3 == actionIndex) {
            i3 = pointerCount2 - 2;
        }
        return event.getY(i3);
    }

    public final double coneToDeviation(double d) {
        return Math.cos(Math.toRadians(d / 2.0d));
    }
}
