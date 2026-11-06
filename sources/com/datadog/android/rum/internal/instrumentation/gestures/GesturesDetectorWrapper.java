package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GesturesDetectorWrapper {
    private final GestureDetectorCompat defaultGesturesDetector;
    private final GesturesListener gestureListener;

    public GesturesDetectorWrapper(GesturesListener gestureListener, GestureDetectorCompat defaultGesturesDetector) {
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
        Intrinsics.checkNotNullParameter(defaultGesturesDetector, "defaultGesturesDetector");
        this.gestureListener = gestureListener;
        this.defaultGesturesDetector = defaultGesturesDetector;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GesturesDetectorWrapper(Context context, GesturesListener gestureListener) {
        this(gestureListener, new GestureDetectorCompat(context, gestureListener));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
    }

    public final void onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.defaultGesturesDetector.onTouchEvent(event) && event.getActionMasked() == 1) {
            this.gestureListener.onUp(event);
        }
    }
}
