package com.reactnativekeyboardcontroller.interactive;

/* JADX INFO: loaded from: classes4.dex */
public final class InteractiveKeyboardProvider {
    public static final InteractiveKeyboardProvider INSTANCE = new InteractiveKeyboardProvider();
    private static boolean isInteractive;

    private InteractiveKeyboardProvider() {
    }

    public final boolean isInteractive() {
        return isInteractive;
    }

    public final void setInteractive(boolean z) {
        isInteractive = z;
    }
}
