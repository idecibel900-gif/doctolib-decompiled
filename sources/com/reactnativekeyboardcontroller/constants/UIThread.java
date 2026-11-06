package com.reactnativekeyboardcontroller.constants;

/* JADX INFO: loaded from: classes4.dex */
public final class UIThread {
    public static final UIThread INSTANCE = new UIThread();
    private static final long NEXT_FRAME = (long) Math.floor(16.666666666666668d);

    private UIThread() {
    }

    public final long getNEXT_FRAME() {
        return NEXT_FRAME;
    }
}
