package com.reactnativekeyboardcontroller.listeners;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardAnimationCallbackConfig {
    private final int deferredInsetTypes;
    private final int dispatchMode;
    private boolean hasTranslucentNavigationBar;
    private final int persistentInsetTypes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardAnimationCallbackConfig)) {
            return false;
        }
        KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig = (KeyboardAnimationCallbackConfig) obj;
        return this.persistentInsetTypes == keyboardAnimationCallbackConfig.persistentInsetTypes && this.deferredInsetTypes == keyboardAnimationCallbackConfig.deferredInsetTypes && this.dispatchMode == keyboardAnimationCallbackConfig.dispatchMode && this.hasTranslucentNavigationBar == keyboardAnimationCallbackConfig.hasTranslucentNavigationBar;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.persistentInsetTypes) * 31) + Integer.hashCode(this.deferredInsetTypes)) * 31) + Integer.hashCode(this.dispatchMode)) * 31) + Boolean.hashCode(this.hasTranslucentNavigationBar);
    }

    public String toString() {
        return "KeyboardAnimationCallbackConfig(persistentInsetTypes=" + this.persistentInsetTypes + ", deferredInsetTypes=" + this.deferredInsetTypes + ", dispatchMode=" + this.dispatchMode + ", hasTranslucentNavigationBar=" + this.hasTranslucentNavigationBar + ")";
    }

    public KeyboardAnimationCallbackConfig(int i, int i2, int i3, boolean z) {
        this.persistentInsetTypes = i;
        this.deferredInsetTypes = i2;
        this.dispatchMode = i3;
        this.hasTranslucentNavigationBar = z;
    }

    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    public final int getDispatchMode() {
        return this.dispatchMode;
    }

    public final boolean getHasTranslucentNavigationBar() {
        return this.hasTranslucentNavigationBar;
    }

    public final void setHasTranslucentNavigationBar(boolean z) {
        this.hasTranslucentNavigationBar = z;
    }
}
