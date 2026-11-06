package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface RootView {
    void onChildEndedNativeGesture(View view, MotionEvent motionEvent);

    void onChildStartedNativeGesture(View view, MotionEvent motionEvent);
}
