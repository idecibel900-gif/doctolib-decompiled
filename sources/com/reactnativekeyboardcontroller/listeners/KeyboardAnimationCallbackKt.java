package com.reactnativekeyboardcontroller.listeners;

import com.reactnativekeyboardcontroller.constants.Keyboard;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyboardAnimationCallbackKt {
    private static final String TAG = Reflection.getOrCreateKotlinClass(KeyboardAnimationCallback.class).getQualifiedName();
    private static final boolean isResizeHandledInCallbackMethods = Keyboard.INSTANCE.getIS_ANIMATION_EMULATED();
}
