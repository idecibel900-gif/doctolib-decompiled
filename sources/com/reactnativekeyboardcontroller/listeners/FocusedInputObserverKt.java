package com.reactnativekeyboardcontroller.listeners;

import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEventData;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FocusedInputObserverKt {
    private static final FocusedInputLayoutChangedEventData noFocusedInputEvent = new FocusedInputLayoutChangedEventData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -1, -1);

    public static final FocusedInputLayoutChangedEventData getNoFocusedInputEvent() {
        return noFocusedInputEvent;
    }
}
