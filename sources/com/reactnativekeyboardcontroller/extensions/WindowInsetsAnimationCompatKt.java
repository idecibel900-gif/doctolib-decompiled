package com.reactnativekeyboardcontroller.extensions;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WindowInsetsAnimationCompatKt {
    public static final boolean isKeyboardAnimation(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "<this>");
        return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0;
    }
}
