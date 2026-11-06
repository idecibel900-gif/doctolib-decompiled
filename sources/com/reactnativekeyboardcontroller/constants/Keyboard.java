package com.reactnativekeyboardcontroller.constants;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public final class Keyboard {
    public static final Keyboard INSTANCE = new Keyboard();
    private static final boolean IS_ANIMATION_EMULATED;

    private Keyboard() {
    }

    static {
        IS_ANIMATION_EMULATED = Build.VERSION.SDK_INT < 30;
    }

    public final boolean getIS_ANIMATION_EMULATED() {
        return IS_ANIMATION_EMULATED;
    }
}
