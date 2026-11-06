package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes4.dex */
public interface OnTouchEventListener {
    void onHandlerUpdate(GestureHandler gestureHandler, MotionEvent motionEvent);

    void onStateChange(GestureHandler gestureHandler, int i, int i2);

    void onTouchEvent(GestureHandler gestureHandler);
}
